package com.huateng.scf.rec.bcp.dao.ext;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtl;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussDtlExample;

@Repository("ExtBcpAppliBussDtlDAO")
public class ExtBcpAppliBussDtlDAOImpl extends IbatisDaoAnnotation4Template implements ExtBcpAppliBussDtlDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;
    

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		// TODO Auto-generated method stub
        return this.template;
	}


	@Override
	public List<RBcpAppliBussDtl> selectByExample(RBcpAppliBussDtlExample example) {
		// TODO Auto-generated method stub
        List<RBcpAppliBussDtl> list = getSqlMapClientTemplate().queryForList("EXT_BCP_APPLI_BUSS_DTL.selectByExample", example);
		return list;
	}

}