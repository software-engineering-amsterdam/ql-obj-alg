package ql_obj_alg.parsers.antlr4_generated_parser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Builder {
	
	private Method method;
	private Object[] args;

	Builder(Method method, Object[] args){
		this.method = method;
		this.args = args;
		
	}

	public Object build(Object Factory){
		try {
			return method.invoke(Factory, args);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
