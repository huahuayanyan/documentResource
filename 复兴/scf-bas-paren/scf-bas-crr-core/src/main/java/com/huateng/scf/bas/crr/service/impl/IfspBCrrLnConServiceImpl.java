package com.huateng.scf.bas.crr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConExample;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConExample.Criteria;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrPrdMdService;
import com.huateng.scf.bas.crr.service.IIfspBCrrLnConService;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>信贷合同查询接口实现类</p>
 *
 * @author 	zhangcheng
 * @date 	2017年3月14日下午8:53:30
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * zhangcheng		2017年3月14日下午8:53:30	     新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("IfspBCrrLnConServiceImpl")
public class IfspBCrrLnConServiceImpl implements IIfspBCrrLnConService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO bcrrlncondao;
	@Resource(name = "BCrrPrdMdServiceImpl")	
	IBCrrPrdMdService bcrrprdmdservice;
	@Resource(name = "BPrdInfoServiceImpl")	
	IBPrdInfoService bprdinfoservice;
	@SuppressWarnings("unchecked")
	@Override
	public Page findBCrrLnConByPage(int pageNo, int pageSize, BCrrLnCon bCrrLnCon) {
		BCrrLnConExample example = new BCrrLnConExample();
		Criteria cri = example.createCriteria();
		
		if(bCrrLnCon!=null)
		{
			//业务流水号
			if(bCrrLnCon.getAppId()!=null&&bCrrLnCon.getAppId().length()>0)
			{
				cri.andAppIdLike("%"+bCrrLnCon.getAppId()+"%");
			}
			//客户名称
			if(bCrrLnCon.getCustNm()!=null&&bCrrLnCon.getCustNm().length()>0)
			{
				cri.andCustNmLike("%"+bCrrLnCon.getCustNm()+"%");
			}
			//产品名称
			if(bCrrLnCon.getPrdNm()!=null&&bCrrLnCon.getPrdNm().length()>0)
			{
				cri.andPrdNmEqualTo(bCrrLnCon.getPrdNm());
			}
			//合同状态
			if(bCrrLnCon.getAppStat()!=null&&bCrrLnCon.getAppStat().length()>0)
			{
				cri.andAppStatEqualTo(bCrrLnCon.getAppStat());
			}
			if(bCrrLnCon.getLnSum()!=null&&!bCrrLnCon.getLnSum().equals(""))
			{
				cri.andLnSumGreaterThan(BigDecimal.valueOf(0));
			}
			if(bCrrLnCon.getVidNo()!=null&&!bCrrLnCon.getVidNo().equals(""))
			{
				if(bCrrLnCon.getVidNo().equals("#"))
				{
					cri.andVidNoIsNotNull();
				}
				else
				{
					cri.andVidNoLike(bCrrLnCon.getVidNo());
				}
			}
			//客户号
			if(bCrrLnCon.getCustId()!=null&&bCrrLnCon.getCustId().length()>0)
			{
				cri.andCustIdEqualTo(bCrrLnCon.getCustId());
			}
			//产品品种
			if(bCrrLnCon.getVidBusiTyp()!=null&&bCrrLnCon.getVidBusiTyp().length()>0)
			{
				cri.andVidBusiTypEqualTo(bCrrLnCon.getVidBusiTyp());
			}
		}
		example.setOrderByClause("LST_UPD_DT DESC");
		
		int total = bcrrlncondao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());

		Page result = new Page();
		result.setRecords(bcrrlncondao.selectByPage(example, p));
		List<com.huateng.scf.bas.crr.dao.model.BCrrLnCon> listdal = result.getRecords();
		List<BCrrLnCon> list = 
				new ArrayList<BCrrLnCon>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.bas.crr.dao.model.BCrrLnCon lncon : listdal)
			{
				String productId = lncon.getVidBusiTyp();
				String prdId = lncon.getPrdId();
				String loanWay = bcrrprdmdservice.findBCrrPrdMdByPrdId(prdId).getLoanWay();
				lncon.setLoanWay(loanWay);
				String productNm = "";
				String parentId = "";
				if(StringUtil.isStrNotEmpty(productId))
				{
					BPrdInfo bPrdInfo = new BPrdInfo();
					bPrdInfo.setProductId(productId);
					BPrdInfo binfo = bprdinfoservice.findBPrdInfoByKey(bPrdInfo);
					productNm = binfo.getProductName();
					parentId = binfo.getParentId();
				}
				lncon.setVidPrdNm(productNm);
				lncon.setParentId(parentId);
				BCrrLnCon lncoNew=new BCrrLnCon();
				BeanUtils.copyProperties(lncon, lncoNew);
				list.add(lncoNew);
			}
		}
		
		p.setRecords(list);
		log.info("p.toString()="+p.toString());
		return p;
	}
	
	
	
}
