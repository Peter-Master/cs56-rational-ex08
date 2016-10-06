/** A class to represent a rational number
    with a numerator and denominator

    @author P. Conrad for CS56 F16

    */
/**
Peter Master, 10/4/2016
*/

import static java.lang.Math.abs;

public class Rational {

    private int num;
    private int denom;

    /**
    default constructor constructs a Rational object representing "1/1"
    */
    public Rational() {
		this.num = 1;
		this.denom = 1;
    }

    /**
    constructor that takes two arguments and constructs a Rational object representing "num/denom"
    @param num numerator
    @param denom denominator
    */
    public Rational(int num, int denom) {
		if (denom== 0) {
	    	throw new IllegalArgumentException("denominator may not be zero");
		}
		else if (denom < 0) {
			this.num = -1*num;
			this.denom = -1*denom;
		}
		else {
			this.num = num;
			this.denom = denom;
		}
		if (num != 0) {
	    	int gcd = Rational.gcd(num,denom);
	    	this.num /= gcd;
	    	this.denom /= gcd;
		}
    }

	/**
	greatest common divisor of a and b
	@param a first number
	@param b second number
	@return gcd of a and b
    */
    public static int gcd(int a, int b) {
    a = abs(a);
    b = abs(b);
	if (a==0)
	    return b;
	else if (b==0)
	    return a;
	else
	    return gcd(b%a, a);
    }

    /**
    lowest common multiple of a and b
    @param a first number
    @param b second number
    @return lcm of a and b
    */
    public static int lcm(int a, int b) {
    	if (b == 0)
    		return 0;
    	return abs(a) / gcd(a, b) * abs(b);
    }

     /**
    product of this and r
    @param r multiplier
    @return product of this and r
    */
	public Rational times(Rational r) {
		return new Rational(this.num * r.num,
			    			this.denom * r.denom);
    }

    /**
    product of a and b
    @param a multiplicand
    @param b multiplier
    @return product of a and b
    */
    public static Rational product(Rational a, Rational b) {
		return new Rational(a.num * b.num,
			    		a.denom * b.denom);
    }

    /**
    sum of this and r
    @param r adder
    @return sum of this and r
    */
    public Rational plus(Rational r) {
    	return 	new Rational(this.num * r.denom +
    						r.num*this.denom,
    						this.denom*r.denom);
    }

    /**
    sum of a and b
    @param a first number
    @param b second number
    @return sum of a and b
    */
    public static Rational sum(Rational a, Rational b) {
    	return new Rational(a.num*b.denom +
    						b.num*a.denom,
    						a.denom*b.denom);
    }

   /**
    difference of this and r
    @param r subtrahend
    @return difference of this and r
    */
    public Rational minus(Rational r) {
    	return this.plus(r.times(new Rational(-1, 1)));
    }

    /**
    difference of a and b
    @param a minuend
    @param b subtrahend
    @return sum of a and b
    */
    public static Rational difference(Rational a, Rational b) {
    	return a.plus(b.times(new Rational(-1, 1)));
    }

    /**
	reciprocal of this
    @return reciprocal of this
    */
    public Rational reciprocalOf() {
    	if (this.num == 0)
    		throw new java.lang.ArithmeticException("denominator may not be zero");
    	return new Rational(this.denom,this.num);
    }

    /**
    quotient of this and r
    @param r divisor
    @return quotient of this and r
    */
    public Rational dividedBy(Rational r) {
    	return this.times(r.reciprocalOf());
    }

    /**
    quotient of a and b
    @param a dividend
    @param b divisor
    @return quotient of a and b
    */
    public static Rational quotient(Rational a, Rational b) {
    	return a.times(b.reciprocalOf());
    }

    /**
    converts Rational object to String
    @return string conveying the Rational object's state
	*/
    public String toString() {
		if (denom == 1 || num == 0)
	    	return "" + num;
		return num + "/" + denom;
    }

    /**
    gets numerator of this
    @return numerator of this
    */
    public int getNumerator() { return this.num; }

    /**
    gets denominator of this
    @return denominator of this
    */
    public int getDenominator() { return this.denom; }

    public static void main (String [] args) {
		Rational r = new Rational(5,7);
		System.out.println("r.getNumerator()=" + r.getNumerator());
		System.out.println("r.getDenominator()=" + r.getDenominator());
    }

    
}
