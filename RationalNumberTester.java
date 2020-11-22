public class RationalNumberTester {

  public static void main(String[] args) {
    boolean failure = false;

    failure = constructorValueTester(100) || failure;
    failure = getsTester(100) || failure;

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

  public static boolean constructorValueTester(int tests) {
    testerMessage("constructorValueTester()");
    boolean failure = false;
    RationalNumber[] testValues = {
      new RationalNumber(0, 1),
      new RationalNumber(1, 0),
      new RationalNumber(-1, 0),
      new RationalNumber(2, 0),
      new RationalNumber(2, 0)
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

    for (int test = 0; test < tests; test++) {
      int nume = randInt(1, 10000000);
      int deno = randInt(1, 10000000);
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
    testerMessage("getsTester()");
    boolean failure = true;

    RationalNumber[] testValues = {
      new RationalNumber(0, 1),
      new RationalNumber(1, 0),
      new RationalNumber(-1, 0),
      new RationalNumber(2, 0),
      new RationalNumber(2, 0)
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

    for (int test = 0; test < tests; test++) {
      int nume = randInt(1, 10000000);
      int deno = randInt(1, 10000000);
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
}
