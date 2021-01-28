public class Customer {

    private String name;
    private int ShoppingCar[];

    public Customer(String name, int[] shoppingCar) {
        this.name = name;
        ShoppingCar = shoppingCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getShoppingCar() {
        return ShoppingCar;
    }

    public void setShoppingCar(int[] shoppingCar) {
        ShoppingCar = shoppingCar;
    }

}
