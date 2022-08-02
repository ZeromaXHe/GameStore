package com.zerox.constant;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/8/2 11:24
 */
public enum ReturnCode {
    BUSINESS_OK(0, "操作成功"),
    BUSINESS_FAIL(1, "业务失败"),
    VALIDATION_FAIL(2, "参数校验失败"),
    INTERNAL_ERROR(-1, "内部异常"),
    ;

    private final int code;
    private final String msg;

    ReturnCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
