package com.hellofresh.qa.pageobjects.page;

import com.hellofresh.qa.core.test.PageObject;
import com.hellofresh.qa.pageobjects.panel.SiteHeaderPanelObject;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * SiteHomePageObject components and behaviours
 * @author SLakmal
 * @since 10/16/2019
 */
public class SiteHomePageObject extends PageObject {
    private static Logger log = Logger.getLogger(SiteHomePageObject.class);

    private By signIn_Link = By.linkText("Sign in");

    private SiteHeaderPanelObject siteHeaderPanel;

    public SiteHomePageObject() {
        this.siteHeaderPanel = new SiteHeaderPanelObject();
        log.info("On SiteHome Page");
    }

    /**
     * Step: Perform sign-in button to access login page
     * @return SiteSignInPageObject
     * @throws FrameworkException
     */
    public SiteSignInPageObject step_perform_sign_in_link() throws FrameworkException {
        step_initializer();
        locator(signIn_Link).click();
        log.info("Perform sign-in button to access login page...");
        return new SiteSignInPageObject();
    }
}
