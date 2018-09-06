package com.huateng.scf.bas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.model.BPrdCopLib;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
* <p>
* 产品组件库服务接口
* </p>
*
* @author huangshuidan
* @date 2016年11月22日上午10:06:04
* @version 1.0
* @Copyright Shanghai Huateng Software Systems Co., Ltd.
*
*            <pre>
* =================Modify Record=======================
* Modifier			   date			              Content
* huangshuidan		   2016年12月2日上午10:06:04              新增
*
*            </pre>
*/

public interface IBPrdCopLibService {

	String add(@ScubeParam("bPrdCopLib") BPrdCopLib bPrdCopLib)
			throws ScubeBizException;

	int delete(@ScubeParam("id") String id) throws ScubeBizException;
	
	int deleteByRelId(@ScubeParam("relId") String relId) throws ScubeBizException;
	
	int update(@ScubeParam("bPrdCopLib") BPrdCopLib bPrdCopLib)
			throws ScubeBizException;

	BPrdCopLib findBPrdCopLibByKey(@ScubeParam("bPrdCopLib") BPrdCopLib bPrdCopLib)
			throws ScubeBizException;

	List<BPrdCopLib> findBPrdCopLibByBPrd(@ScubeParam("bPrdCopLib") BPrdCopLib bPrdCopLib)
			throws ScubeBizException;

	Page findBPrdCopLibByPage(@ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPrdCopLib bPrdCopLib)
			throws ScubeBizException;

}
