package bg.testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {
	public String path;
	public FileInputStream fis=null;
	public FileOutputStream fileOut=null;
	static  XSSFWorkbook workbook=null;
	static XSSFSheet sheet=null;
	static XSSFRow row=null;
	static XSSFCell cell=null;
	public Xls_Reader(){
		
	}
	//Excel Read
	public Xls_Reader(String path){
		this.path=path;
		try{
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheetAt(0);
			fis.close();			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void createExcelFile(String path){
		FileOutputStream fos=null;
		this.path=path;
		try{
			fos=new FileOutputStream(new File(path));
			workbook=new XSSFWorkbook();
			workbook.write(fos);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//Row Count from excel
	public int getRowCount(String sheetName){
		int index=workbook.getSheetIndex(sheetName);
		if(index==-1){
			return 0;
		}
		else{
			sheet=workbook.getSheetAt(index);
			int num=sheet.getLastRowNum()+1;
			return num;
		}		
	}
	//Return the Celldata
	public String getCellData(String sheetName,String colName, int rowNum){
		try{
			if(rowNum<=0)
				return "";
			int index=workbook.getSheetIndex(sheetName);
			int col_num=-1;
			if(index==-1)
				return "";
			sheet=workbook.getSheetAt(index);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim())){
					col_num=i;
				}
			}
				if(col_num==-1)
					return "";
				sheet=workbook.getSheetAt(index);
				row=sheet.getRow(rowNum-1);
				if(row==null)
					return "";
				cell=row.getCell(col_num);
			if(cell==null)
				return "";
			if(cell.getCellType()==cell.CELL_TYPE_NUMERIC||cell.getCellType()==cell.CELL_TYPE_FORMULA){
				String cellText=String.valueOf(cell.getNumericCellValue());
				if(DateUtil.isCellDateFormatted(cell)){
					double d=cell.getNumericCellValue();
					Calendar cal=Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText=(String.valueOf(cal.get(Calendar.YEAR)).substring(2));
					cellText=cal.get(Calendar.DAY_OF_MONTH)+1+"/"+cal.get(Calendar.MONTH)+1+"/"+cellText;
				}
				return cellText;
			}else if(cell.getCellType()==cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){
			e.printStackTrace();
			return "row "+rowNum+" or column "+"does not exist in xls";
		}
	}
	//Return the Celldata
	public String getCellData(String sheetName,int colNum, int rowNum){
		try{
			if(rowNum<=0)
				return "";
			int index=workbook.getSheetIndex(sheetName);
			
			if(index==-1)
				return "";
			sheet=workbook.getSheetAt(index);
			row=sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell=row.getCell(colNum);
			if(cell==null)
				return "";
			if(cell.getCellType()== cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else
				
					if(cell.getCellType()==cell.CELL_TYPE_NUMERIC ||cell.getCellType()== cell.CELL_TYPE_FORMULA)
				{
					String cellText=String.valueOf(cell.getNumericCellValue());
					if(DateUtil.isCellDateFormatted(cell) ){
					double d=cell.getNumericCellValue();
					
					Calendar cal=Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText=(String.valueOf(cal.get(Calendar.YEAR)).substring(2));
					cellText=cal.get(Calendar.DAY_OF_MONTH)+1+"/"+cal.get(Calendar.MONTH)+1+"/"+cellText;
				}
				return cellText;
			}else if(cell.getCellType()==cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
					
					
				
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "row "+rowNum+" or column "+"does not exist in xls";
		}
		
	}
	//returns number of columns in sheet
	public int getColumnCount(String sheetName)
	{
		if(!isSheetExist(sheetName))
		{
			return -1;
		}
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(0);
		if(row==null)
		{
			return -1;
		}
		return row.getLastCellNum();
		
	}
	//find whether sheet exists
	private boolean isSheetExist(String sheetName) {
		// TODO Auto-generated method stub
		int index=workbook.getSheetIndex(sheetName);
		if(index==-1)
		{
			index=workbook.getSheetIndex(sheetName.toUpperCase());
			if(index==-1)
				return false;
			else
				return true;
		}
		return true;
	}
}
