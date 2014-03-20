package ql_obj_alg.parsers.antlr4_generated_parser;

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

	public Object build(Object FactoryForm, Object StmtForm, Object ExpForm){
		try {
			List<Object> Iargs = new ArrayList<Object>();
			for(Object arg : args){
				if(arg instanceof List){
					List<Object> IargList = new ArrayList<Object>();
					for(Object arg_ : (List)arg){
						IargList.add(((Builder)arg_).build(FactoryForm, StmtForm, ExpForm));
					}
					Iargs.add(IargList);
				}else if(arg instanceof Builder){
					Iargs.add(((Builder)arg).build(FactoryForm, StmtForm, ExpForm));
				}else{
					Iargs.add(arg);
				}
			}
			return invokeCorrectAlg(FactoryForm,StmtForm,ExpForm,Iargs.toArray());
			
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

	private Object invokeCorrectAlg(Object FactoryForm, Object StmtForm, Object ExpForm, Object[] Iargs) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if(hasMethod(FactoryForm))
			return method.invoke(FactoryForm, Iargs);
		else if(hasMethod(StmtForm))
			return method.invoke(StmtForm, Iargs);		
		else if(hasMethod(ExpForm))
			return method.invoke(ExpForm, Iargs);
		else
			assert false : "method was not found in algebras";
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
