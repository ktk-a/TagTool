import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;
import java.io.*;
import java.lang.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JScrollPane;
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
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginWindow loginUi = new LoginWindow();
				loginUi.show();
				UserInterfaceWindow.this.dispose();
			}
		});
		logoutButton.setBounds(456, 20, 87, 23);
		contentPane.add(logoutButton);
		
		DefaultTableModel DTM = new DefaultTableModel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 128, 392, 224);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
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
		
		table.setModel(DTM);
		
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
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s[]={"fileName","Tags"};
				DTM.setColumnIdentifiers(s);
				Root a = new Root();
				File f = new File("C:\\Users\\"+ a.userName() +"\\git\\TagTool\\TagTool\\images\\");
				File[] list = f.listFiles();
				
				for(int i=0;i<list.length;i++){
					DTM.addRow(new Object[]{list[i].getName(),list[i].getName()});
				}
			}
		});
		testButton.setBounds(348, 87, 87, 23);
		contentPane.add(testButton);
	}
		
	
	
	
	private static int dataCount=0;
	private static int tagsCount=0;	
	private Data[] data;
	private Tags[] tags;
	
	
	public  void dataSort(Data[] bdata){	//把data依名字做排序
		for(int i=1;i<=dataCount;i++){
			Data temp=bdata[i];
			int j;
			for(j=i-1;j>=0 && bdata[j].getDataName().compareTo(temp.getDataName())>0;j--)
				bdata[j+1]=bdata[j];
			bdata[j+1]=temp;
		}
	}
	
	public static void tagSort(Tags[] btags){	//把tags依名字做排序
		for(int i=1;i<=tagsCount;i++){
			Tags temp=btags[i];
			int j;
			for(j=i-1;j>=0 && btags[j].getTagName().compareTo(temp.getTagName())>0;j--)
				btags[j+1]=btags[j];
			btags[j+1]=temp;
		}
		
	}
	
	public void changeTagName(Tags btag, String string){	//改特定tag的name
		String[] bdataList=btag.getDataList();	//取出該tag的dataList
		String buffer=btag.getTagName();		//暫存修改前的tag名
		btag.changeTagName(string);				//改tag名
		for(int i=1;i<=btag.getDataCount();i++){
			for(int j=1;j<=dataCount;j++){
				if(data[j].getDataName().compareTo(bdataList[i])==0){
					data[j].tagList[data[j].searchTag(buffer)]=string;	//把data中的tag改名
					data[j].sort();	//tagList有更動後必定重新排序tagList
					data[j].bind();	//並且合併成字串,方便顯示於UI
				}
			}
			
		}
		
	}
	
	public void deleteTag(Tags btag){	//刪除tag
		String[] bdataList=btag.getDataList();	//取出該tag的dataList
		//未完成
	}
}
