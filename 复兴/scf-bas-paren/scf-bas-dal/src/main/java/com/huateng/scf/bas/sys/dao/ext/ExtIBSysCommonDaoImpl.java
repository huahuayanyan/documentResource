/**
 * 
 */
package com.huateng.scf.bas.sys.dao.ext;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;

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
@Repository("extIBSysCommonDaoImpl")
public class ExtIBSysCommonDaoImpl extends IbatisDaoAnnotation4Template implements ExtIBSysCommonDao {
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
		 List list = this.searchListPageMyObject("EXT_B_SYS_COMMON.selectBusinessTypeList", map, page);
			return  list;
	}

}
