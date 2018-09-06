package com.huateng.scf.bas.crr.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.model.WarnQryVO;
import com.huateng.scf.bas.cnt.model.BCntInsuranceBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntSlaveMtgRel;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.crr.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.model.BCrrGntyConDetail;
import com.huateng.scf.bas.lan.model.vo.ContSlaveQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>
 * BCrrGntyCon接口类
 * </p>
 *
 * @author mengjiajia
 * @date 2016年11月14日下午8:27:21
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:27:21	     新增
 *
 *            </pre>
 */
public interface IBCrrGntyConService {
	/**
	 * @param bCrrGntyCon
	 * @return
	 */
	public BCrrGntyCon add(@ScubeParam("bCrrGntyCon") BCrrGntyCon bCrrGntyCon);

	/**
	 * @param bCrrGntyCon
	 * @return
	 */
	public int update(@ScubeParam("bCrrGntyCon") BCrrGntyCon bCrrGntyCon);

	/**
	 * @param serialno
	 * @return
	 */
	public int delete(@ScubeParam("bCrrGntyCon") BCrrGntyCon bCrrGntyCon, @ScubeParam("value") HashMap<String, String> value);

	/**
	 * @param serialnos
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BCrrGntyCon> list, @ScubeParam("value") HashMap<String, String> value);

	/**
	 * 
	 * @param conId
	 * @return
	 */
	public BCrrGntyCon findBCrrGntyConByConId(@ScubeParam("conId") String conId);

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrGntyCon
	 * @return
	 */
	public Page findAppBCrrGntyConByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrrGntyCon") BCrrGntyCon bCrrGntyCon);

	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrGntyCon
	 * @return
	 */
	public Page findConBCrrGntyConByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrrGntyCon") BCrrGntyCon bCrrGntyCon);

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrGntyCon
	 * @return
	 */
	public Page findBCrrGntyConByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrrGntyCon") BCrrGntyCon bCrrGntyCon);

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	public Page findBCrrGntyConRelateByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") HashMap<String, String> value);

	/**
	 * 监管合同列表查询
	 * 
	 * @param pageNo
	 *            int-当前页码
	 * @param pageSize
	 *            int-每页大小
	 * @param monitorProtocolDO
	 *            monitorProtocol对象
	 * @return Page对象
	 * @throws ScubeBizException
	 */
	public Page queryMonitorProtocolListByPageForGntyCon(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") HashMap<String, String> value);

	/**
	 * 现货抵押-出账申请-抵质/押合同查询
	 */
	public BCrrGntyConDetail findGntyConInfoByAppno(@ScubeParam("appno") String appno);

	/**
	 * 根据协议号查询从合同信息
	 * 
	 * @param protocolNo
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BCrrGntyCon> getContSlaveByProtocolNo(@ScubeParam("protocolNo") String protocolNo) throws ScubeBizException;

	public Page getContSlaveBaseInfo(@ScubeParam("mastContQryVO") MastContQryVO mastContQryVO) throws ScubeBizException;

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrGntyCon
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月12日上午11:11:55
	 */
	public Page findBCrrGntyConByPageForCHL(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrrGntyCon") BCrrGntyCon bCrrGntyCon);

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @author mengjiajia
	 * @date 2017年4月13日上午10:47:54
	 */
	public Page findSlaveContnoByPageForCHL(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") HashMap<String, Object> value);

	// 预付类抵质押合同信息页面查询
	public Page getSlaveContList(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrrGntyCon") BCrrGntyCon bCrrGntyCon, @ScubeParam("sqlId") String sqlId);

	// 预付类新增抵质押合同信息
	public BCrrGntyCon addGntyConAndMortAndInsu(@ScubeParam("bCntSlaveMtgRel") List<BCntSlaveMtgRel> bCntSlaveMtgRel,
			@ScubeParam("bCntInsuranceBaseInfo") List<BCntInsuranceBaseInfo> bCntInsuranceBaseInfo,
			@ScubeParam("bCrrGntyCon") BCrrGntyCon bCrrGntyCon) throws ScubeBizException;

	// 预付类修改抵质押合同信息
	public BCrrGntyCon updateGntyConAndMortAndInsu(@ScubeParam("bCntSlaveMtgRel") List<BCntSlaveMtgRel> bCntSlaveMtgRel,
			@ScubeParam("bCntInsuranceBaseInfo") List<BCntInsuranceBaseInfo> bCntInsuranceBaseInfo,
			@ScubeParam("bCrrGntyCon") BCrrGntyCon bCrrGntyCon) throws ScubeBizException;

	// 预付类删除抵质押合同信息
	public BCrrGntyCon deleteGntyConAndMortAndInsu(@ScubeParam("conId") String conId) throws ScubeBizException;

	// 预付类价值管理-跌价补偿
	public Page getWarnDropCtlInfoByParamForCompensate(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("WarnQryVO") WarnQryVO warnQryVO) throws ScubeBizException;

	/**
	 * 查询抵质押合同列表
	 * 
	 * @param contSlaveQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月10日上午11:21:36
	 */
	public Page getSlaveContList2(@ScubeParam("contSlaveQryVO") ContSlaveQryVO contSlaveQryVO) throws ScubeBizException;

	/**
	 * 保存时验证质押合同是否已被其他供应链产品抢占,未抢占则更新质押合同的产品ID
	 * @param slaveContno
	 * @param supplyChainPdId
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月16日下午4:08:13
	 */
	public void checkUpdateSlaveContractBySupplyChainPdId(@ScubeParam("slaveContno") String slaveContno,@ScubeParam("supplyChainPdId") String supplyChainPdId) throws ScubeBizException;
}
