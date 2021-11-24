package fractal;

import koch.Koch;
import mountain.MountainFractal;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Koch(300);
		fractals[1] = new MountainFractal(new Point(100,400), new Point(300,200), new Point(500,500), 20);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
