package easykotlin;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
class DepartmentTest {
    @Test
    public void testProperty() {
        Department d = new Department();
        d.setId(1);
        d.setName("技术部");
        d.setBig("big");
        d.setOpen(true);
        Assert.assertTrue(1 == d.getId());
        Assert.assertTrue("1".equals(d.getName()));
        Assert.assertTrue("Y".equals(d.isBig()));
        Assert.assertTrue(d.isOpen());
    }

//    @Test
//    public void testPackageFun() {
//        KotlinExampleKt.f1();
//        KotlinExampleKt.f2();
//        System.out.println(KotlinExampleKt.getP());
//        KotlinExampleKt.swap("abc", 0, 1);
//    }

    @Test
    public void overLoadTest(){
        OverridesFunWithDefaultParams o = new OverridesFunWithDefaultParams();
        o.f1(1,"a");
        o.f2(1,"a");
        o.f2(2);
    }
    @Test
    public void testException() throws Exception {
        CheckKotlinException c = new CheckKotlinException();
        c.funWithException();
    }
}