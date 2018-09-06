package com.huateng.scf.bas.fin.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.fin.dao.IBFinCustDsDAO;
import com.huateng.scf.bas.fin.dao.model.BFinCustDs;
import com.huateng.scf.bas.fin.dao.model.BFinCustDsExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BFinCustDs数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月5日下午5:26:15
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月5日下午5:26:15	     新增
 *
 * </pre>
 */
@Repository("IBFinCustDsDAO")
public class BFinCustDsDAOImpl extends IbatisDaoAnnotation4Template implements IBFinCustDsDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BFinCustDsDAOImpl() {
        super();
    }

    public int countByExample(BFinCustDsExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_FIN_CUST_DS.countByExample", example);
        return count;
    }

    public int deleteByExample(BFinCustDsExample example) {
        int rows = getSqlMapClientTemplate().delete("B_FIN_CUST_DS.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String serialno) {
        BFinCustDs _key = new BFinCustDs();
        _key.setSerialno(serialno);
        int rows = getSqlMapClientTemplate().delete("B_FIN_CUST_DS.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BFinCustDs record) {
        getSqlMapClientTemplate().insert("B_FIN_CUST_DS.insert", record);
    }

    public void insertSelective(BFinCustDs record) {
        getSqlMapClientTemplate().insert("B_FIN_CUST_DS.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BFinCustDs> selectByExample(BFinCustDsExample example) {
        List<BFinCustDs> list = getSqlMapClientTemplate().queryForList("B_FIN_CUST_DS.selectByExample", example);
        return list;
    }

    @SuppressWarnings("unchecked")
	public List<BFinCustDs> selectByFinDirId(String finDirId) {
        BFinCustDs _key = new BFinCustDs();
        _key.setFinDirId(finDirId);
        List<BFinCustDs> record = getSqlMapClientTemplate().queryForList("B_FIN_CUST_DS.selectByFinDirId", _key);
        return record;
    }

    public int updateByExampleSelective(BFinCustDs record, BFinCustDsExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST_DS.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BFinCustDs record, BFinCustDsExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST_DS.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BFinCustDs record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST_DS.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BFinCustDs record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST_DS.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BFinCustDs> selectByPage(BFinCustDsExample example, Page page) {
        List<BFinCustDs> list = this.searchListPageMyObject("B_FIN_CUST_DS.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BFinCustDsExample {
        private Object record;

        public UpdateByExampleParms(Object record, BFinCustDsExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    @SuppressWarnings("unchecked")
	public List<BFinCustDs> selectByFinId(BFinCustDs bFinCustDs)
    {
    	List<BFinCustDs> list = getSqlMapClientTemplate().queryForList("B_FIN_CUST_DS.selectByFinId", bFinCustDs);
        return list;
    }
    @SuppressWarnings("unchecked")
	public List<BFinCustDs> selectIsDs(BFinCustDs bFinCustDs)
    {
    	List<BFinCustDs> list = getSqlMapClientTemplate().queryForList("B_FIN_CUST_DS.selectIsDs", bFinCustDs);
        return list;
    }
    
    /* (non-Javadoc)
	 * @see com.huateng.scf.bas.fin.dao.IBFinCustDsDAO#queryBfinCustDsByFdIRpSource(com.huateng.scf.bas.fin.dao.model.BFinCustDs)
	 */
	@Override
	public List<BFinCustDs> queryBfinCustDsByFdIRpSource(BFinCustDs bFinCustDs) {
		List<BFinCustDs> list = getSqlMapClientTemplate().queryForList("B_FIN_CUST_DS.queryBfinCustDsByFdIRpSource", bFinCustDs);
        return list;
	}
	

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.fin.dao.IBFinCustDsDAO#queryAnalyData(com.huateng.scf.bas.fin.dao.model.BFinCustDs)
	 */
	@Override
	public List<BFinCustDs> queryAnalyData(BFinCustDs bFinCustDs) {
		List<BFinCustDs> list = getSqlMapClientTemplate().queryForList("B_FIN_CUST_DS.queryAnalyData", bFinCustDs);
        return list;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.fin.dao.IBFinCustDsDAO#queryAnalyData(com.huateng.scf.bas.fin.dao.model.BFinCustDs)
	 */
	@Override
	public List<BFinCustDs> queryFinTargetAnalyData(BFinCustDs bFinCustDs) {
		List<BFinCustDs> list = getSqlMapClientTemplate().queryForList("B_FIN_CUST_DS.queryFinTargetAnalyData", bFinCustDs);
        return list;
	}

	/**
     * 根据finId删除客户财报数据信息
     * @param finId
     * @return
     */
    @Override
    public int deleteByFinId(String finId)
    {
    	int rows = 0;
    	BFinCustDs _key = new BFinCustDs();
        _key.setFinId(finId);
    	rows += getSqlMapClientTemplate().delete("B_FIN_CUST_DS.deleteByFinId", _key);
        return rows;
    }
    
    @SuppressWarnings("unchecked")
	public List<BFinCustDs> queryFinCustDsByFinId(String finId)
    {
    	List<BFinCustDs> list = getSqlMapClientTemplate().queryForList("B_FIN_CUST_DS.queryFinCustDsByFinId", finId);
        return list;
    }
}