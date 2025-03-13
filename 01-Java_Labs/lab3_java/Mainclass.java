public class Mainclass {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Please provide exactly 2 numbers and an operator (zy kedaa->>5 + 3) -_-");
            return;
        }
        int num1 = Integer.parseInt(args[0]);
	String operator = args[1];
        int num2 = Integer.parseInt(args[2]);

        int result;
        switch (operator)
       	{
            case "+":
                result = num1 + num2;
               break;
            case "-":
                result = num1 - num2;
                break;
            case "x":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Error: Division by zero -__-");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Wrong entryy");
                return;
        }

        System.out.println("Result: " + result);
    }
}

