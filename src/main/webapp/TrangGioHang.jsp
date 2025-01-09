<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="giohangmodal.GioHang"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	rel="stylesheet">
<style>
.confirm-dialog {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.5);
	display: flex;
	justify-content: center;
	align-items: center;
	z-index: 1000;
}

.confirm-content {
	background-color: white;
	padding: 20px;
	border-radius: 5px;
	text-align: center;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.confirm-buttons {
	margin-top: 20px;
}

.confirm-buttons button {
	margin: 0 10px;
}			<style>
/* CSS để đảm bảo kích thước cột ảnh nhất quán */
.table td:first-child {
	width: 100px;
	min-width: 100px;
	max-width: 100px;
}

/* CSS để đảm bảo ảnh không bị méo */
.table img {
	width: 80px;
	height: 80px;
	object-fit: cover;
	border: 1px solid #dee2e6;
	border-radius: 4px;
}


</style>
</head>
<body class="bg-light">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="banhUserController"> <i
				class="fas fa-cookie"></i> Sweet Delights
			</a>
			<div class="navbar-nav ms-auto">
				<a class="nav-link" href="banhUserController"> <i
					class="fas fa-home"></i> Trang chủ
				</a>
			</div>
		</div>
	</nav>
	<div class="toast-container">
		<%
		if (session.getAttribute("error") != null) {
		%>
		<div class="toast align-items-center text-bg-danger border-0"
			role="alert" aria-live="assertive" aria-atomic="true">
			<div class="d-flex">
				<div class="toast-body">
					<%=session.getAttribute("error")%>
				</div>
				<button type="button" class="btn-close btn-close-white me-2 m-auto"
					data-bs-dismiss="toast" aria-label="Close"></button>
			</div>
		</div>
		<%
		session.removeAttribute("error");
		}
		%>

		<%
		if (session.getAttribute("success") != null) {
		%>
		<div class="toast align-items-center text-bg-success border-0"
			role="alert" aria-live="assertive" aria-atomic="true">
			<div class="d-flex">
				<div class="toast-body">
					<%=session.getAttribute("success")%>
				</div>
				<button type="button" class="btn-close btn-close-white me-2 m-auto"
					data-bs-dismiss="toast" aria-label="Close"></button>
			</div>
		</div>
		<%
		session.removeAttribute("success");
		}
		%>
	</div>
	<div class="container my-5">
		<h2 class="text-center mb-4">
			<i class="fas fa-shopping-cart"></i> Giỏ hàng của bạn
		</h2>

		<%
		ArrayList<GioHang> ds = (ArrayList<GioHang>) request.getAttribute("ds");
		if (ds == null || ds.isEmpty()) {
		%>
		<div class="text-center">
			<p>Giỏ hàng trống</p>
			<a href="banhUserController" class="btn btn-primary"> <i
				class="fas fa-shopping-basket"></i> Tiếp tục mua hàng
			</a>
		</div>
		<%
		} else {
		%>
		<div class="table-responsive">
			<table class="table table-hover">
				<thead class="table-dark">
					<tr>
						<th>Ảnh</th>
						<!-- Thêm cột ảnh -->
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
					for (GioHang gh : ds) {
						long thanhTien = gh.getGia() * gh.getSoluong();
						tongTien += thanhTien;
					%>
					<tr>
						<td><img src="<%=gh.getAnh()%>" alt="<%=gh.getTenbanh()%>"
							class="img-thumbnail"
							style="width: 80px; height: 80px; object-fit: cover;"></td>
						<td><%=gh.getTenbanh()%></td>
						<td class="text-end"><%=String.format("%,d", gh.getGia())%>đ</td>
						<td class="text-center">
							<div class="d-flex justify-content-center align-items-center">
								<a
									href="suaGioHangController?mb=<%=gh.getMabanh()%>&action=giam"
									class="btn btn-sm btn-outline-secondary">-</a> <span
									class="mx-2"><%=gh.getSoluong()%></span> <a
									href="suaGioHangController?mb=<%=gh.getMabanh()%>&action=tang"
									class="btn btn-sm btn-outline-secondary">+</a>
							</div>
						</td>
						<td class="text-end"><%=String.format("%,d", thanhTien)%>đ</td>
						<td class="text-end"><a
							href="xoaGioHangController?mb=<%=gh.getMabanh()%>"
							class="btn btn-danger btn-sm"> <i class="fas fa-trash"></i>
						</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
				<tfoot class="table-light">
					<tr>
						<td colspan="4" class="text-end fw-bold">Tổng tiền:</td>
						<td class="text-end fw-bold text-danger"><%=String.format("%,d", tongTien)%>đ</td>
						<td></td>
					</tr>
				</tfoot>
			</table>

		</div>

		<div class="d-flex justify-content-between mt-4">
			<a href="banhUserController" class="btn btn-secondary"> <i
				class="fas fa-arrow-left"></i> Tiếp tục mua hàng <a
				href="taoHoaDonController" class="btn btn-primary" id="orderButton">
					Đặt hàng <i class="fas fa-arrow-right"></i>
			</a> <!-- Confirmation dialog -->
				<div id="confirmDialog" class="confirm-dialog"
					style="display: none;">
					<div class="confirm-content">
						<p>Bạn có chắc muốn thanh toán không?</p>
						<div class="confirm-buttons">
							<button class="btn btn-secondary" onclick="cancelPayment()">Hủy</button>
							<button class="btn btn-primary" onclick="confirmPayment()">Xác
								nhận</button>
						</div>
					</div>
				</div>
		</div>
		<%
		}
		%>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
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
    document.getElementById('orderButton').addEventListener('click', function(e) {
        e.preventDefault(); // Prevent the default link behavior
        document.getElementById('confirmDialog').style.display = 'flex';
    });

    function cancelPayment() {
        document.getElementById('confirmDialog').style.display = 'none';
    }

    function confirmPayment() {
        // Proceed with payment
        window.location.href = document.getElementById('orderButton').getAttribute('href');
    }
    
    </script>

</body>
</html>