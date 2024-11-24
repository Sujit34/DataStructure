package StreamAPI;

import StreamAPI.models.Student;

import java.util.stream.*;
import java.util.*;


public class MapvsFlatMap {
    public static List<Student> getAll() {
        return Stream.of(
                new Student(101, "john", "john@gmail.com", 3.5, Arrays.asList("011727277", "010129912")),
                new Student(102, "smith", "smith@gmail.com", 3.5, Arrays.asList("09328328", "1211212122")),
                new Student(103, "peter", "peter@gmail.com", 3.6, Arrays.asList("09129129", "212121212")),
                new Student(104, "kely", "kely@gmail.com", 3.7, Arrays.asList("0818128128", "9191020120"))
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        //get all email // Map as it is one to one.
        List<String> email = MapvsFlatMap.getAll().stream().map(s -> s.getEmail()).collect(Collectors.toList());
        System.out.print(email);

        //get all phone number //FlatMap as it is one to many.
        List<String> phoneNumber = MapvsFlatMap.getAll().stream()
                .flatMap(s -> s.getPhoneNumber().stream()).collect(Collectors.toList());
        System.out.print(phoneNumber);
    }
}

