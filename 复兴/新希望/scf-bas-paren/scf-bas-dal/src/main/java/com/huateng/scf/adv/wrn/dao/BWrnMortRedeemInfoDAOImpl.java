package com.huateng.scf.adv.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.wrn.dao.model.BWrnMortRedeemInfo;
import com.huateng.scf.adv.wrn.dao.model.BWrnMortRedeemInfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BWrnMortRedeemInfoDAO")
public class BWrnMortRedeemInfoDAOImpl extends IbatisDaoAnnotation4Template implements IBWrnMortRedeemInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BWrnMortRedeemInfoDAOImpl() {
        super();
    }

    public int countByExample(BWrnMortRedeemInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_WRN_MORT_REDEEM_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(BWrnMortRedeemInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_WRN_MORT_REDEEM_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BWrnMortRedeemInfo _key = new BWrnMortRedeemInfo();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_WRN_MORT_REDEEM_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BWrnMortRedeemInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_MORT_REDEEM_INFO.insert", record);
    }

    public void insertSelective(BWrnMortRedeemInfo record) {
        getSqlMapClientTemplate().insert("B_WRN_MORT_REDEEM_INFO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BWrnMortRedeemInfo> selectByExample(BWrnMortRedeemInfoExample example) {
        List<BWrnMortRedeemInfo> list = getSqlMapClientTemplate().queryForList("B_WRN_MORT_REDEEM_INFO.selectByExample", example);
        return list;
    }

    public BWrnMortRedeemInfo selectByPrimaryKey(String id) {
        BWrnMortRedeemInfo _key = new BWrnMortRedeemInfo();
        _key.setId(id);
        BWrnMortRedeemInfo record = (BWrnMortRedeemInfo) getSqlMapClientTemplate().queryForObject("B_WRN_MORT_REDEEM_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BWrnMortRedeemInfo record, BWrnMortRedeemInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_MORT_REDEEM_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BWrnMortRedeemInfo record, BWrnMortRedeemInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_MORT_REDEEM_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BWrnMortRedeemInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_MORT_REDEEM_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BWrnMortRedeemInfo record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_MORT_REDEEM_INFO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BWrnMortRedeemInfo> selectByPage(BWrnMortRedeemInfoExample example, Page page) {
        List<BWrnMortRedeemInfo> list = this.searchListPageMyObject("B_WRN_MORT_REDEEM_INFO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BWrnMortRedeemInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BWrnMortRedeemInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}