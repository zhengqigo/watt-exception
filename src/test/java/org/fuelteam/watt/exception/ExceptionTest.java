package org.fuelteam.watt.exception;

import org.fuelteam.watt.exception.enums.SeverityEnum;

public class ExceptionTest {

    public static void main(String[] agrs) throws BaseException {
        BaseException sysex = new BusinessException("999999", "系统异常，请稍后重试。", SeverityEnum.Critical);
        throw sysex;
    }
}
