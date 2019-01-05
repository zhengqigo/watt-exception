package org.fuelteam.watt.exception.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fuelteam.watt.exception.chain.AbstractExceptionHandler;
import org.fuelteam.watt.exception.enums.SeverityEnum;

// Mongodb记录异常日志
public class MongoDBExceptionHandler extends AbstractExceptionHandler {

    private static final Logger logger = LogManager.getLogger();

    public boolean support(org.fuelteam.watt.exception.BaseException baseException) {
        return baseException.getSeverity().getValue() >= SeverityEnum.Slight.getValue();
    }

    protected void doHandle(org.fuelteam.watt.exception.BaseException baseException) {
        logger.info("MongoDBExceptionHandler");
    }

    protected boolean async() {
        return false;
    }
}
