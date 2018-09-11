/**
 *
 * @author rajendra
 */
class MyThread3 extends Thread
{
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Child Thread\n");
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                System.out.println("Error Occoured.");
            }
        }
    }
}

public class ThreadDemo3
{
    public static void main(String[] args) 
    {
        MyThread3 t = new MyThread3();
        t.start();
        
        try
        {
            t.join();//wait for thread t to finish.
        }
        catch(InterruptedException e)
        {
            System.out.println("Error Occoured.");
        }
        
        System.out.println("Main Thread.");
    }
}
