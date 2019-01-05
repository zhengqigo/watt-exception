package org.fuelteam.watt.exception.enums;

public interface ExceptionEnum {

    ModuleEnum getModule();

    String getCode();

    String getMessage();

    SeverityEnum getSeverity();
}
