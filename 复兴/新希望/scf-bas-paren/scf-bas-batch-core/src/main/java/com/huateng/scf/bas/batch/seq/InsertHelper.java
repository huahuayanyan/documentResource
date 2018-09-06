package com.huateng.scf.bas.batch.seq;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.huateng.scf.bas.batch.seq.exception.BatchException;


public interface InsertHelper {
	/**
	 *  ��ʼ�������
	 * @throws SQLException 
	 */
	void beginInsert() throws SQLException;
	/**
	 * ����������
	 * @throws SQLException 
	 */
	void endInsert() throws SQLException;
	/**
	 * ����һ��Ψһֵ
	 * @param size һ��ֵ�Ĵ�С
	 * @return һ�����ֵ�������IdentifyBatch��
	 * @throws SQLException ��������ݿ��쳣ʱ�׳�
	 * @throws BatchException ��InsertHelper��δ��ʼ��ʱ�׳��쳣
	 */
	IdentityBatch genIdentifyBatch(int size) throws SQLException, BatchException;
	/**
	 * ��õ�ǰ��Id
	 * @return ��ʶ��ǰ��id��ˮ���
	 * @throws SQLException ��������ݿ��쳣ʱ�׳�
	 * @throws BatchException ��InsertHelper��δ��ʼ��ʱ�׳��쳣
	 */
	int getCurrentValue() throws SQLException, BatchException;
	/**
	 * ��ȡ��һ����ɵ�Id
	 * @return ��һ��Id
	 * @throws SQLException ��������ݿ��쳣ʱ�׳� 
	 * @throws BatchException ��InsertHelper��δ��ʼ��ʱ�׳��쳣
	 */
	int getNextValue() throws SQLException, BatchException;
	/**
	 * ͨ�����ִ�в��붯���Զ��滻����е�@identity�ַ������ݲ���Ĳ���
	 * @param insertQL һ��Insert SQL���
	 * @return �����ݲ���ɹ������ز���ʱʹ�õ�id
	 * @throws SQLException ��������ݿ��쳣ʱ�׳�
	 * @throws BatchException ��InsertHelper��δ��ʼ��ʱ�׳��쳣
	 */
	int executeInsert(String insertQL) throws SQLException, BatchException;
	/**
	 * ����һ��Ԥ�������
	 * @param insertQL һ��Insert SQL���
	 * @return ��Ԥ����� SQL �����µ�Ĭ�� PreparedStatement ����
	 * @throws SQLException ��������ݿ��쳣ʱ�׳�
	 * @throws BatchException ��InsertHelper��δ��ʼ��ʱ�׳��쳣
	 */
	PreparedStatement createPrepareStatement(String insertQL) throws SQLException, BatchException;
	
	/**
	 * ����һ��Ԥ�������
	 * @param insertQL һ��Insert SQL���
	 * @param resultSetType ���� ResultSet ��֮һ��ResultSet.TYPE_FORWARD_ONLY��ResultSet.TYPE_SCROLL_INSENSITIVE �� ResultSet.TYPE_SCROLL_SENSITIVE
	 * @param resultSetConcurrency ���� ResultSet ��֮һ��ResultSet.CONCUR_READ_ONLY �� ResultSet.CONCUR_UPDATABLE
	 * @param resultSetHoldability ���� ResultSet ��֮һ��ResultSet.HOLD_CURSORS_OVER_COMMIT �� ResultSet.CLOSE_CURSORS_AT_COMMIT
	 * @return һ���Ԥ����� SQL ������ PreparedStatement ���󣬸ö�����ɾ��и����͡������ԺͿɱ����Ե� ResultSet ����
	 * @throws SQLException ��������ݿ��쳣ʱ�׳�
	 * @throws BatchException ��InsertHelper��δ��ʼ��ʱ�׳��쳣
	 */
	public PreparedStatement createPrepareStatement (String insertQL, int resultSetType, int resultSetConcurrency, int resultSetHoldability) 
	throws SQLException, BatchException;
}
