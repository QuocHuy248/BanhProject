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

@WebServlet("/gioHangController")
public class GioHangController extends HttpServlet {

	private static final long serialVerionUID = 1L;

	public GioHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			if (session.getAttribute("dn") == null)
				resp.sendRedirect("dangnhapController");
			else {
				KhachHang khachhang = (KhachHang) session.getAttribute("dn");
				GioHangBo bo = new GioHangBo();
				ArrayList<GioHang> giohangList = bo.layGioHang(khachhang.getMakhachhang());
				req.setAttribute("ds", giohangList);
				req.getRequestDispatcher("TrangGioHang.jsp").forward(req, resp);
			}
			resp.sendRedirect("BanhUserController");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}