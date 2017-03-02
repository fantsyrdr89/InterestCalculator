package eightbitsakathebigbyte;
import org.junit.*;

public class InterestCalculatorTest {

    InterestCalculator interestCalculator;

    @Before
    public void setUp(){
        interestCalculator = new InterestCalculator();
    }

    //P=$100;  r=0.1; n1 = 1 (annual); n2 = 4 (quarterly); t=1 (in yrs == 365 days)
    //Interval used in SimpleInterest and CompoundInterest will be a float
    //Equation for interest: i=P(1+(r/n))^(n*t)-P
    //Results need to be in pennies.

    @Test
    public void compIntNonZeroNoRmbTest(){
        long intExpected = 1000L;
        long intActual = interestCalculator
    }


}
