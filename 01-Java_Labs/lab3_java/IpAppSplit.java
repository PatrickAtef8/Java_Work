public class IpAppSplit {
    public static void main(String[] args) {
        if (args.length != 1)
       	{
            System.out.println("basy arg wa7ed bas");
           return;
        }

        String ip = args[0];

        String[] parts = ip.split("\\."); 

        for (int i = 0; i < parts.length; i++)
       	{
            System.out.println(parts[i]); 
        }
    }
}

