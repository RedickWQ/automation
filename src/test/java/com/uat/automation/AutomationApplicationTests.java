package com.uat.automation;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest(classes = {AutomationApplication.class})
public class AutomationApplicationTests extends AbstractTestNGSpringContextTests {

    @Test
    public void test22(){
        System.out.println("hello world");
    }

}
