package com.huateng.scf.bas.nte.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBaseExample;
import com.huateng.scf.bas.nte.dao.model.NoticeQryVO;

public interface IBNteNoticeBaseDAO {
	int countByExample(BNteNoticeBaseExample example);

	int deleteByExample(BNteNoticeBaseExample example);

	int deleteByPrimaryKey(String id);

	void insert(BNteNoticeBase record);

	void insertSelective(BNteNoticeBase record);

	List<BNteNoticeBase> selectByExample(BNteNoticeBaseExample example);

	BNteNoticeBase selectByPrimaryKey(String id);

	int updateByExampleSelective(BNteNoticeBase record, BNteNoticeBaseExample example);

	int updateByExample(BNteNoticeBase record, BNteNoticeBaseExample example);

	int updateByPrimaryKeySelective(BNteNoticeBase record);

	int updateByPrimaryKey(BNteNoticeBase record);

	List<BNteNoticeBase> selectByPage(BNteNoticeBaseExample example, Page page);

	// 预付类 发货通知管理首页查询发货通知信息
	List<NoticeQryVO> getAdvDeliveryNotifyByParam(Map map, Page page);

	// 预付类 发货通知管理-收款确认通知查询
	List<NoticeQryVO> getAdvDeliveryNotifyConfirmByParam(Map map, Page page);

	// 通知书查询
	List<NoticeQryVO> selectNoticePageByParamForPage(Map map, Page page);

	// ext
	/**
	 * 通过APPNO和NOTICETYPE查找通知书
	 * 
	 * @param bNteNoticeBase
	 * @return
	 */
	List<BNteNoticeBase> findBNteNoticeBaseByAppno(BNteNoticeBase bNteNoticeBase);

	/**
	 * 根据appno删除对应的通知书
	 * 
	 * @param appno
	 * @return
	 */
	int deleteBNteNoticeBaseByAppno(String appno);

	List<BNteNoticeBase> selectByCondition(BNteNoticeBase bNteNoticeBase);

	List<BNteNoticeBase> queryNteBaseInfo(Map map, Page page);
}