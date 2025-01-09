<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="hoadonmodal.HoaDon"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản Lý Hóa Đơn</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.container {
	display: flex;
	min-height: 100vh;
	margin: 0;
	padding: 0;
	max-width: none;
}

.sidebar {
	width: 250px;
	background-color: #333;
	color: white;
	padding: 20px;
}

.main-content {
	flex: 1;
	padding: 20px;
	background-color: #f4f4f4;
}

.logo {
	font-size: 24px;
	text-align: center;
	padding: 20px 0;
	border-bottom: 1px solid #444;
}

.menu {
	margin-top: 20px;
}

.menu-item {
	padding: 15px;
	cursor: pointer;
	transition: background 0.3s;
}

.menu-item:hover {
	background-color: #444;
}

.menu-item a {
	color: white;
	text-decoration: none;
	display: block;
}

.header {
	background: white;
	padding: 20px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.toast-container {
	position: fixed;
	top: 20px;
	right: 20px;
	z-index: 1000;
}

/* CSS cho ảnh sản phẩm */
table td:nth-child(1) {
	width: 100px;
	min-width: 100px;
	max-width: 100px;
}

table img {
	width: 80px;
	height: 80px;
	object-fit: cover;
	border: 1px solid #ddd;
	border-radius: 4px;
	transition: transform 0.2s;
}

table img:hover {
	transform: scale(1.1);
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.status-badge {
	padding: 8px 15px;
	border-radius: 20px;
	font-weight: 500;
}

.card {
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
}
</style>
</head>
<body>
    <!-- Toast Container -->
    <div class="toast-container">
        <% if(session.getAttribute("error") != null) { %>
            <div class="toast align-items-center text-bg-danger border-0" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="d-flex">
                    <div class="toast-body">
                        <%= session.getAttribute("error") %>
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
            </div>
            <% session.removeAttribute("error"); %>
        <% } %>

        <% if(session.getAttribute("success") != null) { %>
            <div class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="d-flex">
                    <div class="toast-body">
                        <%= session.getAttribute("success") %>
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
            </div>
            <% session.removeAttribute("success"); %>
        <% } %>
    </div>

    <div class="container">
        <div class="sidebar">
            <div class="logo">ADMIN PANEL</div>
            <div class="menu">
                <div class="menu-item">
                    <a href="banhAdminController">Quản Lý Bánh</a>
                </div>
                <div class="menu-item">
                    <a href="loaiBanhAdminController">Quản Lý Loại Bánh</a>
                </div>
                <div class="menu-item">
                    <a href="hoaDonAdminController">Quản Lý Hóa Đơn</a>
                </div>
                <div class="menu-item">
                    <a href="adminDangXuatController">Đăng Xuất</a>
                </div>
            </div>
        </div>

        <div class="main-content">
            <div class="header">
                <h2>Quản lý hóa đơn</h2>
            </div>

            <div class="content" style="padding: 20px;">
                <div class="table-container">
                    <table class="table table-hover mb-0">
                        <thead class="table-dark">
                            <tr>
                                <th>Mã đơn</th>
                                <th>Mã KH</th>
                                <th>Ngày mua</th>
                                <th class="text-center">Trạng thái</th>
                                <th class="text-center">Thao tác</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            ArrayList<HoaDon> dsHoaDon = (ArrayList<HoaDon>)request.getAttribute("dsHoaDon");
                            if(dsHoaDon == null || dsHoaDon.isEmpty()) {
                            %>
                            <tr>
                                <td colspan="5" class="text-center text-muted fst-italic py-4">
                                    Không có dữ liệu
                                </td>
                            </tr>
                            <%
                            } else {
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                for(HoaDon hd : dsHoaDon) {
                            %>
                            <tr>
                                <td>#<%= hd.getMahoadon() %></td>
                                <td><%= hd.getMakhachhang() %></td>
                                <td><%= sdf.format(hd.getNgaymua()) %></td>
                                <td class="text-center">
                                    <span class="status-badge <%= hd.isDamua() ? "bg-success" : "bg-warning text-dark" %>">
                                        <%= hd.isDamua() ? "Đã thanh toán" : "Chờ thanh toán" %>
                                    </span>
                                </td>
                                <td class="text-center">
                                    <a href="chiTietHoaDonAdminController?mahoadon=<%= hd.getMahoadon() %>" 
                                       class="btn btn-info btn-sm">
                                        <i class="fas fa-eye"></i> Chi tiết
                                    </a>
                                  
                                </td>
                            </tr>
                            <%
                                }
                            }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
    document.addEventListener('DOMContentLoaded', function() {
        var toastElList = document.querySelectorAll('.toast');
        var toasts = [...toastElList].map(toastEl => {
            let toast = new bootstrap.Toast(toastEl, {
                autohide: true,
                delay: 3000
            });
            toast.show();
            return toast;
        });
    });
    </script>
</body>
</html>