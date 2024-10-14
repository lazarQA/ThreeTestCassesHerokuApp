package Tests;

import Base.BaseTest;
import Pages.AddRemoveElementsPage;
import Pages.CheckBoxesPage;
import Pages.FloatingMenuPage;
import Pages.HomePagePage;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class TheInternetHerokuAppTests extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        js = ((JavascriptExecutor) driver);

        homePagePage = new HomePagePage(driver);
        checkBoxes=new CheckBoxesPage(driver);
        addRemoveElements=new AddRemoveElementsPage(driver);
        floatingMenuPage=new FloatingMenuPage(driver);
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    @Test
    public void checkBoxesClickable() {
        homePagePage.clickCheckBoxes();
        for (int i = 0; i < checkBoxes.getCheckboxes().size(); i++) {
            WebElement currentCheckbox = checkBoxes.getCheckboxes().get(i);
            wait.until(ExpectedConditions.elementToBeClickable(currentCheckbox));
        }
        Assert.assertFalse(checkBoxes.getCheckboxes().get(0).isSelected());
        Assert.assertTrue(checkBoxes.getCheckboxes().get(1).isSelected());
        checkBoxes.clickCheckboxes(0);
        checkBoxes.clickCheckboxes(1);
        Assert.assertTrue(checkBoxes.getCheckboxes().get(0).isSelected());
        Assert.assertFalse(checkBoxes.getCheckboxes().get(1).isSelected());
    }

    @Test(priority = 1)
    public void userCanAddAndRemoveItems()  {
        homePagePage.clickGetAddRemoveElements();
        //asertacija da je na pocutku lista elemenata prazna
        boolean isPresent = false;
        try {
            isPresent = addRemoveElements.getAddedElements().getFirst().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(isPresent);
        //dodajemo odredjeni broj elemeneta zatim se radi asertacija da lista ima onoliko elemenata koliko je receno da bude dodat0
        //stavio sam da index ubacenih elemenata prikazuje onoliko elemenata koliko ce biti dodato
        //a ne index-1, radi lakseg koriscenja
        addRemoveElements.clickGetAddElements(4);
        for (int i = 0; i < addRemoveElements.getAddedElements().size(); i++) {
            WebElement trenutniElement = addRemoveElements.getAddedElements().get(i);
            Assert.assertTrue(trenutniElement.isDisplayed());
        }

        //brisu se svi elementi i opet se radi asertacija da je lista prazna
        for (int i = addRemoveElements.getAddedElements().size() - 1; i >= 0; i--) {
            WebElement trenutniElement = addRemoveElements.getAddedElements().get(i);
            trenutniElement.click();
        }
        try {
            isPresent = addRemoveElements.getAddedElements().getFirst().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(isPresent);

        addRemoveElements.clickGetAddElements(4);
        wait.until(ExpectedConditions.visibilityOf(addRemoveElements.getAddedElements().get(3)));
        addRemoveElements.deleteAddedElements(2);
        int expectedNumberOfElements = 3;
        Assert.assertEquals(addRemoveElements.getAddedElements().size(), expectedNumberOfElements);

    }


    @Test (priority = 2)
    public void userCanSeeAndClickFloatingMenuWhenScrolling()  {
        homePagePage.clickFloatingMenu();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/floating_menu");
        Assert.assertTrue(floatingMenuPage.getFloatingMenu().isDisplayed());
        ArrayList<WebElement> elementsOfMenu = floatingMenuPage.getWebElements();
        for (WebElement a:elementsOfMenu){
            Assert.assertTrue(a.isDisplayed());
        }
        Assert.assertTrue(floatingMenuPage.getFloatingMenuHeader().getText().contains("Floating Menu"));
        floatingMenuPage.clickFloatingMenuHome();
        Assert.assertEquals(driver.getCurrentUrl(),floatingMenuPage.getFloatingMenuHomeUrl());
        floatingMenuPage.clickFloatingMenuNews();
        Assert.assertEquals(driver.getCurrentUrl(),floatingMenuPage.getFloatingMenuNewsUrl());
        floatingMenuPage.clickFloatingMenuContact();
        Assert.assertEquals(driver.getCurrentUrl(),floatingMenuPage.getFloatingMenuContactUrl());
        floatingMenuPage.clickFloatingMenuAbout();
        Assert.assertEquals(driver.getCurrentUrl(),floatingMenuPage.getFloatingMenuAboutUrl());

        js.executeScript("window.scrollBy(0,650)", "");
        for (WebElement a:elementsOfMenu){
            Assert.assertTrue(a.isDisplayed());
        }
        floatingMenuPage.clickFloatingMenuHome();
        floatingMenuPage.clickFloatingMenuHome();
        Assert.assertEquals(driver.getCurrentUrl(),floatingMenuPage.getFloatingMenuHomeUrl());
        floatingMenuPage.clickFloatingMenuNews();
        Assert.assertEquals(driver.getCurrentUrl(),floatingMenuPage.getFloatingMenuNewsUrl());
        floatingMenuPage.clickFloatingMenuContact();
        Assert.assertEquals(driver.getCurrentUrl(),floatingMenuPage.getFloatingMenuContactUrl());
        floatingMenuPage.clickFloatingMenuAbout();
        Assert.assertEquals(driver.getCurrentUrl(),floatingMenuPage.getFloatingMenuAboutUrl());

    }



    @AfterMethod
    public void tearDown() {
      driver.quit();
    }

    

}
