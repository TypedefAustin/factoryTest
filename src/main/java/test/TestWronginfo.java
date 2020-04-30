package test;

import PageFactory.TestfireHomePage;
import PageFactory.TestfireLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//输入错误账号密码是否能登陆

public class TestWronginfo {
    WebDriver driver;
    TestfireLogin objLogin;
    TestfireHomePage objHomePage;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:/Users/Administrator/Desktop/POMExample/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.testfire.net/login.jsp");
    }

    /**
     * This test go to http://demo.guru99.com/V4/
     * Verify login page title as guru99 bank
     * Login to application
     * Verify the home page using Dashboard message
     */
    @Test(priority=3)
    public void test_press(){
        //Create Login Page object
        objLogin = new TestfireLogin(driver);
        //Verify login page title
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("online banking login"));
        //login to application
        objLogin.loginToTestfire("admin1", "admin1");//输入错误账号密码
        // go the next page
        objHomePage = new TestfireHomePage(driver);
        //Verify home page
        System.out.println(objHomePage.getHomePageDashboardloginfailed().toLowerCase());
        Assert.assertTrue(objHomePage.getHomePageDashboardloginfailed().toLowerCase().contains("login failed"));//登陆失败测试
    }
}