/**
 * @Author: wangzilinn@gmail.com
 * @Description:
 * @Date: Created in 12:06 AM 08/17/2020
 * @Modified By:wangzilinn@gmail.com
 */
public class Person {
    private String id;
    private int age;


    public Person(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
