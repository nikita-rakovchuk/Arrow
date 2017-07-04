import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            Scanner scanner = new Scanner(new File("INPUT.txt"));
            int count = 0;
            while(scanner.hasNext()) {
                String data = scanner.next();
                String data2 = data;
                Pattern abc = Pattern.compile(">>-->");
                Matcher matcher = abc.matcher(data);

                Pattern abc2 = Pattern.compile("<--<<");
                Matcher matcher2 = abc2.matcher(data2);

                while (matcher.find()) {
                    data = data.substring(matcher.end() - 1, data.length());
                    matcher = abc.matcher(data);
                    count++;
                }
                while (matcher2.find()) {
                    data2 = data2.substring(matcher2.end() - 1, data2.length());
                    matcher2 = abc2.matcher(data2);
                    count++;
                }
            }
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("OUTPUT.txt"), "UTF-8"));
                out.write(Integer.toString(count));
                out.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
