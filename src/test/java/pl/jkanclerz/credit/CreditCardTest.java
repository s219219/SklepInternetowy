package pl.jkanclerz.credit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CreditCardTest {
    @Test
    void itAllowsToAssignLimitToCreditCard() {
        //Arrange   // Given
        CreditCard card = new CreditCard();
        //Act       // When
        card.assignLimit(BigDecimal.valueOf(1000));
        //Assert    // Then // Expected
        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
    }

    @Test
    void itAllowsToAssignLimitToCreditCardV1() {
        CreditCard card = new CreditCard();
        card.assignLimit(BigDecimal.valueOf(2000));
        assertEquals(BigDecimal.valueOf(2000), card.getBalance());
    }

    void itAllowsToWithdrawSomeMoney() {
        //Arrange
        CreditCard card = new CreditCard();
        card.assignLimit(BigDecimal.valueOf(2000));
        //Act
        card.withdraw(BigDecimal.valueOf(500));
        //Assert
        assertEquals(BigDecimal.valueOf(1500), card.getBalance());
    }
}
