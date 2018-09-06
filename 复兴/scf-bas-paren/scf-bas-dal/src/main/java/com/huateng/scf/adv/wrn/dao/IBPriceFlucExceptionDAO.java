package com.huateng.scf.adv.wrn.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;

/**
 * @author htrad0055
 *	价格跌幅预警查询
 */
public interface IBPriceFlucExceptionDAO {
	
	public static final String BeanID ="IBPriceFlucExceptionDAO";

	List getPriceFluctuationExceptionList(Map<String, Object> params, Page page);

	Integer countPriceFluctuationException(Map<String, Object> params);

}
