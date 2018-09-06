package com.huateng.scf.bas.mrn.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.sto.dmp.model.SBcpAppliLowerPrice;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * 
 * <p>BMrnAppliAcctInfo接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月8日下午8:23:11
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月8日下午8:23:11	     新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
public interface IBMrnAppliAcctInfoService {
	public static final String BEAN_ID = "bMrnAppliAcctInfoService";
	/**
	 * @param bMrnAppliAcctInfo
	 */
	public void add(@ScubeParam("bMrnAppliAcctInfo") BMrnAppliAcctInfo bMrnAppliAcctInfo);
	/**
	 * @param bMrnAppliAcctInfo
	 * @return
	 */
	public int update(@ScubeParam("bMrnAppliAcctInfo") BMrnAppliAcctInfo bMrnAppliAcctInfo);
	/**
	 * @param bMrnAppliAcctInfo
	 * @return
	 */
	public int delete(@ScubeParam("bMrnAppliAcctInfo") BMrnAppliAcctInfo bMrnAppliAcctInfo);
	/**
	 * @param bMrnAppliAcctInfo
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BMrnAppliAcctInfo> list);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bMrnAppliAcctInfo
	 * @return
	 */
	public Page findBMrnAppliAcctInfoByPageConNo(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("appId") String appId);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param list
	 * @return
	 */
//	public Page findBMrnAppliAcctInfoByPagebCrrBillInfo(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("list") List<BCrrBillInfo> list);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param list
	 * @return
	 */
//	public Page findBMrnAppliAcctInfoByPagebCrrInvInfo(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("list") List<BCrrInvInfo> list);
	/**
	 * 
	 * @param extId
	 * @return
	 */
//	public List<BMrnAppliAcctInfo> findBMrnAppliAcctInfoByBillId(@ScubeParam("extId") String extId);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page findBMrnAppliAcctInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("bMrnAppliAcctInfo") BMrnAppliAcctInfo bMrnAppliAcctInfo);
	
	
	/**
	 * 根据申请编号查询冻结保证金申请信息
	 * @param appno
	 * @return
	 */
	public List<BMrnAppliAcctInfo> findBMrnAppliAcctInfoByAppno(@ScubeParam("appno") String appno);
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bMrnAppliAcctInfo
	 * @return
	 */
	public Page findBMrnAppliAcctInfoByPageAndSlaveContno(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("bMrnAppliAcctInfo") BMrnAppliAcctInfo bMrnAppliAcctInfo,@ScubeParam("cache") String cache);
	/**
	 * 最低控货价值保证金追加缓存
	 * @param bMrnAppliAcctInfo
	 */
	public void cacheAdd(@ScubeParam("list") List<BLanLnciBase> list,@ScubeParam("lowerprice") SBcpAppliLowerPrice lowerprice);
	/**
	 * 最低控货价值保证金追加保存
	 * @param list
	 */
	public void save(@ScubeParam("list") List<BMrnAppliAcctInfo> list);
	
	/**
	 * 通过APPNO清空保证金表对应数据
	 * @param appno
	 * @throws ScubeBizException
	 */
	public void clearTblAppliCustAccountInfo(@ScubeParam("appno") String appno)throws ScubeBizException;
	/**
	 * 
	 * @param appno
	 * @param debetNo
	 * @return
	 * @throws ScubeBizException
	 */
	public BMrnAppliAcctInfo getTblAliCustAccInfoByAppnoAndDebetNo(@ScubeParam("appno") String appno,@ScubeParam("debetNo") String debetNo) throws ScubeBizException;
	/**
	 * 
	 * @param appno
	 * @throws ScubeBizException
	 */
	public void deleteByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;
	/**
	 * 
	 * @param appno
	 * @return
	 */
	public List<BMrnAppliAcctInfo> findByProperty(@ScubeParam("appno") String appno);
	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getBailTransferQuery(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;
	/**
	 * 
	 * @param list
	 */
	@SuppressWarnings("rawtypes")
	public void saveAll(@ScubeParam("list") List list);
	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getBillCustAccountInfoApprove(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;
	/**
	 * 
	 * @param list
	 */
	@SuppressWarnings("rawtypes")
	public void updateAll(@ScubeParam("list") List list);
	
	/**
	 * 根据申请编号查询冻结保证金信息
	 * @param appno
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月27日下午8:19:10
	 */
	public Page getAddBailAmountListByAppno(@ScubeParam("appno") String appno,@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize) throws ScubeBizException;
}
