<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>
    <title>PDF Box Ticking Service</title>
</head>
<body>

<h2>PDF Box Ticking Service</h2>
<form:form method="post" commandName="fill">

<br/>

<form:label path="template">PDF Template</form:label>
<form:input path="template" />

<br/>

<form:label path="values">FDF Values</form:label>
<form:textarea path="values" />

<br/>

<input type="submit" value="Get PDF" />

</form:form>
</body>
</html>