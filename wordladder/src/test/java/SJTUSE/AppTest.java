package SJTUSE;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        final App app = new App();

        String testDictPath = "EnglishWords.txt";
        HashSet<String> pathDict = new HashSet<String>();
        try{
            pathDict = app.DicGenerate(testDictPath);
        }catch(Exception e){
            e.printStackTrace();
        }
            
        app.findWay("cat", "dog", pathDict);
        
    }
}
