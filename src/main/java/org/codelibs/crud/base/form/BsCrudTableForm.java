package org.codelibs.crud.base.form;

import java.util.HashMap;
import java.util.Map;

import org.seasar.struts.annotation.ByteType;
import org.seasar.struts.annotation.DateType;
import org.seasar.struts.annotation.DoubleType;
import org.seasar.struts.annotation.FloatType;
import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.LongType;
import org.seasar.struts.annotation.Maxbytelength;
import org.seasar.struts.annotation.Required;
import org.seasar.struts.annotation.ShortType;

    /* CRUD: BEGIN
#if(${table.importPackages})${table.importPackages}#end##
       CRUD: END */

public abstract class BsCrudTableForm {
    @IntegerType
    public String pageNumber;

    public Map<String, String> searchParams = new HashMap<String, String>();

    @IntegerType
    public int crudMode;

    public String getCurrentPageNumber() {
        return pageNumber;
    }

    /* CRUD COMMENT: BEGIN */

    @Required(target = "confirmfromupdate,update,delete")
    @LongType
    public String id;

    @Maxbytelength(maxbytelength = 100)
    public String value;

    /* CRUD COMMENT: END */

    /* CRUD: BEGIN
#foreach( $column in ${table.getColumnList()} )##
  #if(${column.annotation})##
    ${column.annotation}
  #else##
    #if(${column.primaryKey})##
      #if(${column.required})##
@Required##
        #if(${column.requiredParam})##
${column.requiredParam}
        #else##
(target = "confirmfromupdate,update,delete")
        #end##
      #end##
    #else##
      #if(${column.required})##
@Required##
        #if(${column.requiredParam})##
${column.requiredParam}
        #else##
(target = "confirmfromcreate,create,confirmfromupdate,update,delete")
        #end##
      #end##
    #end##
    #if(${column.enableJavaType})##
      #if(${column.javaType} == "Long")@LongType#if(${column.longTypeParam})${column.longTypeParam}#end#end##
      #if(${column.javaType} == "Integer")@IntegerType#if(${column.integerTypeParam})${column.integerTypeParam}#end#end##
      #if(${column.javaType} == "Short")@ShortType#if(${column.shortTypeParam})${column.shortTypeParam}#end#end##
      #if(${column.javaType} == "Byte")@ByteType#if(${column.byteTypeParam})${column.byteTypeParam}#end#end##
      #if(${column.javaType} == "Float")@FloatType#if(${column.floatTypeParam})${column.floatTypeParam}#end#end##
      #if(${column.javaType} == "Double")@DoubleType#if(${column.doubleTypeParam})${column.doubleTypeParam}#end#end##
      #if(${column.javaType} == "java.sql.Timestamp")@DateType#if(${column.dateTypeParam})${column.dateTypeParam}#end#end##
    #end##
  #end##
  #if(${column.additionalAnnotation})##
    ${column.additionalAnnotation}
  #end##
    public String ${column.propertyName};
#end
       CRUD: END */

    public void initialize() {
        /* CRUD: BEGIN
#foreach( $column in ${table.getColumnList()} )
        ${column.propertyName} = 
  #if(${column.defaultValue})##
${column.defaultValue}##
  #else##
null##
  #end##
;
#end
           CRUD: END */
    }

}
