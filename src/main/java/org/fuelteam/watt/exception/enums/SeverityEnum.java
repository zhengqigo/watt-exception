package org.fuelteam.watt.exception.enums;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.fuelteam.watt.exception.util.StringUtil;

public enum SeverityEnum {

    // @formatter:off
    Critical("C1", "critical", 1), Middle("M2", "middle", 2), Slight("S3", "slight", 3);
    // @formatter:on

    private SeverityEnum(final String code, final String name, final int value) {
        this.code = code;
        this.name = name;
        this.value = value;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static SeverityEnum getByCode(final String code) {
        if (StringUtil.isEmpty(code)) return null;
        for (SeverityEnum severity : values()) {
            if (severity.code.equals(code)) return severity;
        }
        return null;
    }

    public static SeverityEnum getByName(final String name) {
        if (StringUtil.isEmpty(name)) return null;
        for (SeverityEnum severity : values()) {
            if (severity.name.equals(name)) return severity;
        }
        return null;
    }

    public static SeverityEnum getByValue(final int value) {
        for (SeverityEnum severity : values()) {
            if (severity.value == value) return severity;
        }
        return null;
    }

    private String code;

    private String name;

    private int value;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
