package com.huateng.scf.bas.cnt.dao.ext;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.dao.model.ext.MonitorProtocolInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClass;

@Repository("ExtBCntMprotBaseInfoDAO")
public class ExtIBCntMprotBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements ExtIBCntMprotBaseInfoDAO {

	@Resource(name = "sqlMapClientTemplate")
	private IbatisTemplate template;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page queryMonitorProtocolList(Page page, Map map, boolean isByPage) {
		if (isByPage) {
			// 分页查询
			Page scfPage = new Page(page.getPageSize(), page.getPageNo(), 0);
			List<MonitorProtocolInfo> monitorProtocolVOList = this
					.searchListPageByMap("B_CNT_MPROT_BASE_INFO_EXT.queryMonitorProtocolList", map, scfPage);
			scfPage.setRecords(monitorProtocolVOList);
			return scfPage;
		} else {
			// 不分页查询
			Page scfPage = new Page();
			List<MonitorProtocolInfo> monitorProtocolVOList = getSqlMapClientTemplate()
					.queryForList("B_CNT_MPROT_BASE_INFO_EXT.queryMonitorProtocolList", map);
			scfPage.setRecords(monitorProtocolVOList);
			return scfPage;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int countMonitorProtocolList(Map map) {
		Integer count = (Integer) getSqlMapClientTemplate()
				.queryForObject("B_CNT_MPROT_BASE_INFO_EXT.countMonitorProtocolList", map);
		return count;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	// @Override
	// public Page getSecNamebyProtocol(Page page,Map map) {
	// Page scfPage = new Page(page.getPageSize(), page.getPageNo(), 0);
	// List<DataItems> dataItems =
	// this.searchListPageMyObject("B_CNT_MPROT_BASE_INFO_EXT.getSecNamebyProtocol",
	// map,scfPage);
	// scfPage.setRecords(dataItems);
	// return scfPage;
	// }

	// @Override
	// public Page getThrNamebyProtocol(Page page,Map map) {
	// Page scfPage = new Page(page.getPageSize(), page.getPageNo(), 0);
	// List<DataItems> dataItems =
	// this.searchListPageMyObject("B_CNT_MPROT_BASE_INFO_EXT.getThrNamebyProtocol",
	// map,scfPage);
	// scfPage.setRecords(dataItems);
	// return scfPage;
	// }

	// @Override
	// public MonitorProtocolInfo getThrNamebycustCd(String key) {
	// MonitorProtocolInfo monitorProtocolInfo = new MonitorProtocolInfo();
	// monitorProtocolInfo =
	// (MonitorProtocolInfo)getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_BASE_INFO_EXT.queryProductIdListbycustCd",
	// key);
	// return monitorProtocolInfo;
	// }

	@Override
	public MonitorProtocolInfo queryMonitorProtocolInfo(String protocolCode) {
		MonitorProtocolInfo monitorProtocolInfo = new MonitorProtocolInfo();
		monitorProtocolInfo = (MonitorProtocolInfo) getSqlMapClientTemplate()
				.queryForObject("B_CNT_MPROT_BASE_INFO_EXT.queryMonitorProtocolInfobyprotocolCode", protocolCode);
		return monitorProtocolInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BPbcMtgClass> queryBPbcMtgClassList(HashMap<String, Object> omap, Page page) {
		List<BPbcMtgClass> list = this.searchListPageMyObject("B_CNT_MPROT_BASE_INFO_EXT.queryBPbcMtgClassList", omap,
				page);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BPbcMtgClass> queryBPbcMtgClassName(String code) {
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("mortgageCode", BigDecimal.valueOf(Double.valueOf(code)));
		List<BPbcMtgClass> record = getSqlMapClientTemplate()
				.queryForList("B_CNT_MPROT_BASE_INFO_EXT.queryBPbcMtgClassName", omap);
		return record;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BCntMprotPartInfo> queryMprotPart(HashMap<String, String> omap) {
		List<BCntMprotPartInfo> record = getSqlMapClientTemplate()
				.queryForList("B_CNT_MPROT_BASE_INFO_EXT.queryMprotPart", omap);
		return record;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BCntMprotBaseInfo> getMutiProtDropDownInfo(HashMap<String, Object> omap, Page page) {
		List<BCntMprotBaseInfo> list = this.searchListPageMyObject("B_CNT_MPROT_BASE_INFO_EXT.getMutiProtDropDownInfo", omap, page);
        return list;
	}
	
	@Override
	public int countMutiProtDropDownInfo(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_BASE_INFO_EXT.countMutiProtDropDownInfo", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BCntMprotPartInfo> getMutiProtPartInfo(HashMap<String, Object> omap) {
		List<BCntMprotPartInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_MPROT_BASE_INFO_EXT.getMutiProtPartInfo", omap);
        return list;
	}
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.cnt.dao.ext.ExtIBCntMprotBaseInfoDAO#getMoniCustcdByMoniProtocolNo(java.util.HashMap)
	 */
	@Override
	public List getMoniCustcdByMoniProtocolNo(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("B_CNT_MPROT_BASE_INFO_EXT.getMoniCustcdByMoniProtocolNo", omap);
        return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<BCntMprotBaseInfo> getMonitorProtocolNoBySlaveContnoAppnoPt(HashMap<String, Object> omap) {
		List<BCntMprotBaseInfo> list = getSqlMapClientTemplate().queryForList("B_CNT_MPROT_BASE_INFO_EXT.getMonitorProtocolNoBySlaveContnoAppnoPt", omap);
        return list;
	}

	@Override
	public int countContSlaveByCustcdAndCore(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_BASE_INFO_EXT.countContSlaveByCustcdAndCore", omap);
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BCrrGntyCon> getContSlaveByCustcdAndCore(HashMap<String, Object> omap, Page page) {
		List<BCrrGntyCon> list = this.searchListPageByMap("B_CNT_MPROT_BASE_INFO_EXT.getContSlaveByCustcdAndCore", omap, page);
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getMonitorProtocolQuery(HashMap<String, Object> omap, Page page) {
		List list = this.searchListPageByMap("B_CNT_MPROT_BASE_INFO_EXT.getMonitorProtocolQuery", omap, page);
		return list;
	}

	@Override
	public int countMonitorProtocolQuery(HashMap<String, Object> omap) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("B_CNT_MPROT_BASE_INFO_EXT.countMonitorProtocolQuery", omap);
		return count;
	}

	
}