package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import Helper.DBConnection;
import Helper.Helper;
import Model.Bashekim;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import Helper.Helper;

public class LoginGUI extends JFrame {

	private JPanel w_pane;
	private JTextField fld_hastaTc;
	private JTextField textField_1;
	private JPasswordField fld_doctorPass;
	private JPasswordField fld_doctorTc;
	private DBConnection xConnection=new DBConnection();

	/**
	 * Launch the application.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setTitle("Hastane Otomasyon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		w_pane = new JPanel();
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("hastane.png")));
		lbl_logo.setBounds(230, 11, 169, 145);
		w_pane.add(lbl_logo);
		
		JLabel lblNewLabel = new JLabel("Hastane Y\u00F6netim Sistemine Hosgeldiniz");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(154, 168, 320, 32);
		w_pane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 209, 564, 191);
		w_pane.add(tabbedPane);
		
		JPanel w_hastaLogin = new JPanel();
		w_hastaLogin.setBackground(Color.WHITE);
		tabbedPane.addTab("Hasta Girisi", null, w_hastaLogin, null);
		w_hastaLogin.setLayout(null);
		
		JLabel lbl_hastaTc = new JLabel("T.C Numaraniz :");
		lbl_hastaTc.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl_hastaTc.setBounds(46, 11, 142, 32);
		w_hastaLogin.add(lbl_hastaTc);
		
		JLabel lbl_hastaPass = new JLabel("Sifre :");
		lbl_hastaPass.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl_hastaPass.setBounds(46, 72, 142, 32);
		w_hastaLogin.add(lbl_hastaPass);
		
		fld_hastaTc = new JTextField();
		fld_hastaTc.setBounds(209, 11, 221, 32);
		w_hastaLogin.add(fld_hastaTc);
		fld_hastaTc.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(209, 72, 221, 32);
		w_hastaLogin.add(textField_1);
		
		JButton btnNewButton = new JButton("Kayit Ol");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNewButton.setBounds(46, 115, 165, 37);
		w_hastaLogin.add(btnNewButton);
		
		JButton btnGirisYap = new JButton("Giris Yap");
		btnGirisYap.setFont(new Font("Verdana", Font.BOLD, 14));
		btnGirisYap.setBounds(265, 115, 165, 37);
		w_hastaLogin.add(btnGirisYap);
		
		JPanel w_doctorLogin = new JPanel();
		w_doctorLogin.setBackground(Color.WHITE);
		tabbedPane.addTab("Doktor girisi", null, w_doctorLogin, null);
		w_doctorLogin.setLayout(null);
		
		JLabel lbl_doctorTc = new JLabel("T.C Numaraniz :");
		lbl_doctorTc.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl_doctorTc.setBounds(50, 11, 142, 32);
		w_doctorLogin.add(lbl_doctorTc);
		
		JButton btn_doctorKayit = new JButton("Kayit Ol");
		btn_doctorKayit.setFont(new Font("Verdana", Font.BOLD, 14));
		btn_doctorKayit.setBounds(50, 115, 165, 37);
		w_doctorLogin.add(btn_doctorKayit);
		
		JButton btn_doctorGiris = new JButton("Giris Yap");
		btn_doctorGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(fld_doctorTc.getText().length()==0|| fld_doctorPass.getText().length()==0) {
					 Helper.showMsg("fill");
				 }else {
					 //DB connection
					 Statement st = xConnection.createStatement();
						try {
							ResultSet rs=st.executeQuery("SELECT*FROM KULLANICI");
							while(rs.next()) {
								if(fld_doctorTc.getText().equals(rs.getString("TCNO"))&&fld_doctorPass.getText().equals(rs.getString("PASSWORD"))) {
									Bashekim bhekim=new Bashekim();
									bhekim.setId(rs.getInt("ID"));
									bhekim.setPassword("PASSWORD");
									bhekim.setTcno(rs.getString("TCNO"));
									bhekim.setName(rs.getString("NAME"));
									bhekim.setType1b(rs.getString("TYPE1B"));
									System.out.println(bhekim.getName());
								}
							}
						} catch (SQLException e2) {
							
							e2.printStackTrace();
						}
						
						
				 }
			}
		});
		btn_doctorGiris.setFont(new Font("Verdana", Font.BOLD, 14));
		btn_doctorGiris.setBounds(269, 115, 165, 37);
		w_doctorLogin.add(btn_doctorGiris);
		
		JLabel lbl_doctorPass = new JLabel("Sifre :");
		lbl_doctorPass.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl_doctorPass.setBounds(50, 72, 142, 32);
		w_doctorLogin.add(lbl_doctorPass);
		
		fld_doctorPass = new JPasswordField();
		fld_doctorPass.setBounds(213, 65, 221, 27);
		w_doctorLogin.add(fld_doctorPass);
		
		fld_doctorTc = new JPasswordField();
		fld_doctorTc.setBounds(213, 19, 221, 27);
		w_doctorLogin.add(fld_doctorTc);
	}
}
