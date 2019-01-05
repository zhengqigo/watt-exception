package org.fuelteam.watt.exception.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil extends StringUtils {

    // 当参数为null或长度为零时返回""，否则返回trim后的字串
    public static String clean(final String clean) {
        return isEmpty(clean) ? "" : clean.trim();
    }

    // 当参数为null或长度为零时返回asdefault，否则返回trim后的字串
    public static String cleanas(final String clean, final String defVal) {
        return isEmpty(clean) ? clean(defVal) : clean.trim();
    }
}
