package AdminController;

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

@WebServlet("/loaiBanhAdminController")
public class LoaiBanhAdminController extends HttpServlet {

	private static final long serialVerionUID = 1L;

	public LoaiBanhAdminController() {
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
			LoaiBo bo = new LoaiBo();
			List<Loai> loaiList = new ArrayList();
			loaiList = bo.getLoai();
			req.setAttribute("dsloai", loaiList);
			RequestDispatcher rd = req.getRequestDispatcher("TrangLoaiAdmin.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
