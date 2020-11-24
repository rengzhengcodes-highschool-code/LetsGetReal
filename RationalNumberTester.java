public class RationalNumberTester {

  public static void main(String[] args) {
    boolean failure = false;

    failure = constructorValueTester(100) || failure;
    failure = getsTester(100) || failure;
    failure = overZeroTester(100) || failure;
    failure = reciprocalTester(100)  || failure;
    failure = reduceTester(100) || failure;
    failure = equalsTester() || failure;
    failure = toStringTester(100) || failure;
    failure = multiplyTester(100) || failure;
    failure = divideTester(100) || failure;
    failure = addTester(100) || failure;
    failure = subtractTester(100) || failure;

    System.out.println("\n ~~~ Overall Result ~~~");
    if (failure) {
      System.out.println("You overcooked the turkey.");
    } else {
      System.out.println("Happy Thanksgiving!");
    }
  }

  private static void passMessage (int testCase) {
    System.out.println("Test case " + testCase + " passed.");
  }

  private static void errorMessage(int testCase, String expected, String actual) {
    System.out.println("WE HAVE FAILED AT TEST CASE " + testCase);
    System.out.println("EXPECTED: " + expected);
    System.out.println("ACTUAL: " + actual);
  }

  private static void methodMessage(String method, boolean failure) {
    if (failure) {
      System.out.println("\nAt least one test case failed for " + method);
    } else {
      System.out.println(method + " PASSED");
    }
  }

  private static void testerMessage(String method) {
    System.out.println("\n ~~~ " + method + " TESTER ~~~");
  }

  private static int randInt(int start, int end) {
    return (int)Math.floor(Math.random() * (end - start)) + start;
  }

  private static int gcd(int a, int b) {
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

  private static int[] primes() {
    int[] primes = {
      2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
      43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
      101, 103, 107, 109, 113, 127, 131, 137, 139,
      149, 151, 157, 163, 167, 173, 179, 181, 191,
      193, 197, 199
    };
    return primes;
  }

  public static boolean constructorValueTester(int tests) {
    testerMessage("constructorValue()");
    boolean failure = false;
    RationalNumber[] testValues = {
      new RationalNumber(0, 1),
      new RationalNumber(1, 0),
      new RationalNumber(-1, 0),
      new RationalNumber(2, 0),
      new RationalNumber(-2, 0),
      new RationalNumber(0, 0)
    };

    System.out.println("Static fire barrage.");
    for (int test = 0; test < testValues.length; test++) {
      if (testValues[test].getValue() == 0) {
        //passMessage(test);
      } else {
        failure = true;
        errorMessage(test, "" + 0, "" + testValues[test].getValue());
      }
    }

    System.out.println("\nRandom Time");
    for (int test = 0; test < tests; test++) {
      int nume = randInt(1, 10000000);
      int deno = randInt(1, 10000000);
      int gcd = gcd(nume, deno);
      nume = nume / gcd;
      deno = deno / gcd;
      RealNumber realVal = new RealNumber(nume / (double)deno);
      RationalNumber testVal = new RationalNumber(nume, deno);
      if (realVal.equals(testVal)) {
        //passMessage(test);
      } else {
        failure = true;
        errorMessage(test, realVal.toString(), testVal.toString());
      }
    }

    methodMessage("constructorValueTester()", failure);
    return failure;
  }

  public static boolean getsTester(int tests) {
    testerMessage("gets()");
    boolean failure = false;
    RationalNumber[] testValues = {
      new RationalNumber(0, 1),
      new RationalNumber(1, 0),
      new RationalNumber(-1, 0),
      new RationalNumber(2, 0),
      new RationalNumber(-2, 0),
      new RationalNumber(0, 0)
    };

    System.out.println("Static fire barrage.");
    for (int test = 0; test < testValues.length; test++) {
      if (testValues[test].getValue() == 0) {
        //passMessage(test);
      } else {
        failure = true;
        errorMessage(test, "" + 0, "" + testValues[test].getValue());
      }
    }

    System.out.println("\nRandom Time");
    for (int test = 0; test < tests; test++) {
      int nume = randInt(1, 10000000);
      int deno = randInt(1, 10000000);
      int gcd = gcd(nume, deno);
      nume = nume / gcd;
      deno = deno / gcd;
      RealNumber realVal = new RealNumber(nume / (double)deno);
      RationalNumber testVal = new RationalNumber(nume, deno);

      if (realVal.getValue() == testVal.getValue()) {
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("getValue() failure");
        errorMessage(test, "" + realVal.getValue(), "" + testVal.getValue());
      }

      if (nume == testVal.getNumerator()) {
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("getNumerator() failure");
        errorMessage(test, "" + nume, "" + testVal.getNumerator());
      }

      if (deno == testVal.getDenominator()) {
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("getDenominator() failure");
        errorMessage(test, "" + deno, "" + testVal.getNumerator());
      }
    }

    methodMessage("getsTester()", failure);
    return failure;
  }

  public static boolean overZeroTester(int tests) {
    testerMessage("overZero Constructor");
    boolean failure = false;

    for (int test = 0; test < tests; test++) {
      RationalNumber testVal = new RationalNumber(test, 0);
      if (testVal.getNumerator() == 0 && testVal.getDenominator() == 1) {
        //passMessage(test);
      } else {
        failure = true;
        errorMessage(test, "0/1", testVal.toString());
      }
    }

    methodMessage("overZeroTester()", failure);
    return failure;
  }

  public static boolean reciprocalTester(int tests) {
    testerMessage("reciprocal()");
    boolean failure = false;
    RationalNumber[] testVals = {
      new RationalNumber(0, 1),
      new RationalNumber(1, 0),
      new RationalNumber(-1, 0),
      new RationalNumber(2, 0),
      new RationalNumber(2, 0),
      new RationalNumber(0, 2),
      new RationalNumber(0, -2),
      new RationalNumber(0, -1),
      new RationalNumber(0, 1),
      new RationalNumber(0, 0)
    };

    System.out.println("Static barrage");

    for (int test = 0; test < testVals.length; test++) {
      if (testVals[test].getValue() == 0) {
        //passMessage(test);
      } else {
        failure = true;
        errorMessage(test, "" + 0, "" + testVals[test].getValue());
      }
    }

    System.out.println("\nRandom Time");
    for (int test = 0; test < tests; test++) {
      int nume = randInt(1, 10000000);
      int deno = randInt(1, 10000000);
      int gcd = gcd(nume, deno);
      nume = nume / gcd;
      deno = deno / gcd;
      RealNumber realVal = new RealNumber(deno / (double)nume);
      RationalNumber testVal = new RationalNumber(nume, deno).reciprocal();

      if (realVal.getValue() == testVal.getValue()) {
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("getValue() failure");
        errorMessage(test, "" + realVal.getValue(), "" + testVal.getValue());
      }

      if (deno == testVal.getNumerator()) {
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("getNumerator() failure");
        errorMessage(test, "" + deno, "" + testVal.getDenominator());
      }

      if (nume == testVal.getDenominator()) {
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("getDenominator() failure");
        errorMessage(test, "" + nume, "" + testVal.getNumerator());
      }
    }


    methodMessage("reciprocalTester()", failure);
    return failure;
  }

  public static boolean reduceTester(int tests) {
    testerMessage("reduce()");
    boolean failure = false;
    int[] primes = primes();

    for (int test = 0; test < tests; test++) {
      int nume = primes[randInt(0, primes.length)];
      int deno;
      do {//makes sure nume != deno
        deno = primes[randInt(0, primes.length)];
      } while (nume == deno);

      int gcd = primes[randInt(0, primes.length)];
      gcd = (int)Math.pow(gcd, randInt(1, 4));
      //testing if it will reduce two primes not in common
      RationalNumber testVal = new RationalNumber(nume, deno);
      if (testVal.getNumerator() == nume && testVal.getDenominator() == deno) {
        //passMessage(test);
      } else {
        System.out.println("Trying to reduce 2 primes");
        failure = true;
        errorMessage(test, nume + "/" + deno, testVal.toString());
      }
      //testing if it can reduce x/x to 1/1
      testVal = new RationalNumber(nume, nume);
      if (testVal.getNumerator() == 1 && testVal.getDenominator() == 1) {
        //passMessage(test);
      } else {
        System.out.println("Can't reduce x/x to 1/1");
        failure = true;
        errorMessage(test, "1/1", testVal.toString());
      }
      //test with gcd in common
      testVal = new RationalNumber(nume * gcd, deno * gcd);
      if (testVal.getNumerator() == nume && testVal.getDenominator() == deno) {
        //passMessage(test);
      } else {
        System.out.println("Can't reduce (x*y)/(y*z) to x/z");
        failure = true;
        errorMessage(test, nume + "/" + deno, testVal.toString());
      }
      //testing x/1
      testVal = new RationalNumber(nume, 1);
      if (testVal.getNumerator() == nume && testVal.getDenominator() == 1) {
        //passMessage(test);
      } else {
        System.out.println("Trying to reduce out 1");
        failure = true;
        errorMessage(test, nume + "/1", testVal.toString());
      }
      //testing with gcd of multiple primes/relative primes
      int factors = randInt(2, 3);
      gcd = primes[randInt(0, primes.length)];
      for (int factor = 1; factor <= factors; factor++) {
        gcd *= primes[randInt(0, primes.length)];
      }
      testVal = new RationalNumber(nume * gcd, deno * gcd);
      if (testVal.getNumerator() == nume && testVal.getDenominator() == deno) {
        //passMessage(test);
      } else {
        System.out.println("Can't reduce (x*y)/(y*z) to x/z");
        failure = true;
        errorMessage(test, nume + "/" + deno, testVal.toString());
      }
    }

    methodMessage("reduceTester()", failure);
    return failure;
  }

  public static boolean equalsTester() {
    testerMessage("equals()");
    boolean failure = false;
    int[] primes = primes();
    RationalNumber[][] testVals = {
      {new RationalNumber(1, 2), new RationalNumber(2, 4)},
      {new RationalNumber(3, 4), new RationalNumber(1, 4)},
      {new RationalNumber(3, 8), new RationalNumber(3, 2)},
      {new RationalNumber(0, 1), new RationalNumber(0,10000)},
      {new RationalNumber(1, 0), new RationalNumber(2, 0)},
      {new RationalNumber(1, 0), new RationalNumber(0, 1)}
    };
    boolean[] expected = {
      true, false, false, true, true, true
    };
    int test = 0;
    for (RationalNumber[] testVal : testVals) {
      boolean output = testVal[0].equals(testVal[1]);
      if (output == expected[test]) {
        //passMessage(test);
      } else {
        failure = true;
        errorMessage(test, Boolean.toString(expected[test]), Boolean.toString(output));
      }
      test++;
    }

    methodMessage("equalsTester()", failure);
    return failure;
  }

  public static boolean toStringTester(int tests) {
    testerMessage("toString()");
    boolean failure = false;
    int[] primes = primes();

    for (int test = 0; test < tests; test++) {
      int nume = primes[randInt(0, primes.length)];
      int deno;
      do {//makes sure nume != deno
        deno = primes[randInt(0, primes.length)];
      } while (nume == deno);
      RationalNumber testVal = new RationalNumber(nume, deno);
      if (testVal.toString().equals(nume + "/" + deno)) {
        //passMessage(test);
      } else {
        failure = true;
        errorMessage(test, nume + "/" + deno, testVal.toString());
      }
    }

    for (int test = 0; test < tests; test++) {
      int nume = 0;
      int deno = randInt(1, 1000);
      RationalNumber testVal = new RationalNumber(nume, deno);
      if (testVal.toString().equals("0")) {
        //passMessage(test);
      } else {
        failure = true;
        errorMessage(test, "0", testVal.toString());
      }

      nume = randInt(1, 1000);
      deno = 1;
      testVal = new RationalNumber(nume, deno);
      if (testVal.toString().equals("" + nume)) {
        //passMessage(test);
      } else {
        failure = true;
        errorMessage(test, Integer.toString(nume), testVal.toString());
      }
    }

    methodMessage("toStringTester()", failure);
    return failure;
  }

  public static boolean multiplyTester(int tests) {
    testerMessage("multiply()");
    boolean failure = false;

    for (int test = 0; test < tests; test++) {
      RationalNumber testVal = new RationalNumber(randInt(0, (int)Math.pow(2, 8)), randInt(1, (int)Math.pow(2, 8)));
      RationalNumber testVal1 = new RationalNumber(randInt(0, (int)Math.pow(2, 8)), randInt(1, (int)Math.pow(2, 8)));
      RationalNumber product = testVal.multiply(testVal1);
      RationalNumber expected = new RationalNumber(testVal.getNumerator() * testVal1.getNumerator(),
                                                  testVal.getDenominator() * testVal1.getDenominator());
      if (expected.equals(product)) {
        //passMessage(test);
      } else {
        failure = true;
        errorMessage(test, expected.toString(), product.toString());
      }
    }

    methodMessage("multiplyTester()", failure);
    return failure;
  }

  public static boolean divideTester(int tests) {
    testerMessage("divide()");
    boolean failure = false;

    for (int test = 0; test < tests; test++) {
      RationalNumber testVal = new RationalNumber(randInt(0, (int)Math.pow(2, 8)), randInt(1, (int)Math.pow(2, 8)));
      RationalNumber testVal1 = new RationalNumber(randInt(0, (int)Math.pow(2, 8)), randInt(1, (int)Math.pow(2, 8)));
      RationalNumber quotient = testVal.divide(testVal1);
      RationalNumber expected = new RationalNumber(testVal.getNumerator() * testVal1.getDenominator(),
                                                  testVal.getDenominator() * testVal1.getNumerator());
      if (expected.equals(quotient)) {
        //passMessage(test);
      } else {
        failure = true;
        errorMessage(test, expected.toString(), quotient.toString());
      }
    }

    methodMessage("divideTester()", failure);
    return failure;
  }

  public static boolean addTester(int tests) {
    testerMessage("add()");
    boolean failure = false;

    for (int test = 0; test < tests; test++) {
      RationalNumber testVal = new RationalNumber(randInt(0, (int)Math.pow(2, 8)), randInt(1, (int)Math.pow(2, 8)));
      RationalNumber testVal1 = new RationalNumber(randInt(0, (int)Math.pow(2, 8)), randInt(1, (int)Math.pow(2, 8)));
      RationalNumber sum = testVal.add(testVal1);
      RationalNumber expected = new RationalNumber(testVal.getNumerator() * testVal1.getDenominator() + testVal1.getNumerator() * testVal.getDenominator(),
                                                  testVal.getDenominator() * testVal1.getDenominator());
      if (expected.equals(sum)) {
        //passMessage(test);
      } else {
        failure = true;
        errorMessage(test, expected.toString(), sum.toString());
      }
    }

    methodMessage("addTester()", failure);
    return failure;
  }

  public static boolean subtractTester(int tests) {
    testerMessage("subtract()");
    boolean failure = false;

    for (int test = 0; test < tests; test++) {
      RationalNumber testVal = new RationalNumber(randInt(0, (int)Math.pow(2, 8)), randInt(1, (int)Math.pow(2, 8)));
      RationalNumber testVal1 = new RationalNumber(randInt(0, (int)Math.pow(2, 8)), randInt(1, (int)Math.pow(2, 8)));
      RationalNumber difference= testVal.subtract(testVal1);
      RationalNumber expected = new RationalNumber(testVal.getNumerator() * testVal1.getDenominator() - testVal1.getNumerator() * testVal.getDenominator(),
                                                  testVal.getDenominator() * testVal1.getDenominator());
      if (expected.equals(difference)) {
        //passMessage(test);
      } else {
        failure = true;
        errorMessage(test, expected.toString(), difference.toString());
      }
    }

    methodMessage("subtractTester()", failure);
    return failure;
  }
}
