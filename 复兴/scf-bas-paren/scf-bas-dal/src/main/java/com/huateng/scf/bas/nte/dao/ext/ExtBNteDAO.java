package com.huateng.scf.bas.nte.dao.ext;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExt;

import java.util.HashMap;
import java.util.List;
/**
 * 
 * <p></p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月20日下午1:21:09
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月20日下午1:21:09	     新增
 *
 * </pre>
 */
public interface ExtBNteDAO {
    int countNoticeBaseInfoByNoticeCommonQueryVO(HashMap<String, Object> omap);

	List<BNteNoticeBase> getNoticeBaseInfoByNoticeCommonQueryVO(HashMap<String, Object> omap, Page page);
	
	List<BNteNoticeMtgExt> getDeliveryNotifyMortList(HashMap<String, Object> omap, Page page);
	
}