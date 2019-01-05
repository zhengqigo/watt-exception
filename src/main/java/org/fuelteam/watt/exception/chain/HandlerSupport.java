package org.fuelteam.watt.exception.chain;

import org.fuelteam.watt.exception.BaseException;

public interface HandlerSupport {

    // 是否支持该异常处理
    public boolean support(BaseException exception);
}
