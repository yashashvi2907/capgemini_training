package org.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // bean creation using BeanFactor - here BeanFactory is interface

        BeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean_configuration.xml"));
                Laptop l2 =(Laptop ) beanFactory.getBean("bean_id");
        System.out.println(l2);

        BeanFactory beanFactory2 =  new XmlBeanFactory(new ClassPathResource("bean_configuration.xml"));
        // we can use this when we have only one bean instance in our configuration
        Laptop l3 =(Laptop ) beanFactory2.getBean(Laptop.class);
        System.out.println(l3);

//        Laptop laptop2 = (Laptop) beanFactory.getBean("bean_id4");
//        System.out.println(laptop2);

        // bean creation using ApplicationContext

        ApplicationContext context = new ClassPathXmlApplicationContext("bean_configuration.xml");
        Laptop laptop3 = (Laptop) context.getBean("bean_id");
        System.out.println(laptop3);






    }
}
