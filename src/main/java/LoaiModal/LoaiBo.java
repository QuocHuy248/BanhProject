package LoaiModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketnoimodal.KetNoi;

public class LoaiBo {
	LoaiDao loaidao = new LoaiDao();

	public ArrayList<Loai> getLoai() throws Exception {

		ArrayList<Loai> loaiList = new ArrayList();
		loaiList = loaidao.getLoai();
		return loaiList;
	}

	public void taoLoai(Loai loai) throws Exception {
		loai.setMaloai(loaidao.timMaLoaiLonNhat() + 1);
		loaidao.taoLoai(loai);
	}

	public void editLoai(Loai loai) throws Exception {
		loaidao.editLoai(loai);
	}

	public void xoaLoai(Long maloai) throws Exception {
		loaidao.xoaLoai(maloai);
	}

	public Loai getLoaiByMa(Long maloai) throws Exception {
		return loaidao.getLoaiByMa(maloai);
	}
}
