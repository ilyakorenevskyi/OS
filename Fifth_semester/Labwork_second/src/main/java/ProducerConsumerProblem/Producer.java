package ProducerConsumerProblem;

import javax.swing.plaf.TableHeaderUI;
import java.util.Random;

public class Producer extends Thread{
    private Buffer buffer;
    //private Random rand;
    public Producer(Buffer buffer){
        this.buffer = buffer;
        //this.rand = new Random();
    }
    public void run(){
        while(true){
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            //int item = rand.nextInt(10);
            buffer.insertItem(1);
        }
    }
}
