package com.self.jupiter.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("Duplicates")
public class _3ParameterizedTests {
    private final List<Month> months = Stream.of(Month.values())
            .collect(Collectors.toList());


    @ParameterizedTest(name = "max of {0} and {1} is {2}")
    @MethodSource("maxWithArgsList")
    void testMax(int x, int y, int max) {
        assertTrue(max >= x && max >= y);
    }

    private static List<Arguments> maxWithArgsList() {
        return Arrays.asList(Arguments.of(2, 1, 2),
                Arguments.of(7, 3, 7),
                Arguments.of(5, 5, 5));
    }

    private static Stream<Arguments> maxWithArgs() {
        return Stream.of(
                Arguments.of(2, 1, 2),
                Arguments.of(7, 3, 7),
                Arguments.of(5, 5, 5)
        );
    }

//    private static Stream<Book> getBooks() {
//        return Stream.of(
//                new Book("1935182943", "Making Java Groovy",
//                        "Ken Kousen", LocalDate.parse("2013-09-30")),
//                new Book("1491947020", "Gradle Recipes for Android",
//                        "Ken Kousen", LocalDate.parse("2016-06-17")),
//                new Book("149197317X", "Modern Java Recipes",
//                        "Ken Kousen", LocalDate.parse("2017-08-26")));
//    }
//
//    @ParameterizedTest(name = "{0} is prime and less than 20")
//    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19})
//    void valueIsPrime(int arg) {
//        assertTrue(UtilityMethods.isPrime(arg));
//    }
//
//    @ParameterizedTest(name = "{0} is composite and less than or equal to 20")
//    @ValueSource(ints = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20})
//    void valueIsComposite(int argument) {
//        assertFalse(UtilityMethods.isPrime(argument));
//    }
//
//    @ParameterizedTest(name = "{0} is prime")
//    @MethodSource("primesLessThan100")
//    void checkPrimesLessThan100(int arg) {
//        assertTrue(UtilityMethods.isPrime(arg));
//    }
//
//    // Factory method for the @MethodSource
//    //  no arguments
//    //  static method (factory method)
//    //  returns Stream, Array, Iterable, Iterator
//    private static IntStream primesLessThan100() {
//        return IntStream.rangeClosed(2, 100)
//                .filter(UtilityMethods::isPrime);
//    }
//
//
//    @ParameterizedTest(name = "{0} is not blank")
//    @ValueSource(strings = {"this", "is", "a", "list", "of", "strings"})
//    void noneAreBlank(String argument) {
//        System.out.println("Testing " + argument + " is not blank");
//        //assertTrue(!argument.isBlank());
//        assertTrue(argument.length() > 0);
//    }
//
//    @ParameterizedTest
//    @EnumSource(Month.class)
//    void monthsEnum(Month month) {
//        assertAll(
//                () -> assertNotNull(month),
//                () -> assertTrue(months.contains(month))
//        );
//    }
//
//    @ParameterizedTest  // from user manual
//    @EnumSource(mode = MATCH_ALL, names = "^.*DAYS$")
//    void testWithEnumSourceRegex(ChronoUnit unit) {
//        assertTrue(unit.name().endsWith("DAYS"));
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "Managing Your Manager, https://www.safaribooksonline.com/library/view/managing-your-manager/9781492031628/",
//            "Reactive Spring, https://www.safaribooksonline.com/library/view/reactive-spring/9781492025733/",
//            "Advanced Java Development, https://www.safaribooksonline.com/library/view/advanced-java-development/9781491960400/",
//            "Spring Framework Essentials, https://www.safaribooksonline.com/library/view/spring-framework-essentials/9781491942680/",
//            "Understanding Java 8 Generics, https://www.safaribooksonline.com/library/view/understanding-java-8/9781491978153/"
//    })
//    void courseList(String title, String url) {
//        assertAll(
//                () -> assertNotNull(title),
//                () -> assertTrue(UrlValidator.getInstance().isValid(url))
//        );
//    }
//
//    // Method source with Book instances
//    @ParameterizedTest
//    @MethodSource("getBooks")
//    public void testBooks(Book book) {
//        LocalDate now = LocalDate.now();
//        LocalDate twentyThirteen = LocalDate.of(2013, Month.JANUARY, 1);
//        assertAll(
//                () -> assertTrue(ISBNValidator.getInstance().isValidISBN10(book.getIsbn())),
//                () -> assertNotNull(book.getTitle()),
//                () -> assertNotNull(book.getAuthor()),
//                () -> assertTrue(book.getPublicationDate().isAfter(twentyThirteen) &&
//                        book.getPublicationDate().isBefore(now))
//        );
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/book_data.csv", numLinesToSkip = 1, delimiter = ',')
//    void testBookSource(String isbn, String title, String author, LocalDate date) {
//        LocalDate now = LocalDate.now();
//        LocalDate twentyThirteen = LocalDate.of(2013, Month.JANUARY, 1);
//        assertAll(
//                () -> assertTrue(ISBNValidator.getInstance().isValidISBN10(isbn)),
//                () -> assertNotNull(title),
//                () -> assertNotNull(author),
//                () -> assertTrue(date.isAfter(twentyThirteen) && date.isBefore(now))
//        );
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/book_data.csv", numLinesToSkip = 1)
//    void testBookSourceWithAggregator(@AggregateWith(BookAggregator.class) Book book) {
//        LocalDate now = LocalDate.now();
//        LocalDate twentyThirteen = LocalDate.of(2013, Month.JANUARY, 1);
//        assertAll(
//                () -> assertTrue(ISBNValidator.getInstance().isValidISBN10(book.getIsbn())),
//                () -> assertNotNull(book.getTitle()),
//                () -> assertNotNull(book.getAuthor()),
//                () -> assertTrue(book.getPublicationDate().isAfter(twentyThirteen) &&
//                        book.getPublicationDate().isBefore(now))
//        );
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/book_data.csv", numLinesToSkip = 1)
//    void testBookSourceWithAnnotation(@CsvToBook Book book) {
//        LocalDate now = LocalDate.now();
//        LocalDate twentyThirteen = LocalDate.of(2013, Month.JANUARY, 1);
//        assertAll(
//                () -> assertTrue(ISBNValidator.getInstance().isValidISBN10(book.getIsbn())),
//                () -> assertNotNull(book.getTitle()),
//                () -> assertNotNull(book.getAuthor()),
//                () -> assertTrue(book.getPublicationDate().isAfter(twentyThirteen) &&
//                        book.getPublicationDate().isBefore(now))
//        );
//    }

}