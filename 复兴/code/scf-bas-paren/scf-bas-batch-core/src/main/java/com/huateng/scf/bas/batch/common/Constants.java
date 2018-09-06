package com.huateng.scf.bas.batch.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.common.BatchUtil;
import com.huateng.scf.bas.batch.report.adapter.ReportSqlService;
import com.huateng.scf.bas.batch.report.form.GlobalInfoForm;

public class Constants  {

	public static final int DEFAULT_COMMIT_COUNT = 500;//提交数，每500条提交一次


	/**
	 * 机构信息表值。
	 */
	public static Hashtable branchTable = new Hashtable();


	/**
	 * 机构信息表值。全部机构信息，然机构ID分。
	 */
	public static Hashtable branchTableID= new Hashtable();
	/**
	 * 机构信息　
	 */
	public static final String REPORT_PARAM_BRANCH="branchid";
	public static final int   REPORT_BRANCH=0;
	/**
	 * 总行
	 */
	public static final String   REPORT_ZONGHANG="1";
	/**
	 * 分行
	 */
	public static final String   REPORT_FENHANG="2";
	/**
	 * 支行
	 */
	public static final String   REPORT_ZHIHANG="3";

	/**
	 * 实物＋电子
	 */
	public static final String DRAFT_ATTR_ALL = "E";
	/** 票据属性-1-实物 */
	public static final String DRAFT_ATTR_REAL = "1";
	/** 票据属性-2-电子 */
	public static final String DRAFT_ATTR_ELECTRON = "2";

	/**
	 * 票据类型，纸票，电票，全部
	 */
	public static final String REPORT_PARAM_DRAFTATTR="draftattr";
	public static final int   REPORT_DRAFTATTR=1;
	/**
	 * 报表业务类型。
	 */
	public static final String REPORT_PARAM_BUSTYPE="bustype";
	public static final int   REPORT_BUSTYPE=2;


	/**
	 * 查询综合信息表
	 * @param sqlStr
	 * @return
	 * @throws Exception
	 */
	public static GlobalInfoForm  getServerdate(Connection conn)throws Exception	{

		Statement stmt = null;
		ResultSet rs = null;
		GlobalInfoForm globalform = new GlobalInfoForm();
		//modify by hui.liu 2011-05-12 SCF 更新 系统表名 begin
//		String sqlStr="select  BATCHDATE , LBATCHDATE from  GLOBAL_INFO ";
		String sqlStr="select  BHDATE , LBHDATE from  GLOBALINFO ";
		System.out.println(sqlStr);
		//modify by hui.liu 2011-05-12 SCF 更新 系统表名 end
		try{

			if(stmt == null)
				stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlStr.toString());
			if(rs.next())
			{
				globalform.BATCHDATE=(String)rs.getString("BATCHDATE");
				globalform.LBATCHDATE=(String)rs.getString("LBATCHDATE");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally
		{
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}
		return globalform;
	}


public static Hashtable  getBranchInfo(Connection conn)throws Exception	{

		Statement stmt = null;
		ResultSet rs = null;
		Hashtable ht= new Hashtable();
		//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
//		String sqlStr="select id,brh_no,brh_name  from branch_info " ;
		String sqlStr="select id,brno,brame  from BCTL " ;
		//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end
		System.out.println(sqlStr);
		try{

			if(stmt == null)
				stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlStr.toString());
			while(rs.next())
			{
				//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
//				String brhName = nvlString(rs.getString("brh_name"),"");
//				String brhNo = nvlString(rs.getString("brh_no"),"");
//				ht.put(nvlString(rs.getString("id"),""),brhNo+'-'+brhName);
				String brhName = nvlString(rs.getString("brame"),"");
				String brhNo = nvlString(rs.getString("brno"),"");
				ht.put(nvlString(rs.getString("id"),""),brhNo+'-'+brhName);
				//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally
		{
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}
		return ht;
	}
public static List  getBranchInfoList(Connection conn,String brcdClass)throws Exception	{

	Statement stmt = null;
	ResultSet rs = null;
	List brList=new ArrayList();
	//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
//	String sqlStr="select id  from branch_info where BRH_CLASS='" +brcdClass+"'";
	String sqlStr="select id  from BCTL where BRCLASS='" +brcdClass+"'";
	//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end
	System.out.println(sqlStr);
	try{

		if(stmt == null)
			stmt = conn.createStatement();
		rs = stmt.executeQuery(sqlStr.toString());
		while(rs.next())
		{
			Map brMap= new HashMap();
			String brhNo = nvlString(rs.getString("id"),"");
			brMap.put("ID",brhNo);
			brList.add(brMap);
		}
	}catch (Exception e) {
		e.printStackTrace();
		throw e;
	} finally
	{
		if (stmt != null)
			stmt.close();
		if (rs != null)
			rs.close();
	}
	return brList;
}

	public static String getBrh_class1(Connection conn) throws Exception {

		Statement stmt = null;
		ResultSet rs = null;
		//modify by hui.liu 2011-05-12 SCF 更新 机构表名 begin
//		String sqlStr = "select id,brh_name  from branch_info  where brh_class='1' ";
		String sqlStr = "select id,brname  from BCTL  where brclass='1' ";
		//modify by hui.liu 2011-05-12 SCF 更新 机构表名 end
		System.out.println(sqlStr);
		String ret = "";
		try {

			if (stmt == null)
				stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlStr.toString());
			while (rs.next()) {
				ret = nvlString(rs.getString("id"), "");
			}
		} catch (Exception e) {
			ret = "";
		} finally {
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}
		return ret;
	}



	public static String nvlString(String str,String ret)
	{
		if(str==null)
			str=ret;
		return str.trim();
	}

	/**
	 * yyyyMMddHHmmss
	 * @return
	 */
	public static String getServerTime()
	{
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return simpleDateFormat.format(date);

	}

	/**
	 * 获取批量参数（行级别）
	 * @param procParam	参数
	 * @return	1总行、2分行、3支行
	 * @throws Exception
	 */
	public String getProcParamBranchId(String procParam, int index) throws Exception {
		String branchId = "'1','2'";
		try{
			if (procParam == null || procParam.trim().length() < 1){
				return branchId;
			}else {
				String[] paramer = procParam.split(";;");
				if(paramer.length>1){
					String[] paramBranch = paramer[index].split("=");
					String branch = paramBranch[1];
					String[] branchs = branch.split(",");
					if(branchs.length > 1){
						for (int i = 0; i < branchs.length; i++) {
							branchId = branchId + "'" + branchs[i] + "',";
						}
						branchId = branchId.substring(0,branchId.lastIndexOf(","));
					}else{
						branchId = "'"+branch+"'";
					}
				}else{
					String[] paramBranch = procParam.split("=");
					String branch = paramBranch[1];
					String[] branchs = branch.split(",");
					if(branchs.length > 1){
						for (int i = 0; i < branchs.length; i++) {
							branchId = branchId + "'" + branchs[i] + "',";
						}
						branchId = branchId.substring(0,branchId.lastIndexOf(","));
					}else{
						branchId = "'"+branch+"'";
					}
				}

				return branchId;
			}
		}catch(Exception re){
			return branchId;
		}
	}

	/**
	 * 获取批量参数（票据性质）
	 * @param procParam	参数
	 * @return	1纸票、2电票
	 * @throws Exception
	 */
	public String getProcParamDraftAttr(String procParam, int index) throws Exception {
		String draftAttr = "'1','2'";
		try{
			if (procParam == null || procParam.trim().length() < 1){
				return draftAttr;
			}else {
				String[] paramer = procParam.split(";;");
				if(paramer.length>1){
					String[] paramAttr = paramer[index].split("=");
					String attr = paramAttr[1];
					String[] branchs = attr.split(",");
					if(branchs.length < 1){
						draftAttr = "'"+attr+"'";
					}
				}else{
					String[] paramAttr = procParam.split("=");
					String attr = paramAttr[1];
					String[] branchs = attr.split(",");
					if(branchs.length < 1){
						draftAttr = "'"+attr+"'";
					}
				}

				return draftAttr;
			}
		}catch(Exception re){
			return draftAttr;
		}
	}

	/**
	 * 获取参数
	 * @param procParam
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public static String[] getProcParam(String procParam, int index) throws Exception {
		String[] param = null;
		try{
			if (procParam == null || procParam.trim().length() < 1){
				return param;
			}else {
				String[] paramer = procParam.split("@");
				if(paramer.length>1){
					String[] paramAttr = paramer[index].split("=");
					String attr = paramAttr[1];
					param = attr.split(";");

				}else{
					String[] paramAttr = procParam.split("=");
					String attr = paramAttr[1];
					param = attr.split(";");
				}
				return param;
			}
		}catch(Exception re){
			return param;
		}
	}


	/**
	 * branchid=1;2;3@draftattr=E;1;2@bustype=04;10;20;11;21
	 * branchid:
	 * draftattr: 1-实物票；2-电子票；E-汇总
	 *
	 * @param procParam 数据库bh_proc_step parameter
	 * @param ret 返回类型，0　branchid　　，1 draftattr ,2  bustype
	 * @return 返回对应的值
	 * @throws Exception
	 */
	public static String[] getParamValue(String procParam, int ret) throws Exception {
		String[] param = null;
		Map hmap = new HashMap();
		try{
			if (procParam == null || procParam.trim().length() < 1){
				return param;
			}else {
				String[] paramer = procParam.toLowerCase().split("@");
				for(int i=0;i<paramer.length;i++)
				{
					param=paramer[i].split("=");
					hmap.put(param[0].trim(), param[1].trim());
				}
			}
			String strtemp=null;
			if(ret==REPORT_BRANCH)
				strtemp=(String)hmap.get(REPORT_PARAM_BRANCH);
			else if(ret==REPORT_DRAFTATTR)
				strtemp=(String)hmap.get(REPORT_PARAM_DRAFTATTR);
			else if(ret==REPORT_BUSTYPE)
				strtemp=(String)hmap.get(REPORT_PARAM_BUSTYPE);
			else
				strtemp=null;
			if(strtemp!=null)
				param=strtemp.split(";");
			else
				param=null;
			return param;
		}catch(Exception re){
			return param;
		}
	}




	/**
	 * 创建报表
	 * @param dataList 字段集合
	 * @param brno
	 * @param parameters 参数
	 * @param filename 报表文件名
	 * @param reportname 报表名称
	 * @param reportFlag 报表标志
	 * @param reportDate 报表日期
	 * @throws Exception
	 */
	public static void createReport(List dataList, String brno, HashMap parameters,String filename,String reportname, String reportFlag, String reportDate) throws Exception {
		try {

			String str = BatchUtil.getBatchProperty(BatchConstant.BATCH_PROPERTY_JASPER_FILE_PATH,"");
			StringBuffer fileJasperPath = new StringBuffer();
			fileJasperPath.append(str);
			String fillTemplet = fileJasperPath.toString()+ BatchUtil.getFileSeparator() + filename;
			// 创建对象
			ReportSqlService reports = new ReportSqlService();
			String flag = BatchUtil.trim(reportFlag);


			String tagReporName =reportname ;

			reports.createReportByList(dataList, fillTemplet, parameters,
					tagReporName, flag, brno, reportDate);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	/**
	 * 将机构信息加载到hashtable表中。
	 * hashtable: 1,为总行；2,分行；3,支行。(值为map)
	 * submap : 存放机构号，归属上级机构ID，BRH_CLASS等信息。
	 * @param conn
	 * @throws Exception
	 */
	public static  void loadBranchInfo(Connection conn) throws Exception
	{
		synchronized(branchTable){
			if(branchTable.size()==0)
			{
				branchTable.clear();
				branchTableID.clear();
				Statement stmt = null;
				ResultSet rs = null;
				int branchid ;
				String brh_class;
				String brh_name=null;
				String bln_up_brh_id=null;
				String brh_no = null;
				Map brmap=new HashMap();
				Map formmap=new HashMap();
				Map submap=new HashMap();
				String sql="select id, brh_no,BRH_CLASS,bln_up_brh_id,brh_name  from branch_info where BRH_CLASS in ('"+Constants.REPORT_ZONGHANG+"','"+Constants.REPORT_FENHANG+"','"+Constants.REPORT_ZHIHANG+"') and STATUS='1' order by BRH_CLASS asc ";
				try{
					if(stmt == null)
					{
						stmt = conn.createStatement();
					}
					rs = stmt.executeQuery(sql);
					while(rs.next())
					{
						branchid =rs.getInt("id");
						brh_class =BatchUtil.trim(rs.getString("BRH_CLASS"));
						bln_up_brh_id=BatchUtil.trim(rs.getString("bln_up_brh_id"));
						brh_name=BatchUtil.trim(rs.getString("brh_name"));
						brh_no=BatchUtil.trim(rs.getString("brh_no"));
						//总行
						if(brh_class.trim().equals(Constants.REPORT_ZONGHANG))
						{
							brmap=(Map)branchTable.get(Constants.REPORT_ZONGHANG);
							if(brmap==null)
								brmap=new HashMap();

							formmap=new HashMap();
							formmap.put("id", ""+branchid);
							formmap.put("brh_class", brh_class);
							formmap.put("bln_up_brh_id", bln_up_brh_id);
							formmap.put("brh_name", brh_name.trim());
							formmap.put("brh_no", brh_no);
							brmap.put(""+branchid,formmap);
							branchTable.put(Constants.REPORT_ZONGHANG, brmap);
						}
						//分行
						else 	if(brh_class.trim().equals(Constants.REPORT_FENHANG))
						{
							brmap=(Map)branchTable.get(Constants.REPORT_FENHANG);
							if(brmap==null)
								brmap=new HashMap();

							formmap=new HashMap();
							formmap.put("id", ""+branchid);
							formmap.put("brh_class", brh_class);
							formmap.put("bln_up_brh_id", bln_up_brh_id);
							formmap.put("brh_name", brh_name);
							formmap.put("sub_branch",""+branchid );
							formmap.put("brh_no", brh_no);
							brmap.put(""+branchid,formmap);
							branchTable.put(Constants.REPORT_FENHANG, brmap);
						}
						//支行
						else 	if(brh_class.trim().equals(Constants.REPORT_ZHIHANG))
						{
							brmap=(Map)branchTable.get(Constants.REPORT_ZHIHANG);
							if(brmap==null)
								brmap=new HashMap();

							formmap=new HashMap();
							formmap.put("id", ""+branchid);
							formmap.put("brh_class", brh_class);
							formmap.put("bln_up_brh_id", bln_up_brh_id);
							formmap.put("brh_name", brh_name);
							formmap.put("brh_no", brh_no);
							brmap.put(""+branchid,formmap);
							branchTable.put(Constants.REPORT_ZHIHANG, brmap);
							//加载到上级机构中去
							brmap=(Map)branchTable.get(Constants.REPORT_FENHANG);
							if(brmap!=null)
							{
								submap=(HashMap)brmap.get(bln_up_brh_id);
								if(submap!=null)
								{
									submap.put("sub_branch", (String)submap.get("sub_branch")+","+branchid);
									brmap.put((String)submap.get("id"),submap);
									branchTable.put(Constants.REPORT_FENHANG, brmap);
								}
							}
						}//
						branchTableID.put(branchid, brh_name);

					}
				}catch (Exception e) {
					branchTable=null;
					e.printStackTrace();
					throw e;
				} finally
				{
					if (stmt != null)
						stmt.close();
					if (rs != null)
						rs.close();
				}
			}
		}
	}

}
