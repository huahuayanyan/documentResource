package com.huateng.scf.bas.cnt.dao.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.dao.model.ext.MonitorProtocolInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClass;

public interface ExtIBCntMprotBaseInfoDAO {

	@SuppressWarnings("rawtypes")
	public Page queryMonitorProtocolList(Page page, Map map, boolean isBypPage);

	// public Page getSecNamebyProtocol(Page page,Map map);

	// public Page getThrNamebyProtocol(Page page,Map map);

	// public MonitorProtocolInfo getThrNamebycustCd(String key);

	public MonitorProtocolInfo queryMonitorProtocolInfo(String protocolCode);

	/**
	 * 查询押品信息
	 * 
	 * @param omap
	 * @param page
	 * @return
	 */
	List<BPbcMtgClass> queryBPbcMtgClassList(HashMap<String, Object> omap, Page page);

	/**
	 * 根据押品编号查询押品信息
	 * 
	 * @param code
	 * @return
	 */
	List<BPbcMtgClass> queryBPbcMtgClassName(String code);

	/**
	 * 根据角色、协议号查询
	 * 
	 * @param omap
	 * @return
	 */
	List<BCntMprotPartInfo> queryMprotPart(HashMap<String, String> omap);

	@SuppressWarnings("rawtypes")
	int countMonitorProtocolList(Map map);

	List<BCntMprotBaseInfo> getMutiProtDropDownInfo(HashMap<String, Object> omap, Page page);

	int countMutiProtDropDownInfo(HashMap<String, Object> omap);
	
	List<BCntMprotPartInfo> getMutiProtPartInfo(HashMap<String, Object> omap);
	
	List<BCntMprotBaseInfo> getMonitorProtocolNoBySlaveContnoAppnoPt(HashMap<String, Object> omap);
	/**
	 * 根据监管协议号查询监管公司客户号
	 * @param omap
	 * @return
	 */
	List getMoniCustcdByMoniProtocolNo(HashMap<String, Object> omap);
	/**
	 * 
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月20日下午4:35:29
	 */
	int countContSlaveByCustcdAndCore(HashMap<String, Object> omap);
	/**
	 * 
	 * @param omap
	 * @param page
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月20日下午4:35:26
	 */
	List<BCrrGntyCon> getContSlaveByCustcdAndCore(HashMap<String, Object> omap, Page page);

	/**
	 * 
	 * @param omap
	 * @param page
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月21日下午2:39:36
	 */
	@SuppressWarnings("rawtypes")
	List getMonitorProtocolQuery(HashMap<String, Object> omap, Page page);

	int countMonitorProtocolQuery(HashMap<String, Object> omap);
}