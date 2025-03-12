class Calculator {
    private int num1;
    private int num2;

    Calculator() {
        this.num1 = 0;
        this.num2 = 0;
    }

    Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int sumTwoNumbers() {
        return num1 + num2;
    }
      public int subtractionTwoNumbers() {
        return num1 - num2;
    }

  public int multiplicationTwoNumbers() {
        return num1 * num2;
    }

  public int divisionTwoNumbers() {
        return num1 / num2;
    }


    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}

class MainClass {
    public static void main(String[] args) {
        Calculator ref = new Calculator(12, 4);
        System.out.println("The summation of " + ref.getNum1() + " and " + ref.getNum2() + " equals " + ref.sumTwoNumbers());
        System.out.println("The subtraction of " + ref.getNum1() + " and " + ref.getNum2() + " equals " + ref.subtractionTwoNumbers());
        System.out.println("The multiplication of " + ref.getNum1() + " and " + ref.getNum2() + " equals " + ref.multiplicationTwoNumbers());
        System.out.println("The division of " + ref.getNum1() + " and " + ref.getNum2() + " equals " + ref.divisionTwoNumbers());

    }
}
