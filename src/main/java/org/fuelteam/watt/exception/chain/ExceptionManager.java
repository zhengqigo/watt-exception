package org.fuelteam.watt.exception.chain;

import org.fuelteam.watt.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//使用责任链模式进行异常管理，支持异步方式处理
@Component
public class ExceptionManager {

    @Autowired
    private ExceptionHandlerChain exceptionHandlerChain;

    public void publish(BaseException exception) {
        accept(exception);
    }

    public void publishAndThrow(BaseException exception) throws BaseException {
        accept(exception);
        throw exception;
    }

    protected void accept(BaseException exception) {
        if (!exception.isHandled()) {
            exceptionHandlerChain.handleException(exception);
            exception.setHandled(true);
        }
    }
}
