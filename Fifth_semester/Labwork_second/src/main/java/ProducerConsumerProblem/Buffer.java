package ProducerConsumerProblem;

public class Buffer {
    private int count = 0;
    private int maxCount;
    private int[] buffer;
    public Buffer(int size){
        maxCount = size-1;
        buffer = new int[maxCount];
    }
    public int getItem(){
        if(count==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int res = buffer[count-1];
        count--;
        if(count==maxCount-1){

            notify();
        }
        return res;
    }
    public void insertItem(int val){
        if(count==maxCount){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer[count] = val;
        count++;
        if(count==1){
            notify();
        }
    }

}
