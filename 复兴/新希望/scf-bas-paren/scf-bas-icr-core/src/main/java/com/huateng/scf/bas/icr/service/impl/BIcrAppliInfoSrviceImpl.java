/**
 * 
 */
package com.huateng.scf.bas.icr.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.icr.constant.BIcrConstant;
import com.huateng.scf.bas.icr.dao.IBIcrAppliInfoDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliInfoExample.Criteria;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliInfoExample;
import com.huateng.scf.bas.icr.model.BIcrAppliInfo;
import com.huateng.scf.bas.icr.service.IBIcrAppliInfoService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>XXX</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月9日.上午11:29:18
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月9日.上午11:29:18	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BIcrAppliInfoSrviceImpl")
public class BIcrAppliInfoSrviceImpl  implements  IBIcrAppliInfoService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BIcrAppliInfoDAO")
	IBIcrAppliInfoDAO bIcrAppliInfoDAO;
	@Resource(name = "BSysSerialNoServiceImpl")
	private  IBSysSerialNoService bSysSerialNoService;
	@Override
	@Transactional
	public void addCreditAppliInfo(BIcrAppliInfo bIcrAppliInfo) throws ScubeBizException{
		ScfCommonUtil.setCommonField(bIcrAppliInfo);//设置公共字段 
		// 获取机构信息
		BctlVO BctlVO = ContextHolder.getOrgInfo();
		String brcode = BctlVO.getBrNo();
		bIcrAppliInfo.setBrcode(brcode);
		bIcrAppliInfo.setId(UUIDGeneratorUtil.generate());
		com.huateng.scf.bas.icr.dao.model.BIcrAppliInfo bIcrAppliInfoDal = new com.huateng.scf.bas.icr.dao.model.BIcrAppliInfo();
		BeanUtils.copyProperties(bIcrAppliInfo, bIcrAppliInfoDal);
		bIcrAppliInfoDAO.insert(bIcrAppliInfoDal);
		
	}

	@Override
	@Transactional
	public int updateCreditAppliInfo(BIcrAppliInfo bIcrAppliInfo) throws ScubeBizException{
		// TODO Auto-generated method stub
		com.huateng.scf.bas.icr.dao.model.BIcrAppliInfo bIcrAppliInfoDal = new com.huateng.scf.bas.icr.dao.model.BIcrAppliInfo();
		BeanUtils.copyProperties(bIcrAppliInfo, bIcrAppliInfoDal);
		return bIcrAppliInfoDAO.updateByPrimaryKey(bIcrAppliInfoDal);
	}


	@Override
	@Transactional
	public int delete(String id) throws ScubeBizException{
		// TODO Auto-generated method stub
		log.info("BIcrAppliInfoSrviceImpl delete  id:"+id);
		return bIcrAppliInfoDAO.deleteByPrimaryKey(id);
	}
	/**
	 * 根据额度申请信息删除额度申请信息
	 */
	@Override
	@Transactional
	public int deleteByBIcrAppliInfo(BIcrAppliInfo bIcrAppliInfo)throws ScubeBizException {
		// TODO Auto-generated method stub
		BIcrAppliInfoExample example = new BIcrAppliInfoExample();
		Criteria cri = example.createCriteria();
		int i =0;
		if(bIcrAppliInfo!=null){
			//额度领用信息查询
			if(bIcrAppliInfo.getNodeType()!=null&&bIcrAppliInfo.getNodeType().length()>0){
				cri.andNodeTypeEqualTo(bIcrAppliInfo.getNodeType());
			}
			if(bIcrAppliInfo.getUpCreditNo()!=null&&bIcrAppliInfo.getUpCreditNo().length()>0){
				cri.andUpCreditNoEqualTo(bIcrAppliInfo.getUpCreditNo());
			}
		}
		try {
			i= bIcrAppliInfoDAO.deleteByExample(example);
		} catch (Exception e) {
			//e.printStackTrace();
			log.error("删除额度申请信息失败！");
			throw new ScubeBizException("删除额度申请信息失败！",e);
		}
		return i;
	}
	@Override
	public Page queryCreditAppliInfoByPage(int pageNo, int pageSize, BIcrAppliInfo bIcrAppliInfo) throws ScubeBizException{
		Page p = new Page(pageSize, pageNo, 0);

		BIcrAppliInfoExample example = new BIcrAppliInfoExample();
		Criteria cri = example.createCriteria();
		if (bIcrAppliInfo != null) {
			if (bIcrAppliInfo.getAppno() != null&&bIcrAppliInfo.getAppno().length()>0) {
				cri.andAppnoEqualTo(bIcrAppliInfo.getAppno()); //申请编号
			}
			if(bIcrAppliInfo.getCreditNo()!=null&&bIcrAppliInfo.getCreditNo().length()>0){
				cri.andCreditNoEqualTo(bIcrAppliInfo.getCreditNo());
			}
			if(bIcrAppliInfo.getCreditType()!=null&&bIcrAppliInfo.getCreditType().length()>0){
				cri.andCreditTypeEqualTo(bIcrAppliInfo.getCreditType());
			}
			
			if(bIcrAppliInfo.getUpCreditNo()!=null&&bIcrAppliInfo.getUpCreditNo().length()>0){
				cri.andUpCreditNoEqualTo(bIcrAppliInfo.getUpCreditNo());
			}
			if(bIcrAppliInfo.getNodeType()!=null&&bIcrAppliInfo.getNodeType().length()>0){
				cri.andNodeTypeEqualTo(bIcrAppliInfo.getNodeType()); //节点类型
			}
			if(bIcrAppliInfo.getCreditClass()!=null&&bIcrAppliInfo.getCreditClass().length()>0){
				cri.andCreditClassEqualTo(bIcrAppliInfo.getCreditClass()); //额度类型
			}
			if(bIcrAppliInfo.getStatus()!=null&&bIcrAppliInfo.getStatus().length()>0){
				cri.andStatusEqualTo(bIcrAppliInfo.getStatus()); //额度状态
			}
			
		}
		/*log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		*/
		p.setRecords(bIcrAppliInfoDAO.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}
	//根据总额度编号查询有效已领用间接额度查询
	@Override
	public Page findBIcrAppliInfoByPage(int pageNo, int pageSize, String  creditNo)throws ScubeBizException {
		// TODO Auto-generated method stub
		BIcrAppliInfo bIcrAppliInfo = new BIcrAppliInfo();
		bIcrAppliInfo.setUpCreditNo(creditNo);
		bIcrAppliInfo.setNodeType(BIcrConstant.CREDIT_NODE_TYPE_SUB_LEAF);
		return queryCreditAppliInfoByPage(pageNo,pageSize,bIcrAppliInfo);
	}
	
	@Override
	public BIcrAppliInfo queryCreditAppliInfoKey(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 根据额度编号查询额度申请信息
	 * @param bIcrAppliInfo
	 * @return
	 * @throws ScubeBizException
	 */
	public BIcrAppliInfo queryBIcrAppliInfoByCreditNo(BIcrAppliInfo bIcrAppliInfo) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.icr.dao.model.BIcrAppliInfo bIcrAppliInfoDal = new com.huateng.scf.bas.icr.dao.model.BIcrAppliInfo();
		BeanUtils.copyProperties(bIcrAppliInfo, bIcrAppliInfoDal);
		bIcrAppliInfoDal =bIcrAppliInfoDAO.queryBIcrAppliInfoByCreditNo(bIcrAppliInfoDal);
		if(bIcrAppliInfoDal==null){
			bIcrAppliInfo=null;
		}else{
			BeanUtils.copyProperties(bIcrAppliInfoDal, bIcrAppliInfo);
		}
		
		return bIcrAppliInfo;
	}

}
