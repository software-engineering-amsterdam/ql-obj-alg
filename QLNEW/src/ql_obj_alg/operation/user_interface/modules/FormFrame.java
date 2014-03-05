package ql_obj_alg.operation.user_interface.modules;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FormFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel mainPanel;
	JPanel labelPane;
	JPanel fieldPane;

	public FormFrame(String id) {
		super(id);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        labelPane = new JPanel(new GridLayout(0,1));
        fieldPane = new JPanel(new GridLayout(0,1));
        getContentPane().add(labelPane, BorderLayout.CENTER);
        getContentPane().add(fieldPane, BorderLayout.LINE_END);
	}
	
	public void addLabel(JLabel label){
		labelPane.add(label);
	}
	
	public void addField(JComponent field){
		fieldPane.add(field);
	}

	public void render() {
        pack();
        setVisible(true);		
	}
	
}
