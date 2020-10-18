package com.unit.base.zk.exception;

public class ZKLockTimeoutException extends RuntimeException {
    public ZKLockTimeoutException(String msg) {
        super(msg);
    }
}
