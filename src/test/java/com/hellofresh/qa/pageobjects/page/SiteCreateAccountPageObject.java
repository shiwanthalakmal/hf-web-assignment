package com.hellofresh.qa.pageobjects.page;

import com.hellofresh.qa.core.test.PageObject;
import com.hellofresh.qa.pageobjects.panel.SiteHeaderPanelObject;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * SiteCreateAccountPageObject components and behaviours
 * @author SLakmal
 * @since 10/16/2019
 */
public class SiteCreateAccountPageObject extends PageObject {
    private static Logger log = Logger.getLogger(SiteCreateAccountPageObject.class);

    private By txt_fname = By.id("customer_firstname");
    private By txt_lname = By.id("customer_lastname");
    private By txt_email = By.id("passwd");
    private By txt_password = By.id("passwd");
    private By ddl_dobDate = By.id("days");
    private By ddl_dobMonth = By.id("months");
    private By ddl_dobYear = By.id("years");

    private By chkBx_newLetter = By.id("newsletter");
    private By chkBx_optOffers = By.id("optin");

    private By txt_company = By.id("company");
    private By txt_addressMain = By.id("address1");
    private By txt_addressSub = By.id("address2");
    private By txt_city = By.id("city");
    private By ddl_state = By.id("id_state");
    private By txt_zipCode = By.id("postcode");
    private By ddl_country = By.id("id_country");
    private By txtArea_info = By.id("other");
    private By txt_homePhone = By.id("phone");
    private By txt_mobilePhone = By.id("phone_mobile");
    private By txt_reference = By.id("alias");
    private By btn_register = By.id("submitAccount");

    private SiteHeaderPanelObject siteHeaderPanel;

    public SiteCreateAccountPageObject() {
        this.siteHeaderPanel = new SiteHeaderPanelObject();
        log.info("On SiteCreateAccount Page");
    }

    /**
     * Step: Provide user personal information for registration
     * @return SiteCreateAccountPageObject
     * @throws FrameworkException
     */
    public SiteCreateAccountPageObject step_provide_personal_information() throws FrameworkException {
        step_initializer();
        locator(txt_fname).sendKeys(faker.name().firstName());
        locator(txt_lname).sendKeys(faker.name().lastName());
        locator(txt_email).sendKeys(faker.internet().emailAddress());
        selection(ddl_dobDate).selectByValue(String.valueOf(faker.number().numberBetween(1, 30)));
        selection(ddl_dobMonth).selectByValue(String.valueOf(faker.number().numberBetween(1, 12)));
        selection(ddl_dobYear).selectByValue(String.valueOf(faker.number().numberBetween(1900, 2002)));
        log.info("Provided user personal information for registration...");
        return this;
    }

    /**
     * Step: Provided user address information for registration
     * @return SiteCreateAccountPageObject
     * @throws FrameworkException
     */
    public SiteCreateAccountPageObject step_provide_address_information() throws FrameworkException {
        step_initializer();
        locator(txt_company).sendKeys(faker.company().name());
        locator(txt_addressMain).sendKeys(faker.address().buildingNumber());
        locator(txt_addressSub).sendKeys(faker.address().streetAddress());
        locator(txt_city).sendKeys(faker.address().cityName());
        selection(ddl_state).selectByVisibleText("Georgia");
        locator(txt_zipCode).sendKeys(faker.number().digits(5));
        locator(txtArea_info).sendKeys("Register as a seller !");
        log.info("Provided user address information for registration...");
        return this;
    }

    /**
     * Step: Provided user contact information for registration
     * @return SiteCreateAccountPageObject
     * @throws FrameworkException
     */
    public SiteCreateAccountPageObject step_provide_contact_information() throws FrameworkException {
        step_initializer();
        locator(txt_homePhone).sendKeys(faker.phoneNumber().cellPhone());
        locator(txt_mobilePhone).sendKeys(faker.phoneNumber().cellPhone());
        locator(txt_reference).sendKeys(faker.internet().domainName());
        log.info("Provided user contact information for registration...");
        return this;
    }

    /**
     * Step: Perform register button
     * @return SiteMyProfilePageObject
     * @throws FrameworkException
     */
    public SiteMyProfilePageObject step_perform_register_button() throws FrameworkException {
        step_initializer();
        locator(btn_register).click();
        log.info("Perform register button...");
        return new SiteMyProfilePageObject();
    }
}
