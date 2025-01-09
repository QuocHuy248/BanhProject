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

@WebServlet("/taoGioHangController")
public class TaoGioHangController extends HttpServlet {

	private static final long serialVerionUID = 1L;

	public TaoGioHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BanhBo banhBo = new BanhBo();
			HttpSession session = req.getSession();
			if (session.getAttribute("dn") == null) {
				req.getSession().setAttribute("error", "Vui lòng đăng nhập để thêm sản phẩm");
				resp.sendRedirect("banhUserController");
			} else {
				KhachHang khachhang = (KhachHang) session.getAttribute("dn");
				Long mabanh = (Long) req.getAttribute("mabanh");
				Banh banh = banhBo.layBanh(mabanh);
				if (banh == null) {
					req.getSession().setAttribute("error", "Thêm sản phẩm vào giỏ hàng không thành công");
					resp.sendRedirect("banhUserController");
				}
				GioHangBo gioHangBo = new GioHangBo();
				gioHangBo.themBanhVaoGioHang(khachhang, banh);
				req.getSession().setAttribute("success", "Thêm sản phẩm vào giỏ hàng  thành công");
				resp.sendRedirect("banhUserController");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("error", "Đã xảy ra lỗi");
			resp.sendRedirect("banhUserController");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}