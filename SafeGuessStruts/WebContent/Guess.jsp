<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>The Number Guessing Game</title>
  </head>
  <body>
    <h3>The Number Guessing Game</h3>      
    <s:form action="Evaluate">
      <s:property value="message"/>.
      <p>
      <s:hidden name="token" value="%{#session['token']}"/>
      <s:textfield name="number"/>
      <s:submit value="Guess"/>
    </s:form>
  </body>
</html>