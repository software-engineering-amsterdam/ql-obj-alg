package ql_obj_alg.operation.printer.boxalg;

import java.util.List;

@SuppressWarnings("unchecked") 
public interface BoxAlg<X> {
	X H(List<X> kids);
	X V(List<X> kids);
	X I(List<X> kids);

	X H(X ...kids);
	X V(X ...kids);
	X I(X ...kids);
	
	X H(int hs, X ...kids);
	X V(int vs, X ...kids);
	X I(int is, X ...kids);
	X I(int is, int vs, X ...kids);
	
	X H(int hs, List<X> kids);
	X V(int vs, List<X> kids);
	X I(int is, List<X> kids);
	X I(int is, int vs, List<X> kids);
	
	X L(String txt);
}
