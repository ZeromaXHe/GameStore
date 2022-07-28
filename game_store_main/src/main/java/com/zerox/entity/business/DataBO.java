package com.zerox.entity.business;

import com.zerox.entity.view.DataVO;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/7/28 11:13
 */
public class DataBO {
    private String flag;
    private String msg;

    public DataBO(String flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public DataVO toDataVO() {
        return new DataVO(flag, msg);
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
