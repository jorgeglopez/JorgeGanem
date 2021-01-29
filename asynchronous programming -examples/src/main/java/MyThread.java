public class MyThread implements Runnable{

    public MyThread(String nameThread){

    }

    @Override
    public void run(){
        for (int i= 0; i<=5; i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            System.out.println("The Priority es "+Thread.currentThread().getPriority());
            try{

                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }




}
