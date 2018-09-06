package com.huateng.scf.bas.nte.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.nte.dao.IBNteNoticeMtgDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBill;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BNteNoticeMtgDAO")
public class BNteNoticeMtgDAOImpl extends IbatisDaoAnnotation4Template implements IBNteNoticeMtgDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BNteNoticeMtgDAOImpl() {
        super();
    }

    public int countByExample(BNteNoticeMtgExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_NTE_NOTICE_MTG.countByExample", example);
        return count;
    }

    public int deleteByExample(BNteNoticeMtgExample example) {
        int rows = getSqlMapClientTemplate().delete("B_NTE_NOTICE_MTG.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BNteNoticeMtg _key = new BNteNoticeMtg();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_NTE_NOTICE_MTG.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BNteNoticeMtg record) {
        getSqlMapClientTemplate().insert("B_NTE_NOTICE_MTG.insert", record);
    }

    public void insertSelective(BNteNoticeMtg record) {
        getSqlMapClientTemplate().insert("B_NTE_NOTICE_MTG.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BNteNoticeMtg> selectByExample(BNteNoticeMtgExample example) {
        List<BNteNoticeMtg> list = getSqlMapClientTemplate().queryForList("B_NTE_NOTICE_MTG.selectByExample", example);
        return list;
    }

    public BNteNoticeMtg selectByPrimaryKey(String id) {
        BNteNoticeMtg _key = new BNteNoticeMtg();
        _key.setId(id);
        BNteNoticeMtg record = (BNteNoticeMtg) getSqlMapClientTemplate().queryForObject("B_NTE_NOTICE_MTG.selectByPrimaryKey", _key);
        return record;
    }
    public List<BNteNoticeMtg> selectByPid(String id) {
        BNteNoticeMtg _key = new BNteNoticeMtg();
        _key.setPid(id);
        List<BNteNoticeMtg> list =  getSqlMapClientTemplate().queryForList("B_NTE_NOTICE_MTG.selectByPid", _key);
        return list;
    }
    public int updateByExampleSelective(BNteNoticeMtg record, BNteNoticeMtgExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_MTG.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BNteNoticeMtg record, BNteNoticeMtgExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_MTG.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BNteNoticeMtg record) {
        int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_MTG.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BNteNoticeMtg record) {
        int rows = getSqlMapClientTemplate().update("B_NTE_NOTICE_MTG.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BNteNoticeMtg> selectByPage(BNteNoticeMtgExample example, Page page) {
        List<BNteNoticeMtg> list = this.searchListPageMyObject("B_NTE_NOTICE_MTG.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BNteNoticeMtgExample {
        private Object record;

        public UpdateByExampleParms(Object record, BNteNoticeMtgExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    //ext

	/**
	 * 通过APPNO查找通知书关联押品信息
	 */
	@Override
	public List<BNteNoticeMtg> findBNteNoticeMtgByAppno(String appno) {
		 List<BNteNoticeMtg> list = getSqlMapClientTemplate().queryForList("EXT_B_NTE_NOTICE_MTG.findBNteNoticeMtgByAppno", appno);
	     return list;
	}
}