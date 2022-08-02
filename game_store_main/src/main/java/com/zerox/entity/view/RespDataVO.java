package com.zerox.entity.view;

import com.zerox.constant.ReturnCode;

/**
 * @author ZeromaXHe
 * @apiNote 数据 VO
 * @implNote
 * @since 2020/7/19 17:52
 */
public class RespDataVO<T> {
    private Integer flag;
    private String msg;
    private T data;

    public RespDataVO() {
    }

    public RespDataVO(Integer flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public RespDataVO(ReturnCode code) {
        this.flag = code.getCode();
        this.msg = code.getMsg();
    }

    public static <T> RespDataVO<T> ok(T data) {
        RespDataVO<T> resp = new RespDataVO<>(ReturnCode.BUSINESS_OK);
        resp.setData(data);
        return resp;
    }

    public static <T> RespDataVO<T> error(T data) {
        RespDataVO<T> resp = new RespDataVO<>(ReturnCode.INTERNAL_ERROR);
        resp.setData(data);
        return resp;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
