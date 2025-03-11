class Student{

    private String name;
    private int age;
    private String track;


    Student()
    {     
        name = "Patrick Atef Karmy";
        age = 24;
        track = "Embedded Systems";
    }

    Student(String name, int age, String track)
    {
        this.name = name;
        this.age = age;
        this.track = track;
    }


    public String getStudentInfo()    
    {
        return "Name: " + name + "\n" + "Age: " + age +"\n" + "Track: " + track;
       
    }
}



class MainClass{

    public static void main(String[] args)
    {
        Student s = new Student();
        System.out.println(s.getStudentInfo());

    }
}


