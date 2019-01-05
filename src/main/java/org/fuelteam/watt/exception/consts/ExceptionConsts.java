package org.fuelteam.watt.exception.consts;

public interface ExceptionConsts {

    public final static String Unknown = "unknown";

    public final static String Business = "business";

    public final static String System = "system";

    public final static String Remote = "remote";

    // manual = 1 if exception need manual fix, manual fixed = 2, no need = 0
    public final static short manual = 0;
}
