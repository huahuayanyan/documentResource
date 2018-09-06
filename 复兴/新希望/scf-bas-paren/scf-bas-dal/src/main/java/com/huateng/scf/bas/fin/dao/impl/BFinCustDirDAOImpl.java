package com.huateng.scf.bas.fin.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.fin.dao.IBFinCustDirDAO;
import com.huateng.scf.bas.fin.dao.model.BFinCust;
import com.huateng.scf.bas.fin.dao.model.BFinCustDir;
import com.huateng.scf.bas.fin.dao.model.BFinCustDirExample;
import com.huateng.scf.bas.fin.dao.model.BFinCustDs;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BFinCustDir数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月5日下午5:25:55
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月5日下午5:25:55	     新增
 *
 * </pre>
 */
@Repository("IBFinCustDirDAO")
public class BFinCustDirDAOImpl extends IbatisDaoAnnotation4Template implements IBFinCustDirDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BFinCustDirDAOImpl() {
        super();
    }

    public int countByExample(BFinCustDirExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_FIN_CUST_DIR.countByExample", example);
        return count;
    }

    public int deleteByExample(BFinCustDirExample example) {
        int rows = getSqlMapClientTemplate().delete("B_FIN_CUST_DIR.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String finDirId) {
        BFinCustDir _key = new BFinCustDir();
        _key.setFinDirId(finDirId);
        int rows = getSqlMapClientTemplate().delete("B_FIN_CUST_DIR.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BFinCustDir record) {
        getSqlMapClientTemplate().insert("B_FIN_CUST_DIR.insert", record);
    }

    public void insertSelective(BFinCustDir record) {
        getSqlMapClientTemplate().insert("B_FIN_CUST_DIR.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BFinCustDir> selectByExample(BFinCustDirExample example) {
        List<BFinCustDir> list = getSqlMapClientTemplate().queryForList("B_FIN_CUST_DIR.selectByExample", example);
        return list;
    }

    public BFinCustDir selectByPrimaryKey(String finDirId) {
        BFinCustDir _key = new BFinCustDir();
        _key.setFinDirId(finDirId);
        BFinCustDir record = (BFinCustDir) getSqlMapClientTemplate().queryForObject("B_FIN_CUST_DIR.selectByPrimaryKey", _key);
        return record;
    }
    
    @SuppressWarnings("unchecked")
	public List<BFinCustDir> selectByFinId(String finId) {
        BFinCustDir _key = new BFinCustDir();
        _key.setFinId(finId);
        List<BFinCustDir> record = getSqlMapClientTemplate().queryForList("B_FIN_CUST_DIR.selectByFinId", _key);
        return record;
    }

    public int updateByExampleSelective(BFinCustDir record, BFinCustDirExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST_DIR.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BFinCustDir record, BFinCustDirExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST_DIR.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BFinCustDir record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST_DIR.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BFinCustDir record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CUST_DIR.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BFinCustDir> selectByPage(BFinCustDirExample example, Page page) {
        List<BFinCustDir> list = this.searchListPageMyObject("B_FIN_CUST_DIR.selectByExample", example, page);
        return list;
    }
    
    public String selectByFinDt(String finDt) {
    	BFinCust _key = new BFinCust();
        _key.setFinId(finDt);
        BFinCust record = (BFinCust) getSqlMapClientTemplate().queryForObject("B_FIN_CUST.selectByFinDt", _key);
        String finId = record.getFinId();
        System.out.println(finId);
        return finId;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BFinCustDirExample {
        private Object record;

        public UpdateByExampleParms(Object record, BFinCustDirExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<BFinCustDir> selectByMdlId(String mdlId) {
		BFinCustDir _key = new BFinCustDir();
        _key.setMdlId(mdlId);
        List<BFinCustDir> record = getSqlMapClientTemplate().queryForList("B_FIN_CUST_DIR.selectByMdlId", _key);
        return record;
	}
	
	/**
     * 根据finId删除财报客户目录信息
     * @param finId
     * @return
     */
    @Override
    public int deleteByFinId(String finId)
    {
    	int rows = 0;
    	BFinCustDir _key = new BFinCustDir();
		_key.setFinId(finId);
		rows += getSqlMapClientTemplate().delete("B_FIN_CUST_DIR.deleteByFinId", _key);
        return rows;
    }
    

}