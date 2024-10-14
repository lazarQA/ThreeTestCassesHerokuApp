package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemoveElementsPage extends BaseTest {
    WebDriver driver;
    WebElement addElements;
    List<WebElement> addedElements;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddElements() {
        return driver.findElement(By.cssSelector("button[onclick='addElement()']"));
    }

    public void clickGetAddElements(int index) {
        if (index < 1) {
            System.out.println("Unos je manji od 0, unesite koliko elemeneta zelite da dodate");
        } else {
            for (int i = 1; i <= index; i++) {
                getAddElements().click();
            }
        }
    }

    public List<WebElement> getAddedElements() {
        return driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
    }

    public void deleteAddedElements(int index) {
        if (index > 0 && index < getAddedElements().size()) {
            getAddedElements().get(index).click();
        }
    }
}
