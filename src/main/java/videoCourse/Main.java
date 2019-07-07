package videoCourse;

import com.google.gson.Gson;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Main {
    /**
     *
      * @param args
     */

    public static void main(String[] args) {
        IntFunction<String> intToString = Integer::toString;

        System.out.println
            ("Expected value 4, actual value: " + intToString.apply(1457).length());

        Consumer<String> print = System.out::println;
        print.accept("Coming to you directly from lambda...");

        UnaryOperator<String> makeGreeting = "Hello, "::concat;
        System.out.println(makeGreeting.apply("Peggy"));

        Calculate add = (a, b) -> a + b;
        Calculate difference = (a, b) -> Math.abs(a - b);
        Calculate divide = (a, b) -> (b != 0 ? a / b : 0);

        System.out.println(add.calc(3, 2));
        System.out.println(difference.calc(5, 11));
        System.out.println(divide.calc(13, 3));

        List<String> names = asList("Paul", "Jane", "Michaela", "Sam");
        Collections.sort(names, (a, b) -> b.compareTo(a));

        Book book1 = new Book
            ("Miss Peregrine's Home", "Ranson", "Riggs", 382);

        Book book2 = new Book
            ("Harry Potter", "JK", "Rowling", 411);
        Book book3 = new Book
            ("The Cat in the Hat", "Dr", "Seuss", 45);

        List<Book> books = asList(book1, book2, book3);

        int totalPages = books.stream().collect(Collectors.summingInt(Book::getPages));
        System.out.println(totalPages);

        List<String> listLNames = books.stream()
            .map(Book::getAuthorLName)
            .collect(Collectors.toList());
        System.out.println(listLNames);

        List<Book> dupBooks = asList(book1, book2, book3, book1, book2, book3);
        System.out.println("Before removing duplicate: ");
        System.out.println(dupBooks.toString());

        Collection noDup = new HashSet(dupBooks);
        System.out.println("After removing duplicate: ");
        System.out.println(noDup.toString());

        Set<Integer> numbers = new HashSet<>((asList(4, 3, 3, 4, 1, 1, 1, 2)));
        System.out.println(numbers.toString());

        Predicate<String> moreThenFiveLetters = s -> s.length() > 5;
        System.out.println("Word Apples has more then 5 letters " + moreThenFiveLetters.test("Apples"));

        List<String> colors = asList("Red", "Blue", "Green");
        for (int i = 0; i < colors.size(); i++){
            System.out.println("The cokor is " + colors.get(i));
        }

        Gson gson = new Gson();
        System.out.println(gson.toJson(colors));

    }
}
