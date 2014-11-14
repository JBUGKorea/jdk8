package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: nadal
 * Date: 2014. 7. 15.
 * Time: 오후 7:18
 */
public class RegexExample {

    public static void main(String[] args) {

        // basic
        Pattern pattern = Pattern.compile(".xx.");
        Matcher matcher = pattern.matcher("MxxY");
        System.out.println("Input String matches regex - "+matcher.matches());

        // short cut
        String str = "bbb";
        System.out.println("Using String matches method: "+str.matches(".bb"));
        System.out.println("Using Pattern matches method: "+Pattern.matches(".bb", str));


        // using pattern with flags
        pattern = Pattern.compile("ab", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher("ABcabdAb");

        // using Matcher find(), group(), start() and end() methods
        while (matcher.find()) {
            System.out.println("Found the text \"" + matcher.group()
                    + "\" starting at " + matcher.start()
                    + " index and ending at index " + matcher.end());
        }

        // using Pattern split() method
        pattern = Pattern.compile("\\W");
        String[] words = pattern.split("one@two#three:four$five");
        for (String s : words) {
            System.out.println("Split using Pattern.split(): " + s);
        }

        // using Matcher.replaceFirst() and replaceAll() methods
        pattern = Pattern.compile("1*2");
        matcher = pattern.matcher("11234512678");
        System.out.println("Using replaceAll: " + matcher.replaceAll("_"));
        System.out.println("Using replaceFirst: " + matcher.replaceFirst("_"));

        // SSN test
        List<String> input = new ArrayList<String>();
        input.add("123-45-6789");
        input.add("9876-5-4321");
        input.add("987-65-4321 (attack)");
        input.add("987-65-4321 ");
        input.add("192-83-7465");

        for (String ssn : input) {
            if (ssn.matches("^(\\d{3}-?\\d{2}-?\\d{4})$")) {
                System.out.println("Found good SSN: " + ssn);
            }
        }

    }

}
