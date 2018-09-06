/**
 * 
 */
package com.huateng.scf.bas.sys.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfGlobalInfo;
import com.huateng.scf.bas.common.startup.ScfMcachedUtil;
import com.huateng.scf.bas.sys.dao.IBSysGlobalInfoDAO;
import com.huateng.scf.bas.sys.dao.model.BSysGlobalInfo;
import com.huateng.scf.bas.sys.dao.model.BSysGlobalInfoExample;
import com.huateng.scf.bas.sys.dao.model.BSysGlobalInfoExample.Criteria;
import com.huateng.scf.bas.sys.service.IBSysGlobalInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>系统全局信息实现</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月25日下午2:06:13
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月25日下午2:06:13              新增
 *
 * </pre>
 */
@ScubeService
@Service("BSysGlobalInfoServiceImpl")
public class BSysGlobalInfoServiceImpl implements IBSysGlobalInfoService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BSysGlobalInfoDAO")
	private IBSysGlobalInfoDAO bSysGlobalInfoDAO;
	

	@Override
	public BSysGlobalInfo queryBSysGlobalInfo(BSysGlobalInfo bSysGlobalInfo) throws ScubeBizException {
		BSysGlobalInfoExample bSysGlobalInfoEp=new BSysGlobalInfoExample();
		if(null!=bSysGlobalInfo && null!=bSysGlobalInfo.getSysCode()){
			bSysGlobalInfoEp.createCriteria().andSysCodeEqualTo(bSysGlobalInfo.getSysCode());
		}
		BSysGlobalInfo bSysGlobalInfoResult=null;
		List<BSysGlobalInfo> bSysGlobalInfoList=bSysGlobalInfoDAO.selectByExample(bSysGlobalInfoEp);
		if(null!=bSysGlobalInfoList && bSysGlobalInfoList.size()>0){
			bSysGlobalInfoResult=(BSysGlobalInfo)bSysGlobalInfoList.get(0);
		}
		return bSysGlobalInfoResult;
	}

    @SuppressWarnings({ "static-access", "unused" })
	@Transactional
	@Override
	public void update(BSysGlobalInfo bSysGlobalInfo) {
		try {
			ScfGlobalInfo scfGlobalInfo = null;
			SimpleDateFormat newsdf = null;
			Date date = null;
			if(bSysGlobalInfo != null){
				scfGlobalInfo = new ScfGlobalInfo();
				scfGlobalInfo.setSysCode(bSysGlobalInfo.getSysCode());
				scfGlobalInfo.setSystemName(bSysGlobalInfo.getSystemName());
				scfGlobalInfo.setTxnDate(bSysGlobalInfo.getTbsdy());
				scfGlobalInfo.setBatDate(bSysGlobalInfo.getBhdate());
				scfGlobalInfo.setLastBatDate(bSysGlobalInfo.getLbhdate());
				scfGlobalInfo.setTxnStatus(bSysGlobalInfo.getStatus());
				SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
				date = sdf.parse(bSysGlobalInfo.getTbsdy());
			    newsdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				scfGlobalInfo.setTimestamps(Timestamp.valueOf(newsdf.format(date)));
			}else{
				throw new ScubeBizException("要修改的信息不能为空");
			}
			ScfBaseData.getInstance().setScfGlobalInfo(scfGlobalInfo);
			boolean flag = ScfMcachedUtil.putObject(ScfBasConstant.SCF_CACHE_PUT_KEY_SCFGLOBALINFO,scfGlobalInfo,
						ScfMcachedClientServiceImpl.EXP_TIME);
			
			bSysGlobalInfo.setTimestamps(Timestamp.valueOf(newsdf.format(date)));
			bSysGlobalInfoDAO.updateByPrimaryKey(bSysGlobalInfo);
		} catch (Exception e) {
			throw new ScubeBizException("修改失败！");
		}
	}

	@Override
	public Page findBSysGlobalInfoByPage(int pageNo, int pageSize, BSysGlobalInfo bSysGlobalInfo) {
		Page page = new Page(pageSize, pageNo, 0);
		BSysGlobalInfoExample example = new BSysGlobalInfoExample();
		Criteria criteria = example.createCriteria();
		List<BSysGlobalInfo> list = bSysGlobalInfoDAO.selectByPage(example, page);
		page.setRecords(list);
		return page;
	}
}
