package com.zhanghuanfa;

import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Hotel> hotelClass = Hotel.class;
        Field[] fields = hotelClass.getDeclaredFields();
        System.out.println(fields.length);
        Hotel hotel = hotelClass.newInstance();
        List<String> names = new ArrayList<>();
        names.add("HotelId");
        names.add("Id");
        names.add("Number");
        Map<String, Field> map = Arrays.stream(fields).collect(Collectors.toMap(Field::getName, Function.identity()));
        String[] args = {"1", "2"};
        for (int i = 0; i < args.length; i++) {
            String name = names.get(i);
            Field field = map.get(name.substring(0, 1).toLowerCase() + name.substring(1));
            Method method = hotelClass.getMethod("set" + name, field.getType());
            method.invoke(hotel, args[i]);
        }
        System.out.println(hotel);
    }

    @Test
    public void test() {
        String st = "ST-400-mG79Vpri7PtjJcMM5MihDWOfIyQslWdOOkT";
        String prefix = "yunying:passport:cache";
        System.out.println((prefix + st).getBytes());
    }
}

@Data
class Hotel{
    private String id;
    private String hotelId;
    private String number;
}
