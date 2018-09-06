package com.huateng.scf.bas.fin.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.fin.dao.IBFinCnfgDefDAO;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgDef;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgDefExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BFinCnfgDef数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月5日下午5:23:21
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月5日下午5:23:21	     新增
 *
 * </pre>
 */
@Repository("IBFinCnfgDefDAO")
public class BFinCnfgDefDAOImpl extends IbatisDaoAnnotation4Template implements IBFinCnfgDefDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BFinCnfgDefDAOImpl() {
        super();
    }

    public int countByExample(BFinCnfgDefExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_FIN_CNFG_DEF.countByExample", example);
        return count;
    }

    public int deleteByExample(BFinCnfgDefExample example) {
        int rows = getSqlMapClientTemplate().delete("B_FIN_CNFG_DEF.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String serialno) {
        BFinCnfgDef _key = new BFinCnfgDef();
        _key.setSerialno(serialno);
        int rows = getSqlMapClientTemplate().delete("B_FIN_CNFG_DEF.deleteByPrimaryKey", _key);
        return rows;
    }
    
    public String insert(BFinCnfgDef record) {
    	Object newKey = getSqlMapClientTemplate().insert("B_FIN_CNFG_DEF.insert", record);
    	return (String)newKey;
    }

    public String insertSelective(BFinCnfgDef record) {
    	Object newKey = getSqlMapClientTemplate().insert("B_FIN_CNFG_DEF.insertSelective", record);
    	return (String)newKey;
    }

    @SuppressWarnings("unchecked")
    public List<BFinCnfgDef> selectByExample(BFinCnfgDefExample example) {
        List<BFinCnfgDef> list = getSqlMapClientTemplate().queryForList("B_FIN_CNFG_DEF.selectByExample", example);
        return list;
    }

    public BFinCnfgDef selectByPrimaryKey(String serialno) {
        BFinCnfgDef _key = new BFinCnfgDef();
        _key.setSerialno(serialno);
        BFinCnfgDef record = (BFinCnfgDef) getSqlMapClientTemplate().queryForObject("B_FIN_CNFG_DEF.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BFinCnfgDef record, BFinCnfgDefExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CNFG_DEF.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BFinCnfgDef record, BFinCnfgDefExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CNFG_DEF.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BFinCnfgDef record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CNFG_DEF.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BFinCnfgDef record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CNFG_DEF.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BFinCnfgDef> selectByPage(BFinCnfgDefExample example, Page page) {
        List<BFinCnfgDef> list = this.searchListPageMyObject("B_FIN_CNFG_DEF.selectByExample", example, page);
        return list;
    }
    
    @SuppressWarnings("unchecked")
	public List<BFinCnfgDef> selectByFinId(BFinCnfgDef bFinCnfgDef, Page page) 
    {
    	List<BFinCnfgDef> list = this.searchListPageMyObject("B_FIN_CNFG_DEF.selectByFinId", bFinCnfgDef, page);
        return list;
    }
    
    @SuppressWarnings("unchecked")
	public List<BFinCnfgDef> selectByFinId(BFinCnfgDef bFinCnfgDef)
    {
    	List<BFinCnfgDef> list = getSqlMapClientTemplate().queryForList("B_FIN_CNFG_DEF.selectByFinId", bFinCnfgDef);
        return list;
    }
    
    @SuppressWarnings("unchecked")
	public List<BFinCnfgDef> selectByMdlId(String mdlId)
    {
    	BFinCnfgDef _key = new BFinCnfgDef();
        _key.setMdlId(mdlId);
    	List<BFinCnfgDef> list = getSqlMapClientTemplate().queryForList("B_FIN_CNFG_DEF.selectByMdlId", _key);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BFinCnfgDefExample {
        private Object record;

        public UpdateByExampleParms(Object record, BFinCnfgDefExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@Override
	public BFinCnfgDef selectBySubjIdAndmdlId(BFinCnfgDef bFinCnfgDef) {
        BFinCnfgDef record = (BFinCnfgDef) getSqlMapClientTemplate().queryForObject("B_FIN_CNFG_DEF.selectBySubjIdAndmdlId", bFinCnfgDef);
        return record;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.fin.dao.IBFinCnfgDefDAO#selectBySubjIdAndmdlIdList(com.huateng.scf.bas.fin.dao.model.BFinCnfgDef)
	 */
	@Override
	public List<BFinCnfgDef> selectBySubjIdAndmdlIdList(BFinCnfgDef bFinCnfgDef) {
		List<BFinCnfgDef> bFinCnfgDefList = getSqlMapClientTemplate().queryForList("B_FIN_CNFG_DEF.selectBySubjIdAndmdlId", bFinCnfgDef);
		return bFinCnfgDefList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BFinCnfgDef> selectBySubjId(String subjId) {
		BFinCnfgDef bFinCnfgDef = new BFinCnfgDef();
		bFinCnfgDef.setSubjId(subjId);
		List<BFinCnfgDef> record = getSqlMapClientTemplate().queryForList("B_FIN_CNFG_DEF.selectBySubjId", bFinCnfgDef);
        return record;
	}
	
    @Override
    public int deleteByMdlId(String mdlId) {
    	BFinCnfgDef _key = new BFinCnfgDef();
        _key.setMdlId(mdlId);
        int rows = getSqlMapClientTemplate().delete("B_FIN_CNFG_DEF.deleteByMdlId", _key);
        return rows;
    }
    
}