package com.huateng.scf.bas.fin.service;

import java.util.List;

import com.huateng.scf.bas.fin.model.BFinCustDs;
import com.huateng.scf.bas.fin.model.VBFinCustDs;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * 
 * <p>BFinCustDs接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月12日上午10:01:07
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月12日上午10:01:07	     新增
 *
 * </pre>
 */
public interface IBFinCustDsService {
	/**
	 * 
	 * @param bFinCustDs
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findBFinCustDsByFinId(@ScubeParam("bFinCustDs") BFinCustDs bFinCustDs);	
	/**
	 * 
	 * @param bFinCustDs
	 * @return
	 */
	public List<BFinCustDs> findBFinCustDsByFinDirId(@ScubeParam("finDirId") String finDirId);	
	/**
	 * 
	 * @param list
	 */
	public void add(@ScubeParam("list") List<BFinCustDs> list);
	/**
	 * 
	 * @param list
	 */
	public void update(@ScubeParam("list") List<BFinCustDs> list);
	/**
	 * 
	 * @param list
	 */
	public void submit(@ScubeParam("list") List<BFinCustDs> list);
	/**
	 * 
	 * @param vals
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List calCheck(@ScubeParam("list") List<BFinCustDs> list);
	/**
	 * 
	 * @param vals
	 * @return
	 */
	public String chkCheck(@ScubeParam("list") List<VBFinCustDs> list);
	/**
	 * 
	 * @param finDirId
	 * @return
	 */
	public String findFinCustDsIsDone(@ScubeParam("finDirId") String finDirId);
	
	
	/**
	 * 
	 * @param bFinCnfgCl
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findBFinCustDsListByFinDirId(@ScubeParam("finDirId") String finDirId);
	/**
	 * 
	 * @param list
	 * @return
	 */
	public List<BFinCustDs> getList(@ScubeParam("list") List<VBFinCustDs> list);
	/**
	 * 
	 * @param list
	 * @param vBFinCustDs
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List checkNum(@ScubeParam("list") List<BFinCustDs> list,@ScubeParam("finDs") VBFinCustDs finDs);
	/**
	 * 财务指标分析
	 * @param bFinCustDs
	 * 		BFinCustDs对象
	 * @return List<VBFinCustDs>
	 */
	public List<VBFinCustDs> analy(@ScubeParam("bFinCustDs") BFinCustDs bFinCustDs) throws ScubeBizException;	
	
	/**
	 * 经营分析财务指标分析
	 * @param bFinCustDs
	 * 		BFinCustDs对象
	 * @return List<VBFinCustDs>
	 */
	public List<VBFinCustDs> queryFinTargetAnaly(@ScubeParam("bFinCustDs") BFinCustDs bFinCustDs) throws ScubeBizException;
}
