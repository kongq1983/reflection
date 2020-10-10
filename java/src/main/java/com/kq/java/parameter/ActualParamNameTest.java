package com.kq.java.parameter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Date;


/**
 * @author kq
 * @date 2020-09-23 9:40
 * @since 2020-0630
 */
public class ActualParamNameTest {

    public static void main(String[] args) throws Exception{

        Method method = AccountMapper.class.getMethod("accountAdd",Long.class,String.class,Date.class);

        List<String> list =  ParamNameUtil.getParamNames(method);
        System.out.println(list);

        ParameterNameDiscoverer discoverer = new ParameterNameDiscoverer();
        String[] array = discoverer.getParameterNames(method);
        System.out.println(Arrays.toString(array));

    }


}
