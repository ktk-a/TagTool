import java.awt.BorderLayout;
import java.awt.EventQueue;

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


public class LoginWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	public LoginWindow() {
		setTitle("TagTool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("設計師/檔案管理員登入");
		lblNewLabel.setBounds(147, 70, 133, 15);
		contentPane.add(lblNewLabel);
		
		//accountText
		JTextPane accountText = new JTextPane();
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
				String accoun_ck = new String(accountText.getText());
				String password_ck = new String(passwordText.getText());
			}
		});
		loginButton.setBounds(159, 151, 87, 23);
		contentPane.add(loginButton);
	}
}
