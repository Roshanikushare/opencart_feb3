package utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

public class dataProviders {

	@DataProvider(name="LoginData")
		
		public String[][] getData() throws IOException
		{
		//	String path=".//testData//fcb.xlsx";    //taking xl file from testdata
			String path="C:\\Selenium\\Excel\\fcb.xlsx";
			ExcelUtility xlutil=new ExcelUtility(path);   //create an obj of excelutility
			int totalrows=xlutil.getRowCount("sheet1");
			int totalcols=xlutil.getCellCount("sheet1",1);
			
			String logindata[][]=new String[totalrows][totalcols];
			
			for(int i=1;i<=totalrows;i++)
			{
				for(int j=0;j<totalcols;j++)
				{
					logindata[i-1][j]=xlutil.getCellData("sheet1",i,j);
				}
			}
			return logindata;    //return 2 dimensional array;		
				
		}
}
