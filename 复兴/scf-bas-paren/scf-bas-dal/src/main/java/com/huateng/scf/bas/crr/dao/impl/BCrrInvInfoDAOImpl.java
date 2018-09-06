package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrInvInfoDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrInvInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrInvInfoExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrInvInfo数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:32:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:32:31	     新增
 *
 * </pre>
 */
@Repository("IBCrrInvInfoDAO")
public class BCrrInvInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrInvInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrInvInfoDAOImpl() {
        super();
    }

    public int countByExample(BCrrInvInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_INV_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrInvInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_INV_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String invId) {
        BCrrInvInfo _key = new BCrrInvInfo();
        _key.setInvId(invId);
        int rows = getSqlMapClientTemplate().delete("B_CRR_INV_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrInvInfo record) {
        getSqlMapClientTemplate().insert("B_CRR_INV_INFO.insert", record);
    }

    public void insertSelective(BCrrInvInfo record) {
        getSqlMapClientTemplate().insert("B_CRR_INV_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrInvInfo> selectByExample(BCrrInvInfoExample example) {
        List<BCrrInvInfo> list = getSqlMapClientTemplate().queryForList("B_CRR_INV_INFO.selectByExample", example);
        return list;
    }

    public BCrrInvInfo selectByPrimaryKey(String invId) {
        BCrrInvInfo _key = new BCrrInvInfo();
        _key.setInvId(invId);
        BCrrInvInfo record = (BCrrInvInfo) getSqlMapClientTemplate().queryForObject("B_CRR_INV_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrInvInfo record, BCrrInvInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_INV_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrInvInfo record, BCrrInvInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_INV_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrInvInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_INV_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrInvInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_INV_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrInvInfo> selectByPage(BCrrInvInfoExample example, Page page) {
        List<BCrrInvInfo> list = this.searchListPageMyObject("B_CRR_INV_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrInvInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrInvInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<BCrrInvInfo> selectByExtId(String extId) {
    	BCrrInvInfo _key = new BCrrInvInfo();
        _key.setExtId(extId);
        List<BCrrInvInfo> list = getSqlMapClientTemplate().queryForList("B_CRR_INV_INFO.selectByExtId", _key);
        return list;
    }

    @Override
    public int deleteByExtId(String extId) {
    	BCrrInvInfo _key = new BCrrInvInfo();
        _key.setExtId(extId);
        int rows = getSqlMapClientTemplate().delete("B_CRR_INV_INFO.deleteByExtId", _key);
        return rows;
    }
}