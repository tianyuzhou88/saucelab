package page;

import core.ultils.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TwitterLoginPage implements Page {
    protected WebDriver driver;

    public TwitterLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    //webelements for use
    @FindBy(css="#page-container input[name='session[username_or_email]']")
    WebElement username;

    @FindBy(css="#page-container input[name='session[password]']")
    WebElement password;

    @FindBy(css="div button[type='submit']")
    WebElement submit;

    //methods
    public HomePage login(String _username, String _password){
        username.sendKeys(_username);
        password.sendKeys(_password);
        submit.click();
        return new HomePage(driver);
    }

    @Override
    public Boolean isAt() {
        return submit.isDisplayed();
    }
}
