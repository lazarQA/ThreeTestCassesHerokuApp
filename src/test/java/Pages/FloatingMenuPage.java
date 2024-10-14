package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class FloatingMenuPage extends BaseTest {
    WebDriver driver;
    WebElement floatingMenu;
    WebElement floatingMenuHome;
    WebElement floatingMenuNews;
    WebElement floatingMenuContact;
    WebElement floatingMenuAbout;
    WebElement floatingMenuHeader;
    String floatingMenuHomeUrl="https://the-internet.herokuapp.com/floating_menu#home";
    String floatingMenuNewsUrl="https://the-internet.herokuapp.com/floating_menu#news";
    String floatingMenuContactUrl="https://the-internet.herokuapp.com/floating_menu#contact";
    String floatingMenuAboutUrl="https://the-internet.herokuapp.com/floating_menu#about";



    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFloatingMenu() {
        return driver.findElement(By.id("menu"));
    }

    public WebElement getFloatingMenuHome() {
        return driver.findElement(By.cssSelector("a[href='#home']"));
    }

    public WebElement getFloatingMenuNews() {
        return driver.findElement(By.cssSelector("a[href='#news']"));

    }

    public WebElement getFloatingMenuContact() {
        return driver.findElement(By.cssSelector("a[href='#contact']"));
    }

    public WebElement getFloatingMenuAbout() {
        return driver.findElement(By.cssSelector("a[href='#about']"));
    }

    public WebElement getFloatingMenuHeader() {
        return driver.findElement(By.cssSelector("h3"));
    }
    public void clickFloatingMenuHome(){
        getFloatingMenuHome().click();
    }
    public void clickFloatingMenuNews(){
        getFloatingMenuNews().click();
    }
    public void clickFloatingMenuContact(){
        getFloatingMenuContact().click();
    }
    public void clickFloatingMenuAbout(){
        getFloatingMenuAbout().click();
    }

    public String getFloatingMenuHomeUrl() {
        return floatingMenuHomeUrl;
    }

    public String getFloatingMenuNewsUrl() {
        return floatingMenuNewsUrl;
    }

    public String getFloatingMenuContactUrl() {
        return floatingMenuContactUrl;
    }

    public String getFloatingMenuAboutUrl() {
        return floatingMenuAboutUrl;
    }

    public ArrayList<WebElement> getWebElements() {
        ArrayList<WebElement> elementsOfMenu=new ArrayList<>();
        WebElement floatingMenuHomePg=getFloatingMenuHome();
        WebElement floatingMenuNewsPg=getFloatingMenuNews();
        WebElement floatingMenuContactPg=getFloatingMenuContact();
        WebElement floatingMenuAboutPg=getFloatingMenuAbout();
        elementsOfMenu.add(floatingMenuHomePg);
        elementsOfMenu.add(floatingMenuNewsPg);
        elementsOfMenu.add(floatingMenuContactPg);
        elementsOfMenu.add(floatingMenuAboutPg);
        return elementsOfMenu;
    }
}
