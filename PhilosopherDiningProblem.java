package learn.funda.concur.philosoper;

public class PhilosopherDiningProblem {

    public static void main(String[] args) throws Exception {
        long timeInMillisStart = System.currentTimeMillis();
        int numberOfChopStick = 7;
        System.out.println("Creating instances of number of chopstick =" + numberOfChopStick);
        Chopstick chopstick[] = new Chopstick[numberOfChopStick];
        for (int i = 0; i < numberOfChopStick; i++) {
            chopstick[i] = new Chopstick((i));
        }
        System.out.println("Creating instances of number of philosopher =" + numberOfChopStick);
        Philosopher philosopher[] = new Philosopher[numberOfChopStick];
        for (int i = 1; i < numberOfChopStick ; i++) {
            philosopher[i] = new Philosopher(chopstick[i - 1], chopstick[i], "Philosopher"+i);
        }
        philosopher[0] = new Philosopher(chopstick[numberOfChopStick -1], chopstick[0], "Philosopher "+numberOfChopStick);

        for (int i = 0; i < numberOfChopStick ; i++) {
            philosopher[i].start();
            philosopher[i].join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total time = "+ (endTime-timeInMillisStart));

        System.out.println("Main thread exits");
    }
}
