<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="giohangmodal.GioHang"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Giỏ hàng</title>
   <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
   <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body class="bg-light">
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

   <div class="container my-5">
       <h2 class="text-center mb-4"><i class="fas fa-shopping-cart"></i> Giỏ hàng của bạn</h2>
       
       <%
       ArrayList<GioHang> ds = (ArrayList<GioHang>)request.getAttribute("ds");
       if(ds == null || ds.isEmpty()) {
       %>
           <div class="text-center">
               <p>Giỏ hàng trống</p>
               <a href="banhUserController" class="btn btn-primary">
                   <i class="fas fa-shopping-basket"></i> Tiếp tục mua hàng
               </a>
           </div>
       <%
       } else {
       %>
           <div class="table-responsive">
               <table class="table table-hover">
                   <thead class="table-dark">
                       <tr>
                           <th>Tên bánh</th>
                           <th class="text-end">Đơn giá</th>
                           <th class="text-center">Số lượng</th>
                           <th class="text-end">Thành tiền</th>
                           <th></th>
                       </tr>
                   </thead>
                   <tbody>
                       <% 
                       long tongTien = 0;
                       for(GioHang gh : ds) { 
                           long thanhTien = gh.getGia() * gh.getSoluong();
                           tongTien += thanhTien;
                       %>
                       <tr>
                           <td><%=gh.getTenbanh()%></td>
                           <td class="text-end"><%=String.format("%,d", gh.getGia())%>đ</td>
                           <td class="text-center">
                               <div class="d-flex justify-content-center align-items-center">
                                   <a href="suaGioHangController?mb=<%=gh.getMabanh()%>&action=giam" class="btn btn-sm btn-outline-secondary">-</a>
                                   <span class="mx-2"><%=gh.getSoluong()%></span>
                                   <a href="suaGioHangController?mb=<%=gh.getMabanh()%>&action=tang" class="btn btn-sm btn-outline-secondary">+</a>
                               </div>
                           </td>
                           <td class="text-end"><%=String.format("%,d", thanhTien)%>đ</td>
                           <td class="text-end">
                               <a href="xoaGioHangController?mb=<%=gh.getMabanh()%>" class="btn btn-danger btn-sm">
                                   <i class="fas fa-trash"></i>
                               </a>
                           </td>
                       </tr>
                       <%
                       }
                       %>
                   </tbody>
                   <tfoot class="table-light">
                       <tr>
                           <td colspan="3" class="text-end fw-bold">Tổng tiền:</td>
                           <td class="text-end fw-bold text-danger"><%=String.format("%,d", tongTien)%>đ</td>
                           <td></td>
                       </tr>
                   </tfoot>
               </table>
           </div>

           <div class="d-flex justify-content-between mt-4">
               <a href="banhUserController" class="btn btn-secondary">
                   <i class="fas fa-arrow-left"></i> Tiếp tục mua hàng
               </a>
               <a href="thanhToanController" class="btn btn-primary">
                   Đặt hàng <i class="fas fa-arrow-right"></i>
               </a>
           </div>
       <%
       }
       %>
   </div>

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