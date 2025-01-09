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

@WebServlet("/themBanhController")
@MultipartConfig
public class ThemBanhController extends HttpServlet {
	private static final long serialVerionUID = 1L;

	public ThemBanhController() {
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
			req.setCharacterEncoding("UTF-8");
			Part filePart = req.getPart("anh");
			String tenbanh = req.getParameter("tenbanh");
			String soluongStr = req.getParameter("soluong");
			Long soluong;
			try {
				soluong = Long.parseLong(soluongStr);
				if (soluong < 1) {
					soluong = 1L;
				}
			} catch (NumberFormatException e) {
				soluong = 1L;
			}

			String giaStr = req.getParameter("gia");
			Long gia;
			try {
				gia = Long.parseLong(giaStr);
				if (gia < 10000) {
					gia = 10000L;
				}
			} catch (NumberFormatException e) {
				gia = 10000L;
			}
			String tenloai = req.getParameter("tenloai");

			String fileName = null;
			if (filePart != null && filePart.getSize() > 0) {
				fileName = filePart.getSubmittedFileName();
				String uploadPath = "D:\\LeNguyenMyQuy\\LeQuocHuy2\\src\\main\\webapp\\image\\";
				File uploadDir = new File(uploadPath);
				if (!uploadDir.exists()) {
					uploadDir.mkdirs();
				}
				filePart.write(uploadPath + fileName);
				fileName = "image/" + fileName;
			}

			BanhBo bo = new BanhBo();
			Banh banh = new Banh();
			banh.setTenbanh(tenbanh);
			banh.setSoluong(soluong);
			banh.setGia(gia);
			banh.setTenloai(tenloai);
			if (fileName != null) {
				banh.setAnh(fileName);
			}

			bo.taoBanh(banh);
			session.setAttribute("success", "Thêm bánh thành công");
			resp.sendRedirect("banhAdminController");

		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("error", "Đã xảy ra lỗi");
			resp.sendRedirect("banhAdminController");
		}
	}
}
