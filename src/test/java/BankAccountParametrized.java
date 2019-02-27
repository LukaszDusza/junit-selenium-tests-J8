import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class BankAccountParametrized {

    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountParametrized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @Before
    public void setup() {
        account = new BankAccount(
                "Zdzisław", "Python", 1000.00, BankAccount.CHECKING);

        System.out.println("Uruchamiam testy...");
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {100.00, false, 1109.00},
                {200.00, true, 1400.00},
                {325.14, true, 1400}
        });
    }

    @Test
    public void deposit() {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0);
    }


}
