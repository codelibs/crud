package org.codelibs.crud.db.bsbhv;

import java.util.List;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.outsidesql.executor.*;
import org.codelibs.crud.db.exbhv.*;
import org.codelibs.crud.db.exentity.*;
import org.codelibs.crud.db.bsentity.dbmeta.*;
import org.codelibs.crud.db.cbean.*;

/**
 * The behavior of crud_table as TABLE. <br />
 * <pre>
 * [primary key]
 *     id
 * 
 * [column]
 *     id, name, value, sort_order, created_time
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     id
 * 
 * [version-no]
 *     
 * 
 * [foreign table]
 *     
 * 
 * [referrer table]
 *     
 * 
 * [foreign property]
 *     
 * 
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsCrudTableBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "crud_table"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return CrudTableDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public CrudTableDbm getMyDBMeta() { return CrudTableDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public CrudTable newMyEntity() { return new CrudTable(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public CrudTableCB newMyConditionBean() { return new CrudTableCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * CrudTableCB cb = new CrudTableCB();
     * cb.query().setFoo...(value);
     * int count = crudTableBhv.<span style="color: #FD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of CrudTable. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(CrudTableCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(CrudTableCB cb) { // called by selectCount(cb) 
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(CrudTableCB cb) { // called by selectPage(cb)
        assertCBStateValid(cb);
        return delegateSelectCountPlainly(cb);
    }

    @Override
    protected int doReadCount(ConditionBean cb) {
        return selectCount(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean.
     * <pre>
     * CrudTableCB cb = new CrudTableCB();
     * cb.query().setFoo...(value);
     * CrudTable crudTable = crudTableBhv.<span style="color: #FD4747">selectEntity</span>(cb);
     * if (crudTable != null) {
     *     ... = crudTable.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of CrudTable. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public CrudTable selectEntity(CrudTableCB cb) {
        return doSelectEntity(cb, CrudTable.class);
    }

    protected <ENTITY extends CrudTable> ENTITY doSelectEntity(final CrudTableCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityInternally(cb, entityType, new InternalSelectEntityCallback<ENTITY, CrudTableCB>() {
            public List<ENTITY> callbackSelectList(CrudTableCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * <pre>
     * CrudTableCB cb = new CrudTableCB();
     * cb.query().setFoo...(value);
     * CrudTable crudTable = crudTableBhv.<span style="color: #FD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = crudTable.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of CrudTable. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public CrudTable selectEntityWithDeletedCheck(CrudTableCB cb) {
        return doSelectEntityWithDeletedCheck(cb, CrudTable.class);
    }

    protected <ENTITY extends CrudTable> ENTITY doSelectEntityWithDeletedCheck(final CrudTableCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityWithDeletedCheckInternally(cb, entityType, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, CrudTableCB>() {
            public List<ENTITY> callbackSelectList(CrudTableCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param id The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public CrudTable selectByPKValue(Long id) {
        return doSelectByPKValue(id, CrudTable.class);
    }

    protected <ENTITY extends CrudTable> ENTITY doSelectByPKValue(Long id, Class<ENTITY> entityType) {
        return doSelectEntity(buildPKCB(id), entityType);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param id The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public CrudTable selectByPKValueWithDeletedCheck(Long id) {
        return doSelectByPKValueWithDeletedCheck(id, CrudTable.class);
    }

    protected <ENTITY extends CrudTable> ENTITY doSelectByPKValueWithDeletedCheck(Long id, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(id), entityType);
    }

    private CrudTableCB buildPKCB(Long id) {
        assertObjectNotNull("id", id);
        CrudTableCB cb = newMyConditionBean();
        cb.query().setId_Equal(id);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * CrudTableCB cb = new CrudTableCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;CrudTable&gt; crudTableList = crudTableBhv.<span style="color: #FD4747">selectList</span>(cb);
     * for (CrudTable crudTable : crudTableList) {
     *     ... = crudTable.get...();
     * }
     * </pre>
     * @param cb The condition-bean of CrudTable. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<CrudTable> selectList(CrudTableCB cb) {
        return doSelectList(cb, CrudTable.class);
    }

    protected <ENTITY extends CrudTable> ListResultBean<ENTITY> doSelectList(CrudTableCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        return helpSelectListInternally(cb, entityType, new InternalSelectListCallback<ENTITY, CrudTableCB>() {
            public List<ENTITY> callbackSelectList(CrudTableCB cb, Class<ENTITY> entityType) { return delegateSelectList(cb, entityType); } });
    }

    @Override
    protected ListResultBean<? extends Entity> doReadList(ConditionBean cb) {
        return selectList(downcast(cb));
    }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result bean. <br />
     * (both count-select and paging-select are executed)
     * <pre>
     * CrudTableCB cb = new CrudTableCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #FD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;CrudTable&gt; page = crudTableBhv.<span style="color: #FD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (CrudTable crudTable : page) {
     *     ... = crudTable.get...();
     * }
     * </pre>
     * @param cb The condition-bean of CrudTable. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<CrudTable> selectPage(CrudTableCB cb) {
        return doSelectPage(cb, CrudTable.class);
    }

    protected <ENTITY extends CrudTable> PagingResultBean<ENTITY> doSelectPage(CrudTableCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        return helpSelectPageInternally(cb, entityType, new InternalSelectPageCallback<ENTITY, CrudTableCB>() {
            public int callbackSelectCount(CrudTableCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(CrudTableCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
        });
    }

    @Override
    protected PagingResultBean<? extends Entity> doReadPage(ConditionBean cb) {
        return selectPage(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * Select the cursor by the condition-bean.
     * <pre>
     * CrudTableCB cb = new CrudTableCB();
     * cb.query().setFoo...(value);
     * crudTableBhv.<span style="color: #FD4747">selectCursor</span>(cb, new EntityRowHandler&lt;CrudTable&gt;() {
     *     public void handle(CrudTable entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of CrudTable. (NotNull)
     * @param entityRowHandler The handler of entity row of CrudTable. (NotNull)
     */
    public void selectCursor(CrudTableCB cb, EntityRowHandler<CrudTable> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, CrudTable.class);
    }

    protected <ENTITY extends CrudTable> void doSelectCursor(CrudTableCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler<CrudTable>", entityRowHandler); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        helpSelectCursorInternally(cb, entityRowHandler, entityType, new InternalSelectCursorCallback<ENTITY, CrudTableCB>() {
            public void callbackSelectCursor(CrudTableCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) { delegateSelectCursor(cb, entityRowHandler, entityType); }
            public List<ENTITY> callbackSelectList(CrudTableCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * crudTableBhv.<span style="color: #FD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(CrudTableCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar value derived by a function. (NullAllowed)
     */
    public <RESULT> SLFunction<CrudTableCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends CrudTableCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> resultType, CB cb) {
        assertObjectNotNull("resultType", resultType); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return new SLFunction<CB, RESULT>(cb, resultType);
    }

    // ===================================================================================
    //                                                                            Sequence
    //                                                                            ========
    @Override
    protected Number doReadNextVal() {
        String msg = "This table is NOT related to sequence: " + getTableDbName();
        throw new UnsupportedOperationException(msg);
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key id.
     * @param crudTableList The list of crudTable. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Long> extractIdList(List<CrudTable> crudTableList) {
        return helpExtractListInternally(crudTableList, new InternalExtractCallback<CrudTable, Long>() {
            public Long getCV(CrudTable e) { return e.getId(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * CrudTable crudTable = new CrudTable();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * crudTable.setFoo...(value);
     * crudTable.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//crudTable.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//crudTable.set...;</span>
     * crudTableBhv.<span style="color: #FD4747">insert</span>(crudTable);
     * ... = crudTable.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param crudTable The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(CrudTable crudTable) {
        doInsert(crudTable, null);
    }

    protected void doInsert(CrudTable crudTable, InsertOption<CrudTableCB> option) {
        assertObjectNotNull("crudTable", crudTable);
        prepareInsertOption(option);
        delegateInsert(crudTable, option);
    }

    protected void prepareInsertOption(InsertOption<CrudTableCB> option) {
        if (option == null) { return; }
        assertInsertOptionStatus(option);
        if (option.hasSpecifiedInsertColumn()) {
            option.resolveInsertColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    @Override
    protected void doCreate(Entity entity, InsertOption<? extends ConditionBean> option) {
        if (option == null) { insert(downcast(entity)); }
        else { varyingInsert(downcast(entity), downcast(option)); }
    }

    /**
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * CrudTable crudTable = new CrudTable();
     * crudTable.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * crudTable.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//crudTable.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//crudTable.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * crudTable.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     crudTableBhv.<span style="color: #FD4747">update</span>(crudTable);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param crudTable The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final CrudTable crudTable) {
        doUpdate(crudTable, null);
    }

    protected void doUpdate(CrudTable crudTable, final UpdateOption<CrudTableCB> option) {
        assertObjectNotNull("crudTable", crudTable);
        prepareUpdateOption(option);
        helpUpdateInternally(crudTable, new InternalUpdateCallback<CrudTable>() {
            public int callbackDelegateUpdate(CrudTable entity) { return delegateUpdate(entity, option); } });
    }

    protected void prepareUpdateOption(UpdateOption<CrudTableCB> option) {
        if (option == null) { return; }
        assertUpdateOptionStatus(option);
        if (option.hasSelfSpecification()) {
            option.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (option.hasSpecifiedUpdateColumn()) {
            option.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected CrudTableCB createCBForVaryingUpdate() {
        CrudTableCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected CrudTableCB createCBForSpecifiedUpdate() {
        CrudTableCB cb = newMyConditionBean();
        cb.xsetupForSpecifiedUpdate();
        return cb;
    }

    @Override
    protected void doModify(Entity entity, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { update(downcast(entity)); }
        else { varyingUpdate(downcast(entity), downcast(option)); }
    }

    @Override
    protected void doModifyNonstrict(Entity entity, UpdateOption<? extends ConditionBean> option) {
        doModify(entity, option);
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #FD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param crudTable The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(CrudTable crudTable) {
        doInesrtOrUpdate(crudTable, null, null);
    }

    protected void doInesrtOrUpdate(CrudTable crudTable, final InsertOption<CrudTableCB> insertOption, final UpdateOption<CrudTableCB> updateOption) {
        helpInsertOrUpdateInternally(crudTable, new InternalInsertOrUpdateCallback<CrudTable, CrudTableCB>() {
            public void callbackInsert(CrudTable entity) { doInsert(entity, insertOption); }
            public void callbackUpdate(CrudTable entity) { doUpdate(entity, updateOption); }
            public CrudTableCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(CrudTableCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity entity, InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        if (insertOption == null && updateOption == null) { insertOrUpdate(downcast(entity)); }
        else {
            insertOption = insertOption == null ? new InsertOption<CrudTableCB>() : insertOption;
            updateOption = updateOption == null ? new UpdateOption<CrudTableCB>() : updateOption;
            varyingInsertOrUpdate(downcast(entity), downcast(insertOption), downcast(updateOption));
        }
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity entity, InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        doCreateOrModify(entity, insertOption, updateOption);
    }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * CrudTable crudTable = new CrudTable();
     * crudTable.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * crudTable.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     crudTableBhv.<span style="color: #FD4747">delete</span>(crudTable);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param crudTable The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(CrudTable crudTable) {
        doDelete(crudTable, null);
    }

    protected void doDelete(CrudTable crudTable, final DeleteOption<CrudTableCB> option) {
        assertObjectNotNull("crudTable", crudTable);
        prepareDeleteOption(option);
        helpDeleteInternally(crudTable, new InternalDeleteCallback<CrudTable>() {
            public int callbackDelegateDelete(CrudTable entity) { return delegateDelete(entity, option); } });
    }

    protected void prepareDeleteOption(DeleteOption<CrudTableCB> option) {
        if (option == null) { return; }
        assertDeleteOptionStatus(option);
    }

    @Override
    protected void doRemove(Entity entity, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { delete(downcast(entity)); }
        else { varyingDelete(downcast(entity), downcast(option)); }
    }

    @Override
    protected void doRemoveNonstrict(Entity entity, DeleteOption<? extends ConditionBean> option) {
        doRemove(entity, option);
    }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch-insert the entity list modified-only of same-set columns. (DefaultConstraintsEnabled) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <p><span style="color: #FD4747; font-size: 120%">The columns of least common multiple are registered like this:</span></p>
     * <pre>
     * for (... : ...) {
     *     CrudTable crudTable = new CrudTable();
     *     crudTable.setFooName("foo");
     *     if (...) {
     *         crudTable.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     crudTableList.add(crudTable);
     * }
     * crudTableBhv.<span style="color: #FD4747">batchInsert</span>(crudTableList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param crudTableList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<CrudTable> crudTableList) {
        InsertOption<CrudTableCB> option = createInsertUpdateOption();
        return doBatchInsert(crudTableList, option);
    }

    protected int[] doBatchInsert(List<CrudTable> crudTableList, InsertOption<CrudTableCB> option) {
        assertObjectNotNull("crudTableList", crudTableList);
        prepareBatchInsertOption(crudTableList, option);
        return delegateBatchInsert(crudTableList, option);
    }

    protected void prepareBatchInsertOption(List<CrudTable> crudTableList, InsertOption<CrudTableCB> option) {
        option.xallowInsertColumnModifiedPropertiesFragmented();
        option.xacceptInsertColumnModifiedPropertiesIfNeeds(crudTableList);
        prepareInsertOption(option);
    }

    @Override
    protected int[] doLumpCreate(List<Entity> ls, InsertOption<? extends ConditionBean> option) {
        if (option == null) { return batchInsert(downcast(ls)); }
        else { return varyingBatchInsert(downcast(ls), downcast(option)); }
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #FD4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     CrudTable crudTable = new CrudTable();
     *     crudTable.setFooName("foo");
     *     if (...) {
     *         crudTable.setFooPrice(123);
     *     } else {
     *         crudTable.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//crudTable.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     crudTableList.add(crudTable);
     * }
     * crudTableBhv.<span style="color: #FD4747">batchUpdate</span>(crudTableList);
     * </pre>
     * @param crudTableList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<CrudTable> crudTableList) {
        UpdateOption<CrudTableCB> option = createPlainUpdateOption();
        return doBatchUpdate(crudTableList, option);
    }

    protected int[] doBatchUpdate(List<CrudTable> crudTableList, UpdateOption<CrudTableCB> option) {
        assertObjectNotNull("crudTableList", crudTableList);
        prepareBatchUpdateOption(crudTableList, option);
        return delegateBatchUpdate(crudTableList, option);
    }

    protected void prepareBatchUpdateOption(List<CrudTable> crudTableList, UpdateOption<CrudTableCB> option) {
        option.xacceptUpdateColumnModifiedPropertiesIfNeeds(crudTableList);
        prepareUpdateOption(option);
    }

    @Override
    protected int[] doLumpModify(List<Entity> ls, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { return batchUpdate(downcast(ls)); }
        else { return varyingBatchUpdate(downcast(ls), downcast(option)); }
    }

    /**
     * Batch-update the entity list specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span> 
     * crudTableBhv.<span style="color: #FD4747">batchUpdate</span>(crudTableList, new SpecifyQuery<CrudTableCB>() {
     *     public void specify(CrudTableCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span> 
     * crudTableBhv.<span style="color: #FD4747">batchUpdate</span>(crudTableList, new SpecifyQuery<CrudTableCB>() {
     *     public void specify(CrudTableCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param crudTableList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<CrudTable> crudTableList, SpecifyQuery<CrudTableCB> updateColumnSpec) {
        return doBatchUpdate(crudTableList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> option) {
        return doLumpModify(ls, option);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param crudTableList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<CrudTable> crudTableList) {
        return doBatchDelete(crudTableList, null);
    }

    protected int[] doBatchDelete(List<CrudTable> crudTableList, DeleteOption<CrudTableCB> option) {
        assertObjectNotNull("crudTableList", crudTableList);
        prepareDeleteOption(option);
        return delegateBatchDelete(crudTableList, option);
    }

    @Override
    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { return batchDelete(downcast(ls)); }
        else { return varyingBatchDelete(downcast(ls), downcast(option)); }
    }

    @Override
    protected int[] doLumpRemoveNonstrict(List<Entity> ls, DeleteOption<? extends ConditionBean> option) {
        return doLumpRemove(ls, option);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * crudTableBhv.<span style="color: #FD4747">queryInsert</span>(new QueryInsertSetupper&lt;CrudTable, CrudTableCB&gt;() {
     *     public ConditionBean setup(crudTable entity, CrudTableCB intoCB) {
     *         FooCB cb = FooCB();
     *         cb.setupSelect_Bar();
     * 
     *         <span style="color: #3F7E5E">// mapping</span>
     *         intoCB.specify().columnMyName().mappedFrom(cb.specify().columnFooName());
     *         intoCB.specify().columnMyCount().mappedFrom(cb.specify().columnFooCount());
     *         intoCB.specify().columnMyDate().mappedFrom(cb.specify().specifyBar().columnBarDate());
     *         entity.setMyFixedValue("foo"); <span style="color: #3F7E5E">// fixed value</span>
     *         <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     *         <span style="color: #3F7E5E">//entity.setRegisterUser(value);</span>
     *         <span style="color: #3F7E5E">//entity.set...;</span>
     *         <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     *         <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     * 
     *         return cb;
     *     }
     * });
     * </pre>
     * @param setupper The setup-per of query-insert. (NotNull)
     * @return The inserted count.
     */
    public int queryInsert(QueryInsertSetupper<CrudTable, CrudTableCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<CrudTable, CrudTableCB> setupper, InsertOption<CrudTableCB> option) {
        assertObjectNotNull("setupper", setupper);
        prepareInsertOption(option);
        CrudTable entity = new CrudTable();
        CrudTableCB intoCB = createCBForQueryInsert();
        ConditionBean resourceCB = setupper.setup(entity, intoCB);
        return delegateQueryInsert(entity, intoCB, resourceCB, option);
    }

    protected CrudTableCB createCBForQueryInsert() {
        CrudTableCB cb = newMyConditionBean();
        cb.xsetupForQueryInsert();
        return cb;
    }

    @Override
    protected int doRangeCreate(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper, InsertOption<? extends ConditionBean> option) {
        if (option == null) { return queryInsert(downcast(setupper)); }
        else { return varyingQueryInsert(downcast(setupper), downcast(option)); }
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * CrudTable crudTable = new CrudTable();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//crudTable.setPK...(value);</span>
     * crudTable.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//crudTable.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//crudTable.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//crudTable.setVersionNo(value);</span>
     * CrudTableCB cb = new CrudTableCB();
     * cb.query().setFoo...(value);
     * crudTableBhv.<span style="color: #FD4747">queryUpdate</span>(crudTable, cb);
     * </pre>
     * @param crudTable The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of CrudTable. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(CrudTable crudTable, CrudTableCB cb) {
        return doQueryUpdate(crudTable, cb, null);
    }

    protected int doQueryUpdate(CrudTable crudTable, CrudTableCB cb, UpdateOption<CrudTableCB> option) {
        assertObjectNotNull("crudTable", crudTable); assertCBStateValid(cb);
        prepareUpdateOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(crudTable, cb, option) : 0;
    }

    @Override
    protected int doRangeModify(Entity entity, ConditionBean cb, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { return queryUpdate(downcast(entity), (CrudTableCB)cb); }
        else { return varyingQueryUpdate(downcast(entity), (CrudTableCB)cb, downcast(option)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * CrudTableCB cb = new CrudTableCB();
     * cb.query().setFoo...(value);
     * crudTableBhv.<span style="color: #FD4747">queryDelete</span>(crudTable, cb);
     * </pre>
     * @param cb The condition-bean of CrudTable. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(CrudTableCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(CrudTableCB cb, DeleteOption<CrudTableCB> option) {
        assertCBStateValid(cb);
        prepareDeleteOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, option) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { return queryDelete((CrudTableCB)cb); }
        else { return varyingQueryDelete((CrudTableCB)cb, downcast(option)); }
    }

    // ===================================================================================
    //                                                                      Varying Update
    //                                                                      ==============
    // -----------------------------------------------------
    //                                         Entity Update
    //                                         -------------
    /**
     * Insert the entity with varying requests. <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as insert(entity).
     * <pre>
     * CrudTable crudTable = new CrudTable();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * crudTable.setFoo...(value);
     * crudTable.setBar...(value);
     * InsertOption<CrudTableCB> option = new InsertOption<CrudTableCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * crudTableBhv.<span style="color: #FD4747">varyingInsert</span>(crudTable, option);
     * ... = crudTable.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param crudTable The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(CrudTable crudTable, InsertOption<CrudTableCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(crudTable, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * CrudTable crudTable = new CrudTable();
     * crudTable.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * crudTable.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * crudTable.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;CrudTableCB&gt; option = new UpdateOption&lt;CrudTableCB&gt;();
     *     option.self(new SpecifyQuery&lt;CrudTableCB&gt;() {
     *         public void specify(CrudTableCB cb) {
     *             cb.specify().<span style="color: #FD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     crudTableBhv.<span style="color: #FD4747">varyingUpdate</span>(crudTable, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param crudTable The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(CrudTable crudTable, UpdateOption<CrudTableCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(crudTable, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param crudTable The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(CrudTable crudTable, InsertOption<CrudTableCB> insertOption, UpdateOption<CrudTableCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(crudTable, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param crudTable The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(CrudTable crudTable, DeleteOption<CrudTableCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(crudTable, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param crudTableList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<CrudTable> crudTableList, InsertOption<CrudTableCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(crudTableList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param crudTableList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<CrudTable> crudTableList, UpdateOption<CrudTableCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(crudTableList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param crudTableList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<CrudTable> crudTableList, DeleteOption<CrudTableCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(crudTableList, option);
    }

    // -----------------------------------------------------
    //                                          Query Update
    //                                          ------------
    /**
     * Insert the several entities by query with varying requests (modified-only for fixed value). <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as queryInsert(entity, setupper). 
     * @param setupper The setup-per of query-insert. (NotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The inserted count.
     */
    public int varyingQueryInsert(QueryInsertSetupper<CrudTable, CrudTableCB> setupper, InsertOption<CrudTableCB> option) {
        assertInsertOptionNotNull(option);
        return doQueryInsert(setupper, option);
    }

    /**
     * Update the several entities by query with varying requests non-strictly modified-only. {NonExclusiveControl} <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), allowNonQueryUpdate(). <br />
     * Other specifications are same as queryUpdate(entity, cb). 
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * CrudTable crudTable = new CrudTable();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//crudTable.setPK...(value);</span>
     * crudTable.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//crudTable.setVersionNo(value);</span>
     * CrudTableCB cb = new CrudTableCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;CrudTableCB&gt; option = new UpdateOption&lt;CrudTableCB&gt;();
     * option.self(new SpecifyQuery&lt;CrudTableCB&gt;() {
     *     public void specify(CrudTableCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * crudTableBhv.<span style="color: #FD4747">varyingQueryUpdate</span>(crudTable, cb, option);
     * </pre>
     * @param crudTable The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of CrudTable. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(CrudTable crudTable, CrudTableCB cb, UpdateOption<CrudTableCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(crudTable, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of CrudTable. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(CrudTableCB cb, DeleteOption<CrudTableCB> option) {
        assertDeleteOptionNotNull(option);
        return doQueryDelete(cb, option);
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    /**
     * Prepare the basic executor of outside-SQL to execute it. <br />
     * The invoker of behavior command should be not null when you call this method.
     * <pre>
     * You can use the methods for outside-SQL are as follows:
     * {Basic}
     *   o selectList()
     *   o execute()
     *   o call()
     * 
     * {Entity}
     *   o entityHandling().selectEntity()
     *   o entityHandling().selectEntityWithDeletedCheck()
     * 
     * {Paging}
     *   o autoPaging().selectList()
     *   o autoPaging().selectPage()
     *   o manualPaging().selectList()
     *   o manualPaging().selectPage()
     * 
     * {Cursor}
     *   o cursorHandling().selectCursor()
     * 
     * {Option}
     *   o dynamicBinding().selectList()
     *   o removeBlockComment().selectList()
     *   o removeLineComment().selectList()
     *   o formatSql().selectList()
     * </pre>
     * @return The basic executor of outside-SQL. (NotNull) 
     */
    public OutsideSqlBasicExecutor<CrudTableBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(CrudTableCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(CrudTableCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends CrudTable> void delegateSelectCursor(CrudTableCB cb, EntityRowHandler<ENTITY> erh, Class<ENTITY> et)
    { invoke(createSelectCursorCBCommand(cb, erh, et)); }
    protected <ENTITY extends CrudTable> List<ENTITY> delegateSelectList(CrudTableCB cb, Class<ENTITY> et)
    { return invoke(createSelectListCBCommand(cb, et)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(CrudTable e, InsertOption<CrudTableCB> op)
    { if (!processBeforeInsert(e, op)) { return 0; }
      return invoke(createInsertEntityCommand(e, op)); }
    protected int delegateUpdate(CrudTable e, UpdateOption<CrudTableCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return delegateUpdateNonstrict(e, op); }
    protected int delegateUpdateNonstrict(CrudTable e, UpdateOption<CrudTableCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(e, op)); }
    protected int delegateDelete(CrudTable e, DeleteOption<CrudTableCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return delegateDeleteNonstrict(e, op); }
    protected int delegateDeleteNonstrict(CrudTable e, DeleteOption<CrudTableCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(e, op)); }

    protected int[] delegateBatchInsert(List<CrudTable> ls, InsertOption<CrudTableCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<CrudTable> ls, UpdateOption<CrudTableCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<CrudTable> ls, UpdateOption<CrudTableCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<CrudTable> ls, DeleteOption<CrudTableCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<CrudTable> ls, DeleteOption<CrudTableCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(CrudTable e, CrudTableCB inCB, ConditionBean resCB, InsertOption<CrudTableCB> op)
    { if (!processBeforeQueryInsert(e, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(e, inCB, resCB, op));  }
    protected int delegateQueryUpdate(CrudTable e, CrudTableCB cb, UpdateOption<CrudTableCB> op)
    { if (!processBeforeQueryUpdate(e, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(e, cb, op));  }
    protected int delegateQueryDelete(CrudTableCB cb, DeleteOption<CrudTableCB> op)
    { if (!processBeforeQueryDelete(cb, op)) { return 0; } return invoke(createQueryDeleteCBCommand(cb, op));  }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasVersionNoValue(Entity entity) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasUpdateDateValue(Entity entity) {
        return false;
    }

    // ===================================================================================
    //                                                                     Downcast Helper
    //                                                                     ===============
    protected CrudTable downcast(Entity entity) {
        return helpEntityDowncastInternally(entity, CrudTable.class);
    }

    protected CrudTableCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, CrudTableCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<CrudTable> downcast(List<? extends Entity> entityList) {
        return (List<CrudTable>)entityList;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<CrudTableCB> downcast(InsertOption<? extends ConditionBean> option) {
        return (InsertOption<CrudTableCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<CrudTableCB> downcast(UpdateOption<? extends ConditionBean> option) {
        return (UpdateOption<CrudTableCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<CrudTableCB> downcast(DeleteOption<? extends ConditionBean> option) {
        return (DeleteOption<CrudTableCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<CrudTable, CrudTableCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> option) {
        return (QueryInsertSetupper<CrudTable, CrudTableCB>)option;
    }
}
