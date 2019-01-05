package org.fuelteam.watt.exception;

import java.io.IOException;

import org.fuelteam.watt.exception.enums.SeverityEnum;
import org.fuelteam.watt.exception.util.ExceptionUtil;
import org.junit.Assert;
import org.junit.Test;

public class ExtExceptionsTest {

    @Test
    public void unchecked() {
        // convert Exception to RuntimeException with cause
        BaseException exception = new SystemException("999999", "系统异常，请稍后重试", SeverityEnum.Critical);
        RuntimeException runtimeException = ExceptionUtil.unchecked(exception);
        Assert.assertEquals(exception, runtimeException.getCause());

        // do nothing of RuntimeException
        RuntimeException runtimeException2 = ExceptionUtil.unchecked(runtimeException);
        Assert.assertEquals(runtimeException2, runtimeException);
    }

    @Test
    public void getStackTraceAsString() {
        BaseException exception = new SystemException("999999", "系统异常，请稍后重试", SeverityEnum.Critical);
        RuntimeException runtimeException = new RuntimeException(exception);

        System.out.println(ExceptionUtil.getStackTraceAsString(runtimeException));
        System.out.println(ExceptionUtil.getErrorMessageWithNestedException(runtimeException));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void isCausedBy() {
        BaseException exception = new SystemException("999999", "系统异常，请稍后重试", SeverityEnum.Critical);
        IllegalStateException illegalStateException = new IllegalStateException(exception);
        RuntimeException runtimeException = new RuntimeException(illegalStateException);

        Assert.assertTrue(ExceptionUtil.isCausedBy(runtimeException, BaseException.class));
        Assert.assertTrue(ExceptionUtil.isCausedBy(runtimeException, SystemException.class, BaseException.class));
        Assert.assertTrue(ExceptionUtil.isCausedBy(runtimeException, BaseException.class));
        Assert.assertTrue(!ExceptionUtil.isCausedBy(runtimeException, IOException.class));
    }

}
