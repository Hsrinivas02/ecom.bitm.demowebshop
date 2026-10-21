package objRepo;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Homepage logo
    @FindBy(css = ".header-logo a")
    public WebElement logo; //Using .header-logo a is more appropriate
    // because you're explicitly locating the clickable link.

    // Main navigation categories
    @FindBy(css = ".header-menu > ul > li")
    public List<WebElement> navigationLinks; //.header-menu → Finds the navigation menu, > Selects a direct child.
    //ul-> Finds the direct child <ul>,  > i.e Finds its direct children, li->Selects each menu item.

    // Search textbox
    @FindBy(id = "small-searchterms")
    public WebElement searchBox;

    // Search button
    @FindBy(css = "input.search-box-button")
    public WebElement searchBtn;

    // Product names in search results
    @FindBy(css = ".product-title a") //class product-title is wrapped in anchor tag
    public List<WebElement> productNames;

    // Product details title
    @FindBy(css = ".product-name")
    public WebElement productTitle;

    // Search for a product
    public void searchProduct(String value) throws InterruptedException {
        searchBox.clear();
        if (value != null) {
            searchBox.sendKeys(value);
        }
        searchBtn.click();
        Thread.sleep(1500);
    }

    // Check whether a product appears in search results
    public boolean isProductDisplayed(String productName) {
        for (WebElement product : productNames) {
            if (product.getText().trim().equalsIgnoreCase(productName.trim())) {
                return true;
            }
        }
        return false;
    }

    // Get the number of search results
    public int getSearchResultCount() {
        return productNames.size();
    }
}
