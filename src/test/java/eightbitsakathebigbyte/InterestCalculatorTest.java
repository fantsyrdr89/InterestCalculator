package eightbitsakathebigbyte;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class InterestCalculatorTest {

    InterestCalculator interestCalculator;
    Account account;

    @Before
    public void setUp(){
        interestCalculator = new InterestCalculator();
        account = new Account(null, 10000L, 0.1, 0L, 0L, null);
    }

    //P=$100;  r=0.1; n1 = 1 (annual); n2 = 4 (quarterly); t=1 (in yrs == 365 days)
    //Interval used in SimpleInterest and CompoundInterest will be a float
    //Equation for interest: i=P(1+(r/n))^(n*t)-P
    //Results need to be in pennies.

    //Assumptions: interest is not calculated on accounts below RMB
    //interest is calculated (and deducted) on accounts that are overdrawn.

    @Test
    public void compIntNonZeroNoRmbAnnualTest(){
        long expected = 1000L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntNonZeroNoRmbQuarterlyTest(){
        long expected = 1038L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }


    @Test
    public void compIntNonZeroAboveRmbAnnualTest(){
        long expected = 1000L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntNonZeroAboveRmbQuarterlyTest(){
        long expected = 1038L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntNonZeroBelowMinBalQuarterlyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntNonZeroBelowMinBalAnnualTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntZeroBalNoRmbQuarterlyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntZeroBalNoRmbAnnualTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntZeroBalBelowRmbQuarterlyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void compIntZeroBalBelowRmbAnnualTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    //assuming p=-$70, overdraft fee = $30; so find int on -$100
    @Test
    public void compIntOverdrawnNoRmbAnnualTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    //assuming p=-$70, overdraft fee = $30; so find int on -$100
    @Test
    public void compIntOverdrawnNoRmbQuarterlyTest(){
        long expected = 0L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }

    //assuming p=-$70, overdraft fee = $30; so find int on -$100
    @Test
    public void compIntOverdrawnBelowRmbAnnualTest(){
        long expected = -1000L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 1);
        assertEquals("Expected", expected, actual);
    }

    //assuming p=-$70, overdraft fee = $30; so find int on -$100
    @Test
    public void compIntOverdrawnBelowRmbQuarterlyTest(){
        long expected = -1038L;
        long actual = interestCalculator.calculateComplexInterest(account, 1.0f, 4);
        assertEquals("Expected", expected, actual);
    }



}
