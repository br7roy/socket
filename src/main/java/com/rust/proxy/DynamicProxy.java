/**
 * 壹钱包 Copyright (c) 2013-2017 壹钱包版权所有.
 */
package com.rust.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author FUTANGHANG004
 * @version $Id: DynamicProxy, v 0.1 2017/12/20 FUTANGHANG004 Exp $
 */
public class DynamicProxy implements InvocationHandler {

  private Object proxyTarget;

  public DynamicProxy(Object proxyTarget) {
    this.proxyTarget = proxyTarget;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("add start");
    Object o = method.invoke(proxyTarget, args);
    System.out.println("add end");
    return o;
  }
}
