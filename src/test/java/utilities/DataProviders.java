package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	//DataProvider 1
	@DataProvider(name="LoginData")
	public String[][]getData() throws IOException
	{
		String path = System.getProperty("user.dir") + "\\testData\\Opencart_LoginData.xlsx";
         //taking xl file from testData
		ExcelUtility xlutil=new ExcelUtility(path);//create an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		String logindata[][]=new String[totalrows][totalcols];//create two dimension array which can store
		for(int i=1;i<=totalrows;i++)//1 read the data from xl storing in the two dimension array
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;//return two dimension array
		
	}
	
	//DataProvider 2
	//DataProvider 3....
	
	
	
	
	
	
	
}
