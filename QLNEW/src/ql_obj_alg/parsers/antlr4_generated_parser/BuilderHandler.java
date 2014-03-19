package ql_obj_alg.parsers.antlr4_generated_parser;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class BuilderHandler implements InvocationHandler{

	@Override
	public Builder invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return new Builder(method,args);
	}

}
