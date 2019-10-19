package com.hellofresh.qa.pageobjects.page;

import com.hellofresh.qa.core.test.PageObject;
import com.hellofresh.qa.pageobjects.panel.SiteHeaderPanelObject;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import com.hellofresh.qa.support.util.DataProviderUtil;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

/**
 * SiteProductDetailPageObject components and behaviours
 * @author SLakmal
 * @since 10/16/2019
 */
public class SiteProductDetailPageObject extends PageObject {
    private static Logger log = Logger.getLogger(SiteProductDetailPageObject.class);

    private By txt_itemQuantity = By.id("quantity_wanted");
    private By ddl_sizeSelection = By.id("group_1");
    private By btn_addToCart = By.name("Submit");
    private By btn_checkOut = By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']");

    private SiteHeaderPanelObject siteHeaderPanel;

    public SiteProductDetailPageObject() {
        this.siteHeaderPanel = new SiteHeaderPanelObject();
        log.info("On SiteProductDetail Page");
    }

    /**
     * Step: Provide item quantity information
     * @return SiteProductDetailPageObject
     * @throws FrameworkException
     */
    public SiteProductDetailPageObject step_select_item_quantity_details() throws FrameworkException {
        step_initializer();
        JSONObject object = DataProviderUtil.readTestData("ProductDetails.json");
        String quantity = object.get("quantity").toString();
        locator(txt_itemQuantity).clear();
        locator(txt_itemQuantity).sendKeys(quantity);
        log.info("Provide item quantity information...");
        return this;
    }

    /**
     * Step: Provide item size information
     * @return SiteProductDetailPageObject
     * @throws FrameworkException
     */
    public SiteProductDetailPageObject step_select_item_size_details() throws FrameworkException {
        step_initializer();
        JSONObject object = DataProviderUtil.readTestData("ProductDetails.json");
        String size = object.get("size").toString();
        selection(ddl_sizeSelection).selectByVisibleText(size);
        log.info("Provide item size information...");
        return this;
    }

    /**
     * Step: Perform add-to cart item button
     * @return SiteProductDetailPageObject
     * @throws FrameworkException
     */
    public SiteProductDetailPageObject step_click_on_add_to_cart_button() throws FrameworkException {
        step_initializer();
        locator(btn_addToCart).click();
        log.info("Perform add-to cart item button...");
        return this;
    }

    /**
     * Step: Proceed checkout flow
     * @return SiteShoppingCartPageObject
     * @throws FrameworkException
     */
    public SiteShoppingCartPageObject step_proceed_item_checkout_flow() throws FrameworkException {
        step_initializer();
        waitUntil(btn_checkOut).click();
        log.info("Proceed checkout flow...");
        return new SiteShoppingCartPageObject();
    }
}
