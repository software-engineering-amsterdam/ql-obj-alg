package ql_obj_alg.pgen;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Builder {
	
	private Method method;
	private Object[] args;

	
	@SuppressWarnings("unchecked")
	public static <T> T builderBuilder(Class<T> alg) {
		return (T) Proxy.newProxyInstance(alg.getClassLoader(),new Class[]{alg},new BuilderHandler());
	}
			
	
	private static class BuilderHandler implements InvocationHandler{
		@Override
		public Builder invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			return new Builder(method,args);
		}
	}

	
	Builder(Method method, Object[] args){
		this.method = method;
		this.args = args;		
	}
	
	@SuppressWarnings("unchecked")
	public <T> T build(Object ...factories){
		try {
			List<Object> i_args = new ArrayList<Object>();
			for(Object arg : args){
				i_args.add(buildArgument(arg, factories));
			}
			return (T) invokeCorrectAlg(Arrays.asList(factories),i_args.toArray());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new AssertionError("was not able to build" + method.getName());
	}

	private Object buildArgument(Object arg, Object ...factories) {
		if(arg instanceof List<?>){
			return builderToInterfaceList((List<?>) arg, factories);
		}
		else if(arg instanceof Builder){
			return builderToInterface((Builder) arg, factories);
		}else{
			return arg;
		}
	}

	private Object builderToInterface(Builder arg, Object ...factories) {
		return arg.build(factories);
	}

	private List<Object> builderToInterfaceList(List<?> argList, Object ...factories) {
		List<Object> args = new ArrayList<Object>();
		for(Object arg : argList){
			if(arg instanceof Builder){
				args.add(builderToInterface((Builder)arg, factories));
			}
			else{
				args.add(arg);
			}
		}
		return args;
	}

	private Object invokeCorrectAlg(List<Object> factories, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		for(Object factory : factories){
			if (hasMethod(factory)) {
				return method.invoke(factory, args);
			}
		}
		throw new AssertionError("method was not found in algebras: " + method.getName());
	}

	private boolean hasMethod(Object factory) {
		Method[] methods = factory.getClass().getMethods();
		for (Method m : methods) {
		  if (m.getName().equals(method.getName())) {
		    return true;
		  }
		}
		return false;
	}
}
