package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	
	@DataProvider(name="LoginData")
	public String[][] getLoginData() throws IOException
	{
		String path=".\\testData\\LoginData.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int rowcount=xlutil.getRowCount("Sheet1");
		int colscount=xlutil.getCellCount("Sheet1", 1);
		
		String[][] LoginData=new String[rowcount][colscount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colscount;j++)
			{
				LoginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return LoginData;
		
	}
	

}
