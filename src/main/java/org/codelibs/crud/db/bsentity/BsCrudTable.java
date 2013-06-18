package org.codelibs.crud.db.bsentity;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.Entity;
import org.codelibs.crud.db.allcommon.DBMetaInstanceHandler;
import org.codelibs.crud.db.exentity.*;

/**
 * The entity of crud_table as TABLE. <br />
 * <pre>
 * [primary-key]
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
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long id = entity.getId();
 * String name = entity.getName();
 * String value = entity.getValue();
 * Integer sortOrder = entity.getSortOrder();
 * java.sql.Timestamp createdTime = entity.getCreatedTime();
 * entity.setId(id);
 * entity.setName(name);
 * entity.setValue(value);
 * entity.setSortOrder(sortOrder);
 * entity.setCreatedTime(createdTime);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsCrudTable implements Entity, Serializable, Cloneable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** id: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _id;

    /** name: {VARCHAR(20)} */
    protected String _name;

    /** value: {VARCHAR(50)} */
    protected String _value;

    /** sort_order: {INT(10)} */
    protected Integer _sortOrder;

    /** created_time: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]} */
    protected java.sql.Timestamp _createdTime;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The modified properties for this entity. (NotNull) */
    protected final EntityModifiedProperties __modifiedProperties = newModifiedProperties();

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    public String getTableDbName() {
        return "crud_table";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "crudTable";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * {@inheritDoc}
     */
    public DBMeta getDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(getTableDbName());
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    /**
     * {@inheritDoc}
     */
    public boolean hasPrimaryKeyValue() {
        if (getId() == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                 Modified Properties
    //                                                                 ===================
    /**
     * {@inheritDoc}
     */
    public Set<String> modifiedProperties() {
        return __modifiedProperties.getPropertyNames();
    }

    /**
     * {@inheritDoc}
     */
    public void clearModifiedInfo() {
        __modifiedProperties.clear();
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasModification() {
        return !__modifiedProperties.isEmpty();
    }

    protected EntityModifiedProperties newModifiedProperties() {
        return new EntityModifiedProperties();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * Determine the object is equal with this. <br />
     * If primary-keys or columns of the other are same as this one, returns true.
     * @param other The other entity. (NullAllowed: if null, returns false fixedly)
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsCrudTable)) { return false; }
        BsCrudTable otherEntity = (BsCrudTable)other;
        if (!xSV(getId(), otherEntity.getId())) { return false; }
        return true;
    }
    protected boolean xSV(Object value1, Object value2) { // isSameValue()
        return InternalUtil.isSameValue(value1, value2);
    }

    /**
     * Calculate the hash-code from primary-keys or columns.
     * @return The hash-code from primary-key or columns.
     */
    public int hashCode() {
        int result = 17;
        result = xCH(result, getTableDbName());
        result = xCH(result, getId());
        return result;
    }
    protected int xCH(int result, Object value) { // calculateHashcode()
        return InternalUtil.calculateHashcode(result, value);
    }

    /**
     * {@inheritDoc}
     */
    public int instanceHash() {
        return super.hashCode();
    }

    /**
     * Convert to display string of entity's data. (no relation data)
     * @return The display string of all columns and relation existences. (NotNull)
     */
    public String toString() {
        return buildDisplayString(InternalUtil.toClassTitle(this), true, true);
    }

    /**
     * {@inheritDoc}
     */
    public String toStringWithRelation() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    public String buildDisplayString(String name, boolean column, boolean relation) {
        StringBuilder sb = new StringBuilder();
        if (name != null) { sb.append(name).append(column || relation ? ":" : ""); }
        if (column) { sb.append(buildColumnString()); }
        if (relation) { sb.append(buildRelationString()); }
        sb.append("@").append(Integer.toHexString(hashCode()));
        return sb.toString();
    }
    protected String buildColumnString() {
        StringBuilder sb = new StringBuilder();
        String delimiter = ", ";
        sb.append(delimiter).append(getId());
        sb.append(delimiter).append(getName());
        sb.append(delimiter).append(getValue());
        sb.append(delimiter).append(getSortOrder());
        sb.append(delimiter).append(getCreatedTime());
        if (sb.length() > delimiter.length()) {
            sb.delete(0, delimiter.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String buildRelationString() {
        return "";
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    public CrudTable clone() {
        try {
            return (CrudTable)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] id: {PK, ID, NotNull, BIGINT(19)} <br />
     * @return The value of the column 'id'. (basically NotNull if selected: for the constraint)
     */
    public Long getId() {
        return _id;
    }

    /**
     * [set] id: {PK, ID, NotNull, BIGINT(19)} <br />
     * @param id The value of the column 'id'. (basically NotNull if update: for the constraint)
     */
    public void setId(Long id) {
        __modifiedProperties.addPropertyName("id");
        this._id = id;
    }

    /**
     * [get] name: {VARCHAR(20)} <br />
     * @return The value of the column 'name'. (NullAllowed even if selected: for no constraint)
     */
    public String getName() {
        return _name;
    }

    /**
     * [set] name: {VARCHAR(20)} <br />
     * @param name The value of the column 'name'. (NullAllowed: null update allowed for no constraint)
     */
    public void setName(String name) {
        __modifiedProperties.addPropertyName("name");
        this._name = name;
    }

    /**
     * [get] value: {VARCHAR(50)} <br />
     * @return The value of the column 'value'. (NullAllowed even if selected: for no constraint)
     */
    public String getValue() {
        return _value;
    }

    /**
     * [set] value: {VARCHAR(50)} <br />
     * @param value The value of the column 'value'. (NullAllowed: null update allowed for no constraint)
     */
    public void setValue(String value) {
        __modifiedProperties.addPropertyName("value");
        this._value = value;
    }

    /**
     * [get] sort_order: {INT(10)} <br />
     * @return The value of the column 'sort_order'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getSortOrder() {
        return _sortOrder;
    }

    /**
     * [set] sort_order: {INT(10)} <br />
     * @param sortOrder The value of the column 'sort_order'. (NullAllowed: null update allowed for no constraint)
     */
    public void setSortOrder(Integer sortOrder) {
        __modifiedProperties.addPropertyName("sortOrder");
        this._sortOrder = sortOrder;
    }

    /**
     * [get] created_time: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]} <br />
     * @return The value of the column 'created_time'. (basically NotNull if selected: for the constraint)
     */
    public java.sql.Timestamp getCreatedTime() {
        return _createdTime;
    }

    /**
     * [set] created_time: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]} <br />
     * @param createdTime The value of the column 'created_time'. (basically NotNull if update: for the constraint)
     */
    public void setCreatedTime(java.sql.Timestamp createdTime) {
        __modifiedProperties.addPropertyName("createdTime");
        this._createdTime = createdTime;
    }
}
