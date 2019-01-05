package org.fuelteam.watt.exception.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fuelteam.watt.exception.BaseException;
import org.fuelteam.watt.exception.chain.AbstractExceptionHandler;
import org.fuelteam.watt.exception.enums.SeverityEnum;

// LogExceptionHandler 打印异常日志
public class LogExceptionHandler extends AbstractExceptionHandler {

    private static final Logger logger = LogManager.getLogger();

    public boolean support(BaseException baseException) {
        return baseException.getSeverity().getValue() >= SeverityEnum.Slight.getValue();
    }

    protected void doHandle(BaseException baseException) {
        logger.info("LogExceptionHandler");
    }

    protected boolean async() {
        return false;
    }
}
