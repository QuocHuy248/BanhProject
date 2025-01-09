package giohangmodal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import banhmodal.Banh;
import ketnoimodal.KetNoi;

public class GioHangDao {
	public void taoGioHang(GioHang giohang) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "INSERT INTO GioHang (makhachhang, mabanh, tenbanh, gia, soluong,anh) VALUES (?, ?, ?, ?, ?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, giohang.getMakhachhang());
			cmd.setLong(2, giohang.getMabanh());
			cmd.setString(3, giohang.getTenbanh());
			cmd.setLong(4, giohang.getGia());
			cmd.setLong(5, giohang.getSoluong());
			cmd.setString(6, giohang.getAnh());
			int ketQua = cmd.executeUpdate();

			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}

	public ArrayList<GioHang> layGioHang(long makhachhang) throws Exception {
		ArrayList<GioHang> dsGioHang = new ArrayList<>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "SELECT * FROM GioHang WHERE makhachhang=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, makhachhang);
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				GioHang gh = new GioHang();
				gh.setMakhachhang(rs.getLong("makhachhang"));
				gh.setMabanh(rs.getLong("mabanh"));
				gh.setTenbanh(rs.getString("tenbanh"));
				gh.setGia(rs.getLong("gia"));
				gh.setSoluong(rs.getLong("soluong"));
				dsGioHang.add(gh);
			}

			rs.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
		return dsGioHang;
	}

	public void xoaGioHang(long makhachhang) throws Exception {

		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "DELETE FROM GioHang WHERE makhachhang=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, makhachhang);
			cmd.executeUpdate();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}

	public void updateGioHang(GioHang giohang) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "UPDATE GioHang SET tenbanh=?, gia=?, soluong=?, anh=? WHERE makhachhang=? AND mabanh=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, giohang.getTenbanh());
			cmd.setLong(2, giohang.getGia());
			cmd.setLong(3, giohang.getSoluong());
			cmd.setLong(4, giohang.getMakhachhang());
			cmd.setString(5, giohang.getAnh());
			cmd.setLong(6, giohang.getMabanh());
			cmd.executeUpdate();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}

	public void xoaGioHang(long makhachhang, long mabanh) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		try {
			String sql = "DELETE FROM GioHang WHERE makhachhang=? AND mabanh=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, makhachhang);
			cmd.setLong(2, mabanh);
			cmd.executeUpdate();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			kn.cn.close();
		}
	}
	public GioHang layGioHangTheoBanhVaKH(long makhachhang, long mabanh) throws Exception {
		   KetNoi kn = new KetNoi();
		   kn.ketnoi();
		   GioHang gh = null;

		   try {
		       String sql = "SELECT * FROM GioHang WHERE makhachhang=? AND mabanh=?";
		       PreparedStatement cmd = kn.cn.prepareStatement(sql);
		       cmd.setLong(1, makhachhang);
		       cmd.setLong(2, mabanh);
		       ResultSet rs = cmd.executeQuery();

		       if(rs.next()) {
		           gh = new GioHang();
		           gh.setMakhachhang(rs.getLong("makhachhang"));
		           gh.setMabanh(rs.getLong("mabanh"));
		           gh.setTenbanh(rs.getString("tenbanh")); 
		           gh.setGia(rs.getLong("gia"));
		           gh.setSoluong(rs.getLong("soluong"));
		           gh.setAnh(rs.getString("anh"));
		       }

		       rs.close();
		       cmd.close();
		   } catch(Exception e) {
		       e.printStackTrace();
		       throw e;
		   } finally {
		       kn.cn.close();
		   }
		   return gh;
		}
}
