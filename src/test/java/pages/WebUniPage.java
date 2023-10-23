package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebUniPage {

public WebUniPage(){
    PageFactory.initElements(Driver.getDriver(),this);
}

@FindBy(xpath = "//*[text()='Our Products']")
    public WebElement ourProductslinki;

@FindBy(xpath = "//*[@id='frame']")
    public WebElement IframeElementi;

@FindBy(xpath = "//p[text()='Cameras']")
    public WebElement camerasElementi;

@FindBy(xpath = "//h4")
public WebElement alertYaziElementi;

@FindBy(xpath = "//button[text()='Close']")
    public WebElement closeButtonu;

@FindBy(xpath = "//*[text()='WebdriverUniversity.com (IFrame)']")
    public WebElement webDriverLinki;



}
