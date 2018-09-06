/**
 * 
 */
package com.huateng.scf.bas.mrn.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.model.BMrnAcctBussInfo;
import com.huateng.scf.bas.mrn.vo.BailBussInfoVO;
import com.huateng.scf.bas.mrn.vo.BailLnciQryVO;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>保证金及现金等价物交易流水接口</p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月29日上午11:27:01
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月29日上午11:27:01              新增
 *
 * </pre>
 */
public interface IBMrnAcctBussInfoService {
	public static final String BEAN_ID = "bMrnAcctBussInfoService";
	public void addBMrnAcctBussInfo(@ScubeParam("bMrnAcctBussInfo") BMrnAcctBussInfo bMrnAcctBussInfo) throws ScubeBizException;
	/**
	 * @param bMrnAcctBussInfo
	 * @return
	 */
	public int updateBMrnAcctBussInfo(@ScubeParam("bMrnAcctBussInfo") BMrnAcctBussInfo bMrnAcctBussInfo) throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public int deleteBMrnAcctBussInfo(@ScubeParam("key") String key)throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public BMrnAcctBussInfo findBMrnAcctBussInfoByKey(@ScubeParam("key") String key) throws ScubeBizException;
	/**
	 * 
	 * @param appno
	 */
	public void saveBMrnAcctBussInfo(@ScubeParam("appno") String appno);
	
	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getTblCustAccountBussInfoByParam(@ScubeParam("commonQueryVO") BailLnciQryVO commonQueryVO) throws ScubeBizException;
	/**
	 * 
	 * @param bMrnAcctBussInfo
	 */
	public void save(@ScubeParam("bMrnAcctBussInfo") BMrnAcctBussInfo bMrnAcctBussInfo);
	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getBillCustAccountInfoByParam(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;
	
	public Page queryTblCustAccountBussInfoList(@ScubeParam("pageNo")int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("bMrnAcctBussInfo") BMrnAcctBussInfo bMrnAcctBussInfo); 

	/**
	 * 
	 * @param list
	 */
	@SuppressWarnings("rawtypes")
	public void updateAll(@ScubeParam("list") List list);

	public List  queryTblCustAccountBussInfoListForBMrnAcctBussInfo(@ScubeParam("bMrnAcctBussInfo")BMrnAcctBussInfo bMrnAcctBussInfo) ;
	/**
	 * 
	 * @param slaveContno
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List getAccount(@ScubeParam("slaveContno") String slaveContno);
	/**
	 * 
	 * @param bailBussInfoVO
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	public List getTblCustAccountBussInfoByBailAccountno(@ScubeParam("bailBussInfoVO") BailBussInfoVO bailBussInfoVO) throws ScubeBizException;

}
