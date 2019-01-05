package org.fuelteam.watt.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.fuelteam.watt.exception.consts.ExceptionConsts;
import org.fuelteam.watt.exception.enums.ModuleEnum;
import org.fuelteam.watt.exception.enums.SeverityEnum;
import org.fuelteam.watt.exception.util.StringUtil;

public abstract class BaseException extends Exception {

    private static final long serialVersionUID = -8943623760552019394L;

    private ModuleEnum module = ModuleEnum.System;

    private String code = ExceptionConsts.Unknown;

    private String message = ExceptionConsts.Unknown;

    private SeverityEnum severity = SeverityEnum.Slight;

    private boolean handled = false;

    public BaseException() {
        super();
    }

    public BaseException(final ModuleEnum module, final String code, final String message, final SeverityEnum severity,
            Throwable cause) {
        super(cause);
        this.setModule(module);
        this.setCode(StringUtil.cleanas(code, ExceptionConsts.Unknown));
        this.setMessage(StringUtil.cleanas(message, ExceptionConsts.Unknown));
        if (severity != null) this.setSeverity(severity);
    }

    public BaseException(final ModuleEnum module, final String code, final String message,
            final SeverityEnum severity) {
        super();
        this.setModule(module);
        this.setCode(StringUtil.cleanas(code, ExceptionConsts.Unknown));
        this.setMessage(StringUtil.cleanas(message, ExceptionConsts.Unknown));
        if (severity != null) this.setSeverity(severity);
    }

    public BaseException(final String code, final String message, final SeverityEnum severity) {
        super();
        this.setCode(StringUtil.cleanas(code, ExceptionConsts.Unknown));
        this.setMessage(StringUtil.cleanas(message, ExceptionConsts.Unknown));
        if (severity != null) this.setSeverity(severity);
    }

    public BaseException(final String code, final SeverityEnum severity) {
        super();
        this.setCode(StringUtil.cleanas(code, ExceptionConsts.Unknown));
        if (severity != null) this.setSeverity(severity);
    }

    public BaseException(final String code, final String message) {
        super();
        this.setCode(StringUtil.cleanas(code, ExceptionConsts.Unknown));
        this.setMessage(StringUtil.cleanas(message, ExceptionConsts.Unknown));
    }

    public BaseException(final String message) {
        super();
        this.setMessage(StringUtil.cleanas(message, ExceptionConsts.Unknown));
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SeverityEnum getSeverity() {
        return severity;
    }

    public void setSeverity(SeverityEnum severity) {
        this.severity = severity;
    }

    public ModuleEnum getModule() {
        return module;
    }

    public void setModule(ModuleEnum module) {
        this.module = module;
    }

    public boolean isHandled() {
        return handled;
    }

    public void setHandled(boolean handled) {
        this.handled = handled;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
