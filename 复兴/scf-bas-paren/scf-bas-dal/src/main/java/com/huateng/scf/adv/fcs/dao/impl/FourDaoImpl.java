/**
 * 
 */
package com.huateng.scf.adv.fcs.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.fcs.dao.IFourDAO;
import com.huateng.scf.adv.fcs.dao.model.FourDeliveryVO;
import com.huateng.scf.adv.fcs.dao.model.FourMortgageVO;
import com.huateng.scf.adv.tcs.dao.model.ThreeDeliveryVO;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月21日下午2:23:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月21日下午2:23:31              新增
 *
 * </pre>
 */
@Repository("FourDAO")
public class FourDaoImpl extends IbatisDaoAnnotation4Template implements IFourDAO {

	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;
	   public FourDaoImpl() {
	        super();
	    }
	    public IbatisTemplate getSqlMapClientTemplate() {
	        return this.template;
	    }
		/**
		 * 先票/款后货到货出质入库发货通知已提交押品列表获取
		 * @param map
		 * @param page
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public List<FourMortgageVO> getFHPledgeDeliveryMortInfoList(Map<String, Object> map, Page page) {
			List<FourMortgageVO> list = this.searchListPageMyObject("EXT_A_FCS.getFHPledgeDeliveryMortInfoList", map, page);
			return list;
		}
		
		/**
		 * 提货申请查询列表
		 */
		@Override
		public List<FourDeliveryVO> selectFourDeliveryList(Map<String, Object> map, Page page) {
		    List<FourDeliveryVO> list = this.searchListPageMyObject("EXT_A_FCS.selectFourDeliveryList", map, page);
		    return list;
		}
		
		/**
		 * 根据申请编号查询提货申请信息
		 */
		@Override
		public FourDeliveryVO getFourDeliveryInfoByAppno(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return (FourDeliveryVO)getSqlMapClientTemplate().queryForObject("EXT_A_FCS.getFourDeliveryInfoByAppno",map);
		}
		/**
		 *  根据借据号查询提货信息
		 */
		@Override
		public FourDeliveryVO getFourDeliveryInfoByDebetNo(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return (FourDeliveryVO)getSqlMapClientTemplate().queryForObject("EXT_A_FCS.getFourDeliveryInfoByDebetNo",map);
		}
}
