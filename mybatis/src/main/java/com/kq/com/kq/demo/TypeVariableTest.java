package com.kq.com.kq.demo;

import java.lang.reflect.*;
import java.util.List;
import java.util.Map;

public class TypeVariableTest {

    public void  print(List<? extends Number> list) {
        System.out.println("list="+list);
    }

    public void  printOne(List<Number> list) {
        System.out.println("list="+list);
    }

    public void  printMap(Map<String,Number> list) {
        System.out.println("list="+list);
    }

    public static void main(String[] args) {

        Method[] ms = TypeVariableTest.class.getDeclaredMethods();

        for(Method m : ms) {
            if(!m.getName().startsWith("print"))continue;
            //获取字段定义所在类的class对象
            System.out.println("method name="+m.getName()+" declaringClsss="+m.getDeclaringClass());

            Type[] types = m.getGenericParameterTypes();

            for (Type t : types) {
                System.out.println(t.getTypeName());
                System.out.println(t.getClass());
                if (t instanceof ParameterizedType) {
//                        System.out.println("equal");
                    ParameterizedType type = (ParameterizedType) t;
                    System.out.println("rawType=" + type.getRawType());
                    System.out.println("ownerType=" + type.getOwnerType());
                    System.out.println();
                    Type[] t1s = type.getActualTypeArguments();
                    for (Type t1 : t1s) {
                        if(t1 instanceof  TypeVariable){
                            System.out.println("t1 instanceof TypeVariable");
                        }else if(t1 instanceof  ParameterizedType){
                            System.out.println("t1 instanceof ParameterizedType");
                        }else if(t1 instanceof WildcardType){
                            System.out.println("t1 instanceof WildcardType");
                        }else {
                            System.out.println("not found match type type="+t1);
                        }
                        System.out.println("t1=" + t1);
                    }
                }
            }

            System.out.println(m.getGenericParameterTypes());

            Class[] cs =  m.getParameterTypes();
            for(Class c : cs){
                System.out.println(c);
            }
            TypeVariable<Method>[]  ts  = m.getTypeParameters();


            System.out.println("ts="+ts+"  length="+ts.length);

            for(TypeVariable t : ts) {
                System.out.println("tv="+t);
            }

            System.out.println("------------------------------------------");
        }

    }

}
