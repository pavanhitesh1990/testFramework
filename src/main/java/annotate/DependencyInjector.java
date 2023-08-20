package annotate;

import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.stream.Collectors;

public class DependencyInjector {

    public static void injectDependencies(String packageName) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Set<Class> setC = ClassPath.from(ClassLoader.getSystemClassLoader()).getAllClasses()
                .stream().filter(clazz -> clazz.getPackageName().equalsIgnoreCase(packageName)).map(cla->cla.load()).collect(Collectors.toSet());

        for(Class c:setC){
            for(Field field:c.getDeclaredFields()){
                if(field.isAnnotationPresent(Page.class)){
                    Class<?> dependencyClass = field.getType();
                    Object myObj2 =  dependencyClass.getDeclaredConstructor().newInstance();
                    DependencyInjector.injectDependencies(myObj2,field);
                }
            }
        }
    }
    private static void injectDependencies(Object target,Field field) {

        try {
            field.setAccessible(true);
            field.set(target, target);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}