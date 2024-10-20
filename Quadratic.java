import java.util.*;
class Quadratic {
  public static void main(String[] args) {
    int a, b, c;
    double discriminant;
    double r1, r2;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the value for a : ");
    a = sc.nextInt();
    System.out.print("Enter the value for b : ");
    b = sc.nextInt();
    System.out.print("Enter the value for c : ");
    c = sc.nextInt();
    discriminant = b * b - (4 * a * c);
    if (discriminant == 0) {
      System.out.println("The discriminant is zero and has 2 equal roots");
      r1 = r2 = (double) -b / (2 * a);
      System.out.println("The roots are " + r1 + " & " + r2);
    } else if (discriminant > 0) {
      System.out.println(
          "The discriminant is greater than zero and has 2 distinct roots");
      r1 = ((double) -b / (2 * a)) + Math.sqrt(discriminant);
      r2 = (double) -b / (2 * a) - Math.sqrt(discriminant);

      Zain Mahedi – 1WA23CS056 System.out.println(
          "The roots are " + r1 + " & " + r2);
    } else {
      System.out.println(
          "The discriminant is less than zero and has no real roots");
    }
  }
}