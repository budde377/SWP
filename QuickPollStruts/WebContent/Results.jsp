<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>QuickPoll</title>
  </head>
  <body>
    <h3>QuickPoll</h3>      
			<s:property value="#application['question']"/>?
        	<table >
					<tr>
						<td>Yes:</td>
						<td>
							<table>
								<tr>
									<td bgcolor="black" height="20"
										width="<s:property value="yesLength" />"></td>
								</tr>
							</table>
						</td>
						<td><s:property value="#application['yes']" /></td>
					</tr>
					<tr>
						<td>No:</td>
						<td>
							<table>
								<tr>
									<td bgcolor="black" height="20"
										width="<s:property value="noLength" />"></td>
								</tr>
							</table>
						</td>
						<td><s:property value="#application['no']" /></td>
					</tr>
				</table>
  </body>
</html>
