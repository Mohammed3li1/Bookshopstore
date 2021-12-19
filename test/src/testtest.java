import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class testtest extends JFrame {

	private JPanel contentPane;
	private JTextField txtbname;
	private JTextField txtedition;
	private JTextField txtprice;
	DefaultTableModel model;
	private Object[] rows;
	private JTable table;
	private JTextField txtbookid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testtest frame = new testtest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testtest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Shop");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(316, 11, 229, 111);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(512, 147, 294, 313);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				txtbookid.setText((String) model.getValueAt(i, 0));
				txtbname.setText((String) model.getValueAt(i, 1));
				txtedition.setText((String) model.getValueAt(i, 2));
				txtprice.setText((String) model.getValueAt(i, 3));
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"Book_ID","Book_Name", "Edition", "Price"};
		rows = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane_1.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(33, 146, 350, 255);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("BookName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(29, 100, 95, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Edition");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(29, 157, 95, 26);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("price");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(29, 199, 95, 45);
		panel.add(lblNewLabel_1_2);
		
		txtbname = new JTextField();
		txtbname.setBounds(146, 95, 166, 40);
		panel.add(txtbname);
		txtbname.setColumns(10);
		
		txtedition = new JTextField();
		txtedition.setColumns(10);
		txtedition.setBounds(146, 152, 166, 40);
		panel.add(txtedition);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(146, 203, 166, 40);
		panel.add(txtprice);
		
		txtbookid = new JTextField();
		txtbookid.setColumns(10);
		txtbookid.setBounds(146, 36, 166, 40);
		panel.add(txtbookid);
		
		JLabel lblNewLabel_1_3 = new JLabel("Book_ID");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(29, 41, 95, 26);
		panel.add(lblNewLabel_1_3);
		
		JButton btnNewButton = new JButton("save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtbname.getText().equals(" ") || txtedition.getText().equals("")
						|| txtprice.getText().equals("")) {
					JOptionPane.showMessageDialog(null, " Please complete the information ");
				} else {

					rows[0] = txtbookid.getText();
					rows[1] = txtbname.getText();
					rows[2] = txtedition.getText();
					rows[3] = txtprice.getText();
					
					model.addRow(rows);

					txtbookid.setText("");
					txtbname.setText("");
					txtedition.setText("");
					txtprice.setText("");
					
					JOptionPane.showMessageDialog(null, " Saved successfuly ");
				}
			}
		});
		btnNewButton.setBounds(51, 412, 101, 54);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			
			}
		});
		btnExit.setBounds(162, 412, 101, 54);
		contentPane.add(btnExit);
		
		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtbookid.setText(null);
				txtbname.setText(null);
				txtedition.setText(null);
				txtprice.setText(null);
			}
		});
		btnClear.setBounds(273, 412, 101, 54);
		contentPane.add(btnClear);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if(i>=0) {
					
					model.setValueAt(txtbookid.getText(), i, 0);
					model.setValueAt(txtbname.getText(), i, 1);
					model.setValueAt(txtedition.getText(), i, 2);
					model.setValueAt(txtprice.getText(), i, 3);
					JOptionPane.showMessageDialog(null, " Updated successfuly ");
					
					txtbookid.setText("");
					txtbname.setText("");
					txtedition.setText("");
					txtprice.setText("");
					
				}else {
					JOptionPane.showMessageDialog(null, " Please select a row first ");
				}
				
			}
		});
		btnNewButton_1.setBounds(541, 503, 115, 54);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, " Deleted successfuly ");
					
					txtbookid.setText("");
					txtbname.setText("");
					txtedition.setText("");
					txtprice.setText("");
					
				} else {
					JOptionPane.showMessageDialog(null, " Please select a row first ");
				}
			}
		});
		btnNewButton_1_1.setBounds(666, 503, 115, 54);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Print");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat header=new MessageFormat("Book Shop");
				MessageFormat footer=new MessageFormat("Page");
				
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(null, "unable to print");
				}
			}
		});
		btnNewButton_1_2.setBounds(162, 503, 115, 54);
		contentPane.add(btnNewButton_1_2);
	}
}
