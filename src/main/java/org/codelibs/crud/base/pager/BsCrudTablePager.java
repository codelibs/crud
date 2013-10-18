package org.codelibs.crud.base.pager;

import java.io.Serializable;
import java.util.List;

import org.seasar.framework.util.StringUtil;

public abstract class BsCrudTablePager implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int DEFAULT_PAGE_SIZE = 20;

    public static final int DEFAULT_CURRENT_PAGE_NUMBER = 1;

    private int allRecordCount;

    private int allPageCount;

    private boolean existPrePage;

    private boolean existNextPage;

    private List<Integer> pageNumberList;

    private int pageSize;

    private int currentPageNumber;

    /* CRUD COMMENT: BEGIN */
    public String id;
    
    public String value;
    /* CRUD COMMENT: END */

    /* CRUD: BEGIN
    #foreach( $column in ${table.getColumnList()} )
    #if(${column.javaType} == "Long")
    public String ${column.propertyName};
    #elseif(${column.javaType} == "Integer")
    public String ${column.propertyName};
    #elseif(${column.javaType} == "String")
    public String ${column.propertyName};
    #end
    #end
       CRUD: END */

    public void clear() {
        pageSize = getDefaultPageSize();
        currentPageNumber = getDefaultCurrentPageNumber();
        /* CRUD COMMENT: BEGIN */
        id = null;

        /* CRUD COMMENT: END */

        /* CRUD: BEGIN
        #foreach( $column in ${table.getColumnList()} )
        #if(${column.javaType} == "Long")
        ${column.propertyName} = null;
        #elseif(${column.javaType} == "Integer")
        ${column.propertyName} = null;
        #elseif(${column.javaType} == "String")
        ${column.propertyName} = null;
        #end
        #end
           CRUD: END */
    }

    public boolean hasParams() {
        /* CRUD COMMENT: BEGIN */
        if(StringUtil.isNotBlank(id)){return true;}
        /* CRUD COMMENT: END */

        /* CRUD: BEGIN
        #foreach( $column in ${table.getColumnList()} )
        #if(${column.javaType} == "Long")
        if(StringUtil.isNotBlank(${column.propertyName})){return true;}
        #elseif(${column.javaType} == "Integer")
        if(StringUtil.isNotBlank(${column.propertyName})){return true;}
        #elseif(${column.javaType} == "String")
        if(StringUtil.isNotBlank(${column.propertyName})){return true;}
        #end
        #end
           CRUD: END */
        return false;
    }

    protected int getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    protected int getDefaultCurrentPageNumber() {
        return DEFAULT_CURRENT_PAGE_NUMBER;
    }

    public int getAllRecordCount() {
        return allRecordCount;
    }

    public void setAllRecordCount(int allRecordCount) {
        this.allRecordCount = allRecordCount;
    }

    public int getAllPageCount() {
        return allPageCount;
    }

    public void setAllPageCount(int allPageCount) {
        this.allPageCount = allPageCount;
    }

    public boolean isExistPrePage() {
        return existPrePage;
    }

    public void setExistPrePage(boolean existPrePage) {
        this.existPrePage = existPrePage;
    }

    public boolean isExistNextPage() {
        return existNextPage;
    }

    public void setExistNextPage(boolean existNextPage) {
        this.existNextPage = existNextPage;
    }

    public int getPageSize() {
        if (pageSize <= 0) {
            pageSize = getDefaultPageSize();
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPageNumber() {
        if (currentPageNumber <= 0) {
            currentPageNumber = getDefaultCurrentPageNumber();
        }
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public List<Integer> getPageNumberList() {
        return pageNumberList;
    }

    public void setPageNumberList(List<Integer> pageNumberList) {
        this.pageNumberList = pageNumberList;
    }
}
