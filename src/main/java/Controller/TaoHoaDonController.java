package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import KhachHangModal.KhachHang;
import banhmodal.Banh;
import banhmodal.BanhBo;
import giohangmodal.GioHang;
import giohangmodal.GioHangBo;
import hoadonmodal.HoaDonBo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/taoHoaDonController")
public class TaoHoaDonController extends HttpServlet {

	private static final long serialVerionUID = 1L;

	public TaoHoaDonController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			GioHangBo ghbo = new GioHangBo();
			HoaDonBo hdbo = new HoaDonBo();
			if (session.getAttribute("dn") == null)
				resp.sendRedirect("dangnhapController");
			else {
				KhachHang khachhang = (KhachHang) session.getAttribute("dn");
				if (ghbo.layGioHang(khachhang.getMakhachhang()).size() == 0) {
					req.getSession().setAttribute("error", "Quý khách chưa có sản phẩm nào trong giỏ hàng");
					resp.sendRedirect("gioHangController");
					return;
				}
				if (hdbo.taoHoaDonTheoMaKhachHang(khachhang)==true) {
					req.getSession().setAttribute("success", "Tạo hóa đơn thành công, hãy kiểm tra hóa hơn");
				} else {
					req.getSession().setAttribute("error", "Có sản phẩm đã hết hàng");
				}
				resp.sendRedirect("gioHangController");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("error", "Đã xảy ra lỗi");
			resp.sendRedirect("gioHangController");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}