public class RealNumberTester {

  public static void main(String[] args) {
    boolean failure = false;

    failure = equalsTester() || failure;
    failure = realNumberToRealNumberAddTester(100) || failure;
    failure = realNumberToRealNumberMultiplyTester(100) || failure;
    failure = realNumberToRealNumberDivideTester(100) || failure;
    failure = realNumberToRealNumberSubtractTester(100) || failure;

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

  public static boolean equalsTester() {
    testerMessage("equalsTester()");
    boolean failure = false;

    RealNumber a;
    RealNumber b;
    double[][] vals = {
      {0, 0},
      {0, 1E-6},
      {1E-6, 0},
      {Math.PI, Math.PI - 1E-9},
      {Math.PI, Math.PI + 1E-4},
      {-Math.PI, Math.PI},
      {Math.PI, Math.PI + 1}
    };
    boolean[] expectedEvals = {
      true,
      false,
      false,
      true,
      false,
      false,
      false
    };

    for (int test = 0; test < vals.length; test++) {
      a = new RealNumber(vals[test][0]);
      b = new RealNumber(vals[test][1]);
      if (expectedEvals[test] == a.equals(b)) {
        //System.out.println("a.equals(b)");
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("a.equals(b)");
        errorMessage(test, Boolean.toString(expectedEvals[test]), Boolean.toString(a.equals(b)));
      }
      if (expectedEvals[test] == b.equals(a)) {
        //System.out.println("b.equals(a)");
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("b.equals(a)");
        errorMessage(test, Boolean.toString(expectedEvals[test]), Boolean.toString(b.equals(a)));
      }
    }

    methodMessage("equals()", failure);
    return failure;
  }

  public static boolean realNumberToRealNumberAddTester(int tests) {
    testerMessage("realNumberToRealNumberAddTester()");
    boolean failure = false;

    for (int test = 0; test < tests; test++) {
      double a = Math.random();
      double b = Math.random();
      RealNumber expected = new RealNumber(a + b);
      RealNumber a1 = new RealNumber(a);
      RealNumber b1 = new RealNumber(b);
      if (a1.add(b1).equals(expected)) {
        //System.out.println("a1.add(b1)");
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("a1.add(b1)");
        errorMessage(test, (a + b) + "", a1.add(b1).toString());
      }
      if (b1.add(a1).equals(expected)) {
        //System.out.println("b1.add(a1)");
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("b1.add(a1)");
        errorMessage(test, (a + b) + "", b1.add(a1).toString());
      }
    }

    methodMessage("realNumberToRealNumberAddTester()", failure);
    return false;
  }

  public static boolean realNumberToRealNumberMultiplyTester(int tests) {
    testerMessage("realNumberToRealNumberMultiplyTester()");
    boolean failure = false;

    for (int test = 0; test < tests; test++) {
      double a = Math.random();
      double b = Math.random();
      RealNumber expected = new RealNumber(a * b);
      RealNumber a1 = new RealNumber(a);
      RealNumber b1 = new RealNumber(b);
      if (a1.multiply(b1).equals(expected)) {
        //System.out.println("a1.multiply(b1)");
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("a1.multiply(b1)");
        errorMessage(test, (a * b) + "", a1.multiply(b1).toString());
      }
      if (b1.multiply(a1).equals(expected)) {
        //System.out.println("b1.multiply(a1)");
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("b1.multiply(a1)");
        errorMessage(test, (a * b) + "", b1.multiply(a1).toString());
      }
    }

    methodMessage("realNumberToRealNumberMultiplyTester()", failure);
    return false;
  }

  public static boolean realNumberToRealNumberDivideTester(int tests) {
    testerMessage("realNumberToRealNumberDivideTester()");
    boolean failure = false;

    for (int test = 0; test < tests; test++) {
      double a = Math.random();
      double b = Math.random();
      RealNumber expectedAOverB = new RealNumber(a / b);
      RealNumber expectedBOverA = new RealNumber(b / a);
      RealNumber a1 = new RealNumber(a);
      RealNumber b1 = new RealNumber(b);
      if (a1.divide(b1).equals(expectedAOverB)) {
        //System.out.println("a1.divide(b1)");
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("a1.divide(b1)");
        errorMessage(test, (a / b) + "", a1.divide(b1).toString());
      }
      if (b1.divide(a1).equals(expectedBOverA)) {
        //System.out.println("b1.divide(a1)");
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("b1.divide(a1)");
        errorMessage(test, (b / a) + "", b1.divide(a1).toString());
      }
    }

    methodMessage("realNumberToRealNumberDivideTester()", failure);
    return false;
  }

  public static boolean realNumberToRealNumberSubtractTester(int tests) {
    testerMessage("realNumberToRealNumberSubtractTester()");
    boolean failure = false;

    for (int test = 0; test < tests; test++) {
      double a = Math.random();
      double b = Math.random();
      RealNumber expectedAMinusB = new RealNumber(a - b);
      RealNumber expectedBMinusA = new RealNumber(b - a);
      RealNumber a1 = new RealNumber(a);
      RealNumber b1 = new RealNumber(b);
      if (a1.subtract(b1).equals(expectedAMinusB)) {
        //System.out.println("a1.subtract(b1)");
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("a1.subtract(b1)");
        errorMessage(test, (a - b) + "", a1.subtract(b1).toString());
      }
      if (b1.subtract(a1).equals(expectedBMinusA)) {
        //System.out.println("b1.subtract(a1)");
        //passMessage(test);
      } else {
        failure = true;
        System.out.println("b1.subtract(a1)");
        errorMessage(test, (b - a) + "", b1.subtract(a1).toString());
      }
    }

    methodMessage("realNumberToRealNumberSubtractTester()", failure);
    return false;
  }
}
