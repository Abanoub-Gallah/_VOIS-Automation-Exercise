package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "q")
    WebElement searchTxtBox;

    public void UserSearch(String search) {
        setTextElementText(searchTxtBox, search);
        searchTxtBox.submit();
    }
}
