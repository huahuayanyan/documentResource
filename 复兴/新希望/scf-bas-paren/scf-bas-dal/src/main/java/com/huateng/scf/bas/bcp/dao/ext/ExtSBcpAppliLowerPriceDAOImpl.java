package com.huateng.scf.bas.bcp.dao.ext;

import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPrice;
import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPriceExample;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
/**
 * 
 * <p>SBcpAppliLowerPrice数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月27日下午3:05:35
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月27日下午3:05:35	     新增
 *
 * </pre>
 */
@Repository("ExtSBcpAppliLowerPriceDAO")
public class ExtSBcpAppliLowerPriceDAOImpl extends IbatisDaoAnnotation4Template implements ExtSBcpAppliLowerPriceDAO {
    @Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;

    public ExtSBcpAppliLowerPriceDAOImpl() {
        super();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<SBcpAppliLowerPrice> queryLowerPrice(HashMap<String, String> omap) {
    	List<SBcpAppliLowerPrice> list = getSqlMapClientTemplate().queryForList("DMP_EXT.queryLowerPrice", omap);
        return list;
    }
    
	@SuppressWarnings("rawtypes")
	@Override
    public List queryMtgTotalPrice(HashMap<String, String> omap)
    {
		List price = getSqlMapClientTemplate().queryForList("DMP_EXT.queryMtgTotalPrice", omap);
        return price;
    }

    public IbatisTemplate getSqlMapClientTemplate() {
        return this.template;
    }

    protected static class UpdateByExampleParms extends SBcpAppliLowerPriceExample {
        private Object record;

        public UpdateByExampleParms(Object record, SBcpAppliLowerPriceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<SBcpAppliLowerPrice> selectByAppno(String appno) {
        SBcpAppliLowerPrice _key = new SBcpAppliLowerPrice();
        _key.setAppno(appno);
        List<SBcpAppliLowerPrice> record = getSqlMapClientTemplate().queryForList("DMP_EXT.selectByAppno", _key);
        return record;
    }
}