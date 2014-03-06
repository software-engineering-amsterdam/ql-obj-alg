package ql_obj_alg.operation.user_interface.creator;

import java.text.NumberFormat;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.operation.user_interface.modules.FieldsIdsTable;
import ql_obj_alg.operation.user_interface.modules.FormFrame;
import ql_obj_alg.operation.user_interface.modules.Question;
import ql_obj_alg.types.Type;

public class StmtUserInterfaceCreation implements IStmtAlg<Void, IQuestionFieldCreator> {

	@Override
	public IQuestionFieldCreator iff(Void cond, final IQuestionFieldCreator b) {
		return new IQuestionFieldCreator(){
			@Override
			public void create(FormFrame frame, FieldsIdsTable fields){
				b.create(frame, fields);
			}
		};	
	}

	@Override
	public IQuestionFieldCreator iffelse(Void cond, final IQuestionFieldCreator b1, final IQuestionFieldCreator b2) {
		return new IQuestionFieldCreator(){
			@Override
			public void create(FormFrame frame, FieldsIdsTable fields){
				b1.create(frame, fields);
				b2.create(frame, fields);
			}
		};		
	}

	@Override
	public IQuestionFieldCreator comb(final List<IQuestionFieldCreator> listStatements) {
		return new IQuestionFieldCreator(){
			@Override
			public void create(FormFrame frame, FieldsIdsTable fields){
				for(IQuestionFieldCreator stmt : listStatements){
					stmt.create(frame, fields);
				}
			}
		};
	}

	@Override
	public IQuestionFieldCreator question(final String id, final String label, final Type type) {
		return new IQuestionFieldCreator(){
			@Override
			public void create(FormFrame frame, FieldsIdsTable fields){

				JComponent q = null;
				if(type.isBoolean()){
					q = new JCheckBox();
				}
				else if(type.isNumber()){
					JFormattedTextField qField = new JFormattedTextField(NumberFormat.getNumberInstance());
					qField.setColumns(15);
					q = qField;
				}
				else if(type.isAlphanumeric()){
					JTextField qField = new JTextField();
					qField.setColumns(15);
					q = qField;
				}
				else
					assert false : "Unknown type";
				
				JLabel jLabel = new JLabel(label);

				Question question = new Question(q,jLabel);
				fields.storeQuestion(id, question);
				question.addToFrame(frame);
				question.setVisible(true);
			}
		};
	}

	@Override
	public IQuestionFieldCreator question(final String id, final String label, final Type type, Void e) {
		return new IQuestionFieldCreator(){
			@Override
			public void create(FormFrame frame, FieldsIdsTable fields){

				JComponent q = null;
				if(type.isBoolean()){
					q = new JCheckBox();
				}
				else if(type.isNumber()){
					JFormattedTextField qField = new JFormattedTextField(NumberFormat.getNumberInstance());
					qField.setColumns(15);
					q = qField;
				}
				else if(type.isAlphanumeric()){
					JTextField qField = new JTextField();
					qField.setColumns(15);
					q = qField;
				}
				else
					assert false : "Unknown type";
				q.setEnabled(false);
				
				JLabel jLabel = new JLabel(label);
				Question question = new Question(q,jLabel);
				fields.storeQuestion(id, question);
				question.addToFrame(frame);
				question.setVisible(true);
			}
		};
	}

}
