public class RealNumberTester {


  public static void main(String[] args) {
    boolean failure = false;

    failure = equalsTester() || failure;

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
        passMessage(test);
      } else {
        System.out.println("a.equals(b)");
        errorMessage(test, Boolean.toString(expectedEvals[test]), Boolean.toString(a.equals(b)));
      }
    }

    return failure;
  }
}
