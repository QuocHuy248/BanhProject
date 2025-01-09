package lichsumodal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import ketnoimodal.KetNoi;

public class LichSuDao {
	ArrayList<LichSu> lichsuList = new ArrayList();

	public ArrayList<LichSu> getLichSu(Long makhachhang) throws Exception {
		ArrayList<LichSu> ds = new ArrayList<LichSu>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "select * from Vlichsu where makh=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, makhachhang);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String tensach = rs.getString("tensach");
			long SoLuongMua = rs.getLong("soluongmua");
			long gia = rs.getLong("gia");
			long ThanhTien = rs.getLong("thanhtien");
			Date NgayMua = rs.getDate("ngaymua");
			boolean damua = rs.getBoolean("damua");
			ds.add(new LichSu(tensach, SoLuongMua, gia, ThanhTien, NgayMua, damua, makhachhang));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
