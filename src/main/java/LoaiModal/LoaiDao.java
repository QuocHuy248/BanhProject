package LoaiModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import banhmodal.Banh;
import ketnoimodal.KetNoi;

public class LoaiDao {

	public ArrayList<Loai> getLoai() throws Exception {
		ArrayList<Loai> ds = new ArrayList<Loai>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		try {
			String sql = "SELECT * FROM Loai ORDER BY maloai ASC";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				Long maloai = rs.getLong("maloai");
				String tenloai = rs.getString("tenloai");
				ds.add(new Loai(maloai, tenloai));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}

	public void taoLoai(Loai loai) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "INSERT INTO Loai (maloai, tenloai) VALUES (?, ?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);

			cmd.setLong(1, loai.getMaloai());
			cmd.setString(2, loai.getTenloai());
			int ketQua = cmd.executeUpdate();

			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}

	public void editLoai(Loai loai) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "UPDATE Loai SET tenloai = ? WHERE maloai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);

			cmd.setLong(2, loai.getMaloai());
			cmd.setString(1, loai.getTenloai());
			int ketQua = cmd.executeUpdate();

			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}

	public long timMaLoaiLonNhat() throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		long maxMaLoai = 0;

		try {
			String sql = "SELECT MAX(maloai) as max_maloai FROM Loai";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();

			if (rs.next()) {
				maxMaLoai = rs.getLong("max_maloai");
			}

			rs.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}

		return maxMaLoai;
	}

	public void xoaLoai(long maloai) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			kn.cn.setAutoCommit(false);

			String sqlXoaLoai = "DELETE FROM Loai WHERE maloai = ?";
			PreparedStatement cmdXoaLoai = kn.cn.prepareStatement(sqlXoaLoai);
			cmdXoaLoai.setLong(1, maloai);
			int ketQua = cmdXoaLoai.executeUpdate();
			cmdXoaLoai.close();

			kn.cn.commit();

		} catch (Exception e) {
			try {
				kn.cn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
			throw e;
		} finally {
			try {
				kn.cn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			kn.cn.close();
		}
	}

	public Loai getLoaiByMa(long maloai) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "SELECT * FROM Loai WHERE maloai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, maloai);
			ResultSet rs = cmd.executeQuery();

			if (rs.next()) {
				String tenloai = rs.getString("tenloai");
				return new Loai(maloai, tenloai);
			}

			rs.close();
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}
}
