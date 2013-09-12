<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>QuickPoll</title>
  </head>
  <body>
    <h3>QuickPoll</h3>      
    <s:form action="Vote">
      <s:property value="#application['question']"/> <br />
      <p>
      <s:radio list="yesNo" name="vote"/>
      <s:submit/>
    </s:form>
  </body>
</html>
