/**
 * 
 */
package com.huateng.scf.bas.sys.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.sys.dao.IBSysApplyDtlDAO;
import com.huateng.scf.bas.sys.dao.model.BSysApplyDtl;
import com.huateng.scf.bas.sys.service.IBSysApplyDtlService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>审批意见、审批历史实现类</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月16日下午6:19:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月16日下午6:19:31              新增
 *
 * </pre>
 */
@ScubeService
@Service("BSysApplyDtlServiceImpl")
public class BSysApplyDtlServiceImpl implements IBSysApplyDtlService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BSysApplyDtlDAO")
	IBSysApplyDtlDAO bSysApplyDtlDAO;
	
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.IBSysApplyDtlService#saveBSysApplyDtl(com.huateng.scf.bas.sys.dao.model.BSysApplyDtl)
	 */
	@Override
	@Transactional
	public String saveBSysApplyDtl(BSysApplyDtl bSysApplyDtl) throws ScubeBizException {
		String resultStr=bSysApplyDtlDAO.insertSelective(bSysApplyDtl);
		log.info("=====================>>>"+resultStr);
		return resultStr;
	}



	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.IBSysApplyDtlService#queryBSysApplyDtlListByPage(int, int, com.huateng.scf.bas.sys.dao.model.BSysApplyDtl)
	 */
	@Override
	public Page queryBSysApplyDtlListByPage(int pageNo, int pageSize, BSysApplyDtl bSysApplyDtl)
			throws ScubeBizException {
		Map<String, String> map=new HashMap<String, String>();
		Page scfPage=new Page();
		scfPage.setPageNo(pageNo);
		scfPage.setPageSize(pageSize);
		if(null!=bSysApplyDtl){
			String appno=bSysApplyDtl.getAppno();
			if(StringUtil.isStrNotEmpty(appno)){
				map.put("appno", appno);
			}
		}
		Page resultPage=bSysApplyDtlDAO.queryBsysApplyDtlList(scfPage, map, true);
		if(null!=resultPage){
			log.info("=====================TotalPage>>>"+resultPage.getTotalPage());
			log.info("=====================TotalRecord>>>"+resultPage.getTotalRecord());
		}
		return resultPage;
	}
	
}
