package sb223ce_assign1;

public class Invoice {

    private String number;
    private String description;
    private int quantity;
    private double price;

    public Invoice(String number, String description, int quantity, double price) {
        this.number = number;
        this.description = description;
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    public double getInvoiceAmount() {
        return this.quantity * this.price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        // if given quantity is negative, then make it 0, otherwise keep it same
        this.quantity = quantity < 0 ? 0 : quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // if given price is negative, then make it 0, otherwise keep it same
        this.price = price < 0.0 ? 0.0 : price;
    }
}
