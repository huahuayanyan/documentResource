package com.huateng.scf.bas.cnt.dao.ext;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.model.BCntMtgBaseInfo;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;

@Repository("ExtIBCntContSlaveAndMortgageInfoDAO")
public class ExtIBCntContSlaveAndMortageInfoDAOImpl extends IbatisDaoAnnotation4Template
		implements ExtIBCntContSlaveAndMortgageInfoDAO {

	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		// TODO Auto-generated method stub
		return this.template;

	}

	@Override
	public List<BCntMtgBaseInfo> getContSlaveBaseInfo(HashMap<String, Object> omap, Page page) {
		List<BCntMtgBaseInfo> list = this.searchListPageMyObject("EXT_B_CNT_B_CRR_GNTY_CON.getContSlaveAndMortgageInfo",
				omap, page);
		return list;
	}

	@Override
	public int countContSlaveBaseInfo(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate()
				.queryForObject("EXT_B_CNT_B_CRR_GNTY_CON.countContSlaveAndMortgageInfo", omap);
		return count;
	}

}
