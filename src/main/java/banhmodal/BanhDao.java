package banhmodal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketnoimodal.KetNoi;

public class BanhDao {
	public ArrayList<Banh> getBanh() throws Exception {
		ArrayList<Banh> ds = new ArrayList<Banh>();

		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "SELECT * FROM Banh ORDER BY mabanh ASC";

			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				Long mabanh = rs.getLong("mabanh");
				String tenbanh = rs.getString("tenbanh");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String tenloai = rs.getString("tenloai");
				ds.add(new Banh(mabanh, tenbanh, anh, soluong, gia, tenloai));
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

	public ArrayList<Banh> getBanhChuaHet() throws Exception {
		ArrayList<Banh> ds = new ArrayList<Banh>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "SELECT * FROM Banh WHERE soluong > 0 ORDER BY mabanh ASC";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				Long mabanh = rs.getLong("mabanh");
				String tenbanh = rs.getString("tenbanh");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String tenloai = rs.getString("tenloai");
				ds.add(new Banh(mabanh, tenbanh, anh, soluong, gia, tenloai));
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

	public ArrayList<Banh> timBanh(String tim) throws Exception {
		ArrayList<Banh> ds = new ArrayList<Banh>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT Banh.* FROM Banh " + "WHERE (LOWER(Banh.tenbanh) LIKE ? OR LOWER(Banh.tenloai) LIKE ?) "
				+ "AND Banh.soluong > 0 " + "ORDER BY mabanh ASC";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		String timKiem = "%" + tim.toLowerCase() + "%";
		cmd.setString(1, timKiem);
		cmd.setString(2, timKiem);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			Long mabanh = rs.getLong("mabanh");
			String tenbanh = rs.getString("tenbanh");
			Long soluong = rs.getLong("soluong");
			Long gia = rs.getLong("gia");
			String anh = rs.getString("anh");
			String tenloai = rs.getString("tenloai");
			ds.add(new Banh(mabanh, tenbanh, anh, soluong, gia, tenloai));
		}

		rs.close();
		kn.cn.close();
		return ds;
	}

	public ArrayList<Banh> timBanhChuaHet(String tim) throws Exception {
		ArrayList<Banh> ds = new ArrayList<Banh>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "SELECT Banh.* FROM Banh " + "WHERE (LOWER(Banh.tenbanh) LIKE ? OR LOWER(Banh.tenloai) LIKE ?) "
				+ "AND Banh.soluong > 0 " + "ORDER BY mabanh ASC";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		String timKiem = "%" + tim.toLowerCase() + "%";
		cmd.setString(1, timKiem);
		cmd.setString(2, timKiem);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			Long mabanh = rs.getLong("mabanh");
			String tenbanh = rs.getString("tenbanh");
			Long soluong = rs.getLong("soluong");
			Long gia = rs.getLong("gia");
			String anh = rs.getString("anh");
			String tenloai = rs.getString("tenloai");
			ds.add(new Banh(mabanh, tenbanh, anh, soluong, gia, tenloai));
		}

		rs.close();
		kn.cn.close();
		return ds;
	}

	public void xoaBanh(Long maBanh) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "DELETE FROM Banh WHERE mabanh = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);

			cmd.setLong(1, maBanh);

			int ketQua = cmd.executeUpdate();

			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}

	public void taoBanh(Banh banh) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "INSERT INTO Banh (mabanh, tenbanh, soluong, gia, anh, tenloai) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);

			cmd.setLong(1, banh.getMabanh());
			cmd.setString(2, banh.getTenbanh());
			cmd.setLong(3, banh.getSoluong());
			cmd.setLong(4, banh.getGia());
			cmd.setString(5, banh.getAnh());
			cmd.setString(6, banh.getTenloai());

			int ketQua = cmd.executeUpdate();

			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}

	public void editBanh(Banh banh) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "UPDATE Banh SET tenbanh = ?, soluong = ?, gia = ?, anh = ?, tenloai = ? WHERE mabanh = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);

			cmd.setString(1, banh.getTenbanh());
			cmd.setLong(2, banh.getSoluong());
			cmd.setLong(3, banh.getGia());
			cmd.setString(4, banh.getAnh());
			cmd.setString(5, banh.getTenloai());
			cmd.setLong(6, banh.getMabanh()); // Mã bánh để xác định bánh cần update

			int ketQua = cmd.executeUpdate();

			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// Đóng kết nối
			kn.cn.close();
		}
	}

	public long timMaBanhLonNhat() throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		long maxMaBanh = 0;

		try {
			String sql = "SELECT MAX(mabanh) as max_mabanh FROM Banh";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();

			if (rs.next()) {
				maxMaBanh = rs.getLong("max_mabanh");
			}

			rs.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}

		return maxMaBanh;
	}

	public Banh getBanhByMa(long mabanh) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "SELECT * FROM Banh WHERE mabanh = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, mabanh);
			ResultSet rs = cmd.executeQuery();

			if (rs.next()) {
				String tenbanh = rs.getString("tenbanh");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String tenloai = rs.getString("tenloai");

				return new Banh(mabanh, tenbanh, anh, soluong, gia, tenloai);
			}

			rs.close();
			return null; // Trả về null nếu không tìm thấy bánh

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}
}
