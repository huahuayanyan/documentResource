package com.huateng.scf.sto.wrn.dao.ext;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.wrn.dao.model.DownLowPriceNewVO;

/**
 * @author htrad0055
 *	跌破最低控货价值预警
 */
@Repository(IBDownLowPriceDAO.BeanId)
public class BDownLowPriceDAOImpl extends IbatisDaoAnnotation4Template implements IBDownLowPriceDAO {
	
	@Resource(name ="sqlMapClientTemplate")
	private IbatisTemplate tempalte;

	/**
	 * 
	 *	分页查询跌破最低控货价值预警的列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DownLowPriceNewVO> selectDownLowPriceNewByPage(Map<String, Object> params, Page page) {
		List<DownLowPriceNewVO> list =this.searchListPageMyObject("EXT_B_WRN_DROP_CTL.selectDownLowPriceNew", params, page);
		return list;
	}

	/**
	 * 
	 *	查询跌破最低控货价值预警的条目数
	 */
	@Override
	public Integer countDownLowPriceNew(Map<String, Object> params) {
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("EXT_B_WRN_DROP_CTL.countDownLowPriceNew", params);
		return count;
	}

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return tempalte;
	}

}
