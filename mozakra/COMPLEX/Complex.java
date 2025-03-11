


class Complex{

    private int real;
    private int imag;


    public Complex()
        {
            real=0;
            imag=0;
        }

   public Complex(int real, int imag)
        {
            this.real = real;
            this.imag = imag;
        }

    public void setReal(int real)
        {
            this.real = real;
        }

    public void setImag(int imag)
        {
            this.imag = imag;
        }

        public int getReal()
        {
            return real;
        }

        public int getImag()
        {
            return imag;
        }

        public void addComplex(Complex c1, Complex c2)
        {
            this.real = c1.real+c2.real;
            this.imag = c1.imag+c2.imag;
        }
         public void subtractComplex(Complex c1, Complex c2)
        {
            this.real = c1.real-c2.real;
            this.imag = c1.imag-c2.imag;
        }

    public void printResult()
    {
        if (imag > 0)
        { 
            if (imag == 0)
            {
               System.out.println(real);
            }

            System.out.println(real + " + " + imag + "i");
        }
       
        else
        {

        
            if (imag == 0)
            {
            System.out.println(real);
            }

            else
            {

            System.out.println(real + " - " + (-imag) + "i");
            }
        }
    }
}




class MainClass{


    public static void main(String[] args)
    {
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(1,4);

        Complex result = new Complex();

        result.addComplex(c1,c2);
        System.out.print("Summation: ");
        result.printResult();

        result.subtractComplex(c1,c2);
        System.out.print("Subtraction: ");
        result.printResult();




    }
}