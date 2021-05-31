package QK1.TestCaseProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import QK1.FrameworkAPI.Utilities.JavaUtilities;
import QK1.TestCaseProject.Pages.LoginPage;


public class InvalidLoginTestCases 
{
	LoginPage loginpage;
	@BeforeClass
	@Parameters({"Browser"})
	public void Init(String Br)
	{
		loginpage=new LoginPage(Br);
		
	}
	
	
	@Test(priority=1,dataProvider="ProvideInvalidCredentialsFromExcel")
	public void TestLoginWithInValidCrdentials(String UserName,String Password,String LoginError)
	{
		
		
		loginpage.DoLogin(UserName, Password);
		String CurrentError=loginpage.GetLoginError();
		
		Assert.assertEquals(CurrentError, LoginError);
	}
	
	

	@DataProvider
	public Object[][] ProvideInvalidCredentialsFromExcel()
	{
		String[][]Credentials=JavaUtilities.ReadDataFromExcel("LoginTestData");
		return Credentials;
	}
	@DataProvider
	public Object[][] ProvideInvalidCredentials()
	{
		String[][]Credentials=new String[4][3];
		
		Credentials[0][0]="Admin";
		Credentials[0][1]="";
		Credentials[0][2]="Password cannot be empty";
		
		
		Credentials[1][0]="";
		Credentials[1][1]="admin123";
		Credentials[1][2]="Username cannot be empty";
		

		
		Credentials[2][0]="";
		Credentials[2][1]="";
		Credentials[2][2]="Username cannot be empty";

		
		Credentials[3][0]="Amit";
		Credentials[3][1]="Deokar";
		Credentials[3][2]="Invalid credentials";

		return Credentials;
	}

}
