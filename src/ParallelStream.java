import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: wangzilinn@gmail.com
 * @Description:
 * @Date: Created in 11:45 PM 08/16/2020
 * @Modified By:wangzilinn@gmail.com
 */
public class ParallelStream {
    private final static long PERSON_NUMBER=5000000;//分别测试500,50000,5000000

    public static void main(String[] args) {
        List<Person> persons = init();
        testCommonsCollection(persons);
        testStream(persons);
        testParallelStream(persons);
    }
    //测试普通集合操作效率
    public static void testCommonsCollection(List<Person> persons) {
        long start = System.currentTimeMillis();
        long ageSum=0;
        for (Person person : persons) {
            ageSum+=person.getAge();
        }
        long end = System.currentTimeMillis();
        System.out.println("总的年龄为"+ageSum);
        System.out.println(PERSON_NUMBER+"个对象集合使用普通集合操作一共花费时间："+(end-start));
    }
    //测试stream效率
    public static void testStream(List<Person> persons) {
        long start = System.currentTimeMillis();
        Optional<Integer> sumAge = persons.stream().map(Person::getAge).reduce((age1, age2)->age1+age2);
        sumAge.ifPresent(integer -> System.out.println("总的年龄为" + integer));
        long end = System.currentTimeMillis();
        System.out.println(PERSON_NUMBER+"个对象集合使用stream一共花费时间："+(end-start));
    }
    //测试parallel stream效率
    public static void testParallelStream(List<Person> persons) {
        long start = System.currentTimeMillis();
        Optional<Integer> sumAge = persons.parallelStream().map(Person::getAge).reduce((age1, age2)->age1+age2);
        sumAge.ifPresent(integer -> System.out.println("总的年龄为" + integer));
        long end = System.currentTimeMillis();
        System.out.println(PERSON_NUMBER+"个对象集合使用ParallelStream一共花费时间："+(end-start));
    }
    public static List<Person> init(){
        List<Person> persons=new LinkedList<Person>();
        for(int i=1;i<=PERSON_NUMBER;i++) {
            Person person = new Person("123", i);
            person.setId(String.valueOf(i));
            person.setAge(i);
            persons.add(person);
        }
        return persons;
    }
    //@Test
    //public void testStream() {
    //    // 起始时间
    //
    //
    //    List<Integer> list = new ArrayList<>();
    //    // 将10000-1存入list中
    //    for (int i = 100000; i >= 1; i--) {
    //        list.add(i);
    //    }
    //    LocalTime start = LocalTime.now();
    //    list.stream().collect(Collectors.toMap(key -> key * 100.001, key -> (key - 1) * 1000.01));
    //    // count()是终止操作，有终止操作才会执行中间操作sorted()
    //
    //    // 终止时间
    //    LocalTime end = LocalTime.now();
    //
    //    // 时间间隔
    //    Duration duration = Duration.between(start, end);
    //    // 输出时间间隔毫秒值
    //    System.out.println(duration.toMillis());
    //    //System.out.println(collect);
    //}
    //
    //@Test
    //public void testParallelStream() {
    //    // 起始时间
    //
    //
    //    List<Integer> list = new ArrayList<>();
    //    // 将10000-1存入list中
    //    for (int i = 100000; i >= 1; i--) {
    //        list.add(i);
    //    }
    //    LocalTime start = LocalTime.now();
    //    list.parallelStream().collect(Collectors.toMap(key -> key * 100.001, key -> (key - 1) * 1000.01));
    //    // count()是终止操作，有终止操作才会执行中间操作sorted()
    //
    //    // 终止时间
    //    LocalTime end = LocalTime.now();
    //
    //    // 时间间隔
    //    Duration duration = Duration.between(start, end);
    //    // 输出时间间隔毫秒值
    //    System.out.println(duration.toMillis());
    //    //System.out.println(collect);
    //}
}
