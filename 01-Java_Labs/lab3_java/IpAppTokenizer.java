import java.util.StringTokenizer;

public class IpAppTokenizer
{
    public static void main(String[] args)
    {
        if (args.length != 1)
       	{
            System.out.println("basy wa7ed bas");
            return;
        }

        String ip = args[0];
        StringTokenizer tokenizer = new StringTokenizer(ip, ".");

        while (tokenizer.hasMoreTokens())
       	{
            System.out.println(tokenizer.nextToken());
        }
    }
}

