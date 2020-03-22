package com.xiangxue.jack.start;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;


//@Component
public class TomcatServletWebServerFactoryWW implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//        Connector connector = new Connector("org.apache.coyote.ajp.AjpAprProtocol");
//        BeanDefinition tomcatServletWebServerFactory = registry.getBeanDefinition("tomcatServletWebServerFactory");
//        MutablePropertyValues propertyValues = tomcatServletWebServerFactory.getPropertyValues();
//        List list = new ArrayList<>();
//        list.add(connector);
//        propertyValues.addPropertyValue("additionalTomcatConnectors",list);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Connector connector = new Connector("org.apache.coyote.ajp.AjpAprProtocol");
        TomcatServletWebServerFactory bean = beanFactory.getBean(TomcatServletWebServerFactory.class);
        bean.addAdditionalTomcatConnectors(connector);
    }
}
