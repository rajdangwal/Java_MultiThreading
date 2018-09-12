/**
 *
 * @author rajendra
 */
class Display
{
    public synchronized void wish(String name)//if not synchronized we will get mixed output.
    {
        for(int i=0;i<10;i++)
        {
            System.out.print("Good Morning : ");
            try
            {
                Thread.sleep(100);
            }
            catch(InterruptedException e)
            {
                
            }
            System.out.println(name);
        }
    }
}

class MyThread6 extends Thread
{
    Display d;
    String name;
    
    public MyThread6(Display d, String name)
    {
       this.d = d;
       this.name = name;
    }
    public void run()
    {
        d.wish(name);
    }
}

public class ThreadDemo6 
{
    public static void main(String[] args) 
    {
        Display d = new Display();
        //we will pass this display object to both the threads, so that it will be shared.
        //if we pass different objects then both threads can execute the synchronized methods simultaneously on different objects.
        MyThread6 t1 = new MyThread6(d,"Rajendra");
        MyThread6 t2 = new MyThread6(d,"Raju");
        
        t1.start();
        t2.start();
    }
    
}
