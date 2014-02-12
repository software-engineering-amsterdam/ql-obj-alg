package objectalgebra;

public interface FormAlg<E, S, F> extends StmtAlg<E,S> {
	F form(String id, S s);
	F forms(F f1,F f2);
}
