package Controller;

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

@WebServlet("/banhUserController")
public class BanhUserController extends HttpServlet {

	private static final long serialVerionUID = 1L;

	public BanhUserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BanhBo bo = new BanhBo();
			List<Banh> banhList;
			String search = req.getParameter("search");

			if (search != null && !search.trim().isEmpty()) {
				banhList = bo.timBanhChuaHet(search);
			} else {
				banhList = bo.getBanhChuaHet();
			}

			req.setAttribute("ds", banhList);
			req.getRequestDispatcher("TrangChu.jsp").forward(req, resp);
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