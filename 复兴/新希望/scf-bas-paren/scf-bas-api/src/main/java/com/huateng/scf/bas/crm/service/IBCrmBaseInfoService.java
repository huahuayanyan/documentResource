package com.huateng.scf.bas.crm.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.data.model.BdDataDictionary;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.BCrmBaseInfoAndEntInfo;
import com.huateng.scf.bas.crm.model.BCrmBrInfo;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCrmBaseInfoService {

	/**
	 * 根据客户号查询客户信息
	 * 
	 * @param custcd
	 * @return
	 */
	public BCrmBaseInfo findBCrmBaseInfoObjectByKey(@ScubeParam("custcd") String custcd);

	// 页面经办人，经办机构，客户经理转译
	public BCrmBrInfo findBCrmBrInfo(@ScubeParam("bCrmBrInfo") BCrmBrInfo bCrmBrInfo);

	public BCrmBaseInfoAndEntInfo addBcrmBaseInfo(@ScubeParam("bCrmBaseInfo") BCrmBaseInfoAndEntInfo bCrmBaseInfoAndEntInfo);

	public int deleteBCrmBaseInfoAndRelated(@ScubeParam("bCrmBaseInfo") BCrmBaseInfo bCrmBaseInfo);

	public int deleteBCrmBaseInfoCompletely(@ScubeParam("bCrmBaseInfo") BCrmBaseInfo bCrmBaseInfo);

	public int batchDelete(@ScubeParam("voList") List custcdList);

	public int update(@ScubeParam("bCrmBaseInfo") BCrmBaseInfoAndEntInfo bCrmBaseInfoAndEntInfo);

	public BCrmBaseInfo findBCrmBaseInfoByKey(@ScubeParam("bCrmBaseInfo") BCrmBaseInfo bCrmBaseInfo);

	public BCrmBaseInfo findBCrmBaseInfoByCustcd(@ScubeParam("custcd") String custcd);

	public List<BCrmBaseInfo> findBCrmBaseInfoByBCrm(@ScubeParam("bCrmBaseInfo") BCrmBaseInfo bCrmBaseInfo);

	public Page findBCrmBaseInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCrmBaseInfo") BCrmBaseInfo bCrmBaseInfo);

	public BCrmBaseInfoAndEntInfo checkBeforeAddOrSaveBCrmBrInfo(@ScubeParam("bCrmBaseInfoAndEntInfo") BCrmBaseInfoAndEntInfo bCrmBaseInfoAndEntInfo);

	// 用于客户新增页面，返回同时拥有两个表字段内容
	public BCrmBaseInfoAndEntInfo findBCrmBaseInfoByKey2(@ScubeParam("bCrmBaseInfoAndEntInfo") BCrmBaseInfoAndEntInfo BCrmBaseInfoAndEntInfo);

	// 专门用于页面下拉搜索框的分页查询
	public Page selectBCrmBaseInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCrmBaseInfo value);

	// 核心厂商管理（状态变更按钮方法）
	public int updataCoreCustStatus(@ScubeParam("value") BCrmBaseInfo value);

	// 仅仅修改客户信息（不修改对应的企业信息）
	public void updataBCrmO(@ScubeParam("value") BCrmBaseInfo value);

	// 客户名称前台校验
	public int checkCustomerForSelect(@ScubeParam("value") BCrmBaseInfo value);

	public List<BCrmBaseInfo> queryByCondition(@ScubeParam("mgrno") String mgrno);
     
	//查询客户标签数据字典
    //public Page findBCrmTabByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("value") BdDataDictionary bdDataDictionary);
	  public Page findBCrmTabByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,@ScubeParam("sysCode") String sysCode, @ScubeParam("teamCode") String teamCode, @ScubeParam("dictCode") String dictCode);
}
