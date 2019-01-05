package org.fuelteam.watt.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.fuelteam.watt.exception.enums.ModuleEnum;
import org.fuelteam.watt.exception.enums.SeverityEnum;

import com.alibaba.fastjson.JSON;

// 远程接口提供方正常处理逻辑通过Code/Message方式进行传递，异常情况抛出RemoteException（包括超时和网络异常等），消费方捕获后处理。
public class RemoteException extends BaseException {

    private static final long serialVersionUID = 6663780729210911488L;

    private static final ModuleEnum REMOTE = ModuleEnum.Remote;

    public RemoteException(final String module, final String code, final String message, final SeverityEnum severity,
            Throwable cause) {
        super(REMOTE, code, message, severity, cause);
    }

    public RemoteException(final String code, final String message, final SeverityEnum severity, Throwable cause) {
        super(REMOTE, code, message, severity, cause);
    }

    public RemoteException(final String code, final SeverityEnum severity, Throwable cause) {
        super(REMOTE, code, null, severity, cause);
    }

    public RemoteException(final String code, final String message, final SeverityEnum severity) {
        super(REMOTE, code, message, severity, null);
    }

    public RemoteException(final String code, final SeverityEnum severity) {
        super(REMOTE, code, null, severity, null);
    }

    public RemoteException(final String code, final String message) {
        super(REMOTE, code, null, null);
    }

    public RemoteException(final String message) {
        super(REMOTE, null, message, null, null);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
