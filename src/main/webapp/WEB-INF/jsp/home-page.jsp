<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

${helloPhrase}

<table>
<c:forEach var="bookIterator" items="${books}">
	<tr>
		<td><a href="/book/${bookIterator.id}" >${bookIterator.name}</a></td>
		<td>${bookIterator.author}</td>
	</tr>
</c:forEach>
</table>


