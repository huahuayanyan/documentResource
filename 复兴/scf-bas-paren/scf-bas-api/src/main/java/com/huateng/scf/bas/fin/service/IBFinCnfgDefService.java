package com.huateng.scf.bas.fin.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.fin.model.BFinCnfgCl;
import com.huateng.scf.bas.fin.model.BFinCnfgDef;
import com.huateng.scf.bas.fin.model.VBFinCnfgDef;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * <p>BFinCnfgDef接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月3日下午2:18:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月3日下午2:18:04	     新增
 *
 * </pre>
 */
public interface IBFinCnfgDefService {
	/**
	 * 
	 * @param bFinCnfgDef
	 * @return
	 */
	public String add(@ScubeParam("bFinCnfgDef") BFinCnfgDef bFinCnfgDef);
	/**
	 * 
	 * @param serialno
	 * @return
	 */
	public int delete(@ScubeParam("serialno") String serialno);
	/**
	 * 
	 * @param serialnos
	 * @return
	 */
	public int batchDelete(@ScubeParam("serialnos") String serialnos);
	/**
	 * 
	 * @param bFinCnfgDef
	 * @return
	 */
	public int update(@ScubeParam("bFinCnfgDef") BFinCnfgDef bFinCnfgDef);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bFinCnfgDef
	 * @return
	 */
	public Page findBFinCnfgDefByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bFinCnfgDef") BFinCnfgDef bFinCnfgDef);
	/**
	 * 
	 * @param serialno
	 * @return
	 */
	public BFinCnfgDef findBFinCnfgDefBySerialno(@ScubeParam("serialno") String serialno);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bFinCnfgDef
	 * @return
	 */
	public Page findBFinCnfgDefByFinId(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bFinCnfgDef") BFinCnfgDef bFinCnfgDef);
	/**
	 * 
	 * @param mdlId
	 * @return
	 */
	public List<BFinCnfgDef> findBFinCnfgDefByMdlId(@ScubeParam("mdlId") String mdlId);
	/**
	 * 
	 * @param subjId
	 * @return
	 */
	public String findBFinCnfgDefBySubjId(@ScubeParam("subjIds") String subjIds);
	
	
	/**
	 * 
	 * @param bFinCnfgCl
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findBFinCnfgDefByBFinCnfgCl(@ScubeParam("bFinCnfgCl") BFinCnfgCl bFinCnfgCl);
	
	
	/**
	 * 
	 * @param bFinCnfgCl
	 * @return void
	 */
	public void saveBFinCnfgDefList(@ScubeParam("bFinCnfgDefList") List<VBFinCnfgDef> bFinCnfgDefList,@ScubeParam("bFinCnfgCl") BFinCnfgCl bFinCnfgCl);
	/**
	 * 
	 * @param bFinCnfgDef
	 */
	public void saveBFinCnfgDef(@ScubeParam("bFinCnfgDef") BFinCnfgDef bFinCnfgDef);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	public Page queryBFinCnfgDefSubjByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") HashMap<String, String> value);
	/**
	 * 
	 * @param calCode
	 * @param chkCode
	 * @return
	 */
	public HashMap<String, String> getSubjInfoByCode(@ScubeParam("calCode") String calCode,@ScubeParam("chkCode") String chkCode);
	/**
	 * 检验公式运算符准确性
	 * @param value
	 * @return
	 */
	public boolean checkRight(@ScubeParam("value") String value);
}
