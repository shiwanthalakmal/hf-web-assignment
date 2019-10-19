package com.hellofresh.qa.pageobjects.page;

import com.hellofresh.qa.core.test.PageObject;
import com.hellofresh.qa.pageobjects.panel.SiteHeaderPanelObject;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * SiteShoppingCartPageObject components and behaviours
 * @author SLakmal
 * @since 10/17/2019
 */
public class SiteShoppingCartPageObject extends PageObject {
    private static Logger log = Logger.getLogger(SiteShoppingCartPageObject.class);

    private By btn_proceedToCheckout = By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");

    private SiteHeaderPanelObject siteHeaderPanel;

    public SiteShoppingCartPageObject() {
        this.siteHeaderPanel = new SiteHeaderPanelObject();
        log.info("On SiteShoppingCart Page");
    }

    /**
     * Step: Proceed to shopping cart page
     * @return SiteShippingAddressPageObject
     * @throws FrameworkException
     */
    public SiteShippingAddressPageObject step_proceed_to_checkout_shopping_cart() throws FrameworkException {
        step_initializer();
        locator(btn_proceedToCheckout).click();
        log.info("Proceed to shopping cart page...");
        return new SiteShippingAddressPageObject();
    }

}
