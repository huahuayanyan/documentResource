package com.huateng.scf.adv.nte.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.nte.dao.model.FourWareConfirmNoticeVO;

/**
 * @author htrad0055
 * description:
 * create Date:20170427
 */
public interface IBFourWareAcctConfirmNoticeDAO {
	
	public static final String BeanId = "IBFourWareAcctConfirmNoticeDAO";
	
	/**
	 * @param param
	 * @param page
	 * @return
	 */
	public List<FourWareConfirmNoticeVO> findAcctConfirmNoticeByPage(Map<String, Object> param,Page page);
	
	/**
	 * @param param
	 * @return
	 */
	public Integer findAcctConfirmNoticeCount(Map<String, Object> param);

}
