//package com.gzdata.common.util;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.util.StringUtils;
//
//import com.gzdata.core.model.DecclarInfor;
///**
// * Excel工具类
// * 
// *
// * @author 张兵帅
// *
// * @version 
// *
// * @since 2018年4月17日
// */
//public class ExcelPOIUtil {
//
//	/*public static void main(String[] args) {
//		
//		System.out.println(new Date().toLocaleString());
//
//		ExcelPOIUtil ept = new ExcelPOIUtil();
//		List<DecclarInfor> list = ept
//				.readExcelData("D:\\develop tools\\git\\nhfpc-manager\\src\\main\\webapp\\upload\\down_tpl.xlsx");
//		System.out.println(list.size());
//		for (DecclarInfor stu : list) {
//			System.out.println("省份："+stu.getDeclarProvince());
//			System.out.println("制作时间："+stu.getProductTime());
//		}
//
////		String[] titleRow = { "省份", "制作时间"};//, "Age", "分数" 
////		ept.writeExcelData("D:\\develop tools\\excel test\\test2.xlsx", list, titleRow);
//		System.out.println("----------------excel 读取结束------------------------");
//	}*/
//	
//	// 文件保存目录URL
////	private static String saveUrl0 = WebUtil.getHttpServletRequest().getContextPath() + "/upload/";
//		
//	/**
//	 * 
//	 * 功能描述：读取excel数据
//	 *
//	 * @param fileName即文件的全路径
//	 * @return
//	 * 
//	 * @author 张兵帅
//	 *
//	 * @since 2018年4月17日
//	 *
//	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
//	 */
//	public List<DecclarInfor> readExcelData(String fileName) {
//		List<DecclarInfor> list = new ArrayList<DecclarInfor>();
//		DecclarInfor student = null;
//		FileInputStream fis = null;
//		try {
//			// Create the input stream from the xlsx/xls file
//			fis = new FileInputStream(fileName);
//			// Create Workbook instance for xlsx/xls file input stream
//			Workbook workbook = null;
//			if (fileName.toLowerCase().endsWith(".xlsx")) {
//				workbook = new XSSFWorkbook(fis);
//			} else if (fileName.toLowerCase().endsWith(".xls")) {
//				workbook = new HSSFWorkbook(fis);
//			}
//			Sheet sheet = null;
//			Row row = null;
//			Integer succ = 0;
//			Integer errNum = 0;
//			Integer count = 0;
//			String errorInfo = "";
//			if (workbook != null) {
//				for (int i = 0; i < workbook.getNumberOfSheets(); i++) {// 循环表
//					sheet = workbook.getSheetAt(i);// 第i张表格
//					for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {// 循环行
//						// row.getPhysicalNumberOfCells(); //列数
//						if (errNum >= 20) {
//							break;
//						}
//						row = sheet.getRow(j);
//						if (row == null) {
//							break;
//						}
//						;// 判断行是否还有数据
//						if (StringUtils.isEmpty(getCellVaule(row.getCell(0)))) {
//							break;
//						}
//						;
//						++count;
//						student = new DecclarInfor();
//						int index = 0;// 表 列索引
//						student.setDeclarProvince(getCellVaule(row.getCell(index)));//申报身份
//						student.setProductTime(DateUtil.parseDate(convertCellToString(row.getCell(++index))));//制作时间
//					    student.setReleaseTime(DateUtil.parseDate(convertCellToString(row.getCell(++index))));//上映时间
////						System.out.println("时间格式1："+convertCellToString(row.getCell(++index)));
////						System.out.println("时间格式2："+convertCellToString(row.getCell(++index)));
//					    student.setApproveUnit(getCellVaule(row.getCell(++index)));//批准单位
//					   
//					    student.setProductionName(getCellVaule(row.getCell(++index)));//作品名称
//					    student.setProductionLength(getCellVaule(row.getCell(++index)));//长度
//					    student.setProductionTopic(getCellVaule(row.getCell(++index)));//主题
//					    student.setProductionType(getCellVaule(row.getCell(++index)));//类别
//					   
//					    student.setProductPerson(getCellVaule(row.getCell(++index)));//制作参与人
//					    student.setAuthorUnit(getCellVaule(row.getCell(++index)));//作者单位
//					    student.setAuthoPhone(getCellVaule(row.getCell(++index)));//作者手机号
//					    student.setAuthorEmail(getCellVaule(row.getCell(++index)));//作者email
//					    
//					    student.setContent(getCellVaule(row.getCell(++index)));//内容简介
//					    student.setSkydriveAddress(getCellVaule(row.getCell(++index)));//网盘地址
//					    student.setDeclareUnit(getCellVaule(row.getCell(++index)));//报送单位
//					    student.setBsrAddress(getCellVaule(row.getCell(++index)));//报送地址
//					   
//					    student.setBsrConcat(getCellVaule(row.getCell(++index)));//bsr联系人
//					    student.setBsrPhone(getCellVaule(row.getCell(++index)));//电话
//					    student.setBsrPostCode(getCellVaule(row.getCell(++index)));//邮编
//					    student.setBsrEmail(getCellVaule(row.getCell(++index)));//电子邮件
//					   
//					    student.setBsrRecommendAtion(getCellVaule(row.getCell(++index)));//推荐意见
//					    student.setBsrRemark(getCellVaule(row.getCell(++index)));//备注
//					    student.setRegisterAccout(getCellVaule(row.getCell(++index)));//注册账号
//					    student.setSubmitState("已确认");//评选结果
//					    student.setCreateTime(DateUtil.getNow());//创建时间
//						
//						list.add(student);
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (fis != null) {
//				try {
//					fis.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return list;
//	}
//	/**
//	 * 
//	 * 功能描述：得到单元值
//	 *
//	 * @param cell
//	 * @return
//	 * 
//	 * @author 张兵帅
//	 *
//	 * @since 2018年4月17日
//	 *
//	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
//	 */
//	public String getCellVaule(Cell cell) {
//		String value = null;
//		if (cell == null)
//			return value;
//		switch (cell.getCellType()) {
//		case Cell.CELL_TYPE_STRING:
//			value = cell.getRichStringCellValue().toString();
//			break;
//		case Cell.CELL_TYPE_NUMERIC:
//			value = new DecimalFormat("0.######").format(cell
//					.getNumericCellValue());
//			break;
//		case Cell.CELL_TYPE_BOOLEAN:
//			value = String.valueOf(cell.getBooleanCellValue());
//			break;
//		case Cell.CELL_TYPE_FORMULA:
//			value = cell.getArrayFormulaRange().formatAsString();
//			break;
//		case Cell.CELL_TYPE_BLANK:
//			value = "";
//			break;
//		default:
//			value = cell.getRichStringCellValue().toString();
//			break;
//		}
//		if (value == null)
//			return null;
//		return value;
//	}
//	/**
//	 * 
//	 * 功能描述：写入Excel数据
//	 *
//	 * @param excelPath
//	 * @param list
//	 * @param titleRow
//	 * 
//	 * @author 张兵帅
//	 *
//	 * @since 2018年4月17日
//	 *
//	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
//	 */
//	public void writeExcelData(String excelPath, List<DecclarInfor> list,
//			String titleRow[]) {
//		Workbook workbook = null;
//		Sheet sheet = null;
//		FileOutputStream out = null;
//		try {
//			File file = new File(excelPath);
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//			if (excelPath.toLowerCase().endsWith(".xls")) {
//				workbook = new HSSFWorkbook();
//			} else if (excelPath.toLowerCase().endsWith(".xlsx")) {
//				workbook = new XSSFWorkbook();
//			}
//			sheet = workbook.createSheet("Sheet1");// 创建第一张表
//			// sheet.setDefaultColumnWidth((short)15);
//			int rowNumber = sheet.getLastRowNum(); // 第一行从0开始算
//			// System.out.println("原始数据总行数，除属性列：" + rowNumber);
//			for (int i = 1; i <= rowNumber; i++) {// 删除原有Excel文件
//				Row row = sheet.getRow(i);
//				sheet.removeRow(row);
//			}
//			Row row = sheet.createRow(0);// 创建第一行 列属性(表头)
//			for (int i = 0; i < titleRow.length; i++) {// 写 第一行
//				row.createCell(i).setCellValue(titleRow[i]);
//			}
//			for (int i = 0; i < list.size(); i++) {// 写数据
//				int lastRowNum = sheet.getLastRowNum();
//				Row currentRow = sheet.createRow(lastRowNum + 1);
//				int index = 0;// 写 第i列
//				while (index < titleRow.length) {
//					currentRow.createCell(index++).setCellValue(
//							list.get(i).getDeclarProvince());
//					currentRow.createCell(index++).setCellValue(
//							list.get(i).getProductTime());
//					/*currentRow.createCell(index++).setCellValue(
//							list.get(i).getAge().toString());
//					currentRow.createCell(index++).setCellValue(
//							list.get(i).getScore().toString());*/
//				}
//			}
//			out = new FileOutputStream(file);
//			workbook.write(out);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (out != null) {
//					out.flush();
//					out.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("数据导出成功");
//	}
//	
//	/**
//     * 分多种格式解析单元格的值
//     *
//     * @param cell  单元格
//     * @return  单元格的值
//     */
//    public static String convertCellToString(Cell cell){
//        //如果为null会抛出异常，应当返回空字符串
//        if (cell == null)
//            return "";
//
//        //POI对单元格日期处理很弱，没有针对的类型，日期类型取出来的也是一个double值，所以同样作为数值类型
//        //解决日期2006/11/02格式读入后出错的问题，POI读取后变成“02-十一月-2006”格式
//        if(cell.toString().contains("-") && checkDate(cell.toString())){
//            String ans = "";
//            try {
//                ans = new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue());
//            } catch (Exception e) {
//                ans = cell.toString();
//            }
//            return ans;
//        }
//
//        cell.setCellType(CellType.STRING);
//        return cell.getStringCellValue();
//    }
//
//    /**
//     * 判断是否是“02-十一月-2006”格式的日期类型
//     */
//    private static boolean checkDate(String str){
//        String[] dataArr =str.split("-");
//        try {
//            if(dataArr.length == 3){
//                int x = Integer.parseInt(dataArr[0]);
//                String y =  dataArr[1];
//                int z = Integer.parseInt(dataArr[2]);
//                if(x>0 && x<32 && z>0 && z< 10000 && y.endsWith("月")){
//                    return true;
//                }
//            }
//        } catch (Exception e) {
//            return false;
//        }
//        return false;
//    }
//}
