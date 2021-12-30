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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String[] splitted = s.split(":");
        String newTime = "";
        if(splitted[splitted.length - 1].contains("PM")){
            int hour = Integer.parseInt(splitted[0]);
            hour += 12;
            if(hour == 24){
                splitted[0] = "12";
            }else{
                splitted[0] = "" + hour;
            }
            splitted[splitted.length - 1] = splitted[splitted.length - 1].split("PM")[0]; 
        }else{
                        splitted[splitted.length - 1] = splitted[splitted.length - 1].split("AM")[0];
            if(splitted[0].equals("12")){
                splitted[0] = "00";
            }                
        }
        newTime+= splitted[0] + ":" +splitted[1] + ":" + splitted[2];
        return newTime;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
