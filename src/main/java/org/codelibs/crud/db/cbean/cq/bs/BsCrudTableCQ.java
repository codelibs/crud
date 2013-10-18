package org.codelibs.crud.db.cbean.cq.bs;

import java.util.Map;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;
import org.codelibs.crud.db.cbean.cq.ciq.*;
import org.codelibs.crud.db.cbean.*;
import org.codelibs.crud.db.cbean.cq.*;

/**
 * The base condition-query of crud_table.
 * @author DBFlute(AutoGenerator)
 */
public class BsCrudTableCQ extends AbstractBsCrudTableCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected CrudTableCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsCrudTableCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from crud_table) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #FD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public CrudTableCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected CrudTableCIQ xcreateCIQ() {
        CrudTableCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected CrudTableCIQ xnewCIQ() {
        return new CrudTableCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join crud_table on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #FD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public CrudTableCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        CrudTableCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    protected ConditionValue _id;
    public ConditionValue getId() {
        if (_id == null) { _id = nCV(); }
        return _id;
    }
    protected ConditionValue getCValueId() { return getId(); }

    /** 
     * Add order-by as ascend. <br />
     * id: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsCrudTableCQ addOrderBy_Id_Asc() { regOBA("id"); return this; }

    /**
     * Add order-by as descend. <br />
     * id: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsCrudTableCQ addOrderBy_Id_Desc() { regOBD("id"); return this; }

    protected ConditionValue _name;
    public ConditionValue getName() {
        if (_name == null) { _name = nCV(); }
        return _name;
    }
    protected ConditionValue getCValueName() { return getName(); }

    /** 
     * Add order-by as ascend. <br />
     * name: {VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsCrudTableCQ addOrderBy_Name_Asc() { regOBA("name"); return this; }

    /**
     * Add order-by as descend. <br />
     * name: {VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsCrudTableCQ addOrderBy_Name_Desc() { regOBD("name"); return this; }

    protected ConditionValue _value;
    public ConditionValue getValue() {
        if (_value == null) { _value = nCV(); }
        return _value;
    }
    protected ConditionValue getCValueValue() { return getValue(); }

    /** 
     * Add order-by as ascend. <br />
     * value: {VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsCrudTableCQ addOrderBy_Value_Asc() { regOBA("value"); return this; }

    /**
     * Add order-by as descend. <br />
     * value: {VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsCrudTableCQ addOrderBy_Value_Desc() { regOBD("value"); return this; }

    protected ConditionValue _sortOrder;
    public ConditionValue getSortOrder() {
        if (_sortOrder == null) { _sortOrder = nCV(); }
        return _sortOrder;
    }
    protected ConditionValue getCValueSortOrder() { return getSortOrder(); }

    /** 
     * Add order-by as ascend. <br />
     * sort_order: {INT(10)}
     * @return this. (NotNull)
     */
    public BsCrudTableCQ addOrderBy_SortOrder_Asc() { regOBA("sort_order"); return this; }

    /**
     * Add order-by as descend. <br />
     * sort_order: {INT(10)}
     * @return this. (NotNull)
     */
    public BsCrudTableCQ addOrderBy_SortOrder_Desc() { regOBD("sort_order"); return this; }

    protected ConditionValue _createdTime;
    public ConditionValue getCreatedTime() {
        if (_createdTime == null) { _createdTime = nCV(); }
        return _createdTime;
    }
    protected ConditionValue getCValueCreatedTime() { return getCreatedTime(); }

    /** 
     * Add order-by as ascend. <br />
     * created_time: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]}
     * @return this. (NotNull)
     */
    public BsCrudTableCQ addOrderBy_CreatedTime_Asc() { regOBA("created_time"); return this; }

    /**
     * Add order-by as descend. <br />
     * created_time: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]}
     * @return this. (NotNull)
     */
    public BsCrudTableCQ addOrderBy_CreatedTime_Desc() { regOBD("created_time"); return this; }

    // ===================================================================================
    //                                                             SpecifiedDerivedOrderBy
    //                                                             =======================
    /**
     * Add order-by for specified derived column as ascend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #FD4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] asc</span>
     * cb.<span style="color: #FD4747">addSpecifiedDerivedOrderBy_Asc</span>(<span style="color: #FD4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsCrudTableCQ addSpecifiedDerivedOrderBy_Asc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

    /**
     * Add order-by for specified derived column as descend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #FD4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] desc</span>
     * cb.<span style="color: #FD4747">addSpecifiedDerivedOrderBy_Desc</span>(<span style="color: #FD4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsCrudTableCQ addSpecifiedDerivedOrderBy_Desc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    protected void reflectRelationOnUnionQuery(ConditionQuery baseQueryAsSuper, ConditionQuery unionQueryAsSuper) {
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    protected Map<String, CrudTableCQ> _scalarConditionMap;
    public Map<String, CrudTableCQ> getScalarCondition() { return _scalarConditionMap; }
    public String keepScalarCondition(CrudTableCQ subQuery) {
        if (_scalarConditionMap == null) { _scalarConditionMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_scalarConditionMap.size() + 1);
        _scalarConditionMap.put(key, subQuery); return "scalarCondition." + key;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    protected Map<String, CrudTableCQ> _specifyMyselfDerivedMap;
    public Map<String, CrudTableCQ> getSpecifyMyselfDerived() { return _specifyMyselfDerivedMap; }
    public String keepSpecifyMyselfDerived(CrudTableCQ subQuery) {
        if (_specifyMyselfDerivedMap == null) { _specifyMyselfDerivedMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_specifyMyselfDerivedMap.size() + 1);
        _specifyMyselfDerivedMap.put(key, subQuery); return "specifyMyselfDerived." + key;
    }

    protected Map<String, CrudTableCQ> _queryMyselfDerivedMap;
    public Map<String, CrudTableCQ> getQueryMyselfDerived() { return _queryMyselfDerivedMap; }
    public String keepQueryMyselfDerived(CrudTableCQ subQuery) {
        if (_queryMyselfDerivedMap == null) { _queryMyselfDerivedMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_queryMyselfDerivedMap.size() + 1);
        _queryMyselfDerivedMap.put(key, subQuery); return "queryMyselfDerived." + key;
    }
    protected Map<String, Object> _qyeryMyselfDerivedParameterMap;
    public Map<String, Object> getQueryMyselfDerivedParameter() { return _qyeryMyselfDerivedParameterMap; }
    public String keepQueryMyselfDerivedParameter(Object parameterValue) {
        if (_qyeryMyselfDerivedParameterMap == null) { _qyeryMyselfDerivedParameterMap = newLinkedHashMapSized(4); }
        String key = "subQueryParameterKey" + (_qyeryMyselfDerivedParameterMap.size() + 1);
        _qyeryMyselfDerivedParameterMap.put(key, parameterValue); return "queryMyselfDerivedParameter." + key;
    }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, CrudTableCQ> _myselfExistsMap;
    public Map<String, CrudTableCQ> getMyselfExists() { return _myselfExistsMap; }
    public String keepMyselfExists(CrudTableCQ subQuery) {
        if (_myselfExistsMap == null) { _myselfExistsMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_myselfExistsMap.size() + 1);
        _myselfExistsMap.put(key, subQuery); return "myselfExists." + key;
    }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    protected Map<String, CrudTableCQ> _myselfInScopeMap;
    public Map<String, CrudTableCQ> getMyselfInScope() { return _myselfInScopeMap; }
    public String keepMyselfInScope(CrudTableCQ subQuery) {
        if (_myselfInScopeMap == null) { _myselfInScopeMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_myselfInScopeMap.size() + 1);
        _myselfInScopeMap.put(key, subQuery); return "myselfInScope." + key;
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return CrudTableCB.class.getName(); }
    protected String xCQ() { return CrudTableCQ.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
