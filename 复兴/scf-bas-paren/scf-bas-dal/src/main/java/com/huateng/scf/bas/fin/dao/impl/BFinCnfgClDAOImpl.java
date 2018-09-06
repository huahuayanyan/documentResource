package com.huateng.scf.bas.fin.dao.impl;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.fin.dao.IBFinCnfgClDAO;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgCl;
import com.huateng.scf.bas.fin.dao.model.BFinCnfgClExample;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BFinCnfgCl数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月5日下午5:24:28
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月5日下午5:24:28	     新增
 *
 * </pre>
 */
@Repository("IBFinCnfgClDAO")
public class BFinCnfgClDAOImpl extends IbatisDaoAnnotation4Template implements IBFinCnfgClDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BFinCnfgClDAOImpl() {
        super();
    }

    public int countByExample(BFinCnfgClExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_FIN_CNFG_CL.countByExample", example);
        return count;
    }

    public int deleteByExample(BFinCnfgClExample example) {
        int rows = getSqlMapClientTemplate().delete("B_FIN_CNFG_CL.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String mdlId) {
        BFinCnfgCl _key = new BFinCnfgCl();
        _key.setMdlId(mdlId);
        int rows = getSqlMapClientTemplate().delete("B_FIN_CNFG_CL.deleteByPrimaryKey", _key);
        return rows;
    }

    public String insert(BFinCnfgCl record) {
    	Object newKey = getSqlMapClientTemplate().insert("B_FIN_CNFG_CL.insert", record);
    	return (String) newKey;
    }

    public String insertSelective(BFinCnfgCl record) {
    	Object newKey = getSqlMapClientTemplate().insert("B_FIN_CNFG_CL.insertSelective", record);
    	return (String) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<BFinCnfgCl> selectByExample(BFinCnfgClExample example) {
        List<BFinCnfgCl> list = getSqlMapClientTemplate().queryForList("B_FIN_CNFG_CL.selectByExample", example);
        return list;
    }

    public BFinCnfgCl selectByPrimaryKey(String mdlId) {
        BFinCnfgCl _key = new BFinCnfgCl();
        _key.setMdlId(mdlId);
        BFinCnfgCl record = (BFinCnfgCl) getSqlMapClientTemplate().queryForObject("B_FIN_CNFG_CL.selectByPrimaryKey", _key);
        return record;
    }
    
    @Override
    public BFinCnfgCl selectByMdlNm(String mdlNm) {
        BFinCnfgCl _key = new BFinCnfgCl();
        _key.setMdlNm(mdlNm);;
        BFinCnfgCl record = (BFinCnfgCl) getSqlMapClientTemplate().queryForObject("B_FIN_CNFG_CL.selectByMdlNm", _key);
        return record;
    }

    @SuppressWarnings("unchecked")
	public List<BFinCnfgCl> selectByMldCl(BFinCnfgCl record) {
        List<BFinCnfgCl> list = getSqlMapClientTemplate().queryForList("B_FIN_CNFG_CL.selectByMldClAndCustId", record);
        return list;
    }
    
    @SuppressWarnings("unchecked")
	public List<BFinCnfgCl> selectByMldCl(String mdlCl) {
    	BFinCnfgCl fincl = new BFinCnfgCl();
    	fincl.setMdlCl(mdlCl);
        List<BFinCnfgCl> list = getSqlMapClientTemplate().queryForList("B_FIN_CNFG_CL.selectByMldCl", fincl);
        return list;
    }
    
    public int updateByExampleSelective(BFinCnfgCl record, BFinCnfgClExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CNFG_CL.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BFinCnfgCl record, BFinCnfgClExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_FIN_CNFG_CL.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BFinCnfgCl record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CNFG_CL.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BFinCnfgCl record) {
        int rows = getSqlMapClientTemplate().update("B_FIN_CNFG_CL.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BFinCnfgCl> selectByPage(BFinCnfgClExample example, Page page) {
        List<BFinCnfgCl> list = this.searchListPageMyObject("B_FIN_CNFG_CL.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BFinCnfgClExample {
        private Object record;

        public UpdateByExampleParms(Object record, BFinCnfgClExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
	public List<BFinCnfgCl> selectByMdl(BFinCnfgCl bFinCnfgCl) {
    	List<BFinCnfgCl> record =  getSqlMapClientTemplate().queryForList("B_FIN_CNFG_CL.selectByMdl", bFinCnfgCl);
        return record;
	}
    
    @SuppressWarnings("unchecked")
    @Override
	public List<BFinCnfgCl> selectByMdlTyp(BFinCnfgCl bFinCnfgCl) {
    	List<BFinCnfgCl> record =  getSqlMapClientTemplate().queryForList("B_FIN_CNFG_CL.selectByMdlTyp", bFinCnfgCl);
        return record;
	}
    
	@SuppressWarnings("unchecked")
	@Override
	public List<BFinCnfgCl> selectByMdlTypById(BFinCnfgCl bFinCnfgCl) {
    	List<BFinCnfgCl> record =  getSqlMapClientTemplate().queryForList("B_FIN_CNFG_CL.selectByMdlTypById", bFinCnfgCl);
        return record;
	}
}