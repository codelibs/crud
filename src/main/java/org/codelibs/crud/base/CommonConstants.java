package org.codelibs.crud.base;

public class CommonConstants {
    public static final int LIST_MODE = 0;

    public static final int CREATE_MODE = 1;

    public static final int EDIT_MODE = 2;

    public static final int DELETE_MODE = 3;

    public static final int CONFIRM_MODE = 4;

    public static final String TIMESTAMP_PATTERN = "yyyy/MM/dd HH:mm:ss";

    public static final String TRUE = "T";

    public static final String FALSE = "F";

    public static final String[] PAGER_CONVERSION_RULE = { "allRecordCount",
            "pageSize", "currentPageNumber", "allPageCount", "existPrePage",
            "existNextPage" };
}
