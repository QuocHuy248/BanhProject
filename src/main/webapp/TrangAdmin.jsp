<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang Quản Trị</title>
    <style>
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
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <div class="logo">
                ADMIN PANEL
            </div>
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
                <h2>Chào mừng đến với trang quản trị</h2>
            </div>
            <div class="content" style="padding: 20px;">
             
            </div>
        </div>
    </div>
</body>
</html>