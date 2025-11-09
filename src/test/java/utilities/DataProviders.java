package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	@DataProvider(name="LoginData")
	
	public String[][] getData() throws IOException
	{
		String path = ".\\testData\\MediMention_LoginData.xlsx";
		ExcelUtility xlutils = new ExcelUtility(path);
		
		int totlaRows = xlutils.getRowCount("Sheet1");
		int titalCol = xlutils.getCellCount("Sheet1",1);
		
		String LoginData[][] = new String[totlaRows][titalCol];  
		
		for (int i = 1; i <= totlaRows; i++)
		{
			for (int j = 0; j<titalCol; j++ )
			{
				LoginData[i-1][j] = xlutils.getCellData("Sheet1", i, j);
			}
		}
		return LoginData;
	}
	
	//DataProvider 2
		@DataProvider(name="LoginValidData")
		
		public String[][] getValidData() throws IOException
		{
			String path = ".\\testData\\user_credentials.xlsx";
			ExcelUtility xlutils = new ExcelUtility(path);
			
			int totlaRows = xlutils.getRowCount("Sheet1");
			int titalCol = xlutils.getCellCount("Sheet1",1);
			
			String LoginData[][] = new String[totlaRows][titalCol];  
			
			for (int i = 1; i <= totlaRows; i++)
			{
				for (int j = 0; j<titalCol; j++ )
				{
					LoginData[i-1][j] = xlutils.getCellData("Sheet1", i, j);
				}
			}
			return LoginData;
		}
		
		//DataProvider 3
				@DataProvider(name="LoginwithInValidData")
				
				public String[][] getValidandInvalidData() throws IOException
				{
					String path = ".\\testData\\user_credentials_with_invalid.xlsx";
					ExcelUtility xlutils = new ExcelUtility(path);
					
					int totlaRows = xlutils.getRowCount("Sheet1");
					int titalCol = xlutils.getCellCount("Sheet1",1);
					
					String LoginData[][] = new String[totlaRows][titalCol];  
					
					for (int i = 1; i <= totlaRows; i++)
					{
						for (int j = 0; j<titalCol; j++ )
						{
							LoginData[i-1][j] = xlutils.getCellData("Sheet1", i, j);
						}
					}
					return LoginData;
				}
	
	//DataProvider 4
		@DataProvider(name="RegistrationData")
		
		public String[][] getData2() throws IOException
		{
			String path2 = ".\\testData\\ResisterData.xlsx";
			ExcelUtility xlutils = new ExcelUtility(path2);
			
			int totlaRows = xlutils.getRowCount("data");
			int titalCol = xlutils.getCellCount("data",1);
			
			String LoginData[][] = new String[totlaRows][titalCol];  
			
			for (int i = 1; i <= totlaRows; i++)
			{
				for (int j = 0; j<titalCol; j++ )
				{
					LoginData[i-1][j] = xlutils.getCellData("data", i, j);
				}
			}
			return LoginData;
		}

}
