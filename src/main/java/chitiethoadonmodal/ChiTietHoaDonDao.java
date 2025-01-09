package chitiethoadonmodal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hoadonmodal.HoaDon;
import ketnoimodal.KetNoi;

public class ChiTietHoaDonDao {
	public void taoChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "INSERT INTO ChiTietHoaDon (tenbanh, soluongmua, mahoadon, anh) VALUES (?, ?, ?, ?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);

			cmd.setString(1, chiTietHoaDon.getTenBanh());
			cmd.setLong(2, chiTietHoaDon.getSoluongmua());
			cmd.setLong(3, chiTietHoaDon.getMahoadon());
			cmd.setString(4, chiTietHoaDon.getAnh());
			cmd.executeUpdate();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}

	public ArrayList<ChiTietHoaDon> layChiTietHoaDon(long mahoadon) throws Exception {
		ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "SELECT * FROM ChiTietHoaDon WHERE mahoadon=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, mahoadon);
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				ChiTietHoaDon cthd = new ChiTietHoaDon();
				cthd.setTenBanh(rs.getString("tenbanh"));
				cthd.setSoluongmua(rs.getLong("soluongmua"));
				cthd.setMahoadon(rs.getLong("mahoadon"));
				cthd.setAnh(rs.getString("anh"));
				dsCTHD.add(cthd);
			}

			rs.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
		return dsCTHD;
	}

	public void xoaChiTietHoaDon(long mahoadon) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "DELETE FROM ChiTietHoaDon WHERE mahoadon=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, mahoadon);
			cmd.executeUpdate();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}
}
