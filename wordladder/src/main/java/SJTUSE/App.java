package SJTUSE;
import java.util.*;
import java.io.*;

public class App {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the path of a dictionary:");
        String dictPath = scanner.nextLine();
        HashSet<String> dict = getDict(readToString(dictPath));
        System.out.println("Input the first word:");
        String w1 = scanner.next();
        System.out.println("Input the second word:");
        String w2 = scanner.next();
        scanner.close();
        if(w1.length() != w2.length()){
            System.out.println("Two word is not in the same size, exit.");
            return;
        }

        findWay(w1, w2, dict);

    }

    public static String readToString(String fileName) {  
        String encoding = "UTF-8";  
        File file = new File(fileName);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            in.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        try {  
            return new String(filecontent, encoding);  
        } catch (UnsupportedEncodingException e) {  
            System.err.println("The OS does not support " + encoding);  
            e.printStackTrace();  
            return null;  
        }  
    }

    static HashSet<String> getDict(String dictStr){

        HashSet<String> dict = new HashSet<String>();
        String[] splitStr = dictStr.split("\n");
        for(int i=0; i<splitStr.length; i++){
            dict.add(splitStr[i]);
        }

        return dict;

    }

    static void findWay(String w1, String w2, HashSet<String> dict){

    }
}
