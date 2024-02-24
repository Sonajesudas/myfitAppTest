import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class BankTest {
    private Bank bank;
    private InputStream inputStream;

    @Before
    public void setUp() {
        bank = new Bank();
        String input = "John\n1234567890\n1000";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @Test
    public void testCreateAccount() {
        bank.createAccount(new Scanner(System.in));
        assertEquals(1, bank.getAccounts().size());
    }

    @Test
    public void testDeposit() {
        bank.createAccount(new Scanner(System.in));
        String input = "1001\n500";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        bank.deposit(new Scanner(System.in));
        assertEquals(1500, bank.getAccounts().get("1001").intValue());
    }

    @Test
    public void testWithdraw() {
        bank.createAccount(new Scanner(System.in));
        String input = "1002\n700";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        bank.withdraw(new Scanner(System.in));
        assertEquals(300, bank.getAccounts().get("1002").intValue());
    }

    @Test
    public void testCheckBalance() {
        bank.createAccount(new Scanner(System.in));
        String input = "1003";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertEquals(1000, bank.checkBalance(new Scanner(System.in)));
    }
}
