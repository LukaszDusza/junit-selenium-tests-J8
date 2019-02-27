

import org.junit.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;


public class BankAccountTest {

    private BankAccount bankAccount;
    private static int count = 0;

    @BeforeClass  //metoda wykona sie raz na poczatku testów.
    public static void beforeClass() {
        System.out.println("Test startuje, ładuję metodę BeforeClass " + count++);
    }

    @Before //metoda wykona sie jako pierwsza przed każdym testem.
    public void setup() {
        bankAccount = new BankAccount(
                "Lukasz", "Bankowy", 1000, BankAccount.SAVINGS);
        System.out.println("Startuje test...");
    }

    @Test //wykonuje testowanie
    public void deposit() {
        double balanse = bankAccount.deposit(200.00, true);
         assertEquals(1200.00, balanse, 0);
    }

    @Test
    public void withdraw() throws IllegalAccessException {
        double balance = bankAccount.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test
    public void isChecking_true() {
        assertTrue("Konto nie jest CHECKING", bankAccount.isChecking());

    }

    @Test
    public void inNull_True() {
        assertNotNull(bankAccount);
    }

    @After //wykona sie po każdym tescie.
    public void teardown() {
        System.out.println("Wykonałem test. " + count++);
    }

    @AfterClass //wykona sie raz po zakończonych testach.
    public static void afterClass() {
        System.out.println("Zakończenie działania programu. AfterClass");
    }
}
