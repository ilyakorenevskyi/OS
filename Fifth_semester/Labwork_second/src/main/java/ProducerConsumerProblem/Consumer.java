package ProducerConsumerProblem;

import java.util.Random;

public class Consumer extends Thread{
    private Buffer buffer;
    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }
    public void run(){
        while(true){
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            buffer.getItem();
        }
    }
}
