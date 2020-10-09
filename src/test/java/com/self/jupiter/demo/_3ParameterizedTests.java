package com.self.jupiter.demo;

import com.self.jupiter.bean.Employee;
import com.self.jupiter.utility.DummyUtility;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _3ParameterizedTests {
    private final List<Month> months = Stream.of(Month.values())
            .collect(Collectors.toList());

    @ParameterizedTest
    @MethodSource("getEmployees")
    void testEmployees(Employee employee) {
        assertAll(
                () -> assertTrue(employee.getId() > 99L),
                () -> assertNotNull(employee),
                () -> assertNotNull(employee.getName())

        );
    }

    @ParameterizedTest
    @CsvSource({
            "Title 1, description 1",
            "Title 2, description 2",
            "Title 3, description 3"
    })
    void courseList(String title, String url) {
        assertAll(
                () -> assertNotNull(title),
                () -> assertTrue(url.startsWith("description"))
        );
    }

    @ParameterizedTest(name = "{0} is prime and less than 20")
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19})
    void valueIsPrime(int arg) {
        assertTrue(DummyUtility.isPrime(arg));
    }

    @ParameterizedTest(name = "{0} is not blank")
    @ValueSource(strings = {"this", "is", "a", "list", "of", "strings"})
    void noneAreBlank(String argument) {
        System.out.println("Testing " + argument + " is not blank");
        //assertTrue(!argument.isBlank());
        assertTrue(argument.length() > 0);
    }

    @ParameterizedTest
    @EnumSource(Month.class)
    void monthsEnum(Month month) {
        assertAll(
                () -> assertNotNull(month),
                () -> assertTrue(months.contains(month))
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/employee_data.csv", numLinesToSkip = 1, delimiter = ',')
    void testEmployeeSourceFromFile(Long id, String name) { //@AggregateWith(EmployeeAggregator.class) Employee employee
        assertAll(
                () -> assertNotNull(id),
                () -> assertNotNull(name)
        );
    }

}
