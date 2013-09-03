<%@tag%>
<%@ attribute name="title" required="true" %>
<html>
<head>
<title>${title}</title>
</head>
<body>
<h1>${title}</h1>
<jsp:doBody />
</body>
</html>