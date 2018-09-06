package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrGntyInfoDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyInfoExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrGntyInfo数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月24日下午3:42:55
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月24日下午3:42:55	     新增
 *
 * </pre>
 */
@Repository("IBCrrGntyInfoDAO")
public class BCrrGntyInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrGntyInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrGntyInfoDAOImpl() {
        super();
    }

    public int countByExample(BCrrGntyInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_GNTY_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrGntyInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_GNTY_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String gntyId) {
        BCrrGntyInfo _key = new BCrrGntyInfo();
        _key.setGntyId(gntyId);
        int rows = getSqlMapClientTemplate().delete("B_CRR_GNTY_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrGntyInfo record) {
        getSqlMapClientTemplate().insert("B_CRR_GNTY_INFO.insert", record);
    }

    public void insertSelective(BCrrGntyInfo record) {
        getSqlMapClientTemplate().insert("B_CRR_GNTY_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrGntyInfo> selectByExample(BCrrGntyInfoExample example) {
        List<BCrrGntyInfo> list = getSqlMapClientTemplate().queryForList("B_CRR_GNTY_INFO.selectByExample", example);
        return list;
    }

    public BCrrGntyInfo selectByPrimaryKey(String gntyId) {
        BCrrGntyInfo _key = new BCrrGntyInfo();
        _key.setGntyId(gntyId);
        BCrrGntyInfo record = (BCrrGntyInfo) getSqlMapClientTemplate().queryForObject("B_CRR_GNTY_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrGntyInfo record, BCrrGntyInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrGntyInfo record, BCrrGntyInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrGntyInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrGntyInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_GNTY_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrGntyInfo> selectByPage(BCrrGntyInfoExample example, Page page) {
        List<BCrrGntyInfo> list = this.searchListPageMyObject("B_CRR_GNTY_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrGntyInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrGntyInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}