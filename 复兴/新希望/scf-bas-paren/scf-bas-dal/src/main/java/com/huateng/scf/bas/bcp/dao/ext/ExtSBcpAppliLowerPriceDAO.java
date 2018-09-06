package com.huateng.scf.bas.bcp.dao.ext;

import java.util.HashMap;
import java.util.List;

import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPrice;

/**
 * 
 * <p>SBcpAppliLowerPrice数据库访问层通用接口实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月27日下午3:06:07
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月27日下午3:06:07	     新增
 *
 * </pre>
 */
public interface ExtSBcpAppliLowerPriceDAO {

	List<SBcpAppliLowerPrice> queryLowerPrice(HashMap<String, String> omap);

	@SuppressWarnings("rawtypes")
	List queryMtgTotalPrice(HashMap<String, String> omap);

	List<SBcpAppliLowerPrice> selectByAppno(String appno);
}