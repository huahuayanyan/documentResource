package com.huateng.scf.bas.crr.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.lan.model.vo.ContSlaveQryVO;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BCrrLnCon接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:51:34
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:51:34	     新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
public interface IBCrrLnConService {
	/**
	 * @param bCrrLnCon
	 * @return
	 */
	public void add(@ScubeParam("bCrrLnCon") BCrrLnCon bCrrLnCon);
	/**
	 * @param bCrrLnCon
	 * @return
	 */
	public int update(@ScubeParam("bCrrLnCon") BCrrLnCon bCrrLnCon);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrLnCon
	 * @return
	 */
	public Page findBCrrLnConByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrLnCon") BCrrLnCon bCrrLnCon);
	/**
	 * 
	 * @param bCrrLnCon
	 */
	public void submit(@ScubeParam("bCrrLnCon") BCrrLnCon bCrrLnCon);
	/**
	 * 
	 * @param list
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BCrrLnCon> list);
	/**
	 * 
	 * @param appId
	 * @return
	 */
	public BCrrLnCon findBCrrLnConByAppId(@ScubeParam("appId") String appId);
	/**
	 * 
	 * @param mastContQryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	public List getMastContExceptLCMastCont(@ScubeParam("mastContQryVO") MastContQryVO mastContQryVO) throws ScubeBizException;
	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	public Page getMastContByPara(@ScubeParam("commonQueryVO") OldCommonQueryVO commonQueryVO) throws ScubeBizException;
	
	public Page queryBCrrLnConLst(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("value") Map<String, String> value);
	/**
	 * 质押合同下信贷合同
	 * @param contSlaveQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午4:57:26
	 */
	public Page getContBaseInfoListBySlaveContno(@ScubeParam("contSlaveQryVO") ContSlaveQryVO contSlaveQryVO) throws ScubeBizException;
}
