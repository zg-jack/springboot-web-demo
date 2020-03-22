package com.xiangxue.jack.test;

import com.xiangxue.jack.aware.ComponentScanBean;
import com.xiangxue.jack.service.AreaService;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test4  extends JunitTestService{

    private int num;
    private String applyNo;

    private static Test4 test4;

    @PostConstruct
    public void init(){
        test4 = this;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
        AreaService bean = applicationContext.getBean(AreaService.class);
        List<Object[]> params = new ArrayList<>();
        Object[] data = new Object[2];
        data[0] = 0;
        data[1] = "";
        params.add(data);
        return params;
    }

    @Test
    public  void test(){

    }
}
