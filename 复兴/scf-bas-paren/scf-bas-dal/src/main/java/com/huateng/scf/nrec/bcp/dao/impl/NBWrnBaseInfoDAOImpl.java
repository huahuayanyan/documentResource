package com.huateng.scf.nrec.bcp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.nrec.bcp.dao.INBWrnBaseInfoDAO;
import com.huateng.scf.nrec.bcp.dao.domodel.NBWrnDebtPdoInfoDetailDO;

@Repository(INBWrnBaseInfoDAO.BEAN_ID)
public class NBWrnBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements INBWrnBaseInfoDAO {

	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	@SuppressWarnings("unchecked")
	@Override
	public List<NBWrnDebtPdoInfoDetailDO> getAccountDebtPromptWarnInfo(Map<String, Object> map, Page page) {
		List<NBWrnDebtPdoInfoDetailDO> list = this.searchListPageMyObject("EXT_NREC_WRN_DEBT_PDO.selectAccountDebtPromptWarn", map, page);
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAccountDebtPromptWarnInfo(HashMap<String, Object> omap, Page page) {
		List list = this.searchListPageByMap("EXT_NREC_WRN_DEBT_PDO.selectAccountDebtPromptWarnInfo", omap, page);
		return list;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

}
