package org.codelibs.crud.db.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import org.codelibs.crud.db.allcommon.*;
import org.codelibs.crud.db.exentity.*;

/**
 * The DB meta of crud_table. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class CrudTableDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final CrudTableDbm _instance = new CrudTableDbm();
    private CrudTableDbm() {}
    public static CrudTableDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgId(), "id");
        setupEpg(_epgMap, new EpgName(), "name");
        setupEpg(_epgMap, new EpgValue(), "value");
        setupEpg(_epgMap, new EpgSortOrder(), "sortOrder");
        setupEpg(_epgMap, new EpgCreatedTime(), "createdTime");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgId implements PropertyGateway {
        public Object read(Entity e) { return ((CrudTable)e).getId(); }
        public void write(Entity e, Object v) { ((CrudTable)e).setId(ctl(v)); }
    }
    public static class EpgName implements PropertyGateway {
        public Object read(Entity e) { return ((CrudTable)e).getName(); }
        public void write(Entity e, Object v) { ((CrudTable)e).setName((String)v); }
    }
    public static class EpgValue implements PropertyGateway {
        public Object read(Entity e) { return ((CrudTable)e).getValue(); }
        public void write(Entity e, Object v) { ((CrudTable)e).setValue((String)v); }
    }
    public static class EpgSortOrder implements PropertyGateway {
        public Object read(Entity e) { return ((CrudTable)e).getSortOrder(); }
        public void write(Entity e, Object v) { ((CrudTable)e).setSortOrder(cti(v)); }
    }
    public static class EpgCreatedTime implements PropertyGateway {
        public Object read(Entity e) { return ((CrudTable)e).getCreatedTime(); }
        public void write(Entity e, Object v) { ((CrudTable)e).setCreatedTime((java.sql.Timestamp)v); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "crud_table";
    protected final String _tablePropertyName = "crudTable";
    protected final TableSqlName _tableSqlName = new TableSqlName("crud_table", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnId = cci("id", "id", null, null, true, "id", Long.class, true, true, "BIGINT", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnName = cci("name", "name", null, null, false, "name", String.class, false, false, "VARCHAR", 20, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnValue = cci("value", "value", null, null, false, "value", String.class, false, false, "VARCHAR", 50, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnSortOrder = cci("sort_order", "sort_order", null, null, false, "sortOrder", Integer.class, false, false, "INT", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnCreatedTime = cci("created_time", "created_time", null, null, true, "createdTime", java.sql.Timestamp.class, false, false, "TIMESTAMP", 19, 0, "CURRENT_TIMESTAMP", false, null, null, null, null, null);

    public ColumnInfo columnId() { return _columnId; }
    public ColumnInfo columnName() { return _columnName; }
    public ColumnInfo columnValue() { return _columnValue; }
    public ColumnInfo columnSortOrder() { return _columnSortOrder; }
    public ColumnInfo columnCreatedTime() { return _columnCreatedTime; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnId());
        ls.add(columnName());
        ls.add(columnValue());
        ls.add(columnSortOrder());
        ls.add(columnCreatedTime());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "org.codelibs.crud.db.exentity.CrudTable"; }
    public String getConditionBeanTypeName() { return "org.codelibs.crud.db.cbean.CrudTableCB"; }
    public String getDaoTypeName() { return "${glPackageExtendedDao}.CrudTableDao"; }
    public String getBehaviorTypeName() { return "org.codelibs.crud.db.exbhv.CrudTableBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<CrudTable> getEntityType() { return CrudTable.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public CrudTable newMyEntity() { return new CrudTable(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptPrimaryKeyMap((CrudTable)e, m); }
    public void acceptAllColumnMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptAllColumnMap((CrudTable)e, m); }
    public Map<String, Object> extractPrimaryKeyMap(Entity e) { return doExtractPrimaryKeyMap(e); }
    public Map<String, Object> extractAllColumnMap(Entity e) { return doExtractAllColumnMap(e); }
}
