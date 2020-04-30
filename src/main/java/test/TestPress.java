package test;
import PageFactory.TestfireHomePage;
import PageFactory.TestfireLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
//压力测试 多次进行登陆操作是否有效
public class TestPress {
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
    @Test(priority=1)
    public void test_press(){
        //Create Login Page object
        objLogin = new TestfireLogin(driver);
        //Verify login page title
        String loginPageTitle=null;
        for(int i=0;i<=10;i++)
        {
            loginPageTitle = objLogin.getLoginTitle();  //循环刷新十次看网站是否正常运行
        }
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("online banking login"));
        //login to application
        objLogin.loginToTestfire("admin", "admin");
        // go the next page
        objHomePage = new TestfireHomePage(driver);
        //Verify home page
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("congratulations!"));
    }
}
