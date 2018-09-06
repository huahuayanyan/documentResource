/**
 * 
 */
package com.huateng.scf.bas.common.model;

import java.util.List;

import com.huateng.authority.entity.BctlVO;

/**
 * <p>VO公共对象</p>
 *
 * @author 	huangshuidan
 * @date 2016年11月30日下午2:42:32	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月30日下午2:42:32              新增
 *
 * </pre>
 */
public class CommonBaseVO {
	List<BctlVO> listBctl=null;
	/**
	 * @return the listBctl
	 */
	public List<BctlVO> getListBctl() {
		return listBctl;
	}
	/**
	 * @param listBctl the listBctl to set
	 */
	public void setListBctl(List<BctlVO> listBctl) {
		this.listBctl = listBctl;
	}
}
