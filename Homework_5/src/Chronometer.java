public class Chronometer {
    private int time = 0;

    public void countTime(Message messageOne, Message messageTwo, int period) {
        for (int i = 0; i < period; i++) {
            synchronized (this) {
                time += 1;
                System.out.println(time);
                if (i == period - 1) Message.finish = true;
                messageOne.flag = false;
                this.notify();
                messageTwo.flag = false;
                this.notify();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Message implements Runnable {
        public static boolean finish = false;
        public Chronometer chronometer;
        public boolean flag = true;
        private int time;

        public Message(int time, Chronometer chronometer) {
            this.time = time;
            this.chronometer = chronometer;
        }

        public void waitForTime() {
            while (true) {
                synchronized (chronometer) {
                    try {
                        while (flag)
                            chronometer.wait();
                        if (finish) return;
                        if (chronometer.time % this.time == 0) {
                            System.out.println("Thread " + this.time);
                            flag = true;
                        }
                        flag = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        public void run() {
            waitForTime();
            System.out.println("End");
        }
    }
}