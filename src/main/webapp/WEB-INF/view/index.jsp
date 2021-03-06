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
					<a class="brand" href="#"><bean:message key="labels.crud_brand_name"/></a>
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
							<li><s:link href="crudTable/index">crudTable</s:link></li>
<%-- CRUD COMMENT: END --%>
<%-- CRUD: BEGIN
#foreach( $table in ${database.getTableList()} )
							<li><s:link href="${table.propertyName}/index">crudTable</s:link></li>
#end
     CRUD: END --%>
						</ul>
					</div>
				</div>
				<div class="span9">
					<div class="hero-unit">
						<h1><bean:message key="labels.crud_hero_title"/></h1>
						<p><bean:message key="labels.crud_hero_message"/></p>
					</div>
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
