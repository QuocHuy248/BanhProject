package AdminController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import LoaiModal.Loai;
import LoaiModal.LoaiBo;
import banhmodal.Banh;
import banhmodal.BanhBo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/themLoaiBanhController")
public class ThemLoaiBanhController extends HttpServlet {
	private static final long serialVerionUID = 1L;

	public ThemLoaiBanhController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			String dnadmin = (String) session.getAttribute("dnadmin");

			// Nếu chưa đăng nhập hoặc không phải admin thì chuyển về trang đăng nhập
			if (dnadmin == null || !dnadmin.equals("admin")) {
				resp.sendRedirect("adminDangNhapController");
				return;
			}
			String tenloai = req.getParameter("tenloai");
			LoaiBo bo = new LoaiBo();
			Loai loai = new Loai();
			loai.setTenloai(tenloai);

			bo.taoLoai(loai);
			session.setAttribute("success", "Thêm loại bánh thành công");
			resp.sendRedirect("loaiBanhAdminController");

		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("error", "Đã xảy ra lỗi");
			resp.sendRedirect("loaiBanhAdminController");
		}
	}
}
