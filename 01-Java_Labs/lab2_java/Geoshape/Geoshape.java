

abstract class Geoshape
{
    protected double dim1;
    protected double dim2;

    public Geoshape(double dim1, double dim2)
    {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    public abstract double calcAreas();  

    public static double sumAreas(Geoshape s1, Geoshape s2, Geoshape s3)
    {
        return s1.calcAreas() + s2.calcAreas() + s3.calcAreas();
    }
}

class Rectangle extends Geoshape 
{
    public Rectangle(double dim1, double dim2)
    {
        super(dim1, dim2);
    }

 
    public double calcAreas() 
    {
        return dim1 * dim2;
    }
}

class Circle extends Geoshape
{
    public Circle(double radius)
    {
        super(radius, 0);
    }

  
    public double calcAreas()
    {
        return 3.14 * dim1 * dim1;
    }
}

class Triangle extends Geoshape
{
    public Triangle(double dim1, double dim2)
    {
        super(dim1, dim2);
    }

    
    public double calcAreas()
    {
        return 0.5 * dim1 * dim2;
    }
}

class MainClass
{
    public static void main(String[] args)
    {
        Geoshape rect = new Rectangle(5, 4); //20
        Geoshape circle = new Circle(3);// 28 w shwya
        Geoshape triangle = new Triangle(6, 2); //6

        double totalArea = Geoshape.sumAreas(rect, circle, triangle);

        System.out.println("Total Area: " + totalArea);
    }
}

