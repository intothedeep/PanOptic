package com.kitri.admin.server;



public class Abortable 
{
	public boolean done = false;

	public Abortable() 
	{
		init();
	}

	public void init()
	{
		done = false;
	}

	public boolean isDone()
	{
		return done;
	}
}