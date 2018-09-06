package com.huateng.scf.bas.pbc.dao.ext;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConVO;
import com.huateng.scf.bas.pbc.dao.model.ext.BPbcMtgChkStockInfoVO;

@Repository("ExtIBPbcMtgChkStockBaseInfoDAO")
public class ExtIBPbcMtgChkStockBaseInfoDaoImpl extends IbatisDaoAnnotation4Template
		implements ExtIBPbcMtgChkStockBaseInfoDAO {

	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return template;
	}

	@Override
	public List<BPbcMtgChkStockInfoVO> getCheckAccountInfoByPara(HashMap<String, Object> omap, Page page) {
		List<BPbcMtgChkStockInfoVO> list = this
				.searchListPageByMap("EXT_B_PBC_MTG_CHK_STOCK_INFO.selectBPbcMtgChkStockInfo", omap, page);
		return list;
	}

	@Override
	public int countCheckAccountInfoByPara(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate()
				.queryForObject("EXT_B_PBC_MTG_CHK_STOCK_INFO.countBPbcMtgChkStockInfo", omap);
		return count;
	}

	@Override
	public List<BCrrGntyConVO> getContSlaveInfoByProduct(HashMap<String, Object> omap, Page page) {
		List<BCrrGntyConVO> list = this.searchListPageByMap("EXT_B_PBC_MTG_CHK_STOCK_INFO.getContSlaveInfoByProduct",
				omap, page);
		return list;
	}

	@Override
	public int countContSlaveInfoByProduct(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate()
				.queryForObject("EXT_B_PBC_MTG_CHK_STOCK_INFO.countContSlaveInfoByProduct", omap);
		return count;
	}

	@Override
	public List<Map<String, String>> getTblMortgageBaseInfoPageByParam(HashMap<String, Object> omap, Page page) {
		List<Map<String, String>> list = this
				.searchListPageByMap("EXT_B_PBC_MTG_CHK_STOCK_INFO.getTblMortgageBaseInfoPageByParam", omap, page);
		return list;
	}

	@Override
	public BigDecimal getSumTblMortgageBaseInfoByParam(HashMap<String, Object> omap) {
		BigDecimal sum = (BigDecimal) getSqlMapClientTemplate()
				.queryForObject("EXT_B_PBC_MTG_CHK_STOCK_INFO.getSumTblMortgageBaseInfoByParam", omap);
		return sum;
	}

}
