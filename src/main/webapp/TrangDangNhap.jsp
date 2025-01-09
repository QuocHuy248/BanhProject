<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Login</title>
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
    background-color: #f4f4f4;
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
}

.login-container {
    background: white;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 400px;
}

.login-header {
    text-align: center;
    margin-bottom: 30px;
}

.login-header h2 {
    font-size: 24px;
    color: #333;
    font-weight: 500;
}

.form-group {
    margin-bottom: 20px;
}

.form-group label {
    display: block;
    margin-bottom: 8px;
    color: #555;
    font-weight: 500;
    font-size: 15px;
}

.form-group input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 15px;
}

.form-group input:focus {
    outline: none;
    border-color: #4CAF50;
    box-shadow: 0 0 0 2px rgba(76, 175, 80, 0.1);
}

.captcha-container {
    margin-bottom: 20px;
}

.captcha-container img {
    margin-bottom: 10px;
    border-radius: 4px;
}

.captcha-container input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

.login-btn {
    width: 100%;
    padding: 12px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    font-size: 16px;
    font-weight: 500;
    cursor: pointer;
    transition: background-color 0.3s;
}

.login-btn:hover {
    background-color: #45a049;
}

.error-message {
    color: #f44336;
    margin-top: 15px;
    text-align: center;
    font-size: 14px;
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

    <div class="login-container">
        <div class="login-header">
            <h2> LOGIN</h2>
        </div>
        <form action="xacNhanDangNhapController" method="post">
            <div class="form-group">
                <label for="username">Tên đăng nhập</label>
                <input type="text" id="username" name="txtun" required>
            </div>
            
            <div class="form-group">
                <label for="password">Mật khẩu</label>
                <input type="password" id="password" name="txtpass" required>
            </div>

            <button type="submit" name="but" value="Login" class="login-btn">Đăng nhập</button>

            <%
            String tb=(String)request.getAttribute("tb");
            if(tb!=null) {
            %>
            <div class="error-message"><%=tb%></div>
            <%
            }
            %>
        </form>
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