package com.huateng.scf.rec.bcp.dao.ext;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;

@Repository("ExtIRBcpDebtBaseInfoDAO")
public class ExtIRBcpDebtBaseInfoDAOImpl extends IbatisDaoAnnotation4Template implements ExtIRBcpDebtBaseInfoDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;
    

	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		// TODO Auto-generated method stub
        return this.template;
	}

	
	@Override
	public List findCancelRBcpDebtBaseInfoByPage(Map debt, Page page) {
		// TODO Auto-generated method stub
        List list = this.searchListPageMyObject("EXT_R_BCP_DEBT_BASE_INFO.findCancelRBcpDebtBaseInfoPage", debt, page);
		return list;
	}

	/**
	 * 核销申请发票添加查询
	 */
	@Override
	public List getInvoiceChargeOffAddQry(Map map, Page page) {
		// TODO Auto-generated method stub
		 List list = this.searchListPageMyObject("EXT_R_BCP_DEBT_BASE_INFO.getInvoiceChargeOffAddQry", map, page);
		return list;
	}
	
   
}