package giohangmodal;

import java.util.ArrayList;

import KhachHangModal.KhachHang;
import banhmodal.Banh;

public class GioHangBo {
	public void taoGioHang(GioHang giohang) throws Exception {
		GioHangDao dao = new GioHangDao();
		dao.taoGioHang(giohang);
	}

	public ArrayList<GioHang> layGioHang(long makhachhang) throws Exception {
		GioHangDao dao = new GioHangDao();
		return dao.layGioHang(makhachhang);
	}

	public void xoaGioHang(long makhachhang) throws Exception {
		GioHangDao dao = new GioHangDao();
		dao.xoaGioHang(makhachhang);
	}

	public void xoaGioHangTheoMaBanh(long makhachhang, long mabanh) throws Exception {
		GioHangDao dao = new GioHangDao();
		dao.xoaGioHang(makhachhang, mabanh);
	}

	public boolean checkSanPham(KhachHang khachhang, Long masanpham) throws Exception {
		GioHangDao dao = new GioHangDao();
		ArrayList<GioHang> gioHangList = dao.layGioHang(khachhang.getMakhachhang());
		for (GioHang gh : gioHangList) {
			if (gh.getMabanh() == masanpham) {
				return true;
			}
		}
		return false;
	}

	public String themBanhVaoGioHang(KhachHang khachhang, Banh banh) throws Exception {
		GioHangDao dao = new GioHangDao();
		ArrayList<GioHang> giohangList = dao.layGioHang(khachhang.getMakhachhang());

		for (GioHang gh : giohangList) {
			if (gh.getMabanh().equals(banh.getMabanh())) {
				if (gh.getSoluong().compareTo(banh.getSoluong()) < 0) {
					gh.setSoluong(gh.getSoluong() + 1);
					dao.updateGioHang(gh);
					return "Thêm sản phẩm vào giỏ hàng thành công";
				}
				return "Số lượng sản phẩm hiện tại không đủ";
			}

		}

		GioHang gioHang = new GioHang(khachhang.getMakhachhang(), banh.getMabanh(), banh.getTenbanh(), banh.getGia(),
				1L, banh.getAnh());
		dao.taoGioHang(gioHang);
		return "Thêm sản phẩm vào giỏ hàng thành công";
	}

	public GioHang layGioHangTheoBanhVaKH(long makhachhang, long mabanh) throws Exception {
		GioHangDao dao = new GioHangDao();
		return dao.layGioHangTheoBanhVaKH(makhachhang, mabanh);
	}

	public String tangGiamSanPhamTrongGioHang(GioHang giohang, Banh banh, String action) throws Exception {
		GioHangDao dao = new GioHangDao();

		if (action.equals("tang")) {
			if (giohang.getSoluong() >= banh.getSoluong()) {
				return "Số lượng sản phẩm không đủ";
			}
			giohang.setSoluong(giohang.getSoluong() + 1);
			dao.updateGioHang(giohang);
			return "Cập nhật số lượng thành công";
		}

		if (action.equals("giam")) {
			if (giohang.getSoluong() <= 1) {
				dao.xoaGioHang(giohang.getMakhachhang(), giohang.getMabanh());
				return "Đã xóa sản phẩm";
			}
			giohang.setSoluong(giohang.getSoluong() - 1);
			dao.updateGioHang(giohang);
			return "Cập nhật số lượng thành công";
		}

		return "Thao tác không hợp lệ";
	}
}
