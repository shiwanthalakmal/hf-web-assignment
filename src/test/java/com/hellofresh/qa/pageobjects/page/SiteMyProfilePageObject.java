package com.hellofresh.qa.pageobjects.page;

import com.hellofresh.qa.core.test.PageObject;
import com.hellofresh.qa.pageobjects.panel.SiteHeaderPanelObject;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * SiteMyProfilePageObject components and behaviours
 * @author SLakmal
 * @since 10/16/2019
 */
public class SiteMyProfilePageObject extends PageObject {
    private static Logger log = Logger.getLogger(SiteMyProfilePageObject.class);

    private By lbl_pageTitle = By.className("page-heading");
    private By lbl_profileName = By.className("account");
    private By welcomeMsg_lbl = By.className("info-account");
    private By logout_link = By.className("logout");
    private By catory_tab = By.linkText("Women");

    private SiteHeaderPanelObject siteHeaderPanel;

    public SiteMyProfilePageObject() {
        this.siteHeaderPanel = new SiteHeaderPanelObject();
        log.info("On SiteMyProfile Page");
    }

    /**
     * Validate: Verify profile page tile
     * @param title
     * @return SiteMyProfilePageObject
     * @throws FrameworkException
     */
    public SiteMyProfilePageObject check_and_validate_profile_page_tile(String title) throws FrameworkException {
        step_initializer();
        assertEquals(locator(lbl_pageTitle).getText(), title);
        log.info("Verify profile page tile...");
        return this;
    }

    /**
     * Validate: Verify logged user profile name
     * @param name
     * @return SiteMyProfilePageObject
     * @throws FrameworkException
     */
    public SiteMyProfilePageObject check_and_validate_logged_user_profile_name(String name) throws FrameworkException {
        step_initializer();
        this.siteHeaderPanel.check_and_validate_logged_user_profile_name(name);
        log.info("Verify logged user profile name...");
        return this;
    }

    /**
     * Validate: Verify welcome message
     * @return SiteMyProfilePageObject
     * @throws FrameworkException
     */
    public SiteMyProfilePageObject check_and_validate_welcome_message() throws FrameworkException {
        step_initializer();
        assertTrue(locator(welcomeMsg_lbl).getText().contains("Welcome to your account."));
        log.info("Verify welcome message...");
        return this;
    }

    /**
     * Validate: Verify sing-out link availability
     * @return SiteMyProfilePageObject
     * @throws FrameworkException
     */
    public SiteMyProfilePageObject check_and_validate_sign_out_link_availability() throws FrameworkException {
        step_initializer();
        this.siteHeaderPanel.check_and_validate_sign_out_link_availability();
        log.info("Verify sing-out link availability...");
        return this;
    }

    /**
     * Validate: Verify current site url
     * @param url
     * @return SiteMyProfilePageObject
     */
    public SiteMyProfilePageObject check_and_validate_current_site_url(String url) {
        step_initializer();
        this.siteHeaderPanel.check_and_validate_current_site_url(url);
        log.info("Verify current site url...");
        return this;
    }

    /**
     * Step: Navigate to category women section
     * @return SiteWomenCategoryPageObject
     * @throws FrameworkException
     */
    public SiteWomenCategoryPageObject step_navigation_to_women_section() throws FrameworkException {
        step_initializer();
        this.siteHeaderPanel.action_navigation_to_women_section();
        log.info("Navigate to category women section...");
        return new SiteWomenCategoryPageObject();
    }
}
