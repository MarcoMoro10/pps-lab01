import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private static final int INITIAL_BALANCE = 0;
    private static final int DEPOSIT_AMOUNT = 100;
    private static final int WITHDRAW_AMOUNT = 70;
    private static final int UserID = 2;
    private static final int EXCEPTED_AMOUNT = 100;
    private static final String ACCOUNT_HOLDER_NAME="Mario";
    private static final String ACCOUNT_HOLDER_SURNAME="Rossi";


    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder(ACCOUNT_HOLDER_NAME, ACCOUNT_HOLDER_SURNAME, 1);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertAll(
                () -> assertEquals(0, bankAccount.getBalance()),
                () -> assertEquals(accountHolder, bankAccount.getHolder())
        );
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        assertEquals(EXCEPTED_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.deposit(UserID, 50);
        assertEquals(EXCEPTED_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), WITHDRAW_AMOUNT);
        assertEquals(30, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(UserID, WITHDRAW_AMOUNT);
        assertEquals(EXCEPTED_AMOUNT, bankAccount.getBalance());
    }
}
