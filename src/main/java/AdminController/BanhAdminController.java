package AdminController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import banhmodal.Banh;
import banhmodal.BanhBo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import banhmodal.Banh;

@WebServlet("/banhAdminController")
public class BanhAdminController extends HttpServlet {

	private static final long serialVerionUID = 1L;

	public BanhAdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// Kiểm tra session
			HttpSession session = req.getSession();
			String dnadmin = (String) session.getAttribute("dnadmin");

			// Nếu chưa đăng nhập hoặc không phải admin thì chuyển về trang đăng nhập
			if (dnadmin == null || !dnadmin.equals("admin")) {
				resp.sendRedirect("adminDangNhapController");
				return;
			}

			// Nếu đã đăng nhập là admin thì thực hiện các chức năng
			BanhBo bo = new BanhBo();
			List<Banh> banhList = new ArrayList();
			banhList = bo.getBanh();
			req.setAttribute("ds", banhList);
			RequestDispatcher rd = req.getRequestDispatcher("TrangBanhAdmin.jsp");
			rd.forward(req, resp);
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