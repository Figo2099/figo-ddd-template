FROM centos:7
RUN echo "ip_resolve=4" >> /etc/yum.conf
#安装 KonaJDK
COPY ./java-8-konajdk.rpm /java-8-konajdk.rpm
RUN yum update -y && yum install -y java-8-konajdk.rpm && yum install telnet -y


# 设置时区。这对于日志、调用链等功能能否在 TSF 控制台被检索到非常重要。
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone
ENV workdir /root/workspace/


# 下面的 jar 包可替换为您的 Spring Cloud 应用 jar 包，注意这个 jar 包要和您的 dockerfile 位于同一级目录
ENV jar XXX.jar
ENV jar1 opentelemetry-javaagent.jar
ENV jar2 femas-trace-opentelemetry.jar
COPY ./XXX/target/XXX-1.0.0-SNAPSHOT.jar ${workdir}/XXX.jar
COPY ${jar1} ${jar2} ${workdir}
WORKDIR ${workdir}
ENV home -Duser.home=/home


# JVM 监控组件要和您的 Dockerfile 位于同一级目录，并创建 JVM 监控数据采集目录
ENV agentjar TencentCloudJvmMonitor-1.3.1-RELEASE.jar
# 若容器的基础版本为 非 gnu-libc 版本，如 Alpine，请添加如下语句
# RUN ln -sf /lib/libc.musl-x86_64.so.1 /lib/ld-linux-x86-64.so.2
COPY ./TencentCloudJvmMonitor-1.3.1-RELEASE.jar ${workdir}


RUN mkdir -p /data/tsf_apm/monitor/jvm-metrics/
ARG APP_ENV
ENV RUNTIME_ENV=${APP_ENV}
EXPOSE 8722
# JAVA_OPTS 环境变量的值为部署组的 JVM 启动参数，在运行时 bash 替换。使用 exec 以使 Java 程序可以接收 SIGTERM 信号。
# 使用 JVM监控功能需要加上 gclog 和 javaagent 的配置, 否则将无法提供 jvm 监控能力
# 考虑到容器场景对于内存的要求，建议添加-Xshare:off选项关闭CDS功能
CMD ["sh", "-ec", "exec java ${home} -Xloggc:/data/tsf_apm/monitor/jvm-metrics/gclog.log -XX:+PrintGCDateStamps -XX:+PrintGCDetails -verbose:gc -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=8 -XX:GCLogFileSize=50M -javaagent:${workdir}/${agentjar}=hascontroller=true  -Xshare:off -javaagent:${workdir}/${jar1} -Dotel.javaagent.extensions=${workdir}/${jar2} -jar ${jar} --spring.profiles.active=${RUNTIME_ENV} ${JAVA_OPTS}"]
