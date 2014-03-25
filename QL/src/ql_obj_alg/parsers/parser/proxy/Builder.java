package ql_obj_alg.parsers.parser.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Builder {
	
	private Method method;
	private Object[] args;

	Builder(Method method, Object[] args){
		this.method = method;
		this.args = args;		
	}
	
	public Object build(Object factory){
		List<Object> list = new ArrayList<Object>();
		list.add(factory);
		return build(list);
	}

	public Object build(List<Object> factories){
		try {
			List<Object> i_args = new ArrayList<Object>();
			for(Object arg : args){
				i_args.add(buildArgument(factories, arg));
			}
			return invokeCorrectAlg(factories,i_args.toArray());
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		assert false : "was not able to build" + method.getName();
		return null;
	}

	private Object buildArgument(List<Object> factories, Object arg) {
		if(arg instanceof List<?>){
			return builderToInterfaceList(factories, (List<?>) arg);
		}
		else if(arg instanceof Builder){
			return builderToInterface(factories, (Builder) arg);
		}else{
			return arg;
		}
	}

	private Object builderToInterface(List<Object> factories, Builder arg) {
		return arg.build(factories);
	}

	private List<Object> builderToInterfaceList(List<Object> factories, List<?> argList) {
		List<Object> i_argList = new ArrayList<Object>();
		for(Object arg : argList){
			if(arg instanceof Builder){
				i_argList.add(builderToInterface(factories, (Builder) arg));
			}
			else{
				i_argList.add(arg);
			}
		}
		return i_argList;
	}

	private Object invokeCorrectAlg(List<Object> factories, Object[] i_args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		for(Object factory : factories){
			if(hasMethod(factory))
				return method.invoke(factory, i_args);
		}
		assert false : "method was not found in algebras: " + method.getName();
		return null;
	}

	private boolean hasMethod(Object expForm) {
		boolean hasMethod = false;
		Method[] methods = expForm.getClass().getMethods();
		for (Method m : methods) {
		  if (m.getName().equals(method.getName())) {
		    hasMethod = true;
		    break;
		  }
		}
		return hasMethod;
	}
}
