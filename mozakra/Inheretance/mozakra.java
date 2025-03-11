class Parent{

    int variable; 
    // public Parent(){}
    public Parent(int variable)
    {
        this.variable = variable;
    }
}


class Child extends Parent{

  int variable2; 
    public Child(int variable2)
    {
        this.variable2 = variable2;
    }
}


class MainClass{


    public static void main(String[] args)

            {    
                Parent c = new Parent(12);
                Child c1 = new Child(22);
                System.out.println( c.variable + " " + c1.variable2);
            }

}