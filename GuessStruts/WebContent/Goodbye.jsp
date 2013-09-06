<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>The Number Guessing Game</title>
  </head>
  <body>
    <h3>The Number Guessing Game</h3>      
    You used <s:property value="#session['guesses']"/> guesses.
    <p>
    The highscore is <s:property value="#application['hiname']"/>
    with <s:property value="#application['hiscore']"/> guesses.
  </body>
</html>
