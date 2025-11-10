package ss11_Stack_Queue.mvc.entity;

public class Products {
    private int id;
    private String name;
    private  float price;
    private int quantity;
    public Products(){

    }
    public Products(int id,String name, float price,int quantity){
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Products: \n" +
                "   id=" + id +
                "\n name='" + name  +
                "\n price=" + price +
                "\n quantity=" + quantity +
                "\n}";
    }
}
