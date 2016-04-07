package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

//               Диалоговое окно для задания названия выработки 
//----------------------------------------------------------------------------

public class PassportDialog implements ActionListener {
	
	public JDialog jdial;
	
	public JLabel nameLabel, absLabel, typeLabel;
	
	public JTextField nameTxtf, absTxtf;
	
	public JButton jbtOk, jbtCancel, jbtApply;
	
	
	public PassportDialog(){
		
		jdial = new JDialog();
		jdial.setTitle("Паспорт выработки");
		jdial.setModal(true);
		jdial.setSize(500, 400);
		jdial.setLocationRelativeTo(null);
		
		GridBagLayout gb = new GridBagLayout();
		jdial.setLayout(gb);
		
		nameLabel = new JLabel("Номер выработки");
		absLabel = new JLabel("Абсолютная отметка, м");
		typeLabel = new JLabel("Тип выработки");
		
		nameTxtf = new JTextField(15);
		absTxtf = new JTextField(15);
		
		jbtOk = new JButton("Ок");
		jbtCancel = new JButton("Отмена");
		jbtApply = new JButton("Применить");
		
		jbtOk.addActionListener(this);
		jbtCancel.addActionListener(this);
		jbtApply.addActionListener(this);
		
		jdial.add(nameLabel, new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,
	            new Insets(5, 5, 5, 5), 0, 0));
		jdial.add(absLabel, new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,
	            new Insets(5, 5, 5, 5), 0, 0));
		jdial.add(typeLabel, new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,
	            new Insets(5, 5, 5, 5), 0, 0));
		jdial.add(nameTxtf, new GridBagConstraints(1,0,2,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,
	            new Insets(5, 5, 5, 5), 0, 0));
		jdial.add(absTxtf, new GridBagConstraints(1,1,2,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,
	            new Insets(5, 5, 5, 5), 0, 0));
		jdial.add(jbtOk, new GridBagConstraints(1,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,
	            new Insets(5, 5, 5, 5), 0, 0));
		jdial.add(jbtCancel, new GridBagConstraints(2,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,
	            new Insets(5, 5, 5, 5), 0, 0));
		jdial.add(jbtApply, new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,
	            new Insets(5, 5, 5, 5), 0, 0));
		
		jdial.pack();
		jdial.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e){
		
		if (e.getActionCommand().equals(jbtOk.getActionCommand()))
		{
		System.out.println("qq");	
		}
		
	}
}
