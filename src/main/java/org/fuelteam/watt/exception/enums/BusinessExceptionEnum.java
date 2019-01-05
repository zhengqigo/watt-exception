package org.fuelteam.watt.exception.enums;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

public enum BusinessExceptionEnum implements ExceptionEnum {

    // @formatter:off
    Error("Error", "error", SeverityEnum.Critical),
    NotyetImplemented("NotyetImplemented", "not yet implemented", SeverityEnum.Critical);
    // @formatter:on

    private BusinessExceptionEnum(final String code, final String message, final SeverityEnum severity) {
        this.code = code;
        this.message = message;
        this.severity = severity;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static BusinessExceptionEnum getByCode(final String code) {
        if (StringUtils.isEmpty(code)) return null;
        for (BusinessExceptionEnum exception : values()) {
            if (exception.code.equals(code)) return exception;
        }
        return null;
    }

    public static BusinessExceptionEnum getByMessage(final String message) {
        if (StringUtils.isEmpty(message)) return null;
        for (BusinessExceptionEnum exception : values()) {
            if (exception.message.equals(message)) return exception;
        }
        return null;
    }

    private ModuleEnum module = ModuleEnum.Business;
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
