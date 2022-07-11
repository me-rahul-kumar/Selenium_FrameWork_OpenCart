package resources;

import org.testng.annotations.DataProvider;

public class Login_DataProvider {

	//make it static so that we can use it another class with class name

	@DataProvider(name="logindatprovider")
	public static Object[][] getData()
	{
		Object [][] data=new Object [5][4];

		data[0][0]="rahul111@gmail.com";
		data[0][1]="12345";
		data[0][2]="Valid Credentials";
		data[0][3]="Pass";

		data[1][0]="rahul112@gmail.com";
		data[1][1]="12345";
		data[1][2]="Valid Credentials";
		data[1][3]="Pass";

		data[2][0]="rahul113@gmail.com";
		data[2][1]="12345";
		data[2][2]="Valid Credentials";
		data[2][3]="Pass";

		data[3][0]="rahul114@gmail.com";
		data[3][1]="12345";
		data[3][2]="Valid Credentials";
		data[3][3]="Pass";

		data[4][0]="rahul115@gmail.com";
		data[4][1]="12345";
		data[4][2]="Invalid Credentials";
		data[4][3]="Fail";

		return data;
	}

}
