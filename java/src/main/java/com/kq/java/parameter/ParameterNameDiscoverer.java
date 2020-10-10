package com.kq.java.parameter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 为了使用该特性，你的项目必须采用 Java 8 编译，并且加上 <code>-parameters</code>
 * @author kq
 * @date 2020-09-01 16:59
 * @since 2020-0630
 */
public class ParameterNameDiscoverer {

    public String[] getParameterNames(Method method) {
        return getParameterNames(method.getParameters());
    }

    public String[] getParameterNames(Constructor<?> ctor) {
        return getParameterNames(ctor.getParameters());
    }

    private String[] getParameterNames(Parameter[] parameters) {
        String[] parameterNames = new String[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Parameter param = parameters[i];
            if (!param.isNamePresent()) {
                return null;
            }
            parameterNames[i] = param.getName();
        }
        return parameterNames;
    }

}
