package banhmodal;

import java.util.ArrayList;

public class BanhBo {
	BanhDao banhdao = new BanhDao();
	ArrayList<Banh> ds;

	public ArrayList<Banh> getBanh() throws Exception {
		ds = banhdao.getBanh();
		return ds;
	}

	public ArrayList<Banh> timBanh(String timBanh) throws Exception {
		ds = banhdao.timBanh(timBanh);
		return ds;
	}

	public ArrayList<Banh> getBanhChuaHet() throws Exception {
		return banhdao.getBanhChuaHet();
	}

	public ArrayList<Banh> timBanhChuaHet(String tim) throws Exception {
		return banhdao.timBanhChuaHet(tim);

	}

	public void taoBanh(Banh banh) throws Exception {
		banh.setMabanh(banhdao.timMaBanhLonNhat() + 1);
		banhdao.taoBanh(banh);
	}

	public void xoaBanh(Long maBanh) throws Exception {
		banhdao.xoaBanh(maBanh);
	}

	public void editBanh(Banh banh) throws Exception {
		banhdao.editBanh(banh);
	}

	public Banh layBanh(Long mabanh) throws Exception {
		return banhdao.getBanhByMa(mabanh);
	}

}
