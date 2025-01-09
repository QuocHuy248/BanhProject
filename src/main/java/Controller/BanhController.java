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
import banhmodal.Banh;

@WebServlet("/banhController")
public class BanhController extends HttpServlet {

	private static final long serialVerionUID = 1L;

	public BanhController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BanhBo bo = new BanhBo();
			List<Banh> banhList = new ArrayList();
			banhList = bo.getBanh();
			req.setAttribute("ds", banhList);
			RequestDispatcher rd = req.getRequestDispatcher("Trangchu.jsp");
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
