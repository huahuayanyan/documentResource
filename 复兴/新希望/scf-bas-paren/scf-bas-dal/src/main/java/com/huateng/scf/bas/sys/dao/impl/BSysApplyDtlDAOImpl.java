package com.huateng.scf.bas.sys.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.IBSysApplyDtlDAO;
import com.huateng.scf.bas.sys.dao.model.BSysApplyDtl;
import com.huateng.scf.bas.sys.dao.model.BSysApplyDtlExample;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BSysApplyDtlDAO")
public class BSysApplyDtlDAOImpl extends IbatisDaoAnnotation4Template implements IBSysApplyDtlDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BSysApplyDtlDAOImpl() {
        super();
    }

    public int countByExample(BSysApplyDtlExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_APPLY_DTL.countByExample", example);
        return count;
    }

    public int deleteByExample(BSysApplyDtlExample example) {
        int rows = getSqlMapClientTemplate().delete("B_SYS_APPLY_DTL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        BSysApplyDtl _key = new BSysApplyDtl();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("B_SYS_APPLY_DTL.deleteByPrimaryKey", _key);
        return rows;
    }

    public String insert(BSysApplyDtl record) {
        Object newKey = getSqlMapClientTemplate().insert("B_SYS_APPLY_DTL.insert", record);
        return (String) newKey;
    }

    public String insertSelective(BSysApplyDtl record) {
    	Object newKey = getSqlMapClientTemplate().insert("B_SYS_APPLY_DTL.insertSelective", record);
        return (String) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<BSysApplyDtl> selectByExample(BSysApplyDtlExample example) {
        List<BSysApplyDtl> list = getSqlMapClientTemplate().queryForList("B_SYS_APPLY_DTL.selectByExample", example);
        return list;
    }

    public BSysApplyDtl selectByPrimaryKey(String id) {
        BSysApplyDtl _key = new BSysApplyDtl();
        _key.setId(id);
        BSysApplyDtl record = (BSysApplyDtl) getSqlMapClientTemplate().queryForObject("B_SYS_APPLY_DTL.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BSysApplyDtl record, BSysApplyDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_APPLY_DTL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BSysApplyDtl record, BSysApplyDtlExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_APPLY_DTL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BSysApplyDtl record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_APPLY_DTL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BSysApplyDtl record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_APPLY_DTL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BSysApplyDtl> selectByPage(BSysApplyDtlExample example, Page page) {
        List<BSysApplyDtl> list = this.searchListPageMyObject("B_SYS_APPLY_DTL.selectByExample", example, page);
        return list;
    }
    
    

    /* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.dao.IBSysApplyDtlDAO#queryBsysApplyDtlList(com.huateng.base.common.beans.Page, java.util.Map, boolean)
	 */
	@Override
	public Page queryBsysApplyDtlList(Page page, Map map, boolean isBypPage) {
		if(isBypPage){
			//分页查询
//			int totalCount=(Integer)this.getSqlMapClientTemplate().queryForObject("B_SYS_APPLY_DTL.queryBsysApplyDtlListCount", map);
			Page scfPage = new Page(page.getPageSize(), page.getPageNo(), 0);
			List<BSysApplyDtl> bSysApplyDtlList=this.searchListPageMyObject("B_SYS_APPLY_DTL.queryBsysApplyDtlList", map, scfPage);
			scfPage.setRecords(bSysApplyDtlList);
			return scfPage;
		}else{
			//不分页查询
			Page scfPage=new Page();
			List<BSysApplyDtl> bSysApplyDtlList=getSqlMapClientTemplate().queryForList("B_SYS_APPLY_DTL.queryBsysApplyDtlList", map);
			scfPage.setRecords(bSysApplyDtlList);
			return scfPage;
		}
		
	}

	public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BSysApplyDtlExample {
        private Object record;

        public UpdateByExampleParms(Object record, BSysApplyDtlExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}