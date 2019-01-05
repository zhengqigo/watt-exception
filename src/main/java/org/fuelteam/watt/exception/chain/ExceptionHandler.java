package org.fuelteam.watt.exception.chain;

import org.fuelteam.watt.exception.BaseException;

// 异常处理接口
public interface ExceptionHandler extends HandlerSupport {

    public void handle(BaseException baseException, ExceptionHandlerChain exceptionHandlerChain);
}
