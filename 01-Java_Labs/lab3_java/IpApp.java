public class IpApp {
    public static void main(String[] args) {
        if (args.length != 1)
       	{
            System.out.println("Pass only one arggggg -__-");
            return;
        }

        String ip = args[0];
        int start = 0;
	int dotIndex;
        //int dotIndex = ip.indexOf(".", start);

        while((dotIndex= ip.indexOf(".",start))  != -1)
     	  	{ 

            System.out.println(ip.substring(start, dotIndex));

            start = dotIndex+1;

            }

        if (start < ip.length())
       	{
            System.out.println(ip.substring(start));
        }
    }
}

