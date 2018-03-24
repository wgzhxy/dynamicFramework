package com.yisutech.framework.dynamic.engine;

/**
 * 引擎通用接口
 *
 * @author guangzhong.wgz
 */
public interface Engine {

    /**
     * 类动态调用
     */
    Object run(String groovyScriptName) throws Exception;

    /**
     * 获取实例服务
     */
    Object getInstanceObject(String groovyScriptName) throws Exception;

    /**
     * 创建脚本
     */
    Object instance(String groovyScript, String groovyScriptName) throws Exception;
}
