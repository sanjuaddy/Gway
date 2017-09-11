package bg.testutils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	static Xls_Reader xlsFile=null;
	static String testName=null;
	static String[][] tabArray=null;
	//static String className;

	//set fileLocation, sheetName, className;
	public void setUp(String fileLocation, String sheetName) throws IOException{
		xlsFile=new Xls_Reader(fileLocation);
		testName=sheetName;
		//className=myClassName;		
	}
	//Get data from excel
	public static String[][] getData(){
		int endRow, endCol;
		endRow=xlsFile.getRowCount(testName);
		endCol=xlsFile.getColumnCount(testName);
		tabArray=new String[endRow-1][endCol];
		endCol--;
		int newRowIndex=0;
		for(int cellRow=2;cellRow<=endRow;cellRow++)
		{
			//if(xlsFile.getCellData(testName, 0, cellRow).equals(className))
			//{
				for(int cellColoumn=0;cellColoumn<=endCol;cellColoumn++)
				{
					tabArray[newRowIndex][cellColoumn]=xlsFile.getCellData(testName, cellColoumn, cellRow);
				}
				newRowIndex+=1;
			//}
	}
	String[][]newTabArray=new String[newRowIndex][endCol+1];
	for(int cellRow=0;cellRow<newRowIndex;cellRow++){
		for(int cellColoumn=0;cellColoumn<endCol+1;cellColoumn++){
			newTabArray[cellRow][cellColoumn]=tabArray[cellRow][cellColoumn];	
		}
	}
	return (newTabArray);
	}
	//Create dataprovider
	@DataProvider(name="xlsData")
	public static Object[][] createData1(){
		System.out.println("Data");
		Object[][]retObjArr=getData();
		return retObjArr;
		
	}

}
