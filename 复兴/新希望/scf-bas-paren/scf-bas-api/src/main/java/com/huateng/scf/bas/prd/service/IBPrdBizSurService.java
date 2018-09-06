package com.huateng.scf.bas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.model.BPrdBizSur;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
* <p>
* 业务调查服务接口
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
public interface IBPrdBizSurService {
	String add(@ScubeParam("bPrdBizSur") BPrdBizSur bPrdBizSur)
			throws ScubeBizException;

	int delete(@ScubeParam("id") String id) throws ScubeBizException;
		
	int update(@ScubeParam("bPrdBizSur") BPrdBizSur bPrdBizSur)
			throws ScubeBizException;

	BPrdBizSur findBPrdBizSurByKey(@ScubeParam("bPrdBizSur") BPrdBizSur bPrdBizSur)
			throws ScubeBizException;

	List<BPrdBizSur> findBPrdBizSurByBPrd(@ScubeParam("bPrdBizSur") BPrdBizSur bPrdBizSur)
			throws ScubeBizException;

	Page findBPrdBizSurByPage(@ScubeParam("pageNo") int pageNo,
			@ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BPrdBizSur bPrdBizSur)
			throws ScubeBizException;

}
