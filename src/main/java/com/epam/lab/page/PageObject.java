package com.epam.lab.page;
import com.epam.lab.singleton.SingletonDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class PageObject {
    public PageObject(WebDriver driver) {
        WebDriver instance = SingletonDriver.getInstance();
        PageFactory.initElements(new DefaultElementLocatorFactory(instance),this);
    }
    public PageObject() {
        this(SingletonDriver.getInstance());
    }
}
