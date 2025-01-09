<%@ page import="banhmodal.Banh"%>
<%@ page import="LoaiModal.Loai"%>
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
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap');

* {
   margin: 0;
   padding: 0;
   box-sizing: border-box;
}

body {
   font-family: 'Roboto', sans-serif;
   background: #f4f4f4;
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
   background: #333;
   color: white;
   padding: 20px;
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
   transition: all 0.3s;
}

.menu-item:hover {
   background: #444;
}

.menu-item a {
   color: white;
   text-decoration: none;
   display: block;
}

.main-content {
   flex: 1;
   padding: 20px;
   background: #f4f4f4;
}

.header {
   background: white;
   padding: 20px;
   box-shadow: 0 2px 5px rgba(0,0,0,0.1);
   margin-bottom: 20px;
}

.edit-form {
   background: white;
   padding: 30px;
   border-radius: 8px;
   box-shadow: 0 2px 5px rgba(0,0,0,0.1);
}

.form-group {
   margin-bottom: 20px;
}

.form-group label {
   display: block;
   margin-bottom: 8px;
   font-weight: 500;
}

.form-group input,
.form-group select {
   width: 100%;
   padding: 10px;
   border: 1px solid #ddd;
   border-radius: 4px;
}

.image-upload {
   margin: 15px 0;
}

.current-image {
   max-width: 200px;
   margin-bottom: 10px;
   border-radius: 4px;
}

.btn-save,
.btn-cancel {
   padding: 10px 20px;
   border-radius: 4px;
   cursor: pointer;
   text-decoration: none;
   display: inline-block;
}

.btn-save {
   background: #4CAF50;
   color: white;
   border: none;
}

.btn-cancel {
   background: #f44336;
   color: white;
   margin-left: 10px;
}

.toast-container {
   position: fixed;
   top: 20px;
   right: 20px;
   z-index: 1000;
}
.form-group {
   margin-bottom: 20px;
}

.image-upload {
   border: 2px dashed #ddd;
   padding: 20px;
   border-radius: 8px;
   text-align: center;
}

.current-image {
   max-width: 300px;
   max-height: 300px;
   object-fit: contain;
   margin-bottom: 15px;
   border-radius: 4px;
   box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

input[type="file"] {
   display: block;
   width: 100%;
   padding: 8px;
   border: 1px solid #ddd;
   border-radius: 4px;
   margin-top: 10px;
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
                    <a href="hoaDonAdminController">Quản Lý Hóa Đơn</a>
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
                <div class="edit-form">
                    <h2>Chỉnh sửa thông tin bánh</h2>
                    <%
                    Banh banh = (Banh) request.getAttribute("banh");
                    ArrayList<Loai> dsLoai = (ArrayList<Loai>) request.getAttribute("dsloai");
                    if (banh != null) {
                    %>
                    <form action="chinhSuaBanhController" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="mabanh" value="<%=banh.getMabanh()%>">

                        <div class="form-group">
                            <label>Tên bánh:</label>
                            <input type="text" name="tenbanh" value="<%=banh.getTenbanh()%>" required>
                        </div>

                        <div class="form-group">
                            <label>Ảnh sản phẩm:</label>
                            <div class="image-upload">
                                <img class="current-image" src="<%=banh.getAnh()%>" alt="Ảnh bánh">
                                <input type="file" name="anh" accept="image/jpeg,image/jpg,image/png">
                            </div>
                        </div>

                        <div class="form-group">
                            <label>Số lượng:</label>
                            <input type="number" name="soluong" value="<%=banh.getSoluong()%>"   min="1" required>
                        </div>

                        <div class="form-group">
                            <label>Giá:</label>
                            <input type="number" name="gia" value="<%=banh.getGia()%>"  required min="10000" required>
                        </div>

                        <div class="form-group">
                            <label>Loại bánh:</label>
                            <select name="tenloai" required>
                                <%
                                if (dsLoai != null) {
                                    for (Loai l : dsLoai) {
                                %>
                                <option value="<%=l.getTenloai()%>"
                                    <%=l.getTenloai().equals(banh.getTenloai()) ? "selected" : ""%>>
                                    <%=l.getTenloai()%>
                                </option>
                                <%
                                    }
                                }
                                %>
                            </select>
                        </div>

                        <div style="margin-top: 20px;">
                            <button type="submit" class="btn-save">Lưu thay đổi</button>
                            <a href="banhAdminController" class="btn-cancel">Hủy</a>
                        </div>
                    </form>
                    <%
                    } else {
                    %>
                    <p>Không tìm thấy thông tin bánh!</p>
                    <a href="banhAdminController" class="btn-cancel">Quay lại</a>
                    <%
                    }
                    %>
                </div>
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