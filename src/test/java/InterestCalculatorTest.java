import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InterestCalculatorTest {
    InterestCalculator interestCalculator;
    Account account;

    @Before
    public void setUp(){
        interestCalculator = new InterestCalculator();
    }

    @Test
    public void simpleInterestNormalBalanceNoRMBTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestNormalBalanceAboveRMBTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestNormalBelowMinBalanceNonzeroTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestZeroBalanceTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestZeroBalanceBelowRMBTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestNegBalanceNoRMBTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestNegBalanceBelowRMBTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestNegBalanceBelowRMBTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestNormalBalanceRecurringDeductionsNotExceedingIntEarnedTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestNormalBalanceRecurringDeductionsExceedingIntEarnedTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestBlowRMBRecurringContributionNotAboveRMBTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestBlowRMBRecurringContributionAboveRMBTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestLowBalGetOverDrawnNotAboveZeroTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestLowBalGetOverDrawnAboveZeroTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestLowBalOverdrawnNotAboveZeroTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }

    @Test
    public void simpleInterestLowBalOverdrawnAboveZeroTest() {

        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }
}
