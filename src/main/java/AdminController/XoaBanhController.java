package AdminController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import LoaiModal.Loai;
import LoaiModal.LoaiBo;
import banhmodal.Banh;
import banhmodal.BanhBo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import banhmodal.Banh;

@WebServlet("/xoaBanhController")
public class XoaBanhController extends HttpServlet {
	private static final long serialVerionUID = 1L;

	public XoaBanhController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			String dnadmin = (String) session.getAttribute("dnadmin");

			// Nếu chưa đăng nhập hoặc không phải admin thì chuyển về trang đăng nhập
			if (dnadmin == null || !dnadmin.equals("admin")) {
				resp.sendRedirect("adminDangNhapController");
				return;
			}
			req.setCharacterEncoding("UTF-8");
			BanhBo banhbo = new BanhBo();
			Long mabanh = Long.parseLong(req.getParameter("mabanh"));
			Banh banh = banhbo.layBanh(mabanh);

			if (banh != null) {
				banhbo.xoaBanh(mabanh);
				session.setAttribute("success", "Xóa thành công");
			} else {
				session.setAttribute("error", "Xóa không thành công");
			}
			resp.sendRedirect("banhAdminController");
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("error", "Đã xảy ra lỗi");
			resp.sendRedirect("banhAdminController");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
