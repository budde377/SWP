<html>
	<head><title>QuickPoll</title></head>
	<body>
   		<h1>QuickPoll</h1>
   		${requestScope.question}?<p>
           <form method=post action=vote>
             	<input name=vote type=radio value=yes> yes<br>
             	<input name=vote type=radio value=no> no<p>
             	<input type=submit name=submit value=Vote>
           </form>
  	</body>
</html>