package org.codelibs.crud.db.cbean.cq;

import org.codelibs.crud.db.cbean.cq.bs.BsCrudTableCQ;

import org.seasar.dbflute.cbean.ConditionQuery;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;

/**
 * The condition-query of crud_table.
 * <p>
 * You can implement your original methods here. This class remains when
 * re-generating.
 * </p>
 * 
 * @author DBFlute(AutoGenerator)
 */
public class CrudTableCQ extends BsCrudTableCQ {

    //==========================================================================
    // =========
    // Constructor
    // ===========
    /**
     * Constructor.
     * 
     * @param childQuery Child query as abstract class. (Nullable: If null, this
     *            is base instance.)
     * @param sqlClause SQL clause instance. (NotNull)
     * @param aliasName My alias name. (NotNull)
     * @param nestLevel Nest level.
     */
    public CrudTableCQ(ConditionQuery childQuery, SqlClause sqlClause,
            String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    //==========================================================================
    // =========
    // Arrange Method
    // ==============
    // You can make original arrange query methods here.
    // public void arranegeXxx() {
    // ...
    // }
}
