package com.huateng.scf.bas.fin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
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
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.fin.dao.IBFinCnfgClDAO;
import com.huateng.scf.bas.fin.dao.IBFinCustDAO;
import com.huateng.scf.bas.fin.dao.IBFinCustDirDAO;
import com.huateng.scf.bas.fin.dao.IBFinCustDsDAO;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgCl;
import com.huateng.scf.bas.fin.dao.model.BFinCustDir;
import com.huateng.scf.bas.fin.dao.model.BFinCustDirExample;
import com.huateng.scf.bas.fin.dao.model.BFinCustDs;
import com.huateng.scf.bas.fin.dao.model.BFinCustDsExample;
import com.huateng.scf.bas.fin.dao.model.BFinCustExample;
import com.huateng.scf.bas.fin.dao.model.BFinCustExample.Criteria;
import com.huateng.scf.bas.fin.model.BFinCust;
import com.huateng.scf.bas.fin.service.IBFinCustService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BFinCust接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月3日下午5:23:22
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月3日下午5:23:22	     新增
 *
 * </pre>
 */

@ScubeService
@Service("BFinCustServiceImpl")
public class BFinCustServiceImpl implements IBFinCustService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBFinCustDAO")
	IBFinCustDAO bfincustdao;
	
	@Resource(name = "IBFinCustDsDAO")
	IBFinCustDsDAO bfincustdsdao;
	
	@Resource(name = "IBFinCnfgClDAO")
	IBFinCnfgClDAO bfincnfgcldao;
	
	@Resource(name = "IBFinCustDirDAO")
	IBFinCustDirDAO bfincustdirdao;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	@Override
	@Transactional
	public void add(BFinCust bFinCust) {
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCust bFinCustdal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCust();
		try
		{
			BeanUtils.copyProperties(bFinCust, bFinCustdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		String finId =ibSysSerialNoService.genSerialNo("FIN_NO");
		UserInfo user = ContextHolder.getUserInfo(); 
	    String userId= user.getTlrNo();
		BctlVO BctlVO = ContextHolder.getOrgInfo();
	    String brcode = BctlVO.getBrNo();
	    
		bFinCustdal.setFinId(finId);
		bFinCustdal.setTlrNo(userId);// 创建人rptNO
		bFinCustdal.setBrCd(brcode);
		bFinCustdal.setInputDt(ScfDateUtil.formatDate(new Date()));
		bFinCustdal.setLstUpdTlr(userId);// 最后更新人
		bFinCustdal.setLstUpdBrCd(brcode);
		bFinCustdal.setLstUpdDt(ScfDateUtil.formatDate(new Date()));
		String rptNo=bFinCustdal.getRptNo();
		String finPd=bFinCustdal.getFinPd();
		try
		{
			bfincustdao.insert(bFinCustdal);//保存客户财报记录主表信息
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入客户记录异常");
		}
		//TODO
		String mdlCl = "1";//获取的客户类型，测试使用
		//获取该客户的财报模型
		List<BFinCnfgCl> listcl = bfincnfgcldao.selectByMldCl(mdlCl);
		if(listcl!=null&&listcl.size()>0)
		{
			BFinCustDir bFinCustDir = new BFinCustDir();
			bFinCustDir.setFinId(finId);//客户记录号
			bFinCustDir.setCustId(bFinCustdal.getCustId());//客户编号
			bFinCustDir.setFinScp(bFinCustdal.getFinScp());//财报口径
			bFinCustDir.setFinDt(bFinCustdal.getFinDt());//财报日期
			bFinCustDir.setFinStat("0");
			bFinCustDir.setTlrNo(userId);//登记人
			bFinCustDir.setBrCd(brcode);//登记机构
			bFinCustDir.setInputDt(ScfDateUtil.formatDate(new Date()));
			bFinCustDir.setLstUpdTlr(userId);//更新人
			bFinCustDir.setLstUpdBrCd(brcode);//更新机构
			bFinCustDir.setLstUpdDt(ScfDateUtil.formatDate(new Date()));
			bFinCustDir.setRptNo(rptNo);//报表期次 add by huangshuidan 2017-06-14
			bFinCustDir.setFinPd(finPd);//报表周期 add by huangshuidan 2017-06-15
			for(int i=0;i<listcl.size();i++)
			{
				BFinCnfgCl bfincnfgcl = listcl.get(i);
				String mdlTyp = bfincnfgcl.getMdlTyp();//模型种类，用于确定为资产负债表、损益表、现金流量表
				String mdlNm = bfincnfgcl.getMdlNm();//模型名称，默认为报表名称
				String mdlId = bfincnfgcl.getMdlId();//模型编号
				String mdlCode = mdlTyp+"-"+mdlId;//组合生成客户目录表中的模型编号
				String finDirId = UUIDGeneratorUtil.generate();//客户目录表主键
				bFinCustDir.setFinDirId(finDirId);
				bFinCustDir.setMdlId(mdlCode);
				bFinCustDir.setFinNm(mdlNm);
				try
				{
					bfincustdirdao.insertSelective(bFinCustDir);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("插入客户目录异常");
				}
			}
		}
	}

	@Override
	@Transactional
	public int update(BFinCust bFinCust) {
		UserInfo user = ContextHolder.getUserInfo(); 
	    String userId= user.getTlrNo();
		BctlVO BctlVO = ContextHolder.getOrgInfo();
	    String brcode = BctlVO.getBrNo();
	    
		bFinCust.setLstUpdTlr(userId);// 最后更新人
		bFinCust.setLstUpdBrCd(brcode);
		bFinCust.setLstUpdDt(ScfDateUtil.formatDate(new Date()));
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.fin.dao.model.BFinCust bFinCustdal = 
				new com.huateng.scf.bas.fin.dao.model.BFinCust();
		try
		{
			BeanUtils.copyProperties(bFinCust, bFinCustdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		int i;
		try
		{
			i = bfincustdao.updateByPrimaryKeySelective(bFinCustdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("更新异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int updateBFinCust(BFinCust bFinCust) {
	    int i=this.update(bFinCust);
	    UserInfo user = ContextHolder.getUserInfo(); 
		String userId= user.getTlrNo();
		BctlVO BctlVO = ContextHolder.getOrgInfo();
		String brcode = BctlVO.getBrNo();
		//根据财报记录号更新客户财报目录的相关信息
		BFinCustDirExample  example = new BFinCustDirExample();
		BFinCustDirExample.Criteria criteria = example.createCriteria();
		criteria.andFinIdEqualTo(bFinCust.getFinId());
		BFinCustDir bFinCustDir = new BFinCustDir();
		bFinCustDir.setCustId(bFinCust.getCustId());//客户编号
		bFinCustDir.setFinScp(bFinCust.getFinScp());//财报口径
		bFinCustDir.setFinDt(bFinCust.getFinDt());//财报日期
		bFinCustDir.setLstUpdTlr(userId);//更新人
		bFinCustDir.setLstUpdBrCd(brcode);//更新机构
		bFinCustDir.setLstUpdDt(ScfDateUtil.formatDate(new Date()));
		bFinCustDir.setRptNo(bFinCust.getRptNo());//报表期次 add by huangshuidan 2017-06-14
		bFinCustDir.setFinPd(bFinCust.getFinPd());//报表周期 add by huangshuidan 2017-06-15
		
		try {
			bfincustdirdao.updateByExampleSelective(bFinCustDir, example);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("更新客户财报目录异常"+e.getMessage());
			e.printStackTrace();
			throw new ScubeBizException("更新客户财报目录异常！");
		}
		//根据财报目录号更新客户财报数据的财报周期，财报期次
		List<BFinCustDs> listds	= bfincustdsdao.queryFinCustDsByFinId(bFinCust.getFinId());
		List<String> finDirs = new ArrayList<String>();
		if(null!=listds&&listds.size()>0){
			for(BFinCustDs ds:listds){
				finDirs.add(ds.getFinDirId());
			}
			BFinCustDs custDs = new BFinCustDs();
			custDs.setRpSource(bFinCust.getFinPd());
			custDs.setRptNo(bFinCust.getRptNo());
			BFinCustDsExample  exampleds = new BFinCustDsExample();
			BFinCustDsExample.Criteria cri = exampleds.createCriteria();
			cri.andFinDirIdIn(finDirs);
			try {
				bfincustdsdao.updateByExampleSelective(custDs, exampleds);
			} catch (Exception e) {
				log.error("更新客户财报数据异常"+e.getMessage());
				e.printStackTrace();
				throw new ScubeBizException("更新客户财报数据异常！");
			}
			
		}
		
		return i;
	}
	@Override
	@Transactional
	public int delete(String finId) {
		log.info(finId);
		int i;
		try
		{
			try
			{
				bfincustdsdao.deleteByFinId(finId);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("删除客户财报数据异常");
			}
			try
			{
				bfincustdirdao.deleteByFinId(finId);
			}
			catch(BeansException e)
			{
				throw new ScubeBizException("删除客户财报科目异常");
			}
			i = bfincustdao.deleteByPrimaryKey(finId);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("删除异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int batchDelete(String finIds) {
		log.info(finIds);
		int rows = 0;
		String[] finIdsArr = finIds.split(",");
        for(String finId:finIdsArr)
        {
        	rows += delete(finId);
        }
		return rows;
	}

	@Override
	public BFinCust findBFinCustByFinId(String finId) {
		com.huateng.scf.bas.fin.dao.model.BFinCust bFinCustdal = bfincustdao.selectByPrimaryKey(finId);
		// VO转PO 展现层对象转换DAO层对象  
		BFinCust bFinCust = new BFinCust();
		try
		{
			BeanUtils.copyProperties(bFinCustdal, bFinCust);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		return bFinCust;
	}

	@Override
	public Page findBFinCustByPage(int pageNo, int pageSize, BFinCust bFinCust) {
		
		BFinCustExample example = new BFinCustExample();
		Criteria cri = example.createCriteria();
		
		if(bFinCust != null)
		{
			if(bFinCust.getFinDt()!=null&&bFinCust.getFinDt().length()>0)
			{
				String finDt = bFinCust.getFinDt();
				finDt = finDt.substring(0, finDt.length()-2);
				cri.andFinDtLike("%"+finDt+"%");
			}
			cri.andTlrNoEqualTo(ContextHolder.getUserInfo().getTlrNo());
		}
		example.setOrderByClause("INPUT_DT desc");
		
		int total = bfincustdao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bfincustdao.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}
	
	/**
	 * 由客户编号获取客户种类信息，由客户种类信息获取该类客户的财务报表模板信息
	 */
	@Override
	public List<com.huateng.scf.bas.fin.model.BFinCnfgCl> findMdlClsByCustId(BFinCust bFinCust)
	{
		String finId = bFinCust.getFinId();
		//TODO
		String mdlCl = "1";//获取的客户类型，测试使用
		//获取该客户的财报模型
		BFinCnfgCl bfincl = new BFinCnfgCl();
		bfincl.setMdlCl(mdlCl);
		bfincl.setMdlId(finId);
		List<BFinCnfgCl> listdal = bfincnfgcldao.selectByMldCl(bfincl);
		List<com.huateng.scf.bas.fin.model.BFinCnfgCl> list = 
				new ArrayList<com.huateng.scf.bas.fin.model.BFinCnfgCl>();
		if(listdal.size()>0)
		{
			for(BFinCnfgCl bfincnfgcldal:listdal)
			{
				// VO转PO 展现层对象转换DAO层对象
				com.huateng.scf.bas.fin.model.BFinCnfgCl bfincnfgcl = 
						new com.huateng.scf.bas.fin.model.BFinCnfgCl();
				try
				{
					BeanUtils.copyProperties(bfincnfgcldal, bfincnfgcl);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				list.add(bfincnfgcl);
			}
		}
		return list;
	}

	/**
	 * 经营分析-客户信用-财报查看
	 * 根据客户id 获得客户财报记录表的年报的最新记录
	 * @param custId
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public BFinCust findBFinCustByCustId(String custId) throws ScubeBizException {
		// TODO Auto-generated method stub
		if(StringUtil.isStrEmpty(custId)){
			throw new ScubeBizException("客户id参数丢失");
		}
		BFinCust bFinCust = new  BFinCust();
		BFinCustExample  example = new BFinCustExample();
		BFinCustExample.Criteria criteria= example.createCriteria();
		criteria.andCustIdEqualTo(custId);
		criteria.andFinPdEqualTo(ScfBasConstant.RP_SOURCE_04);
		example.setOrderByClause("LST_UPD_DT desc");
		 List<com.huateng.scf.bas.fin.dao.model.BFinCust> list = bfincustdao.selectByExample(example);
		 if(list!=null&&list.size()>0){
			 com.huateng.scf.bas.fin.dao.model.BFinCust bFinCustdal= list.get(0);
		 if(bFinCustdal!=null){
			 BeanUtils.copyProperties(bFinCustdal, bFinCust);
		 }
		 }
			 
		 return bFinCust;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.fin.service.IBFinCustService#findMdlClsNotCWZBByCustId(com.huateng.scf.bas.fin.model.BFinCust)
	 */
	@Override
	public List<com.huateng.scf.bas.fin.model.BFinCnfgCl> findMdlClsNotCWZB(BFinCust bFinCust) {
		// TODO Auto-generated method stub
		List<com.huateng.scf.bas.fin.model.BFinCnfgCl> list = 
				new ArrayList<com.huateng.scf.bas.fin.model.BFinCnfgCl>();
		list = this.findMdlClsByCustId(bFinCust);
		if(list!=null&&list.size()>0){
			for(com.huateng.scf.bas.fin.model.BFinCnfgCl info:list){
				if(ScfBasConstant.MDL_ID_CWZB.equals(info.getMdlId())){
					list.remove(info);
					break;
				}
			}
		}
		return list;
	}
}
