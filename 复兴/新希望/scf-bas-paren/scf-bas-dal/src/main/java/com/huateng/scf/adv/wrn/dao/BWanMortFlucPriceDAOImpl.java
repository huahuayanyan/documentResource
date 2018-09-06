package com.huateng.scf.adv.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.wrn.dao.IBWanMortFlucPriceDAO;
import com.huateng.scf.adv.wrn.dao.model.BWanMortFlucPrice;
import com.huateng.scf.adv.wrn.dao.model.BWanMortFlucPriceExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BWanMortFlucPriceDAO")
public class BWanMortFlucPriceDAOImpl extends IbatisDaoAnnotation4Template implements IBWanMortFlucPriceDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BWanMortFlucPriceDAOImpl() {
        super();
    }

    public int countByExample(BWanMortFlucPriceExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_WRN_MORT_FLUC_PRICE.countByExample", example);
        return count;
    }

    public int deleteByExample(BWanMortFlucPriceExample example) {
        int rows = getSqlMapClientTemplate().delete("B_WRN_MORT_FLUC_PRICE.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BWanMortFlucPrice _key = new BWanMortFlucPrice();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_WRN_MORT_FLUC_PRICE.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BWanMortFlucPrice record) {
        getSqlMapClientTemplate().insert("B_WRN_MORT_FLUC_PRICE.insert", record);
    }

    public void insertSelective(BWanMortFlucPrice record) {
        getSqlMapClientTemplate().insert("B_WRN_MORT_FLUC_PRICE.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BWanMortFlucPrice> selectByExample(BWanMortFlucPriceExample example) {
        List<BWanMortFlucPrice> list = getSqlMapClientTemplate().queryForList("B_WRN_MORT_FLUC_PRICE.selectByExample", example);
        return list;
    }

    public BWanMortFlucPrice selectByPrimaryKey(String id) {
        BWanMortFlucPrice _key = new BWanMortFlucPrice();
        _key.setId(id);
        BWanMortFlucPrice record = (BWanMortFlucPrice) getSqlMapClientTemplate().queryForObject("B_WRN_MORT_FLUC_PRICE.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BWanMortFlucPrice record, BWanMortFlucPriceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_MORT_FLUC_PRICE.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BWanMortFlucPrice record, BWanMortFlucPriceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_WRN_MORT_FLUC_PRICE.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BWanMortFlucPrice record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_MORT_FLUC_PRICE.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BWanMortFlucPrice record) {
        int rows = getSqlMapClientTemplate().update("B_WRN_MORT_FLUC_PRICE.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BWanMortFlucPrice> selectByPage(BWanMortFlucPriceExample example, Page page) {
        List<BWanMortFlucPrice> list = this.searchListPageMyObject("B_WRN_MORT_FLUC_PRICE.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BWanMortFlucPriceExample {
        private Object record;

        public UpdateByExampleParms(Object record, BWanMortFlucPriceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}