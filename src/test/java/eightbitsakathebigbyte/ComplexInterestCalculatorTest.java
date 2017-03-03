package eightbitsakathebigbyte;
import org.junit.*;

import static org.junit.Assert.*;

public class ComplexInterestCalculatorTest {

    InterestCalculator interestCalculator;
    Account genericAccount;
    Account savingsBelowRmbAccount;
    Account savingsAboveRmbAccount;
    Account savingsNoRmbAccount;
    Account savingsNoRmbOverdrawnAccount;
    Account savingsBelowRmbOverdrawnAccount;
    Account checkingBelowRmbAcount;
    Account checkingAboveRmbAcount;
    Account moneyMarketBelowRmbAcount;
    Account moneyMarketAboveRmbAcount;
    Account savingsBelowRmbAccountDeposit;
    Account savingsAboveRmbAccountDeposit;
    Account checkingBelowRmbAcountDeposit;
    Account checkingAboveRmbAcountDeposit;
    Account moneyMarketBelowRmbAcountDeposit;
    Account moneyMarketAboveRmbAcountDeposit;
    Account savingsBelowRmbAccountWithdrawal;
    Account savingsAboveRmbAccountWithdrawal;
    Account checkingBelowRmbAcountWithdrawal;
    Account checkingAboveRmbAcountWithdrawal;
    Account moneyMarketBelowRmbAcountWithdrawal;
    Account moneyMarketAboveRmbAcountWithdrawal;


    @Before
    public void setUp(){
        interestCalculator = new InterestCalculator();
        genericAccount = new Account(null, 10000L, 0.1, 0L, 0L, null);
        savingsBelowRmbAccount = new Account(null, 5000L, 0.0, 30L, 100L, null);
        savingsAboveRmbAccount = new Account("savings", 20000L, 0.01, 30L, 100L, null);
        savingsNoRmbAccount = new Account("savings", 20000L, .01, 30L, 0L, null);
        savingsNoRmbOverdrawnAccount = new Account("savings", -20000L, 0.0, 30L, 0L, null);
        savingsBelowRmbOverdrawnAccount = new Account("savings", -20000L, 0.0, 30L, 100L, null);
        checkingBelowRmbAcount = new Account("checking", 10000L, 0.0, 30L, 0L, null);
        checkingAboveRmbAcount = new Account("checking", 10000L, 0.0, 30L, 0L, null);
        moneyMarketBelowRmbAcount = new Account("moneyMarket", 500000L, 0.0, 30L, 1000000L, null);
        moneyMarketAboveRmbAcount = new Account("moneyMarket", 2000000L, .05, 30L, 1000000L, null);
        savingsBelowRmbAccountDeposit = new Account("savings", 5000L, 0.0, 30L, 100L, null);
        savingsAboveRmbAccountDeposit = new Account("savings", 20000L, 0.01, 30L, 100L, null);
        checkingBelowRmbAcountDeposit = new Account("checking", 10000L, 0.0, 30L, 0L, null);
        checkingAboveRmbAcountDeposit = new Account("checking", 10000L, 0.0, 30L, 0L, null);
        moneyMarketBelowRmbAcountDeposit = new Account("moneyMarket", 500000L, 0.0, 30L, 1000000L, null);
        moneyMarketAboveRmbAcountDeposit = new Account("moneyMarket", 2000000L, .05, 30L, 1000000L, null);
        savingsBelowRmbAccountWithdrawal = new Account("savings", 5000L, 0.0, 30L, 100L, null);
        savingsAboveRmbAccountWithdrawal = new Account("savings", 20000L, 0.01, 30L, 100L, null);
        checkingBelowRmbAcountWithdrawal = new Account("checking", 10000L, 0.0, 30L, 0L, null);
        checkingAboveRmbAcountWithdrawal = new Account("checking", 10000L, 0.0, 30L, 0L, null);
        moneyMarketBelowRmbAcountWithdrawal = new Account("moneyMarket", 500000L, 0.0, 30L, 1000000L, null);
        moneyMarketAboveRmbAcountWithdrawal = new Account("moneyMarket", 2000000L, .05, 30L, 1000000L, null);
    }


    //Principal, P = $100;  r = 0.1; n1 = 1 (annual); n2 = 4 (quarterly); t = 1 (in yrs == 365 days)
    //A = Principal + interest; M == recurring payment/deduction
    //Interval used in SimpleInterest and CompoundInterest will be a float
    //Equation for interest: i = P(1+(r/n))^(n*t)-P
    //for recurring payment amounts (M): i = P(1+r/n)^(n*t) - P - M(n*t)

    //Balance values are in pennies. Results need to be in pennies.

    //Assumptions: interest is not calculated on accounts below RMB; RMB value is $30 (3000 pennies)
    //interest is calculated (and deducted) on accounts that are overdrawn.

    //Equations for finding future value, A, for recurring additions (A = P+i)
    //http://www.thecalculatorsite.com/articles/finance/compound-interest-formula.php?page=2
    //A =P*(1+r/n)^(n*t) + M*[(1+r/n)^(n*t)-1]/(r/n)


    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 20000L  r = 0.01   n = 1   t = 1
    public void compIntNonZeroAboveRmbAnnualSavingsTest() {
        long expected = 200L;
        long actual = interestCalculator.calculateComplexInterest(savingsAboveRmbAccount, 1.0f, 1);
        assertEquals("Expected", expected,actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 20000L  r = 0.01   n = 4   t = 1
    public void compIntNonZeroAboveRmbQuarterlySavingsTest() {
        long expected = 200L;
        long actual = interestCalculator.calculateComplexInterest(savingsAboveRmbAccount, 1.0f, 4);
        assertEquals("Expected", expected,actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 20000L  r = 0.01   n = 365  t = 1
    public void compIntNonZeroAboveRmbDailySavingsTest() {
        long expected = 201L;
        long actual = interestCalculator.calculateComplexInterest(savingsAboveRmbAccount, 1.0f, 365);
        assertEquals("Expected", expected,actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 20000L  r = 0.01   n = 1   t = 1
    public void compIntNonZeroNoRmbAnnualTest(){
        long expected = 200L;
        long actual = interestCalculator.calculateComplexInterest(savingsNoRmbAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 20000L  r = 0.01   n = 4   t = 1
    public void compIntNonZeroNoRmbQuarterlyTest(){
        long expected = 200L;
        long actual = interestCalculator.calculateComplexInterest(savingsNoRmbAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 20000L  r = 0.01   n = 365  t = 1
    public void compIntNonZeroAboveRmbDailyTest(){
        long expected = 201L;
        long actual = interestCalculator.calculateComplexInterest(savingsNoRmbAccount, 1.0f, 365);
        assertEquals("Expected", expected, actual);
    }

    @Test    //  i = P(1+(r/n))^(n*t)-P      P = 5000L  r = 0.00   n = 1   t = 1
    public void compIntNonZeroBelowMinBalAnnualTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsBelowRmbAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 5000L  r = 0.00   n = 4   t = 1
    public void compIntNonZeroBelowMinBalQuarterlyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsBelowRmbAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 5000L  r = 0.00   n = 365   t = 1
    public void compIntNonZeroBelowMinBalDailyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsBelowRmbAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 20000L  r = 0.00   n = 1   t = 1
    public void compIntZeroBalNoRmbAnnualTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsNoRmbAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 20000L  r = 0.00   n = 4   t = 1
    public void compIntZeroBalNoRmbQuarterlyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsNoRmbAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 20000L  r = 0.00   n = 365   t = 1
    public void compIntZeroBalNoRmbDailyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsNoRmbAccount, 1.0f, 365);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 5000L  r = 0.00   n = 1   t = 1
    public void compIntZeroBalBelowRmbAnnualTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsBelowRmbAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 5000L  r = 0.00   n = 4   t = 1
    public void compIntZeroBalBelowRmbQuarterlyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsBelowRmbAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 5000L  r = 0.00   n = 365   t = 1
    public void compIntZeroBalBelowRmbDailyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsBelowRmbAccount, 1.0f, 365);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = -20000L  r = 0.00   n = 1   t = 1
    public void compIntOverdrawnNoRmbAnnualTest() {
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsNoRmbOverdrawnAccount, 1.0f, 1);
        assertEquals("Expected", expected,actual);

    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = -20000L  r = 0.00   n = 4   t = 1
    public void compIntOverdrawnNoRmbQuarterlyTest() {
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsNoRmbOverdrawnAccount, 1.0f, 4);
        assertEquals("Expected", expected,actual);

    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = -20000L  r = 0.00   n = 365   t = 1
    public void compIntOverdrawnNoRmbDailyTest() {
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsNoRmbOverdrawnAccount, 1.0f, 365);
        assertEquals("Expected", expected,actual);

    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = -20000L  r = 0.00   n = 1   t = 1
    public void compIntOverdrawnBelowRmbAnnualTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsBelowRmbOverdrawnAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = -20000L  r = 0.00   n = 4   t = 1
    public void compIntOverdrawnBelowRmbQuarterlyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsBelowRmbOverdrawnAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = -20000L  r = 0.00   n = 365   t = 1
    public void compIntOverdrawnBelowRmbDailyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(savingsBelowRmbOverdrawnAccount, 1.0f, 365);
        assertEquals("Expected", expected, actual);
    }


    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 20000L  r = 0.01   n = 1   t = 1
    public void compIntAutoDeductionLessThanInterestAnnualSavingsAccountTest(){
        long expected = 200L;
        long actual = interestCalculator.calculateComplexInterest(savingsAboveRmbAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 20000L  r = 0.01   n = 4   t = 1
    public void compIntAutoDeductionLessThanInterestQuarterlySavingsAccountTest(){
        long expected = 200L;
        long actual = interestCalculator.calculateComplexInterest(savingsAboveRmbAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 20000L  r = 0.01   n = 365   t = 1
    public void compIntAutoDeductionLessThanInterestDailySavingsAccountTest(){
        long expected = 201L;
        long actual = interestCalculator.calculateComplexInterest(savingsAboveRmbAccount, 1.0f, 365);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 500000L  r = 0.05   n = 1   t = 1
    public void compIntAutoDeductionLessThanInterestAnnualMMAccountTest(){
        long expected = 2500L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 500000L  r = 0.05   n = 4   t = 1
    public void compIntAutoDeductionLessThanInterestQuarterlyMMAccountTest(){
        long expected = 2547L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test   //  i = P(1+(r/n))^(n*t)-P      P = 500000L  r = 0.05   n = 365   t = 1
    public void compIntAutoDeductionLessThanInterestDailyMMAccountTest(){
        long expected = 2563L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 365);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntAutoDeductionLessThanInterestQuarterlyTest(){
        long expected = 5190L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    //recurring deductions going forward is M=$10/month
    public void compIntAutoDeductionMoreThanInterestBelowRmbAnnualTest(){
        long expected = -750L;
        long actual = interestCalculator.calculateComplexInterest(savingsBelowRmbAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    public void compIntAutoDeductionMoreThanInterestBelowRmbQuarterlyTest(){
        long expected = 254L;
        long actual = interestCalculator.calculateComplexInterest(savingsBelowRmbAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    public void compIntAutoDeductionMoreThanInterestAboveRmbAnnualTest(){
        long expected = 250L;
        long actual = interestCalculator.calculateComplexInterest(savingsBelowRmbAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

}