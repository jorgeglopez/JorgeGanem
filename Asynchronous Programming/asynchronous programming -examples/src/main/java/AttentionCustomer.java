import java.util.concurrent.ThreadFactory;

public class AttentionCustomer extends Thread{


    private String attentionCustomer;
    private Customer customer;
    private long initialTime;

    public AttentionCustomer(String attentionCustomer, Customer customer, long initialTime) {
        this.attentionCustomer = attentionCustomer;
        this.customer = customer;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        this.attention(customer,initialTime);
    }

    public ThreadFactory attention(Customer customer, long timeStamp) {
        System.out.println("The attention of " + this.attentionCustomer + "the process the service technical "
                + customer.getName() + "completed in " + (System.currentTimeMillis() - timeStamp) / 1000 + " Seconds ");

        for (int i = 0; i < customer.getShoppingCar().length; i++) {
            this.waitBySeconds(customer.getShoppingCar()[i]);
            System.out.println("The service processed " + i + 1 + " Time "
                    + (System.currentTimeMillis() - timeStamp) / 1000 + " Seconds ");
        }
        System.out.println("The cashier " + this.attentionCustomer + " has finished to process " + customer.getName() + " Time " +
                (System.currentTimeMillis() - timeStamp) / 1000 + " Seconds ");
        return null;
    }

    private void waitBySeconds(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
