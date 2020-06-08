import org.junit.Test;


/**
 * @Author: wangzilinn@gmail.com
 * @Description:
 * @Date: Created in 4:28 PM 6/8/2020
 * @Modified By:wangzilinn@gmail.com
 */
public class mainTest {
    @Test
    //java14 更详细的错误信息:
    //默认null pointer输出:
//    java.lang.NullPointerException
//    at mainTest.shouldFail(mainTest.java:13)
//添加 -XX:+ShowCodeDetailsInExceptionMessages后输出:
    //java.lang.NullPointerException: Cannot invoke "String.toString()" because the return value of "mainTest.getEmailAddress()" is null
    public void shouldFail() {
        System.out.println(getEmailAddress().toString());
    }

    private String getEmailAddress() {
        return null;
    }

}