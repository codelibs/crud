package org.codelibs.crud.db.cbean.nss;

import org.codelibs.crud.db.cbean.cq.CrudTableCQ;

/**
 * The nest select set-upper of crud_table.
 * @author DBFlute(AutoGenerator)
 */
public class CrudTableNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected CrudTableCQ _query;
    public CrudTableNss(CrudTableCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============

}
