package box;


import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked") 
public abstract class DesugarBox<X> implements BoxAlg<X> {
	@Override
	public X H(List<X> kids) {
		return H(0, kids);
	}
	
	@Override
	public X V(List<X> kids) {
		return V(1, kids);
	}
	
	@Override
	public X I(List<X> kids) {
		return I(1, kids);
	}
	
	@Override
	public X H(X... kids) {
		return H(Arrays.asList(kids));
	}

	@Override
	public X V(X... kids) {
		return V(Arrays.asList(kids));
	}

	@Override
	public X I(X... kids) {
		return I(Arrays.asList(kids));
	}

	@Override
	public X H(int hs, X ...kids) {
		return H(hs, Arrays.asList(kids));
	}
	
	@Override
	public X V(int vs, X ...kids) {
		return V(vs, Arrays.asList(kids));
	}
	
	public X I(int is, X ...kids) {
		return I(is, Arrays.asList(kids));
	}
	
	@Override
	public X I(int is, int vs, X ...kids) {
		return I(is, vs, Arrays.asList(kids));
	}
	
	
	@Override
	public X I(int is, List<X> kids) {
		return I(is, 1, kids);
	}
	
}
