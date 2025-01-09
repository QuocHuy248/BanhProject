package hoadonmodal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import giohangmodal.GioHang;
import ketnoimodal.KetNoi;

public class HoaDonDao {
	public void taoHoaDon(HoaDon hoadon) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "INSERT INTO HoaDon (mahoadon, makhachhang, ngaymua, damua) VALUES (?, ?, ?, ?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, hoadon.getMahoadon());
			cmd.setLong(2, hoadon.getMakhachhang());
			cmd.setDate(3, (Date) hoadon.getNgaymua());
			cmd.setBoolean(4, hoadon.isDamua());
			cmd.executeUpdate();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}

	public HoaDon layHoaDon(long mahoadon) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		HoaDon hd = null;

		try {
			String sql = "SELECT * FROM HoaDon WHERE mahoadon=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, mahoadon);
			ResultSet rs = cmd.executeQuery();

			if (rs.next()) {
				hd = new HoaDon();
				hd.setMahoadon(rs.getLong("mahoadon"));
				hd.setMakhachhang(rs.getLong("makhachhang"));
				hd.setNgaymua(rs.getDate("ngaymua"));
				hd.setDamua(rs.getBoolean("damua"));
			}

			rs.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
		return hd;
	}

	public ArrayList<HoaDon> layDanhSachHoaDonTheoKH(long makhachhang) throws Exception {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "SELECT * FROM HoaDon WHERE makhachhang=? ORDER BY mahoadon DESC";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, makhachhang);
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				HoaDon hd = new HoaDon();
				hd.setMahoadon(rs.getLong("mahoadon"));
				hd.setMakhachhang(rs.getLong("makhachhang"));
				hd.setNgaymua(rs.getDate("ngaymua"));
				hd.setDamua(rs.getBoolean("damua"));
				dsHoaDon.add(hd);
			}

			rs.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
		return dsHoaDon;
	}

	public ArrayList<HoaDon> layTatCaHoaDon() throws Exception {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "SELECT * FROM HoaDon ORDER BY mahoadon DESC";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				HoaDon hd = new HoaDon();
				hd.setMahoadon(rs.getLong("mahoadon"));
				hd.setMakhachhang(rs.getLong("makhachhang"));
				hd.setNgaymua(rs.getDate("ngaymua"));
				hd.setDamua(rs.getBoolean("damua"));
				dsHoaDon.add(hd);
			}

			rs.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
		return dsHoaDon;
	}

	public long timMaHoaDonLonNhat() throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		long maxMaHoaDon = 0;

		try {
			String sql = "SELECT MAX(mahoadon) as max_mahoadon FROM HoaDon";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();

			if (rs.next()) {
				maxMaHoaDon = rs.getLong("max_mahoadon");
			}

			rs.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}

		return maxMaHoaDon;
	}

	public void updateHoaDon(HoaDon hoadon) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "UPDATE HoaDon SET makhachhang=?, ngaymua=?, damua=? WHERE mahoadon=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);

			cmd.setLong(1, hoadon.getMakhachhang());
			cmd.setDate(2, (Date) hoadon.getNgaymua());
			cmd.setBoolean(3, hoadon.isDamua());
			cmd.setLong(4, hoadon.getMahoadon());

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
