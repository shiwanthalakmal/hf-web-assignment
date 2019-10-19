package com.hellofresh.qa.pageobjects.page;

import com.hellofresh.qa.core.test.PageObject;
import com.hellofresh.qa.pageobjects.panel.SiteHeaderPanelObject;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * SitePaymentPageObject components and behaviours
 * @author SLakmal
 * @since 10/17/2019
 */
public class SitePaymentPageObject extends PageObject {
    private static Logger log = Logger.getLogger(SitePaymentPageObject.class);

    private By bankWire_div = By.className("bankwire");
    private By confirmOrder_btn = By.xpath("//*[@id='cart_navigation']/button");

    private SiteHeaderPanelObject siteHeaderPanel;

    public SitePaymentPageObject() {
        this.siteHeaderPanel = new SiteHeaderPanelObject();
        log.info("On SitePayment Page");
    }

    /**
     * Step: Selection payment option
     * @return SitePaymentPageObject
     * @throws FrameworkException
     */
    public SitePaymentPageObject step_selction_payment_options_as_a_bankwire() throws FrameworkException {
        step_initializer();
        locator(bankWire_div).click();
        log.info("Selection payment option...");
        return this;
    }

    /**
     * Step: Perform order confirmation
     * @return SitePlaceOrderPageObject
     * @throws FrameworkException
     */
    public SitePlaceOrderPageObject step_perform_order_conformation() throws FrameworkException {
        step_initializer();
        locator(confirmOrder_btn).click();
        log.info("Perform order confirmation...");
        return new SitePlaceOrderPageObject();
    }

}
