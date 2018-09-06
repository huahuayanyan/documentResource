package com.huateng.scf.bas.lan.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;

@Repository(IMtgLoanApplyDAO.BeanId)
public class MtgLoanApplyDAOImpl extends IbatisDaoAnnotation4Template implements IMtgLoanApplyDAO {
	
	@Resource(name="sqlMapClientTemplate")
	IbatisTemplate template;

	@SuppressWarnings("unchecked")
	@Override
	public List<BPbcAppliBaseInfo> findMtgLoanApplyByProductId(Map<String, Object> map, Page page) {
		return this.searchListPageByMap("EXT_B_LAN_MTG_LOAN.selectMtgLoanApplyByProductId", map, page);
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

}
