package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.sys.dao.model.BSysSerialNo;
import com.huateng.scf.bas.sys.dao.model.BSysSerialNoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("BSysSerialNoDAO")
public class BSysSerialNoDAOImpl extends IbatisDaoAnnotation4Template implements IBSysSerialNoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public BSysSerialNoDAOImpl() {
        super();
    }

    public int countByExample(BSysSerialNoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("B_SYS_SERIAL_NO.countByExample", example);
        return count;
    }

    public int deleteByExample(BSysSerialNoExample example) {
        int rows = getSqlMapClientTemplate().delete("B_SYS_SERIAL_NO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String serialCode) {
        BSysSerialNo _key = new BSysSerialNo();
        _key.setSerialCode(serialCode);
        int rows = getSqlMapClientTemplate().delete("B_SYS_SERIAL_NO.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(BSysSerialNo record) {
        getSqlMapClientTemplate().insert("B_SYS_SERIAL_NO.insert", record);
    }

    public void insertSelective(BSysSerialNo record) {
        getSqlMapClientTemplate().insert("B_SYS_SERIAL_NO.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<BSysSerialNo> selectByExample(BSysSerialNoExample example) {
        List<BSysSerialNo> list = getSqlMapClientTemplate().queryForList("B_SYS_SERIAL_NO.selectByExample", example);
        return list;
    }

    public BSysSerialNo selectByPrimaryKey(String serialCode) {
        BSysSerialNo _key = new BSysSerialNo();
        _key.setSerialCode(serialCode);
        BSysSerialNo record = (BSysSerialNo) getSqlMapClientTemplate().queryForObject("B_SYS_SERIAL_NO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(BSysSerialNo record, BSysSerialNoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_SERIAL_NO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(BSysSerialNo record, BSysSerialNoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("B_SYS_SERIAL_NO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(BSysSerialNo record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_SERIAL_NO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(BSysSerialNo record) {
        int rows = getSqlMapClientTemplate().update("B_SYS_SERIAL_NO.updateByPrimaryKey", record);
        return rows;
    }

    @SuppressWarnings("unchecked")
    public List<BSysSerialNo> selectByPage(BSysSerialNoExample example, Page page) {
        List<BSysSerialNo> list = this.searchListPageMyObject("B_SYS_SERIAL_NO.selectByExample", example, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BSysSerialNoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BSysSerialNoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.dao.BSysSerialNoDAO#queryBSysSerialNoBySerialCode(com.huateng.scf.bas.sys.dao.model.BSysSerialNo)
	 */
	@Override
	public String queryBSysSerialNoBySerialCode(BSysSerialNo bSysSerialNo) {
		String resultSerial = (String)  getSqlMapClientTemplate().queryForObject("B_SYS_SERIAL_NO.queryBSysSerialNoBySerialCode", bSysSerialNo);
		return resultSerial;
	}
    
}