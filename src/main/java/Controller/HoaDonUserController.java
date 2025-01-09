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

@WebServlet("/hoaDonUserController")
public class HoaDonUserController extends HttpServlet {

	private static final long serialVerionUID = 1L;

	public HoaDonUserController() {
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
	       HoaDonBo hdbo = new HoaDonBo();
	       KhachHang khachhang = (KhachHang) session.getAttribute("dn");
	       req.setAttribute("hoadonlist", hdbo.layDanhSachHoaDonTheoKH(khachhang.getMakhachhang()));
	       req.getRequestDispatcher("TrangHoaDonUser.jsp").forward(req, resp);

	   } catch (Exception e) {
	       e.printStackTrace();
	       HttpSession session = req.getSession();
	       session.setAttribute("error", "Đã xảy ra lỗi");
	       resp.sendRedirect("gioHangController");
	   }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}