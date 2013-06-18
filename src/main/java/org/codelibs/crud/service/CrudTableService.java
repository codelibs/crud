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
