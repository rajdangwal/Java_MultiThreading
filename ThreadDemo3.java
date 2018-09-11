/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
            t.join();
        }
        catch(InterruptedException e)
        {
            System.out.println("Error Occoured.");
        }
        
        System.out.println("Main Thread.");
    }
}