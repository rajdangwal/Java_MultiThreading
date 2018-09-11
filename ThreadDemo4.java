/**
 *
 * @author rajendra
 */

class MyThread4 extends Thread
{
    public static Thread mainThread;
    public void start()
    {
        mainThread = Thread.currentThread();
        super.start();
    }
    public void run()
    {
        System.out.println("Child thread waiting for the parent thread to finish.");
        try 
        {
            mainThread.join();
        } 
        catch (InterruptedException ex) 
        {
            System.out.println("Error Occoured.");
        }
        System.out.println("Parent thread finished. Child thread now ending.");
    }
}

public class ThreadDemo4 
{
    public static void main(String args[])
    {
        MyThread4 t = new MyThread4();
        t.start();
        
        for(int i=0;i<10;i++)
        {
            System.out.println("Main Thread Running.\n");
            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException e)
            {
                System.out.println("Error Occoured.");
            }
        }
    }
}
