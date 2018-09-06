package com.huateng.scf.bas.prd.service;

import com.huateng.scube.exception.ScubeBizException;

public interface IBPrdMortService {

	/**
	 * 返回产品类型为动产动态的小类的组合字符串
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月20日下午3:09:19
	 */
	public String getProductDynamic() throws ScubeBizException;
	
	/**
	 * @Description: 返回产品类型为动产静态的小类的组合字符串
	 * @author xu_hong
	 * @Created 2013-1-9下午03:55:08
	 * @return
	 * @throws CommonException
	 */
	public String getProductStatic() throws ScubeBizException;

}
