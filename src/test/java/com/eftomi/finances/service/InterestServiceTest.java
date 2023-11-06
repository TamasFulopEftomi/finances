package com.eftomi.finances.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterestServiceTest {

    private InterestService interestService = new InterestService();

    @Test
    void compoundInterestWithInitialCapital() {
        int amount = interestService.compoundInterestWithInitialCapital(200000, 3, 10);
        assertEquals(268783, amount);
    }

    @Test
    void cIWithInitialCapitalInYearlyMap() {
        interestService.cIWithInitialCapitalInYearlyMap(200000, 3, 10);
    }

    @Test
    void compoundInterestWithAnnualPayment() {
        int amount = interestService.compoundInterestWithAnnualPayment(200000, 3, 10);
        assertEquals(2361559, amount);
    }

    @Test
    void cIWithAnnualPaymentInYearlyMap() {
        interestService.cIWithAnnualPaymentInYearlyMap(200000, 3, 10);
    }

    @Test
    void compoundInterestWithInitialCapitalAndWithAnnualPayment() {
        int amount = interestService.compoundInterestWithInitialCapitalAndWithAnnualPayment(200000, 200000, 3, 10);
        assertEquals(2630342, amount);
    }

    @Test
    void cIWithInitialCapitalAndWithAnnualPaymentInYearlyMap() {
        interestService.cIWithInitialCapitalAndWithAnnualPaymentInYearlyMap(200000, 200000, 3, 10);
    }

}