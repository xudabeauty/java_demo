package com.saas.ec.exception;

import java.io.Serializable;

public class BaseException implements Serializable{
    private static final long serialVersionUID = 6951461176023604144L;
    private java.lang.String errorCode;
    private java.lang.String errorMsg;
    private java.lang.String returnMsg;
    private java.lang.Integer printLog;

    public BaseException() { /* compiled code */ }

    public BaseException(java.lang.String errorCode, java.lang.String errorMsg) { /* compiled code */ }

    public BaseException(java.lang.String errorCode, java.lang.String errorMsg, java.lang.Integer printLog) { /* compiled code */ }

    public BaseException(java.lang.String errorCode, java.lang.String errorMsg, java.lang.Throwable t) { /* compiled code */ }

    public BaseException(java.lang.String errorCode, java.lang.String errorMsg, java.lang.Integer printLog, java.lang.Throwable t) { /* compiled code */ }

    public BaseException(java.lang.String errorCode, java.lang.String errorMsg, java.lang.String returnMsg) { /* compiled code */ }

    public BaseException(java.lang.String errorCode, java.lang.String errorMsg, java.lang.String returnMsg, java.lang.Integer printLog) { /* compiled code */ }

    public BaseException(java.lang.String errorCode, java.lang.String errorMsg, java.lang.String returnMsg, java.lang.Throwable t) { /* compiled code */ }

    public BaseException(java.lang.String errorCode, java.lang.String errorMsg, java.lang.String returnMsg, java.lang.Integer printLog, java.lang.Throwable t) { /* compiled code */ }

    public void setErrorCode(java.lang.String errorCode) { /* compiled code */ }

    public void setErrorMsg(java.lang.String errorMsg) { /* compiled code */ }


    public void setReturnMsg(java.lang.String returnMsg) { /* compiled code */ }


    public void setPrintLog(java.lang.Integer printLog) { /* compiled code */ }


}
