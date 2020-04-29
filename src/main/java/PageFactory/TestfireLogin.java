package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TestfireLogin {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	@FindBy(name="uid")
	WebElement userTestfireName;
	
	@FindBy(name="passw")
	WebElement passwordTestfire;

	@FindBy(xpath="/html/body/table/tbody/tr[2]/td[2]/div/h1")
	WebElement titleText;
	
	@FindBy(name="btnSubmit")
	WebElement login;
	
	public TestfireLogin(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	//Set user name in textbox
	public void setUserName(String strUserName){
		userTestfireName.sendKeys(strUserName);
		
	}
	
	//Set password in password textbox
	public void setPassword(String strPassword){
	passwordTestfire.sendKeys(strPassword);
	}
	
	//Click on login button
	public void clickLogin(){
			login.click();
	}
	
	//Get the title of Login Page
	public String getLoginTitle(){
	 return	titleText.getText();
	}
	/**
	 * This POM method will be exposed in test case to login in the application
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */
	public void loginToTestfire(String strUserName, String strPasword){
		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPassword(strPasword);
		//Click Login button
		this.clickLogin();
				
	}
}
