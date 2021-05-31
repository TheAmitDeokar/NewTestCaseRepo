package QK1.TestCaseProject.Pages;

import org.openqa.selenium.WebElement;

import QK1.FrameworkAPI.WebTest;
import QK1.FrameworkAPI.Utilities.JavaUtilities;




public class LoginPage 
{
	

	WebTest T;
	public LoginPage(String BrowserName)
	{
		T=new WebTest();
		JavaUtilities.ReadEnvVars();
		T.StartTest(BrowserName);
		T.CreateObjectRepository("LoginPage");
	}
	public void DoLogin(String UserName,String Password)
	{
		
		T.EnterText(T.ObjectRepo.get("UserNameField"),UserName);
		
		T.EnterText(T.ObjectRepo.get("PasswordField"),Password);
		
		T.ClickElement(T.ObjectRepo.get("LoginButton"));
	}
	
	public String GetLoginError()
	{
		WebElement ErrorElement=T.FindAndReturnElement("BY_ID", "spanMessage");
		String LoginError=T.GetElementText(ErrorElement);
		return LoginError;
	}

}
