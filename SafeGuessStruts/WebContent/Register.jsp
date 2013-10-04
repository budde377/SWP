<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>The Number Guessing Game</title>
  </head>
  <body>
    <h3>The Number Guessing Game</h3>      
    <s:form action="Update">
      You have the new highscore of 
      <s:property value="#session['guesses']"/> guesses!
      <p>
      Please enter your name:
      <s:textfield name="name"/>
      <s:hidden name="token" value="%{#session['token']}"/>
      <s:submit value="Register"/>
    </s:form>
  </body>
</html>
