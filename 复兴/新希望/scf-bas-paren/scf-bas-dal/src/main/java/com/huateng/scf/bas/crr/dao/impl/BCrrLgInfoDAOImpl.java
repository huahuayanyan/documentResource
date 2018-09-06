package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrLgInfoDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLgInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrLgInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrLgInfo数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:32:44
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:32:44	     新增
 *
 * </pre>
 */
@Repository("IBCrrLgInfoDAO")
public class BCrrLgInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrLgInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrLgInfoDAOImpl() {
        super();
    }

    public int countByExample(BCrrLgInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_LG_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrLgInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_LG_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String lgId) {
        BCrrLgInfo _key = new BCrrLgInfo();
        _key.setLgId(lgId);
        int rows = getSqlMapClientTemplate().delete("B_CRR_LG_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrLgInfo record) {
        getSqlMapClientTemplate().insert("B_CRR_LG_INFO.insert", record);
    }

    public void insertSelective(BCrrLgInfo record) {
        getSqlMapClientTemplate().insert("B_CRR_LG_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrLgInfo> selectByExample(BCrrLgInfoExample example) {
        List<BCrrLgInfo> list = getSqlMapClientTemplate().queryForList("B_CRR_LG_INFO.selectByExample", example);
        return list;
    }

    public BCrrLgInfo selectByPrimaryKey(String lgId) {
        BCrrLgInfo _key = new BCrrLgInfo();
        _key.setLgId(lgId);
        BCrrLgInfo record = (BCrrLgInfo) getSqlMapClientTemplate().queryForObject("B_CRR_LG_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrLgInfo record, BCrrLgInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_LG_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrLgInfo record, BCrrLgInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_LG_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrLgInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_LG_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrLgInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_LG_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrLgInfo> selectByPage(BCrrLgInfoExample example, Page page) {
        List<BCrrLgInfo> list = this.searchListPageMyObject("B_CRR_LG_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrLgInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrLgInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}