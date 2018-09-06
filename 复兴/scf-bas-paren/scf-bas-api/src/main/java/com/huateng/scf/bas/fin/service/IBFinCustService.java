package com.huateng.scf.bas.fin.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.fin.model.BFinCnfgCl;
import com.huateng.scf.bas.fin.model.BFinCust;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BFinCust接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月3日下午5:13:08
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月3日下午5:13:08	     新增
 *
 * </pre>
 */
public interface IBFinCustService {
	/**
	 * 
	 * @param bFinCust
	 * @return
	 */
	public void add(@ScubeParam("bFinCust") BFinCust bFinCust);
	/**
	 * 
	 * @param bFinCust
	 * @return
	 */
	public int update(@ScubeParam("bFinCust") BFinCust bFinCust);
	
	/**
	 * 更新客户财务记录，客户财务目录，客户财务数据
	 */
	public int updateBFinCust(@ScubeParam("bFinCust") BFinCust bFinCust);
	/**
	 * 
	 * @param finId
	 * @return
	 */
	public int delete(@ScubeParam("finId") String finId);
	/**
	 * 
	 * @param finIds
	 * @return
	 */
	public int batchDelete(@ScubeParam("finIds") String finIds);
	/**
	 * 
	 * @param finId
	 * @return
	 */
	public BFinCust findBFinCustByFinId(@ScubeParam("finId") String finId);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bFinCust
	 * @return
	 */
	public Page findBFinCustByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bFinCust") BFinCust bFinCust);
	/**
	 * 
	 * @param custId
	 * @return
	 */
	public List<BFinCnfgCl> findMdlClsByCustId(@ScubeParam("bFinCust") BFinCust bFinCust);
	
	/**
	 * 经营分析-客户信用-财报查看
	 * 根据客户id 获得客户财报记录表的年报的最新记录
	 * @param custId
	 * @return
	 * @throws ScubeBizException
	 */
	public BFinCust findBFinCustByCustId(@ScubeParam("custId")String custId) throws ScubeBizException;
	
	
	/**
	 * 经营分析-客户信用-财报查看
	 * 获得除财务报表之外的
	 * @param bFinCust
	 * @return
	 */
	public List<BFinCnfgCl> findMdlClsNotCWZB(@ScubeParam("bFinCust") BFinCust bFinCust);
	
}
