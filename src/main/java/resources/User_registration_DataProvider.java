package resources;

import org.testng.annotations.DataProvider;

public class User_registration_DataProvider {

	//make it static so that we can use it another class with class name

	@DataProvider(name="registrationdatprovider")
	public static Object[][] getData()
	{
		Object [][] data=new Object [5][6];

		data[0][0]="Rahul";
		data[0][1]="Kumar";
		data[0][2]="rahul01@gmail.com";
		data[0][3]="0123456789";
		data[0][4]="password";
		data[0][5]="password";

		data[1][0]="Rahul";
		data[1][1]="Kumar";
		data[1][2]="rahul01@gmail.com";
		data[1][3]="0123456789";
		data[1][4]="password";
		data[1][5]="password";

		data[2][0]="Rahul";
		data[2][1]="Kumar";
		data[2][2]="rahul01@gmail.com";
		data[2][3]="0123456789";
		data[2][4]="password";
		data[2][5]="password";

		data[3][0]="Rahul";
		data[3][1]="Kumar";
		data[3][2]="rahul01@gmail.com";
		data[3][3]="0123456789";
		data[3][4]="password";
		data[3][5]="password";

		data[4][0]="Rahul";
		data[4][1]="Kumar";
		data[4][2]="rahul01@gmail.com";
		data[4][3]="0123456789";
		data[4][4]="password";
		data[4][5]="password";

	
		
		return data;
	}

}
