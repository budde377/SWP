<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrap title="QuickPoll">
<form method=post action=vote>
${currentQuestion.question}?
<p>
<input name=vote type=radio value=yes> yes<br>
<input name=vote type=radio value=no> no</p>
<input type=submit name=submit value=Vote>
</form>

</t:wrap>