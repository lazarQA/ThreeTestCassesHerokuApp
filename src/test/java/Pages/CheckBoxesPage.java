package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesPage extends BaseTest {
    WebDriver driver;
    List<WebElement> checkboxes;

    public CheckBoxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCheckboxes() {
        return driver.findElements(By.cssSelector("input[type='checkbox']"));
    }
    public void clickCheckboxes(int index){
        if (index>=0 && index<=getCheckboxes().size()){
        getCheckboxes().get(index).click();}
        else {
            System.out.println("Broj koji ste uneli je manji od 0 ili veci od broja polja");
        }

    }

}
