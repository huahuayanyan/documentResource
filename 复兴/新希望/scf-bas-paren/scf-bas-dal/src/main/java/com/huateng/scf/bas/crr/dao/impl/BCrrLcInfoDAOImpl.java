package com.huateng.scf.bas.crr.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.crr.dao.IBCrrLcInfoDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLcInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrLcInfoExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BCrrLcInfo数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:32:38
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:32:38	     新增
 *
 * </pre>
 */
@Repository("IBCrrLcInfoDAO")
public class BCrrLcInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBCrrLcInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BCrrLcInfoDAOImpl() {
        super();
    }

    public int countByExample(BCrrLcInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_CRR_LC_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BCrrLcInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_CRR_LC_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String lcId) {
        BCrrLcInfo _key = new BCrrLcInfo();
        _key.setLcId(lcId);
        int rows = getSqlMapClientTemplate().delete("B_CRR_LC_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BCrrLcInfo record) {
        getSqlMapClientTemplate().insert("B_CRR_LC_INFO.insert", record);
    }

    public void insertSelective(BCrrLcInfo record) {
        getSqlMapClientTemplate().insert("B_CRR_LC_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BCrrLcInfo> selectByExample(BCrrLcInfoExample example) {
        List<BCrrLcInfo> list = getSqlMapClientTemplate().queryForList("B_CRR_LC_INFO.selectByExample", example);
        return list;
    }

    public BCrrLcInfo selectByPrimaryKey(String lcId) {
        BCrrLcInfo _key = new BCrrLcInfo();
        _key.setLcId(lcId);
        BCrrLcInfo record = (BCrrLcInfo) getSqlMapClientTemplate().queryForObject("B_CRR_LC_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BCrrLcInfo record, BCrrLcInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_LC_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BCrrLcInfo record, BCrrLcInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_CRR_LC_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BCrrLcInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_LC_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BCrrLcInfo record) {
        int rows = getSqlMapClientTemplate().update("B_CRR_LC_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BCrrLcInfo> selectByPage(BCrrLcInfoExample example, Page page) {
        List<BCrrLcInfo> list = this.searchListPageMyObject("B_CRR_LC_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BCrrLcInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BCrrLcInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}