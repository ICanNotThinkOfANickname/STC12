public class Main {
    public static void main(String[] args) throws InterruptedException {
        Chronometer chronometer = new Chronometer();
        Runnable stream1 = new Chronometer.Message(7, chronometer);
        Runnable stream2 = new Chronometer.Message(5, chronometer);
        new Thread(stream1, "Stream1").start();
        new Thread(stream2, "Stream2").start();
        chronometer.countTime((Chronometer.Message) stream1, (Chronometer.Message) stream2, 30);
    }
}
