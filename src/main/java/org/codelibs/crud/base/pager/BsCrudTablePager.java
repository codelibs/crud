package org.codelibs.crud.base.pager;

import java.io.Serializable;
import java.util.List;

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

    /* CRUD COMMENT: END */

    /* CRUD: BEGIN
    #foreach( $column in ${table.getColumnList()} )
    #if(${column.required})
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
        #if(${column.required})
        ${column.propertyName} = null;
        #end
        #end
           CRUD: END */
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
