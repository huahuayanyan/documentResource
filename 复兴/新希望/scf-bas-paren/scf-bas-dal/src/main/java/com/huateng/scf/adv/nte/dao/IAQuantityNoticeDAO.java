package com.huateng.scf.adv.nte.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.nte.dao.model.NoticeResultVO;

public interface IAQuantityNoticeDAO {
	
	public static final String BeanId = "IAQuantityNoticeDAO";

	List<NoticeResultVO> findQuantityNoticeListByPage(Map<String, Object> param, Page page);

	Integer findQuantityNoticeCount(Map<String, Object> param);

}
