package eightbitsakathebigbyte;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jeriahhumphrey on 3/2/17.
 */
public class CheckedAccountTest {
    CheckedAccount checked1;
    CheckedAccount checked2;
    CheckedAccount checked3;
    Account account1 = new Account("checking", 30000l);
    Account account2 = new Account("savings", 20000l);
    Account account3 = new Account("money market", 3000000l);

    @Before
    public void setUp(){
        checked1=new CheckedAccount(account1);
        checked2=new CheckedAccount(account2);
        checked3=new CheckedAccount(account3);
    }

    @Test
    public void checkValidAccountTypeTest() {
        assertTrue(checked1.checkValidAccountType());
    }

    @Test
    public void checkValidAccountTypeTest2() throws Exception {
        account1.setAccountType("give me money");
        assertFalse(checked1.checkValidAccountType());
    }


    @Test
    public void isOverdraftTest(){
        account1.setBalance(-500l);
        assertTrue(checked1.isOverdraft());
    }
    @Test
    public void isOverdraftTest2(){
        assertFalse(checked1.isOverdraft());
    }

    @Test
    public void checkInterestRateNormalChecking(){
        assertEquals(0, checked1.checkInterestRate(), 0.0);

    }

    @Test
    public void checkInterestRateNormalSavings(){
        assertEquals(0.01, checked2.checkInterestRate(), 0.0);

    }

    @Test
    public void checkInterestRateNormalMoneyMarket(){
        assertEquals(0.05, checked3.checkInterestRate(), 0.0);

    }

    @Test
    public void checkInterestRateRMBSavings(){
        account2.setBalance(1000l);
        assertEquals(0.005, checked2.checkInterestRate(), 0.0);
    }

    @Test
    public void checkInterestRateRMBMoneyMarketTest(){
        account3.setBalance(1000l);
        assertEquals(-0.025, checked3.checkInterestRate(), 0.0);
    }



    @Test
    public void checkMinimumBalanceRequirementTest(){
        assertTrue(checked2.checkMinimumBalanceRequirement());
    }

    @Test
    public void checkRequiredMinimumBalance() throws Exception {
        assertEquals(10000, checked2.checkRequiredMinimumBalance());
    }

    @Test
    public void isRMBTest()  {
        account2.setBalance(1000l);
        assertTrue(checked2.isRMB());

    }

    @Test
    public void isRMBTest2()  {
        account3.setBalance(1000l);
        assertTrue(checked3.isRMB());

    }

    @Test
    public void setCheckedBalance() throws Exception {
        account1.setBalance(-1000l);
        assertEquals(-4000l,checked1.CheckBalance());

    }

}