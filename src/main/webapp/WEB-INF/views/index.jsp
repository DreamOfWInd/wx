<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信服务号</title>
</head>
<body>
<h2>
这是微信服务号的第一个测试页 O(∩_∩)O~
</h2>
	<div>
		<table>
			<thead>
				<tr>
					<th>
						用户名
					</th>
					<th>
						密码
					</th>
					<th>
						性别
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${list}">
					<tr>
						<td>
							${item.username }
						</td>
						<td>
							${item.password }
						</td>
						<td>
							${item.gender }
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>