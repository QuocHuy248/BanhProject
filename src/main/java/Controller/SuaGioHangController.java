package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import KhachHangModal.KhachHang;
import banhmodal.Banh;
import banhmodal.BanhBo;
import giohangmodal.GioHang;
import giohangmodal.GioHangBo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/suaGioHangController")
public class SuaGioHangController extends HttpServlet {

	private static final long serialVerionUID = 1L;

	public SuaGioHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BanhBo banhBo = new BanhBo();
			GioHangBo gioHangBo = new GioHangBo();
			HttpSession session = req.getSession();
			if (session.getAttribute("dn") == null) {
				req.getSession().setAttribute("error", "Vui lòng đăng nhập ");
				resp.sendRedirect("dangnhapController");
			} else {
				KhachHang khachhang = (KhachHang) session.getAttribute("dn");
				Long mabanh = Long.parseLong(req.getParameter("mb"));
				String action = req.getParameter("action");
				Banh banh = banhBo.layBanh(mabanh);
				if (banh == null) {
					req.getSession().setAttribute("error", "Không tìm thấy sản phẩm");
					resp.sendRedirect("gioHangController");
				}
				ArrayList<GioHang> giohangList = gioHangBo.layGioHang(khachhang.getMakhachhang());
				if (gioHangBo.checkSanPham(khachhang, mabanh) == false) {
					req.getSession().setAttribute("error", "Không tìm thấy sản phẩm trong gio hang");
					resp.sendRedirect("gioHangController");
				}
				GioHang giohang = gioHangBo.layGioHangTheoBanhVaKH(khachhang.getMakhachhang(), mabanh);
				String text = gioHangBo.tangGiamSanPhamTrongGioHang(giohang, banh, action);
				req.getSession().setAttribute("success", text);
				resp.sendRedirect("gioHangController");

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