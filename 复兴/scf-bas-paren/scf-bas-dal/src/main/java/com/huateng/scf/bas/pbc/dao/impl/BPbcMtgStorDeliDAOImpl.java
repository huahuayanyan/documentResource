package com.huateng.scf.bas.pbc.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgStorDeliDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeli;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgStorDeliExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository("BPbcMtgStorDeliDAO")
public class BPbcMtgStorDeliDAOImpl extends IbatisDaoAnnotation4Template implements IBPbcMtgStorDeliDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPbcMtgStorDeliDAOImpl() {
        super();
    }

    public int countByExample(BPbcMtgStorDeliExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PBC_MTG_STOR_DELI.countByExample", example);
        return count;
    }

    public int deleteByExample(BPbcMtgStorDeliExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_STOR_DELI.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPbcMtgStorDeli _key = new BPbcMtgStorDeli();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PBC_MTG_STOR_DELI.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPbcMtgStorDeli record) {
        getSqlMapClientTemplate().insert("B_PBC_MTG_STOR_DELI.insert", record);
    }

    public void insertSelective(BPbcMtgStorDeli record) {
        getSqlMapClientTemplate().insert("B_PBC_MTG_STOR_DELI.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPbcMtgStorDeli> selectByExample(BPbcMtgStorDeliExample example) {
        List<BPbcMtgStorDeli> list = getSqlMapClientTemplate().queryForList("B_PBC_MTG_STOR_DELI.selectByExample", example);
        return list;
    }

    public BPbcMtgStorDeli selectByPrimaryKey(String id) {
        BPbcMtgStorDeli _key = new BPbcMtgStorDeli();
        _key.setId(id);
        BPbcMtgStorDeli record = (BPbcMtgStorDeli) getSqlMapClientTemplate().queryForObject("B_PBC_MTG_STOR_DELI.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPbcMtgStorDeli record, BPbcMtgStorDeliExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_STOR_DELI.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPbcMtgStorDeli record, BPbcMtgStorDeliExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_STOR_DELI.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPbcMtgStorDeli record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_STOR_DELI.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPbcMtgStorDeli record) {
        int rows = getSqlMapClientTemplate().update("B_PBC_MTG_STOR_DELI.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPbcMtgStorDeli> selectByPage(BPbcMtgStorDeliExample example, Page page) {
        List<BPbcMtgStorDeli> list = this.searchListPageMyObject("B_PBC_MTG_STOR_DELI.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPbcMtgStorDeliExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPbcMtgStorDeliExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	/**
	 * 根据appno查询押品申请表信息
	 */
	@Override
	public List<BPbcMtgStorDeli> selectByAppno(String appno) {
		  List<BPbcMtgStorDeli> list = getSqlMapClientTemplate().queryForList("EXT_B_PBC_MTG_STOR_DELI.selectByAppno", appno);
	      return list;
	}
}