package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import KhachHangModal.KhachHang;
import banhmodal.Banh;
import banhmodal.BanhBo;
import chitiethoadonmodal.ChiTietHoaDonBo;
import giohangmodal.GioHang;
import giohangmodal.GioHangBo;
import hoadonmodal.HoaDon;
import hoadonmodal.HoaDonBo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/chiTietHoaDonUserController")
public class ChiTietHoaDonUserController extends HttpServlet {

	private static final long serialVerionUID = 1L;

	public ChiTietHoaDonUserController() {
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
		        Long mahoadon = Long.parseLong(req.getParameter("mahoadon")); 
		        HoaDonBo hdbo = new HoaDonBo();
		        HoaDon hoadon = hdbo.layHoaDonTheoMa(mahoadon);
		        
		        if (hoadon == null) {
		            session.setAttribute("error", "Không tìm thấy hóa đơn");
		            resp.sendRedirect("hoaDonUserController");
		            return;
		        }
		        ChiTietHoaDonBo cthdbo = new ChiTietHoaDonBo();
		        req.setAttribute("hoadon", hoadon);
		        req.setAttribute("cthdList", cthdbo.layChiTietHoaDon(mahoadon));
		        req.getRequestDispatcher("TrangChiTietHoaDonUser.jsp").forward(req, resp);

		    } catch (Exception e) {
		        e.printStackTrace();
		        req.getSession().setAttribute("error", "Đã xảy ra lỗi");
		        resp.sendRedirect("hoaDonUserController");
		    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}