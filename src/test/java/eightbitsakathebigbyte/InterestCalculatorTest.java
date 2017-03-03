package eightbitsakathebigbyte;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class InterestCalculatorTest {

    InterestCalculator interestCalculator;
    Account genericAccount;
    Account savingsBelowRmbAccount;
    Account savingsAboveRmbAccount;

    @Before
    public void setUp(){
        interestCalculator = new InterestCalculator();
        genericAccount = new Account(null, 10000L, 0.1, 0L, 0L, null);
        savingsBelowRmbAccount = new Account(null, 5000L, 0.05, 30L, 100L, null);
        savingsAboveRmbAccount = new Account(null, 20000L, 0.1, 30L, 100L, null);

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

    @Test
    public void compIntNonZeroNoRmbAnnualTest(){
        long expected = 1000L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntNonZeroNoRmbQuarterlyTest(){
        long expected = 1038L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }


    @Test
    public void compIntNonZeroAboveRmbAnnualTest(){
        long expected = 1000L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntNonZeroAboveRmbQuarterlyTest(){
        long expected = 1038L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntNonZeroBelowMinBalQuarterlyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntNonZeroBelowMinBalAnnualTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }


    @Test
    public void compIntZeroBalNoRmbQuarterlyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntZeroBalNoRmbAnnualTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntZeroBalBelowRmbQuarterlyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntZeroBalBelowRmbAnnualTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    //assuming p=-$70, overdraft fee = $30; so find int on -$100
    @Test
    public void compIntOverdrawnNoRmbAnnualTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    //assuming p=-$70, overdraft fee = $30; so find int on -$100
    @Test
    public void compIntOverdrawnNoRmbQuarterlyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    //assuming p=-$70, overdraft fee = $30; so find int on -$100
    @Test
    public void compIntOverdrawnBelowRmbAnnualTest(){
        long expected = -1000L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    //assuming p=-$70, overdraft fee = $30; so find int on -$100
    @Test
    public void compIntOverdrawnBelowRmbQuarterlyTest(){
        long expected = -1038L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    //Using a recurring addition, M=$10
    @Test
    public void compIntAutoDeductionLessThanInterestAnnualTest(){
        long expected = 2000L;
        long actual = interestCalculator.calculateComplexInterest(genericAccount, 1.0f, 1);
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
