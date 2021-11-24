package ovn8;
	import se.lth.cs.window.SimpleWindow;
	
	
	class RaceTrack {
		private int yStart;
		private int yFinish;
		private int windowWidth;
		private int windowHeight;
	
	
		

	public RaceTrack(int yStart, int yFinish) {
	 this.yStart = yStart;
	 this.yFinish = yFinish;
	 
	
	}
	public void WindowSize(int Height, int Width){
		this.windowHeight = Height;
		this.windowWidth = Width;
		
	}
	
	public void draw(SimpleWindow w) {
		int startFinishLine = windowWidth/4;
		Turtle t = new Turtle(w, startFinishLine, yStart );
		t.penDown();
		t.right(90);
		t.forward(windowWidth/2);
		t.jumpTo(startFinishLine, yFinish);
		t.forward(windowWidth/2);
		
		
	}
	public int getyFinish() {
		return this.yFinish;
	}
	

}
