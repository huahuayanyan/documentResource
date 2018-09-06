/**
 * 
 */
package com.huateng.scf.bas.brp.service.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.IBBrpNoticeModelDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpNoticeModelExample;
import com.huateng.scf.bas.brp.dao.model.BBrpNoticeModelExample.Criteria;
import com.huateng.scf.bas.brp.model.BBrpNoticeModel;
import com.huateng.scf.bas.brp.service.IBBrpNoticeModelService;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 费用参数信息服务实现类
 * </p>
 * 
 * @author lihao
 * @date 2016年12月3日上午11:38:57
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月3日上午11:38:57	      新增
 * 
 *            </pre>
 */
@ScubeService
@Service("BBrpNoticeModelServiceImpl")
public class BBrpNoticeModelServiceImpl implements IBBrpNoticeModelService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BBrpNoticeModelDAO")
	IBBrpNoticeModelDAO iBBrpNoticeModelDAO;
	@Resource(name = "userService")
	UserService userService;

	// 费用信息分页条件查询（根据费用代码，费用名称）
	@Override
	public Page findBBrpNoticeModelByPage(int pageNo, int pageSize, BBrpNoticeModel bBrpNoticeModel) {
		Page p = new Page(pageSize, pageNo, 0);
		BBrpNoticeModelExample example = new BBrpNoticeModelExample();
		Criteria cri = example.createCriteria();
		if (bBrpNoticeModel != null) {
			// 对复选框字段进行处理
			// 根据通知书类型
			if (bBrpNoticeModel.getNoticeType() != null && !"".equals(bBrpNoticeModel.getNoticeType())) {
				cri.andNoticeTypeEqualTo(bBrpNoticeModel.getNoticeType());
			}
		}
		try {
			List<com.huateng.scf.bas.brp.dao.model.BBrpNoticeModel> list=iBBrpNoticeModelDAO.selectByPage(example, p);
			// 2.转译页面信息
			List<BBrpNoticeModel> list2 = new ArrayList<BBrpNoticeModel>();
			for ( com.huateng.scf.bas.brp.dao.model.BBrpNoticeModel model: list) {
				// 翻译，创建人tlrcd，最后更新操作员lastUpdTlrcd，经办机构brcode，最后更新经办机构lastUpdBrcode
				UserInfo userInfo1 = new UserInfo();
				BBrpNoticeModel bBrpNoticeModel1=new BBrpNoticeModel();
				BeanUtils.copyProperties(model, bBrpNoticeModel1);
				Date date=model.getUploadTime();
				String uploadDate=new SimpleDateFormat("yyyy-MM-dd").format(date);
				bBrpNoticeModel1.setUploadDate(uploadDate);
				userInfo1.setTlrNo(model.getUploadTlrno());// 搜索创建人对应的名称。
				List<TlrInfoVO> userList = userService.selectByExample(userInfo1);
				if (userList != null && userList.size() == 1) {
					bBrpNoticeModel1.setUploadTlrno(userList.get(0).getTlrName());// 将查询结果赋值于页面创建人代码。
				} else {
					throw new ScubeBizException("操作员号为" + bBrpNoticeModel1.getUploadTlrno() + " 的操作员信息有误！");
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

	@Override
	@Transactional
	public String add(BBrpNoticeModel bBrpNoticeModel) {
		try {
		if (bBrpNoticeModel != null) {
			// lastUpdTlrcd最后更新操作员,lastUpdTime最后更新时间，lastUpdBrcode最后更新机构
			UserInfo user = ContextHolder.getUserInfo();
			String userId = user.getTlrNo();
			bBrpNoticeModel.setUploadTlrno(userId);
			//String form=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
			Timestamp ts=new Timestamp(System.currentTimeMillis());
			bBrpNoticeModel.setUploadTime(ts);// 最后更新时间	
			//bBrpNoticeModel.setId(UUIDGeneratorUtil.generate());// 设置主键
			this.saveorupdate(bBrpNoticeModel);
		}
			return null;
		} catch (Exception e) {
			log.error("通知书上传失败！");
			throw new ScubeBizException("通知书上传失败！", e);
		}

	}

	@Override
	@Transactional
	public String saveorupdate(BBrpNoticeModel bBrpNoticeModel) {
		BBrpNoticeModelExample example = new BBrpNoticeModelExample();
		com.huateng.scf.bas.brp.dao.model.BBrpNoticeModel model=new com.huateng.scf.bas.brp.dao.model.BBrpNoticeModel();
		Criteria cri = example.createCriteria();
		if (bBrpNoticeModel.getNoticeType() != null && !"".equals(bBrpNoticeModel.getNoticeType())) {
			cri.andNoticeTypeEqualTo(bBrpNoticeModel.getNoticeType());
		}
		List noticeList=iBBrpNoticeModelDAO.selectByExample(example);
		if(noticeList!=null&&noticeList.size()>0){//已存在相同通知书类型的通知书则更新
			model=(com.huateng.scf.bas.brp.dao.model.BBrpNoticeModel)noticeList.get(0);	
		    String id=model.getId();
		    BeanUtils.copyProperties(bBrpNoticeModel, model);
		    model.setId(id);
		    iBBrpNoticeModelDAO.updateByPrimaryKey(model);
		}else{//新增通知书
		    BeanUtils.copyProperties(bBrpNoticeModel, model);
		    model.setId(UUIDGeneratorUtil.generate());// 设置主键
			iBBrpNoticeModelDAO.insert(model);
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	@Transactional
	public int delete(String id) {
		try {
			return iBBrpNoticeModelDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("通知书删除失败！");
			throw new ScubeBizException("通知书删除失败！", e);
		}
	}

	@Override
	public BBrpNoticeModel selectById(String id) {
		BBrpNoticeModel bBrpNoticeModel=new BBrpNoticeModel();
		if(id!=null&&!"".equals(id)){
			com.huateng.scf.bas.brp.dao.model.BBrpNoticeModel model=iBBrpNoticeModelDAO.selectByPrimaryKey(id);
			if(model!=null){
				BeanUtils.copyProperties(model, bBrpNoticeModel);
			}
		}
		// TODO Auto-generated method stub
		return bBrpNoticeModel;
	}
	@Override
	public BBrpNoticeModel selectByNoticeType(String noticeType) {
		BBrpNoticeModel bBrpNoticeModel=new BBrpNoticeModel();
		if(noticeType!=null&&!"".equals(noticeType)){
			com.huateng.scf.bas.brp.dao.model.BBrpNoticeModel model=iBBrpNoticeModelDAO.selectByNoticeType(noticeType);
			if(model!=null){
				BeanUtils.copyProperties(model, bBrpNoticeModel);
			}
		}
		// TODO Auto-generated method stub
		return bBrpNoticeModel;
	}
}
