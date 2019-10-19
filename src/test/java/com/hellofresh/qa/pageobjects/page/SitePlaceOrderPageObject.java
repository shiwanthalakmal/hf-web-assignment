package com.hellofresh.qa.pageobjects.page;

import com.hellofresh.qa.core.test.PageObject;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * SitePlaceOrderPageObject components and behaviours
 * @author SLakmal
 * @since 10/17/2019
 */
public class SitePlaceOrderPageObject extends PageObject {
    private static Logger log = Logger.getLogger(SitePlaceOrderPageObject.class);

    private By lbl_tilte = By.cssSelector("h1");
    private By tab_shippingBreadcumb = By.xpath("//li[@class='step_done step_done_last four']");
    private By tab_paymentBreadcumb = By.xpath("//li[@id='step_end' and @class='step_current last']");
    private By lbl_orderCompleteMsg = By.xpath("//*[@class='cheque-indent']/strong");

    /**
     * Validate: Verify order confirmation title
     * @param title
     * @return SitePlaceOrderPageObject
     * @throws FrameworkException
     */
    public SitePlaceOrderPageObject check_and_validate_title(String title) throws FrameworkException {
        step_initializer();
        assertEquals(title, locator(lbl_tilte).getText());
        log.info("Verify order confirmation title...");
        return this;
    }

    /**
     * Validate: Verify order complete message
     * @return SitePlaceOrderPageObject
     * @throws FrameworkException
     */
    public SitePlaceOrderPageObject check_and_validate_order_completion_msg() throws FrameworkException {
        step_initializer();
        assertTrue(locator(lbl_orderCompleteMsg).getText().contains("Your order on My Store is complete."));
        log.info("Verify order complete message...");
        return this;
    }

    /**
     * Validate: Verify current page url availability
     * @param url
     * @return SitePlaceOrderPageObject
     */
    public SitePlaceOrderPageObject check_and_validate_current_url_availability(String url) {
        step_initializer();
        assertTrue(getDriver().getCurrentUrl().contains(url));
        log.info("Verify current page url availability...");
        return this;
    }

    /**
     * Validate: Verify breadcrumb availability
     * @return SitePlaceOrderPageObject
     * @throws FrameworkException
     */
    public SitePlaceOrderPageObject step_verify_breadcumb_availability() throws FrameworkException {
        step_initializer();
        assertTrue(locator(tab_shippingBreadcumb).isDisplayed());
        assertTrue(locator(tab_paymentBreadcumb).isDisplayed());
        log.info("Verify breadcrumb availability...");
        return this;
    }

}
