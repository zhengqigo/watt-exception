package org.fuelteam.watt.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.fuelteam.watt.exception.enums.ModuleEnum;
import org.fuelteam.watt.exception.enums.SeverityEnum;

import com.alibaba.fastjson.JSON;

public class BusinessException extends BaseException {

    private static final long serialVersionUID = -4011725163070471891L;

    private static final ModuleEnum BUSINESS = ModuleEnum.Business;

    public BusinessException(final String code, final String message, final SeverityEnum severity, Throwable cause) {
        super(BUSINESS, code, message, severity, cause);
    }

    public BusinessException(final String code, final SeverityEnum severity, Throwable cause) {
        super(BUSINESS, code, null, severity, cause);
    }

    public BusinessException(final String code, final String message, final SeverityEnum severity) {
        super(BUSINESS, code, message, severity);
    }

    public BusinessException(final String code, final SeverityEnum severity) {
        super(BUSINESS, code, null, severity);
    }

    public BusinessException(final String code, final String message) {
        super(BUSINESS, code, message, null);
    }

    public BusinessException(final String message) {
        super(BUSINESS, null, message, null);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
