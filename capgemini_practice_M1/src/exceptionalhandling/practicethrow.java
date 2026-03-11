package exceptionalhandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class practicethrow {

    public static void main(String[] args) throws IOException
    {
        //without using try-catch - can handle exception
        //by using throws - that catch exception, it is like
        // warning method that there can occur exception - be caution
        // this line doesnt show compile error, even without using try-ctahc, because of throwskeyword
        // throws just compiles , and throws exception at runtime, not avoid error
        m1();
        FileReader fr = new FileReader("e.txt");
        System.out.println(10);

    }

    public static void m1() throws FileNotFoundException {
        try {
            FileReader fs = new FileReader("t.txt");
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
            // used to throw excedption forcefully--> we just need to add method signature
            throw new FileNotFoundException("exception");
        }
    }
}
//customexception --


