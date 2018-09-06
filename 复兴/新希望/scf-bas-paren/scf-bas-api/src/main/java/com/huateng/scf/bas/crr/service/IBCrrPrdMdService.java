package com.huateng.scf.bas.crr.service;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.model.BCrrPrdMd;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>BCrrPrdMd接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月28日下午5:11:28
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月28日下午5:11:28	     新增
 *
 * </pre>
 */
public interface IBCrrPrdMdService {
	/**
	 * @param bCrrPrdMd
	 * @return
	 */
	public void add(@ScubeParam("bCrrPrdMd") BCrrPrdMd bCrrPrdMd);
	/**
	 * @param bCrrPrdMd
	 * @return
	 */
	public int update(@ScubeParam("bCrrPrdMd") BCrrPrdMd bCrrPrdMd);
	/**
	 * @param bCrrPrdMd
	 * @return
	 */
	public int delete(@ScubeParam("bCrrPrdMd") BCrrPrdMd bCrrPrdMd);
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param bCrrPrdMd
	 * @return
	 */
	public Page findBCrrPrdMdByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrrPrdMd") BCrrPrdMd bCrrPrdMd);
	/**
	 * 
	 * @param list
	 * @return
	 */
	public int batchDelete(@ScubeParam("list") List<BCrrPrdMd> list);
	/**
	 * 
	 * @param prdId
	 * @return
	 */
	public String checkPrdId(@ScubeParam("prdId") String prdId);
	/**
	 * 
	 * @param prdNm
	 * @return
	 */
	public String checkPrdNm(@ScubeParam("prdNm") String prdNm);
	/**
	 * 
	 * @param bCrrPrdMd
	 * @return
	 */
	public String checkPrdMd(@ScubeParam("bCrrPrdMd") BCrrPrdMd bCrrPrdMd);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 */
	public Page queryPrdMdSource(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") Map<String, String> value);
	/**
	 * 
	 * @param prdId
	 * @return
	 */
	public BCrrPrdMd findBCrrPrdMdByPrdId(@ScubeParam("prdId") String prdId);
}
