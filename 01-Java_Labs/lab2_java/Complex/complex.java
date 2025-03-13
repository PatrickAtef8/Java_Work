class Complex {


    private int real;
    private int imag;

       public Complex(int real, int imag) 
       {
        this.real = real;
        this.imag = imag;
       }

       public void complexSum(Complex r1, Complex r2)
       {
        this.real = r1.real + r2.real;
        this.imag = r1.imag + r2.imag;
       }

        public void complexSubtract(Complex i1, Complex i2)
       	{
        this.real = i1.real - i2.real;
        this.imag = i1.imag - i2.imag;
        } 

public void printResult()
{
    if (imag >= 0)
    { 
        System.out.println(real + " + " + imag + "i");
    }
    else
    {  
        System.out.println(real + " - " + (-imag) + "i");
    }
}
}

class MainClass {
    public static void main(String[] args) {
              Complex c1 = new Complex(1, 2);
              Complex c2 = new Complex(3, 4);

              Complex result = new Complex(0, 0);

              result.complexSum(c1, c2);
              result.printResult();

       
              result.complexSubtract(c1, c2);
              result.printResult();
    }
}

