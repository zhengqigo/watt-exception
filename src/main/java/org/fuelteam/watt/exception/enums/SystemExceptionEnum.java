package org.fuelteam.watt.exception.enums;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.fuelteam.watt.exception.util.StringUtil;

public enum SystemExceptionEnum implements ExceptionEnum {

    // @formatter:off
    Error("Error", "error", SeverityEnum.Critical),
    NotyetSupported("NotyetSupported", "not yes supported", SeverityEnum.Critical);
    // @formatter:on

    private SystemExceptionEnum(final String code, final String message, final SeverityEnum severity) {
        this.code = code;
        this.message = message;
        this.severity = severity;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static SystemExceptionEnum getByCode(final String code) {
        if (StringUtil.isEmpty(code)) return null;
        for (SystemExceptionEnum exception : values()) {
            if (exception.code.equals(code)) return exception;
        }
        return null;
    }

    public static SystemExceptionEnum getByMessage(final String message) {
        if (StringUtil.isEmpty(message)) return null;
        for (SystemExceptionEnum exception : values()) {
            if (exception.message.equals(message)) return exception;
        }
        return null;
    }

    private ModuleEnum module = ModuleEnum.System;
    private String code;
    private String message;
    private SeverityEnum severity;

    public ModuleEnum getModule() {
        return module;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public SeverityEnum getSeverity() {
        return severity;
    }
}
