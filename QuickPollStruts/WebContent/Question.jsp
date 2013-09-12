<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>QuickPoll</title>
  </head>
  <body>
    <h3>QuickPoll</h3>      
    <s:form action="Setup">
      What is your question?<br />
      <p>
      <s:textfield name="question"/>
      <s:submit/>
    </s:form>
  </body>
</html>
