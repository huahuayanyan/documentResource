package com.huateng.scf.bas.crg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalDtl;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalDtlExample;
import com.huateng.scube.server.annotation.ScubeParam;

public interface IBCrgEvalDtlService {
	
	/**
	 * @param s
	 * @return
	 */
	public String getString(@ScubeParam("s") String s);

	/**
	 * @param bCrgEvalDtl
	 * @return
	 */
	
	public String add(@ScubeParam("bCrgEvalDtl") BCrgEvalDtl bCrgEvalDtl);
	
	/**
	 * @param bCrgEvalDtl
	 * @return
	 */
	
	public int update(@ScubeParam("bCrgEvalDtl") BCrgEvalDtl bCrgEvalDtl);
	
	/**
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key);
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrgEvalDtl
	 * @return
	 */
	public Page findCrgEvalDtlByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrgEvalDtl") BCrgEvalDtl bCrgEvalDtl);
	
	/**
	 * @param key
	 * @return
	 */
	public BCrgEvalDtl findCrgEvalDtlByKey(@ScubeParam("key") String key);
	
	/**
	 * 
	 * @param example
	 * @return
	 */
	public List<BCrgEvalDtl> selectByExample(@ScubeParam("example") BCrgEvalDtlExample example);

}
