/**
 * 
 */
package com.huateng.scf.bas.pbc.service;

import java.util.List;

import com.huateng.scf.adv.bcp.model.ABcpAppliImprestBuss;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgStorDeli;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>押品变更流水信息接口</p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月29日上午9:43:48
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月29日上午9:43:48              新增
 *
 * </pre>
 */
public interface IBPbcMtgStorDeliService {
	public static final String BEAN_ID = "bPbcMtgStorDeliService";
	public String addBPbcMtgStorDeli(@ScubeParam("bPbcMtgStorDeli") BPbcMtgStorDeli bPbcMtgStorDeli) throws ScubeBizException;
	/**
	 * @param bPbcMtgStorDeli
	 * @return
	 */
	public int updateBPbcMtgStorDeli(@ScubeParam("bPbcMtgStorDeli") BPbcMtgStorDeli bPbcMtgStorDeli) throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public int deleteBPbcMtgStorDeli(@ScubeParam("key") String key)throws ScubeBizException;
	/**
	 * @param key
	 * @return
	 */
	public BPbcMtgStorDeli findBPbcMtgStorDeliByKey(@ScubeParam("key") String key) throws ScubeBizException;
	
	/**
	 * 根据appno查询押品变更流水信息
	 * @param appno
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BPbcMtgStorDeli> findBPbcMtgStorDeliByAppno(@ScubeParam("appno") String appno) throws ScubeBizException;
	/**
	 * 保存 业务流水信息(1)(公用)
	 * @param appliBaseInfo
	 * @param storDeliBizType
	 * @param storOrDeli
	 * @param mortgageBizNo
	 * @param bussType
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月19日下午2:56:29
	 */
	public String addTblMortgageStorDeliInfo(@ScubeParam("appliBaseInfo") BPbcAppliBaseInfo appliBaseInfo,@ScubeParam("storDeliBizType") String storDeliBizType,@ScubeParam("storOrDeli") String storOrDeli,
			@ScubeParam("mortgageBizNo") Integer mortgageBizNo,@ScubeParam("bussType") String bussType) throws ScubeBizException;
	
	/**
	 * 四方到货出质入库押品流水信息添加
	 * 原方法名addTblMortgageStorDeliInfo
	 * @param appliBaseInfo
	 * @param storDeliBizType
	 * @param storOrDeli
	 * @param appMortgageList
	 * @return
	 * @throws ScubeBizException
	 */
	public String addMortgageStorDeliInfo(@ScubeParam("appliBaseInfo") BPbcAppliBaseInfo appliBaseInfo,@ScubeParam("storDeliBizType") String storDeliBizType,@ScubeParam("storOrDeli") String storOrDeli,
			@ScubeParam("appMortgageList") List<BPbcAppliMtgInfo> appMortgageList) throws ScubeBizException;
	
	
	/***
	 * 提货押品操作流水信息写入(线下)
	 * @param bPbcAppliBaseInfo
	 * @param aBcpAppliImprestBuss
	 * @throws ScubeBizException
	 */
	public void saveMortgageStockInfoDtl(@ScubeParam("bPbcAppliBaseInfo")BPbcAppliBaseInfo bPbcAppliBaseInfo,@ScubeParam("aBcpAppliImprestBuss") ABcpAppliImprestBuss aBcpAppliImprestBuss) throws ScubeBizException;
	
}
