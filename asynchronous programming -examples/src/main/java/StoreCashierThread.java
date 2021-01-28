public class StoreCashierThread extends Thread{


    private String storeCashier;
    private Customer customer;
    private long initialTime;

    public StoreCashierThread(String storeCashier, Customer customer, long initialTime) {
        this.storeCashier = storeCashier;
        this.customer = customer;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        this.buy(customer,initialTime);
    }

    public void buy(Customer customer, long timeStamp) {
        System.out.println("The Cashier " + this.storeCashier + "The begins to process the purchase of the customer "
                + customer.getName() + "In the time " + (System.currentTimeMillis() - timeStamp) / 1000 + " Seconds ");

        for (int i = 0; i < customer.getShoppingCar().length; i++) {
            this.waitBySeconds(customer.getShoppingCar()[i]);
            System.out.println("The product processed " + i + 1 + " Time "
                    + (System.currentTimeMillis() - timeStamp) / 1000 + " Seconds ");
        }
        System.out.println("The cashier " + this.storeCashier + " has finished to process " + customer.getName() + " Time " +
                (System.currentTimeMillis() - timeStamp) / 1000 + " Seconds ");
    }

    private void waitBySeconds(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
