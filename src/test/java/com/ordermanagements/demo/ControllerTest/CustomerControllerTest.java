
package com.ordermanagements.demo.ControllerTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ordermanagements.demo.controller.CustomerController;
import com.ordermanagements.demo.entities.Customer;
import com.ordermanagements.demo.services.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	public static final String ADDRESS = "tanjore";
    public static final String CUSTOMER_ID = "1";
    public static final String CUSTOMER_NAME = "David";
    public static final String MOBILE_NO = "8985521522";
    public static final String EMAIL = "visha@mail.com";

	@Mock
	private CustomerService customerService;

	@InjectMocks
	private CustomerController customerController;
	private Customer customer;

	@Before
	public void setup() {
		/*
		 * customer =
		 * Customer.builder().customerAddress(ADDRESS).customerEmail(EMAIL).customerId(
		 * CUSTOMER_ID)
		 * .customerMobileNo(MOBILE_NO).customerName(CUSTOMER_NAME).build();
		 */
	}
	
	@Test
	public void addCustomerTests() {
	
	}
}
