package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Validator{
    public static List<String> validate(Object instance) {
        List<String> result = new ArrayList<>();
        for (Field field: instance.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                field.setAccessible(true);
                try {
                    if (field.get(instance) == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Object instance) {
        Map<String, List<String>> result = new HashMap<>();
        for (Field field: instance.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            MinLength minLength = field.getAnnotation(MinLength.class);
            if (notNull != null || minLength != null) {
                field.setAccessible(true);
                List<String> errorMses = new ArrayList<>();
                try {
                    if (field.get(instance) == null) {
                        errorMses.add("can not be null");
                    } else if (minLength != null && field.get(instance).toString().length() < minLength.minLength()) {
                        errorMses.add("length less than " + minLength.minLength());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (errorMses.size() > 0) {
                    result.put(field.getName(), errorMses);
                }
            }
        }
        return result;
    }
}
