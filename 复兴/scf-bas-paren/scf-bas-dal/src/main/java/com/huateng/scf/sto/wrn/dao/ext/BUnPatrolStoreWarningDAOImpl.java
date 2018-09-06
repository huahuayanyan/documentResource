package com.huateng.scf.sto.wrn.dao.ext;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.sto.wrn.dao.model.WarnUnPatrolStoreVO;

@Repository(IBUnPatrolStoreWarningDAO.BeanID)
public class BUnPatrolStoreWarningDAOImpl extends IbatisDaoAnnotation4Template implements IBUnPatrolStoreWarningDAO {
	
	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return template;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WarnUnPatrolStoreVO> findUnPatrolStoreWarningByPage(Map<String, Object> params, Page page) {
		List<WarnUnPatrolStoreVO> list = this.searchListPageMyObject("EXT_B_WRN_UNPATROL_STORE.selectUnPatrolStoreWarning", params, page);
		return list;
	}

	@Override
	public Integer countUnPatrolStoreWarning(Map<String, Object> params) {
		Integer count =(Integer) this.getSqlMapClientTemplate().queryForObject("EXT_B_WRN_UNPATROL_STORE.countUnPatrolStoreWarning", params);
		return count;
	}
	
	@Override
	public String getLastAppDateInWhseInspect(Map<String, Object> params){
		String lastDate =(String) this.getSqlMapClientTemplate().queryForObject("EXT_B_WRN_UNPATROL_STORE.selectLastAppDateInWhseInspect", params);
		return lastDate;
	}

}
