package com.huateng.scf.sto.nwr.dao.ext;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormal;
import com.huateng.scf.sto.nwr.dao.model.SBcpProductBill;
import com.huateng.scf.sto.nwr.dao.model.SBcpProductBillExample;
import com.huateng.scf.sto.nwr.dao.vo.SBcpBillNormalAppVO;
import com.huateng.scf.sto.nwr.dao.vo.SBcpBillNormalInOutDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>SBcpProductBill仓单产品参数扩展表 数据库访问层通用接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月12日下午3:59:12
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月12日下午3:59:12	     新增
 *
 * </pre>
 */
@Repository("ExtSBcpNwrDAO")
public class ExtSBcpNwrDAOImpl extends IbatisDaoAnnotation4Template implements ExtSBcpNwrDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public ExtSBcpNwrDAOImpl() {
        super();
    }

    public int countSBcpMortBill(HashMap<String, Object> omap) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_S_BCP_NWR.countSBcpMortBill", omap);
        return count;
    }

    @SuppressWarnings({ "rawtypes" })
    public List selectSBcpMortBill(HashMap<String, Object> omap, Page page) {
        List list = this.searchListPageMyObject("EXT_S_BCP_NWR.selectSBcpMortBill", omap, page);
        return list;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends SBcpProductBillExample {
        private Object record;

        public UpdateByExampleParms(Object record, SBcpProductBillExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

    /**
     * 根据仓单类型获取仓单小类
     */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public List getBillByMidProductId(String billType) {
		SBcpProductBill vo = new SBcpProductBill();
		vo.setBillType(billType);
		List list = getSqlMapClientTemplate().queryForList("EXT_S_BCP_NWR.getBillByMidProductId", vo);
		return list;
	}

	@Override
	public int countAppContInfoBySupplyChainPdId(HashMap<String, Object> omap) {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_S_BCP_NWR.countAppContInfoBySupplyChainPdId", omap);
        return count;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAppContInfoBySupplyChainPdId(HashMap<String, Object> omap, Page page) {
		List list = this.searchListPageMyObject("EXT_S_BCP_NWR.getAppContInfoBySupplyChainPdId", omap, page);
        return list;
	}

	@Override
	public int countEffectNormalList(HashMap<String, Object> omap) {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_S_BCP_NWR.countEffectNormalList", omap);
        return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SBcpMortBillNormal> getEffectNormalList(HashMap<String, Object> omap, Page page) {
		List<SBcpMortBillNormal> list = this.searchListPageMyObject("EXT_S_BCP_NWR.getEffectNormalList", omap, page);
        return list;
	}
	
	@Override
	public int countBillnormalListByAppno(HashMap<String, Object> omap) {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_S_BCP_NWR.countBillnormalListByAppno", omap);
        return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SBcpBillNormalAppVO> getBillnormalListByAppno(HashMap<String, Object> omap, Page page, boolean flag) {
		List<SBcpBillNormalAppVO> list = new ArrayList<SBcpBillNormalAppVO>();
		if(flag)
		{
			list = this.searchListPageMyObject("EXT_S_BCP_NWR.getBillnormalListByAppno", omap, page);
		}
		else
		{
			list = getSqlMapClientTemplate().queryForList("EXT_S_BCP_NWR.getBillnormalListByAppno", omap);
		}
        return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SBcpMortBillNormal> getBillExchangeEnteringListByParam(HashMap<String, Object> omap, boolean flag, Page page) {
		List<SBcpMortBillNormal> list = new ArrayList<SBcpMortBillNormal>();
		if(flag)
		{
			list = this.searchListPageMyObject("EXT_S_BCP_NWR.getBillExchangeEnteringListByParam", omap, page);
		}
		else
		{
			list = getSqlMapClientTemplate().queryForList("EXT_S_BCP_NWR.getBillExchangeEnteringListByParam", omap);
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getBillNormalAppByAppno(HashMap<String, Object> omap) {
		List list = getSqlMapClientTemplate().queryForList("EXT_S_BCP_NWR.getBillNormalAppByAppno", omap);
        return list;
	}

	@Override
	public int countBillnormalListBySlaveContno(HashMap<String, Object> omap) {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_S_BCP_NWR.countBillnormalListBySlaveContno", omap);
        return count;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getBillnormalListBySlaveContno(HashMap<String, Object> omap, Page page) {
		List list = this.searchListPageMyObject("EXT_S_BCP_NWR.getBillnormalListBySlaveContno", omap, page);
		return list;
	}

	@Override
	public int countBillNormalDeliverableList(HashMap<String, Object> omap) {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_S_BCP_NWR.countBillNormalDeliverableList", omap);
        return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SBcpMortBillNormal> getBillNormalDeliverableList(HashMap<String, Object> omap, Page page) {
		List<SBcpMortBillNormal> list = this.searchListPageMyObject("EXT_S_BCP_NWR.getBillNormalDeliverableList", omap, page);
		return list;
	}

	@Override
	public int countBillExchangeEnteringListByParam(HashMap<String, Object> omap) {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_S_BCP_NWR.countBillExchangeEnteringListByParam", omap);
        return count;
	}

	@Override
	public int countAppliBillnormalList(HashMap<String, Object> omap) {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_S_BCP_NWR.countAppliBillnormalList", omap);
        return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SBcpBillNormalAppVO> getAppliBillnormalList(HashMap<String, Object> omap, Page page, boolean flag) {
		List<SBcpBillNormalAppVO> list = new ArrayList<SBcpBillNormalAppVO>();
		if(flag)
		{
			list = this.searchListPageMyObject("EXT_S_BCP_NWR.getAppliBillnormalList", omap, page);
		}
		else
		{
			list = getSqlMapClientTemplate().queryForList("EXT_S_BCP_NWR.getAppliBillnormalList", omap);
		}
        return list;
	}

	@Override
	public int countNormalBillByPara(HashMap<String, Object> omap) {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_S_BCP_NWR.countNormalBillByPara", omap);
        return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SBcpBillNormalInOutDO> getNormalBillByPara(HashMap<String, Object> omap, Page page) {
		List<SBcpBillNormalInOutDO> list = this.searchListPageMyObject("EXT_S_BCP_NWR.getNormalBillByPara", omap, page);
		return list;
	}
}