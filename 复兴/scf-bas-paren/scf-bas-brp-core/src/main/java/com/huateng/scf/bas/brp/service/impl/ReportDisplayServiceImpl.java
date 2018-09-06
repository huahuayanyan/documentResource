/**
 * 
 */
package com.huateng.scf.bas.brp.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.IBBrpNoticeModelDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpNoticeModelExample;
import com.huateng.scf.bas.brp.dao.model.BBrpNoticeModelExample.Criteria;
import com.huateng.scf.bas.brp.model.BBrpNoticeModel;
import com.huateng.scf.bas.brp.model.TreeModel;
import com.huateng.scf.bas.brp.service.IReportDisplayService;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crm.service.IBCrmEntInfoService;
import com.huateng.scf.bas.crm.service.IBCrmUpanddownRelService;
import com.huateng.scf.ods.dao.IOCrmInfoAnalysisDAO;
import com.huateng.scf.ods.dao.IOCrmTagDAO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年5月9日下午2:15:58
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年5月9日下午2:15:58              新增
 *
 * </pre>
 */
@ScubeService
@Service("ReportDisplayServiceImpl")
public class ReportDisplayServiceImpl implements IReportDisplayService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BBrpNoticeModelDAO")
	IBBrpNoticeModelDAO bBrpNoticeModelDAO;
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;
	
	@Resource(name = "BCrmEntInfoServiceImpl") //公司信息
	IBCrmEntInfoService bCrmEntInfoService;
	
	@Resource(name = "IBCrmUpanddownRelServiceImpl") //公司信息
	IBCrmUpanddownRelService bCrmUpanddownRelServie;
	@Resource(name = "OCrmTagDAO") //客户标签
	IOCrmTagDAO oCrmTagDAO;
	@Resource(name = "OCrmInfoAnalysisDAO") //客户标签
	IOCrmInfoAnalysisDAO oCrmInfoAnalysisDAO;
	

	@Autowired
	ScubeUserService scubeUserService;
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.brp.service.IReportDisplayService#ReportDisplayTreeGetter(java.util.HashMap)
	 */
	@Override
	public List<TreeModel> ReportDisplayTreeGetter(HashMap<String, String> value) throws ScubeBizException {
		// TODO Auto-generated method stub
		log.debug("获取报表的展现信息==================");
		List<TreeModel> list = new ArrayList<TreeModel>();
		BBrpNoticeModelExample example = new BBrpNoticeModelExample();
		Criteria cri = example.createCriteria();
		// TODO 暂用通知书模板这块保存报表的模板
		//cri.andNoticeTypeEqualTo("1000");//
		cri.andNoticeTypeBetween("1000", "1025");
		example.setOrderByClause("id");

		List<com.huateng.scf.bas.brp.dao.model.BBrpNoticeModel> listR = bBrpNoticeModelDAO.selectByExample(example);
		TreeModel first = new TreeModel();
		// 首节点
		first.setTreeId("1000");
		first.setTreeLevel("1");
		first.setTreeName("报表统计");
		first.setTreeParentId("0");
		if (listR != null && listR.size() > 0) {
			list.add(first);
			for (com.huateng.scf.bas.brp.dao.model.BBrpNoticeModel bBrpNoticeModel : listR) {
				TreeModel treeModel1 = new TreeModel();

				treeModel1.setTreeId(bBrpNoticeModel.getId());
				treeModel1.setTreeLevel("2");
				treeModel1.setTreeName(bBrpNoticeModel.getFileName());
				treeModel1.setTreeParentId("1000");
				list.add(treeModel1);
			}
		}
		return list;
	}
	
	@Override
	public Page findBBrpNoticeModelByPage(int pageNo, int pageSize, BBrpNoticeModel bBrpNoticeModel) {
		Page p = new Page(pageSize, pageNo, 0);
		BBrpNoticeModelExample example = new BBrpNoticeModelExample();
		Criteria cri = example.createCriteria();
		if (bBrpNoticeModel != null) {
			// 对复选框字段进行处理
			if(StringUtil.isStrNotEmpty(bBrpNoticeModel.getFileName())){
				cri.andFileNameLike("%"+bBrpNoticeModel.getFileName()+"%");
			}
			
		}
		// 报表类型 暂存于通知书模板中 类型为1000以上的
		cri.andNoticeTypeBetween("1000", "1025");
		try {
			List<com.huateng.scf.bas.brp.dao.model.BBrpNoticeModel> list=bBrpNoticeModelDAO.selectByPage(example, p);
			// 2.转译页面信息
			List<BBrpNoticeModel> list2 = new ArrayList<BBrpNoticeModel>();
			for ( com.huateng.scf.bas.brp.dao.model.BBrpNoticeModel model: list) {
				// 翻译，创建人tlrcd
				BBrpNoticeModel bBrpNoticeModel1=new BBrpNoticeModel();
				BeanUtils.copyProperties(model, bBrpNoticeModel1);
				Date date=model.getUploadTime();
				String uploadDate=new SimpleDateFormat("yyyy-MM-dd").format(date);
				bBrpNoticeModel1.setUploadDate(uploadDate);
				if (StringUtil.isStrNotEmpty(model.getUploadTlrno())) {
					UserInfo userInfo = scubeUserService.selectUserByTlrNo(model.getUploadTlrno(), ScfCommonUtil.getBrManagerNo(scubeUserService));
					if (userInfo != null) {
						bBrpNoticeModel1.setUploadTlrno(userInfo.getTlrName());
					}
				}
				
				list2.add(bBrpNoticeModel1);
			}
			p.setRecords(list2);
			return p;
		} catch (Exception e) {
			log.error("通知书信息分页条件查询失败！");
			throw new ScubeBizException("通知书信息分页条件查询失败！", e);
		}
	}
}
