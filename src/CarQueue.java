import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue {

    private Queue<Integer> cars;
    private Random num;

    public CarQueue()
    {
        cars = new LinkedList<>();
        num = new Random();
        for(int count = 0; count < 50; count++)
        {
            cars.add(num.nextInt(4));
        }
    }

    public void addToQueue()
    {
        class AnimationRun implements Runnable
        {
            public void run()
            {
                try
                {
                    while(true)
                    {
                        
                        synchronized(cars)
                        {
                        	int direct = num.nextInt(4);
                            cars.add(direct);
                        }
                        Thread.sleep(10);
                    }
                }
                catch(InterruptedException e)
                {
                }
            }
        }
        Runnable run = new AnimationRun();
        Thread thread = new Thread(run);
        thread.start();
    }

    public Integer deleteQueue()
    {
        synchronized(cars)
        {
            if(cars.isEmpty())
            {
                return -1;
            }
            return cars.poll();
        }
    }
}
