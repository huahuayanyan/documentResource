/**
 * 
 */
package com.huateng.scf.bas.icr.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.dao.IBIcrAppliChgDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliChgExample;
import com.huateng.scf.bas.icr.model.BIcrAppliChg;
import com.huateng.scf.bas.icr.dao.model.BIcrAppliChgExample.Criteria;
import com.huateng.scf.bas.icr.service.IBIcrAppliChgService;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	huangshuidan
 * @date 	2016年10月31日 下午2:16:49
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			      Content
 * huangshuidan		2016年10月31日 下午2:16:49	              新增
 *
 * </pre>
 */
@ScubeService
@Service("BIcrAppliChgServiceImpl")
public class BIcrAppliChgServiceImpl implements IBIcrAppliChgService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BIcrAppliChgDAO")
	IBIcrAppliChgDAO bIcrAppliChgDAO;
	
	@Override
	@Transactional
	public void addCreditAppliChg(BIcrAppliChg bIcrAppliChg) {
		com.huateng.scf.bas.icr.dao.model.BIcrAppliChg bIcrAppliChgDal = new com.huateng.scf.bas.icr.dao.model.BIcrAppliChg();
		BeanUtils.copyProperties(bIcrAppliChg, bIcrAppliChgDal);
		 bIcrAppliChgDAO.insert(bIcrAppliChgDal);
	}

	@Override
	@Transactional
	public int updateCreditAppliChg(BIcrAppliChg bIcrAppliChg) {
		log.info("BicrAppliChgServiceImpl update  bIcrAppliChg:"+bIcrAppliChg);
		com.huateng.scf.bas.icr.dao.model.BIcrAppliChg bIcrAppliChgDal = new com.huateng.scf.bas.icr.dao.model.BIcrAppliChg();
		BeanUtils.copyProperties(bIcrAppliChg, bIcrAppliChgDal);
		return bIcrAppliChgDAO.updateByPrimaryKey(bIcrAppliChgDal);
	}

	@Override
	@Transactional
	public int delete(String id) {
		log.info("BicrAppliChgServiceImpl delete  id:"+id);
		return bIcrAppliChgDAO.deleteByPrimaryKey(id);
	}

	@Override
	public Page queryCreditAppliChgByPage(int pageNo, int pageSize, BIcrAppliChg bIcrAppliChg) {
		Page p = new Page(pageSize, pageNo, 0);

		BIcrAppliChgExample example = new BIcrAppliChgExample();
		Criteria cri = example.createCriteria();
		if (bIcrAppliChg != null) {
			if (bIcrAppliChg.getAppno() != null&&bIcrAppliChg.getAppno().length()>0) {
				cri.andAppnoEqualTo(bIcrAppliChg.getAppno());
			}
			if(bIcrAppliChg.getCreditNo()!=null&&bIcrAppliChg.getCreditNo().length()>0){
				cri.andCreditNoEqualTo(bIcrAppliChg.getCreditNo());
			}
		/*	if(bIcrAppliChg.getCreditType()!=null&&bIcrAppliChg.getCreditType().length()>0){
				cri.andCreditTypeEqualTo(bIcrAppliChg.getCreditType());
			}*/

			
		}
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bIcrAppliChgDAO.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}

	@Override
	public BIcrAppliChg queryCreditAppliChgKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
