package com.yisutech.framework.dynamic.engine.instance;

import com.google.common.collect.Maps;
import com.yisutech.framework.dynamic.engine.Engine;
import groovy.lang.GroovyClassLoader;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Groovy 引擎实现
 *
 * @author guangzhong.wgz
 */
public class GroovyScriptEngine implements Engine {

    /**
     * groovy实例对象池
     */
    private static Map<String, Object> objectPool = Maps.newConcurrentMap();

    private final String templateName = "Wanggz";
    private final String templateMethod = "run";

    @Override
    public Object instance(String groovyScript, String groovyScriptName) throws Exception {

        if (StringUtils.isBlank(groovyScript)) {
            throw new RuntimeException("groovyScript is empty");
        }

        if (StringUtils.isBlank(groovyScriptName)) {
            throw new RuntimeException("groovyScriptName is empty");
        }

        StringBuilder groovyFile = new StringBuilder();
        groovyFile.append("class ").append(templateName).append(" { ")
                .append("def")
                .append(templateMethod)
                .append("(def context){")
                .append(groovyScript)
                .append("}")
                .append("}");

        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        Class<?> groovyClass = groovyClassLoader.parseClass(groovyScript);

        Object obj = groovyClass.newInstance();
        if (null == obj) {
            throw new RuntimeException("groovyClass.newInstance error");
        }

        objectPool.put(groovyScriptName, obj);
        return objectPool.get(groovyScriptName);
    }

    @Override
    public Object run(String groovyScriptName) throws Exception {

        if (StringUtils.isBlank(groovyScriptName)) {
            throw new RuntimeException("groovyScriptName is empty");
        }

        Object obj = objectPool.get(groovyScriptName);
        if (obj == null) {
            throw new RuntimeException("instance of groovyScriptName is empty");
        }

        Method method = obj.getClass().getMethod(templateMethod, null);
        return method.invoke(obj);
    }

    @Override
    public Object getInstanceObject(String groovyScriptName) throws Exception {
        if (StringUtils.isBlank(groovyScriptName)) {
            throw new RuntimeException("groovyScriptName is empty");
        }
        return objectPool.get(groovyScriptName);
    }

}
