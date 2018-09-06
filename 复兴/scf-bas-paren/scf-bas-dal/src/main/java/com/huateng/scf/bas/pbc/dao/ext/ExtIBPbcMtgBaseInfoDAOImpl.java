package com.huateng.scf.bas.pbc.dao.ext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.dao.vo.BPbcAppliMtgInfoVO;
import com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO;

@Repository("ExtBPbcMtgBaseInfoDAO")
public class ExtIBPbcMtgBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements ExtIBPbcMtgBaseInfoDAO {
	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<BPbcMtgBaseInfo> queryMortgageEnteringList(Page page, Map map) {
		// 分页查询
		// Page scfPage = new Page(page.getPageSize(), page.getPageNo(), 0);
		// List<BPbcMtgBaseInfo>
		// bPbcMtgBaseInfo=this.searchListPageMyObject("B_PBC_MTG_BASE_INFO_EXT.queryMortgageEnteringList",
		// map, scfPage);
		// scfPage.setRecords(bPbcMtgBaseInfo);
		// return scfPage;
		List<BPbcMtgBaseInfo> list = this.searchListPageMyObject("B_PBC_MTG_BASE_INFO_EXT.queryMortgageEnteringList", map, page);
		return list;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BPbcAppliMtgInfoVO> getTblAppliMortgageBaseInfoByPara(HashMap<String, Object> omap, Page page) {
		List<BPbcAppliMtgInfoVO> list = this.searchListPageMyObject("B_PBC_MTG_BASE_INFO_EXT.getTblAppliMortgageBaseInfoByPara", omap, page);
		return list;
	}

	@Override
	public int countTblAppliMortgageBaseInfoByPara(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_BASE_INFO_EXT.countTblAppliMortgageBaseInfoByPara", omap);
		return count;
	}

	@Override
	public int countBillstandardMortgageQuery(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_BASE_INFO_EXT.countBillstandardMortgageQuery", omap);
		return count;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<BPbcMtgBaseInfoVO> findBillstandardMortgageQuery(HashMap<String, Object> omap, Page page, boolean flag) {
		List<BPbcMtgBaseInfoVO> list = new ArrayList<BPbcMtgBaseInfoVO>();
		if (flag) {
			list = this.searchListPageMyObject("B_PBC_MTG_BASE_INFO_EXT.findBillstandardMortgageQuery", omap, page);
		} else {
			list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_BASE_INFO_EXT.findBillstandardMortgageQuery", omap);
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getMortgageSumPriceByBillMastno(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_BASE_INFO_EXT.getMortgageSumPriceByBillMastno", omap);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BPbcMtgBaseInfoVO> getBillstandardMorgByBillno(HashMap<String, Object> omap, Page page, boolean flag) {
		List<BPbcMtgBaseInfoVO> list = new ArrayList<BPbcMtgBaseInfoVO>();
		if (flag) {
			list = this.searchListPageMyObject("B_PBC_MTG_BASE_INFO_EXT.getBillstandardMorgByBillno", omap, page);
		} else {
			list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_BASE_INFO_EXT.getBillstandardMorgByBillno", omap);
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findByConditionException(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_BASE_INFO_EXT.findByConditionException", omap);
		return list;
	}

	@Override
	public List getMortgageSumPriceByParam(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_BASE_INFO_EXT.getMortgageSumPriceByParam", omap);
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAppliMortgageTotalPrice(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_BASE_INFO_EXT.getAppliMortgageTotalPrice", omap);
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getEffectTotPrice(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_BASE_INFO_EXT.getEffectTotPrice", omap);
		return list;
	}

	@Override
	public int countBillNormalUnlockedByBillno(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_BASE_INFO_EXT.countBillNormalUnlockedByBillno", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BPbcMtgBaseInfo> getBillNormalUnlockedByBillno(HashMap<String, Object> omap, Page page) {
		List<BPbcMtgBaseInfo> list = this.searchListPageMyObject("B_PBC_MTG_BASE_INFO_EXT.getBillNormalUnlockedByBillno", omap, page);
		return list;
	}

	@Override
	public List<BCrrGntyCon> getPriceAdjustSlaveContGetter(Map map, Page page) {
		List<BCrrGntyCon> list = this.searchListPageMyObject("B_PBC_MTG_BASE_INFO_EXT.getPriceAdjustSlaveContGetter", map, page);
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAppliReceiptPledgeAmountBybillno(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_BASE_INFO_EXT.getAppliReceiptPledgeAmountBybillno", omap);
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getExchangeTotalPrice(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_BASE_INFO_EXT.getExchangeTotalPrice", omap);
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getSumPriceByslaveContno(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_BASE_INFO_EXT.getSumPriceByslaveContno", omap);
		return list;
	}

	@Override
	public List<BPbcMtgBaseInfo> getMortgageEnteringAddList(Map<String, Object> map, Page page) {
		List<BPbcMtgBaseInfo> list = this.searchListPageMyObject("B_PBC_MTG_BASE_INFO_EXT.getMortgageEnteringAddList", map, page);
		return list;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public List getTotPriceByParam(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_BASE_INFO_EXT.getTotPriceByParam", omap);
		return list;
	}

	@Override
	public List<BPbcMtgBaseInfo> queryMortgageEnteringListByPriceAdjust(Page page, Map map) {
		List<BPbcMtgBaseInfo> list = this.searchListPageMyObject("B_PBC_MTG_BASE_INFO_EXT.queryMortgageEnteringListByPriceAdjust", map, page);
		return list;
	}

}