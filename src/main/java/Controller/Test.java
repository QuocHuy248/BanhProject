package Controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import LoaiModal.Loai;
import LoaiModal.LoaiBo;
import banhmodal.Banh;
import banhmodal.BanhBo;
import ketnoimodal.KetNoi;

public class Test {
	public static void main(String[] args) throws Exception {
		BanhBo banhbo = new BanhBo();
		banhbo.timBanhChuaHet("banhngot");
		System.out.println(banhbo.timBanhChuaHet("banhngot").get(0).getTenbanh());
//		bo.xoaBanh("maBanh55");
//		Banh banh = new Banh();
//		banh.setAnh("anh55");
//		banh.setMabanh("maBanh55");
//		banh.setMaloai("maloai6");
//		banh.setSoluong(25L);
//		banh.setGia(34000L);
//		banh.setTenbanh("Jasmine Hibiscus");
//		bo.editBanh(banh);

	}
}
