package KhachHangModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ketnoimodal.KetNoi;

public class KhachHangBo {
	KhachHangDao khDao = new KhachHangDao();

	public void taoKhachHang(KhachHang kh) throws Exception {
		kh.setMakhachhang(khDao.timMaKhachHangLonNhat() + 1);
		khDao.taoKhachHang(kh);
	}

	public KhachHang kiemTraDangNhap(String tendn, String pass) throws Exception {

		return khDao.kiemTraDangNhap(tendn, pass);
	}

}
