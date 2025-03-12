class OddEven {
    private int num;

    OddEven(int num){
        this.num = num;
    }

    public void checkOddEven(int num){
        if (num % 2 == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }
}

class MainClass {
    public static void main(String[] args) {
        OddEven obj = new OddEven(4);
        obj.checkOddEven(4);
    }
}
