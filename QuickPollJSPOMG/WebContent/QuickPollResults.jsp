<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<t:wrap title="Quick Poll">
<c:choose>
	<c:when test="${currentQuestion.total == 0}">
		No votes yet...
	</c:when>
	<c:otherwise>
		${currentQuestion.question}?<p>
        <table border=0>
        <tr><td>Yes:<td><t:bar length="${currentQuestion.yes*300 / currentQuestion.yes}"/><td>${currentQuestion.yes}
        <tr><td>No:<td><t:bar length="${currentQuestion.no*300 /currentQuestion.no}"/><td>${currentQuestion.no}
        </table>
	</c:otherwise>
</c:choose>
</t:wrap>