package com.huateng.scf.bas.batch.common;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SQL操作类
 * @author hicomhui
 *
 */
public class BaseDao {

	private Connection con = null;

	public BaseDao(Connection con){
		this.con = con;
	}

	/**
	 * 保存数据（添加/更新）
	 * @param con 连接对象
	 * @param sql
	 * @param params	参数
	 * @throws Exception
	 */
	public void save( String sql, Object[] params) throws Exception {
		PreparedStatement ps = null;
        try {
        	if(ps == null)
        		ps = con.prepareStatement(sql);

            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
					setObjectValue(ps, i + 1, params[i]);
				}
            }
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close(ps);
        }
    }

	/**
	 * 批处理保存数据（添加/更新）
	 * @param con	连接对象
	 * @param sql
	 * @param params	参数集合<Object[]>
	 * @param count	每次提交条数
	 * @throws Exception
	 */
	public void saveBatch(String sql, List params, int count) throws Exception {
		PreparedStatement ps = null;
		try{
			if(ps == null)
				ps = con.prepareStatement(sql);

			for (int i = 0; i < params.size(); i++) {
				Object[] objParams = (Object[])params.get(i);
				for (int j = 0; j < objParams.length; j++) {
					setObjectValue(ps, j + 1, objParams[j]);
				}
				ps.addBatch();	//加入批处理，进行打包

				if(i % count == 0){	//提交批处理事务，防止堵塞
					ps.executeBatch();
					con.commit();
					ps.clearBatch();
				}
			}
			ps.executeBatch();
			con.commit();
			ps.clearBatch();
		}catch(Exception e){
			throw e;
		}finally {
			close(ps);
        }
	}

	/**
     * 删除数据
     * @param con  连接对象
     * @param SQL
     * @param params  参数
     * @throws Exception
     * @author
     */
    public void remove(String sql, Object[] params) throws Exception {
        PreparedStatement ps = null;
        try {
        	if(ps == null)
        		ps = con.prepareStatement(sql);

            if (params != null && params.length > 0) {
            	for (int i = 0; i < params.length; i++) {
					setObjectValue(ps, i + 1, params[i]);
				}
            }
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
        	close(ps);
        }
    }

    /**
     * 获取记录集(List)
     * @param con  连接对象
     * @param SQL
     * @param params  参数
     * @return  List集合<Map<大写字段名,字段值>>
     * @throws Exception
     * @author
     */
    public List query(String sql, Object[] params)
            throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsm = null;
        List relist = null;
        try {
        	if(ps == null)
        		ps = con.prepareStatement(sql);

            if (params != null && params.length > 0) {
            	for (int i = 0; i < params.length; i++) {
					setObjectValue(ps, i + 1, params[i]);
				}
            }
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            relist = new ArrayList();
            while (rs.next()) {
                Map entity = new HashMap();
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    String columnName = rsm.getColumnName(i).toUpperCase();
                    entity.put(columnName, rs.getObject(i));
                }
                    relist.add(entity);
            }
        } catch (Exception e) {
            throw e;
        } finally {
        	close(rs);
            close(ps);

        }
        return relist;
    }

    /**
     * 获取记录集(ResultSet)
     * @param con  连接对象
     * @param SQL
     * @param params  参数
     * @return
     * @throws Exception
     * @author
     */
    public ResultSet queryRs(String sql, Object[] params)
            throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
        	if(ps == null)
        		ps = con.prepareStatement(sql);

            if (params != null && params.length > 0) {
            	for (int i = 0; i < params.length; i++) {
					setObjectValue(ps, i + 1, params[i]);
				}
            }
            rs = ps.executeQuery();
        } catch (Exception e) {
            throw e;
        } finally {
        	close(ps);
        }
        return rs;
    }

	/**
     * 把对象传入数据库（匹配类型）
     * @param ps
     * @param count
     * @param object
     * @author
     */
    private final void setObjectValue(PreparedStatement ps, int count, Object object) throws Exception {
//        System.out.println("count is " + count + " object is " + object);
        if(object != null) {
            if(object instanceof Integer){
                ps.setInt(count, ((Integer)object).intValue());
            }else if(object instanceof Long) {
                ps.setLong(count, ((Long)object).longValue());
            }else if(object instanceof BigDecimal){
                ps.setBigDecimal(count, (BigDecimal)object);
            }else if(object instanceof Double){
                ps.setDouble(count, ((Double)object).doubleValue());
            }else if(object instanceof String){
                ps.setString(count, (String)object);
            }else if(object instanceof java.util.Date) {
                if(object!=null){
                    long time = ((java.util.Date)object).getTime();
                    ps.setDate(count, new java.sql.Date(time));
                }else{
                    ps.setDate(count, null);
                }
            }else{
                ps.setObject(count, object);
            }
        }else{
//            ps.setNull(count, Types.VARCHAR);
        	ps.setObject(count, object);
        }
    }

    /*********  Statement  ************/

    /**
	 * 保存数据（添加/更新）(Statement)
	 * @param con 连接对象
	 * @param sql
	 * @param params	参数
	 * @throws Exception
	 */
	public void save(String sql) throws Exception {
		Statement stmt = null;
        try {
        	if(stmt == null)
        		stmt = con.createStatement();

            stmt.executeUpdate(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            close(stmt);
        }
    }

    /**
	 * 删除数据(Statement)
	 * @param con 连接对象
	 * @param sql
	 * @param params	参数
	 * @throws Exception
	 */
	public void remove(String sql) throws Exception {
		Statement stmt = null;
        try {
        	if(stmt == null)
        		stmt = con.createStatement();

            stmt.executeUpdate(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            close(stmt);
        }
    }

	/**
     * 获取记录集(List)(Statement)
     * @param con  连接对象
     * @param SQL
     * @return  List集合<Map<字段,字段值>>
     * @throws Exception
     * @author
     */
    public List query(String sql) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsm = null;
        List relist = null;
        try {
        	if(stmt == null)
        		stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
            rsm = rs.getMetaData();
            relist = new ArrayList();
            while (rs.next()) {
                Map entity = new HashMap();
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    String columnName = rsm.getColumnName(i).toUpperCase();
                    entity.put(columnName, rs.getObject(i));
                }
                    relist.add(entity);
            }
        } catch (Exception e) {
            throw e;
        } finally {
        	close(rs);
            close(stmt);

        }
        return relist;
    }

    /**
     * 获取记录集(ResultSet)
     * @param con  连接对象
     * @param SQL
     * @return
     * @throws Exception
     * @author
     */
    public ResultSet queryRs(String sql) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        try {
        	if(stmt == null)
        		stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            throw e;
        } finally {
        	close(stmt);
        }
        return rs;
    }

    public void close(PreparedStatement ps){
    	 try {
             if (ps != null) {
                 ps.close();
             }
         } catch (Exception e) {
         }
    }

    public void close(Statement stmt ){
      	 try {
               if (stmt != null) {
            	   stmt.close();
               }
           } catch (Exception e) {
           }
      }

    public void close(ResultSet rs ){
   	 try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
        }
   }
}
