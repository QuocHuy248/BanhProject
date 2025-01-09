<%@page import="LeQuocHuyModal.LeQuocHuy_Tintuc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hiển thị tin tức</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
<body>
	<form>
		<input type="text" name="timkiem"/>
		<button type="submit">Tìm</button>
	</form>
	<table class="table table-bordered">
		<tr>
			<th>Tiêu đề</th>
			<th>Ngày đưa tin</th>
			<th>Tóm tắt</th>
			<th>Nội dung</th>
		</tr>
 <% ArrayList<LeQuocHuy_Tintuc> ds = (ArrayList<LeQuocHuy_Tintuc>)request.getAttribute("list");
			for (LeQuocHuy_Tintuc tt : ds) { %>
				<tr>
					<td><%=tt.getTieuDe() %></td>
			<td><%=tt.getNgayDuaTin()%></td>
			<td><%=tt.getTomTat() %></td>
					<td><%=tt.getNoiDung() %></td>
				</tr>
			<%}
		%> 
	</table>
	
</body>
</html>