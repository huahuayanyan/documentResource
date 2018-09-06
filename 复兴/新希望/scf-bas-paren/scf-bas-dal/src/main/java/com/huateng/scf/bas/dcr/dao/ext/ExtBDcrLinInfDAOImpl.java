package com.huateng.scf.bas.dcr.dao.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.dcr.model.BDcrLinInf;

@Repository
public class ExtBDcrLinInfDAOImpl extends IbatisDaoAnnotation4Template implements ExtBDcrLinInfDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;
    

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		// TODO Auto-generated method stub
        return this.template;
	}

	@Override
	public List<BDcrLinInf> selectTreeByRootId(String linId) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("EXT_DCR.selectTreeByRootId",linId);
	}
	
	@Override
	public List   queryCusBDcrLinInf(String custId,String prdId,String linTyp,String stat,Page page) {
		Map   vMap=  new  HashMap();
		vMap.put("prdId", prdId);
		vMap.put("custId", custId);
		vMap.put("linTyp", linTyp);
		vMap.put("stat", stat);
		// TODO Auto-generated method stub
        List list = this.searchListPageMyObject("EXT_DCR.queryCusBDcrLinInf", vMap, page);
        return  list;
	}
	
   
}