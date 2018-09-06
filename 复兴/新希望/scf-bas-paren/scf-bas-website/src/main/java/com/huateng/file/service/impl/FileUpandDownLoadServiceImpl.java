package com.huateng.file.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import com.huateng.file.service.FileOperateService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.nbas.prd.model.BPrdPrintInfoVO;
import com.huateng.scf.nbas.prd.service.IBPrdPrintInfoService;
import com.huateng.scf.nrec.bcp.model.RBcpDebtInfoVO;
import com.huateng.scf.nrec.bcp.service.ITransferApplyService;
import com.huateng.scube.exception.ScubeBizException;

public class FileUpandDownLoadServiceImpl implements FileOperateService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	//上传路径
//	private final String UPLOAD_PATH = "scube.tmpFilePath";
	
	//下载路径
//	private final String DOWNLOAD_PATH = "AuthorizationFromParamsUrl";
	
	// 可以注入其他类
	@Resource(name = "BPrdPrintInfoServiceImpl")
	IBPrdPrintInfoService bprdprintinfoservice;

	@Resource(name = "TransferApplyServiceImpl")
	ITransferApplyService transferApplyService;

	/*
	 * 
	 * 上传
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object upload(List<File> fileList, Map<String, String> paramMap) {
		String uploadType = paramMap.get("uploadType");
		if (StringUtils.isNotEmpty(uploadType)) {
			String mastContno = paramMap.get("mastContno");
			if (StringUtils.isEmpty(mastContno) || mastContno.equals("undefined")) {
				throw new ScubeBizException("合同号丢失，数据上传失败，请重试！");
			}
			String fileName = fileList.get(0).getName();
			int num = fileName.lastIndexOf(".");
			if (num == -1) {
				throw new ScubeBizException("文件格式错误！");
			}
			String fileext = fileName.substring(num + 1);// 文件类型
			if (!fileext.equals("xlsx")) {
				return "请通过页面'下载'按钮下载模版，编译数据后上传对应文件！";
			}
			Object rBcpDebtInfoList = uploadTransferExcel(fileList, paramMap);
			return rBcpDebtInfoList;
		} else {
			String invokPhase = paramMap.get("invokPhase");
			String productId = paramMap.get("productId");
			if(invokPhase.equals("undefined") || StringUtil.isEmpty(invokPhase))
			{
				throw new ScubeBizException("调用阶段不能为空！");
			}
			List list = bprdprintinfoservice.CheckBPrdPrintInfo(productId, invokPhase);
			if(list != null && list.size() > 0)
			{
				throw new ScubeBizException("该业务品种同一调用阶段模版信息已存在，请重新选择，或删除原信息");
			}
			for(File file : fileList)
			{
				String fileName = file.getName();
				int num = fileName.lastIndexOf(".");
				BPrdPrintInfoVO infoVO = new BPrdPrintInfoVO();
				if(num == -1)
				{
					throw new ScubeBizException("文件格式错误！");
				}
				String filename = fileName.substring(0, num);// 文件名称
				String fileext = fileName.substring(num + 1);// 文件类型
				if("exe".equalsIgnoreCase(fileext))
				{
					throw new ScubeBizException("文件格式不能为exe！");
				}
				try
				{
					InputStream in = new FileInputStream(file);
					byte[] b = FileCopyUtils.copyToByteArray(in);
					infoVO.setFileExt(fileext);
					infoVO.setFileName(filename);
					infoVO.setInvokPhase(invokPhase);
					infoVO.setProductId(productId);
					infoVO.setFileData(b);
					bprdprintinfoservice.addBPrdPrintInfo(infoVO);// 保存到数据库
					// 删除生成的临时文件 start
					if(file.exists())
					{
						file.delete();
					}
					File parentFile = file.getParentFile();
					deleteDir(parentFile);
					deleteDir(parentFile.getParentFile());
					// 删除生成的临时文件 end
				}
				catch (FileNotFoundException e)
				{
					throw new ScubeBizException("合同模板上传失败！");
				}
				catch (IOException e)
				{
					throw new ScubeBizException("合同模板上传失败！");
				}
			}
			logger.debug("upload 完成");
		}
		return fileList;
	}

	/*
	 * 
	 * 下载方法
	 * 
	 */
	@Override
	public InputStream download(Map<String, String> paramMap) {

		logger.debug("download================================start");
		InputStream isInputStream = null;
		OutputStream outInputStream = null;
		String id = paramMap.get("id");
		if (id.equals("undefined") || StringUtil.isEmpty(id)) {
			throw new ScubeBizException("合同模板主键信息丢失");
		}
		try {
			BPrdPrintInfoVO infoVO = bprdprintinfoservice.findBPrdPrintInfoById(id);
			String fileName = infoVO.getFileName();
			String fileExt = infoVO.getFileExt();
			byte[] fileDate = infoVO.getFileData();
//			String filepath = ScfMessageUtil.transSysMsgByKey(DOWNLOAD_PATH);// 下载文件路径，暂时写死
//			String filename = fileName + "." + fileExt;
//			File fileparent = new File(filepath);
//			if (!fileparent.exists())
//			{
//				fileparent.mkdirs();
//			}
//			File file = new File(filepath + "/" + filename);
//			if (file.exists()) {
//				file.delete();
//
//			}
//			outInputStream=new FileOutputStream(filepath+"/"+filename,true);
//			outInputStream.write(fileDate, 0, fileDate.length);//写文件
//			outInputStream.close();
//			if (file.exists()) {
//				isInputStream = new FileInputStream(file);
//			}
//			return isInputStream;
			//无需在指定路径存储文件
			String filename = fileName + "." + fileExt;
			File file = new File(filename);
			if (file.exists())
			{
				file.delete();
			}
			outInputStream = new FileOutputStream(filename, true);
			outInputStream.write(fileDate, 0, fileDate.length);// 写文件
			outInputStream.close();
			if (file.exists())
			{
				isInputStream = new FileInputStream(file);
			}
			return isInputStream;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ScubeBizException("下载失败");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ScubeBizException("下载失败");
		}
	}

	/**
	 * 删除文件
	 * mengjiajia
	 * @param dir
	 */
	public static void deleteDir(File dir) {
		if (dir == null || !dir.exists() || !dir.isDirectory()) {
			for (File f : dir.listFiles()) {
				if (f.isFile()) {
					f.delete();
				} else if (f.isDirectory()) {
					deleteDir(f);
				}
			}
		}
		dir.delete();
	}

	@SuppressWarnings("resource")
	public Object uploadTransferExcel(List<File> fileList, Map<String, String> paramMap) {

		File file = fileList.get(0);
		String errorMsg = "";
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
			List<RBcpDebtInfoVO> rBcpDebtInfoList = new ArrayList<RBcpDebtInfoVO>();
			Workbook wb = new XSSFWorkbook(inputStream);
			Sheet sht0 = wb.getSheetAt(0);
			if (sht0.getLastRowNum() == 0) {
				errorMsg = "上传文件为空，请填写数据后上传！";
				return errorMsg;
			}
			boolean errorFlag=false;
			String errorMessageDetail="";
			HashMap<String, Object> map = new HashMap<String, Object>();
			for (int i = 1; i <= sht0.getLastRowNum(); i++) {
				RBcpDebtInfoVO rBcpDebtInfoVO = new RBcpDebtInfoVO();
				Row r = sht0.getRow(i);
				if(r==null){
					continue;	
				}
				String billsNo = "";// 凭证编号
				String billsType = "";// 凭证类型
				String bussContcode = "";// 商务合同号
				String aging = "";// 账期
				String gracePeriod = "";// 宽限期
				String billsDate = "";// 应收账款日期
				String billsAmountView = "";// 票面金额
				String billsAmount = "";// 有效金额
				String memo = "";// 备注
				//这里要考虑到用户填写的Excel中可能存在在输入空格里打了几个空格键或者出现隔行才有数据
				if((r.getCell(0) == null||(r.getCell(0) != null && StringUtils.isBlank(r.getCell(0).toString())))
						&&(r.getCell(1) == null||(r.getCell(1) != null && StringUtils.isBlank(r.getCell(1).toString())))
						&&(r.getCell(2) == null||(r.getCell(2) != null && StringUtils.isBlank(r.getCell(2).toString())))
						&&(r.getCell(3) == null||(r.getCell(3) != null && StringUtils.isBlank(r.getCell(3).toString())))
						&&(r.getCell(4) == null||(r.getCell(4) != null && StringUtils.isBlank(r.getCell(4).toString())))
						&&(r.getCell(5) == null||(r.getCell(5) != null && StringUtils.isBlank(r.getCell(5).toString())))
						&&(r.getCell(6) == null||(r.getCell(6) != null && StringUtils.isBlank(r.getCell(6).toString())))
						&&(r.getCell(7) == null||(r.getCell(7) != null && StringUtils.isBlank(r.getCell(7).toString())))
						&&(r.getCell(8) == null||(r.getCell(8) != null && StringUtils.isBlank(r.getCell(8).toString())))){
					continue;
				}
				boolean errorFormat=false;
				String regex="[a-zA-Z_0-9-]{1,50}";
				// 一、页面字段校验，校验成功之后再
				// 1.页面检验规则-不可为空字段
				// 凭证编号
				if (r.getCell(0) != null) {
					// billsNo = r.getCell(0).getStringCellValue();
					billsNo = r.getCell(0).toString();
					billsNo = sustringZero(billsNo);
					if (StringUtils.isBlank(billsNo)) {
						errorMsg = "[凭证编号]不可为空；";
						errorFlag=true;
					}else{
						//校验编号格式
						boolean matches = billsNo.matches(regex);
						if(matches){
							// 去重
							if (map.get(billsNo) == null) {// 说明没有这个凭证编号
								rBcpDebtInfoVO.setBillsNo(billsNo);
								map.put(billsNo, billsNo);// 如果不存在则存储下对应的凭证编号
							} else {
								errorMsg = "[凭证编号]在表格中已存在；";
								errorFlag=true;
							}
						}else{
							errorMsg = "[凭证编号]须符合“50位以内大小写英文，数字，_或者-”数据格式要求；";
							errorFlag=true;
						}
					}
				}else{
					errorMsg = "[凭证编号]不可为空；";
					errorFlag=true;
				}
				// 凭证类型
				if (r.getCell(1) != null) {
					billsType = r.getCell(1).toString();
					if (StringUtils.isBlank(billsType)) {
						errorMsg = errorMsg+"[凭证类型]不可为空；";
						errorFlag=true;
					}else{
						if (billsType.equals("发票")) {
							rBcpDebtInfoVO.setBillsType("01");
						} else if (billsType.equals("虚拟发票")) {
							rBcpDebtInfoVO.setBillsType("02");
						} else if (billsType.equals("结算单")) {
							rBcpDebtInfoVO.setBillsType("03");
						} else if (billsType.equals("收货收据")) {
							rBcpDebtInfoVO.setBillsType("04");
						} else if (billsType.equals("出口退税池")) {
							rBcpDebtInfoVO.setBillsType("05");
						} else if (billsType.equals("其他")) {
							rBcpDebtInfoVO.setBillsType("06");
						} else {
							errorMsg = errorMsg+"[凭证类型]错误，请通过输入框旁下拉箭头选择数据！";
							errorFlag=true;
						}
					}
				}else{
					errorMsg = errorMsg+"[凭证类型]不可为空；";
					errorFlag=true;
				}
				// 商务合同号
				if (r.getCell(2) != null) {
					bussContcode = r.getCell(2).toString();
					bussContcode = sustringZero(bussContcode);
					if (StringUtils.isBlank(bussContcode)) {
						errorMsg = errorMsg+"[商务合同号]不可为空；";
						errorFlag=true;
					}else{
						boolean matche = bussContcode.matches(regex);
						if(matche){
							rBcpDebtInfoVO.setBussContcode(bussContcode);
						}else{
							errorMsg = "[商务合同号]须符合“50位以内大小写英文，数字，_或者-”数据格式要求；";
							errorFlag=true;
						}
					}
					
				}else{
					errorMsg = errorMsg+"[商务合同号]不可为空；";
					errorFlag=true;
				}
				// 账期
				if (r.getCell(3) != null) {
					aging = r.getCell(3).toString();
					aging = sustringZero(aging);
					if (StringUtils.isBlank(aging)) {
						errorMsg = errorMsg+"[账期]不可为空；";
						errorFlag=true;
					}else{
						// 首先是必须是数值类型，不是则需要报错。不得小于等于0
						try {
							int parseInt = Integer.parseInt(aging);
							if (parseInt <= 0) {
								errorMsg = errorMsg+"[账期]必须大于0；";
								errorFlag=true;
							}else{
								rBcpDebtInfoVO.setAging(aging);
							}
						} catch (Exception e) {
							errorMsg = errorMsg+"[账期]必须为整数格式；";
							errorFlag=true;
						}
					}
				}else{
					errorMsg = errorMsg+"[账期]不可为空；";
					errorFlag=true;
				}
				// 宽限期
				if (r.getCell(4) != null) {
					gracePeriod = r.getCell(4).toString();
					gracePeriod = sustringZero(gracePeriod);
					if (StringUtils.isBlank(gracePeriod)) {
						errorMsg = errorMsg+"[宽限期]不可为空；";
						errorFlag=true;
					}else{
						try {
							int parseInt2 = Integer.parseInt(gracePeriod);
							if (parseInt2 < 0) {
								errorMsg =errorMsg+ "[宽限期]必须大于0；";
								errorFlag=true;
							}else{
								rBcpDebtInfoVO.setGracePeriod(new BigDecimal(parseInt2));
							}
						} catch (Exception e) {
							errorMsg = errorMsg+"[宽限期]必须为整数格式；";
							errorFlag=true;
						}
						
					}
				}else{
					errorMsg = errorMsg+"[宽限期]不可为空；";
					errorFlag=true;
				}
				// 应收账款日期
				if (r.getCell(5) != null) {
					billsDate = r.getCell(5).toString();
					if (StringUtils.isBlank(billsDate)) {
						errorMsg =errorMsg+ "[应收账款日期]不可为空；";
						errorFlag=true;
					}else{
						// 必须含有-，而且必须含有两个。
						if (!billsDate.contains("-")) {
							errorMsg = errorMsg+"[应收账款日期]格式错误，请以“年-月-日”格式填写；";
							errorFlag=true;
						}else{
							String[] time = billsDate.split("-");
							String errorBillsDate=billsDate;
							if(time.length !=3 ){
								errorMsg = errorMsg+"[应收账款日期]格式错误，请以“年-月-日”格式填写；";
								errorFlag=true;
							}else{
								String year = time[0];
								String month = time[1];
								String day = time[2];
								boolean dateErrorFlag1=false;//日期不存在
								boolean dateErrorFlag2=false;//应该为整数
								// 必须为数字格式和对应的数字范围
								try {
									int day1 = Integer.parseInt(day);
									if (day1 <= 0 || day1 > 31) {
										dateErrorFlag1=true;
									}
								} catch (Exception e) {
									dateErrorFlag2=true;
								}
								try {
									int month1 = Integer.parseInt(month);
									if (month1 <= 0 || month1 > 12) {
										dateErrorFlag1=true;
									}
								} catch (Exception e) {
									dateErrorFlag2=true;
								}
								try {
									int year1 = Integer.parseInt(year);
									if (year1 <= 0) {
										dateErrorFlag1=true;
									}
								} catch (Exception e) {
									dateErrorFlag2=true;
								}
								//最终判断
								if(dateErrorFlag2){
									errorMsg = errorMsg+"[应收账款日期]年月日应为整数类型，请重新填写；";
									errorFlag=true;
								}else if(dateErrorFlag1){
									errorMsg = errorMsg+"[应收账款日期]为"+errorBillsDate+"，该日期并不存在，请重新填写；";
									errorFlag=true;
								}else{
									if (month.length() == 1) {
										month = "0" + month;
									}
									if (day.length() == 1) {
										day = "0" + day;
									}
									billsDate = year + month + day;
									//这里防止填写非闰月出现2.29号或者小月出现31号这种错误数据(已经调到前面去了)
									SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
									Date startDate2=null;
									String formatstartDate="";
									try {
										startDate2 = simpleDateFormat.parse(billsDate);
										formatstartDate= simpleDateFormat.format(startDate2);
									} catch (ParseException e) {
										e.printStackTrace();
									}
									//说明日期解析失败
									if(startDate2==null){
										if(year.length() > 4){
											errorMsg = errorMsg+"[应收账款日期]中年份过大，请重新填写；";
											errorFlag=true;
										}else{
											errorMsg = errorMsg+"[应收账款日期]解析失败，请重新填写；";
											errorFlag=true;	
										}
									}else{
										//解析之后的日期与原来的日期不等，说明日期不对，不存在。
										if(!billsDate.equals(formatstartDate)){
											errorMsg = errorMsg+"[应收账款日期]为"+errorBillsDate+"，该日期并不存在，请重新填写；";
											errorFlag=true;
										}else{
											rBcpDebtInfoVO.setBillsDate(billsDate);
											// 日期的其他校验都给后面，这里只做基本的格式校验
										}
									}
								}
							}
						}
					}
				}else{
					errorMsg =errorMsg+ "[应收账款日期]不可为空；";
					errorFlag=true;
				}
				// 票面金额
				if (r.getCell(6) != null) {
					billsAmountView = r.getCell(6).toString();
					billsAmountView = sustringZero(billsAmountView);
					if (StringUtils.isBlank(billsAmountView)) {
						errorMsg =errorMsg+ "[票面金额]不可为空；";
						errorFlag=true;
					}else{
						// 首先是必须是数值类型，不是则需要报错。不得小于等于0
						try {
							BigDecimal bigDecimal1 = new BigDecimal(billsAmountView);
							if (bigDecimal1.compareTo(BigDecimal.ZERO) <= 0) {
								errorMsg =errorMsg+ "[票面金额]必须大于0；";
								errorFlag=true;
							}
						} catch (Exception e) {
							errorMsg = errorMsg+"[票面金额]必须为数值类型；";
							errorFormat=true;
							errorFlag=true;
						}
					}
				}else{
					errorMsg =errorMsg+ "[票面金额]不可为空；";
					errorFlag=true;
				}
				// 有效金额
				if (r.getCell(7) != null) {
					billsAmount = r.getCell(7).toString();
					billsAmount = sustringZero(billsAmount);
					// billsAmount = r.getCell(7).getStringCellValue();
					if (StringUtils.isBlank(billsAmount)) {
						errorMsg =errorMsg+ "[有效金额]不可为空；";
						errorFlag=true;
					}else{
						// 首先是必须是数值类型，不是则需要报错。不得小于等于0
						try {
							BigDecimal bigDecimal2 = new BigDecimal(billsAmount);
							if (bigDecimal2.compareTo(BigDecimal.ZERO) <= 0) {
								errorMsg = errorMsg+"[有效金额]必须大于0；";
								errorFlag=true;
							}
						} catch (Exception e) {
							errorMsg =errorMsg+ "[有效金额]必须为数值类型；";
							errorFormat=true;
							errorFlag=true;
						}
					}
				}else{
					errorMsg =errorMsg+ "[有效金额]不可为空；";
					errorFlag=true;
				}
				// 备注
				if (r.getCell(8) != null) {
					memo = r.getCell(8).toString();
					if (StringUtils.isNotBlank(memo)) {
						if (memo.length() > 160) {// 这里限制为160个字符。
							errorMsg =errorMsg+ "[备注]需控制在150字以内；";
							errorFlag=true;
						}
						rBcpDebtInfoVO.setMemo(memo);
					}
				}
				if(StringUtils.isNotBlank(billsAmountView)&&StringUtils.isNotBlank(billsAmount)){
					//防止不为整数类型还无法计算。
					if(!errorFormat){
						BigDecimal billsAmountView2 = new BigDecimal(billsAmountView);
						BigDecimal billsAmount2 = new BigDecimal(billsAmount);
						if (billsAmountView2.compareTo(billsAmount2) < 0) {
							errorMsg =errorMsg+ "[有效金额]不得大于[票面金额]；";
							errorFlag=true;
						}else{
							rBcpDebtInfoVO.setBillsAmountView(billsAmountView2);
							rBcpDebtInfoVO.setBillsAmount(billsAmount2);
						}
					}
				}
				
				if(errorFlag){
					errorMsg="第"+(i+1)+"行数据"+errorMsg;
					errorMessageDetail=errorMessageDetail+errorMsg;
					errorMsg="";
					errorFlag=false;
				}else{
					rBcpDebtInfoList.add(rBcpDebtInfoVO);
				}
			}
			//数据基本格式校验
			if(StringUtils.isNotEmpty(errorMessageDetail)){
				if(errorMessageDetail.length() > 300){
					errorMessageDetail=errorMessageDetail.substring(0,500)+"...";
				}
				return errorMessageDetail;
			}
			wb.close();
			String mastContno = paramMap.get("mastContno");
			// 这里要写下校验规则(各种最重要的规则基本都在这里，上述只是基本格式校验。)
			Object checkInfo = transferApplyService.checkUploadDebtListRule(rBcpDebtInfoList, mastContno);
			return checkInfo;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ScubeBizException("");
		} catch (IOException e) {
			e.printStackTrace();
			throw new ScubeBizException("");
		}
	}

	// 去除".0"
	public String sustringZero(String key) {
		if (StringUtils.isNotEmpty(key)) {
			if (key.contains(".0")) {
				key.replace(".0", "");
				return key;
			} else {
				return key;
			}
		} else {
			return key;
		}
	}

}
