
public class TestComplex {

	public static void main(String[] args) {
			MandelbrotGUI  gui = new MandelbrotGUI();
			Generator gen = new Generator();
			boolean exists = false;
			
			
			while(true) {
				int i = gui.getCommand();
				
				switch(i) {
				
				case MandelbrotGUI.RENDER: 
					//render
					exists = true;
					gen.render(gui);
					
					
					break;
					
				case MandelbrotGUI.ZOOM:
					if (exists) {
						gen.render(gui);
					}
					else {
						gui.resetPlane();
					}
					
					
					break;
				case MandelbrotGUI.RESET:
					//reset
					
					exists = false;
					gui.resetPlane();
					gui.clearPlane();
					
					
					break;
					
				case MandelbrotGUI.QUIT:
					
					System.exit(0);
					
					
					break;
				}
					
					
				
				
				
			}
					
					
		
	}

}