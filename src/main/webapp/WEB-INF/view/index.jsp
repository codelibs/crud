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

<h3>DB Access</h3>
<ul>
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

</body>
</html>
