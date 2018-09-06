package com.huateng.scf.bas.fin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.IBBrpFinParamDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpFinParam;
import com.huateng.scf.bas.brp.dao.model.BBrpFinParamExample;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.fin.dao.IBFinCnfgDefDAO;
import com.huateng.scf.bas.fin.dao.IBFinCustDirDAO;
import com.huateng.scf.bas.fin.dao.IBFinCustDsDAO;
import com.huateng.scf.bas.fin.dao.IBFinCustDsExtDAO;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgDef;
import com.huateng.scf.bas.fin.dao.model.BFinCustDir;
import com.huateng.scf.bas.fin.dao.model.BFinCustDsExample;
import com.huateng.scf.bas.fin.dao.model.BFinCustDsExample.Criteria;
import com.huateng.scf.bas.fin.dao.model.BFinCustDsExt;
import com.huateng.scf.bas.fin.dao.model.BFinCustDsExtExample;
import com.huateng.scf.bas.fin.model.BFinCust;
import com.huateng.scf.bas.fin.model.BFinCustDs;
import com.huateng.scf.bas.fin.model.VBFinCustDs;
import com.huateng.scf.bas.fin.service.IBFinCustDsService;
import com.huateng.scf.bas.fin.service.IBFinCustService;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>BFinCustDs接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月12日上午10:03:27
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月12日上午10:03:27	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BFinCustDsServiceImpl")
public class BFinCustDsServiceImpl implements IBFinCustDsService{
	
	static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBFinCustDsDAO")
	IBFinCustDsDAO bfincustdsdao;
	
	@Resource(name = "IBFinCnfgDefDAO")
	IBFinCnfgDefDAO bfincnfgdefdao;
	
	@Resource(name = "IBFinCustDirDAO")
	IBFinCustDirDAO bfincustdirdao;
	
	@Resource(name = "BFinCnfgDefServiceImpl")
	BFinCnfgDefServiceImpl  bFinCnfgDefServiceImpl;
	
	@Resource(name = "BFinCustServiceImpl")
	IBFinCustService bfincustservice;
	@Resource(name = "BFinCustDsExtDAO")
	IBFinCustDsExtDAO bFinCustDsExtDAO;
	@Resource(name = "BBrpFinParamDAO") //财务指标参数配置
	IBBrpFinParamDAO bBrpFinParamDAO;
	
	//分析结果描述
	public static final String SUBJVAL = "SUBJVAL";// 财务指标值
	public static final String FINANALYA = "FINANALYA";// 与平均值比较结果
	public static final String FINANALYR = "FINANALYR";// 财务指标分析机构
	
	
	@Override
	public String findFinCustDsIsDone(String finDirId)
	{
		String flag = "";
		//根据finId判断该报表是否有数据
		List<com.huateng.scf.bas.fin.dao.model.BFinCustDs> isds = bfincustdsdao.selectByFinDirId(finDirId);
		if(isds.size()==0)
		{
			flag = "add";
		}
		else
		{
			flag = "update";
		}
		return flag;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public List findBFinCustDsByFinId(BFinCustDs bFinCustDs) {
		Page p=null;
		String rptNo = null;// 报表期次
		String rpSource = null;// 报表数据来源
		BFinCustDir bFinCustDir = bfincustdirdao.selectByPrimaryKey(bFinCustDs.getFinDirId());
		if (null != bFinCustDir) {
			rptNo = bFinCustDir.getRptNo();
			rpSource = bFinCustDir.getFinPd();
		}
		if(null!=bFinCustDs && ScfBasConstant.MDL_ID_CWZB.equals(bFinCustDs.getMdlId())){//财务指标
			p = bFinCnfgDefServiceImpl.findBFinCnfgDefByMdlIdRpSource(bFinCustDs.getMdlId(),rpSource);
		}else{//财务3表科目
			p = bFinCnfgDefServiceImpl.findBFinCnfgDefByBFinCnfgCl(bFinCustDs.getMdlId());
		}

		for (int j = 0; j < p.getRecords().size(); j++) {
			com.huateng.scf.bas.fin.dao.model.BFinCnfgDef bFinCnfgDef = (com.huateng.scf.bas.fin.dao.model.BFinCnfgDef) p
					.getRecords().get(j);
			com.huateng.scf.bas.fin.dao.model.BFinCustDs bFinCustDsdal = new com.huateng.scf.bas.fin.dao.model.BFinCustDs();
			String serialno = UUIDGeneratorUtil.generate();
			bFinCustDsdal.setSerialno(serialno);
			bFinCustDsdal.setSubjNm(bFinCnfgDef.getSubjNm());
			bFinCustDsdal.setSubjId(bFinCnfgDef.getSubjId());
			bFinCustDsdal.setFinDirId(bFinCustDs.getFinDirId());
			bFinCustDsdal.setCotes(bFinCnfgDef.getCotes());
			bFinCustDsdal.setOrd(bFinCnfgDef.getOrd());
			bFinCustDsdal.setColVal1(new BigDecimal("0.00"));
			bFinCustDsdal.setColVal2(new BigDecimal("0.00"));
			bFinCustDsdal.setRptNo(rptNo);
			bFinCustDsdal.setRpSource(rpSource);
			bfincustdsdao.insert(bFinCustDsdal);
		}
		List list = findBFinCustDsListByFinDirId(bFinCustDs.getFinDirId());
		return list;
	}
	
	public List<BFinCustDs> findBFinCustDsByFinDirId(String finDirId) {
		log.info(finDirId);
		List<com.huateng.scf.bas.fin.dao.model.BFinCustDs> listdal = bfincustdsdao.selectByFinDirId(finDirId);
		List<BFinCustDs> list = new ArrayList<BFinCustDs>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.bas.fin.dao.model.BFinCustDs bfindsdal:listdal)
			{
				// VO转PO 展现层对象转换DAO层对象
				BFinCustDs bfinds = new BFinCustDs();
				try
				{
					BeanUtils.copyProperties(bfindsdal, bfinds);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				list.add(bfinds);
			}
		}
		return list;
	}
	
	/**
	 * 计算公式计算结果
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List calCheck(List<BFinCustDs> list) {
		Object colVal1 = 0 ;
		Object colVal2 = 0;	
		int cotesVal=0;
//		List<BFinCustDs> listnew = getList(list);
		List<VBFinCustDs> vBFinCustDsList = new ArrayList<VBFinCustDs>();
		for(BFinCustDs bFinCustDs:list)
		{
			boolean flagM = false;//该项科目类型
			com.huateng.scf.bas.fin.dao.model.BFinCnfgDef bFinCnfgDefdal = 
					new com.huateng.scf.bas.fin.dao.model.BFinCnfgDef();
			//TODO
			//获取模型编号mdlId
			String subjId = bFinCustDs.getSubjId();//得到科目编号
			String mdlId = bFinCustDs.getMdlId();
			bFinCnfgDefdal.setSubjId(subjId);
			bFinCnfgDefdal.setMdlId(mdlId);
			BFinCnfgDef bFinCnfgDef = bfincnfgdefdao.selectBySubjIdAndmdlId(bFinCnfgDefdal);
			if(bFinCnfgDef==null)
			{
				flagM = false;
				bFinCustDs.setColVal1(null);
				bFinCustDs.setColVal2(null);
			}
			else
			{
				String edtyp = bFinCnfgDef.getEdTyp();
				if(null!=bFinCnfgDef.getCotes()){
					cotesVal=bFinCnfgDef.getCotes().intValue();
				}
				if(edtyp.equals("1"))
				{//输入项
					flagM = true;
				}
				else if(edtyp.equals("3"))
				{//标题项
					flagM = false;
					bFinCustDs.setColVal1(null);
					bFinCustDs.setColVal2(null);
				}
				if(edtyp.equals("2"))
				{//计算项
					flagM = false;
					String cal = bFinCnfgDef.getCal();//得到计算公式
					if(cal==null)
					{
					}
					else
					{
						//从计算公式中得出科目号，从而获取该科目对应的年初年末数，公式中数据获得后计算得出结果。
						String[] subjIds = cal.split(">");
						String cal1 = cal;
						String cal2 = cal;
						for(String subjid:subjIds)
						{
							String subj = subjid.substring(subjid.indexOf("<")+1);
							for(int i=0;i<list.size();i++)
							{
								BFinCustDs bfinds = list.get(i);
								if(subj.equals(bfinds.getSubjId()))
								{
									String rex = "<"+subj+">";
									cal1 = cal1.replace(rex, formatColVal(bfinds.getColVal1().toString()));
									if(!ScfBasConstant.MDL_ID_XJLL.equals(mdlId)&&!ScfBasConstant.MDL_ID_CWZB.equals(mdlId)){
//									if(cotesVal>1){
										if(null!=bfinds.getColVal2()){
											cal2 = cal2.replace(rex, formatColVal(bfinds.getColVal2().toString()));
										}
									}
								}
							}
						}
						try
						{
							colVal1 = jse.eval(cal1);
							if(!ScfBasConstant.MDL_ID_XJLL.equals(mdlId)&&!ScfBasConstant.MDL_ID_CWZB.equals(mdlId)){
//							if(cotesVal>1){
								if(null!=cal2&&!(cal2.indexOf(">")>-1)){
									colVal2 = jse.eval(cal2);
								}
								
							}
							
						}
						catch(Exception e)
						{
							log.error(e.getMessage());
							e.printStackTrace();
							throw new ScubeBizException("计算异常");
						}
						String colval1 = colVal1.toString();
						bFinCustDs.setColVal1(BigDecimal.valueOf(Double.valueOf(colval1)));
						if(!ScfBasConstant.MDL_ID_XJLL.equals(mdlId)&&!ScfBasConstant.MDL_ID_CWZB.equals(mdlId)){
//						if(cotesVal>1){
							if(null!=cal2&&!(cal2.indexOf(">")>-1)){
								String colval2 = colVal2.toString();
								bFinCustDs.setColVal2(BigDecimal.valueOf(Double.valueOf(colval2)));
							}
						}else{
							bFinCustDs.setColVal2(new BigDecimal(0));
						}
						
					}
				}
			}
			VBFinCustDs vBFinCustDs = new VBFinCustDs();
			BeanUtils.copyProperties(bFinCustDs, vBFinCustDs);
			vBFinCustDs.setFlagM(flagM);
	    	   if(vBFinCustDs.getCotes().intValue()==1){
	    		 //第一栏初始化
	    		   vBFinCustDsList.add(vBFinCustDs);
	    	   }
	    	   else if(vBFinCustDs.getCotes().intValue()==2){
	    		   //第二栏初始化
	    		   for(int k=0;k<vBFinCustDsList.size();k++){
		    			  if(vBFinCustDsList.get(k).getOrd().intValue()==vBFinCustDs.getOrd().intValue()){
		    				  vBFinCustDsList.get(k).setChild(vBFinCustDs);
			    			     break;
		    			  }
	    		   }  
	    	   }
		}
		return vBFinCustDsList;
	}
	/**
	 * 检查公式计算平衡结果
	 * @param list
	 * @return
	 */
	public String chkCheck(List<VBFinCustDs> list) {
		boolean balance1 = false;
		boolean balance2 = false;
		//遍历数组
		List<BFinCustDs> listnew = getList(list);
		for(BFinCustDs bFinCustDs:listnew)
		{
			com.huateng.scf.bas.fin.dao.model.BFinCnfgDef bFinCnfgDefdal = 
					new com.huateng.scf.bas.fin.dao.model.BFinCnfgDef();
			//TODO
			//获取模型编号mdlId
			String subjId = bFinCustDs.getSubjId();//得到科目编号
			String mdlId = bFinCustDs.getMdlId();
			bFinCnfgDefdal.setSubjId(subjId);
			bFinCnfgDefdal.setMdlId(mdlId);
			BFinCnfgDef bFinCnfgDef = bfincnfgdefdao.selectBySubjIdAndmdlId(bFinCnfgDefdal);
			if(bFinCnfgDef!=null)
			{
				String chk = bFinCnfgDef.getChk();//得到计算公式
				if(chk==null)
				{
				}
				else
				{
					//从计算公式中得出科目号，从而获取该科目对应的年初年末数，公式中数据获得后计算得出结果。
					String[] subjIds = chk.split(">");
					String chk1 = chk;
					String chk2 = chk;
					for(String subjid:subjIds)
					{
						String subj = subjid.substring(subjid.indexOf("<")+1);
						for(int i=0;i<listnew.size();i++)
						{
							BFinCustDs bfinds = listnew.get(i);
							if(subj.equals(bfinds.getSubjId()))
							{
								String rex = "<"+subj+">";
								chk1 = chk1.replace(rex, bfinds.getColVal1().toString());
								chk2 = chk2.replace(rex, bfinds.getColVal2().toString());
							}
						}
					}
					try
					{
						balance1 = (Boolean) jse.eval(chk1);
						balance2 = (Boolean) jse.eval(chk2);
					}
					catch(Exception e)
					{
						throw new ScubeBizException("平衡检查异常");
					}
					if(!balance1||!balance2)
					{
						return "false";
					}
				}
			}
		}
		return "true";
	}

	@Override
	@Transactional
	public void add(List<BFinCustDs> list) {
		if(list.size()>0)
		{
			for(BFinCustDs bfinCustDs : list)
			{
				// VO转PO 展现层对象转换DAO层对象
				com.huateng.scf.bas.fin.dao.model.BFinCustDs bFinCustDsdal = 
						new com.huateng.scf.bas.fin.dao.model.BFinCustDs();
				try
				{
					BeanUtils.copyProperties(bfinCustDs, bFinCustDsdal);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				String serialno = UUIDGeneratorUtil.generate();
				bFinCustDsdal.setSerialno(serialno);
				try
				{
					bfincustdsdao.insert(bFinCustDsdal);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("插入数据异常");
				}
			}
			String finDirId = list.get(0).getFinDirId();
			BFinCustDir bFinCustDir = new BFinCustDir();
			bFinCustDir.setFinDirId(finDirId);
			bFinCustDir.setFinStat("9");
			UserInfo user = ContextHolder.getUserInfo(); 
			String userId= user.getTlrNo();
			BctlVO BctlVO = ContextHolder.getOrgInfo();
			String brcode = BctlVO.getBrNo();
			bFinCustDir.setLstUpdTlr(userId);// 最后更新人
			bFinCustDir.setLstUpdBrCd(brcode);
			bFinCustDir.setLstUpdDt(ScfDateUtil.formatDate(new Date()));
			try
			{
				bfincustdirdao.updateByPrimaryKeySelective(bFinCustDir);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("插入异常");
			}
			//更新客户财报记录表信息
			//有一个财务报表已录入则客户记录表中财报状态为已录入
			bFinCustDir = bfincustdirdao.selectByPrimaryKey(finDirId);
			String finId = bFinCustDir.getFinId();
			BFinCust bFinCust = new BFinCust();
			bFinCust.setFinId(finId);
			bFinCust.setStat("9");
			bfincustservice.update(bFinCust);
		}
	}
	
	@Override
	@Transactional
	public void update(List<BFinCustDs> list) {
		for(BFinCustDs bfinCustDs : list)
		{
			// VO转PO 展现层对象转换DAO层对象
			com.huateng.scf.bas.fin.dao.model.BFinCustDs bFinCustDsdal = 
					new com.huateng.scf.bas.fin.dao.model.BFinCustDs();
			//ZCFZ006
			String subjId=bfinCustDs.getSubjId();
//			if("ZCFZ1144".equals(subjId)){
//				log.info("===============subjId:"+subjId);
//			}
			log.info("===============subjId:"+subjId);
			try
			{
				BeanUtils.copyProperties(bfinCustDs, bFinCustDsdal);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("转换异常");
			}
			try
			{
				bfincustdsdao.updateByPrimaryKey(bFinCustDsdal);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("数据更新异常");
			}
		}
		//更新财报目录表状态
		String finDirId = list.get(0).getFinDirId();
		BFinCustDir bFinCustDir = new BFinCustDir();
		bFinCustDir.setFinDirId(finDirId);
		bFinCustDir.setFinStat("9");
		String userId = ContextHolder.getUserInfo().getTlrNo();
		String orgId = ContextHolder.getOrgInfo().getBrNo();
		bFinCustDir.setLstUpdTlr(userId);// 最后更新人
		bFinCustDir.setLstUpdBrCd(orgId);
		bFinCustDir.setLstUpdDt(ScfDateUtil.formatDate(new Date()));
		try
		{
			bfincustdirdao.updateByPrimaryKeySelective(bFinCustDir);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("更新异常");
		}
		//更新客户财报记录表信息
		//有一个财务报表已录入则客户记录表中财报状态为已录入
		bFinCustDir = bfincustdirdao.selectByPrimaryKey(finDirId);
		String finId = bFinCustDir.getFinId();
		BFinCust bFinCust = new BFinCust();
		bFinCust.setFinId(finId);
		bFinCust.setStat("9");
		bfincustservice.update(bFinCust);
	}
	
	@Override
	@Transactional
	public void submit(List<BFinCustDs> list) {
		if(list.size()>0)
		{
			for(BFinCustDs bfinCustDs : list)
			{
				// VO转PO 展现层对象转换DAO层对象
				com.huateng.scf.bas.fin.dao.model.BFinCustDs bFinCustDsdal = 
						new com.huateng.scf.bas.fin.dao.model.BFinCustDs();
				try
				{
					BeanUtils.copyProperties(bfinCustDs, bFinCustDsdal);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				try
				{
					bfincustdsdao.updateByPrimaryKey(bFinCustDsdal);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("数据提交异常");
				}
			}
			String finDirId = list.get(0).getFinDirId();
			BFinCustDir bFinCustDir = new BFinCustDir();
			bFinCustDir.setFinDirId(finDirId);
			bFinCustDir.setFinStat("1");
			String userId = ContextHolder.getUserInfo().getTlrNo();
			String orgId = ContextHolder.getOrgInfo().getBrNo();
			bFinCustDir.setLstUpdTlr(userId);// 最后更新人
			bFinCustDir.setLstUpdBrCd(orgId);
			bFinCustDir.setLstUpdDt(ScfDateUtil.formatDate(new Date()));
			try
			{
				bfincustdirdao.updateByPrimaryKeySelective(bFinCustDir);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("录入保存异常");
			}
			//更新客户财报记录表信息
			//所有财务报表均已提交，则客户记录表中财报状态为已提交
			bFinCustDir = bfincustdirdao.selectByPrimaryKey(finDirId);
			String finId = bFinCustDir.getFinId();
			List<BFinCustDir> dirlist = bfincustdirdao.selectByFinId(finId);
			int count = 0;
			if(dirlist.size()>0)
			{
				for(BFinCustDir dir:dirlist)
				{
					if(dir.getFinStat().equals("1"))
					{
						count++;
					}
				}
				if(count==dirlist.size())
				{
					BFinCust bFinCust = new BFinCust();
					bFinCust.setFinId(finId);
					bFinCust.setStat("1");
					bfincustservice.update(bFinCust);
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findBFinCustDsListByFinDirId(String finDirId) {
		BFinCustDir bFinCustDir = bfincustdirdao.selectByPrimaryKey(finDirId);
		//TODO 这里需要加上非空判断bFinCustDir
		String mdlId = bFinCustDir.getMdlId();
		String rpSource=bFinCustDir.getFinPd();
		mdlId = mdlId.substring(mdlId.lastIndexOf("-")+1, mdlId.length());
		List<VBFinCustDs>  vBFinCustDsList=new ArrayList<VBFinCustDs>();
    	try {
    		Page p=null;
    		if(null!=mdlId && ScfBasConstant.MDL_ID_CWZB.equals(mdlId)){
    			p=queryBFinCustDsByFinDirId(finDirId,mdlId,rpSource); 
    		}else{
    			p=queryBFinCustDsByFinDirId(finDirId); 
    		}
    		     
	    	for(int j=0;j<p.getRecords().size();j++)
	    	{
	    		
	    		com.huateng.scf.bas.fin.dao.model.BFinCustDs bFinCustDs= (com.huateng.scf.bas.fin.dao.model.BFinCustDs)p.getRecords().get(j);
                VBFinCustDs vBFinCustDs=new VBFinCustDs();
                bFinCustDs.setMdlId(mdlId);
	    	    BeanUtils.copyProperties(bFinCustDs, vBFinCustDs);
	    	    
	    	    /**
	    	     * 设置该项科目类型值		开始
	    	     */
	    	    com.huateng.scf.bas.fin.dao.model.BFinCnfgDef bFinCnfgDefdal = 
						new com.huateng.scf.bas.fin.dao.model.BFinCnfgDef();
				//获取模型编号mdlId
				String subjId = bFinCustDs.getSubjId();//得到科目编号
				if(!StringUtil.isEmpty(subjId))
				{
					bFinCnfgDefdal.setSubjId(subjId);
					bFinCnfgDefdal.setMdlId(mdlId);
//					BFinCnfgDef bFinCnfgDef = bfincnfgdefdao.selectBySubjIdAndmdlId(bFinCnfgDefdal);
					BFinCnfgDef bFinCnfgDef=null;
					List<BFinCnfgDef> bFinCnfgDefList=bfincnfgdefdao.selectBySubjIdAndmdlIdList(bFinCnfgDefdal);
					if(null!=bFinCnfgDefList && bFinCnfgDefList.size()>0){
						bFinCnfgDef=(BFinCnfgDef)bFinCnfgDefList.get(0);
					}
					if(bFinCnfgDef==null)
					{
						vBFinCustDs.setFlagM(false);
						vBFinCustDs.setColVal1(null);
						vBFinCustDs.setColVal2(null);
						vBFinCustDs.setEdTyp(null);
					}
					else
					{
						String edTyp = bFinCnfgDef.getEdTyp();
						if(StringUtil.isEmpty(edTyp))
						{
							vBFinCustDs.setFlagM(false);
							vBFinCustDs.setColVal1(null);
							vBFinCustDs.setColVal2(null);
							vBFinCustDs.setEdTyp(null);
						}
						else
						{
							if(bFinCnfgDef.getEdTyp().equals(ScfBasConstant.ED_TYP_1))
							{//输入项
								vBFinCustDs.setFlagM(true);
								vBFinCustDs.setEdTyp(ScfBasConstant.ED_TYP_1);
							}
							else if(bFinCnfgDef.getEdTyp().equals(ScfBasConstant.ED_TYP_3))
							{//标题项
								vBFinCustDs.setFlagM(false);
								vBFinCustDs.setColVal1(null);
								vBFinCustDs.setColVal2(null);
								vBFinCustDs.setEdTyp(ScfBasConstant.ED_TYP_3);
							}
							else if(bFinCnfgDef.getEdTyp().equals(ScfBasConstant.ED_TYP_2))
							{//计算项
								vBFinCustDs.setFlagM(false);
								vBFinCustDs.setEdTyp(ScfBasConstant.ED_TYP_2);
							}
						}
					}
				}
				else
				{
					vBFinCustDs.setFlagM(false);
					vBFinCustDs.setColVal1(null);
					vBFinCustDs.setColVal2(null);
					vBFinCustDs.setEdTyp(null);
				}
				/**
	    	     * 设置该项科目类型值		结束
	    	     */
				
				
				// 金额格式化
				if(!StringUtil.isEmpty(bFinCustDs.getColVal1())){
			    	  vBFinCustDs.setColVal1Str(ScfCommonUtil.amountFormatToString(bFinCustDs.getColVal1()));
			    }
			    if(!StringUtil.isEmpty(bFinCustDs.getColVal2())){
			    	vBFinCustDs.setColVal2Str(ScfCommonUtil.amountFormatToString(bFinCustDs.getColVal2()));
			    }

	    	    if(vBFinCustDs.getCotes().intValue()==1)
	    	    {
	    	    	//第一栏初始化
		    		vBFinCustDsList.add(vBFinCustDs);
	    	    }
	    	    else if(vBFinCustDs.getCotes().intValue()==2)
	    	    {
	    	    	//第二栏初始化
	    	    	for(int k=0;k<vBFinCustDsList.size();k++)
	    	    	{
	    	    		if(vBFinCustDsList.get(k).getOrd().intValue()==vBFinCustDs.getOrd().intValue())
		    			{
	    	    			vBFinCustDsList.get(k).setChild(vBFinCustDs);
		    				break;
		    			}
		    		}
	    	    }
	    	}
	
 		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
		}		
		return vBFinCustDsList;
	}
	
	public Page queryBFinCustDsByFinDirId(String finDirId) {
		Page p = new Page(1000000, 1, 0);
		BFinCustDsExample example = new BFinCustDsExample();
		Criteria cri = example.createCriteria();	
		cri.andFinDirIdEqualTo(finDirId);
		example.setOrderByClause("COTES,ORD");
		bfincustdsdao.selectByPage(example, p);
		return p;
	}
	public Page queryBFinCustDsByFinDirId(String finDirId,String mdlId,String rpSource) {
		Page p = new Page(1000000, 1, 0);
		BFinCustDsExample example = new BFinCustDsExample();
		Criteria cri = example.createCriteria();
		if(null!=mdlId && ScfBasConstant.MDL_ID_CWZB.equals(mdlId)){
			cri.andRpSourceEqualTo(rpSource);
		}
		cri.andFinDirIdEqualTo(finDirId);
		example.setOrderByClause("COTES,ORD");
		bfincustdsdao.selectByPage(example, p);
		return p;
	}
	
	@Override
	public List<BFinCustDs> getList(List<VBFinCustDs> list)
	{
		List<BFinCustDs> listnew = new ArrayList<BFinCustDs>();	
		//遍历数组
		for(VBFinCustDs vbFinCustDs:list)
		{
			VBFinCustDs vbFinCustDs2 = vbFinCustDs.getChild();
			BFinCustDs bFinCustDs1 = new BFinCustDs();
			BeanUtils.copyProperties(vbFinCustDs, bFinCustDs1);
			listnew.add(bFinCustDs1);
			if(vbFinCustDs2!=null)
			{
				BFinCustDs bFinCustDs2 = new BFinCustDs();
				BeanUtils.copyProperties(vbFinCustDs2, bFinCustDs2);
				listnew.add(bFinCustDs2);
			}
		}
		return listnew;
	}
	
	/**
	 * 财务报表数据录入，失去焦点时调用方法
	 * @param list 财务报表科目项
	 * @param finDs 失去焦点项
	 * @return
	 * 注意：两个计算项中的计算公式不能同时包含彼此，否则无限死循环
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List checkNum(List<BFinCustDs> list,VBFinCustDs finDs) {
		Object colVal1 = 0 ;
		Object colVal2 = 0;		
		List<VBFinCustDs> vBFinCustDsList = new ArrayList<VBFinCustDs>();
		String nowSubjId = finDs.getSubjId();
		BigDecimal nowColVal1 = finDs.getColVal1();
		BigDecimal nowColVal2 = finDs.getColVal2();
		//赋值后的listnew,页面获取的值赋值到list中对应项
		List<BFinCustDs> listnew = new ArrayList<BFinCustDs>();
		for(BFinCustDs bFinCustDs:list)
		{
			if(!StringUtil.isEmpty(bFinCustDs.getSubjId())&&bFinCustDs.getSubjId().equals(nowSubjId))
			{
				bFinCustDs.setColVal1(nowColVal1);
				bFinCustDs.setColVal2(nowColVal2);
			}
			listnew.add(bFinCustDs);
		}
		//初始化list集合，用于存放获得新结果的科目包含在其它科目的BFinCustDs对象
		List<BFinCustDs> listcontain = new ArrayList<BFinCustDs>();
		for(BFinCustDs bFinCustDs:listnew)
		{
			boolean flagM = false;//该项科目类型
			com.huateng.scf.bas.fin.dao.model.BFinCnfgDef bFinCnfgDefdal = 
					new com.huateng.scf.bas.fin.dao.model.BFinCnfgDef();
			/**
			 * 1.通过subjId获取该科目的计算公式
			 * 2.判断该计算公式中是否包含指定科目
			 *  	如果包含，则将该科目对应的值带入公式并计算
			 * 		如果不包含，则进行下一个
			 */
			/**
			 * 1.通过subjId获取该科目的计算公式
			 */
			//获取模型编号mdlId
			String subjId = bFinCustDs.getSubjId();//得到科目编号
			String mdlId = bFinCustDs.getMdlId();
			bFinCnfgDefdal.setSubjId(subjId);
			bFinCnfgDefdal.setMdlId(mdlId);
//			BFinCnfgDef bFinCnfgDef = bfincnfgdefdao.selectBySubjIdAndmdlId(bFinCnfgDefdal);
			//modify by huangshuidan 2017-06-10
			BFinCnfgDef bFinCnfgDef=null;
			List<BFinCnfgDef> bFinCnfgDefList=bfincnfgdefdao.selectBySubjIdAndmdlIdList(bFinCnfgDefdal);
			if(null!=bFinCnfgDefList && bFinCnfgDefList.size()>0){
				bFinCnfgDef=(BFinCnfgDef)bFinCnfgDefList.get(0);
			}//end by huangshuidan 2017-06-10
			if(bFinCnfgDef==null)
			{
				flagM = false;
				bFinCustDs.setColVal1(null);
				bFinCustDs.setColVal2(null);
			}
			else
			{
				String edtyp = bFinCnfgDef.getEdTyp();
				if(edtyp.equals("1"))
				{//输入项
					flagM = true;
				}
				else if(edtyp.equals("3"))
				{//标题项
					flagM = false;
					bFinCustDs.setColVal1(null);
					bFinCustDs.setColVal2(null);
				}
				if(edtyp.equals("2"))
				{//计算项
					flagM = false;
					String cal = bFinCnfgDef.getCal();//得到计算公式
					if(cal==null)
					{
					}
					else
					{
						/**
						 * 2.判断该计算公式中是否包含指定科目
						 */
						if(cal.contains(nowSubjId))
						{//如果包含，则将该科目对应的值带入公式并计算
							//从计算公式中得出科目号，从而获取该科目对应的年初年末数，公式中数据获得后计算得出结果。
							String[] subjIds = cal.split(">");
							String cal1 = cal;
							String cal2 = cal;
							for(String subjid:subjIds)
							{
								String subj = subjid.substring(subjid.indexOf("<")+1);
								for(int i=0;i<listnew.size();i++)
								{
									BFinCustDs bfinds = listnew.get(i);
									if(subj.equals(bfinds.getSubjId()))
									{
										String rex = "<"+subj+">";
										if(subj.equals(nowSubjId))
										{
											cal1 = cal1.replace(rex, formatColVal(nowColVal1.toString()));
											if(!ScfBasConstant.MDL_ID_XJLL.equals(mdlId)&&!ScfBasConstant.MDL_ID_CWZB.equals(mdlId)){
												cal2 = cal2.replace(rex, formatColVal(nowColVal2.toString()));
											}
										}
										else
										{
											cal1 = cal1.replace(rex, formatColVal(bfinds.getColVal1().toString()));
//											log.info("=========================>>>cal1:"+cal1);
											if(!ScfBasConstant.MDL_ID_XJLL.equals(mdlId)&&!ScfBasConstant.MDL_ID_CWZB.equals(mdlId)){
//												log.info("=========================>>>bfinds.getColVal2():"+bfinds.getColVal2());
												if(null!=bfinds && null!=bfinds.getColVal2()){
													cal2 = cal2.replace(rex, formatColVal(bfinds.getColVal2().toString()));
												}
//												log.info("=========================>>>cal2:"+cal2);
												
											}
										}
									}
								}
							}
							try
							{
								colVal1 = jse.eval(cal1);
								if(!ScfBasConstant.MDL_ID_XJLL.equals(mdlId)&&!ScfBasConstant.MDL_ID_CWZB.equals(mdlId)){
									if(null!=cal2 && (cal2.indexOf("<")<=-1 || cal2.indexOf(">")<=-1)){
										colVal2 = jse.eval(cal2);
									}
								}
							}
							catch(Exception e)
							{
								log.error(e.getMessage());
								e.printStackTrace();
								throw new ScubeBizException("计算异常");
							}
							String colval1 = colVal1.toString();
							
							//add by huangshuidan  2017-06-12 计算后，保留2位小数
							BigDecimal bigColVal1=BigDecimal.valueOf(Double.valueOf(colval1));
							
							if(null!=bigColVal1){
								bigColVal1=bigColVal1.setScale(2, BigDecimal.ROUND_HALF_UP);
								log.info("=======================bigColVal1:"+bigColVal1);
							}
							//end by huangshuidan  2017-06-12 计算后，保留2位小数
//							bFinCustDs.setColVal1(BigDecimal.valueOf(Double.valueOf(colval1)));
//							bFinCustDs.setColVal2(BigDecimal.valueOf(Double.valueOf(colval2)));
							if(!ScfBasConstant.MDL_ID_XJLL.equals(mdlId)&&!ScfBasConstant.MDL_ID_CWZB.equals(mdlId)){
								String colval2 = colVal2.toString();
								BigDecimal bigColVal2=BigDecimal.valueOf(Double.valueOf(colval2));
								if(null!=bigColVal2){
									bigColVal2=bigColVal2.setScale(2, BigDecimal.ROUND_HALF_UP);
									log.info("=======================bigColVal2:"+bigColVal2);
								}
								bFinCustDs.setColVal2(bigColVal2);
							}else{
								bFinCustDs.setColVal2(new BigDecimal(0));
							}
							bFinCustDs.setColVal1(bigColVal1);
							
							/**
							 * 判断当前科目是否包含在其它科目的计算项中
							 * 若包含，则放入项的list对象中
							 */
							for(BFinCustDs newFinDs:listnew)
							{
								String subjid = newFinDs.getSubjId();//得到科目编号
								if(!StringUtil.isEmpty(subjid))
								{
									String mdlid = newFinDs.getMdlId();
									BFinCnfgDef cnfgdef = new BFinCnfgDef();
									cnfgdef.setSubjId(subjid);
									cnfgdef.setMdlId(mdlid);
//									BFinCnfgDef newBFinCnfgDef = bfincnfgdefdao.selectBySubjIdAndmdlId(cnfgdef);
									//modify by huangshuidan 2017-06-10
									BFinCnfgDef newBFinCnfgDef=null;
									List<BFinCnfgDef> newBFinCnfgDefList=bfincnfgdefdao.selectBySubjIdAndmdlIdList(cnfgdef);
									if(null!=newBFinCnfgDefList && newBFinCnfgDefList.size()>0){
										newBFinCnfgDef=(BFinCnfgDef)newBFinCnfgDefList.get(0);
									}//end by huangshuidan 2017-06-10
									if(newBFinCnfgDef.getEdTyp().equals("2"))
									{
										String newcal = newBFinCnfgDef.getCal();
										if(newcal.contains(subjId))
										{
											listcontain.add(bFinCustDs);
										}
									}
								}
							}
						}
					}
				}
			}
			VBFinCustDs vBFinCustDs = new VBFinCustDs();
			BeanUtils.copyProperties(bFinCustDs, vBFinCustDs);
			vBFinCustDs.setFlagM(flagM);
	    	   if(vBFinCustDs.getCotes().intValue()==1){
	    		 //第一栏初始化
	    		   vBFinCustDsList.add(vBFinCustDs);
	    	   }
	    	   else if(vBFinCustDs.getCotes().intValue()==2){
	    		   //第二栏初始化
	    		   for(int k=0;k<vBFinCustDsList.size();k++){
		    			  if(vBFinCustDsList.get(k).getOrd().intValue()==vBFinCustDs.getOrd().intValue()){
		    				  vBFinCustDsList.get(k).setChild(vBFinCustDs);
			    			     break;
		    			  }
	    		   }  
	    	   }
		}
		if(listcontain.size()!=0)
		{
			for(BFinCustDs bFinCustDs:listcontain)
			{
				VBFinCustDs vbFinCustDs = new VBFinCustDs();
				BeanUtils.copyProperties(bFinCustDs, vbFinCustDs);
				List<BFinCustDs> listds = getList(vBFinCustDsList);
				vBFinCustDsList = checkNum(listds, vbFinCustDs);
			}
		}
		return vBFinCustDsList;
	}
	
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.fin.service.IBFinCustDsService#analy(com.huateng.scf.bas.fin.model.VBFinCustDs)
	 */
	@Transactional
	@Override
	public List<VBFinCustDs> analy(BFinCustDs bFinCustDs) {
		com.huateng.scf.bas.fin.dao.model.BFinCustDs bFinCustDsdal = new com.huateng.scf.bas.fin.dao.model.BFinCustDs();
		bFinCustDsdal.setFinDirId(bFinCustDs.getFinDirId());
		bFinCustDsdal.setRpSource(bFinCustDs.getRpSource());
		bFinCustDsdal.setMdlId(bFinCustDs.getMdlId());//queryAnalyData排除财务指标模板;queryBfinCustDsByFdIRpSource作为查询条件
		BFinCustDir bFinCustDir = bfincustdirdao.selectByPrimaryKey(bFinCustDs.getFinDirId());
		String finId=null;
		String rptNo=null;//期次
		String rptNoTmp=null;
		String rpSource=bFinCustDs.getRpSource();//报表周期01-月，04-年
		String custId=null;
		if(null!=bFinCustDir){
			finId=bFinCustDir.getFinId();
			rptNo=bFinCustDir.getRptNo();
			custId=bFinCustDir.getCustId();
		}
		bFinCustDsdal.setFinId(finId);
		Map fCustDsMap=new HashMap();//存放本期财务报表数据
		Object colVal1 = 0 ;
		//查询资产负债、现金流量、损益表财务数据，维度根据实际的月份、年份
		List<com.huateng.scf.bas.fin.dao.model.BFinCustDs> bFindCustDsDataList =bfincustdsdao.queryAnalyData(bFinCustDsdal);
		if(null!=bFindCustDsDataList && bFindCustDsDataList.size()>0){
			for(int j=0;j<bFindCustDsDataList.size();j++){
				com.huateng.scf.bas.fin.dao.model.BFinCustDs bFinCustDsData = (com.huateng.scf.bas.fin.dao.model.BFinCustDs) bFindCustDsDataList
						.get(j);
				fCustDsMap.put(bFinCustDsData.getSubjId(), bFinCustDsData.getColVal1());//财务科目号-金额
			}
		}
		//计算上年周期
		Map fCustDsAMap=new HashMap();//存放上一年的财务报表数据
		if(null!=rpSource){
			if(ScfBasConstant.RP_SOURCE_01.equals(rpSource)||ScfBasConstant.RP_SOURCE_03.equals(rpSource)){//月报/半年报
				if(null!=rptNo){
					rptNoTmp=rptNo.substring(0,rptNo.length()-2);
				}
			}else if(ScfBasConstant.RP_SOURCE_04.equals(rpSource)){//年报
				rptNoTmp=rptNo;
			}
			int rptNoi=0;
			rptNoi=Integer.valueOf(rptNoTmp)-1;//上一年
			rptNoTmp=String.valueOf(rptNoi);
			com.huateng.scf.bas.fin.dao.model.BFinCustDs bFinCustDsAdal = new com.huateng.scf.bas.fin.dao.model.BFinCustDs();
			bFinCustDsAdal.setRpSource(ScfBasConstant.RP_SOURCE_04);
			bFinCustDsAdal.setRptNo(rptNoTmp);
			bFinCustDsAdal.setMdlId(bFinCustDs.getMdlId());//custId
			bFinCustDsAdal.setCustId(custId);
			List<com.huateng.scf.bas.fin.dao.model.BFinCustDs> bFindCustDsADataList =bfincustdsdao.queryAnalyData(bFinCustDsAdal);
			if(null!=bFindCustDsADataList && bFindCustDsADataList.size()>0){
				for(int n=0;n<bFindCustDsADataList.size();n++){
					com.huateng.scf.bas.fin.dao.model.BFinCustDs bFinCustDsAData = (com.huateng.scf.bas.fin.dao.model.BFinCustDs) bFindCustDsADataList
							.get(n);
					log.info("bFinCustDsAData.getSubjId():"+bFinCustDsAData.getSubjId()+" bFinCustDsAData.getColVal1():"+bFinCustDsAData.getColVal1());
					fCustDsAMap.put(bFinCustDsAData.getSubjId(), bFinCustDsAData.getColVal1());//财务科目号-金额
				}
			}
		}
		List<com.huateng.scf.bas.fin.dao.model.BFinCustDs> bFindCustDsList =bfincustdsdao.queryBfinCustDsByFdIRpSource(bFinCustDsdal);
		List<VBFinCustDs>  vBFinCustDsList=new ArrayList<VBFinCustDs>();
		boolean flagM = false;//该项科目显示类型控制
		if(null!=bFindCustDsList && bFindCustDsList.size()>0){
			for(int i=0;i<bFindCustDsList.size();i++){//遍历bFindCustDs
				com.huateng.scf.bas.fin.dao.model.BFinCustDs bFinCustDsRedal = (com.huateng.scf.bas.fin.dao.model.BFinCustDs) bFindCustDsList
						.get(i);
				VBFinCustDs vBFinCustDs=new VBFinCustDs();
	    	    BeanUtils.copyProperties(bFinCustDsRedal, vBFinCustDs);
	    	    String cal=vBFinCustDs.getCal();//财务指标计算公式
	    	    //1.财务指标计算
	    	    //1.1解析计算公式
	    	    if(null!=cal){
	    	    	//如果包含，则将该科目对应的值带入公式并计算<NSYB3400>*100*2/(<AZCFZ1000>+<NZCFZ1000>)
						//从计算公式中得出科目号，从而获取该科目对应的年初年末数，公式中数据获得后计算得出结果。
						String[] subjIds = cal.split(">");
						String cal1 = cal;
						if("CWZB0820".equals(vBFinCustDs.getSubjId())){
							log.info(vBFinCustDs.getSubjId());
						}
						for(String subjid:subjIds)
						{
							String subj = subjid.substring(subjid.indexOf("<")+1);
							if(null!=subj && subj.indexOf(")")>-1){//出现“)”则忽略掉
								continue;
							}
							String subj_id=null;
							if(null!=subj){
								if(subj.indexOf("N")>-1){//去掉N开头的科目号才是正确的科目号
									subj_id=subj.substring(subj.indexOf("N")+1);
									String rex = "<"+subj+">";
									log.info("==================subj:"+subj+" subj_id:"+subj_id+" cal1:"+cal1 +" vBFinCustDs.getSubjId():"+vBFinCustDs.getSubjId());
									try {
										cal1 = cal1.replace(rex, formatColVal(fCustDsMap.get(subj_id).toString()));
									} catch (Exception e) {
										log.error("==================公式配置错误或者数据异常！"+"subj_id:"+subj_id+" cal1:"+cal1+" fCustDsMap.get(subj_id):"+fCustDsMap.get(subj_id));
										e.printStackTrace();
										throw new ScubeBizException("公式配置错误或者财务报表数据异常，请检查财务报表是否全部录入！");
									}
								}
								if(subj.indexOf("A")>-1){//去掉A开头的科目号才是正确的科目号
									//A开头的科目数据从fCustDsAMap取，上一年数据
									subj_id=subj.substring(subj.indexOf("A")+1);
									String rex = "<"+subj+">";
									log.info("==================subj:"+subj+" subj_id:"+subj_id+" cal1:"+cal1 +" vBFinCustDs.getSubjId():"+vBFinCustDs.getSubjId());
									try {
										String subjIdMapVal=null==fCustDsAMap.get(subj_id)?"0":fCustDsAMap.get(subj_id).toString();
										cal1 = cal1.replace(rex, formatColVal(subjIdMapVal));
									} catch (Exception e) {
										log.error("==================公式配置错误或者数据异常！"+"subj_id:"+subj_id+" cal1:"+cal1);
										e.printStackTrace();
										throw new ScubeBizException("公式配置错误或者数据异常！");
									}
								}
							}
//							log.info("==================subj:"+subj+" subj_id:"+subj_id);
						}
						try
						{
							colVal1 = jse.eval(cal1);
//							log.info("=======================colVal1:"+colVal1+" cal1:"+cal1);
						}catch(Exception e){
							log.error(e.getMessage());
							e.printStackTrace();
							throw new ScubeBizException("计算异常");
						}
						String colval1 = colVal1.toString();
						//出现计算结果为0，eval函数执行后会变为NaN或Infinity，此时重置为0
						if(null!=colval1 &&("NaN".equals(colval1) || "Infinity".equals(colval1)||"-Infinity".equals(colval1))){
							colval1="0";
						}
						//add by huangshuidan  2017-06-12 计算后，保留2位小数
						BigDecimal bigColVal1=BigDecimal.valueOf(Double.valueOf(colval1));
						if(null!=bigColVal1){
							bigColVal1=bigColVal1.setScale(2, BigDecimal.ROUND_HALF_UP);
//							log.info("=======================bigColVal1:"+bigColVal1);
						}
						vBFinCustDs.setColVal1(bigColVal1);
						if(null!=vBFinCustDs.getEdTyp() && ScfBasConstant.ED_TYP_1.equals(vBFinCustDs.getEdTyp())){
							flagM = true;//输入项
						}
						if(null!=vBFinCustDs.getEdTyp() && ScfBasConstant.ED_TYP_2.equals(vBFinCustDs.getEdTyp())){
							flagM = false;//计算项
						}
						if(null!=vBFinCustDs.getEdTyp() && ScfBasConstant.ED_TYP_3.equals(vBFinCustDs.getEdTyp())){
							flagM = false;//标题项
						}
						vBFinCustDs.setFlagM(flagM);
						
			}    
	    	    vBFinCustDsList.add(vBFinCustDs);
			}
			//根据财务指标分项保存财务指标分项结果和描述 至相关的拓展表
			this.saveBFinCustDsExt(vBFinCustDsList);
		}
		return vBFinCustDsList;
	}
	
	/***
	 * 保存财务指标分析的结果和描述
	 * @param vBFinCustDs
	 * @throws ScubeBizException
	 */
	@Transactional
	public void saveBFinCustDsExt(List<VBFinCustDs> list) throws ScubeBizException{
		
		// 与平均值比较的结果
		Map<String, String> finAnalyAMap = new HashMap<String, String>();
		finAnalyAMap.put(ScfBasConstant.FIN_ANALY_A_2, "高于");
		finAnalyAMap.put(ScfBasConstant.FIN_ANALY_A_1, "近与");
		finAnalyAMap.put(ScfBasConstant.FIN_ANALY_A_0, "低于");

		// 分析结果描述
		Map<String, String> finAnalyRMap = new HashMap<String, String>();
		finAnalyRMap.put(ScfBasConstant.FIN_ANALY_R_5, "优秀");
		finAnalyRMap.put(ScfBasConstant.FIN_ANALY_R_4, "较好");
		finAnalyRMap.put(ScfBasConstant.FIN_ANALY_R_3, "平均");
		finAnalyRMap.put(ScfBasConstant.FIN_ANALY_R_2, "较差");
		finAnalyRMap.put(ScfBasConstant.FIN_ANALY_R_1, "差");

		
		Map fCustDsMap=new HashMap(); //存放计算出的科目和金额
		if(list!=null&list.size()>0){
			for(VBFinCustDs vo:list){
				fCustDsMap.put(vo.getSubjId(), vo.getColVal1());//财务科目号-金额
			}
			Map<String, String> fCustSubjMap=new HashMap<String, String>(); //存放非标题项 科目 --分项结果 差，较差，平均，较好，优秀
			for(VBFinCustDs ds:list){
				String subjId= ds.getSubjId();
				String  analyResult =ScfBasConstant.FIN_ANALY_R_3; //默认平均
				String  analyAResult ="";
				if(ScfBasConstant.ED_TYP_1.equals(ds.getEdTyp())){ //非标题项的科目项
					BBrpFinParam bBrpFinParam =bBrpFinParamDAO.selectByPrimaryKey(subjId);
					//各项值来获得分析结果
					 //科目对应的金额
					 BigDecimal subjIdMapVal=(BigDecimal) (null==fCustDsMap.get(subjId)?BigDecimal.ZERO:fCustDsMap.get(subjId));
					 BigDecimal subjLower = BigDecimal.ZERO;
					 BigDecimal subjLow = BigDecimal.ZERO;
					 BigDecimal tradeAverage = BigDecimal.ZERO;
					 BigDecimal subjMidi = BigDecimal.ZERO;
					 BigDecimal subjHigh = BigDecimal.ZERO;
					 BigDecimal subjHigher = BigDecimal.ZERO;
					 if(null==bBrpFinParam){
						 log.error("==================财务指标参数配置未配置！"+"subjId:"+subjId);
						 throw new ScubeBizException("财务指标参数配置,科目号"+subjId+"未配置！请检查财务指标参数是否全部配置！");
					 }
					 if(!StringUtil.isStrNum(bBrpFinParam.getSubjLower())){
						 subjLower = BigDecimal.valueOf(Double.valueOf(bBrpFinParam.getSubjLower())); 
					 }
					 if(!StringUtil.isStrNum(bBrpFinParam.getSubjLow())){
						 subjLow = BigDecimal.valueOf(Double.valueOf(bBrpFinParam.getSubjLow()));
					 }
					 if(!StringUtil.isStrNum(bBrpFinParam.getSubjLow())){
						 subjLow = BigDecimal.valueOf(Double.valueOf(bBrpFinParam.getSubjLow()));
					 }
					 if(bBrpFinParam.getTradeAverage()!=null){
						 tradeAverage = bBrpFinParam.getTradeAverage();
					 }
					 if(!StringUtil.isStrNum(bBrpFinParam.getSubjMidi())){
						 subjMidi = BigDecimal.valueOf(Double.valueOf(bBrpFinParam.getSubjMidi()));
					 }
					 if(!StringUtil.isStrNum(bBrpFinParam.getSubjHigh())){
						 subjHigh = BigDecimal.valueOf(Double.valueOf(bBrpFinParam.getSubjHigh()));
					 }
					 if(!StringUtil.isStrNum(bBrpFinParam.getSubjHigher())){
						 subjHigher = BigDecimal.valueOf(Double.valueOf(bBrpFinParam.getSubjHigher()));
					 }
					
					 String remark = bBrpFinParam.getRemark();
					 if(subjIdMapVal.compareTo(tradeAverage)>0){ //高于
						 analyAResult= ScfBasConstant.FIN_ANALY_A_2;
					 }else if(subjIdMapVal.compareTo(tradeAverage)==0){ //近与
						 analyAResult= ScfBasConstant.FIN_ANALY_A_1;
					 }else if(subjIdMapVal.compareTo(tradeAverage)<0){ //低于
						 analyAResult= ScfBasConstant.FIN_ANALY_A_0;
					 }
					 
					 //特殊的处理
					 //TODO
					 //资产负债率
					 //资金运营周期（大于45天差，大于30天较低，小于20较好，大 ---小于15天较强（优秀））
					 //研发投入比例
					 //后台费用率
					 //带息负债率（大于90%差，大于75%较差，60-75平均小于60%较好，小于40%优秀）
					 //总债务/ebit 偿债保障比 （大于3%较差，5%差，小于3较差，小于1%较强）
					 
					  if("CWZB0835".equals(subjId)||"CWZB0855".equals(subjId)||"CWZB0813".equals(subjId) ){//资金运营周期
						  if(subjIdMapVal.compareTo(subjLower)>0){//差
								 analyResult = ScfBasConstant.FIN_ANALY_R_1;
							}else if(subjIdMapVal.compareTo(subjLow)>0){ //较差
								 analyResult = ScfBasConstant.FIN_ANALY_R_2;
							}else if(subjIdMapVal.compareTo(tradeAverage)==0){ //平均
								 analyResult = ScfBasConstant.FIN_ANALY_R_3;
							}else if(subjIdMapVal.compareTo(subjHigh)<0){ //较好
								 analyResult = ScfBasConstant.FIN_ANALY_R_3; 
							} else if(subjIdMapVal.compareTo(subjHigher)<0){ //优秀
								 analyResult = ScfBasConstant.FIN_ANALY_R_3; 
							}
					  }
					  //研发投入比例
					  else if("CWZB0837".equals(subjId)||"CWZB0814".equals(subjId)||"CWZB0856".equals(subjId) ){
						 
					  }
					  //后台费用率
					  else if("CWZB0833".equals(subjId)||"CWZB0811".equals(subjId)||"CWZB0853".equals(subjId) ){
						  
					  }
					  
					  //带息负债率 （大于90%差，大于75%较差，60-75平均,小于60%较好，小于40%优秀）
					  else if("CWZB0838".equals(subjId)||"CWZB0857".equals(subjId)||"CWZB0815".equals(subjId) ){//资金运营周期
						  if(subjIdMapVal.compareTo(subjLower)>0){//差
								 analyResult = ScfBasConstant.FIN_ANALY_R_1;
							}else if(subjIdMapVal.compareTo(subjLow)>0){ //较差
								 analyResult = ScfBasConstant.FIN_ANALY_R_2;
							}else if(subjIdMapVal.compareTo(tradeAverage)>=0&&subjIdMapVal.compareTo(subjMidi)<=0){ //平均
								 analyResult = ScfBasConstant.FIN_ANALY_R_3;
							}else if(subjIdMapVal.compareTo(subjHigh)<0){ //较好
								 analyResult = ScfBasConstant.FIN_ANALY_R_3; 
							} else if(subjIdMapVal.compareTo(subjHigher)<0){ //优秀
								 analyResult = ScfBasConstant.FIN_ANALY_R_3; 
							}
					  }
					  
					  //总债务/ebit 偿债保障比 （大于3%较差，5%差，小于3较差，小于1%较强） CWZB0851,CWZB0831,CWZB0808
					  else if("CWZB0851".equals(subjId)||"CWZB0831".equals(subjId)||"CWZB0808".equals(subjId) ){
						  if(subjIdMapVal.compareTo(subjLower)>0){//差
								 analyResult = ScfBasConstant.FIN_ANALY_R_1;
							}else if(subjIdMapVal.compareTo(subjLow)>0){ //较差
								 analyResult = ScfBasConstant.FIN_ANALY_R_2;
							}else if(subjIdMapVal.compareTo(tradeAverage)>=0&&subjIdMapVal.compareTo(subjMidi)<=0){ //平均
								 analyResult = ScfBasConstant.FIN_ANALY_R_3;
							}else if(subjIdMapVal.compareTo(subjHigh)<0){ //较好
								 analyResult = ScfBasConstant.FIN_ANALY_R_3; 
							} else if(subjIdMapVal.compareTo(subjHigher)<0){ //优秀
								 analyResult = ScfBasConstant.FIN_ANALY_R_3; 
							}
					  }
					 //其他科目
					else if(subjIdMapVal.compareTo(subjLower)<0){//差
						 analyResult = ScfBasConstant.FIN_ANALY_R_1;
					}else if(subjIdMapVal.compareTo(subjLow)<0){ //较差
						 analyResult = ScfBasConstant.FIN_ANALY_R_2;
					}else if(subjIdMapVal.compareTo(tradeAverage)==0){ //平均
						 analyResult = ScfBasConstant.FIN_ANALY_R_3;
					}else if(subjIdMapVal.compareTo(subjHigh)>0){ //较好
						 analyResult = ScfBasConstant.FIN_ANALY_R_3; 
					} else if(subjIdMapVal.compareTo(subjHigher)>0){ //优秀
						 analyResult = ScfBasConstant.FIN_ANALY_R_3; 
					}
					  fCustSubjMap.put(subjId, analyResult);
					  BFinCustDsExt bFinCustDsExt = new BFinCustDsExt();
					  bFinCustDsExt.setId(UUIDGeneratorUtil.generate());
					  bFinCustDsExt.setSerialno(ds.getSerialno());
					  //bFinCustDsExt.setSubjId(ds.getSubjId());
				      bFinCustDsExt.setSubjId(subjId);
				      bFinCustDsExt.setAnalyDate(ScfDateUtil.formatDate(new Date()));
				      bFinCustDsExt.setResult(analyResult);
				      remark = remark.replace(SUBJVAL, subjIdMapVal.toString()); //替换相应的财务指标对应的值
				      remark = remark.replace(FINANALYA, finAnalyAMap.get(analyAResult)); //替换与平均值的比较结果
				      remark = remark.replace(FINANALYR, finAnalyRMap.get(analyResult)); //替换分析结果
				      bFinCustDsExt.setRemark(remark);
				      bFinCustDsExt.setLastUptTlrno(ContextHolder.getUserInfo().getTlrNo());
				      bFinCustDsExt.setLastUpdDate(new Date());
				      
				      //通过Serialno 和 subjId 查询记录是否存在,存在先删除
				       this.findBFinCustDsExtListDelete(bFinCustDsExt);
				      
				      
				      try {
						bFinCustDsExtDAO.insert(bFinCustDsExt);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new ScubeBizException("新增异常");
					}
				}
			}
			
			//标题项的处理
			for(VBFinCustDs tds:list){
				String subjId= tds.getSubjId();
				String  analyResult =""; //分析结果
				 String remark = "";  //分析描述
				if(ScfBasConstant.ED_TYP_3.equals(tds.getEdTyp())){
					BBrpFinParamExample example = new BBrpFinParamExample();
					BBrpFinParamExample.Criteria criteria = example.createCriteria();
					criteria.andTitleIdEqualTo(subjId);
					List<BBrpFinParam> listT = bBrpFinParamDAO.selectByExample(example);
					 String results="";
					if(listT!=null&&listT.size()>0){
						for(BBrpFinParam TVO:listT){
							//根据财务科目号获得财务指标相关的参数
						   String tsubjId = TVO.getSubjId();
						  // BBrpFinParam TFinParam =bBrpFinParamDAO.selectByPrimaryKey(tsubjId);
						   //科目对应的金额
						  BigDecimal subjIdMapVal=(BigDecimal) (null==fCustDsMap.get(tsubjId)?BigDecimal.ZERO:fCustDsMap.get(tsubjId));
						 //后台费用和研发投入比例 不包含在内
						//研发投入比例
						  if("CWZB0837".equals(tsubjId)||"CWZB0814".equals(tsubjId)||"CWZB0856".equals(tsubjId) ){
							 
						  }
						  //后台费用率
						  else if("CWZB0833".equals(tsubjId)||"CWZB0811".equals(tsubjId)||"CWZB0853".equals(tsubjId) ){
							  
						  } else{
							  if(subjIdMapVal.compareTo(TVO.getTradeAverage())>0){
								  results=results+ScfBasConstant.FIN_ANALY_A_2; //高于
							  }else if(subjIdMapVal==(TVO.getTradeAverage())){
								  results=results+ScfBasConstant.FIN_ANALY_A_1; //
							  }else if(subjIdMapVal.compareTo(TVO.getTradeAverage())<0){
								  results=results+ScfBasConstant.FIN_ANALY_A_0; //低于
							  }
						  }
						 
						  //科目分析结果
						 String subjAnalyR = fCustSubjMap.get(tsubjId);
						  remark =remark+TVO.getSubjNm()+ finAnalyRMap.get(subjAnalyR)+","; 
						}
						remark ="企业"+remark;
					}
					int  char2=  getCharCount(results,ScfBasConstant.FIN_ANALY_A_2);
					int  char1=  getCharCount(results,ScfBasConstant.FIN_ANALY_A_1);
					int  char0=  getCharCount(results,ScfBasConstant.FIN_ANALY_A_0);
					analyResult = ScfBasConstant.FIN_ANALY_R_3; //设置分析结果默认值
					  //盈利能力
					  if("SUBJ0061".equals(subjId)||"SUBE0001".equals(subjId)||"SUBE0008".equals(subjId) )  
					  {
						
						if(char2>=3){ //
							analyResult = ScfBasConstant.FIN_ANALY_R_5; //优秀 ;//4项中任意3项高于平均值 222x
						}
						if(char2==2&&char1>=1){
							analyResult = ScfBasConstant.FIN_ANALY_R_4; //较好 ;//4项中任意2项高于平均值，至少一项等于平均值 2211;2210
						}
						if(char0>=3){
							analyResult = ScfBasConstant.FIN_ANALY_R_3; //平均 ;//4项中任意3项等于平均值111x
						}
						if(char0==2&&char1>=1){
							analyResult = ScfBasConstant.FIN_ANALY_R_2; //较差 ;//4项中任意2项等于平均值，至少一项为平均值，0011,0012
						}
						if(char0==2&&char1>=1){
							analyResult = ScfBasConstant.FIN_ANALY_R_1; //差 ;//4项中任意3项低于平均值000x
						}
						remark = remark + "企业总体的"+tds.getSubjNm()+finAnalyRMap.get(analyResult);
					  }
					  //偿债能力 SUBJ0062、SUBE0004、 SUBE0009

					  if("SUBJ0062".equals(subjId)||"SUBE0004".equals(subjId)||"SUBE0009".equals(subjId) )  
					  {
						if(char2>=4||(char2==3&&char1==2)){ //
							analyResult = ScfBasConstant.FIN_ANALY_R_5; //优秀 ;//4项中任意3项高于平均值 222x
						}
						if((char2==3&&char0>=1)||(char2==2)&&char1==3){
							analyResult = ScfBasConstant.FIN_ANALY_R_4; //较好 ;//4项中任意2项高于平均值，至少一项等于平均值 2211;2210
						}
						if(char1>=4||(char1==3&&char2==1&&char0==1)||(char1==2&&char2==2&&char0==1)){
							analyResult = ScfBasConstant.FIN_ANALY_R_3; //平均 ;//4项中任意3项等于平均值111x
						}
						if((char0==3&&char2>=1)||(char1==3&&char0==2)){
							analyResult = ScfBasConstant.FIN_ANALY_R_2; //较差 ;//4项中任意2项等于平均值，至少一项为平均值，0011,0012
						}
						if(char0>=4||(char0==3&&char1==2)){
							analyResult = ScfBasConstant.FIN_ANALY_R_1; //差 ;//4项中任意3项低于平均值000x
						}
						remark = remark + "企业的"+tds.getSubjNm()+finAnalyRMap.get(analyResult);
					  }
					  //运营能力 SUBE0003、SUBE0006、SUBJ0063
					  else if("SUBE0003".equals(subjId)||"SUBE0006".equals(subjId)||"SUBJ0063".equals(subjId)){
							if(char2>=3){ //
								analyResult = ScfBasConstant.FIN_ANALY_R_5; //优秀 ;//4项中任意3项高于平均值 222x
							}
							if(char2==2&&char1>=1){
								analyResult = ScfBasConstant.FIN_ANALY_R_4; //较好 ;//4项中任意2项高于平均值，至少一项等于平均值 2211;2210
							}
							if(char0>=3){
								analyResult = ScfBasConstant.FIN_ANALY_R_3; //平均 ;//4项中任意3项等于平均值111x
							}
							if(char0==2&&char1>=1){
								analyResult = ScfBasConstant.FIN_ANALY_R_2; //较差 ;//4项中任意2项等于平均值，至少一项为平均值，0011,0012
							}
							if(char0==2&&char1>=1){
								analyResult = ScfBasConstant.FIN_ANALY_R_1; //差 ;//4项中任意3项低于平均值000x
							}
							remark = remark + "企业的"+tds.getSubjNm()+ finAnalyRMap.get(analyResult);
					  }
					  //发展能力 SUBJ0064、SUBE0002、SUBE0007
					  else if("SUBJ0064".equals(subjId)||"SUBE0002".equals(subjId)||"SUBE0007".equals(subjId)){
							if(char2>=3){ //
								analyResult = ScfBasConstant.FIN_ANALY_R_5; //优秀 ;//4项中任意3项高于平均值 222x
							}
							if(char2==2&&char1>=1){
								analyResult = ScfBasConstant.FIN_ANALY_R_4; //较好 ;//4项中任意2项高于平均值，至少一项等于平均值 2211;2210
							}
							if(char0>=3){
								analyResult = ScfBasConstant.FIN_ANALY_R_3; //平均 ;//4项中任意3项等于平均值111x
							}
							if(char0==2&&char1>=1){
								analyResult = ScfBasConstant.FIN_ANALY_R_2; //较差 ;//4项中任意2项等于平均值，至少一项为平均值，0011,0012
							}
							if(char0==2&&char1>=1){
								analyResult = ScfBasConstant.FIN_ANALY_R_1; //差 ;//4项中任意3项低于平均值000x
							}
							remark = remark + "企业的"+tds.getSubjNm()+ finAnalyRMap.get(analyResult);
					  }
					  //现金流
					  else if("SUBJ0065".equals(subjId)||"SUBE0005".equals(subjId)||"SUBE0000".equals(subjId)){
							if(char2>=3){ //
								analyResult = ScfBasConstant.FIN_ANALY_R_5; //优秀 ;//4项中任意3项高于平均值 222x
							}
							if(char2==2&&char1>=1){
								analyResult = ScfBasConstant.FIN_ANALY_R_4; //较好 ;//4项中任意2项高于平均值，至少一项等于平均值 2211;2210
							}
							if(char0>=3){
								analyResult = ScfBasConstant.FIN_ANALY_R_3; //平均 ;//4项中任意3项等于平均值111x
							}
							if(char0==2&&char1>=1){
								analyResult = ScfBasConstant.FIN_ANALY_R_2; //较差 ;//4项中任意2项等于平均值，至少一项为平均值，0011,0012
							}
							if(char0==2&&char1>=1){
								analyResult = ScfBasConstant.FIN_ANALY_R_1; //差 ;//4项中任意3项低于平均值000x
							}
							remark = remark + "企业总体的"+tds.getSubjNm()+ finAnalyRMap.get(analyResult);
					  }
					
					// 标题项相关的新增
					 
					  BFinCustDsExt bFinCustDsExt = new BFinCustDsExt();
					  bFinCustDsExt.setId(UUIDGeneratorUtil.generate());
					  bFinCustDsExt.setSerialno(tds.getSerialno());
					  //bFinCustDsExt.setSubjId(ds.getSubjId());
				      bFinCustDsExt.setSubjId(subjId);
				      bFinCustDsExt.setAnalyDate(ScfDateUtil.formatDate(new Date()));
				      bFinCustDsExt.setResult(analyResult);
				      bFinCustDsExt.setRemark(remark);
				      bFinCustDsExt.setLastUptTlrno(ContextHolder.getUserInfo().getTlrNo());
				      bFinCustDsExt.setLastUpdDate(new Date());
				    //通过Serialno 和 subjId 查询记录是否存在,存在先删除
				       this.findBFinCustDsExtListDelete(bFinCustDsExt);
				      try {
						bFinCustDsExtDAO.insert(bFinCustDsExt);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new ScubeBizException("新增异常");
						
					}
				}
				
			}
		}
		
	}
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.fin.service.IBFinCustDsService#FinTargetAnaly(com.huateng.scf.bas.fin.model.BFinCustDs)
	 */
	@Override
	public List<VBFinCustDs> queryFinTargetAnaly(BFinCustDs bFinCustDs) throws ScubeBizException {
		// TODO Auto-generated method stub
		List<VBFinCustDs>  list=new ArrayList<VBFinCustDs>();
		String mdlId = bFinCustDs.getMdlId();
	
		com.huateng.scf.bas.fin.dao.model.BFinCustDs bFinCustDsdal = new com.huateng.scf.bas.fin.dao.model.BFinCustDs();
		bFinCustDsdal.setCustId(bFinCustDs.getCustId());
		bFinCustDsdal.setRptNo(bFinCustDs.getRptNo()); //报表期次
		bFinCustDsdal.setRpSource(bFinCustDs.getRpSource()); //报表周期
		bFinCustDsdal.setMdlId(mdlId);

		try {
		List<com.huateng.scf.bas.fin.dao.model.BFinCustDs>  dataList = bfincustdsdao.queryFinTargetAnalyData(bFinCustDsdal);
		VBFinCustDs  vBFinCustDs = null;
		boolean flagM = false;//该项科目显示类型控制
		if(dataList!=null&&dataList.size()>0){
			for(com.huateng.scf.bas.fin.dao.model.BFinCustDs vo:dataList){
				vBFinCustDs = new VBFinCustDs();
				
	    	    BeanUtils.copyProperties(vo, vBFinCustDs);
	    	    //格式化
	    	    if(!StringUtil.isEmpty(vo.getColVal1())){
	    	    	vBFinCustDs.setColVal1Str(ScfCommonUtil.amountFormatToString(vo.getColVal1()));
	    	    }
	    	    if(!StringUtil.isEmpty(vo.getColVal2())){
	    	    	vBFinCustDs.setColVal2Str(ScfCommonUtil.amountFormatToString(vo.getColVal2()));
	    	    }
				if(ScfBasConstant.ED_TYP_1.equals(vo.getEdTyp())){//输入项
					flagM = true;//输入项
				}
				if(ScfBasConstant.ED_TYP_2.equals(vo.getEdTyp()))
				{//计算项
					flagM = false;//计算项
				}
				if(ScfBasConstant.ED_TYP_3.equals(vo.getEdTyp()))
				{//标题项
					vBFinCustDs.setFlagM(false);
					vBFinCustDs.setColVal1(null);
					vBFinCustDs.setColVal2(null);
				}
				
				vBFinCustDs.setFlagM(flagM);
				/**
	    	     * 设置该项科目类型值		结束
	    	     */
				
	    	    if(vBFinCustDs.getCotes().intValue()==1){
	    	    	//第一栏初始化
		    		list.add(vBFinCustDs);
	    	    }
	    	    else if(vBFinCustDs.getCotes().intValue()==2){
	    	    	//第二栏初始化
	    	    	for(int k=0;k<list.size();k++){
	    	    		if(list.get(k).getOrd().intValue()==vBFinCustDs.getOrd().intValue())
		    			{
	    	    			list.get(k).setChild(vBFinCustDs);
		    				break;
		    			}
		    		}
	    	    }
	    	 }
		 }
 		} catch (BeansException e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
		}		
		return list;
	}
	/**
	 * 格式化财务报表对应的科目金额（去掉“-”号），以免跟计算公式冲突
	 * @param colVal
	 * @return  String
	 */
	private String formatColVal(String colVal){
		if(null==colVal || "".equals(colVal)){
			return "0";
		}
		if(null!=colVal && colVal.indexOf("-")>-1){
			colVal="("+colVal+")";
		}
		return colVal;
	}


	/***
	 * 获得字符串中str含str1的个数
	 * @param str
	 * @param str1
	 * @return
	 */
	private int getCharCount(String str,String str1){
		int  count =0;
		int start =0;
		while(str.indexOf(str1, start)>=0&&start<str.length()){
			count++;
			start = str.indexOf(str1, start)+str1.length();
		}
		return count;
	}
	
	
	//根据Serialno 和SubjId 查询记录是否存在,存在删除
	@Transactional
	private  void findBFinCustDsExtListDelete(BFinCustDsExt bFinCustDsExt) throws ScubeBizException{
		
		 BFinCustDsExtExample example =  new BFinCustDsExtExample();
		 BFinCustDsExtExample.Criteria criteria = example.createCriteria();
		 
		 if(StringUtil.isStrNotEmpty(bFinCustDsExt.getSerialno())){
			 criteria.andSerialnoEqualTo(bFinCustDsExt.getSerialno());
		 }
		 if(StringUtil.isStrNotEmpty(bFinCustDsExt.getSubjId())){
			 criteria.andSubjIdEqualTo(bFinCustDsExt.getSubjId());
		 }
		 List<BFinCustDsExt> list	= bFinCustDsExtDAO.selectByExample(example);
		 if(list!=null&&list.size()>0){
		    	for(BFinCustDsExt ext:list){
		    		try {
						bFinCustDsExtDAO.deleteByPrimaryKey(ext.getId());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new ScubeBizException("删除异常");
					}
		    	}
		      }
	}
}
