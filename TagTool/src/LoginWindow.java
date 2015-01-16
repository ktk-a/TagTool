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
import javax.swing.DropMode;
import javax.swing.JPasswordField;


public class LoginWindow<C> extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

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
		
		JLabel lblNewLabel = new JLabel("請輸入帳號密碼");
		lblNewLabel.setBounds(100, 70, 214, 15);
		contentPane.add(lblNewLabel);
		
		//accountText
		JTextPane accountText = new JTextPane();
		accountText.setForeground(Color.GRAY);
		accountText.setBounds(87, 89, 239, 21);
		contentPane.add(accountText);
		
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
/*				UserInterfaceWindow ui = new UserInterfaceWindow();
				ui.show();
				LoginWindow.this.dispose();
*/
				String account_ck = new String(accountText.getText());
				String password_ck = new String(passwordField.getText());
				if(account_ck.hashCode()==accountHash&&password_ck.hashCode()==passwordHash){
					UserInterfaceWindow ui = new UserInterfaceWindow();
					ui.show();
				}else{
					lblNewLabel.setText("帳號或密碼錯誤，請重新輸入");
					accountText.setText("");
					passwordField.setText("");
				}
			}
		});
		loginButton.setBounds(159, 151, 87, 23);
		contentPane.add(loginButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(87, 120, 239, 21);
		contentPane.add(passwordField);
		
		

	}
}
