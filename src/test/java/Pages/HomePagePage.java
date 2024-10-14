package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePagePage extends BaseTest {
    WebDriver driver;
    WebElement checkBoxes;
    WebElement addElements;
    WebElement floatingMenu;




    public HomePagePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getCheckBoxes() {
        return driver.findElement(By.cssSelector("a[href='/checkboxes']"));
    }
    public void clickCheckBoxes(){
        getCheckBoxes().click();
    }

    public WebElement getAddElements() {
        return driver.findElement(By.cssSelector("a[href='/add_remove_elements/']"));
    }
    public void clickGetAddRemoveElements(){
        getAddElements().click();
    }

    public WebElement getFloatingMenu() {
        return driver.findElement(By.cssSelector("a[href='/floating_menu']"));
    }
    public void clickFloatingMenu(){
        getFloatingMenu().click();
    }
}
