package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheableInvocationHandler implements InvocationHandler {

  private Object realObject;
  private Map<String, Object> cachedValues = new HashMap<>();

  public CacheableInvocationHandler(Object realObject) {

    this.realObject = realObject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    Cacheable cacheableAnnotation = realObject.
        getClass().
        getMethod(method.getName(), method.getParameterTypes()).
        getAnnotation(Cacheable.class);

    if (cacheableAnnotation != null) {
      String cacheId = cacheableAnnotation.value();
      if (cachedValues.containsKey(cacheId)) {
        return cachedValues.get(cacheId);
      } else {
        var result = method.invoke(realObject, args);
        cachedValues.put(cacheId, result);
        return result;
      }

    } else {
      return method.invoke(realObject, args);
    }
  }
}
