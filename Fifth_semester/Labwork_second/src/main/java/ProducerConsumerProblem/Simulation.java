package ProducerConsumerProblem;

public class Simulation {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(100);

        Thread producer = new Thread(new Producer(buffer),"Producer");
        Thread consumer = new Thread(new Consumer(buffer),"Consumer");
        producer.start();
        consumer.start();
    }
}
