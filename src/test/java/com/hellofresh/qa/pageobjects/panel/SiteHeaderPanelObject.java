package com.hellofresh.qa.pageobjects.panel;

import com.hellofresh.qa.core.test.PageObject;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * SiteHeaderPanelObject common components and behaviours
 * @author SLakmal
 * @since 10/18/2019
 */
public class SiteHeaderPanelObject extends PageObject {
    private static Logger log = Logger.getLogger(SiteHeaderPanelObject.class);

    private By lbl_profileName = By.className("account");
    private By lnk_signout = By.className("logout");

    private By tab_womenSelection = By.linkText("Women");
    private By tab_dressSelection = By.linkText("Dresses");
    private By tab_shirtSelection = By.linkText("T-shirts");

    /**
     * Validate: Verify logged user profile name
     * @param name
     * @throws FrameworkException
     */
    public void check_and_validate_logged_user_profile_name(String name) throws FrameworkException {
        step_initializer();
        //assertEquals(locator(lbl_profileName).getText(), customerName);
    }

    /**
     * Validate: Verify sing-out link availability
     * @return SiteMyProfilePageObject
     * @throws FrameworkException
     */
    public void check_and_validate_sign_out_link_availability() throws FrameworkException {
        step_initializer();
        assertTrue(locator(lnk_signout).isDisplayed());
    }

    /**
     * Validate: Verify current site url
     * @param url
     * @return SiteMyProfilePageObject
     */
    public void check_and_validate_current_site_url(String url) {
        step_initializer();
        assertTrue(getDriver().getCurrentUrl().contains(url));
    }

    public void action_navigation_to_women_section() throws FrameworkException {
        locator(tab_womenSelection).click();
    }

    public void action_navigation_to_dress_section() throws FrameworkException {
        locator(tab_dressSelection).click();
    }

    public void action_navigation_to_shirts_section() throws FrameworkException {
        locator(tab_shirtSelection).click();
    }
}
