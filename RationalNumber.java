public class RationalNumber extends RealNumber {
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *  If the denominator is negative, negate both numerator and denominator
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno) {
    super(0.0);
    if (deno == 0 || nume == 0) {
      this.numerator = 0;
      this.denominator = 1;
    } else if (deno < 0) {
      this.numerator = -nume;
      this.denominator = -deno;
    } else {
      this.numerator = nume;
      this.denominator = deno;
    }
    this.reduce();
  }

  public double getValue() {
    return this.numerator / (double)this.denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator() {
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator() {
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal() {
    return new RationalNumber(this.denominator, this.numerator);
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other) {
    return (this.numerator == other.numerator && this.denominator == other.denominator);
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString() {
    return this.numerator + "/" + this.denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b) {
    /*use euclids method or a better one*/
    http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
    if (a == 0 || b == 0) {
      return 1;
    }

    a = Math.abs(a);
    b = Math.abs(b);

    if (a < b) {//Makes a the largest number
      int c = b;
      b = a;
      a = c;
    }

    int remainder = a % b;
    while (remainder != 0) {
      a = b;
      b = remainder;
      remainder = a % b;
    }

    return b;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce() {
    int gcd = gcd(this.numerator, this.denominator);
    this.numerator = this.numerator / gcd;
    this.denominator = this.denominator / gcd;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other) {
    return new RationalNumber(this.numerator * other.numerator, this.denominator * other.denominator);
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other) {
    return this.multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other) {
    int gcd = gcd(this.denominator, other.denominator);
    int otherMultiply = this.denominator / gcd;
    int thisMultiply = other.denominator / gcd;
    return new RationalNumber(this.numerator * thisMultiply + other.numerator * otherMultiply,
                              this.denominator * thisMultiply);
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other) {
    int gcd = gcd(this.denominator, other.denominator);
    int otherMultiply = this.denominator / gcd;
    int thisMultiply = other.denominator / gcd;
    return new RationalNumber(this.numerator * thisMultiply - other.numerator * otherMultiply,
                              this.denominator * thisMultiply);
  }
}
