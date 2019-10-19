package com.hellofresh.qa.tests;

import com.hellofresh.qa.core.test.TestObject;
import com.hellofresh.qa.pageobjects.page.SiteHomePageObject;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import org.testng.annotations.Test;

public class SiteTestSuite extends TestObject {

    //@Test
    public void newly_created_user_login_end_to_end_flow() throws FrameworkException {
        new SiteHomePageObject().step_perform_sign_in_link()
                .step_create_an_new_account()
                .step_provide_personal_information()
                .step_provide_address_information()
                .step_provide_contact_information()
                .step_perform_register_button()
                .check_and_validate_profile_page_tile("MY ACCOUNT")
                .check_and_validate_logged_user_profile_name("")
                .check_and_validate_welcome_message()
                .check_and_validate_sign_out_link_availability()
                .check_and_validate_current_site_url("controller=my-account");
    }

    //@Test
    public void already_existing_user_login_flow() throws FrameworkException {
        new SiteHomePageObject().step_perform_sign_in_link()
                .step_sign_in_already_existing_user("hf_challenge_123456@hf123456.com",
                        "12345678")
                .check_and_validate_profile_page_tile("MY ACCOUNT")
                .check_and_validate_logged_user_profile_name("Joe Black")
                .check_and_validate_welcome_message()
                .check_and_validate_sign_out_link_availability()
                .check_and_validate_current_site_url("controller=my-account");
    }

    @Test
    public void product_checkout_end_to_end_flow() throws FrameworkException {
        new SiteHomePageObject().step_perform_sign_in_link()
                .step_sign_in_already_existing_user("hf_challenge_123456@hf123456.com",
                        "12345678")
                .step_navigation_to_women_section()
                .step_select_specific_women_dress_item("Faded Short Sleeve T-shirts")
                .step_select_item_quantity_details()
                .step_select_item_size_details()
                .step_click_on_add_to_cart_button()
                .step_proceed_item_checkout_flow()
                .step_proceed_to_checkout_shopping_cart()
                .step_proceed_to_checkout_with_shipping_address()
                .step_accept_shipping_terms_and_condition()
                .step_proceed_checkout_with_shipping_delivery_info()
                .step_selction_payment_options_as_a_bankwire()
                .step_perform_order_conformation()
                .check_and_validate_title("ORDER CONFIRMATION")
                .step_verify_breadcumb_availability()
                .check_and_validate_order_completion_msg()
                .check_and_validate_current_url_availability("controller=order-confirmation");
    }

    //@Test
    public void negative_test_for_demonstration_purpose() throws FrameworkException {
        new SiteHomePageObject().step_perform_sign_in_link()
                .step_sign_in_already_existing_user("autouser24112018@autoprac12345.com",
                        "12345678")
                .check_and_validate_profile_page_tile("MY Profile");
    }
}
