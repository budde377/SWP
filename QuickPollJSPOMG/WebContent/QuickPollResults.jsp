<html>
	<head><title>QuickPoll</title></head>
	<body>
    <h1>QuickPoll</h1>
    ${requestScope.question}?<p>
    	<table border=0>
        	<tr><td>Yes:<td><table><tr><td bgcolor=black height=20 width="${requestScope.yes*300/(requestScope.yes+requestScope.no)}"></table><td>yes
        	<tr><td>No:<td><table><tr><td bgcolor=black height=20 width="${requestScope.no*300/(requestScope.yes+requestScope.no)}"></table><td>no
        </table>
    </body>
</html>