package com.saas.ec.exception;

public class ActivityException extends BaseException {

    private static final long serialVersionUID = -943045597624040548L;

    private String bizInfo;

    public ActivityException(ExceptionError errorCode) {
        super(errorCode.getErrorCode(), errorCode.getErrorMsg(), errorCode.getReturnMsg());
    }

    public ActivityException(ExceptionError errorCode, Throwable t) {
        super(errorCode.getErrorCode(), errorCode.getErrorMsg(), errorCode.getReturnMsg(), t);
    }

    public ActivityException(ExceptionError errorCode, String bizInfo, Throwable t) {
        super(errorCode.getErrorCode(), errorCode.getErrorMsg(), errorCode.getReturnMsg(), t);
        this.bizInfo = bizInfo;
    }

    public ActivityException(ExceptionError errorCode, String bizInfo) {
        super(errorCode.getErrorCode(), errorCode.getErrorMsg());
        this.bizInfo = bizInfo;
    }

    public ActivityException(ExceptionError errorCode, String bizInfo,String returnMsg) {
        super(errorCode.getErrorCode(), errorCode.getErrorMsg(),returnMsg);
        this.bizInfo = bizInfo;
    }

    public String getBizInfo() {
        return bizInfo;
    }

    public void setBizInfo(String bizInfo) {
        this.bizInfo = bizInfo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ActivityException [bizInfo=");
        builder.append(bizInfo);
        builder.append("]");
        return builder.toString();
    }
}
