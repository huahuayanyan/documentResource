package com.huateng.scf.bas.mrn.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.mrn.dao.IBMrnBussInfoDAO;
import com.huateng.scf.bas.mrn.dao.ext.ExtBMrnDAO;
import com.huateng.scf.bas.mrn.model.BMrnBussInfo;
import com.huateng.scf.bas.mrn.service.IBMrnBussInfoService;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>BMrnBussInfo接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月27日下午4:10:16
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月27日下午4:10:16	     新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("BMrnBussInfoServiceImpl")
public class BMrnBussInfoServiceImpl implements IBMrnBussInfoService {

	@Resource(name = "IBMrnBussInfoDAO")
	IBMrnBussInfoDAO bmrnbussinfodao;
	
	@Resource(name = "ExtBMrnDAO")
	ExtBMrnDAO extbmrndao;
	
	@Override
	public void save(BMrnBussInfo bMrnBussInfo) throws ScubeBizException
	{
		if(StringUtil.isEmpty(bMrnBussInfo.getId())){
			bMrnBussInfo.setId(UUIDGeneratorUtil.generate());
		}
		com.huateng.scf.bas.mrn.dao.model.BMrnBussInfo record = new com.huateng.scf.bas.mrn.dao.model.BMrnBussInfo();
		BeanUtils.copyProperties(bMrnBussInfo, record);
		bmrnbussinfodao.insertSelective(record);
	}
	
	/**
	 *
	 * @Description: 保证金转入信息列表查询
	 * @author mengjiajia
	 * @Created 2012-11-9下午02:39:33
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page getBailTransferQuery(OldCommonQueryVO commonQueryVO) throws ScubeBizException{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if(!StringUtil.isEmpty(commonQueryVO.getApplyType_Q())){
			omap.put("applyType", commonQueryVO.getApplyType_Q());//申请类型
		}
		if(!StringUtil.isEmpty(commonQueryVO.getCustcd_Q())){
			omap.put("custcdBuyer", commonQueryVO.getCustcd_Q());//客户号
		}
		if(!StringUtil.isEmpty(commonQueryVO.getCname_Q())){
			omap.put("cname", commonQueryVO.getCname_Q());//客户名称
		}
		if(!StringUtil.isEmpty(commonQueryVO.getSubContno_Q())){
			omap.put("subContno", commonQueryVO.getSubContno_Q());//主合同/监管协议
		}
		if(!StringUtil.isEmpty(commonQueryVO.getSlaveContno_Q())){
			omap.put("slaveContno", commonQueryVO.getSlaveContno_Q());//抵质押合同号
		}
		if(!StringUtil.isEmpty(commonQueryVO.getBailType_Q())){
			omap.put("bailType", commonQueryVO.getBailType_Q());//现金等价物类型，加以区别保证金和最高额保证金申请类型
		}
		if(!StringUtil.isEmpty(commonQueryVO.getType_Q())){
			omap.put("initType", commonQueryVO.getType_Q());//质押类型，加以区别初始、追加和最高额保证金
		}
		if (!StringUtil.isEmpty(commonQueryVO.getBrcode_Q())) {// 机构号
			omap.put("parentBrcode", ContextHolder.getOrgInfo().getBrNo());
			omap.put("affiliationType", ScfBasConstant.BCTL_AFFILIATION_BELONG);
		}
		Page page = new Page(commonQueryVO.getPageSize(), commonQueryVO.getPageIndex(), 0);
		List list = extbmrndao.getBailTransferSerialQuery(omap, page);
		List result = new ArrayList();
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				HashMap<String, Object> map = (HashMap<String, Object>) list.get(i);
				Date appDate = (Date) map.get("appDate");
				String newAppDate = appDate.toString();
				map.put("newAppDate", newAppDate);
				result.add(map);
			}
		}
		page.setRecords(result);
		page.setTotalRecord(extbmrndao.countBailTransferSerialQuery(omap));
		return page;
	}
}
