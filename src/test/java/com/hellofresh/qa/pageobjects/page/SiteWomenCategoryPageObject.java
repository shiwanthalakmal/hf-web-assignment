package com.hellofresh.qa.pageobjects.page;

import com.hellofresh.qa.core.test.PageObject;
import com.hellofresh.qa.pageobjects.panel.SiteHeaderPanelObject;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * SiteWomenCategoryPageObject components and behaviours
 * @author SLakmal
 * @since 10/16/2019
 */
public class SiteWomenCategoryPageObject extends PageObject {
    private static Logger log = Logger.getLogger(SiteWomenCategoryPageObject.class);

    private SiteHeaderPanelObject siteHeaderPanel;

    public SiteWomenCategoryPageObject() {
        this.siteHeaderPanel = new SiteHeaderPanelObject();
        log.info("On SiteWomenCategory Page");
    }

    /**
     * Step: Selection for given women dress item
     * @param item
     * @return SiteProductDetailPageObject
     * @throws FrameworkException
     */
    public SiteProductDetailPageObject step_select_specific_women_dress_item(String item) throws FrameworkException {
        step_initializer();
        By btn_dressItem = By.xpath("//a[@title='"+item+"']/ancestor::li");
        locator(btn_dressItem).click();
        if (!getBrowser().equalsIgnoreCase("firefox")) {locator(btn_dressItem).click(); }
        log.info("Selection for given women dress item...");
        return new SiteProductDetailPageObject();
    }
}
