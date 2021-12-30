import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
        char[] arr = s.toCharArray();        
        for(int i=0; i< arr.length; i++){
            boolean check = Character.isAlphabetic(arr[i]);
            boolean isUpper = Character.isUpperCase(arr[i]);
            if(check){
                k = k % 26;
                if(Character.isAlphabetic((char)((int)arr[i]) + k)){
                    if(isUpper && !Character.isUpperCase((char) (((int) arr[i]) + k))){
                        arr[i] = (char) (((int) arr[i]) + k - 26);                    
                    }else{
                        arr[i] = (char) (((int) arr[i]) + k);
                    }
                    
                }else{
                    arr[i] = (char) (((int) arr[i]) + k - 26);    
                    }
            }
        }

        
        String result = String.valueOf(arr);
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
