package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import KhachHangModal.KhachHang;
import banhmodal.Banh;
import banhmodal.BanhBo;
import giohangmodal.GioHangBo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/xoaGioHangController")
public class XoaGioHangController extends HttpServlet {

	private static final long serialVerionUID = 1L;

	public XoaGioHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			if (session.getAttribute("dn") == null) {
				resp.sendRedirect("dangnhapController");
				return;
			}

			Long mabanh = Long.parseLong(req.getParameter("mb"));
			BanhBo banhBo = new BanhBo();
			Banh banh = banhBo.layBanh(mabanh);

			if (banh == null) {
				session.setAttribute("error", "Không tìm thấy sản phẩm");
				resp.sendRedirect("gioHangController");
				return;
			}
			KhachHang khachhang = (KhachHang) session.getAttribute("dn");
			GioHangBo gioHangBo = new GioHangBo();
			gioHangBo.xoaGioHangTheoMaBanh(khachhang.getMakhachhang(), mabanh);
			session.setAttribute("success", "Xóa sản phẩm thành công");
			resp.sendRedirect("gioHangController");

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