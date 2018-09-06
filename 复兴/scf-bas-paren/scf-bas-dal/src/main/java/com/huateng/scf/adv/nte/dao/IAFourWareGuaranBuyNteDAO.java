package com.huateng.scf.adv.nte.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.nte.dao.model.NoticeResultVO;

public interface IAFourWareGuaranBuyNteDAO {
	
	public static final String BeanId = "IAFourWareGuaranBuyNteDAO";

	List<NoticeResultVO> findFourWareGuaranBuyNteByPage(Map<String, Object> param, Page page);

	Integer findFourWareGuaranBuyNteCount(Map<String, Object> param);
	
}
