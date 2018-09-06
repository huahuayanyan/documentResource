/**
 * 
 */
package com.huateng.scf.bas.pbc.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgMktPriceHisDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceHisExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgMktPriceHisExample.Criteria;
import com.huateng.scf.bas.pbc.model.BPbcMtgMktPriceHis;
import com.huateng.scf.bas.pbc.service.IBPbcMtgMktPriceHisService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年4月27日下午7:50:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年4月27日下午7:50:20	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BPbcMtgMktPriceHisServiceImpl")
public class BPbcMtgMktPriceHisServiceImpl implements IBPbcMtgMktPriceHisService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "IBPbcMtgMktPriceHisDAO")
	IBPbcMtgMktPriceHisDAO bPbcMtgMktPriceHisDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.pbc.service.IBPbcMtgMktPriceHisService#
	 * getMortMarketPriByProId(int, int,
	 * com.huateng.scf.bas.pbc.model.BPbcMtgMktPriceHis)
	 */
	@Override
	public Page getMortMarketPriByProId(int pageNo, int pageSize, BPbcMtgMktPriceHis bPbcMtgMktPriceHis) {
		Page page = new Page(pageSize, pageNo, 0);
		if (bPbcMtgMktPriceHis == null) {
			return page;
		} else if (bPbcMtgMktPriceHis.getProductId() == null || "".equals(bPbcMtgMktPriceHis.getProductId())) {
			return page;
		}
		BPbcMtgMktPriceHisExample bPbcMtgMktPriceHisExample = new BPbcMtgMktPriceHisExample();
		Criteria cri = bPbcMtgMktPriceHisExample.createCriteria();
		cri.andProductIdEqualTo(bPbcMtgMktPriceHis.getProductId());
		cri.andMarketPriceSrcEqualTo(ScfBasConstant.MARKETPRICESRC_IMPORT); // excel导入
		try {
			bPbcMtgMktPriceHisDAO.selectByPage(bPbcMtgMktPriceHisExample, page);
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new ScubeBizException("押品市场价格历史信息分页查询失败！");
		}

		return page;
	}

}
