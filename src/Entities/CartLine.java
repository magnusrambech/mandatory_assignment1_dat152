package Entities;

public class CartLine {
    private Product product;
    private int quantity;
    private double total;

    public CartLine(Product p, int q){
        this.product = p;
        this.quantity = q;
        this.total = p.getPriceInEuro() * q;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
