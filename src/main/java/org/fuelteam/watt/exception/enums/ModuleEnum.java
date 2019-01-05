package org.fuelteam.watt.exception.enums;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.fuelteam.watt.exception.util.StringUtil;

public enum ModuleEnum {

    // @formatter:off
    Business("business", "1"), System("system", "2"), Remote("remote", "3");
    // @formatter:on

    private ModuleEnum(final String code, final String name) {
        this.code = code;
        this.name = name;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static ModuleEnum getByCode(final String code) {
        if (StringUtil.isEmpty(code)) return null;
        for (ModuleEnum severity : values()) {
            if (severity.code.equals(code)) return severity;
        }
        return null;
    }

    public static ModuleEnum getByName(final String name) {
        if (StringUtil.isEmpty(name)) return null;
        for (ModuleEnum severity : values()) {
            if (severity.name.equals(name)) return severity;
        }
        return null;
    }

    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
