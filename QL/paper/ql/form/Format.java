package ql.form;

import java.util.List;

import box.IFormat;
import ql_obj_alg.operation.printer.IFormatWithPrecedence;

public class Format implements QLAlg<IFormat, IFormat, IFormatWithPrecedence, IFormat> {

	@Override
	public IFormatWithPrecedence intLit(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormatWithPrecedence var(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormatWithPrecedence neg(IFormatWithPrecedence e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormatWithPrecedence add(IFormatWithPrecedence l,
			IFormatWithPrecedence r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormatWithPrecedence eq(IFormatWithPrecedence l,
			IFormatWithPrecedence r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormatWithPrecedence not(IFormatWithPrecedence e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormatWithPrecedence and(IFormatWithPrecedence l,
			IFormatWithPrecedence r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormat integer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormat bool() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormat string() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormat form(String name, List<IFormat> body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormat ifThen(IFormatWithPrecedence cond, List<IFormat> body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormat answerable(String name, String label, IFormat type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormat computed(String name, String label,
			IFormatWithPrecedence expr) {
		// TODO Auto-generated method stub
		return null;
	}

}
