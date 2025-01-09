package lichsumodal;

import java.util.ArrayList;

public class LichSuBo {
	LichSuDao lichsudao = new LichSuDao();

	public ArrayList<LichSu> getLichSu(Long makhachhang) throws Exception {
		return lichsudao.getLichSu(makhachhang);
	}

}
