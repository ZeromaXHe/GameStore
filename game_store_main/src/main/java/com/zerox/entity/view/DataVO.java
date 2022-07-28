package com.zerox.entity.view;

/**
 * @author ZeromaXHe
 * @apiNote 数据 VO
 * @implNote
 * @since 2020/7/19 17:52
 */
public class DataVO {
    private String flag;
    private String msg;

    public DataVO() {
    }

    public DataVO(String flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
