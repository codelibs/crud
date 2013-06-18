package org.codelibs.crud.base.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.codelibs.crud.base.CommonConstants;
import org.codelibs.crud.base.CrudMessageException;
import org.codelibs.crud.db.cbean.CrudTableCB;
import org.codelibs.crud.db.exbhv.CrudTableBhv;
import org.codelibs.crud.db.exentity.CrudTable;
import org.codelibs.crud.pager.CrudTablePager;

import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.framework.beans.util.Beans;

public abstract class BsCrudTableService {

    @Resource
    protected CrudTableBhv crudTableBhv;

    public BsCrudTableService() {
        super();
    }

    public List<CrudTable> getCrudTableList(CrudTablePager crudTablePager) {

        CrudTableCB cb = new CrudTableCB();

        cb.fetchFirst(crudTablePager.getPageSize());
        cb.fetchPage(crudTablePager.getCurrentPageNumber());

        setupListCondition(cb, crudTablePager);

        PagingResultBean<CrudTable> crudTableList = crudTableBhv.selectPage(cb);

        // update pager
        Beans.copy(crudTableList, crudTablePager).includes(
                CommonConstants.PAGER_CONVERSION_RULE).execute();
        crudTableList.setPageRangeSize(5);
        crudTablePager.setPageNumberList(crudTableList.pageRange()
                .createPageNumberList());

        return crudTableList;
    }

    public CrudTable getCrudTable(Map<String, String> keys) {
        CrudTableCB cb = new CrudTableCB();

        /* CRUD COMMENT: BEGIN */
        cb.query().setId_Equal(Long.parseLong(keys.get("id")));
        /* CRUD COMMENT: END */

        /* CRUD: BEGIN
        #foreach( $column in ${table.getColumnList()} )
        #if(${column.primaryKey})
        #if(${column.javaType} == "Long")
        cb.query().set${column.methodName}_Equal(Long.parseLong(keys.get("${column.propertyName}"))); 
        #end
        #if(${column.javaType} == "Integer")
        cb.query().set${column.methodName}_Equal(Integer.parseInt(keys.get("${column.propertyName}"))); 
        #end
        #if(${column.javaType} == "String")
        cb.query().set${column.methodName}_Equal(keys.get("${column.propertyName}")); 
        #end
        #end
        #end
        // TODO Long, Integer, String supported only.
           CRUD: END */

        setupEntityCondition(cb, keys);

        CrudTable crudTable = crudTableBhv.selectEntity(cb);
        if (crudTable == null) {
            // TODO exception?
            return null;
        }

        return crudTable;
    }

    public void store(CrudTable crudTable) throws CrudMessageException {
        setupStoreCondition(crudTable);

        crudTableBhv.insertOrUpdate(crudTable);

    }

    public void delete(CrudTable crudTable) throws CrudMessageException {
        setupDeleteCondition(crudTable);

        crudTableBhv.delete(crudTable);

    }

    protected void setupListCondition(CrudTableCB cb,
            CrudTablePager crudTablePager) {
        /* CRUD COMMENT: BEGIN */
        if (crudTablePager.id != null) {
            cb.query().setId_Equal(Long.parseLong(crudTablePager.id));
        }
        /* CRUD COMMENT: END */

        /* CRUD: BEGIN
        #foreach( $column in ${table.getColumnList()} )
        #if(${column.primaryKey})
        #if(${column.javaType} == "Long")
        if (crudTablePager.${column.propertyName} != null) {
            cb.query().set${column.methodName}_Equal(Long.parseLong(crudTablePager.${column.propertyName}));
        }
        #end
        #if(${column.javaType} == "Integer")
        if (crudTablePager.${column.propertyName} != null) {
            cb.query().set${column.methodName}_Equal(Integer.parseInt(crudTablePager.${column.propertyName}));
        }
        #end
        #if(${column.javaType} == "String")
        if (crudTablePager.${column.propertyName} != null) {
            cb.query().set${column.methodName}_Equal(crudTablePager.${column.propertyName});
        }
        #end
        #end
        #end
        // TODO Long, Integer, String supported only.
           CRUD: END */}

    protected void setupEntityCondition(CrudTableCB cb, Map<String, String> keys) {
    }

    protected void setupStoreCondition(CrudTable crudTable) {
    }

    protected void setupDeleteCondition(CrudTable crudTable) {
    }
}