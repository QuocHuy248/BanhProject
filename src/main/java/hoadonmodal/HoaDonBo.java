package hoadonmodal;

import java.util.ArrayList;
import java.util.Date;

import KhachHangModal.KhachHang;
import chitiethoadonmodal.ChiTietHoaDonBo;
import giohangmodal.GioHang;
import giohangmodal.GioHangBo;

public class HoaDonBo {
	public void taoHoaDon(HoaDon hoadon) throws Exception {
		HoaDonDao hoaDonDao = new HoaDonDao();
		hoadon.setMahoadon(hoaDonDao.timMaHoaDonLonNhat() + 1);
		hoaDonDao.taoHoaDon(hoadon);
	}

	public void updateHoaDon(HoaDon hoadon) throws Exception {
		HoaDonDao hoaDonDao = new HoaDonDao();
		hoaDonDao.updateHoaDon(hoadon);
	}

	public ArrayList<HoaDon> layDanhSachHoaDonTheoKH(long makhachhang) throws Exception {
		HoaDonDao hoaDonDao = new HoaDonDao();
		return hoaDonDao.layDanhSachHoaDonTheoKH(makhachhang);
	}

	public ArrayList<HoaDon> layTatCaHoaDon() throws Exception {
		HoaDonDao hoaDonDao = new HoaDonDao();
		return hoaDonDao.layTatCaHoaDon();
	}

	public HoaDon layHoaDonTheoMa(Long mahoadon) throws Exception {
		HoaDonDao hoaDonDao = new HoaDonDao();
		return hoaDonDao.layHoaDon(mahoadon);
	}

	public void taoHoaDonTheoMaKhachHang(KhachHang khachhang) throws Exception {
		GioHangBo giohangbo = new GioHangBo();
		ArrayList<GioHang> giohangList = giohangbo.layGioHang(khachhang.getMakhachhang());
		HoaDonDao hoaDonDao = new HoaDonDao();
		HoaDon hoadon = new HoaDon();
		hoadon.setMahoadon(hoaDonDao.timMaHoaDonLonNhat() + 1);
		hoadon.setDamua(false);
		hoadon.setMakhachhang(khachhang.getMakhachhang());
		Date date = new Date();
		hoadon.setNgaymua(date);
		hoaDonDao.taoHoaDon(hoadon);
		ChiTietHoaDonBo cthdbo = new ChiTietHoaDonBo();
		for (GioHang gh : giohangList) {
			cthdbo.taoChiTietHoaDonTheoGioHang(gh, hoadon.getMahoadon());
		}
	}
}
