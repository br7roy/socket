/**
 * 壹钱包 Copyright (c) 2013-2017 壹钱包版权所有.
 */
package com.rust.proxy;

import java.lang.reflect.Proxy;

/**
 * @author FUTANGHANG004
 * @version $Id: InvokeEntrance, v 0.1 2017/12/20 FUTANGHANG004 Exp $
 */
public class InvokeEntrance {
    public static void main(String[] args) {

        IDoWork iDoWork = new DoWorkImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(iDoWork);

        IDoWork o = (IDoWork) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), iDoWork.getClass().getInterfaces(), dynamicProxy);
        o.doWork();

    }

}
