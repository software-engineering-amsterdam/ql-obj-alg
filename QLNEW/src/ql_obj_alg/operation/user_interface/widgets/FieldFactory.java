package ql_obj_alg.operation.user_interface.widgets;


import ql_obj_alg.types.Type;
import ql_obj_alg.types.TBoolean;
import ql_obj_alg.types.TInteger;
import ql_obj_alg.types.TString;

public class FieldFactory {

	public static IWidget createField(String id, String label, Type type){
		assert (type != null) : "Null type in Field Factory.";
		IWidget field = null;
		if(type.equals(new TInteger())){
			field = new IntegerWidget(id, label);
		}
		else if(type.equals(new TString())){
			field = new StringWidget(id, label);
		}
		else if(type.equals(new TBoolean())){
			field = new BooleanWidget(id, label);
		}
		else{
			assert false : "Unknown type.";
		}
		return field;
	}
}
