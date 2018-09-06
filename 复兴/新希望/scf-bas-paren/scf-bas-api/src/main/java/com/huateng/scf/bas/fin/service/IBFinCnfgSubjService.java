package com.huateng.scf.bas.fin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.TreeModel;
import com.huateng.scf.bas.fin.model.BFinCnfgSubj;
import com.huateng.scube.server.annotation.ScubeParam;
/**
 * <p>BFinCnfgSubj接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月3日下午2:18:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月3日下午2:18:24	     新增
 *
 * </pre>
 */
public interface IBFinCnfgSubjService{
	/**
	 * @param s
	 * @return
	 */
	public String getString(@ScubeParam("s") String s);
	/**
	 * @param subjNm
	 * @return
	 */
	public BFinCnfgSubj findBFinCnfgSubjByName(@ScubeParam("subjNm") String subjNm);
	/**
	 * @param bFinCnfgSubj
	 * @return
	 */
	public String add(@ScubeParam("bFinCnfgSubj") BFinCnfgSubj bFinCnfgSubj);
	/**
	 * @param bFinCnfgSubj
	 * @return
	 */
	public int update(@ScubeParam("bFinCnfgSubj") BFinCnfgSubj bFinCnfgSubj);
	/**
	 * @param subjId
	 * @return
	 */
	public int delete(@ScubeParam("subjId") String subjId);
	/**
	 * @param subjIds
	 * @return
	 */
	public int batchDelete(@ScubeParam("subjIds") String subjIds);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bFinCnfgSubj
	 * @return
	 */
	public Page findBFinCnfgSubjByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bFinCnfgSubj") BFinCnfgSubj bFinCnfgSubj);
	/**
	 * @param subjId
	 * @return
	 */
	public BFinCnfgSubj findBFinCnfgSubjBysubjId(@ScubeParam("subjId") String subjId);
	/**
	 * 
	 * @param bFinCnfgSubj
	 * @return
	 */
	public List<BFinCnfgSubj> selectForSelect(@ScubeParam("bFinCnfgSubj") BFinCnfgSubj bFinCnfgSubj);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	public Page querySubjSource(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") Map<String, String> value);
	/**
	 * 
	 * @param value
	 * @return
	 */
	public List<TreeModel> changeBFinCnfgSubjToTree(@ScubeParam("value") HashMap<String, String> value);
}
