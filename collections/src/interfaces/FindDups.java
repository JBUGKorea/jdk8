package interfaces;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 14. 5. 5.
 * Time: 오후 2:05
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
import java.util.stream.*;

public class FindDups {
    public static void main(String[] args) {
        Set<String> distinctWords = Arrays.asList(args).stream()
                .collect(Collectors.toSet());
        System.out.println(distinctWords.size()+
                " distinct words: " +
                distinctWords);
    }
}