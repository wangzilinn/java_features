import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wangzilinn@gmail.com
 * @Description:
 * @Date: Created in 9:36 PM 6/7/2020
 * @Modified By:wangzilinn@gmail.com
 */
public class main {
    private void collection() {
        final List<String> strings = new ArrayList<>();
        final Map<Integer, String> map = new HashMap<>();
        final HashSet<Integer> set = new HashSet<>();
    }

    private void collectionFactories() {
        final List<String> unmodifiableListOfString = List.of("Some", "thing", "here");
        final Map<Integer, String> unmodifiableMap = Map.of(23, "the value", 49, "another value");
        final Set<Integer> unmodifiableSet = Set.of(4, 12345, 3);
    }

    //java 8
    private void streamsAPI() {
        final List<String> unmodifiableListOfString = List.of("Some", "thing", "here");

        final List<String> listOfStrings = unmodifiableListOfString.stream()
                .filter(s -> s.startsWith("S"))
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    //java 8
    private void lambdaExpression() {
        final Map<Integer, String> unmodifiableMap = Map.of(23, "the value", 49, "another value");

        final String collect = unmodifiableMap.values().stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));

        //如果不存在key ,则创建一个key, 并基于key创建一个value
        unmodifiableMap.computeIfAbsent(12, Object::toString);
        unmodifiableMap.computeIfAbsent(13, integer -> "this is 13's value");

        //如果存在key, 则更新key对应的value, lambda返回新的value
        unmodifiableMap.computeIfPresent(23, (integer, s) -> s + integer.toString());
    }

    //java8
    private void optional() {
        final List<String> unmodifiableListOfString = List.of("Some", "thing", "here");

        Optional<String> aValue = unmodifiableListOfString.stream()
                .filter(s -> s.equals("Some"))
                .findFirst();
        //注释内容与下面等效
//        if (aValue.isPresent()) {
//            System.out.println(aValue.get());
//        }
        aValue.ifPresent(System.out::println);

        aValue.ifPresentOrElse(System.out::println, ()-> System.out.println("Doesn't exist"));
    }

    private void time() {
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();

        LocalDate today = LocalDate.of(2020, 6, 7);
    }

    private void checkedExceptionSometimes() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            simpleDateFormat.parse("Definitely not a date");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("This is not a date");
        }
    }

    @Contract(pure=true)
    private @NotNull String annotations(@NotNull Object param) {
        String value = param.toString();
        return "This can never return null";
    }


    private void varWhereAppropriate() {
        var s = "My String";
        var integers = List.of(1, 2, 3, 4);
    }
}
