package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class DataProviders {

	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path =".\\testData\\LoginDDT_Data.xlsx";
		UtilityFile utilfile = new UtilityFile(path);
		int totalrows= utilfile.getRowCount("Sheet1");
		int totalcols = utilfile.getCellCount("Sheet1",0);
		 System.out.println("Excel Path: " + path);
	      System.out.println("Total Rows: " + totalrows + ", Total Columns: " + totalcols);
		
		String logindata [] [] = new String [totalrows][totalcols];
		
		for (int i = 1; i<=totalrows; i++)
		{
			for (int j=0; j<totalcols; j++)
			{
				
				 String cellData =utilfile.getCellData("Sheet1", i, j);
				 logindata[i-1][j] = cellData;
				  System.out.println("Row " + i + " Col " + j + " = " + cellData);
			}
		}
		return logindata;
	}

}
