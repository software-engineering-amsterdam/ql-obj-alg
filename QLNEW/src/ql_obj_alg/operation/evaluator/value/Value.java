package ql_obj_alg.operation.evaluator.value;

public abstract class Value {

	public abstract Integer getInteger();
	public abstract Boolean getBoolean();
	public abstract String getString();
	public abstract boolean isUndefined();
	public abstract boolean isError();
	public abstract int compareTo(Value v);
}
