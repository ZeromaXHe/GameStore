package com.zerox.entity.business;

import com.zerox.entity.view.RespDataVO;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/7/28 11:13
 */
public class DataBO {
    private Integer flag;
    private String msg;

    public DataBO(Integer flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public RespDataVO<String> toRespDataVO() {
        return new RespDataVO<>(flag, msg);
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
}
