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
.control-value {
	float:left;
	padding-top:5px;
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
						<li><s:link href="index"><bean:message key="labels.crud_link_list"/></s:link></li>
						<li class="active">
						<c:if test="${crudMode==1}">
							<a href="#"><bean:message key="labels.crud_link_create_new"/></a>
						</c:if>
						<c:if test="${crudMode==2}">
							<a href="#"><bean:message key="labels.crud_link_edit"/></a>
						</c:if>
						</li>
					</ul>

<%-- Message: BEGIN --%>
					<html:messages id="msg" message="true"><div class="alert alert-info"><bean:write name="msg" ignore="true"/></div></html:messages>
					<html:errors/>
<%-- Message: END --%>

<%-- Edit Form: BEGIN --%>
					<s:form styleClass="form-horizontal">
						<html:hidden property="crudMode"/>
<%-- CRUD COMMENT: BEGIN --%>
<%-- Primary: BEGIN --%>
<c:if test="${crudMode==2}">
						<div class="control-group">
							<label class="control-label" for="idInput">id</label>
							<div class="controls">
								<span class="control-value">${f:h(id)}</span>
							</div>
						</div>
						<html:hidden property="id" styleId="idInput"/>
</c:if>
<%-- Primary: END --%>
						<div class="control-group">
							<label class="control-label" for="valueInput">value</label>
							<div class="controls">
								<html:text property="value" styleId="valueInput"/>
							</div>
						</div>
<%-- CRUD COMMENT: END --%>
<%-- CRUD: BEGIN
#foreach( $column in ${table.getColumnList()} )##
	#if(${column.primaryKey})##
<c:if test="${crudMode==2}">
						<div class="control-group">
							<label class="control-label" for="${column.propertyName}Input">${column.name}</label>
							<div class="controls">
								<span class="control-value">${f:h(${column.propertyName})}</span>
							</div>
						</div>
						<html:hidden property="${column.propertyName}" styleId="${column.propertyName}Input"/>
</c:if>
	#else##
						<div class="control-group">
							<label class="control-label" for="${column.propertyName}Input">${column.name}</label>
							<div class="controls">
								<html:text property="${column.propertyName}" styleId="${column.propertyName}Input"/>
							</div>
						</div>
	#end##
#end##
     CRUD: END --%>

						<div class="form-actions">
							<c:if test="${crudMode == 1}">
								<input type="submit" name="confirmfromcreate" value="<bean:message key="labels.crud_button_create"/>" class="btn btn-primary"/>
								<input type="submit" name="back" value="<bean:message key="labels.crud_button_back"/>" class="btn"/>
							</c:if>
							<c:if test="${crudMode == 2}">
								<input type="submit" name="confirmfromupdate" value="<bean:message key="labels.crud_button_confirm"/>" class="btn btn-primary"/>
								<input type="submit" name="back" value="<bean:message key="labels.crud_button_back"/>" class="btn"/>
							</c:if>
						</div>
					</s:form>
<%-- Edit Form: BEGIN --%>

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
