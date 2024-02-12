import java.util.Random;


class Philosopher extends Thread {
  private Chopstick left, right;
  private Random random;
  private int thinkCount;
  private int thinkingTime;
  private int eatingTime;
  private int cycles;
  private int id;
  private int hand;
  

  public Philosopher(Chopstick left, Chopstick right, int thinkingTime, int eatingTime, int cycles, int id, int hand) {
    this.left = left; this.right = right;
    random = new Random();
    this.thinkingTime = thinkingTime;
    this.eatingTime = eatingTime;
    this.cycles = cycles;
    this.id = id;
    this.hand = hand;

    random = new Random();
    if (cycles == 0){
      thinkCount = -26585528;
    }
  }
  public void run() {
    try {
      // All philosophers are right handed
      if (hand == 0){
        while (thinkCount < cycles) {
          ++thinkCount;
          if (thinkCount % 10 == 0)
            System.out.println("Philosopher " + id + " has thought " + thinkCount + " times");
          int tt = random.nextInt(thinkingTime);
          System.out.println("Philosopher " + id + " thinks for " + tt + " units");
          Thread.sleep(tt);     // Think for a while
          System.out.println("Philosopher " + id + " wants chopstick right");
          synchronized(right) {                    // Grab right chopstick 
            System.out.println("Philosopher " + id + " has chopstick right");
            System.out.println("Philosopher " + id + " wants chopstick left");
            synchronized(left) {
              System.out.println("Philosopher " + id + " has chopstick left");                 // Grab left chopstick
              int et = random.nextInt((eatingTime));
              System.out.println("Philosopher " + id + " eats for " + et + " units");
              Thread.sleep(et); // Eat for a while
            }
            System.out.println("Philosopher " + id + " releases chopstick left");
          }
          System.out.println("Philosopher " + id + " releases chopstick right");
        }
      }

      // Even philosophers are right handed and odd philosophers are left handed
      else{
        // right Handed Philosopher
        if (id % 2 == 0){
          while (thinkCount < cycles) {
            ++thinkCount;
            if (thinkCount % 10 == 0)
              System.out.println("Philosopher " + id + " has thought " + thinkCount + " times");
            int tt = random.nextInt(thinkingTime);
            System.out.println("Philosopher " + id + " thinks for " + tt + " units");
            Thread.sleep(tt);     // Think for a while
            System.out.println("Philosopher " + id + " wants chopstick right");
            synchronized(right) {                    // Grab right chopstick 
              System.out.println("Philosopher " + id + " has chopstick right");
              System.out.println("Philosopher " + id + " wants chopstick left");
              synchronized(left) {
                System.out.println("Philosopher " + id + " has chopstick left");                 // Grab left chopstick
                int et = random.nextInt((eatingTime));
                System.out.println("Philosopher " + id + " eats for " + et + " units");
                Thread.sleep(et); // Eat for a while
              }
              System.out.println("Philosopher " + id + " releases chopstick left");
            }
            System.out.println("Philosopher " + id + " releases chopstick right");
          }
        }
        // left Handed Philopher
        else if (id % 2 != 0){
          while (thinkCount < cycles) {
            ++thinkCount;
            if (thinkCount % 10 == 0)
              System.out.println("Philosopher " + id + " has thought " + thinkCount + " times");
            int tt = random.nextInt(thinkingTime);
            System.out.println("Philosopher " + id + " thinks for " + tt + " units");
            Thread.sleep(tt);     // Think for a while
            System.out.println("Philosopher " + id + " wants chopstick left");
            synchronized(left) {                    // Grab left chopstick 
              System.out.println("Philosopher " + id + " has chopstick left");
              System.out.println("Philosopher " + id + " wants chopstick right");
              synchronized(right) {
                System.out.println("Philosopher " + id + " has chopstick right");                 // Grab right chopstick
                int et = random.nextInt((eatingTime));
                System.out.println("Philosopher " + id + " eats for " + et + " units");
                Thread.sleep(et); // Eat for a while
              }
              System.out.println("Philosopher " + id + " releases chopstick right");
            }
            System.out.println("Philosopher " + id + " releases chopstick left");
          }

        }
      }
    } catch(InterruptedException e) {}
  }
}
