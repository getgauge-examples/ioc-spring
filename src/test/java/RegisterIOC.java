import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.ClassInitializer;
import com.thoughtworks.gauge.ClassInstanceManager;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RegisterIOC {

    @BeforeSuite
    public void registerIOC() {
        ClassInstanceManager.setClassInitializer(new ClassInitializer() {
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
        });
    }
}
