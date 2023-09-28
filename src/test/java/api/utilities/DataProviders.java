package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//Get all the data from excel and store in 2D array
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException {
		String path = System.getProperty("user.dir") + "//testData//UserData.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		
		int rowNum = xl.getRowCount("Sheet1");
		int colNum = xl.getCellCount("Sheet1",1);
		
		String apiData[][] = new String[rowNum][colNum];
		
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				apiData[i-1][j] = xl.getCellData("Sheet1",i,j);
			}
		}
		
		return apiData;
	}

	
	
	//Get all usernames from excel
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException {
		String path = System.getProperty("user.dir") + "//testData//UserData.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		
		int rowNum = xl.getRowCount("Sheet1");
		
		
		String apiData[] = new String[rowNum];
		
		for(int i=1;i<=rowNum;i++) {			
				apiData[i-1] = xl.getCellData("Sheet1",i,1);			
		}
		
		return apiData;
	}
}
