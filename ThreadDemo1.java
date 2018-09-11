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
