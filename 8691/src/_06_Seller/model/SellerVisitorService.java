package _06_Seller.model;

import java.util.ArrayList;
import java.util.List;

public class SellerVisitorService {
	private SellerVisitorJDBC sellerVisitorDao = new SellerVisitorJDBC();
	public List<SellerVisitorBean> select(SellerVisitorBean bean) {
		List<SellerVisitorBean> result = null;
		if(bean!=null && bean.getFEIN().length()!=0) {
			SellerVisitorBean temp = sellerVisitorDao.select(bean.getFEIN());
			if(temp!=null) {
				result = new ArrayList<SellerVisitorBean>();
				result.add(temp);
			}
		} else {
			result = sellerVisitorDao.select(); 
		}
		return result;
	}
	public SellerVisitorBean insert(SellerVisitorBean bean) {
		SellerVisitorBean result = null;
		if(bean!=null) {
			result = sellerVisitorDao.insert(bean);
		}
		return result;
	}
	public SellerVisitorBean update(SellerVisitorBean bean) {
		SellerVisitorBean result = null;
		if(bean!=null) {
			result = sellerVisitorDao.update(bean.getName(), bean.getAcc_email(),
					bean.getPsd(), bean.getSeller_photo(), bean.getTel(),
					bean.getGUAR_CT(), bean.getGUAR_AR(),bean.getGUAR_ROAD(),bean.getGUAR_NO(),
					bean.getEmail2(), bean.getCon_name(), bean.getCon_cel(), bean.getReceipts_metho(),
					bean.isIS_check(), bean.isIS_cooperation(), bean.getInsdate(), bean.getFEIN());
		}
		return result;
	}
	public boolean delete(SellerVisitorBean bean) {
		if(bean!=null) {
			int i = sellerVisitorDao.delete(bean.getFEIN());
			if(i==1) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		SellerVisitorService service = new SellerVisitorService();
		List<SellerVisitorBean> beans = service.select(null);
		System.out.println("beans="+beans);
	}
}