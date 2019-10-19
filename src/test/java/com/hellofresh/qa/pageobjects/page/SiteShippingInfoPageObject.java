package com.hellofresh.qa.pageobjects.page;

import com.hellofresh.qa.core.test.PageObject;
import com.hellofresh.qa.pageobjects.panel.SiteHeaderPanelObject;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * SiteShippingInfoPageObject components and behaviours
 * @author SLakmal
 * @since 10/17/2019
 */
public class SiteShippingInfoPageObject extends PageObject {
    private static Logger log = Logger.getLogger(SiteShippingInfoPageObject.class);

    private By chkBx_terms = By.id("uniform-cgv");
    private By btn_proceedToCheckout = By.name("processCarrier");

    private SiteHeaderPanelObject siteHeaderPanel;

    public SiteShippingInfoPageObject() {
        this.siteHeaderPanel = new SiteHeaderPanelObject();
        log.info("On SiteShippingInfo Page");
    }

    /**
     * Step: Perform accept terms and condition
     * @return SiteShippingInfoPageObject
     * @throws FrameworkException
     */
    public SiteShippingInfoPageObject step_accept_shipping_terms_and_condition() throws FrameworkException {
        step_initializer();
        locator(chkBx_terms).click();
        log.info("Perform accept terms and condition...");
        return this;
    }

    /**
     * Step: Provide shipping info and proceed to checkout
     * @return SitePaymentPageObject
     * @throws FrameworkException
     */
    public SitePaymentPageObject step_proceed_checkout_with_shipping_delivery_info() throws FrameworkException {
        step_initializer();
        locator(btn_proceedToCheckout).click();
        log.info("Provide shipping info and proceed to checkout...");
        return new SitePaymentPageObject();
    }

}
