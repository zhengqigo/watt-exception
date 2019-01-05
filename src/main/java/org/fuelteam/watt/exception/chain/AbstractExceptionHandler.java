package org.fuelteam.watt.exception.chain;

import org.fuelteam.watt.exception.BaseException;
import org.springframework.core.task.TaskExecutor;

public abstract class AbstractExceptionHandler implements ExceptionHandler {

    // 异步处理线程池
    private TaskExecutor exceptionHandleExecutor;

    // 是否为链条中的最后一个处理器
    private Boolean isLast;

    public void handle(BaseException exception, ExceptionHandlerChain chain) {
        if (support(exception)) {
            if (async()) {
                getExceptionHandleExecutor().execute(new AsyncHandler(exception));
            } else {
                doHandle(exception);
            }
        }
        if (!isLast()) chain.handleException(exception);
    }

    protected abstract void doHandle(BaseException ue);

    protected abstract boolean async();

    private class AsyncHandler implements Runnable {

        private BaseException exception;

        public AsyncHandler(BaseException ue) {
            this.exception = ue;
        }

        public void run() {
            doHandle(exception);
        }
    }

    public TaskExecutor getExceptionHandleExecutor() {
        return exceptionHandleExecutor;
    }

    public void setExceptionHandleExecutor(TaskExecutor exceptionHandleExecutor) {
        this.exceptionHandleExecutor = exceptionHandleExecutor;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean isLast) {
        this.isLast = isLast;
    }
}
