package com.huateng.scf.adv.wrn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.RespectBinding;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.wrn.dao.IBThreeCheckStockWarnDAO;
import com.huateng.scf.adv.wrn.dao.model.ThreeCheckStockWarnVO;
import com.huateng.scf.adv.wrn.dao.model.WarnQryVO;

/**
 * @author htrad0055
 *  发货对账不平预警
 */
@Repository(IBThreeCheckStockWarnDAO.BEAN_ID)
public class BThreeCheckStockWarnDAOImpl extends IbatisDaoAnnotation4Template implements IBThreeCheckStockWarnDAO {
	
	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return template;
	}

	/**
	 * 
	 *  查询发货对账不平预警列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page getCheckStockWarnInfo(WarnQryVO warnQryVO, Page page) {
		List<ThreeCheckStockWarnVO> list =this.searchListPageMyObject("EXT_B_WRN_MORT_CHECK.selectCheckStockWarnInfo", warnQryVO, page);

		Integer totalRecord = (Integer) this.getSqlMapClientTemplate().queryForObject("EXT_B_WRN_MORT_CHECK.countCheckStockWarnInfo", warnQryVO);
		Page pageResult = new Page();
		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		pageResult.setRecords(list);
		pageResult.setTotalRecord(totalRecord);
		return pageResult;
		
	}

}
