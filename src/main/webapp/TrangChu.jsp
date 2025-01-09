<%@ page import="banhmodal.Banh"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <title>Sweet Delights Bakery</title>
   <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
   <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
   <style>
       body {
           font-family: Arial, sans-serif;
           background-color: #f5f5f5;
       }
       .hero-section {
           position: relative;
           height: 400px;
           background: linear-gradient(rgba(0,0,0,0.5), rgba(0,0,0,0.5)), url('path_to_your_banner_image.jpg');
           background-size: cover;
           background-position: center;
           color: white;
           text-align: center;
           display: flex;
           align-items: center;
           justify-content: center;
       }
       .grid {
           display: grid;
           grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
           gap: 20px;
           padding: 20px;
       }
       .product-card {
           background: white;
           border-radius: 8px;
           padding: 15px;
           box-shadow: 0 2px 4px rgba(0,0,0,0.1);
           transition: transform 0.2s;
       }
       .product-card:hover {
           transform: translateY(-5px);
           box-shadow: 0 4px 8px rgba(0,0,0,0.2);
       }
       .product-image {
           width: 100%;
           height: 200px;
           object-fit: cover;
           border-radius: 4px;
           margin-bottom: 10px;
       }
       .product-info {
           padding: 10px 0;
       }
       .product-name {
           font-size: 1.1em;
           font-weight: bold;
           color: #333;
           margin: 8px 0;
       }
       .product-id {
           color: #666;
           font-size: 0.9em;
           margin: 5px 0;
       }
       .product-price {
           color: #e44d26;
           font-weight: bold;
           font-size: 1.2em;
           margin: 8px 0;
       }
       .product-quantity {
           color: #4CAF50;
           font-size: 0.9em;
       }
       .no-data {
           grid-column: 1/-1;
           text-align: center;
           padding: 20px;
           background: white;
           border-radius: 8px;
           color: #666;
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

   <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
       <div class="container">
           <a class="navbar-brand" href="#">
               <i class="fas fa-cookie"></i> Sweet Delights
           </a>
           <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
               <span class="navbar-toggler-icon"></span>
           </button>
           <div class="collapse navbar-collapse" id="navbarNav">
               <ul class="navbar-nav ms-auto">
                   <li class="nav-item">
                       <a class="nav-link" href="#menu">
                           <i class="fas fa-book-open"></i> Menu
                       </a>
                   </li>
                   <li class="nav-item">
                       <a class="nav-link" href="gioHangController">
                           <i class="fas fa-shopping-cart"></i> Giỏ hàng
                       </a>
                   </li>
                   <% if(session.getAttribute("dn")==null) { %>
                       <li class="nav-item">
                           <a class="nav-link" href="dangnhapController">
                               <i class="fas fa-sign-in-alt"></i> Đăng nhập
                           </a>
                       </li>
                   <% } else { %>
                       <li class="nav-item">
                           <a class="nav-link" href="hoaDonUserController">
                               <i class="fas fa-file-invoice"></i> Xem hóa đơn
                           </a>
                       </li>
                       <li class="nav-item">
                           <a class="nav-link" href="hoaDonUserController">
                               <i class="fas fa-history"></i> Lịch sử mua
                           </a>
                       </li>
                       <li class="nav-item">
                           <a class="nav-link" href="dangxuatController">
                               <i class="fas fa-sign-out-alt"></i> Đăng xuất
                           </a>
                       </li>
                   <% } %>
               </ul>
           </div>
       </div>
   </nav>

   <div class="hero-section">
       <div class="container">
           <h1 class="display-4">Sweet Delights Bakery</h1>
           <p class="lead">Thưởng thức những chiếc bánh tuyệt hảo</p>
       </div>
   </div>

   <div class="container mt-4">
       <form action="banhUserController" method="get" class="d-flex justify-content-center">
           <div class="input-group" style="max-width: 500px;">
               <input type="text" name="search" class="form-control" placeholder="Tìm kiếm bánh..." value="${param.search}">
               <button class="btn btn-primary" type="submit">
                   <i class="fas fa-search"></i>
               </button>
           </div>
       </form>
   </div>

   <div class="container">
       <div class="grid">
           <%
           ArrayList<Banh> ds = (ArrayList<Banh>) request.getAttribute("ds");
           if (ds == null || ds.isEmpty()) {
           %>
           <div class="no-data">Không có dữ liệu</div>
           <%
           } else {
           for (Banh tt : ds) {
           %>
           <div class="product-card text-center">
               <img src="<%=tt.getAnh()%>" alt="<%=tt.getTenbanh()%>" class="product-image">
               <div class="product-info p-3">
                   <h5 class="product-name mb-2"><%=tt.getTenbanh()%></h5>
                   <p class="product-id text-muted mb-2"><%=tt.getTenloai()%></p>
                   <p class="product-price text-danger fw-bold mb-2"><%=String.format("%,d", tt.getGia())%> đ</p>
                   <p class="product-quantity text-success mb-3">Còn: <%=tt.getSoluong()%></p>
                   <a href="taoGioHangController" class="btn btn-primary w-100">
                       <i class="fas fa-cart-plus me-2"></i>Thêm vào giỏ
                   </a>
               </div>
           </div>
           <%
           }
           }
           %>
       </div>
   </div>

   <footer class="bg-dark text-white py-4 mt-5">
       <div class="container text-center">
           <p><i class="fas fa-heart"></i> &copy; 2024 Sweet Delights Bakery</p>
       </div>
   </footer>

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