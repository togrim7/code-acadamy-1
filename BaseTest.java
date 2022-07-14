package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Volumes/Mac HDD/Code Academy QA/Selenium/test_project/TestProject/lib/chromedriver");
        //System.setProperty("webdriver.gecko.driver", "/Volumes/Mac HDD/Code Academy QA/Selenium/test_project/TestProject/lib/geckodriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       //chrome_options = Options();
       //chrome_options.add_argument("headless");
       //driver = webdriver.Chrome(options=chrome_options);
    }

    @After
    public void teardown(){
        driver.quit();
    }
    
}
