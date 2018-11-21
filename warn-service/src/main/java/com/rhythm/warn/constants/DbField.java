package com.rhythm.warn.constants;

/**
 * 数据库字段
 *
 * @author majunjie
 * @date 2018/11/19 13:08
 */
public interface DbField {
    /**
     * 字段名
     */
    String id = "id";
    String name = "name";
    String notify_code = "notify_code";

    /**
     * 值
     */
    int NOT_DEFAULT = 0;
    int IS_DEFAULT = 1;

    int IS_DELETED_NO = 0;
    int IS_DELETED_YES = 1;
}
