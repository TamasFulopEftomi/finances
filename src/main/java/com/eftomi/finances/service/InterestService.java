package com.eftomi.finances.service;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class InterestService {

    public int compoundInterestWithInitialCapital(int initialCapital, int interestRate, int maturity) {
        double rate = 1 + (double) interestRate / 100;
        return (int) (initialCapital * Math.pow(rate, maturity));
    }

    public Map<Integer, Integer> cIWithInitialCapitalInYearlyMap(int initialCapital, int interestRate, int maturity) {
        Map<Integer, Integer> cIWithInitialCapitalMap = new TreeMap<>();
        double rate = 1 + (double) interestRate / 100;
        int amount = initialCapital;
        for (int i = 0; i < maturity; i++) {
            amount *= rate;
            cIWithInitialCapitalMap.put(i + 1, amount);
        }
        log.info("Map: " + cIWithInitialCapitalMap);
        return cIWithInitialCapitalMap;
    }

    public int compoundInterestWithAnnualPayment(int annualPayment, int interestRate, int maturity) {
        double rate = 1 + (double) interestRate / 100;
        double geometricSequence = 1 * ((Math.pow(rate, maturity) - 1) / (rate - 1));
        return (int) (annualPayment * rate * geometricSequence);
    }

    public Map<Integer, Integer> cIWithAnnualPaymentInYearlyMap(int annualPayment, int interestRate, int maturity) {
        Map<Integer, Integer> cIWithInitialCapitalMap = new TreeMap<>();
        double rate = 1 + (double) interestRate / 100;
        int amount = 0;
        for (int i = 0; i < maturity; i++) {
            amount = (int) ((annualPayment + amount) * rate);
            cIWithInitialCapitalMap.put(i + 1, amount);
        }
        log.info("Map: " + cIWithInitialCapitalMap);
        return cIWithInitialCapitalMap;
    }

    public int compoundInterestWithInitialCapitalAndWithAnnualPayment(int initialCapital, int annualPayment, int interestRate, int maturity) {
        int compoundInterestWithInitialCapital = compoundInterestWithInitialCapital(initialCapital, interestRate, maturity);
        int compoundInterestWithAnnualPayment = compoundInterestWithAnnualPayment(annualPayment, interestRate, maturity);
        return compoundInterestWithInitialCapital + compoundInterestWithAnnualPayment;
    }

    public Map<Integer, Integer> cIWithInitialCapitalAndWithAnnualPaymentInYearlyMap(int initialCapital, int annualPayment, int interestRate, int maturity) {
        Map<Integer, Integer> cIWithInitialCapitalMap = new TreeMap<>();
        double rate = 1 + (double) interestRate / 100;
        int amount = initialCapital;
        for (int i = 0; i < maturity; i++) {
            amount = (int) ((annualPayment + amount) * rate);
            cIWithInitialCapitalMap.put(i + 1, amount);
        }
        log.info("Map: " + cIWithInitialCapitalMap);
        return cIWithInitialCapitalMap;
    }

}
