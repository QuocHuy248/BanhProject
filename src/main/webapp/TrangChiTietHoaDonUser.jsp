<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="chitiethoadonmodal.ChiTietHoaDon"%>
<%@ page import="hoadonmodal.HoaDon"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết đơn hàng</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	rel="stylesheet">
<style>
.order-info {
	background: white;
	border-radius: 8px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	padding: 20px;
	margin-bottom: 20px;
}

.table img {
	width: 80px;
	height: 80px;
	object-fit: cover;
	border-radius: 4px;
}

.status-badge {
	padding: 8px 12px;
	border-radius: 20px;
}

.toast-container {
	position: fixed;
	top: 20px;
	right: 20px;
	z-index: 1000;
}
</style>
</head>
<body class="bg-light">
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="banhUserController"> <i
				class="fas fa-cookie"></i> Sweet Delights
			</a>
			<div class="navbar-nav ms-auto">
				<a class="nav-link" href="hoaDonUserController"> <i
					class="fas fa-list"></i> Danh sách đơn hàng
				</a> <a class="nav-link" href="banhUserController"> <i
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
		%>
		<%
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
		%>
		<%
		}
		%>
	</div>
	<div class="container my-5">
		<%
		HoaDon hoaDon = (HoaDon) request.getAttribute("hoadon");
		ArrayList<ChiTietHoaDon> dsChiTiet = (ArrayList<ChiTietHoaDon>) request.getAttribute("cthdList");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		%>

		<!-- Thông tin đơn hàng -->
		<div class="order-info">
			<div class="d-flex justify-content-between align-items-center mb-4">
				<h2 class="mb-0">
					<i class="fas fa-file-invoice"></i> Chi tiết đơn hàng #<%=hoaDon.getMahoadon()%>
				</h2>
				<span
					class="status-badge <%=hoaDon.isDamua() ? "bg-success" : "bg-warning text-dark"%>">
					<%=hoaDon.isDamua() ? "Đã thanh toán" : "Chờ thanh toán"%>
				</span>
			</div>

			<div class="row">
				<div class="col-md-6">
					<p>
						<strong><i class="far fa-calendar-alt"></i> Ngày đặt:</strong>
						<%=sdf.format(hoaDon.getNgaymua())%>
					</p>
					<p>
						<strong><i class="far fa-user"></i> Mã khách hàng:</strong>
						<%=hoaDon.getMakhachhang()%>
					</p>
				</div>
			</div>
		</div>

		<!-- Chi tiết sản phẩm -->
		<div class="card">
			<div class="card-body">
				<h3 class="card-title mb-4">Sản phẩm đã đặt</h3>
				<div class="table-responsive">
					<table class="table">
						<thead class="table-light">
							<tr>
								<th>Ảnh</th>
								<th>Sản phẩm</th>
								<th class="text-center">Số lượng</th>
								<th class="text-end">Đơn giá</th>
								<th class="text-end">Thành tiền</th>
							</tr>
						</thead>
						<tbody>
							<%
							long tongTien = 0;
							for (ChiTietHoaDon ct : dsChiTiet) {
								long thanhTien = ct.getGia() * ct.getSoluongmua();
								tongTien += thanhTien;
							%>
							<tr>
								<td><img src="<%=ct.getAnh()%>" alt="<%=ct.getTenbanh()%>"
									class="img-thumbnail"></td>
								<td><%=ct.getTenbanh()%></td>
								<td class="text-center"><%=ct.getSoluongmua()%></td>
								<td class="text-end"><%=String.format("%,d", ct.getGia())%>đ</td>
								<td class="text-end"><%=String.format("%,d", thanhTien)%>đ</td>
							</tr>
							<%
							}
							%>
						</tbody>
						<tfoot class="table-light">
							<tr>
								<td colspan="4" class="text-end fw-bold">Tổng tiền:</td>
								<td class="text-end fw-bold text-danger"><%=String.format("%,d", tongTien)%>đ
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>

		<!-- Nút điều hướng -->
		<div class="d-flex justify-content-between mt-4">
			<a href="hoaDonUserController" class="btn btn-secondary"> <i
				class="fas fa-arrow-left"></i> Quay lại danh sách
			</a>
		</div>
	</div>

	<!-- Scripts -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
	<script>
        function confirmPayment(mahoadon) {
            if(confirm('Bạn có chắc muốn thanh toán đơn hàng này?')) {
                window.location.href = 'thanhToanController?mahoadon=' + mahoadon;
            }
        }
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