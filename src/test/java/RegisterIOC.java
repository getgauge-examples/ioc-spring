import com.thoughtworks.gauge.ClassInitializer;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RegisterIOC implements ClassInitializer {

    @Override
    public Object initialize(Class<?> aClass) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-module.xml");
        String[] beanNames = context.getBeanNamesForType(aClass);
        if (beanNames.length == 0) {
            throw new NoSuchBeanDefinitionException(aClass.getName());
        }
        String s = beanNames[0];
        return aClass.cast(context.getBean(s));
    }
}