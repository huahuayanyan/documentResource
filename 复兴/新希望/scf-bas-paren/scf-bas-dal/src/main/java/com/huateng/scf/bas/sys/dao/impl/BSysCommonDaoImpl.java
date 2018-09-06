/**
 * 
 */
package com.huateng.scf.bas.sys.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.IBSysCommonDao;

/**
 * <p>公共类下拉列表，筛选</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月28日下午7:53:07
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月28日下午7:53:07	     新增
 *
 * </pre>
 */
@Repository("bSysCommonDaoImpl")
public class BSysCommonDaoImpl extends IbatisDaoAnnotation4Template implements IBSysCommonDao {
	  @Resource(name="sqlMapClientTemplate")
	   private IbatisTemplate template;
	  public IbatisTemplate getSqlMapClientTemplate() {
			// TODO Auto-generated method stub
	        return this.template;

		}
	/**
	 * 业务品种筛选
	 * @param map
	 * @param page
	 * @return
	 */
	 public List selectBusinessType(Map map, Page page) {
		 List list = this.searchListPageMyObject("B_SYS_COMMON.selectBusinessTypeList", map, page);
			return  list;
	}
	 /**
	 * 账户筛选(结算账号,回款保证金账号,回款专户) 
	 * @param map
	 * @param page
	 * @return
	 */
	 public List selectAccountNo(Map map, Page page) {
		 List list = this.searchListPageMyObject("B_SYS_COMMON.selectAccountNoList", map, page);
			return  list;
	}

}
