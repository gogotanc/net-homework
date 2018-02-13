package cn.gogotanc.work.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于返回 Json 数据的对象
 *
 * @author tanc
 */
public class JsonResult {

    private static final Integer SUCCESS = 1;
    private static final Integer FAIL = -1;

    private Integer code;
    private String info;
    private Object data;

    public void setStatusOK() {
        setStatusOK("success");
    }

    public void setStatusOK(String info) {
        this.code = SUCCESS;
        this.info = info;
    }

    public void setStatusFail() {
        setStatusFail("fail");
    }

    public void setStatusFail(String info) {
        this.code = FAIL;
        this.info = info;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("info", info);
        map.put("data", data);
        return map;
    }
}
