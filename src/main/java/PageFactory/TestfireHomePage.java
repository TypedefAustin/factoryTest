package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestfireHomePage {

	WebDriver driver;
	//@FindBy(xpath="//table//tr[@class='heading3']")
	@FindBy(xpath="//td//span[@id='_ctl0__ctl0_Content_Main_promo']")
	WebElement homePageUserName;
	
	public TestfireHomePage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Get the User name from Home Page
		public String getHomePageDashboardUserName(){
		 return	homePageUserName.getText();
		}
}
