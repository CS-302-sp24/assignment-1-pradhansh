public class DiningPhilosophers {  
  public static void main(String[] args) throws InterruptedException {
    int np = Integer.parseInt(args[0]);
    int nc = Integer.parseInt(args[1]);
    int tt = Integer.parseInt(args[2]);
    int et = Integer.parseInt(args[3]);
    int rl = Integer.parseInt(args[4]);
    // arguments we need
    Philosopher[] philosophers = new Philosopher[np];
    Chopstick[] chopsticks = new Chopstick[np];

    System.out.println("shreya");
    for (int i = 0; i < 5; ++i)
      chopsticks[i] = new Chopstick(i);
    for (int i = 0; i < 5; ++i) {
      philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % np], tt,et,nc,i,rl);
      philosophers[i].start();
    }
    for (int i = 0; i < 5; ++i)
      philosophers[i].join();
  }
}


