import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextPane;

import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.*;


public class LoginWindow<C> extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
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
	public LoginWindow(){
		int accountHash =1023432427; 
		int passwordHash = -1650067834; 
		
		setTitle("TagTool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("設計師/檔案管理員登入");
		lblNewLabel.setBounds(147, 70, 133, 15);
		contentPane.add(lblNewLabel);
		
		//accountText
		JTextPane accountText = new JTextPane();
		accountText.setForeground(Color.GRAY);
		accountText.setBounds(87, 89, 239, 21);
		contentPane.add(accountText);
		
		//passwordText
		JTextPane passwordText = new JTextPane();
		passwordText.setLocation(87, 120);
		passwordText.setSize(239, 21);
		contentPane.add(passwordText);
		
		//accountLabel
		JLabel account = new JLabel("帳號：");
		account.setToolTipText("accountName");
		account.setBounds(42, 95, 46, 15);
		contentPane.add(account);
		
		//passwordLabel
		JLabel password = new JLabel("密碼：");
		password.setBounds(42, 120, 46, 15);
		contentPane.add(password);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserInterfaceWindow ui = new UserInterfaceWindow();
				ui.show();
				LoginWindow.this.dispose();

				String account_ck = new String(accountText.getText());
				String password_ck = new String(passwordText.getText());
		/*		if(account_ck.hashCode()==accountHash&&password_ck.hashCode()==passwordHash){
					UserInterfaceWindow ui = new UserInterfaceWindow();
					ui.show();
					LoginWindow.this.dispose();
				}else
					System.out.println("2");*/
			}
		});
		loginButton.setBounds(159, 151, 87, 23);
		contentPane.add(loginButton);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Root a = new Root();
				a.output();
			}
		});
		btnNewButton.setBounds(26, 208, 87, 23);
		contentPane.add(btnNewButton);
		

	}
}
