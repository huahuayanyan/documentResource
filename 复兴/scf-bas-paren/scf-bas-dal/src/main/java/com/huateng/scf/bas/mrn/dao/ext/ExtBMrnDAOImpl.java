package com.huateng.scf.bas.mrn.dao.ext;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.lan.dao.vo.BLanLnciBaseAcctVo;
import com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfoExample;
import com.huateng.scf.bas.mrn.dao.model.BMrnBussInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>BMrnAppliAcctInfo数据库访问层通用接口类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月13日上午9:52:25
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月13日上午9:52:25	     新增
 *
 * </pre>
 */
@Repository("ExtBMrnDAO")
public class ExtBMrnDAOImpl extends IbatisDaoAnnotation4Template implements ExtBMrnDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public ExtBMrnDAOImpl() {
        super();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<BMrnAppliAcctInfo> queryMrnAppli(HashMap<String, String> omap, Page page) {
        List<BMrnAppliAcctInfo> list = this.searchListPageMyObject("EXT_B_MRN.queryMrnAppli", omap, page);
        return list;
    }

    @Override
    public int countMrnAppli(HashMap<String, String> omap)
    {
    	Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_MRN.countMrnAppli", omap);
        return count;
    }
    
    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends BMrnAppliAcctInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, BMrnAppliAcctInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
	public List<BMrnAcctBussInfo> getTblCustAccountBussInfoByParam(HashMap<String, Object> omap,Page page)
    {
    	List<BMrnAcctBussInfo> list = this.searchListPageMyObject("EXT_B_MRN.getTblCustAccountBussInfoByParam", omap, page);
        return list;
    }
    
    /**
     *  保证金转入信息列表查询
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<RBcpAppliBussInfo> getBailTransferQuery(HashMap<String, Object> omap, Page page) {
		List<RBcpAppliBussInfo> list = this.searchListPageMyObject("EXT_R_BCP.getBailTransferQuery", omap, page);
        return list;
	}
	/**
	 *  保证金转入信息列表个数查询
	 */
	@Override
    public int countBailTransferQuery(HashMap<String, Object> omap) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_R_BCP.countBailTransferQuery", omap);
        return count;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<BMrnAcctBussInfo> queryAcctBussInfoList(HashMap<String, Object> omap) {
		List<BMrnAcctBussInfo> list = getSqlMapClientTemplate().queryForList("EXT_B_MRN.queryAcctBussInfoList", omap);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BMrnAcctBussInfo> getBillCustAccountInfoByParam(HashMap<String, Object> omap, Page page) {
		List<BMrnAcctBussInfo> list = this.searchListPageMyObject("EXT_B_MRN.getBillCustAccountInfoByParam", omap, page);
        return list;
	}	 
	
	@Override
    public int countBillCustAccountInfoByParam(HashMap<String, Object> omap) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_MRN.countBillCustAccountInfoByParam", omap);
        return count;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BMrnBussInfo> getBailTransferSerialQuery(HashMap<String, Object> omap, Page page) {
		List<BMrnBussInfo> list = this.searchListPageMyObject("EXT_B_MRN.getBailTransferSerialQuery", omap, page);
        return list;
	}	 
	
	@Override
    public int countBailTransferSerialQuery(HashMap<String, Object> omap) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_MRN.countBailTransferSerialQuery", omap);
        return count;
    }

	@Override
	public int countAddBailAmountListByAppno(HashMap<String, Object> omap) {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_MRN.countAddBailAmountListByAppno", omap);
        return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BLanLnciBaseAcctVo> getAddBailAmountListByAppno(HashMap<String, Object> omap, Page page) {
		List<BLanLnciBaseAcctVo> list = this.searchListPageMyObject("EXT_B_MRN.getAddBailAmountListByAppno", omap, page);
        return list;
	}

	@Override
	public int countWareMnAddByPara(HashMap<String, Object> omap) {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_PBC_APPLI_BASE_INFO.countWareMnAddByPara", omap);
        return count;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getWareMnAddByPara(HashMap<String, Object> omap, Page page) {
		List list = this.searchListPageMyObject("EXT_B_PBC_APPLI_BASE_INFO.getWareMnAddByPara", omap, page);
        return list;
	}
}