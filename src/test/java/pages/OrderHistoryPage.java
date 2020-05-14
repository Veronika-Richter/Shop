package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage extends BasePage {
    protected static final String CURRENT_PAGE_URL ="/index.php?controller=history";

    String orderLinkByReference = "//*[contains(text(), '%s')]/../..//*[contains(@class,'history_state')]/span";

    public OrderHistoryPage(WebDriver driver){
        super(driver);
    }

    @Override
    protected String currentPageUrl() {
        return CURRENT_PAGE_URL;
    }

    public String getOrderStatusByReference(String orderReference){
        WebElement element = xpathFormator(orderLinkByReference, "NTFVZVQFJ");
        return getWebElementText(element);

    }

}
