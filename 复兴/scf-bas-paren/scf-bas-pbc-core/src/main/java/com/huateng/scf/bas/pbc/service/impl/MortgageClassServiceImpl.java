package com.huateng.scf.bas.pbc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.TreeModel;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgClassDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClassExample;
import com.huateng.scf.bas.pbc.dao.model.ExtBPbcMtgClass;
import com.huateng.scf.bas.pbc.model.BPbcMtgClassVO;
import com.huateng.scf.bas.pbc.service.IMortgageClassService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>押品目录管理接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月23日下午5:34:54
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月23日下午5:34:54	     新增
 *
 * </pre>
 */

@ScubeService
@Service("MortgageClassServiceImpl")
public class MortgageClassServiceImpl implements IMortgageClassService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ScubeUserService scubeUserService;
	
	@Resource(name = "BPbcMtgClassDAO")
	IBPbcMtgClassDAO bpbcmtgclassdao;
	
	@Override
	public List<TreeModel> MortgageClassTreeGetter(HashMap<String, String> value) throws ScubeBizException
	{
		log.debug("获取押品目录信息==================");
		List<TreeModel> list = new ArrayList<TreeModel>();
		BPbcMtgClassExample example = new BPbcMtgClassExample();
		BPbcMtgClassExample.Criteria cri = example.createCriteria();
		cri.andLevelsNotEqualTo("3");
		//为防止误删数据，这里定义status状态值，当status=1时有效，当status=0时无效，此处只搜索有效数据
		cri.andStatusEqualTo("1");
		//TODO 老代码中此处需查询brcode信息值，且该值为当前客户机构,在本处不需该条件
//		String brcode = ContextHolder.getOrgInfo().getBrNo();
//		BctlVO bctlVO = scubeUserService.selectBctlByBrNo(brcode, ScfCommonUtil.getBrManagerNo(scubeUserService));
//		String topBrcode = bctlVO.getBrUpNo();
//		cri.andBrcodeEqualTo(topBrcode);
		
//		String id = value.get("id");
//		if("0".equals(id))
//		{
//			cri.andMortgageCodeNotEqualTo(new BigDecimal(0));
//		}
//		else
//		{
//			cri.andParentCodeEqualTo(new BigDecimal(id));
//		}
		example.setOrderByClause("PARENT_CODE,MORTGAGE_CODE");
		
		List<BPbcMtgClass> listclass = bpbcmtgclassdao.selectByExample(example);
		if(listclass.size()>0)
		{
			for(BPbcMtgClass bPbcMtgClass:listclass)
			{
				TreeModel treeModel1 = new TreeModel();
				//当首节点为0时，由于首节点的等级不得为0，因此将所有数据项的等级在原基础上加1
				String level = bPbcMtgClass.getLevels();
				int newLevel = Integer.valueOf(level)+1;
				//当首节点为0，上级目录为空，则设置原始上级目录为0，其它所有数据项上级目录均加1
				BigDecimal parentCode = bPbcMtgClass.getParentCode();
				BigDecimal mortgageCode = bPbcMtgClass.getMortgageCode();
				BigDecimal newParentCode;
				//由于所有数据上级目录加1，所以其节点值均需加1，包括首节点为0的数据
				BigDecimal newMortgageCode = mortgageCode.add(new BigDecimal(1));
				if(StringUtil.isEmpty(parentCode))
				{
					newParentCode = new BigDecimal(0);
				}
				else
				{
					newParentCode = parentCode.add(new BigDecimal(1));
				}
				treeModel1.setTreeId(newMortgageCode.toString());
				treeModel1.setTreeLevel(String.valueOf(newLevel));
				treeModel1.setTreeName(bPbcMtgClass.getMortgageName());
				treeModel1.setTreeParentId(newParentCode.toString());
				list.add(treeModel1);
			}
		}
		return list;
	}
	
	@Override
	public Page MortgageClassPageGetter(int pageNo, int pageSize,BPbcMtgClassVO bPbcMtgClass)
	{
		BPbcMtgClassExample example = new BPbcMtgClassExample();
		BPbcMtgClassExample.Criteria cri = example.createCriteria();
		if(!StringUtil.isEmpty(bPbcMtgClass.getParentCode()))
		{
			BigDecimal parentCode = bPbcMtgClass.getParentCode();
			int newCode = Integer.valueOf(parentCode.toString()) - 1;
			parentCode = new BigDecimal(newCode);
			cri.andParentCodeEqualTo(parentCode);
		}
		else
		{
			cri.andLevelsEqualTo("1");
		}
		if(!StringUtil.isEmpty(bPbcMtgClass.getMortgageName()))
		{
			cri.andMortgageNameLike("%"+bPbcMtgClass.getMortgageName()+"%");
		}
		//为防止误删数据，这里定义status状态值，当status=1时有效，当status=0时无效，此处只搜索有效数据
		cri.andStatusEqualTo("1");
		example.setOrderByClause("MORTGAGE_CODE");
		
		int total = bpbcmtgclassdao.countByExample(example);
		Page page = new Page(pageSize, pageNo, total);
		
		List<BPbcMtgClass> list = bpbcmtgclassdao.selectByPage(example, page);
		List<ExtBPbcMtgClass> result = new ArrayList<ExtBPbcMtgClass>();
		if(list.size()>0)
		{
			for(BPbcMtgClass mtgClass:list)
			{
				ExtBPbcMtgClass extMtgClass = new ExtBPbcMtgClass();
				BeanUtils.copyProperties(mtgClass, extMtgClass);
				String brname = "";
				if(!StringUtil.isEmpty(extMtgClass.getBrcode()))
				{
					BctlVO bctlVO = scubeUserService.selectBctlByBrNo(extMtgClass.getBrcode(), ScfCommonUtil.getBrManagerNo(scubeUserService));
					if(null!=bctlVO)
					{
						brname = bctlVO.getBrName();
					}
				}
				extMtgClass.setBrname(brname);
				result.add(extMtgClass);
			}
		}
		
		page.setRecords(result);
		page.setTotalRecord(total);
		
		return page;
	}
	
	@Override
	public int updateMtgClass(BPbcMtgClassVO mtgClassVO)
	{
		int i = 0;
		BPbcMtgClass record = new BPbcMtgClass();
		try
		{
			BeanUtils.copyProperties(mtgClassVO, record);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			i = bpbcmtgclassdao.updateByPrimaryKeySelective(record);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("更新押品信息异常");
		}
		return i;
	}
	
	/**
	 * 防止数据误删，此处删除功能将对应status赋值0，表示无效数据不显示
	 */
	@Override
	public int deleteMtgClass(List<BPbcMtgClassVO> list)
	{
		int i = 0;
		BPbcMtgClass record = null;
		BPbcMtgClassExample example = null;
		if(list.size()>0)
		{
			for(BPbcMtgClassVO mtgClassVO:list)
			{
				record = new BPbcMtgClass();
				BeanUtils.copyProperties(mtgClassVO, record);
				example = new BPbcMtgClassExample();
				BPbcMtgClassExample.Criteria cri = example.createCriteria();
				if(mtgClassVO.getLevels().equals("1"))
				{
					cri.andParentCodeEqualTo(mtgClassVO.getMortgageCode());
					//获取一级目录的下级目录——二级目录
					List<BPbcMtgClass> listLevel2 = bpbcmtgclassdao.selectByExample(example);
					if(listLevel2.size()>0)
					{
						for(BPbcMtgClass bPbcMtgClass2:listLevel2)
						{
							BPbcMtgClass record2 = new BPbcMtgClass();
							BeanUtils.copyProperties(bPbcMtgClass2, record2);
							BPbcMtgClassExample example2 = new BPbcMtgClassExample();
							BPbcMtgClassExample.Criteria cri2 = example2.createCriteria();
							cri2.andParentCodeEqualTo(bPbcMtgClass2.getMortgageCode());
							//获取二级目录的下级目录——三级目录
							List<BPbcMtgClass> listLevel3 = bpbcmtgclassdao.selectByExample(example2);
							if(listLevel3.size()>0)
							{
								for(BPbcMtgClass bPbcMtgClass3:listLevel3)
								{
									BPbcMtgClass record3 = new BPbcMtgClass();
									BeanUtils.copyProperties(bPbcMtgClass3, record3);
									record3.setStatus("0");
									i += bpbcmtgclassdao.updateByPrimaryKeySelective(record3);
								}
							}
							record2.setStatus("0");
							i += bpbcmtgclassdao.updateByPrimaryKeySelective(record2);
						}
					}
				}
				if(mtgClassVO.getLevels().equals("2"))
				{
					cri.andParentCodeEqualTo(mtgClassVO.getMortgageCode());
					List<BPbcMtgClass> listLevel3 = bpbcmtgclassdao.selectByExample(example);
					if(listLevel3.size()>0)
					{
						for(BPbcMtgClass bPbcMtgClass:listLevel3)
						{
							BPbcMtgClass record3 = new BPbcMtgClass();
							BeanUtils.copyProperties(bPbcMtgClass, record3);
							record3.setStatus("0");
							i += bpbcmtgclassdao.updateByPrimaryKeySelective(record3);
						}
					}
				}
				record.setStatus("0");
				i += bpbcmtgclassdao.updateByPrimaryKeySelective(record);
			}
		}
		return i;
	}
}
