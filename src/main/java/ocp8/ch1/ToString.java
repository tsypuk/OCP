package ocp8.ch1;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by rtsy on 23.01.2016.
 */
class Supra {
    String canYouSeeThis = "?";
}
public class ToString extends Supra{
    private String name;
    private String address;
    private int age;

    public ToString(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public boolean equals(Object o) {
        if (!( o instanceof ToString)){
            return false;
        }
        ToString other = (ToString) o;
        return new EqualsBuilder().append(name, other.name)
                .append(address, other.address)
                .isEquals();
    }

    public static void main(String[] args)
            throws IllegalAccessException {
        ToString instance = new ToString("Name", "Address");
        instance.age = 99;
        System.out.println(instance.toString());

        Class clazz = instance.getClass();
        System.out.println(clazz);
        getClassFields(instance, clazz);
        // instance already has all super class methods
        getClassMethods(instance, clazz);
        while (clazz.getSuperclass() != null) {
            clazz = clazz.getSuperclass();
            getClassFields(instance, clazz);
        }
    }

    private static void getClassFields(ToString instance, Class clazz)
            throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        System.out.println("package" + clazz.getPackage());
        System.out.println(clazz.getSimpleName());
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String fieldName = field.getName();
            Object fieldValue = field.get(instance);
            System.out.println(fieldName + " : " + fieldValue);
        }
    }

    private static void getClassMethods(ToString instance, Class clazz)
            throws IllegalAccessException {
        Method[] methods = clazz.getMethods();
        AccessibleObject.setAccessible(methods, true);
        System.out.println("package" + clazz.getPackage());
        System.out.println(clazz.getSimpleName());
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            String methodName = method.getName();
            Class returnType = method.getReturnType();
            System.out.println(methodName + " : " + returnType);
        }
    }
}