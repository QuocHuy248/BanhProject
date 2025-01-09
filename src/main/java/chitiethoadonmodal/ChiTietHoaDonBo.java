package chitiethoadonmodal;

import java.util.ArrayList;

import giohangmodal.GioHang;

public class ChiTietHoaDonBo {
	public void taoChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws Exception {
		ChiTietHoaDonDao cthddao = new ChiTietHoaDonDao();
		cthddao.taoChiTietHoaDon(chiTietHoaDon);
	}

	public ArrayList<ChiTietHoaDon> layChiTietHoaDon(long mahoadon) throws Exception {
		ChiTietHoaDonDao cthddao = new ChiTietHoaDonDao();
		return cthddao.layChiTietHoaDon(mahoadon);
	}

	public void xoaChiTietHoaDon(long mahoadon) throws Exception {
		ChiTietHoaDonDao cthddao = new ChiTietHoaDonDao();
		cthddao.xoaChiTietHoaDon(mahoadon);
	}

	public void taoChiTietHoaDonTheoGioHang(GioHang giohang, Long mahoadon) throws Exception {
		ChiTietHoaDonDao cthddao = new ChiTietHoaDonDao();
		ChiTietHoaDon cthd = new ChiTietHoaDon();
		cthd.setMahoadon(mahoadon);
		cthd.setSoluongmua(giohang.getSoluong());
		cthd.setTenBanh(giohang.getTenbanh());
		cthd.setAnh(giohang.getAnh());
		cthd.setGia(giohang.getGia());
		cthddao.taoChiTietHoaDon(cthd);
	}
}
