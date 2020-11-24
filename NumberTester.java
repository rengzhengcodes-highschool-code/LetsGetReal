public class NumberTester {
  public static void main(String[] args) {
    System.out.println("\n ~~~ Overall Result ~~~");
    if (compareToTester()) {
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

  public static boolean compareToTester() {
    testerMessage("compareTo()");
    boolean failure = false;
    RationalNumber[] ratios = {
      new RationalNumber(1, 2),
      new RationalNumber(2, 3),
      new RationalNumber(3, 4),
      new RationalNumber(4, 5),
      new RationalNumber(5, 6)
    };
    RealNumber[] reals = {
      new RealNumber(1 / 2.),
      new RealNumber(2 / 3.),
      new RealNumber(3 / 4.),
      new RealNumber(4 / 5.),
      new RealNumber(5 / 6.)
    };

    for (int test = 0; test < ratios.length; test++) {
      for (int index = 0; index < ratios.length; index++) {
        if (test == index && (ratios[test].compareTo(ratios[index])) == 0) {
          //System.out.println("Test case: " + test + "\n Index: " + index);
        } else if (test - index < 0 && (ratios[test].compareTo(ratios[index])) < 0) {
          //System.out.println("Test case: " + test + "\n Index: " + index);
        } else if (test - index > 0 && (ratios[test].compareTo(ratios[index])) > 0) {
          //System.out.println("Test case: " + test + "\n Index: " + index);
        } else {
          failure = true;
          System.out.println("Test case: " + test + "\n Index: " + index);
          errorMessage((test+1) * (index+1), "Sign of: " + (test - index), "" + ratios[test].compareTo(ratios[index]));
        }
      }
    }

    for (int test = 0; test < reals.length; test++) {
      for (int index = 0; index < reals.length; index++) {
        if (test == index && (reals[test].compareTo(reals[index])) == 0) {
          //System.out.println("Test case: " + test + "\n Index: " + index);
        } else if (test - index < 0 && (reals[test].compareTo(reals[index])) < 0) {
          //System.out.println("Test case: " + test + "\n Index: " + index);
        } else if (test - index > 0 && (reals[test].compareTo(reals[index])) > 0) {
          //System.out.println("Test case: " + test + "\n Index: " + index);
        } else {
          failure = true;
          System.out.println("Test case: " + test + "\n Index: " + index);
          errorMessage((test+1) * (index+1), "Sign of: " + (test - index), "" + reals[test].compareTo(reals[index]));
        }
      }
    }

    for (int test = 0; test < reals.length; test++) {
      for (int index = 0; index < reals.length; index++) {
        if (test == index && (reals[test].compareTo(ratios[index])) == 0) {
          //System.out.println("Test case: " + test + "\n Index: " + index);
        } else if (test - index < 0 && (reals[test].compareTo(ratios[index])) < 0) {
          //System.out.println("Test case: " + test + "\n Index: " + index);
        } else if (test - index > 0 && (reals[test].compareTo(ratios[index])) > 0) {
          //System.out.println("Test case: " + test + "\n Index: " + index);
        } else {
          failure = true;
          System.out.println("Test case: " + test + "\n Index: " + index);
          errorMessage((test+1) * (index+1), "Sign of: " + (test - index), "" + reals[test].compareTo(reals[index]));
        }
      }
    }

    for (int test = 0; test < reals.length; test++) {
      for (int index = 0; index < reals.length; index++) {
        if (test == index && (ratios[test].compareTo(reals[index])) == 0) {
          //System.out.println("Test case: " + test + "\n Index: " + index);
        } else if (test - index < 0 && (ratios[test].compareTo(reals[index])) < 0) {
          //System.out.println("Test case: " + test + "\n Index: " + index);
        } else if (test - index > 0 && (ratios[test].compareTo(reals[index])) > 0) {
          //System.out.println("Test case: " + test + "\n Index: " + index);
        } else {
          failure = true;
          System.out.println("Test case: " + test + "\n Index: " + index);
          errorMessage((test+1) * (index+1), "Sign of: " + (test - index), "" + reals[test].compareTo(reals[index]));
        }
      }
    }

    methodMessage("compareToTester()", failure);
    return failure;
  }
}
