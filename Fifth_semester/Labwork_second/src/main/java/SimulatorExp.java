import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class SimulatorExp {
    public static void main(String[] args) throws InterruptedException {
        SpinLockCounter c = new SpinLockCounter();

        Thread first = new Thread(c, "First");
        Thread second = new Thread(c, "Second");

        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println(c.count);
    }
}

class AtomicCounter extends Thread {
    AtomicInteger count;
    AtomicCounter() {
        count = new AtomicInteger();
    }

    public void run() {
        for (int i = 0; i < 100000; i++) {
            count.addAndGet(1);
        }
    }
}
class SpinLockCounter extends Thread {

    private SpinLock lock = new SpinLock();
    int count = 0;

    public void run() {
        for(int i = 0 ;i < 100000;i++){
            lock.lock();
            count++;
            lock.unlock();
        }
    }
}
