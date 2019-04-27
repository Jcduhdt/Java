public class ForTest
{
    public static void main(String[] args)
    {
        /*
        打印
         *****
         ****
         ***
         **
         *
         */
        for (int x=1;x<=5;x++)
        {
            for (int y=x;y<=5;y++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        /*
        打印
        *
        **
        ***
        ****
        *****
         */
        System.out.println("----------------");
        for (int x=1;x<=5;x++)
        {
            for (int y=1;y<=x;y++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        /*
        打印
        54321
        5432
        543
        54
        5
         */
        System.out.println("----------------");
        for (int x=1;x<=5;x++)
        {
            for (int y=5;y>=x;y--)
            {
                System.out.print(y);
            }
            System.out.println();
        }
        /*
        打印
        * * * *
         * * *
          * *
           *
         */
        System.out.println("----------------");
        for (int x=1;x<=5;x++)
        {
            for (int y=1;y<x;y++)
            {
                System.out.print(" ");
            }
            for (int z=x;z<5;z++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
