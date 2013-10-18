#!/bin/sh

TARGET_DIR=$1

cd `dirname $0`
cd ../../..
BASE_DIR=`pwd`

for file in `ffg $BASE_DIR/src/main/java/org/codelibs/crud/ | grep -v /db/` ; do
    newfile=`echo $file | sed -e "s/.*\/src\/main\/java\/org\/codelibs\/crud\///" -e "s/\.java/\.vm/"`
    echo "Copying $newfile.."
    newfile="$TARGET_DIR/template/sastruts/java/$newfile"
    mkdir -p `dirname $newfile`
    cp $file $newfile
    perl -pi -e 's/CrudTable/\${table.className}/g' $newfile
    perl -pi -e 's/crudTable/\${table.propertyName}/g' $newfile
    perl -pi -e 's/org.codelibs.crud.base.action/\${crudContext.baseActionPackage}/g' $newfile
    perl -pi -e 's/org.codelibs.crud.base.form/\${crudContext.baseFormPackage}/g' $newfile
    perl -pi -e 's/org.codelibs.crud.base.pager/\${crudContext.basePagerPackage}/g' $newfile
    perl -pi -e 's/org.codelibs.crud.base.service/\${crudContext.baseServicePackage}/g' $newfile
    perl -pi -e 's/org.codelibs.crud.base/\${crudContext.basePackage}/g' $newfile
    perl -pi -e 's/org.codelibs.crud.action/\${crudContext.actionPackage}/g' $newfile
    perl -pi -e 's/org.codelibs.crud.db/\${crudContext.dbPackage}/g' $newfile
    perl -pi -e 's/org.codelibs.crud.form/\${crudContext.formPackage}/g' $newfile
    perl -pi -e 's/org.codelibs.crud.pager/\${crudContext.pagerPackage}/g' $newfile
    perl -pi -e 's/org.codelibs.crud.service/\${crudContext.servicePackage}/g' $newfile
    perl -pi -e 's/org.codelibs.crud/\${crudContext.rootPackage}/g' $newfile
    perl -pi -e 's/\/\* CRUD COMMENT: BEGIN \*\//\#\*/g' $newfile
    perl -pi -e 's/\/\* CRUD COMMENT: END \*\//\*\#/g' $newfile
    perl -pi -e 's/\/\* CRUD: BEGIN//g' $newfile
    perl -pi -e 's/CRUD: END \*\///g' $newfile
done

for file in `ffg ../crud/src/main/webapp/WEB-INF/view/` ; do
    newfile=`echo $file | sed -e "s/.*\/src\/main\/webapp\/WEB-INF\/view\///" -e "s/\.jsp/\.vm/"`
    echo "Copying $newfile.."
    newfile="$TARGET_DIR/template/sastruts/webapp/WEB-INF/view/$newfile"
    mkdir -p `dirname $newfile`
    cp $file $newfile
    perl -pi -e 's/CrudTable/\${table.className}/g' $newfile
    perl -pi -e 's/crudTable/\${table.propertyName}/g' $newfile
    perl -pi -e 's/\$\{\$\{/__D__\{\$\{/g' $newfile
    perl -pi -e 's/\$\{f:/__D__\{f:/g' $newfile
    perl -pi -e 's/test=\"\$/test=\"__D__/g' $newfile
    perl -pi -e 's/class=\"\$/class=\"__D__/g' $newfile
    perl -pi -e 's/\<\%-- CRUD COMMENT: BEGIN --\%\>/\#\*/g' $newfile
    perl -pi -e 's/\<\%-- CRUD COMMENT: END --\%\>/\*\#/g' $newfile
    perl -pi -e 's/\<\%-- CRUD: BEGIN//g' $newfile
    perl -pi -e 's/CRUD: END --\%\>//g' $newfile
    perl -pi -e 's/__D__/\$\{D\}/g' $newfile
done

for file in `ffg ../crud/src/main/resources application` ; do
    newfile=`echo $file | sed -e "s/.*\/src\/main\/resources\///"`
    echo "Copying $newfile.."
    newfile="$TARGET_DIR/template/sastruts/resources/$newfile"
    mkdir -p `dirname $newfile`
    cp $file $newfile
    echo "# CRUD PROPERTIES: BEGIN" > $newfile
    sed -e "1,/# CRUD PROPERTIES: BEGIN/d" -e "/# CRUD PROPERTIES: END/,\$d" $file >> $newfile
    echo "# CRUD PROPERTIES: END" >> $newfile
done

cd src/main/webapp
TEMP_ZIP_FILE=/tmp/webresource.zip
zip $TEMP_ZIP_FILE `find css img js -type f`
cd ../../..
mv $TEMP_ZIP_FILE $TARGET_DIR/template/sastruts

