/**
 *
 * @author rajendra
 */
class MyThread extends Thread
{
    public void start()//this start is called not the default one. So explicitly call default start.
    {
        super.start();//This start is in Thread class. Creates new thread and calls run().
        System.out.println(Thread.currentThread().getName()+" : My start is running now.");//This will be executed by calling thread not the newly created thread.
    }
    public void run()//This will be executed by newly created thread. If we don't define it run() method of Thread class overriden from Runnable interface will be executed.
    {
        run(5);
        for(int i=0;i<10;i++)
        {
                System.out.println(Thread.currentThread().getName()+" : i = "+i+"\n");
        }
    }
    
    public void run(int i)
    {
        System.out.println(Thread.currentThread().getName()+" : This is my run(int i) called from default run.");
    }
}

public class ThreadDemo1
{
    public static void main(String args[])
    {
        MyThread t = new MyThread();
        t.start();
        for(int j=0;j<10;j++)
        {
                System.out.println(Thread.currentThread().getName()+" : j = "+j+"\n");
        }
    }
}
