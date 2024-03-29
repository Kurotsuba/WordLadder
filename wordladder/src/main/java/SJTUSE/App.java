package SJTUSE;
import java.util.*;
import java.io.*;

public class App {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the path of a dictionary:");
        String dictPath = scanner.nextLine();

        HashSet<String> dict = new HashSet<String>();

        try{
            dict = DicGenerate(dictPath);
        }catch (Exception e){
            e.printStackTrace();
        }

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

    public static HashSet<String> DicGenerate(String filename)throws IOException{
        HashSet<String> result = new HashSet<String>();
        
        DataInputStream in = new DataInputStream(new FileInputStream(filename));
        BufferedReader br  = new BufferedReader(new InputStreamReader(in));
        String temp;

        while((temp = br.readLine())!=null)
            result.add(temp);
        br.close();
        return result;
    }


    public static void findWay(String w1, String w2, HashSet<String> dict){
        if(w1.equals(w2)){
            System.out.println(w1);
            return;
        }

        if(!(dict.contains(w1) && dict.contains(w2))){
            return;
        }



        Stack<String> stack0 = new Stack<String>();
        stack0.push(w1);

        Queue<Stack<String>> queue = new LinkedList<Stack<String>>();
        queue.add(stack0);

        Stack<String> temp;

        while(!queue.isEmpty()){
            temp = queue.poll();
            String curWord = temp.peek();

            for(int i=0; i<curWord.length(); i++){

                String front, end;
                if(i==0){
                    front = "";
                    end = curWord.substring(i+1);
                }else if(i==curWord.length()-1){
                    front = curWord.substring(0, i);
                    end = "";
                }else{
                    front = curWord.substring(0, i);
                    end = curWord.substring(i+1);
                }

                for(int j = (int)'a'; j < (int)'z'+1; j++){
                    String newWord = front + (char)j + end;
                    
                    if(dict.contains(newWord)){
                        temp.push(newWord);
                        if(newWord.equals(w2)){
                            for(String s : temp){
                                System.out.println(s);
                            }
                            return;
                        }else{
                            Stack<String> newStack = (Stack<String>)temp.clone();
                            queue.add(newStack);
                        }
                    }
                }


            }
        }
    }
}
