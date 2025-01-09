<%@ page import="LoaiModal.Loai"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh Sửa Loại Bánh</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap');

body {
    font-family: 'Roboto', sans-serif;
    font-size: 14px;
    line-height: 1.6;
    color: #333;
}

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

.container {
    display: flex;
    min-height: 100vh;
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

.edit-form {
    max-width: 600px;
    margin: 20px auto;
    padding: 30px;
    background: white;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.edit-form h2 {
    font-size: 24px;
    font-weight: 500;
    color: #333;
    margin-bottom: 20px;
}

.form-group {
    margin-bottom: 20px;
}

.form-group label {
    display: block;
    font-weight: 500;
    margin-bottom: 8px;
    font-size: 15px;
}

.form-group input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 15px;
    font-family: 'Roboto', sans-serif;
}

.btn-save {
    background: #4CAF50;
    color: white;
    padding: 12px 24px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 15px;
    font-family: 'Roboto', sans-serif;
    font-weight: 500;
}

.btn-save:hover {
    background: #45a049;
}

.btn-cancel {
    background: #f44336;
    color: white;
    padding: 12px 24px;
    margin-left: 10px;
    text-decoration: none;
    border-radius: 4px;
    display: inline-block;
    font-size: 15px;
    font-family: 'Roboto', sans-serif;
    font-weight: 500;
}

.btn-cancel:hover {
    background: #da190b;
}
</style>
</head>
<body>
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
                    <a href="QuanLyHoaDonController">Quản Lý Hóa Đơn</a>
                </div>
                <div class="menu-item">
                    <a href="ThongKeController">Thống Kê</a>
                </div>
                <div class="menu-item">
                    <a href="adminDangXuatController">Đăng Xuất</a>
                </div>
            </div>
        </div>

        <div class="main-content">
            <div class="header">
                <h2>Quản lý loại bánh</h2>
            </div>
            <div class="content" style="padding: 20px;">
                <div class="edit-form">
                    <h2>Chỉnh sửa thông tin loại bánh</h2>
                    <%
                    Loai loai = (Loai) request.getAttribute("loai");
                    if (loai != null) {
                    %>
                    <form action="chinhSuaLoaiBanhController" method="post">
                        <input type="hidden" name="maloai" value="<%=loai.getMaloai()%>">

                        <div class="form-group">
                            <label>Tên loại bánh:</label>
                            <input type="text" name="tenloai" value="<%=loai.getTenloai()%>" required>
                        </div>

                        <div style="margin-top: 20px;">
                            <button type="submit" class="btn-save">Lưu thay đổi</button>
                            <a href="loaiBanhAdminController" class="btn-cancel">Hủy</a>
                        </div>
                    </form>
                    <%
                    } else {
                    %>
                    <p>Không tìm thấy thông tin loại bánh!</p>
                    <a href="loaiBanhAdminController" class="btn-cancel">Quay lại</a>
                    <%
                    }
                    %>
                </div>
            </div>
        </div>
    </div>
</body>
</html>