package com.huateng.scf.bas.fin.service;

import java.util.HashMap;
import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.fin.model.BFinCnfgCl;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * <p>BFinCnfgCl接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月3日下午2:17:38
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月3日下午2:17:38	     新增
 *
 * </pre>
 */
public interface IBFinCnfgClService {
	/**
	 * @param bFinCnfgCl
	 * @return
	 */
	public String add(@ScubeParam("bFinCnfgCl") BFinCnfgCl bFinCnfgCl);
	/**
	 * @param mdlId
	 * @return
	 */
	public int delete(@ScubeParam("mdlId") String mdlId);
	/**
	 * @param mdlIds
	 * @return
	 */
	public int batchDelete(@ScubeParam("mdlIds") String mdlIds);
	/**
	 * @param bFinCnfgCl
	 * @return
	 */
	public int update(@ScubeParam("bFinCnfgCl") BFinCnfgCl bFinCnfgCl);
	/**
	 * @param mdlId
	 * @return
	 */
	public BFinCnfgCl findBFinCnfgClByMdlId(@ScubeParam("mdlId") String mdlId);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bFinCnfgCl
	 * @return
	 */
	public Page findBFinCnfgClByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bFinCnfgCl") BFinCnfgCl bFinCnfgCl);
	/**
	 * @param example
	 * @return
	 */
	public List<BFinCnfgCl> selectForSelect(@ScubeParam("bFinCnfgCl") BFinCnfgCl bFinCnfgCl);
	
	/**
	 * @param mdlId
	 * @return
	 */
	public String checkMdlId(@ScubeParam("mdlId") String mdlId);
	/**
	 * 
	 * @param mdlNm
	 * @return
	 */
	public String checkMdlNm(@ScubeParam("mdlNm") String mdlNm);
	/**
	 * 
	 * @param bFinCnfgSubj
	 * @return
	 */
	public String checkMdl(@ScubeParam("bFinCnfgCl") BFinCnfgCl bFinCnfgCl);
	/**
	 * 
	 * @param bFinCnfgSubj
	 * @return
	 */
	public String checkMdlTyp(@ScubeParam("bFinCnfgCl") BFinCnfgCl bFinCnfgCl);
	/**
	 * 
	 * @param bFinCnfgCl
	 * @return
	 */
	public String checkMdlTypById(@ScubeParam("bFinCnfgCl") BFinCnfgCl bFinCnfgCl);
	/**
	 * 
	 * @param map
	 * @return
	 */
	public List<BFinCnfgCl> queryMdlByMdlId(@ScubeParam("map") HashMap<String, String> map);
}
