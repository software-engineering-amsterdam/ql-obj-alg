package objectalgebra;

public interface QuestionAlg<E, S> extends ExpAlg<E> {
	S iff(E cond, S b);
	S iffelse(E cond,S b1, S b2);
	S comp(S s1, S s2);
	S decl(String id, String label, String type);
	S decl(String id, String label, String type, E e);
}
