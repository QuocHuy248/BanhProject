package KhachHangModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hoadonmodal.HoaDon;
import ketnoimodal.KetNoi;

public class KhachHangDao {
	public void taoKhachHang(KhachHang kh) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "INSERT INTO KhachHang (makhachhang, hoten, diachi, tendn, pass) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);

			cmd.setLong(1, kh.getMakhachhang());
			cmd.setString(2, kh.getHoten());
			cmd.setString(3, kh.getDiachi());
			cmd.setString(4, kh.getTendn());
			cmd.setString(5, kh.getPass());

			cmd.executeUpdate();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}

	public long timMaKhachHangLonNhat() throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		long maxMaKH = 0;

		try {
			String sql = "SELECT MAX(makhachhang) as max_makh FROM KhachHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();

			if (rs.next()) {
				maxMaKH = rs.getLong("max_makh");
			}

			rs.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}

		return maxMaKH;
	}
}
