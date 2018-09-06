/*
 */

package com.huateng.scf.bas.batch.common;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 为了支持Struts的索引属性，该类封装了一些Getter和Setter。
 *
 * @author Huang Liang
 * @version 1.0
 */

public class BatchHTArrayList
	extends ArrayList {

	/**
	 * @param initialCapacity
	 */
	public BatchHTArrayList(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * 
	 */
	public BatchHTArrayList() {
		super();
	}

	/**
	 * @param c
	 */
	public BatchHTArrayList(Collection c) {
		super(c);
	}

	/**
	 * 按索引位置获得对象。
	 * @param index，索引位置。
	 * @return 索引位置处的对象。
	 */
	public Object getIndexed(int index) {
		return get(index);
	}
	
	/**
	 * 按索引位置存储对象。
	 * @param index，索引位置。
	 * @param element，要存储的对象。
	 * @return 原来在索引位置处的对象。
	 */
	public Object setIndexed(int index, Object element) {
		return set(index, element);
	}
}
