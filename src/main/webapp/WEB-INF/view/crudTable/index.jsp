<%-- CRUD: BEGIN
#set($D = '$')
     CRUD: END --%><%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %><%--
--%><!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title><bean:message key="labels.crud_page_title"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<link href="${f:url('/css/bootstrap.css')}" rel="stylesheet">
		<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
.sidebar-nav {
	padding: 9px 0;
}

@media (max-width: 980px) {
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
		</style>
		<link href="${f:url('/css/bootstrap-responsive.css')}" rel="stylesheet">

		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
			<script src="${f:url('/js/html5shiv.js')}"></script>
		<![endif]-->
	</head>


	<body>

		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">
					<s:link href="../index" styleClass="brand"><bean:message key="labels.crud_brand_name"/></s:link>
				</div>
			</div>
		</div>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span3">
					<div class="well sidebar-nav">
						<ul class="nav nav-list">
							<li class="nav-header"><bean:message key="labels.crud_menu_table"/></li>
<%-- CRUD COMMENT: BEGIN --%>
							<li><s:link href="../crudTable/index">crudTable</s:link></li>
<%-- CRUD COMMENT: END --%>
<%-- CRUD: BEGIN
#foreach( $table in ${database.getTableList()} )
							<li><s:link href="../${table.propertyName}/index">crudTable</s:link></li>
#end
     CRUD: END --%>
						</ul>
					</div>
				</div>
				<div class="span9">

					<ul class="nav nav-tabs">
						<li class="active">
							<a href="#"><bean:message key="labels.crud_link_list"/></a>
						</li>
						<li><s:link href="createpage"><bean:message key="labels.crud_link_create_new"/></s:link></li>
					</ul>

<%-- Message: BEGIN --%>
					<html:messages id="msg" message="true"><div class="alert alert-info"><bean:write name="msg" ignore="true"/></div></html:messages>
					<html:errors/>
<%-- Message: END --%>

<%-- Search: BEGIN --%>
					<div class="accordion" id="conditionAccodion">
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#conditionAccodion" href="#conditionCollapse">
									<bean:message key="labels.crud_search_condition_title"/>
								</a>
							</div>
							<div id="conditionCollapse" class="accordion-body collapse<c:if test="${crudTablePager.hasParams()}"> in</c:if>">
								<div class="accordion-inner">

									<s:form styleClass="form-horizontal">
<%-- CRUD COMMENT: BEGIN --%>
										<div class="control-group">
											<label class="control-label" for="idInput">ID</label>
											<div class="controls">
												<html:text property="searchParams.id" styleId="idInput"></html:text>
											</div>
										</div>
<%-- CRUD COMMENT: END --%>
<%-- CRUD: BEGIN
#foreach( $column in ${table.getColumnList()} )
										<div class="control-group">
											<label class="control-label" for="${column.propertyName}Input">${column.name}</label>
											<div class="controls">
												<html:text property="searchParams.${column.propertyName}" styleId="${column.propertyName}Input"></html:text>
											</div>
										</div>
#end
     CRUD: END --%>
										<div class="control-group">
											<div class="controls">
												<input type="submit" name="search" value="<bean:message key="labels.crud_button_search"/>" class="btn btn-primary"/>
												<input type="submit" name="reset" value="<bean:message key="labels.crud_button_reset"/>" class="btn"/>
											</div>
										</div>
									</s:form>

								</div>
							</div>
						</div>
					</div>
<%-- Search: END --%>

<%-- List: BEGIN --%>
					<div class="text-left" style="height:0;">
						<span class="label label-info">${crudTablePager.currentPageNumber}/${crudTablePager.allPageCount}</span>
					</div>
					<p class="text-right">
						<span class="badge badge-info">${crudTablePager.allRecordCount}</span>
					</p>
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
<%-- CRUD COMMENT: BEGIN --%>
								<th>id</th>
								<th>value</th>
<%-- CRUD COMMENT: END --%>
<%-- CRUD: BEGIN
#foreach( $column in ${table.getColumnList()} )##
								<th>${column.name}</th>
#end##
     CRUD: END --%>
								<th>&nbsp;</th>
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
#foreach( $column in ${table.getColumnList()} )##
	#if(${column.primaryKey})##
								<td><s:link href="confirmpage/4#foreach( $col in ${table.getColumnList()} )#if(${col.primaryKey})/${f:u(data.${col.propertyName})}#end#end">${f:h(data.${column.propertyName})}</s:link></td>
	#else##
								<td>${f:h(data.${column.propertyName})}</td>
	#end##
#end##
     CRUD: END --%>
								<td>
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
<%-- Page Navigation: BEGIN --%>
					<div class="pagination pagination-centered">
						<ul>
						<c:if test="${crudTablePager.existPrePage}">
							<li>
								<s:link href="list/${crudTablePager.currentPageNumber - 1}"><bean:message key="labels.crud_link_prev_page"/></s:link>
							</li>
						</c:if>
						<c:forEach var="p" varStatus="s" items="${crudTablePager.pageNumberList}">
							<c:if test="${p == crudTablePager.currentPageNumber}">
							<li class="disabled"><a href="#">${p}</a></li>
							</c:if>
							<c:if test="${p != crudTablePager.currentPageNumber}">
							<li class="active"><s:link href="list/${p}">${p}</s:link></li>
							</c:if>
						</c:forEach>
						<c:if test="${crudTablePager.existNextPage}">
							<li>
								<s:link href="list/${crudTablePager.currentPageNumber + 1}"><bean:message key="labels.crud_link_next_page"/></s:link>
							</li>
						</c:if>
						</ul>
					</div>
<%-- Page Navigation: END --%>
<%-- List: END --%>


				</div>
			</div>

			<hr>

			<footer>
				<p><bean:message key="labels.crud_copyright"/></p>
			</footer>

		</div>

		<script src="${f:url('/js/jquery.min.js')}"></script>
		<script src="${f:url('/js/bootstrap.min.js')}"></script>

	</body>
</html>
