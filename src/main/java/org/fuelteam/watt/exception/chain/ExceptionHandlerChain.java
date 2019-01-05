package org.fuelteam.watt.exception.chain;

import java.util.List;

import org.fuelteam.watt.exception.BaseException;
import org.fuelteam.watt.exception.handler.LogExceptionHandler;
import org.fuelteam.watt.exception.handler.MailExceptionHandler;
import org.fuelteam.watt.exception.handler.MongoDBExceptionHandler;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
public class ExceptionHandlerChain {

    private List<AbstractExceptionHandler> chain = Lists.newArrayList(new LogExceptionHandler(),
            new MailExceptionHandler(), new MongoDBExceptionHandler());

    private ThreadLocal<Integer> index = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return Integer.valueOf(0);
        }
    };

    public boolean handleException(BaseException baseException) {
        Integer currentIndex = index.get();
        boolean isLast = false;
        if (currentIndex < chain.size()) {
            if (currentIndex == chain.size() - 1) {
                isLast = true;
                index.remove();
            } else {
                index.set(currentIndex + 1);
            }
            chain.get(currentIndex).setLast(isLast);
            chain.get(currentIndex).handle(baseException, this);
        }
        return true;
    }
}
