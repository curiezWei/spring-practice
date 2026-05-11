package org.example.managebook.constant;

import java.util.HashMap;
import java.util.Map;

public enum BookStatus {
    DELETE("删除",0),
    NORMAL("可借阅",1),
    FORBIDDEN("不可借阅",2),
    ;
    private Integer code;
    private String desc;

    private static final Map<Integer,String> map = new HashMap<>();
    static {
        for (BookStatus status : values()) {
            map.put(status.getCode(), status.getDesc());
        }
    }
    BookStatus(String desc, Integer code) {
        this.desc = desc;
        this.code = code;
    }

    public static String getDescByCode(Integer code) {
        return map.get(code);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
