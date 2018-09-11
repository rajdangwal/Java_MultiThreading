class MyThread extends Thread
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			system.out.println("i = "+i+"\n");
		}
	}
}

class ThreadDemo1
{
	public static void main(String args[])
	{
		MyThread t = new MyThread();
		t.start();
		for(int j=0;j<10;j++)
		{
			system.out.println("j = "+j+"\n");
		}
	}
}
