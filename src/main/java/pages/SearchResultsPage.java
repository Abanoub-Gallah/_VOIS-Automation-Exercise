package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage extends PageBase{

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    private By pageLinks = By.className("g");
    public By logoIcn = By.id("logo");

    @FindBy(id = "pnnext")
    WebElement nextPageBtn;

    @FindBy(id="result-stats")
    public WebElement pageNumber;

    public void clickNextPage() {
        scrollDown();
        clickButton(nextPageBtn);
    }

    public int countResultsPage() {
        countResults(pageLinks);
        return 0;
    }

    public boolean logoVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoIcn)).isDisplayed();
    }
}
