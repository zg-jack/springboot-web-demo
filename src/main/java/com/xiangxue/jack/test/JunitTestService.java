package com.xiangxue.jack.test;

import com.xiangxue.jack.start.SpringbootTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = SpringbootTest.class)
@WebAppConfiguration
@RunWith(Parameterized.class)
public class JunitTestService {
    private TestContextManager testContextManager;

    public void setup(){
        testContextManager = new TestContextManager(getClass());
        try {
            testContextManager.prepareTestInstance(this);
        }catch (Exception e){

        }
    }
}
