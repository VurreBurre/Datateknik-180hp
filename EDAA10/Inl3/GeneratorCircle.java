import java.awt.Color;

public class GeneratorCircle {
	
	public GeneratorCircle() {

		
	}
	
	public void render(MandelbrotGUI gui) {
		int resolution = gui.getResolution();
		int pixels =1;
		if (resolution == 2048) {
			pixels = 1;
		}else if (resolution == 1024) {
			pixels = 3;
		}else if (resolution == 512) {
			pixels = 5;
		}else if (resolution == 256) {
			pixels = 7;
		}else if (resolution == 128) {
			pixels = 9;
		}
		
		
		
		
		
		
		gui.disableInput();
	    Complex [][] mesh = mesh(gui.getMinimumReal(), gui.getMaximumReal(), gui.getMinimumImag(),
								gui.getMaximumImag(), gui.getWidth(), gui.getHeight());
		Color [][] picture = new Color[gui.getHeight()][gui.getWidth()];
		for (int i = 0; i < gui.getHeight(); i++) {
			for (int j = 0; j < gui.getWidth() ; j++) {
				
				
		
				
				
				
			
				if (mesh[i][j].getAbs2() > 1) {
				picture[i/pixels][j/pixels] = Color.WHITE;
				
				}else if (mesh[i][j].getRe() > 0 && mesh[i][j].getIm()>0) {//första kvadranten
					picture[i/pixels][j/pixels] = Color.RED;
				}else if (mesh[i][j].getRe() < 0 && mesh[i][j].getIm()>0) {//andra kvadranten
					picture[i/pixels][j/pixels] = Color.BLUE;
				}else if (mesh[i][j].getRe() < 0 && mesh[i][j].getIm()<0) {//tredje kvadranten
					picture[i/pixels][j/pixels] = Color.YELLOW;
				}else if (mesh[i][j].getRe() > 0 && mesh[i][j].getIm()<0) {//fjärde kvadranten
					picture[i/pixels][j/pixels] = Color.GREEN;
				}
				
				
				}}
		
		gui.putData(picture, pixels, pixels);
		gui.enableInput();
		
	}
		
		private Complex [][] mesh(double minRe, double maxRe, 
				double minIm, double maxIm, 
				int width, int height){
			
			Complex [][] a = new Complex[height][width];
					for (int i = 0; i < height; i++) {
						for (int k = 0; k < width; k++) {
							
							double im = maxIm - (((maxIm-minIm)/height)*i);
							double re = minRe + (((maxRe-minRe)/width)*k);
							a[i][k] = new Complex(re,im);
						}
					}
					
					return a;
			
		
	}
	
	
	

}