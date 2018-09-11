/**
 *
 * @author rajendra
 */
class MyRunnable implements Runnable //insted of extending Thread class we can implement Runnable interface. Much beneficial while inheriting from other classes.
{
    public void run()//mandatory to override.
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("i = "+i+"\n");
        }
    }
}

public class ThreadDemo2 
{
    public static void main(String args[])
    {
        MyRunnable r = new MyRunnable();//object of MyRunnable
        Thread t = new Thread(r); //start can't be called on runnable object. Pass runnable object as parameter to Thread object.
        t.start();//Call start on thread object. Directly calling run() doesn't creates a new thread.
        for(int j=0;j<10;j++)
        {
            System.out.println("j = "+j+"\n");
        }           
    }
}
