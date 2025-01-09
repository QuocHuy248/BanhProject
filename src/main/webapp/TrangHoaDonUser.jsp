<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="hoadonmodal.HoaDon"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đơn hàng của tôi</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="banhUserController">
                <i class="fas fa-cookie"></i> Sweet Delights
            </a>
            <div class="navbar-nav ms-auto">
                <a class="nav-link" href="banhUserController">
                    <i class="fas fa-home"></i> Trang chủ
                </a>
            </div>
        </div>
    </nav>

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

    <!-- Main Content -->
    <div class="container my-5">
        <h2 class="text-center mb-4">
            <i class="fas fa-file-invoice"></i> Đơn hàng của tôi
        </h2>

        <% 
        ArrayList<HoaDon> dsHoaDon = (ArrayList<HoaDon>)request.getAttribute("dsHoaDon");
        if(dsHoaDon == null || dsHoaDon.isEmpty()) {
        %>
            <div class="text-center">
                <p>Bạn chưa có đơn hàng nào</p>
                <a href="banhUserController" class="btn btn-primary">
                    <i class="fas fa-shopping-basket"></i> Mua hàng ngay
                </a>
            </div>
        <% } else { %>
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead class="table-dark">
                        <tr>
                            <th>Mã đơn</th>
                            <th>Ngày mua</th>
                            <th class="text-center">Trạng thái</th>
                            <th class="text-center">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        for(HoaDon hd : dsHoaDon) { 
                        %>
                            <tr>
                                <td>#<%= hd.getMahoadon() %></td>
                                <td><%= sdf.format(hd.getNgaymua()) %></td>
                                <td class="text-center">
                                    <% if(hd.isDamua()) { %>
                                        <span class="badge bg-success">Đã thanh toán</span>
                                    <% } else { %>
                                        <span class="badge bg-warning text-dark">Chờ thanh toán</span>
                                    <% } %>
                                </td>
                                <td class="text-center">
                                    <a href="chiTietHoaDonUserController?mahoadon=<%= hd.getMahoadon() %>" 
                                       class="btn btn-info btn-sm">
                                        <i class="fas fa-eye"></i> Xem chi tiết
                                    </a>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        <% } %>
    </div>

    <!-- Scripts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
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