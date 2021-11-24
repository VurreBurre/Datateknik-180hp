public class Complex {
	private double re;
	private double im;
	private double z;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
		
	
	
	}
	
	public double getRe() {
		return re;
		
	}
	
	public double getIm() {
		return im;
		
	}
	
	public double getAbs2() {
		
		return Math.pow(re, 2) + Math.pow(im, 2);
		
	}
	
	public void add(Complex c) {
		double cRe = c.getRe();
		double cIm = c.getIm();
		re = re + cRe;
		im = im + cIm;
		
		
	}
	
	public void mul(Complex c) {
		double cRe = c.getRe();
		double cIm = c.getIm();
		double f = re;
		re = (re*cRe - im*cIm);
	    im = (im*cRe + f*cIm);
		
		
	}

}