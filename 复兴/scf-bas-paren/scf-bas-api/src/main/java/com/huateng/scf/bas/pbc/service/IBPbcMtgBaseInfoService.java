package com.huateng.scf.bas.pbc.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.model.MortgageQryVO;
import com.huateng.scf.sto.nwr.vo.AppliMortgageBaseQryVO;
import com.huateng.scf.sto.nwr.vo.BillNormalMortgageQryVO;
import com.huateng.scf.sto.nwr.vo.BillstandardQryVO;
import com.huateng.scf.sto.smp.model.MortgageSumPriceQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 押品基本信息接口
 * </p>
 *
 * @author liph
 * @date 2016年12月29日上午9:43:48
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * liph		   2016年12月29日上午9:43:48              新增
 *
 *            </pre>
 */
public interface IBPbcMtgBaseInfoService {
	public void addBPbcMtgBaseInfo(@ScubeParam("bPbcMtgBaseInfo") BPbcMtgBaseInfo bPbcMtgBaseInfo) throws ScubeBizException;

	/**
	 * @param bPbcMtgBaseInfo
	 * @return
	 */
	public int updateBPbcMtgBaseInfo(@ScubeParam("bPbcMtgBaseInfo") BPbcMtgBaseInfo bPbcMtgBaseInfo) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public int deleteBPbcMtgBaseInfo(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * @param key
	 * @return
	 */
	public BPbcMtgBaseInfo findBPbcMtgBaseInfoByKey(@ScubeParam("key") String key) throws ScubeBizException;

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param appno
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月13日下午6:28:42
	 */
	public Page findBPbcMtgBaseInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("appno") String appno);

	/**
	 * 
	 * @param billno
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月13日下午6:28:38
	 */
	@SuppressWarnings("rawtypes")
	public List getBillstandardMorgByBillno(@ScubeParam("billno") String billno);

	/**
	 * 
	 * @param baseInfo
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月13日下午7:55:58
	 */
	public void saveMorgBaseInfo(@ScubeParam("baseInfo") BPbcMtgBaseInfo baseInfo) throws ScubeBizException;

	/**
	 * 
	 * @param billno
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月17日下午3:58:54
	 */
	public boolean isBillstandardMorgNoExist(@ScubeParam("billno") String billno);

	/**
	 * 
	 * @param mastContno
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月18日上午9:52:55
	 */
	public BigDecimal getMortgageSumPriceByBillMastno(@ScubeParam("mastContno") String mastContno);

	/**
	 * 
	 * @param baseInfo
	 * @author mengjiajia
	 * @date 2017年4月18日下午4:25:30
	 */
	public void update(@ScubeParam("bPbcMtgBaseInfo") BPbcMtgBaseInfo bPbcMtgBaseInfo);

	/**
	 * 
	 * 根据抵制压合同号查询对应的押品信息
	 * 
	 */
	public List<BPbcMtgBaseInfo> findBPbcMtgBaseInfoBySlaveContno(@ScubeParam("slaveContno") String slaveContno) throws ScubeBizException;

	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月21日下午4:01:05
	 */
	public Page getEffectTotPrice(@ScubeParam("commonQueryVO") AppliMortgageBaseQryVO commonQueryVO) throws ScubeBizException;

	/**
	 * 获取押品列表（分页）押品明细查询(数量大于0)
	 * 
	 * @param mortgageQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getMortgageBaseInfoPageByParam(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("mortgageQryVO") MortgageQryVO mortgageQryVO) throws ScubeBizException;

	/**
	 * 获取押品总价格
	 * 
	 * @param map
	 * @return
	 */
	public BigDecimal getMortgageSumPriceByParam(@ScubeParam("map") HashMap<String, Object> map) throws ScubeBizException;

	/**
	 * 四方到货出质入库押品正式表及流水信息表写入&&更新购销合同已出质金额
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 */
	public void fhPledgeAppMortInfoDtlRecord(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 预付类，批量调价，关联抵质押合同
	 * 
	 * @param 一级二级三级和业务种类参数
	 * @throws ScubeBizException
	 */
	public Page getPriceAdjustSlaveContGetter(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bPbcMtgBaseInfo") BPbcMtgBaseInfo bPbcMtgBaseInfo) throws ScubeBizException;

	/**
	 * 查询此表下一级二级三级产品号一致的信息
	 * 
	 * @param
	 * @throws ScubeBizException
	 */
	public List<BPbcMtgBaseInfo> getMortgageInfoByMortgageLevels(@ScubeParam("bPbcMtgBaseInfo") BPbcMtgBaseInfo bPbcMtgBaseInfo)
			throws ScubeBizException;

	/**
	 * @Description: 押品加锁
	 * @author xiong_xiaolong
	 * @Created 2013-4-16下午3:52:04
	 * @param id
	 *            押品主键
	 * @param lockAppno
	 *            加锁业务编号
	 * @throws CommonException
	 */
	public void lockMortgageBaseInfo(@ScubeParam("mortgageNo") String mortgageNo, @ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 统计质押合同下 质押仓单押品金额
	 * 
	 * @param slaveContno
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月26日下午1:50:17
	 */
	@SuppressWarnings("rawtypes")
	public List calBillPledgePriceBySlaveContno(@ScubeParam("slaveContno") String slaveContno);

	/**
	 * 统计质押合同下 仓单所有押品金额
	 * 
	 * @param slaveContno
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月26日下午1:53:58
	 */
	@SuppressWarnings("rawtypes")
	public List calBillAllPriceBySlaveContno(@ScubeParam("slaveContno") String slaveContno);

	/**
	 * 根据billno获得未锁定押品
	 * 
	 * @param mortgageQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月26日下午3:04:48
	 */
	public Page getBillNormalUnlockedByBillno(@ScubeParam("mortgageQryVO") BillNormalMortgageQryVO mortgageQryVO) throws ScubeBizException;

	/**
	 * 押品解锁
	 * 
	 * @param id
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月26日下午5:57:08
	 */
	public void releaseMortgageBaseInfo(@ScubeParam("mortgageNo") String mortgageNo) throws ScubeBizException;

	/**
	 * 押品解锁（根据申请号）
	 * 
	 * @param id
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年4月26日下午5:57:08
	 */
	public void releaseMortgageBaseInfoByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;

	/**
	 * 根据仓单号查询该仓单下批次号下临时押品表价值总和
	 * 
	 * @param billno
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月3日上午9:29:12
	 */
	@SuppressWarnings("rawtypes")
	public List getAppliReceiptPledgeAmountBybillno(@ScubeParam("billno") String billno);

	/**
	 * 修改被解压押品的数量
	 * 
	 * @param mortgageNo
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月8日上午9:21:29
	 */
	public void resetMortQuantity(@ScubeParam("mortgageNo") String mortgageNo) throws ScubeBizException;

	/**
	 * 获取抵制押合同下押品总价值
	 * 
	 * @param slaveContno
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月10日下午2:50:32
	 */
	public BigDecimal getSumPriceByslaveContno(@ScubeParam("slaveContno") String slaveContno);

	/**
	 * 单表获取押品基本信息
	 * 
	 * @param billstandardQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月11日上午11:24:04
	 */
	public Page getMortgageBaseInfoByPara(@ScubeParam("billstandardQryVO") BillstandardQryVO billstandardQryVO) throws ScubeBizException;

	/**
	 * 出质入库最终审批通过修改押品基本信息数据
	 * 
	 * @param billstandardQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author
	 * @date 2017年5月11日上午11:24:04
	 */
	public void addMortgageBaseInfoByAppli(@ScubeParam("BPbcAppliMtgInfo") BPbcAppliMtgInfo appliMortgageBaseInfo,
			@ScubeParam("BPbcAppliBaseInfo") BPbcAppliBaseInfo appBaseInfo) throws ScubeBizException;

	public void addMortgageBaseInfoByAppliInfo(@ScubeParam("BPbcAppliMtgInfo") BPbcAppliMtgInfo appliMortgageBaseInfo,
			@ScubeParam("BPbcAppliBaseInfo") BPbcAppliBaseInfo appBaseInfo) throws ScubeBizException;

	/**
	 * 查找从合同下押品总价
	 * 
	 * @param appliMortgageBaseQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月15日下午3:28:24
	 */
	@SuppressWarnings("rawtypes")
	public List getTotPriceByParam(@ScubeParam("appliMortgageBaseQryVO") AppliMortgageBaseQryVO appliMortgageBaseQryVO) throws ScubeBizException;

	/**
	 * 获取押品总价格
	 * 
	 * @param commonQueryVO
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月16日下午2:21:40
	 */
	public BigDecimal getMortgageSumPriceByParam(@ScubeParam("commonQueryVO") MortgageSumPriceQryVO commonQueryVO);

	/**
	 * 根据押品编号查询押品表
	 * 
	 * @param mortgageNo
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月16日下午2:36:19
	 */
	public Page queryDeliveryMortgageByMortgageNo(@ScubeParam("mortgageNo") String mortgageNo, @ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize) throws ScubeBizException;
}
