package com.epam.lab.page;
import com.epam.lab.excelutils.EnvProperties;
import com.epam.lab.singleton.SingletonDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage extends PageObject{
    private WebDriver driver = SingletonDriver.getInstance();
    private final Wait wait = new WebDriverWait(driver, 5, 1000);

    @FindBy(css = "input.whsOnd.zHQkBf")
    private WebElement loginInput;
    @FindBy(css = "span.RveJvd.snByac")
    private WebElement nextButton;
    @FindBy(css = "input.whsOnd.zHQkBf")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"passwordNext\"]/content/span")
    private WebElement logButton;

    public void typeLoginAndSubmit(String login) {
        loginInput.sendKeys(login);
        nextButton.click();
    }
    public void typePasswordAndSubmit(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passwordNext\"]/content/span")));
        passwordInput.sendKeys(password);
        logButton.click();
    }
}



