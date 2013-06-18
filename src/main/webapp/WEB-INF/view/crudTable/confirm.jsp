<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%-- CRUD: BEGIN
#set($D = '$')
     CRUD: END --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
<div class="content">

<!-- Message: BEGIN -->
<div><html:messages id="msg" message="true"><bean:write name="msg" ignore="true"/></html:messages><html:errors/></div>
<!-- Message: END -->

<!-- Confirm Form: BEGIN -->
	<s:form>
		<html:hidden property="crudMode"/>
		<div class="form-table">
		<table>
			<caption><bean:message key="labels.crud_title_confirm"/></caption>
			<tbody>

<%-- CRUD COMMENT: BEGIN --%>
<!-- Primary: BEGIN -->
<c:if test="${crudMode==2 || crudMode==3 || crudMode==4}">
                <tr>
                    <th>id</th>
                    <td>${f:h(id)}<html:hidden property="id"/></td>
                </tr>
</c:if>
<!-- Primary: END -->
                <tr>
                    <th>value</th>
                    <td>${f:h(value)}<html:hidden property="value"/></td>
                </tr>
<%-- CRUD COMMENT: END --%>
<%-- CRUD: BEGIN
	#foreach( $column in ${table.getColumnList()} )
		#if(${column.primaryKey})
<c:if test="${crudMode==2 || crudMode==3 || crudMode==4}">
                <tr>
                    <th>${column.name}</th>
                    <td>${f:h(${column.propertyName})}<html:hidden property="${column.propertyName}"/></td>
                </tr>
</c:if>
		#else
                <tr>
                    <th>${column.name}</th>
                    <td>${f:h(${column.propertyName})}<html:hidden property="${column.propertyName}"/></td>
                </tr>
		#end
	#end
     CRUD: END --%>

			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
        <c:if test="${crudMode == 1}">
            <input type="submit" name="create" value="<bean:message key="labels.crud_button_create"/>"/>
            <input type="submit" name="editagain" value="<bean:message key="labels.crud_button_back"/>"/>
        </c:if>
        <c:if test="${crudMode == 2}">
            <input type="submit" name="update" value="<bean:message key="labels.crud_button_update"/>"/>
            <input type="submit" name="editagain" value="<bean:message key="labels.crud_button_back"/>"/>
        </c:if>
        <c:if test="${crudMode == 3}">
            <input type="submit" name="delete" value="<bean:message key="labels.crud_button_delete"/>"/>
            <input type="submit" name="back" value="<bean:message key="labels.crud_button_back"/>"/>
        </c:if>
        <c:if test="${crudMode == 4}">
            <input type="submit" name="back" value="<bean:message key="labels.crud_button_back"/>"/>
            <input type="submit" name="editfromconfirm" value="<bean:message key="labels.crud_button_edit"/>"/>
            <input type="submit" name="deletefromconfirm" value="<bean:message key="labels.crud_button_delete"/>"/>
        </c:if>
					</td>
				</tr>
			</tfoot>
		</table>
		</div>
	</s:form>
<!-- Confirm Form: BEGIN -->

</div>

</body>
</html>
