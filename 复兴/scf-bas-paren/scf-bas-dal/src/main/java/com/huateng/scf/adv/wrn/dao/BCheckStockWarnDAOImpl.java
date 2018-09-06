package com.huateng.scf.adv.wrn.dao;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.wrn.dao.model.BWanCheckStock;
import com.huateng.scf.adv.wrn.dao.model.BWanCheckStockVO;

@Repository(IBCheckStockWarnDAO.BeanId)
public class BCheckStockWarnDAOImpl extends IbatisDaoAnnotation4Template implements IBCheckStockWarnDAO {
	
	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;

	@Override
	public List<BWanCheckStockVO> findCheckStockWarnByPage(Map<String, Object> params, Page page) {
		List<BWanCheckStockVO> list =this.searchListPageByMap("EXT_B_WRN_CHECK_STOCK.selectCheckStockWarnByPage", params, page);
		return list;
	}

	@Override
	public Integer findCheckStockWarnCount(Map<String, Object> params) {
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("EXT_B_WRN_CHECK_STOCK.selectCheckStockWarnCount", params);
		return count;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

}
