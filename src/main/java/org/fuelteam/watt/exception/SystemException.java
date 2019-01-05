package org.fuelteam.watt.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.fuelteam.watt.exception.enums.ModuleEnum;
import org.fuelteam.watt.exception.enums.SeverityEnum;

import com.alibaba.fastjson.JSON;

public class SystemException extends BaseException {

    private static final long serialVersionUID = 61483967392077358L;

    private static final ModuleEnum SYSTEM = ModuleEnum.System;

    public SystemException(final String code, final String message, final SeverityEnum severity, Throwable cause) {
        super(SYSTEM, code, message, severity, cause);
    }

    public SystemException(final String code, final SeverityEnum severity, Throwable cause) {
        super(SYSTEM, code, null, severity, cause);
    }

    public SystemException(final String code, final String message, final SeverityEnum severity) {
        super(SYSTEM, code, message, severity);
    }

    public SystemException(final String code, final SeverityEnum severity) {
        super(SYSTEM, code, null, severity);
    }

    public SystemException(final String code, final String message) {
        super(SYSTEM, code, null, null);
    }

    public SystemException(final String message) {
        super(SYSTEM, null, message, null);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
