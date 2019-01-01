package sb223ce_assign1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceTest {

    private Invoice sut;

    @BeforeEach // execute before each test
    public void setUp() {
        sut = new Invoice("1233", "Laptop", 2, 1200);
    }

    @Test
    public void shouldReturn24000AsInvoiceAmount() {
        Assertions.assertEquals(2400, sut.getInvoiceAmount());
    }

    @Test
    public void shouldReturn0AsInvoiceAmount() {
        sut.setQuantity(-2);
        Assertions.assertEquals(0, sut.getInvoiceAmount());
    }

    @Test
    public void shouldReturn1233AsNumber() {
        sut.setPrice(-1200);
        Assertions.assertEquals("1233", sut.getNumber());
    }

    @Test
    public void shouldReturnLaptopAsDescription() {
        Assertions.assertEquals("Laptop", sut.getDescription());
    }

    @Test
    public void shouldReturn2AsQuantity() {
        Assertions.assertEquals(2, sut.getQuantity());
    }

    @Test
    public void shouldReturn0AsQuantity() {
        sut.setQuantity(-2);
        Assertions.assertEquals(0, sut.getQuantity());
    }

    @Test
    public void shouldReturn1200AsPrice() {
        sut.setPrice(1200);
        Assertions.assertEquals(1200, sut.getPrice());
    }

    @Test
    public void shouldReturn0AsPrice() {
        sut.setPrice(-1200);
        Assertions.assertEquals(0, sut.getPrice());
    }
}
