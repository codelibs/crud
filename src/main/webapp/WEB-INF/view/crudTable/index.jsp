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

<!-- Search: BEGIN -->
<div class="form-table">
<s:form>
<table>
	<tbody>
		<tr>
			<td>
				<table><tbody>
<%-- CRUD COMMENT: BEGIN --%>
					<tr>
						<th>ID:</th>
						<td><html:text property="searchParams.id"></html:text></td>
					</tr>
<%-- CRUD COMMENT: END --%>
<%-- CRUD: BEGIN
	#foreach( $column in ${table.getColumnList()} )
		#if(${column.primaryKey})
					<tr>
						<th>${column.name}:</th>
						<td><html:text property="searchParams.${column.propertyName}"></html:text></td>
					</tr>
		#end
	#end
     CRUD: END --%>

				</tbody></table>
			</td>
			<td>
				<input type="submit" name="search" value="<bean:message key="labels.crud_button_search"/>"/>
				<input type="submit" name="reset" value="<bean:message key="labels.crud_button_reset"/>"/>
			</td>
		</tr>
	</tbody>
</table>
</s:form>
</div>
<!-- Search: END -->

<!-- List: BEGIN -->
<div class="list-table">
<div>
<s:link href="createpage"><bean:message key="labels.crud_link_create_new"/></s:link>
</div>
<table border="1">
	<thead>
		<tr>
<%-- CRUD COMMENT: BEGIN --%>
			<th style="text-align: center;">id</th>
			<th style="text-align: center;">value</th>
<%-- CRUD COMMENT: END --%>
<%-- CRUD: BEGIN
	#foreach( $column in ${table.getColumnList()} )
			<th style="text-align: center;">${column.name}</th>
	#end
     CRUD: END --%>
			<th style="text-align: center;">&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="data" varStatus="s" items="${crudTableItems}">
		<tr class="${s.index % 2 == 0 ? 'row1' : 'row2'}">

<%-- CRUD COMMENT: BEGIN --%>
			<td><s:link href="confirmpage/4/${f:u(data.id)}">${f:h(data.id)}</s:link></td>
			<td>${f:h(data.value)}</td>
<%-- CRUD COMMENT: END --%>
<%-- CRUD: BEGIN
	#foreach( $column in ${table.getColumnList()} )
		#if(${column.primaryKey})
			<td><s:link href="confirmpage/4#foreach( $col in ${table.getColumnList()} )#if(${col.primaryKey})/${f:u(data.${col.propertyName})}#end#end">${f:h(data.${column.propertyName})}</s:link></td>
		#else
			<td>${f:h(data.${column.propertyName})}</td>
		#end
	#end
     CRUD: END --%>

			<td align="center">
<%-- CRUD COMMENT: BEGIN --%>
				<s:link href="editpage/2/${f:u(data.id)}"><bean:message key="labels.crud_link_edit"/></s:link>
				<s:link href="deletepage/3/${f:u(data.id)}"><bean:message key="labels.crud_link_delete"/></s:link>
<%-- CRUD COMMENT: END --%>
<%-- CRUD: BEGIN
				<s:link href="editpage/2#foreach( $col in ${table.getColumnList()} )#if(${col.primaryKey})/${f:u(data.${col.propertyName})}#end#end"><bean:message key="labels.crud_link_edit"/></s:link>
				<s:link href="deletepage/3#foreach( $col in ${table.getColumnList()} )#if(${col.primaryKey})/${f:u(data.${col.propertyName})}#end#end"><bean:message key="labels.crud_link_delete"/></s:link>
     CRUD: END --%>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<!-- Page Navigation: BEGIN -->
<div>
	<span>
		<c:if test="${crudTablePager.existPrePage}">
		<s:link href="list/${crudTablePager.currentPageNumber - 1}"><bean:message key="labels.crud_link_prev_page"/></s:link>
		</c:if>
	</span>
	<span>
		<c:forEach var="p" varStatus="s" items="${crudTablePager.pageNumberList}">
		<span>
			<c:if test="${p == crudTablePager.currentPageNumber}">
			${p}
			</c:if>
			<c:if test="${p != crudTablePager.currentPageNumber}">
			<s:link href="list/${p}">${p}</s:link>
			</c:if>
		</span>
		</c:forEach>
	</span>
	<span>
		<c:if test="${crudTablePager.existNextPage}">
		<s:link href="list/${crudTablePager.currentPageNumber + 1}"><bean:message key="labels.crud_link_next_page"/></s:link>
		</c:if>
	</span>
</div>
<div>
	<span>
		${crudTablePager.currentPageNumber}/${crudTablePager.allPageCount} (${crudTablePager.allRecordCount})
	</span>
</div>
<!-- Page Navigation: END -->
</div>
<!-- List: END -->

</div>

</body>
</html>
