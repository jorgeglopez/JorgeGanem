import java.sql.Timestamp;

public class StoreCashier {


    private String nameCashier;

    public StoreCashier(String nameCashier) {
        this.nameCashier = nameCashier;
    }

    public void buy(Customer customer, long timeStamp)  {
        System.out.println("The Cashier " +this.nameCashier+ "The begins to process the purchase of the customer "
                +customer.getName() +"In the time "+(System.currentTimeMillis()-timeStamp)/1000 +" Seconds ");

        for (int i=0;i<customer.getShoppingCar().length;i++){
            this.waitBySeconds(customer.getShoppingCar()[i]);
            System.out.println("The product processed " +i+1+ " Time "
                    +(System.currentTimeMillis()-timeStamp)/1000 +" Seconds ");
        }
        System.out.println("The cashier "+this.nameCashier+" has finished to process "+customer.getName()+" Time "+
                (System.currentTimeMillis()-timeStamp)/1000 +" Seconds " );
    }

    private void waitBySeconds(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

    }





}
