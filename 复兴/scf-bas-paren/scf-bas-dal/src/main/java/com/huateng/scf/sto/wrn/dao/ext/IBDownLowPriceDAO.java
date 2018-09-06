package com.huateng.scf.sto.wrn.dao.ext;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.model.DownLowPriceNewVO;

/**
 * @author htrad0055
 *	跌破最低控货价值预警
 */
public interface IBDownLowPriceDAO {
	
	public static final String BeanId ="IBDownLowPriceDAO";

	List<DownLowPriceNewVO> selectDownLowPriceNewByPage(Map<String, Object> params, Page page);

	Integer countDownLowPriceNew(Map<String, Object> params);

}
