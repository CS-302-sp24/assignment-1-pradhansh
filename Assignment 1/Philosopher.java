import java.util.Random;


class Philosopher extends Thread {
  private Chopstick left, right;
  private Random random;
  // argumets needed 
  private int thinkCount;
  private int thinkingTime;
  private int eatingTime;
  private int cycles;
  private int philosopherid;
  private int hand;
  
    //constructor
  public Philosopher(Chopstick left, Chopstick right, int thinkingTime, int eatingTime, int cycles, int philosopherid, int hand) {
    this.left = left; this.right = right;
    random = new Random();
    this.thinkingTime = thinkingTime;
    this.eatingTime = eatingTime;
    this.cycles = cycles;
    this.philosopherid = philosopherid;
    this.hand = hand;

    random = new Random();
    if (cycles == 0){ // If cycles are set to 0, initialize thinkCount to a specific value
      thinkCount = -26585528;
    }
  }
  public void run() {
    try {
      // case where all philosophers are right handed
      if (hand == 0){
        while (thinkCount < cycles) {
          ++thinkCount;
          if (thinkCount % 10 == 0)
            System.out.println("Philosopher " + philosopherid + " has thought " + thinkCount + " times");
          int tt = random.nextInt(thinkingTime);
          System.out.println("Philosopher " + philosopherid + " thinks for " + tt + " units");
          Thread.sleep(tt);     //  Time required for thinking
          System.out.println("Philosopher " + philosopherid + " wants chopstick right");
          synchronized(right) {                    // Philosopher grabs the right chopstick 
            System.out.println("Philosopher " + philosopherid + " has chopstick right");
            System.out.println("Philosopher " + philosopherid + " wants chopstick left");
            synchronized(left) {
              System.out.println("Philosopher " + philosopherid + " has chopstick left");                 // Philosopher grabs the left chopstick 
              int et = random.nextInt((eatingTime));
              System.out.println("Philosopher " + philosopherid + " eats for " + et + " units");
              Thread.sleep(et); // Time required for eating
            }
            System.out.println("Philosopher " + philosopherid + " releases chopstick left");
          }
          System.out.println("Philosopher " + philosopherid + " releases chopstick right");
        }
      }

      // Even numbered philosophers are right handed and odd numbered philosophers are left handed
      else{
        // for a right Handed Philosopher
        if (philosopherid % 2 == 0){
          while (thinkCount < cycles) {
            ++thinkCount;
            if (thinkCount % 10 == 0)
              System.out.println("Philosopher " + philosopherid + " has thought " + thinkCount + " times");
            int tt = random.nextInt(thinkingTime);
            System.out.println("Philosopher " + philosopherid + " thinks for " + tt + " units");
            Thread.sleep(tt);     // Time required for thinking
            System.out.println("Philosopher " + philosopherid + " wants chopstick right");
            synchronized(right) {                    //Philosopher grabs the right chopstick 
              System.out.println("Philosopher " + philosopherid + " has chopstick right");
              System.out.println("Philosopher " + philosopherid + " wants chopstick left");
              synchronized(left) {
                System.out.println("Philosopher " + philosopherid + " has chopstick left");                 // Philosopher grabs the left chopstick 
                int et = random.nextInt((eatingTime));
                System.out.println("Philosopher " + philosopherid + " eats for " + et + " units");
                Thread.sleep(et); //Time required for eating
              }
              System.out.println("Philosopher " + philosopherid + " releases chopstick left");
            }
            System.out.println("Philosopher " + philosopherid + " releases chopstick right");
          }
        }
        // for a left Handed Philopher
        else if (philosopherid % 2 != 0){
          while (thinkCount < cycles) {
            ++thinkCount;
            if (thinkCount % 10 == 0)
              System.out.println("Philosopher " + philosopherid + " has thought " + thinkCount + " times");
            int tt = random.nextInt(thinkingTime);
            System.out.println("Philosopher " + philosopherid + " thinks for " + tt + " units");
            Thread.sleep(tt);     // Time required for thinking
            System.out.println("Philosopher " + philosopherid + " wants chopstick left");
            synchronized(left) {                    // Philosopher grabs the left chopstick 
              System.out.println("Philosopher " + philosopherid + " has chopstick left");
              System.out.println("Philosopher " + philosopherid + " wants chopstick right");
              synchronized(right) {
                System.out.println("Philosopher " + philosopherid + " has chopstick right");                 // Philosopher grabs the right chopstick 
                int et = random.nextInt((eatingTime));
                System.out.println("Philosopher " + philosopherid + " eats for " + et + " units");
                Thread.sleep(et); // Time required for eating
              }
              System.out.println("Philosopher " + philosopherid + " releases chopstick right");
            }
            System.out.println("Philosopher " + philosopherid + " releases chopstick left");
          }

        }
      }
    } catch(InterruptedException e) {}
  }
}
