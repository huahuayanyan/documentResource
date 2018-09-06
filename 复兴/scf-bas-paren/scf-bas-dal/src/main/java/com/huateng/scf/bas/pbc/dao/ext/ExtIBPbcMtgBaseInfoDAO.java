package com.huateng.scf.bas.pbc.dao.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.dao.vo.BPbcAppliMtgInfoVO;
import com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO;

public interface ExtIBPbcMtgBaseInfoDAO {

	@SuppressWarnings("rawtypes")
	public List<BPbcMtgBaseInfo> queryMortgageEnteringList(Page page, Map map);

	/**
	 * 申请中押品列表
	 * 
	 * @param omap
	 * @param page
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月13日下午5:20:22
	 */
	List<BPbcAppliMtgInfoVO> getTblAppliMortgageBaseInfoByPara(HashMap<String, Object> omap, Page page);

	/**
	 * 申请中押品列表个数
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月13日下午5:20:25
	 */
	int countTblAppliMortgageBaseInfoByPara(HashMap<String, Object> omap);

	/**
	 * 标准仓单押品查询列表个数
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月14日上午10:38:58
	 */
	int countBillstandardMortgageQuery(HashMap<String, Object> omap);

	/**
	 * 
	 * @param omap
	 * @param page
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月18日下午5:26:00
	 */
	List<BPbcMtgBaseInfoVO> findBillstandardMortgageQuery(HashMap<String, Object> omap, Page page, boolean flag);

	/**
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月18日下午5:26:04
	 */
	@SuppressWarnings("rawtypes")
	List getMortgageSumPriceByBillMastno(HashMap<String, Object> omap);

	/**
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月18日下午5:26:07
	 */
	@SuppressWarnings("rawtypes")
	List getBillstandardMorgByBillno(HashMap<String, Object> omap, Page page, boolean flag);

	/**
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月18日下午5:26:11
	 */
	@SuppressWarnings("rawtypes")
	List findByConditionException(HashMap<String, Object> omap);

	/**
	 * 获取押品总价格
	 * 
	 * @param omap
	 * @return
	 */
	List<Map<String, Object>> getMortgageSumPriceByParam(HashMap<String, Object> omap);

	/**
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月18日下午6:55:06
	 */
	@SuppressWarnings("rawtypes")
	List getAppliMortgageTotalPrice(HashMap<String, Object> omap);

	/**
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月21日下午4:06:17
	 */
	@SuppressWarnings("rawtypes")
	List getEffectTotPrice(HashMap<String, Object> omap);

	/**
	 * 
	 * @param omap
	 * @return
	 * @author lihao
	 * @date 2017年4月25日下午4:06:17
	 */
	List<BCrrGntyCon> getPriceAdjustSlaveContGetter(Map map, Page page);

	/**
	 * 根据billno获得未锁定押品个数
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月26日下午3:09:49
	 */
	public int countBillNormalUnlockedByBillno(HashMap<String, Object> omap);

	/**
	 * 根据billno获得未锁定押品
	 * 
	 * @param omap
	 * @param page
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月26日下午3:09:52
	 */
	public List<BPbcMtgBaseInfo> getBillNormalUnlockedByBillno(HashMap<String, Object> omap, Page page);

	/**
	 * 根据仓单号查询该仓单下批次号下临时押品表价值总和
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月3日上午9:31:44
	 */
	@SuppressWarnings("rawtypes")
	public List getAppliReceiptPledgeAmountBybillno(HashMap<String, Object> omap);

	/**
	 * 获取非标准仓单置换押品总价值。
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月9日下午1:27:23
	 */
	@SuppressWarnings("rawtypes")
	public List getExchangeTotalPrice(HashMap<String, Object> omap);

	/**
	 * 获取抵制押合同下押品总价值
	 * 
	 * @param omap
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月10日下午2:52:16
	 */
	@SuppressWarnings("rawtypes")
	public List getSumPriceByslaveContno(HashMap<String, Object> omap);


	/**
	 * 存货类出质入库新增押品页面
	 */
	public List<BPbcMtgBaseInfo> getMortgageEnteringAddList(Map<String, Object> map, Page page);


	/**
	 * 查找从合同下押品总价
	 * @param omap
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月15日下午3:25:29
	 */
	@SuppressWarnings("rawtypes")
	public List getTotPriceByParam(HashMap<String, Object> omap);

	/**
	 * 价格调整查询押品信息
	 * @param page
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<BPbcMtgBaseInfo> queryMortgageEnteringListByPriceAdjust(Page page, Map map);
}