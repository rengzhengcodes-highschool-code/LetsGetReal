public class RationalToRealNumberCompatibilityTester {

  public static void main(String[] args) {
    boolean failure = false;

    //failure = arithmeticTester(100) || failure;
    failure = equalsTester(100) || failure;

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

  public static boolean equalsTester(int tests) {
    testerMessage("equals()");
    boolean failure = false;

    for (int test = 0; test < tests; test++) {
      int nume = randInt(1, 10000);
      int deno = randInt(1, 10000);
      double fp = nume / (double)deno;
      RationalNumber x = new RationalNumber(nume, deno);
      RealNumber y = new RealNumber(fp);
      if (x.equals(y)) {
        //System.out.println("x.equals(y)");
        //passMessage(test);
      } else {
        System.out.println("x.equals(y)");
        errorMessage(test, "true", Boolean.toString(x.equals(y)));
        failure = true;
      }

      if (y.equals(x)) {
        //System.out.println("y.equals(x)");
        //passMessage(test);
      } else {
        System.out.println("y.equals(x)");
        errorMessage(test, "true", Boolean.toString(y.equals(x)));
        failure = true;
      }

      do {
        fp = Math.random();
      } while(fp == x.getValue());
      y = new RealNumber(fp);

      if (!x.equals(y)) {
        //System.out.println("x.equals(y)");
        //passMessage(test);
      } else {
        System.out.println("x.equals(y)");
        errorMessage(test, "false", Boolean.toString(x.equals(y)));
        failure = true;
      }
      if (!y.equals(x)) {
        //System.out.println("y.equals(x)");
        //passMessage(test);
      } else {
        System.out.println("y.equals(x)");
        errorMessage(test, "false", Boolean.toString(y.equals(x)));
        failure = true;
      }
    }

    methodMessage("equalsTester()", failure);
    return failure;
  }

  /*public static boolean arithmeticTester(int tests) {
    testerMessage("arithmetic");
    boolean failure = false;

    for (int test = 0; test < tests; test++) {
      int nume = randInt(1, 10000);
      int deno = randInt(1, 10000);
      double fpValue = Math.random();
      //System.out.println("\n" + nume + "\n" + deno + "\n" + fpValue);
      RationalNumber x = new RationalNumber(nume, deno);
      RealNumber y = new RealNumber(fpValue);

      RealNumber answer = new RealNumber((nume / (double)deno) + fpValue);
      RealNumber output = x.add(y);
      RealNumber output1 = y.add(x);
      if (answer.equals(output)) {
        //System.out.println("x.add(y)");
        //passMessage(test);
      } else {
        System.out.println("x.add(y)");
        failure = true;
        errorMessage(test, answer.toString(), output.toString());
      }
      if (answer.equals(output1)) {
        //System.out.println("y.add(x)");
        //passMessage(test);
      } else {
        System.out.println("y.add(x)");
        failure = true;
        errorMessage(test, answer.toString(), output1.toString());
      }

      answer = new RealNumber((nume / (double)deno) - fpValue);
      RealNumber answer1 = new RealNumber(fpValue - (nume / (double)deno));
      output = x.subtract(y);
      output1 = y.subtract(x);
      if (answer.equals(output)) {
        //System.out.println("x.subtract(y)");
        //passMessage(test);
      } else {
        System.out.println("x.subtract(y)");
        failure = true;
        errorMessage(test, answer.toString(), output.toString());
      }
      if (answer1.equals(output1)) {
        //System.out.println("y.subtract(x)");
        //passMessage(test);
      } else {
        System.out.println("y.subtract(x)");
        failure = true;
        errorMessage(test, answer1.toString(), output1.toString());
      }

      answer = new RealNumber((nume / (double)deno) * fpValue);
      output = x.multiply(y);
      output1 = y.multiply(x);
      if (answer.equals(output)) {
        //System.out.println("x.multiply(y)");
        //passMessage(test);
      } else {
        System.out.println("x.multiply(y)");
        failure = true;
        errorMessage(test, answer.toString(), output.toString());
      }
      if (answer.equals(output1)) {
        //System.out.println("y.multiply(x)");
        //passMessage(test);
      } else {
        System.out.println("y.multiply(x)");
        failure = true;
        errorMessage(test, answer.toString(), output1.toString());
      }

      answer = new RealNumber((nume / (double)deno) / fpValue);
      answer1 = new RealNumber(fpValue / (nume / (double)deno));
      output = x.divide(y);
      output1 = y.divide(x);
      if (answer.equals(output)) {
        //System.out.println("x.divide(y)");
        //passMessage(test);
      } else {
        System.out.println("x.divide(y)");
        failure = true;
        errorMessage(test, answer.toString(), output.toString());
      }
      if (answer1.equals(output1)) {
        //System.out.println("y.divide(x)");
        //passMessage(test);
      } else {
        System.out.println("y.divide(x)");
        failure = true;
        errorMessage(test, answer1.toString(), output1.toString());
      }
    }

    methodMessage("arithmeticTester", failure);
    return failure;
  }*/
}
