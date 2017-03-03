package eightbitsakathebigbyte;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class InterestCalculatorTest {

    InterestCalculator interestCalculator;
    Account account;

    @Before
    public void setUp(){
        interestCalculator = new InterestCalculator();
    }

    //P=$100;  r=0.1; n1 = 1 (annual); n2 = 4 (quarterly); t=1 (in yrs == 365 days)
    //Interval used in SimpleInterest and CompoundInterest will be a float
    //Equation for interest: i=P(1+(r/n))^(n*t)-P
    //Results need to be in pennies.
/*
    @Test
    public void compIntNonZeroNoRmbTest(){
        long intExpected = 1000L;
        long intActual;
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
*/

}
