package dependency_injection;

import org.ioc.Laptop;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {

    public static void main(String[] args) {

        BeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("library_book_dependency_injection.xml"));
        Library l1 =(Library) beanFactory.getBean("L1");
        System.out.println(l1);

        BeanFactory beanFactory1 =  new XmlBeanFactory(new ClassPathResource("library_book_dependency_injection.xml"));
        Book l2 =(Book) beanFactory1.getBean("B1");
        System.out.println(l2);

        BeanFactory beanFactory3 =  new XmlBeanFactory(new ClassPathResource("List_Dependency.xml"));
        Library1 l3 =(Library1) beanFactory3.getBean("Lib1");
        System.out.println(l3);




//        BeanFactory beanFactory1 = new XmlBeanFactory()
    }
}
