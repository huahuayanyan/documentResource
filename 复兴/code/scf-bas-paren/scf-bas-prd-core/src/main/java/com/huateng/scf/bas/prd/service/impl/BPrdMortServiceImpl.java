package com.huateng.scf.bas.prd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.prd.dao.IBPrdMortDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdMort;
import com.huateng.scf.bas.prd.dao.model.BPrdMortExample;
import com.huateng.scf.bas.prd.service.IBPrdMortService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>动产产品参数表</p>
 *
 * @author 	huangshuidan
 * @date 	2017年4月20日下午3:07:27
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年4月20日下午3:07:27             新增
 *
 * </pre>
 */
@ScubeService
@Service("BPrdMortServiceImpl")
public class BPrdMortServiceImpl implements IBPrdMortService
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBPrdMortDAO")
	IBPrdMortDAO bprdmortdao;
	
	/**
	 * 返回产品类型为动产动态的小类的组合字符串
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public String getProductDynamic() throws ScubeBizException
	{
		log.debug("======================================");
		BPrdMortExample example = new BPrdMortExample();
		BPrdMortExample.Criteria cri = example.createCriteria();
		cri.andMoniTypeEqualTo(ScfBasConstant.MONI_MODEL_DYNAMIC);
		List<BPrdMort> list = bprdmortdao.selectByExample(example);
		String productId="";
		if(list!=null&&list.size()>0){
			productId=(String)list.get(0).getProductId();
		}
		return productId;
	}
	
	/**
	 * @Description: 返回产品类型为动产静态的小类的组合字符串
	 * @author xu_hong
	 * @return
	 * @throws CommonException
	 */
	@Override
	public String getProductStatic() throws ScubeBizException {
		BPrdMortExample example = new BPrdMortExample();
		BPrdMortExample.Criteria cri = example.createCriteria();
		cri.andMoniTypeEqualTo(ScfBasConstant.MONI_MODEL_STATIC);
		List<BPrdMort> list = bprdmortdao.selectByExample(example);
		String productId = "";
		if(list!=null&&list.size()>0){
			productId=(String)list.get(0).getProductId();
		}
		return productId;
	}
}
