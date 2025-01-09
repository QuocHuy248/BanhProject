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
			BanhBo banhBo = new BanhBo();
			HttpSession session = req.getSession();
			if (session.getAttribute("dn") == null)// Chua dang nhap
				resp.sendRedirect("dangnhapController");
			else {
				KhachHang khachhang = (KhachHang) session.getAttribute("dn");
				Long mabanh = (Long) req.getAttribute("mb");
				Banh banh = banhBo.layBanh(mabanh);
				if (banh == null) {
					req.getSession().setAttribute("error", "Thêm sản phẩm vào giỏ hàng không thành công");
					return;
				}
				GioHangBo gioHangBo = new GioHangBo();
				gioHangBo.themBanhVaoGioHang(khachhang, banh);
				req.getSession().setAttribute("success", "Thêm sản phẩm vào giỏ hàng không thành công");
			}
			RequestDispatcher rd = req.getRequestDispatcher("Trangchu.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("error", "Đã xảy ra lỗi");
			resp.sendRedirect("BanhUserController");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}