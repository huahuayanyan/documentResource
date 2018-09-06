/**
 * 
 */
package com.huateng.scf.adv.tcs.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.common.beans.Page;
import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.adv.tcs.dao.IATcsThreeDeliveryDAO;
import com.huateng.scf.adv.tcs.dao.model.ThreeBuyMortgageInfoVO;
import com.huateng.scf.adv.tcs.dao.model.ThreeDeliveryVO;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月25日下午2:40:32
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月25日下午2:40:32              新增
 *
 * </pre>
 */
@Repository("ATcsThreeDeliveryDAO")
public class ATcsThreeDeliveryDAOImpl extends IbatisDaoAnnotation4Template implements IATcsThreeDeliveryDAO {
	@Resource(name="sqlMapClientTemplate")
	private IbatisTemplate template;
	   public ATcsThreeDeliveryDAOImpl() {
	        super();
	    }
	    public IbatisTemplate getSqlMapClientTemplate() {
	        return this.template;
	    }
		/**
		 * 提货申请查询列表
		 */
		@Override
		public List<ThreeDeliveryVO> selectThreeDeliveryList(Map map, Page page) {
		    List<ThreeDeliveryVO> list = this.searchListPageMyObject("EXT_A_TCS_THREE_DELIVERY.selectThreeDeliveryList", map, page);
		    return list;
		}
		/**
		 * 根据申请编号查询提货申请信息
		 */
		@Override
		public ThreeDeliveryVO getThreeDeliveryInfoByAppno(Map map) {
			// TODO Auto-generated method stub
			return (ThreeDeliveryVO)getSqlMapClientTemplate().queryForObject("EXT_A_TCS_THREE_DELIVERY.getThreeDeliveryInfoByAppno",map);
		}
		/**
		 *  根据借据号查询提货信息
		 */
		@Override
		public ThreeDeliveryVO getThreeDeliveryInfoByDebetNo(Map map) {
			// TODO Auto-generated method stub
			return (ThreeDeliveryVO)getSqlMapClientTemplate().queryForObject("EXT_A_TCS_THREE_DELIVERY.getThreeDeliveryInfoByDebetNo",map);
		}
		/**
		 * 根据借据号查询对应出账的贸易合同押品信息
		 */
		@Override
		public List<ThreeBuyMortgageInfoVO> getTripartiteDeliveryAppMortList(Map<String, Object> map, Page page) {
			 List<ThreeBuyMortgageInfoVO> list = this.searchListPageMyObject("EXT_A_TCS_THREE_DELIVERY.getTripartiteDeliveryAppMortList", map, page);
			return list;
		}
		/**
		 * 根据申请编号查询冻结保证金信息
		 */
		@Override
		public List getAddBailAmountListByAppno(String appno, Page page) {
			 List list = this.searchListPageMyObject("EXT_A_TCS_THREE_DELIVERY.getAddBailAmountListByAppno", appno, page);
			return list;
		}
}
