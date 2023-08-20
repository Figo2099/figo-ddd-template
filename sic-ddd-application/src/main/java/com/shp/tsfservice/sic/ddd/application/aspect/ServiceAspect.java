package com.shp.tsfservice.sic.ddd.application.aspect;

import com.shp.tsfservice.sic.component.dto.Response;
import com.shp.tsfservice.sic.component.exception.ServiceException;
import com.shp.tsfservice.sic.component.util.DsonUtil;
import com.shp.tsfservice.sic.ddd.common.exception.BusinessCheckException;
import com.shp.tsfservice.sic.ddd.common.enums.TemplateEcInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import java.lang.reflect.Field;

@Order(1)
@Component
@Aspect
@Slf4j
public class ServiceAspect implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    private static final int METHOD_TIMEOUT = 500;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Around(value = "execution(* com.shp.tsfservice.sic.ddd.io.interfaces.*.*(..))")
    public Object timeAroundMain(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> returnType = signature.getReturnType();
        Object[] args = joinPoint.getArgs();
        Object result = null;
        long startTime = System.currentTimeMillis();
        try {
            result = ((ProceedingJoinPoint) joinPoint).proceed();
        } catch (BusinessCheckException e) {
            log.warn("business check warn,methodName = {}, args = {}, clientIp = {}", methodName, args, e);
            result = processBusinessCheckException(e, returnType);
        } catch (Exception e) {
            if (e instanceof ServiceException) {
                log.error("service error, methodName = {}, args = {}, clientIp = {}", methodName, args, e);
            } else if (e instanceof ValidationException) {
                log.error("service param error, methodName = {}, args = {}, clientIp = {}", methodName, args, e);
            } else {
                log.error("service unknown error, methodName = {}, args = {}, clientIp = {}", methodName, args, e);
            }
            throw e;
        } finally {
            long costTime = System.currentTimeMillis() - startTime;
            if (costTime > METHOD_TIMEOUT) {
                log.warn("service execution timeout, methodName = {}, args = {}, cost = {}", methodName, args, costTime);
            }
            log.info("service request response, methodName = {}, args = {}, result = {}, cost = {}", methodName, DsonUtil.toJSON(args), result, costTime);
        }
        return result;
    }

    private Object processBusinessCheckException(BusinessCheckException e, Class<?> returnType) throws Exception {
        TemplateEcInfo portalEcInfo = e.getPortalEcInfo();
        if (Response.class.isAssignableFrom(returnType) || returnType.equals(Response.class)) {
            Response response = (Response) returnType.newInstance();
            Field ec = Response.class.getDeclaredField("ec");
            Field em = Response.class.getDeclaredField("em");
            ec.setAccessible(true);
            ec.set(response, portalEcInfo.getEc());
            em.setAccessible(true);
            em.set(response, StringUtils.isBlank(e.getMessage()) ? portalEcInfo.getEm() : e.getMessage());
            return response;
        }
        throw new ServiceException("throw BusinessCheckException,but method returnType not assignable from Response");
    }

}
