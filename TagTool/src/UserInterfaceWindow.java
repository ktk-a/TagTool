import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UserInterfaceWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterfaceWindow frame = new UserInterfaceWindow();
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
	public UserInterfaceWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane searchText = new JTextPane();
		searchText.setBounds(43, 47, 114, 21);
		contentPane.add(searchText);
		
		JButton searchButton = new JButton("Search");
		searchButton.setForeground(new Color(0, 0, 0));
		searchButton.setBounds(167, 47, 87, 23);
		contentPane.add(searchButton);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(456, 20, 87, 23);
		contentPane.add(logoutButton);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.setBounds(43, 128, 392, 224);
		contentPane.add(table);
		
		JButton editButton = new JButton("Edit");
		editButton.setBounds(456, 223, 87, 23);
		contentPane.add(editButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(456, 265, 87, 23);
		contentPane.add(clearButton);
		
		JButton removeButton = new JButton("Remove");
		removeButton.setBounds(456, 307, 87, 23);
		contentPane.add(removeButton);
		
		JButton testButton = new JButton("Test");
		testButton.setBounds(348, 87, 87, 23);
		contentPane.add(testButton);
	}
}
