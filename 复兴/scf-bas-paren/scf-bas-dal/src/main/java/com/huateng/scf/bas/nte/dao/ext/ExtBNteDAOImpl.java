package com.huateng.scf.bas.nte.dao.ext;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExt;
import com.huateng.scf.sto.nwr.dao.model.SBcpProductBillExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p></p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月20日下午1:21:16
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月20日下午1:21:16	     新增
 *
 * </pre>
 */
@Repository("ExtBNteDAO")
public class ExtBNteDAOImpl extends IbatisDaoAnnotation4Template implements ExtBNteDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public ExtBNteDAOImpl() {
        super();
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
    
    public int countNoticeBaseInfoByNoticeCommonQueryVO(HashMap<String, Object> omap) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EXT_B_NTE_NOTICE_BASE.countNoticeBaseInfoByNoticeCommonQueryVO", omap);
        return count;
    }

    @SuppressWarnings("unchecked")
	public List<BNteNoticeBase> getNoticeBaseInfoByNoticeCommonQueryVO(HashMap<String, Object> omap, Page page) {
    	List<BNteNoticeBase> list = new ArrayList<BNteNoticeBase>();
    	if(page==null)
    	{
    		list = getSqlMapClientTemplate().queryForList("EXT_B_NTE_NOTICE_BASE.getNoticeBaseInfoByNoticeCommonQueryVO", omap);
    	}
    	else
        {
    		list = this.searchListPageMyObject("EXT_B_NTE_NOTICE_BASE.getNoticeBaseInfoByNoticeCommonQueryVO", omap, page);
        }
        return list;
    }

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.nte.dao.ext.ExtBNteDAO#getDeliveryNotifyMortList(java.util.HashMap, com.huateng.base.common.beans.Page)
	 */
    @Override
	public List<BNteNoticeMtgExt> getDeliveryNotifyMortList(HashMap<String, Object> omap, Page page) {
		// TODO Auto-generated method stub
		List<BNteNoticeMtgExt>  list = this.searchListPageMyObject("EXT_B_NTE_NOTICE_MTG.getDeliveryNotifyMortList", omap, page);
		return list;
	}

}