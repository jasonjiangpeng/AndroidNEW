package com.jh.rental.user;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        String asdasdadasd = dispaly("asdasdadasd");
        System.out.println(asdasdadasd);
        Integer dispaly = dispaly(123);
        System.out.println(dispaly);
    }
    public static <T> T dispaly(T tClass){
     return  tClass;

    }


}