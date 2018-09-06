/**
 * 
 */
package com.huateng.scf.bas.sys.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;

/**
 * <p>公共类下拉列表，筛选</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月28日下午7:52:18
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月28日下午7:52:18	     新增
 *
 * </pre>
 */
public interface IBSysCommonDao {
	/**
	 * 业务品种筛选
	 * @param map
	 * @param page
	 * @return
	 */
	 public List<?> selectBusinessType(Map map, Page page) ;
	 /**
	 * 账户筛选(结算账号,回款保证金账号,回款专户) 
	 * @param map
	 * @param page
	 * @return
	 */
	 public List<?> selectAccountNo(Map map, Page page) ;

}
