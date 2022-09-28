package PetProjectScebold;

public class stopwatch {
	
	
	//Attributes
	private boolean running;
	private long startTime, stopTime, pausedTime;
	//Constructor
	public stopwatch() {
		running = false;
		startTime = 0;
		stopTime = 0;
		pausedTime = 0;
	}
	
	//Methods
	public boolean isRunning() {
		return this.running;
	}
	
	public void start() {
		this.running = true;
		this.startTime = System.currentTimeMillis();
	}
	private void stop() {
		this.running = false;
		this.stopTime = System.currentTimeMillis();
	}
	public void pause() {
		if(this.running) {
			stop();
			this.pausedTime += this.stopTime - this.startTime;
		}
	}
	
	public long getElapsedTime() {
		long elapsed = 0;
		if(this.running) {
			elapsed = System.currentTimeMillis() - this.startTime;
			elapsed += pausedTime;
		}
		else {
			elapsed += this.pausedTime;
		}
		return elapsed / 1000;
	}

}
