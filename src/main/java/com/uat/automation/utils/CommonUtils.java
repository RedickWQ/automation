package com.uat.automation.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @Author Paul.Wang
 * @Date 2018/7/20
 */
public class CommonUtils {
    /**
     * 返回工程目录根目录
     *
     * @author wq
     * @return
     * @since 2017/6/27
     */
    public static String getRealpath() {
        String path = null;
        try {
            // path=TestBase.class.getClassLoader().getResource("").toURI()
            // .getPath();
            path = Thread.currentThread().getContextClassLoader()
                    .getResource("").toURI().getPath();
            if (path.indexOf("/target/test-classes") != -1) {
                path = path.replace("/target/test-classes", "/src/test");
            }
            if (path.indexOf("/target/classes") != -1) {
                path = path.replace("/target/classes", "/src/main");
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return path;
    }

    public static String getResourcesPath() {
        String path = null;
        try {
            path = Thread.currentThread().getContextClassLoader()
                    .getResource("").toURI().getPath();
            if (path.indexOf("/target/test-classes") != -1) {
                path = path.replace("/target/test-classes",
                        "/src/main/resources");
            }
            if (path.indexOf("/target/classes") != -1) {
                path = path.replace("/target/classes", "/src/main/resources");
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //去掉第一个“/”
        return path.substring(1);
    }


    /**
     *
     *
     * Map转换层Bean，使用泛型免去了类型转换的麻烦。
     * @param <T>
     * @param map
     * @param class1
     * @return
     */
    public static <T> T map2Bean(Map<String, String> map, Class<T> class1) {
        T bean = null;
        try {
            bean = class1.newInstance();
            BeanUtils.populate(bean, map);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
