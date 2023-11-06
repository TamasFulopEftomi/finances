package com.eftomi.finances.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InterestServiceTest {

    private InterestService interestService = new InterestService();
    private Map<Integer, Integer> cIWithInitialCapital = new TreeMap<>();
    private Map<Integer, Integer> cIWithAnnualPayment = new TreeMap<>();
    private Map<Integer, Integer> cIWithInitialCapitalAndAnnualPayment = new TreeMap<>();

    @Test
    void cIWithInitialCapital() {
        int amount = interestService.cIWithInitialCapital(200000, 3, 10);
        assertEquals(268783, amount);
    }

    @BeforeAll
    void setUp() {
        cIWithInitialCapital = interestService.cIWithInitialCapitalMap(200000, 3, 10);
        cIWithAnnualPayment = interestService.cIWithAnnualPaymentMap(200000, 3, 10);
        cIWithInitialCapitalAndAnnualPayment = interestService
                .cIWithInitialCapitalAndAnnualPaymentMap(200000, 200000, 3, 10);
    }

    @ParameterizedTest
    @CsvSource({"1, 206000", "2, 212180", "3, 218545", "4, 225101", "5, 231854", "6, 238809", "7, 245973", "8, 253352", "9, 260952", "10, 268780"})
    void cIWithInitialCapitalMap(int key, int value) {
        assertEquals(value, cIWithInitialCapital.get(key));
    }

    @Test
    void cIWithAnnualPayment() {
        int amount = interestService.cIWithAnnualPayment(200000, 3, 10);
        assertEquals(2361559, amount);
    }
    @ParameterizedTest
    @CsvSource({"1, 206000", "2, 418180", "3, 636725", "4, 861826", "5, 1093680", "6, 1332490", "7, 1578464", "8, 1831817", "9, 2092771", "10, 2361554"})
    void cIWithAnnualPaymentMap(int key, int value) {
        assertEquals(value, cIWithAnnualPayment.get(key));
    }

    @Test
    void cIWithInitialCapitalAndAnnualPayment() {
        int amount = interestService.cIWithInitialCapitalAndAnnualPayment(200000, 200000, 3, 10);
        assertEquals(2630342, amount);
    }
    @ParameterizedTest
    @CsvSource({"1, 412000", "2, 630360", "3, 855270", "4, 1086928", "5, 1325535", "6, 1571301", "7, 1824440", "8, 2085173", "9, 2353728", "10, 2630339"})
    void cIWithInitialCapitalAndAnnualPaymentMap(int key, int value) {
        assertEquals(value, cIWithInitialCapitalAndAnnualPayment.get(key));
    }

}