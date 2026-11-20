package com.smartstore.billing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BillingApplicationTest {

	@Test
	void testDiscountBelowOneThousand() {
		double totalAmount = 800.0;
		double expectedDiscount = 0.0;

		double actualDiscount = BillingApplication.calculateDiscount(totalAmount);

		assertEquals(expectedDiscount, actualDiscount, 0.001);
	}

	@Test
	void testDiscountExactlyOneThousand() {
		double totalAmount = 1000.0;
		double expectedDiscount = 50.0;

		double actualDiscount = BillingApplication.calculateDiscount(totalAmount);

		assertEquals(expectedDiscount, actualDiscount, 0.001);
	}

	@Test
	void testDiscountForFourThousandNineHundredNinetyNine() {
		double totalAmount = 4999.0;
		double expectedDiscount = 249.95;

		double actualDiscount = BillingApplication.calculateDiscount(totalAmount);

		assertEquals(expectedDiscount, actualDiscount, 0.001);
	}

	@Test
	void testDiscountExactlyFiveThousand() {
		double totalAmount = 5000.0;
		double expectedDiscount = 500.0;

		double actualDiscount = BillingApplication.calculateDiscount(totalAmount);

		assertEquals(expectedDiscount, actualDiscount, 0.001);
	}

	@Test
	void testDiscountAboveFiveThousand() {
		double totalAmount = 7000.0;
		double expectedDiscount = 700.0;

		double actualDiscount = BillingApplication.calculateDiscount(totalAmount);

		assertEquals(expectedDiscount, actualDiscount, 0.001);
	}
}
