/**
 * 
 */
package com.huateng.scf.bas.pbc.service;

import java.util.List;

import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcMtgStockDtl;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>押品信息变更明细</p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月29日上午10:52:44
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月29日上午10:52:44              新增
 *
 * </pre>
 */
public interface IBPbcMtgStockDtlService {
	public static final String BEAN_ID = "bPbcMtgStockDtlService";
	public void addBPbcMtgStockDtl(@ScubeParam("bPbcMtgStockDtl") BPbcMtgStockDtl bPbcMtgStockDtl) throws ScubeBizException;
	/**
	 * @param bPbcMtgStockDtl
	 * @return
	 */
	public int updateBPbcMtgStockDtl(@ScubeParam("bPbcMtgStockDtl") BPbcMtgStockDtl bPbcMtgStockDtl) throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public int deleteBPbcMtgStockDtl(@ScubeParam("key") String key)throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public BPbcMtgStockDtl findBPbcMtgStockDtlByKey(@ScubeParam("key") String key) throws ScubeBizException;
	
	/**
	 * 根据appno查询押品信息变更明细
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BPbcMtgStockDtl> findBPbcMtgStockDtlByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;
	/**
	 * 根据申请信息，保存押品信息变更明细表(公共方法)
	 * @param appliMortgageBaseInfo
	 * @param pid
	 * @param bussType
	 * @param type
	 * @param supplyChainId
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月19日下午2:19:16
	 */
	public void addTblMortgageStockInfoByAppliInfo(@ScubeParam("appliMortgageBaseInfo") BPbcAppliMtgInfoVO appliMortgageBaseInfo,@ScubeParam("pid") String pid,@ScubeParam("bussType") String bussType,
			@ScubeParam("type") String type,@ScubeParam("supplyChainId") String supplyChainId) throws ScubeBizException;
	

}
