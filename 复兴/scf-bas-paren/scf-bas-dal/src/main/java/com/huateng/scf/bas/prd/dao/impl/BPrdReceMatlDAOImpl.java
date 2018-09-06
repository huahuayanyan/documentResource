package com.huateng.scf.bas.prd.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.prd.dao.IBPrdReceMatlDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdReceMatl;
import com.huateng.scf.bas.prd.dao.model.BPrdReceMatlExample;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BPrdReceMatlDAO")
public class BPrdReceMatlDAOImpl extends IbatisDaoAnnotation4Template implements IBPrdReceMatlDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BPrdReceMatlDAOImpl() {
        super();
    }

    public int countByExample(BPrdReceMatlExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_PRD_RECE_MATL.countByExample", example);
        return count;
    }

    public int deleteByExample(BPrdReceMatlExample example) {
        int rows = getSqlMapClientTemplate().delete("B_PRD_RECE_MATL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BPrdReceMatl _key = new BPrdReceMatl();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_PRD_RECE_MATL.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BPrdReceMatl record) {
        getSqlMapClientTemplate().insert("B_PRD_RECE_MATL.insert", record);
    }

    public void insertSelective(BPrdReceMatl record) {
        getSqlMapClientTemplate().insert("B_PRD_RECE_MATL.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BPrdReceMatl> selectByExample(BPrdReceMatlExample example) {
        List<BPrdReceMatl> list = getSqlMapClientTemplate().queryForList("B_PRD_RECE_MATL.selectByExample", example);
        return list;
    }

    public BPrdReceMatl selectByPrimaryKey(String id) {
        BPrdReceMatl _key = new BPrdReceMatl();
        _key.setId(id);
        BPrdReceMatl record = (BPrdReceMatl) getSqlMapClientTemplate().queryForObject("B_PRD_RECE_MATL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BPrdReceMatl record, BPrdReceMatlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_RECE_MATL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BPrdReceMatl record, BPrdReceMatlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_PRD_RECE_MATL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BPrdReceMatl record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_RECE_MATL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BPrdReceMatl record) {
        int rows = getSqlMapClientTemplate().update("B_PRD_RECE_MATL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BPrdReceMatl> selectByPage(BPrdReceMatlExample example, Page page) {
        List<BPrdReceMatl> list = this.searchListPageMyObject("B_PRD_RECE_MATL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BPrdReceMatlExample {
        private Object record;

        public UpdateByExampleParms(Object record, BPrdReceMatlExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

    //批量查询
	 @Override
	 @SuppressWarnings("unchecked")
	public List<BPrdReceMatl> selectByIdList(List<String> idList) {
		 List<BPrdReceMatl> list =new ArrayList<BPrdReceMatl>();
		 if(idList!=null&&idList.size()>0)
		 list = getSqlMapClientTemplate().queryForList("B_PRD_RECE_MATL.SelectByIdList",idList );
	      return list;
	}
}