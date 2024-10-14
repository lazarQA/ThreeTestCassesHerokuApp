package Base;

import Pages.AddRemoveElementsPage;
import Pages.CheckBoxesPage;
import Pages.FloatingMenuPage;
import Pages.HomePagePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public HomePagePage homePagePage;
    public CheckBoxesPage checkBoxes;
    public AddRemoveElementsPage addRemoveElements;
    public FloatingMenuPage floatingMenuPage;
    public JavascriptExecutor js;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

    }

}
