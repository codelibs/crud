package org.codelibs.crud.service;

import java.io.Serializable;
import java.util.Map;

import org.codelibs.crud.base.service.BsCrudTableService;
import org.codelibs.crud.db.cbean.CrudTableCB;
import org.codelibs.crud.db.exentity.CrudTable;
import org.codelibs.crud.pager.CrudTablePager;

public class CrudTableService extends BsCrudTableService implements
        Serializable {

    private static final long serialVersionUID = 1L;

    protected void setupListCondition(CrudTableCB cb,
            CrudTablePager crudTablePager) {
        super.setupListCondition(cb, crudTablePager);

        // setup condition

        // search
        /* CRUD COMMENT: BEGIN */
        if (crudTablePager.value != null) {
            cb.query().setValue_Equal(crudTablePager.value);
        }
        /* CRUD COMMENT: END */

        /* CRUD: BEGIN
        #foreach( $column in ${table.getColumnList()} )
        #if(!${column.primaryKey})
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
           CRUD: END */
    }

    protected void setupEntityCondition(CrudTableCB cb, Map<String, String> keys) {
        super.setupEntityCondition(cb, keys);

        // setup condition

    }

    protected void setupStoreCondition(CrudTable crudTable) {
        super.setupStoreCondition(crudTable);

        // setup condition

    }

    protected void setupDeleteCondition(CrudTable crudTable) {
        super.setupDeleteCondition(crudTable);

        // setup condition

    }

}
