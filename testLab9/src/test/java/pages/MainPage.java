package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage {
    private static final String HOMEPAGE_URL = "https://www.massimodutti.com/ru/";
    private final WebDriver driver;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement submitCookie;

    @FindBy(xpath = "//button[@class='d-flex link-raw']")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@class='ebx-search-box__input ebx-search-box__input-query']")
    private WebElement searchInput;

    @FindBy(xpath = "//section[@class='ebx-result-figure ebx-result__figure']")
    private WebElement accessoryButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void enterSearchText(String searchText) {
        searchInput.sendKeys(searchText);
        searchInput.submit();
    }

    public void enterShoes() {
        accessoryButton.click();
    }

    public void searchClick(){
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        searchButton.click();
    }
    public void setSubmitCookie() {
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        submitCookie.click();
    }

}
