package com.huateng.scf.bas.crr.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.crr.dao.IBCrrBillInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrEqptInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrGntyRelaDAO;
import com.huateng.scf.bas.crr.dao.IBCrrInvInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLcInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLgInfoDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnAppRelaDAO;
import com.huateng.scf.bas.crr.dao.ext.ExtBCrrDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppExample;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRela;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppRelaExample;
import com.huateng.scf.bas.crr.dao.model.BCrrLnAppExample.Criteria;
import com.huateng.scf.bas.crr.model.BCrrLnApp;
import com.huateng.scf.bas.crr.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrLnAppService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scf.bas.dcr.service.IbDcrLinService;
import com.huateng.scf.bas.dcr.vo.VbDcrLin;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BCrrLnApp接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:59:26
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:59:26	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCrrLnAppServiceImpl")
public class BCrrLnAppServiceImpl implements IBCrrLnAppService,DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrLnAppDAO")
	IBCrrLnAppDAO bcrrlnappdao;
	
	@Resource(name = "ExtBCrrDAO")
	ExtBCrrDAO extbcrrdao;
	
	@Resource(name = "IBCrrLnAppRelaDAO")
	IBCrrLnAppRelaDAO bcrrlnappreladao;
	
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	@Resource(name = "IBCrrLgInfoDAO")
	IBCrrLgInfoDAO bcrrlginfodao;
	
	@Resource(name = "IBCrrEqptInfoDAO")
	IBCrrEqptInfoDAO bcrreqptinfodao;
	
	@Resource(name = "IBCrrLcInfoDAO")
	IBCrrLcInfoDAO bcrrlcinfodao;
	
	@Resource(name = "IBCrrBillInfoDAO")
	IBCrrBillInfoDAO bcrrbillinfodao;
	
	@Resource(name = "IBCrrInvInfoDAO")
	IBCrrInvInfoDAO bcrrinvinfodao;
	
	@Resource(name = "IBCrrGntyRelaDAO")
	IBCrrGntyRelaDAO bcrrgntyreladao;
	
	@Resource(name = "IBCrrGntyInfoDAO")
	IBCrrGntyInfoDAO bcrrgntyinfodao;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	@Resource(name = "BCrrLnConServiceImpl")
	BCrrLnConServiceImpl bcrrlnconservice;
	
	@Resource(name = "BCrrPrdMdServiceImpl")
	BCrrPrdMdServiceImpl bcrrprdmdservice;
	
	@Resource(name = "BDcrLinServiceImpl")
	IbDcrLinService bdcrlinservice;
	
	@Override
	@Transactional
	public BCrrLnApp add(BCrrLnApp bCrrLnApp) {
		BCrrModelCommonUtil.setAddField(bCrrLnApp);
	    // VO转PO 展现层对象转换DAO层对象
	    com.huateng.scf.bas.crr.dao.model.BCrrLnApp bCrrLnAppdal =
	    		new com.huateng.scf.bas.crr.dao.model.BCrrLnApp();
	    try
	    {
	    	BeanUtils.copyProperties(bCrrLnApp, bCrrLnAppdal);
	    }
	    catch(BeansException e)
	    {
	    	throw new ScubeBizException("转换异常");
	    }
	   
	    try
	    {
	    	bcrrlnappdao.insertSelective(bCrrLnAppdal);
	    }
	    catch(BeansException e)
	    {
	    	throw new ScubeBizException("插入异常");
	    }
	    return bCrrLnApp;
	}
	
	@Override
	public BCrrLnApp cachadd(BCrrLnApp bCrrLnApp)
	{
		String appStat = WorkflowConstant.APPLI_STATUS_UNSUBMIT;
		String appId =ibSysSerialNoService.genSerialNo("LN_APP_NO");
		String extId = ibSysSerialNoService.genSerialNo("EXT_NO");
		bCrrLnApp.setAppId(appId);
	    bCrrLnApp.setExtId(extId);
	    bCrrLnApp.setAppStat(appStat);
	    bCrrLnApp.setAppDt(ScfDateUtil.formatDate(new Date()));
	    BCrrModelCommonUtil.setAddField(bCrrLnApp);
	    return bCrrLnApp;
	}
	@Override
	@Transactional
	public int update(BCrrLnApp bCrrLnApp) {
		BCrrModelCommonUtil.setUpdateField(bCrrLnApp);
	    // VO转PO 展现层对象转换DAO层对象
	    com.huateng.scf.bas.crr.dao.model.BCrrLnApp bCrrLnAppdal =
	    		new com.huateng.scf.bas.crr.dao.model.BCrrLnApp();
	    try
	    {
	    	BeanUtils.copyProperties(bCrrLnApp, bCrrLnAppdal);
	    }
	    catch(BeansException e)
	    {
	    	throw new ScubeBizException("转换异常");
	    }
	    int i;
	    try
	    {
	    	i = bcrrlnappdao.updateByPrimaryKeySelective(bCrrLnAppdal);
	    }
	    catch(BeansException e)
	    {
	    	throw new ScubeBizException("更新异常");
	    }
		return i;
	}
	
	@Override
	@Transactional
	public String submit(BCrrLnApp bCrrLnApp){
		String appId = bCrrLnApp.getAppId();
		if(appId==null||appId.equals(""))
		{
			bCrrLnApp = add(bCrrLnApp);
			appId = bCrrLnApp.getAppId();
		}
		String appStat = WorkflowConstant.APPLI_STATUS_SUBMITUNAPPROVE;
		com.huateng.scf.bas.crr.dao.model.BCrrLnApp bCrrLnAppdal =
				new com.huateng.scf.bas.crr.dao.model.BCrrLnApp();
		BCrrModelCommonUtil.setUpdateField(bCrrLnApp);
		try
	    {
	    	BeanUtils.copyProperties(bCrrLnApp, bCrrLnAppdal);
	    }
	    catch(BeansException e)
	    {
	    	throw new ScubeBizException("提交异常");
	    }
		bCrrLnAppdal.setAppId(appId);
		bCrrLnAppdal.setAppStat(appStat);
	    try
	    {
	    	bcrrlnappdao.updateByPrimaryKeySelective(bCrrLnAppdal);
	    }
	    catch(BeansException e)
	    {
	    	throw new ScubeBizException("提交异常");
	    }
	    return "0";
	}
	
	@Override
	@Transactional
	public int delete(BCrrLnApp bCrrLnApp) 
	{
		String appId = bCrrLnApp.getAppId();
		//1.根据appId获取业务关联信息表信息
		BCrrLnAppRelaExample example = new BCrrLnAppRelaExample();
		com.huateng.scf.bas.crr.dao.model.BCrrLnAppRelaExample.Criteria cri = example.createCriteria();
		cri.andSerialnoEqualTo(appId);
	    List<BCrrLnAppRela> listdal = bcrrlnappreladao.selectByExample(example);
		if(listdal.size()>0)
		{
			for(BCrrLnAppRela lnappreladal : listdal)
			{
				//判断该业务中担保合同是否为引入合同，如果是，则只删除关联信息
				String isRelate = lnappreladal.getIsRelate();
				if(isRelate=="02"||isRelate.equals("02"))
				{
					bcrrlnappreladao.deleteByPrimaryKey(lnappreladal);
				}
				else
				{
					//2.从业务关联信息中获取担保合同conId
					String conId = lnappreladal.getRltNo();
					//3.根据conId在担保业务关联中获取担保物信息gntyId
					List<com.huateng.scf.bas.crr.dao.model.BCrrGntyRela> listgntyrela = bcrrgntyreladao.selectBySerialno(conId);
					if(listgntyrela.size()>0)
					{
						for(com.huateng.scf.bas.crr.dao.model.BCrrGntyRela bcrrgntyrela:listgntyrela)
						{
							String gntyId = bcrrgntyrela.getRltNo();
							//4.删除担保关联信息
							try
							{
								bcrrgntyreladao.deleteByRltNo(gntyId);
							}
							catch(BeansException e)
							{
								throw new ScubeBizException("删除担保关联信息异常");
							}
							//5.删除担保物信息
							try
							{
								bcrrgntyinfodao.deleteByPrimaryKey(gntyId);
							}
							catch(BeansException e)
							{
								throw new ScubeBizException("删除担保物信息异常");
							}
						}
					}
					//6.删除业务关联信息
					try
					{
						bcrrlnappreladao.deleteByPrimaryKey(lnappreladal);
					}
					catch(BeansException e)
					{
						throw new ScubeBizException("删除业务关联信息异常");
					}
					//7.删除担保合同信息
					try
					{
						bcrrgntycondao.deleteByPrimaryKey(conId);
					}
					catch(BeansException e)
					{
						throw new ScubeBizException("删除担保合同信息异常");
					}
				}
			}
		}
		//8.删除产品信息
		String extId = bCrrLnApp.getExtId();
		try
		{
			bcrrlginfodao.deleteByPrimaryKey(extId);
			bcrreqptinfodao.deleteByPrimaryKey(extId);
			bcrrlcinfodao.deleteByPrimaryKey(extId);
			bcrrbillinfodao.deleteByExtId(extId);
			bcrrinvinfodao.deleteByExtId(extId);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("删除产品信息异常");
		}
		int i;
	    try
	    {
	    	//9.删除业务申请信息
	    	i = bcrrlnappdao.deleteByPrimaryKey(appId);
	    }
	    catch(BeansException e)
	    {
	    	throw new ScubeBizException("删除异常");
	    }
		return i;
	}

	@Override
	@Transactional
	public int batchDelete(List<BCrrLnApp> list) {
		int i = 0;
		if(list.size()>0)
		{
			for(BCrrLnApp bCrrLnApp:list)
			{
				delete(bCrrLnApp);
			}
		}
		return i;
	}

	@Override
	public Page findBCrrLnAppByPage(int pageNo, int pageSize, BCrrLnApp bCrrLnApp) {
		
		BCrrLnAppExample example = new BCrrLnAppExample();
		Criteria cri = example.createCriteria();
		
		if(bCrrLnApp!=null)
		{
			//业务流水号
			if(bCrrLnApp.getAppId()!=null&&bCrrLnApp.getAppId().length()>0)
			{
				cri.andAppIdLike("%"+bCrrLnApp.getAppId()+"%");
			}
			//客户名称
			if(bCrrLnApp.getCustNm()!=null&&bCrrLnApp.getCustNm().length()>0)
			{
				cri.andCustNmLike("%"+bCrrLnApp.getCustNm()+"%");
			}
			//产品名称
			if(bCrrLnApp.getPrdNm()!=null&&bCrrLnApp.getPrdNm().length()>0)
			{
				cri.andPrdNmEqualTo(bCrrLnApp.getPrdNm());
			}
			//贷款性质
			if(bCrrLnApp.getLnNat()!=null&&bCrrLnApp.getLnNat().length()>0)
			{
				cri.andLnNatEqualTo(bCrrLnApp.getLnNat());
			}
//			cri.andTlrNoEqualTo(ContextHolder.getUserInfo().getTlrNo());
		}
		example.setOrderByClause("INP_DT DESC");
		
		int total = bcrrlnappdao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bcrrlnappdao.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}
	
	@Override
	public Page queryCustSource(int pageNo, int pageSize,Map<String, String> value) {
		log.debug("传递参数,value="+value);
		Page p = new Page(pageSize, pageNo,0);
		Map<String, String>  omap = new HashMap<String, String>(); 
		if(value!=null&&value.get("custId")!=null&&value.get("custNm")!=null){
			omap.put("custId",value.get("custId").toString().trim());
			omap.put("custNm", value.get("custNm").toString().trim());
		}
		extbcrrdao.queryCustSource(omap,p);
		return p;
	}
	
	@Override
	public BCrrLnApp findBCrrLnAppByAppId(String appId) {
		com.huateng.scf.bas.crr.dao.model.BCrrLnApp bCrrLnAppdal = bcrrlnappdao.selectByPrimaryKey(appId);
		// VO转PO 展现层对象转换DAO层对象
		BCrrLnApp bCrrLnApp = new BCrrLnApp();
		try
		{
			BeanUtils.copyProperties(bCrrLnAppdal, bCrrLnApp);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		return bCrrLnApp;
	}

	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		// TODO Auto-generated method stub
		BCrrLnApp bCrrLnApp = findBCrrLnAppByAppId(appNo);
		BCrrLnCon bCrrLnCon = new BCrrLnCon();
		try 
		{
			BeanUtils.copyProperties(bCrrLnApp, bCrrLnCon);
		} 
		catch(BeansException e) 
		{
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);

		}
		bCrrLnCon.setIndrctCrdt(bCrrLnApp.getCrMdl());
		bCrrLnCon.setCreditProtNo(bCrrLnCon.getCrNo());
		bCrrLnCon.setInpDt(ScfDateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
		bCrrLnCon.setLstUpdDt(ScfDateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
		if(bCrrLnCon.getIndrctCrdt().equals("1"))
		{
			VbDcrLin bDcrLin = bdcrlinservice.findVbDcrLinByKey(bCrrLnCon.getBcCrId());
			if(null!=bDcrLin)
			{
				bCrrLnCon.setCrdtCustCd(bDcrLin.getCustId());
				bCrrLnCon.setCrdtCustNm(bDcrLin.getCustNm());
			}
		}
		bcrrlnconservice.add(bCrrLnCon);
		bCrrLnApp.setAppStat(WorkflowConstant.APPLI_STATUS_APPROVED);
		update(bCrrLnApp);
	}

	@Override
	@Transactional
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub
		BCrrLnApp bCrrLnApp = findBCrrLnAppByAppId(appNo);
		bCrrLnApp.setAppStat(WorkflowConstant.APPLI_STATUS_REFUSED);
		update(bCrrLnApp);
	}

	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub
		
	}
}
