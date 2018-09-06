package com.huateng.scf.bas.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.scf.bas.sys.dao.IBSysLnValDAO;
import com.huateng.scf.bas.sys.model.BSysLnVal;
import com.huateng.scf.bas.sys.service.IBSysLnValService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BSysLnVal接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月12日上午11:19:05
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月12日上午11:19:05	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BSysLnValServiceImpl")
public class BSysLnValServiceImpl implements IBSysLnValService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBSysLnValDAO")
	private IBSysLnValDAO bsyslnvaldao;
	
	@Override
	@Transactional
	public BSysLnVal add(BSysLnVal bSysLnVal) {
		log.debug("开始新增……");
		com.huateng.scf.bas.sys.dao.model.BSysLnVal bSysLnValdal = 
				new com.huateng.scf.bas.sys.dao.model.BSysLnVal();
		try
		{
			BeanUtils.copyProperties(bSysLnVal, bSysLnValdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bsyslnvaldao.insertSelective(bSysLnValdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return bSysLnVal;
	}

	@Override
	@Transactional
	public int update(BSysLnVal bSysLnVal) {
		com.huateng.scf.bas.sys.dao.model.BSysLnVal bSysLnValdal = 
				new com.huateng.scf.bas.sys.dao.model.BSysLnVal();
		try
		{
			BeanUtils.copyProperties(bSysLnVal, bSysLnValdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		int i;
		bSysLnValdal.setId(bSysLnVal.getValId());
		try
		{
			i = bsyslnvaldao.updateByPrimaryKeySelective(bSysLnValdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("更新异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int delete(BSysLnVal bSysLnVal) {
		int row;
		String id = bSysLnVal.getValId();
		try
		{
			row = bsyslnvaldao.deleteByPrimaryKey(id);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("删除异常");
		}
		return row;
	}

	@Override
	@Transactional
	public int batchDelete(List<BSysLnVal> list) {
		int rows = 0;
		if(list.size()>0)
		{
			for(BSysLnVal bSysLnVal:list)
			{
				rows += delete(bSysLnVal);
			}
		}
		return rows;
	}

	/*@Override
	public Page findBSysLnValByPage(int pageNo, int pageSize, BSysLnVal bSysLnVal) {
		int total = bsyslnvaldao.countByExample(new BSysLnValExample());
		Page p = new Page(pageSize, pageNo, total);
		
		BSysLnValExample example = new BSysLnValExample();
		Criteria cri = example.createCriteria();
		
		if(bSysLnVal!=null)
		{
			
		}
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(bsyslnvaldao.selectByExample(example));
		log.info("p.toString()="+p.toString());
		return p;
	}*/

}
