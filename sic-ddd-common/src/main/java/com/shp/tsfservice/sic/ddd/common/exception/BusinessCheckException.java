package com.shp.tsfservice.sic.ddd.common.exception;

import com.shp.tsfservice.sic.ddd.common.enums.TemplateEcInfo;
import lombok.Getter;
import lombok.ToString;

/**
 * 业务异常，最上层统一设置ec、em
 */
@ToString
public class BusinessCheckException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Getter
	private TemplateEcInfo portalEcInfo;

	@Getter
	private String message;

	public BusinessCheckException(TemplateEcInfo portalEcInfo) {
		super(portalEcInfo.toString());
		this.portalEcInfo = portalEcInfo;
	}

	public BusinessCheckException(TemplateEcInfo ecInfo, String detail) {
		super(ecInfo.toString() + "|detail:" + detail);
		this.portalEcInfo = ecInfo;
		this.message = detail;
	}

}
