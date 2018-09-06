package com.huateng.scf.adv.qry.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.qry.dao.IFourLnciDtlQryDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseVO;

@Repository("fourLnciDtlQryDAO")
public class FourLnciDtlQryDAOImpl extends IbatisDaoAnnotation4Template implements IFourLnciDtlQryDAO {
	@Resource(name="sqlMapClientTemplate")
	
    private IbatisTemplate template;
	
	 public FourLnciDtlQryDAOImpl() {
	        super();
	    }
	 public IbatisTemplate getSqlMapClientTemplate() {
	        return this.template;
	    }

	@Override
	public List<BLanLnciBaseVO> selectByPage(Map<String, Object> param, Page page) {
		@SuppressWarnings("unchecked")
		List<BLanLnciBaseVO> list =  this.searchListPageMyObject("EXT_FOURLNCIDTLQRY.selectFourLnciInfoList",param, page);
        return list;
	}
	@Override
	public Page queryBCntBuyInfoListByPage(String debetNo, Page page) {
		this.searchListPageMyObject("EXT_FOURLNCIDTLQRY.selectContBuyInfoByDebetNo",debetNo, page);
        return page;
	}

}
