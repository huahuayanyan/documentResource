package com.huateng.scf.bas.fin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.fin.dao.IBFinCnfgDefDAO;
import com.huateng.scf.bas.fin.dao.IBFinCnfgSubjDAO;
import com.huateng.scf.bas.fin.dao.ext.ExtBFinCnfgSubjDAO;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgDefExample;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgDefExample.Criteria;
import com.huateng.scf.bas.fin.model.BFinCnfgCl;
import com.huateng.scf.bas.fin.model.BFinCnfgDef;
import com.huateng.scf.bas.fin.model.VBFinCnfgDef;
import com.huateng.scf.bas.fin.service.IBFinCnfgDefService;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * <p>BFinCnfgDef接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月3日下午2:15:52
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月3日下午2:15:52	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BFinCnfgDefServiceImpl")
public class BFinCnfgDefServiceImpl implements IBFinCnfgDefService{
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBFinCnfgDefDAO")
	IBFinCnfgDefDAO bfincnfgdefdao;
	
	@Resource(name = "IBFinCnfgSubjDAO")
	IBFinCnfgSubjDAO bfincnfgsubjdao;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	@Resource(name = "ExtBFinCnfgSubjDAO")
	ExtBFinCnfgSubjDAO extbfincnfgsubjdao;
	
	@Override
	@Transactional
	public String add(BFinCnfgDef bFinCnfgDef) {
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCnfgDef bFinCnfgDefdal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCnfgDef();
		try
		{
			BeanUtils.copyProperties(bFinCnfgDef, bFinCnfgDefdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		String i ;
		bFinCnfgDefdal.setSerialno(UUIDGeneratorUtil.generate());
		try
		{
			i = bfincnfgdefdao.insert(bFinCnfgDefdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int delete(String serialno) {
		int i;
		try
		{
			i = bfincnfgdefdao.deleteByPrimaryKey(serialno);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("删除异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int batchDelete(String serialnos) {
		int i=0;
		String[] serialnoArr = serialnos.split(",");
		for(String serialno:serialnoArr)
		{
			i += delete(serialno);
		}
		return i;
	}

	@Override
	@Transactional
	public int update(BFinCnfgDef bFinCnfgDef) {
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCnfgDef bFinCnfgDefdal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCnfgDef();
		try
		{
			BeanUtils.copyProperties(bFinCnfgDef, bFinCnfgDefdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		int i ;
		try
		{
			i = bfincnfgdefdao.updateByPrimaryKey(bFinCnfgDefdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("更新异常");
		}
		return i;
	}

	@Override
	public Page findBFinCnfgDefByPage(int pageNo, int pageSize, BFinCnfgDef bFinCnfgDef) {
		int total = bfincnfgdefdao.countByExample(new BFinCnfgDefExample());
		Page p = new Page(pageSize, pageNo, total);
		
		BFinCnfgDefExample example = new BFinCnfgDefExample();
		Criteria cri = example.createCriteria();
		
		if(bFinCnfgDef != null)
		{
			if(bFinCnfgDef.getMdlId()!=null&&bFinCnfgDef.getMdlId().length()>0)
			{
				cri.andMdlIdLike("%"+bFinCnfgDef.getMdlId()+"%");
			}
			if(bFinCnfgDef.getSubjId()!=null&&bFinCnfgDef.getSubjId().length()>0)
			{
				cri.andSubjIdLike("%"+bFinCnfgDef.getSubjId()+"%");
			}
			if(bFinCnfgDef.getSubjNm()!=null&&bFinCnfgDef.getSubjNm().length()>0)
			{
				cri.andSubjNmLike("%"+bFinCnfgDef.getSubjNm()+"%");
			}
			if(bFinCnfgDef.getEdTyp()!=null&&bFinCnfgDef.getEdTyp().length()>0)
			{
				cri.andEdTypEqualTo(bFinCnfgDef.getEdTyp());
			}
		}
		example.setOrderByClause("ORD");
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bfincnfgdefdao.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}

	@Override
	public BFinCnfgDef findBFinCnfgDefBySerialno(String serialno) {
		log.info(serialno);
		// VO转PO 展现层对象转换DAO层对象
		BFinCnfgDef bFinCnfgDef = new BFinCnfgDef();
		com.huateng.scf.bas.fin.dao.model.BFinCnfgDef bFinCnfgDefdal = bfincnfgdefdao.selectByPrimaryKey(serialno);
		try
		{
			BeanUtils.copyProperties(bFinCnfgDefdal, bFinCnfgDef);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		return bFinCnfgDef;
	}

	/**
	 * 根据客户财报记录号及报表种类信息获得模型信息
	 */
	public Page findBFinCnfgDefByFinId(int pageNo, int pageSize, BFinCnfgDef bFinCnfgDef) {
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCnfgDef bFinCnfgDefdal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCnfgDef();
		try
		{
			BeanUtils.copyProperties(bFinCnfgDef, bFinCnfgDefdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		
		int total = bfincnfgdefdao.selectByFinId(bFinCnfgDefdal).size();
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bfincnfgdefdao.selectByFinId(bFinCnfgDefdal, p));
		log.info("p.toString()="+p.toString());
		return p;
	}
	
	/**
	 * 根据模型编码获得模型信息
	 */
	@Override
	public List<BFinCnfgDef> findBFinCnfgDefByMdlId(String mdlId) {
		List<com.huateng.scf.bas.fin.dao.model.BFinCnfgDef> listdal = bfincnfgdefdao.selectByMdlId(mdlId);
		List<BFinCnfgDef> list = new ArrayList<BFinCnfgDef>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.bas.fin.dao.model.BFinCnfgDef bfindefdal:listdal)
			{
				// VO转PO 展现层对象转换DAO层对象
				BFinCnfgDef bfindef = new BFinCnfgDef();
				try
				{
					BeanUtils.copyProperties(bfindefdal, bfindef);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				list.add(bfindef);
			}
		}
		return list;
	}
	@Override
	public String findBFinCnfgDefBySubjId(String subjIds)
	{
		String flag = "";
		String[] subjIdArr = subjIds.split(",");
		for(String subjId:subjIdArr)
		{
			List<com.huateng.scf.bas.fin.dao.model.BFinCnfgDef> list = bfincnfgdefdao.selectBySubjId(subjId);
			if(list.size()>0)
			{
				flag = "false";
				return flag;
			}
			else
			{
				flag = "true";
			}
		}
		return flag;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findBFinCnfgDefByBFinCnfgCl(BFinCnfgCl bFinCnfgCl) {
		// TODO Auto-generated method stub
		List<VBFinCnfgDef>  vBFinCnfgDefList=new ArrayList<VBFinCnfgDef>();
		
    	try {
    		for(int i=1;i<=bFinCnfgCl.getCotes().intValue();i++){
		    	    Page p=findBFinCnfgDefByBFinCnfgCl(bFinCnfgCl.getMdlId(),BigDecimal.valueOf(i));      
			    	for(int j=0;j<p.getRecords().size();j++){
			    		com.huateng.scf.bas.fin.dao.model.BFinCnfgDef bFinCnfgDef=(com.huateng.scf.bas.fin.dao.model.BFinCnfgDef) p.getRecords().get(j);
			    		VBFinCnfgDef vBFinCnfgDef=new VBFinCnfgDef();
			    	    BeanUtils.copyProperties(bFinCnfgDef, vBFinCnfgDef);
			    	    String edTyp = bFinCnfgDef.getEdTyp();
			    	    //判断项目是否为标题项，如果是，则colVal值设为空
			    	    if(StringUtil.isEmpty(edTyp))
			    	    {
			    	    	vBFinCnfgDef.setColVal1(null);
			    	    	vBFinCnfgDef.setColVal2(null);
			    	    }
			    	    else
			    	    {
			    	    	if(bFinCnfgDef.getEdTyp().equals("3"))
				    	    {
				    	    	vBFinCnfgDef.setColVal1(null);
				    	    	vBFinCnfgDef.setColVal2(null);
				    	    }
				    	    else
				    	    {
				    	    	vBFinCnfgDef.setColVal1(new BigDecimal(0.00));
				    	    	vBFinCnfgDef.setColVal2(new BigDecimal(0.00));
				    	    }
			    	    }
			    	    
			    	   if(i==1){
			    		 //第一栏初始化
			    	      vBFinCnfgDefList.add(vBFinCnfgDef);
			    	   }
			    	   else if(i==2){
			    		   //第二栏初始化
			    		   for(int k=0;k<vBFinCnfgDefList.size();k++){
				    			  if(vBFinCnfgDefList.get(k).getOrd().intValue()==vBFinCnfgDef.getOrd().intValue()){
					    			     vBFinCnfgDefList.get(k).setChild(vBFinCnfgDef);
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
		return vBFinCnfgDefList;
	}
	
	public Page findBFinCnfgDefByBFinCnfgCl(String mdlId,BigDecimal cotes) {
		// TODO Auto-generated method stub
		Page p = new Page(1000000, 1, 0);
		BFinCnfgDefExample example = new BFinCnfgDefExample();
		Criteria cri = example.createCriteria();	
		cri.andMdlIdEqualTo(mdlId);
		cri.andCotesEqualTo(cotes);
		example.setOrderByClause("ORD");
		bfincnfgdefdao.selectByPage(example, p);
		return p;
	}

	public Page findBFinCnfgDefByBFinCnfgCl(String mdlId) {
		Page p = new Page(1000000, 1, 0);
		BFinCnfgDefExample example = new BFinCnfgDefExample();
		Criteria cri = example.createCriteria();	
		cri.andMdlIdEqualTo(mdlId);
		example.setOrderByClause("COTES,ORD");
		bfincnfgdefdao.selectByPage(example, p);
		return p;
	}
	/**
	 * 根据模型ID和报表周期查询指标
	 * @param mdlId
	 * 		String-模型ID
	 * @param rpSource
	 * 		String-报表周期
	 * @return
	 */
	public Page findBFinCnfgDefByMdlIdRpSource(String mdlId,String rpSource) {
		//TODO 参数非空判断有时间得完善
		Page p = new Page(1000000, 1, 0);
		BFinCnfgDefExample example = new BFinCnfgDefExample();
		Criteria cri = example.createCriteria();	
		if (StringUtil.isStrNotEmpty(mdlId)) {
			cri.andMdlIdEqualTo(mdlId);
		}
		if (StringUtil.isStrNotEmpty(rpSource)) {
			cri.andRpSourceEqualTo(rpSource);
		}
		example.setOrderByClause("COTES,ORD");
		bfincnfgdefdao.selectByPage(example, p);
		return p;
	}
	
	@Transactional
	public void add(VBFinCnfgDef vBFinCnfgDef) {
		com.huateng.scf.bas.fin.dao.model.BFinCnfgDef bFinCnfgDefdal = new com.huateng.scf.bas.fin.dao.model.BFinCnfgDef();
			BeanUtils.copyProperties(vBFinCnfgDef, bFinCnfgDefdal);
			bfincnfgdefdao.insert(bFinCnfgDefdal);
	}
	
	@Override
	@Transactional
	public void saveBFinCnfgDefList(List<VBFinCnfgDef> bFinCnfgDefList, BFinCnfgCl bFinCnfgCl) {
		// TODO Auto-generated method stub
		
    	try {	
    		   bfincnfgdefdao.deleteByMdlId(bFinCnfgCl.getMdlId());
				for(int i=0;i<bFinCnfgDefList.size();i++){
					VBFinCnfgDef   parentBFinCnfgDef =bFinCnfgDefList.get(i);
					    parentBFinCnfgDef.setOrd(BigDecimal.valueOf(i+1));
					    String serialno=parentBFinCnfgDef.getSerialno();
					   if(StringUtils.isBlank(serialno)){
						   parentBFinCnfgDef.setSerialno(UUIDGeneratorUtil.generate());
						   }
					   parentBFinCnfgDef.setMdlId(bFinCnfgCl.getMdlId());
					   //插入第一栏
					    add(parentBFinCnfgDef);
					   
					     VBFinCnfgDef childBFinCnfgDef=parentBFinCnfgDef.getChild();
						   if(childBFinCnfgDef!=null&&childBFinCnfgDef.getCotes()!=null){
							   
							   if(StringUtils.isBlank(childBFinCnfgDef.getSerialno())){
								   childBFinCnfgDef.setSerialno(UUIDGeneratorUtil.generate());
								   }
							   childBFinCnfgDef.setMdlId(bFinCnfgCl.getMdlId());
							   childBFinCnfgDef.setOrd(BigDecimal.valueOf(i+1));
							   //插入第二栏
							    add(childBFinCnfgDef);
						   }
					   
					}

    	} catch (Exception e) {
			log.warn("转换异常", e);
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50000),BSysErrorConstant.SCF_BAS_DCR_50000);
		}			
	}

	/**
	 * 保存报表模板信息
	 * @param bFinCnfgDef
	 */
	@Override
	public void saveBFinCnfgDef(BFinCnfgDef bFinCnfgDef) 
	{
		//1.校验科目名称是否存在
		//2.科目名称存在，校验科目编号
		//3.科目名称不存在，新增科目信息
		String subjNm = bFinCnfgDef.getSubjNm();
		String subjId = bFinCnfgDef.getSubjId();
		com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj bFinCnfgSubj = bfincnfgsubjdao.selectBySubjNm(subjNm);
		if(bFinCnfgSubj!=null)
		{
			if(!StringUtil.isEmpty(subjId)&&!subjId.equals(bFinCnfgSubj.getSubjId()))
			{
				throw new ScubeBizException("所填写的报表科目与编号不匹配，请重新选择！");
			}
		}
		else
		{
			subjId = ibSysSerialNoService.genSerialNo("SUBJ_NO");
			com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj cnfgSubj = new com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj();
			cnfgSubj.setSubjNm(subjNm.trim());
			cnfgSubj.setSubjId(subjId);
			cnfgSubj.setDelFlg("0");
			bfincnfgsubjdao.insert(cnfgSubj);
			bFinCnfgDef.setSubjId(subjId);
		}
		
		if(StringUtils.isEmpty(bFinCnfgDef.getSerialno()))
		{
			add(bFinCnfgDef);
		}
		else
		{
			update(bFinCnfgDef);
		}
	}
	
	/**
	 * 编辑报表科目信息时，选择科目均在报表科目中选择
	 */
	@Override
	public Page queryBFinCnfgDefSubjByPage(int pageNo, int pageSize,HashMap<String, String> value) {
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		HashMap<String, String> omap = new HashMap<String, String>();
		if(value!=null)
		{
			if(value.get("subjId")!=null)
			{
				omap.put("subjId", value.get("subjId").toString().trim());
			}
			if(value.get("subjNm")!=null)
			{
				omap.put("subjNm", value.get("subjNm").toString().trim());
			}
			if(value.get("mdlId")!=null)
			{
				omap.put("mdlId", value.get("mdlId").toString().trim());
			}
			if(value.get("edTyp")!=null)
			{
				omap.put("edTyp", value.get("edTyp").toString().trim());
			}
		}
		page.setRecords(extbfincnfgsubjdao.queryBFinCnfgDefSubjByPage(omap, page));
		page.setTotalRecord(extbfincnfgsubjdao.countBFinCnfgDefSubjByPage(omap));
		return page;
	}
	
	@Override
	public HashMap<String, String> getSubjInfoByCode(String calCode,String chkCode)
	{
		HashMap<String, String> omap = new HashMap<String, String>();
		if(StringUtil.isEmpty(calCode))
		{
			omap.put("calNm", "");
		}
		else
		{
			String calNm = getSubjNm(calCode);
			omap.put("calNm", calNm);
		}
		if(StringUtil.isEmpty(chkCode))
		{
			omap.put("chkNm", "");
		}
		else
		{
			String chkNm = getSubjNm(chkCode);
			omap.put("chkNm", chkNm);
		}
		return omap;
	}
	
	public String getSubjNm(String code)
	{
		//去除字符串最后一个">"后的字符串
		String newCode = code.substring(0, code.lastIndexOf(">")+1);
		String[] strCode = newCode.split(">");
		for(String str:strCode)
		{
			String subjId = str.substring(str.indexOf("<")+1);
			com.huateng.scf.bas.fin.dao.model.BFinCnfgSubj bFinCnfgSubj = bfincnfgsubjdao.selectByPrimaryKey(subjId);
			String rex = "<"+subjId+">";
			code = code.replaceAll(rex, bFinCnfgSubj.getSubjNm());
		}
		return code;
	}
	
	/**
	 * 粗略验证运算符使用准确性
	 */
	@Override
	public boolean checkRight(String value)
	{
		//判断字符串是否为空
		if(StringUtil.isEmpty(value))
		{
			return true;
		}
		/**
		 * 判断运算符小括号及中括号使用是否正确
		 * 1.判断是否出现括号
		 * 2.左括号及右括号个数是否相同
		 * 3.括号使用位置是否正确
		 * 4.运算符加减乘除使用是否正确
		 */
		int smalL = 0;//小括号(左括号个数
		int smalR = 0;//小括号)右括号个数
		int bigL = 0;//中括号[左括号个数
		int bigR = 0;//中括号]右括号个数
		char[] valueChar = value.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(char c : valueChar)
		{
			if("(".charAt(0)==c)
			{
				smalL ++;
				sb.append(c);
			}
			if(")".charAt(0)==c)
			{
				smalR ++;
				sb.append(c);
			}
			if("[".charAt(0)==c)
			{
				bigL ++;
				sb.append(c);
			}
			if("]".charAt(0)==c)
			{
				bigR ++;
				sb.append(c);
			}
		}
		/**
		 * 1.判断是否出现括号
		 * 如果没有括号，则判断字符串首字符及最后一个字符是否是加减乘除运算中的一个
		 */
		if(smalL==0&&smalR==0&&bigL==0&&bigR==0)
		{
			if(value.charAt(0)=="+".charAt(0)||value.charAt(0)=="-".charAt(0)||value.charAt(0)=="*".charAt(0)||value.charAt(0)=="/".charAt(0))
			{
				return false;
			}
			if(value.charAt(value.length()-1)=="+".charAt(0)||value.charAt(value.length()-1)=="-".charAt(0)||value.charAt(value.length()-1)=="*".charAt(0)||value.charAt(value.length()-1)=="/".charAt(0))
			{
				return false;
			}
			return true;
		}
		//1.左括号及右括号个数是否相同
		if(smalL!=smalR||bigL!=bigR)
		{
			return false;
		}
		//2.括号使用位置是否正确
		String signal = sb.toString();
		char[] signalChar = signal.toCharArray();
		if(")".equals(signalChar[0])||"]".equals(signalChar[0]))
		{
			return false;
		}
		signal = removeDouble(signal, "()");
		signal = removeDouble(signal, "[]");
		if(!StringUtil.isEmpty(signal))
		{
			return false;
		}
		return true;
	}
	
	public String removeDouble(String str,String signal)
	{
		if(StringUtil.isEmpty(str))
		{
			return str;
		}
		if(str.contains(signal))
		{
			str = str.replace(signal, "");
			str = removeDouble(str, signal);
		}
		return str;
	}
}
