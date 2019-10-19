package com.hellofresh.qa.pageobjects.page;

import com.hellofresh.qa.core.test.PageObject;
import com.hellofresh.qa.pageobjects.panel.SiteHeaderPanelObject;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * SiteSignInPageObject components and behaviours
 * @author SLakmal
 * @since 10/16/2019
 */
public class SiteSignInPageObject extends PageObject {
    private static Logger log = Logger.getLogger(SiteSignInPageObject.class);

    private By txt_email = By.id("email_create");
    private By btn_account = By.id("SubmitCreate");

    private By txt_username = By.id("email");
    private By txt_password = By.id("passwd");
    private By btn_login = By.id("SubmitLogin");

    private SiteHeaderPanelObject siteHeaderPanel;

    public SiteSignInPageObject() {
        this.siteHeaderPanel = new SiteHeaderPanelObject();
        log.info("On SiteSignIn Page");
    }

    /**
     * Step: Create new account for new user
     * @return SiteCreateAccountPageObject
     * @throws FrameworkException
     */
    public SiteCreateAccountPageObject step_create_an_new_account() throws FrameworkException {
        step_initializer();
        locator(txt_email).sendKeys(faker.internet().emailAddress());
        locator(btn_account).click();
        log.info("Perform create account button with valid email address...");
        return new SiteCreateAccountPageObject();
    }

    /**
     * Step: Enter username
     * @param username
     * @return SiteSignInPageObject
     * @throws FrameworkException
     */
    public SiteSignInPageObject step_enter_login_username(String username) throws FrameworkException {
        step_initializer();
        locator(txt_username).sendKeys(username);
        log.info("Enter username...");
        return this;
    }

    /**
     * Step: Enter password
     * @param password
     * @return SiteSignInPageObject
     * @throws FrameworkException
     */
    public SiteSignInPageObject step_enter_login_password(String password) throws FrameworkException {
        step_initializer();
        locator(txt_password).sendKeys(password);
        log.info("Enter password...");
        return this;
    }

    /**
     * Step: Logginf as a already existing user with valid credentials
     * @param username
     * @param password
     * @return SiteMyProfilePageObject
     * @throws FrameworkException
     */
    public SiteMyProfilePageObject step_sign_in_already_existing_user(String username, String password) throws FrameworkException {
        step_initializer();
        this.step_enter_login_username(username);
        this.step_enter_login_password(password);
        locator(btn_login).click();
        log.info("Logging as a already existing user with valid credentials...");
        return new SiteMyProfilePageObject();
    }



}
