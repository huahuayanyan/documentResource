package com.huateng.scf.adv.nte.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.nte.dao.IBFourWareAcctConfirmNoticeDAO;
import com.huateng.scf.adv.nte.dao.model.FourWareConfirmNoticeVO;

/**
 * @author htrad0055
 * description:
 * create Date:20170427
 */
/**
 * @author htrad0055
 * 查询收款确认通知书
 */
@Repository(IBFourWareAcctConfirmNoticeDAO.BeanId)
public class BFourWareAcctConfirmNoticeDAOImpl extends IbatisDaoAnnotation4Template implements IBFourWareAcctConfirmNoticeDAO {
	
	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;

	/**
	 * 分页查询收款确认通知书
	 * @param param
	 * @param page
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<FourWareConfirmNoticeVO> findAcctConfirmNoticeByPage(Map<String, Object> param, Page page) {
		List<FourWareConfirmNoticeVO> list =this.searchListPageMyObject("EXT_B_ADV_NTE_NOTICE.selectAcctConfirmNoticeByPage", param, page);
		return list;
	}

	/**
	 * 查询收款确认通知书的数目
	 * @param param
	 * @return
	 */
	@Override
	public Integer findAcctConfirmNoticeCount(Map<String, Object> param) {
		Integer count =(Integer) this.getSqlMapClientTemplate().queryForObject("EXT_B_ADV_NTE_NOTICE.selectAcctConfirmNoticeCount", param);
		return count;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

}
