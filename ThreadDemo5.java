/**
 *
 * @author rajendra
 */
//Synchronized: Used for providing mutual exclusive access to threads on synchronized blocks or methods for given object. There is no concept of synchronized class or variable
//Each object has an internal lock. If thread wants to excuted synchronized block or method on given object it has to acquire lock of that object. After the execution
//completes thread automatically releases the lock. While one thread is executing any sync method/block other threads can't execute any sync method/block on same object.

class SyncClass
{
    int sharedVal;
    //only a single thread can execute any of the two methods method1 or method2 at a time.
    public synchronized void method1()
    {
        System.out.println("Thread : "+Thread.currentThread().getName()+" ++sharedVal : "+ ++sharedVal);//writing to sharedVal
    }
    public synchronized void method2()
    {
        System.out.println("Thread : "+Thread.currentThread().getName()+" sharedVal : "+ sharedVal);//reading sharedVal
    }
    public void method3()//This method can be executed without mutual exclusion. Therefore can be executed concurrently with any sych method.
    {
        System.out.println("Thread : "+Thread.currentThread().getName()+" sharedVal(unsync) : "+ sharedVal);
    }
}

class MyThread5 extends Thread
{
    static SyncClass X;//we want this object to be shared between threads. Therefore made static. This can be done without static variable.
    
    public void run()
    {
        for(int i=0;i<50000;i++)
        {
            X.method1();
//            try
//            {
//                Thread.sleep(0);
//            }
//            catch(InterruptedException e)
//            {
//                
//            }
//            X.method2();

        }
    }
}
public class ThreadDemo5 
{
    public static void main(String[] args) 
    {
        SyncClass Y = new SyncClass();//Creating object that will be shared.
        MyThread5.X = Y;//X will now refer to shared object for both threads.
        
        MyThread5 Obj1 = new MyThread5();
        MyThread5 Obj2 = new MyThread5();
        
        Obj1.start();
        Obj2.start();
        
    }
}
