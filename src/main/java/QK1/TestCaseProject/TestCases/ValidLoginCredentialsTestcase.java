package QK1.TestCaseProject.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import QK1.TestCaseProject.Pages.LoginPage;

public class ValidLoginCredentialsTestcase 
{
	LoginPage loginpage;
	@BeforeClass
	@Parameters({"Browser"})
	public void Init(String Br)
	{
		loginpage=new LoginPage(Br);
		
	}
	
	@Test(priority=1)
	public void TestLoginWithValidCrdentials()
	{
		
		loginpage.DoLogin("Admin", "admin123");
	}

}
