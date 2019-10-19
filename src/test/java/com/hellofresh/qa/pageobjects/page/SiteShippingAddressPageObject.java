package com.hellofresh.qa.pageobjects.page;

import com.hellofresh.qa.core.test.PageObject;
import com.hellofresh.qa.pageobjects.panel.SiteHeaderPanelObject;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * SiteShippingAddressPageObject components and behaviours
 * @author SLakmal
 * @since 10/17/2019
 */
public class SiteShippingAddressPageObject extends PageObject {
    private static Logger log = Logger.getLogger(SiteShippingAddressPageObject.class);

    private By proceedToCheckout_btn = By.name("processAddress");

    private SiteHeaderPanelObject siteHeaderPanel;

    public SiteShippingAddressPageObject() {
        this.siteHeaderPanel = new SiteHeaderPanelObject();
        log.info("On SiteShippingAddress Page");
    }

    /**
     * Step: Provide shipping address info and proceed to checkout
     * @return SiteShippingInfoPageObject
     * @throws FrameworkException
     */
    public SiteShippingInfoPageObject step_proceed_to_checkout_with_shipping_address() throws FrameworkException {
        step_initializer();
        locator(proceedToCheckout_btn).click();
        log.info("Provide shipping address info and proceed to checkout...");
        return new SiteShippingInfoPageObject();
    }

}
