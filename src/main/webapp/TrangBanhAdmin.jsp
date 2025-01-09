<%@ page import="banhmodal.Banh"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Quản Trị</title>
<!-- Bootstrap CSS -->
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
</style>
</head>
<body>
    <!-- Toast Container -->
    <div class="toast-container">
        <%
        if(session.getAttribute("error") != null) {
        %>
        <div class="toast align-items-center text-bg-danger border-0" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body">
                    <%=session.getAttribute("error")%>
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
        </div>
        <%
        session.removeAttribute("error");
        }
        %>

        <%
        if(session.getAttribute("success") != null) {
        %>
        <div class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body">
                    <%=session.getAttribute("success")%>
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
        </div>
        <%
        session.removeAttribute("success");
        }
        %>
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
                <h2>Quản lý bánh</h2>
            </div>
            
            <div class="content" style="padding: 20px;">
                <!-- Thêm nút Thêm mới -->
                <div style="margin-bottom: 20px;">
                    <a href="taoBanhController">
                        <button
                            style="padding: 10px 20px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer;">
                            + Thêm bánh mới</button>
                    </a>
                </div>

                <!-- Bảng danh sách bánh -->
                <table
                    style="width: 100%; border-collapse: collapse; background: white; box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);">
                    <thead>
                        <tr style="background-color: #333; color: white;">
                            <th style="padding: 12px; text-align: left;">STT</th>
                            <th style="padding: 12px; text-align: left;">Tên bánh</th>
                            <th style="padding: 12px; text-align: left;">Số lượng</th>
                            <th style="padding: 12px; text-align: left;">Đơn giá</th>
                            <th style="padding: 12px; text-align: left;">Loại bánh</th>
                            <th style="padding: 12px; text-align: center;">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        ArrayList<Banh> dsBanh = (ArrayList<Banh>) request.getAttribute("ds");
                        if (dsBanh == null || dsBanh.isEmpty()) {
                        %>
                        <tr>
                            <td colspan="6"
                                style="text-align: center; padding: 20px; font-style: italic; color: #666;">
                                Không có dữ liệu</td>
                        </tr>
                        <%
                        } else {
                        int stt = 1;
                        for (Banh b : dsBanh) {
                        %>
                        <tr style="border-bottom: 1px solid #ddd;">
                            <td style="padding: 12px;"><%=stt++%></td>
                            <td style="padding: 12px;"><%=b.getTenbanh()%></td>
                            <td style="padding: 12px;"><%=b.getSoluong()%></td>
                            <td style="padding: 12px;"><%=String.format("%,d", b.getGia())%>
                                đ</td>
                            <td style="padding: 12px;"><%=b.getTenloai()%></td>
                            <td style="padding: 12px; text-align: center;">
                                <a href="suaBanhController?mabanh=<%=b.getMabanh()%>"
                                    style="padding: 5px 10px; background-color: #2196F3; color: white; text-decoration: none; border-radius: 3px; margin-right: 5px;">Sửa</a>
                                <a href="xoaBanhController?mabanh=<%=b.getMabanh()%>"
                                    onclick="return confirm('Bạn có chắc muốn xóa bánh này?')"
                                    style="padding: 5px 10px; background-color: #f44336; color: white; text-decoration: none; border-radius: 3px;">Xóa</a>
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

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
    // Hiển thị toast nếu có
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