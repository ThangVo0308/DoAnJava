package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import BUS.BUS_taiKhoan;
import DTO.DTO_Taikhoan;

public class loginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_user;
	public JPasswordField textField_password;
	public JCheckBox chckbxNewCheckBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    UIManager.setLookAndFeel( new FlatLightLaf()) ;
				} catch( Exception ex ) {
				    System.err.println( "Failed to initialize LaF" );
				}
				try {
					loginForm frame = new loginForm();
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
	public loginForm() {
		setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 571);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setBackground(new Color(230, 230, 250));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(128, 0, 255));
		lblNewLabel.setBounds(658, 64, 158, 42);
		contentPane.add(lblNewLabel);
		
		textField_user = new JTextField();
		textField_user.setBackground(new Color(255, 255, 255));
		textField_user.setBounds(670, 183, 178, 31);
		contentPane.add(textField_user);
		textField_user.setColumns(10);
		
		JButton btnNewButton_submit = new JButton("ĐĂNG NHẬP");
		btnNewButton_submit.setFont(new Font("Arial", Font.BOLD, 10));
		btnNewButton_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(login()) {
					System.out.println("OKKK");
				}
			}
		});
		btnNewButton_submit.setBackground(new Color(221, 160, 221));
		btnNewButton_submit.setBounds(582, 424, 254, 42);
		contentPane.add(btnNewButton_submit);
		
		ImageIcon iconUser = new ImageIcon("Icons8-Windows-8-Users-Name.64.png","User");
		
		JLabel lblNewLabel_2_1 = new JLabel("Mật khẩu");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_2_1.setForeground(new Color(128, 0, 255));
		lblNewLabel_2_1.setBounds(582, 291, 66, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(loginForm.class.getResource("/img/Icons8-Windows-8-Users-Name.32.png")));
		lblNewLabel_2.setBounds(528, 172, 51, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tài khoản");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_3.setForeground(new Color(128, 0, 255));
		lblNewLabel_3.setBounds(582, 189, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(loginForm.class.getResource("/img/Icons8-Ios7-User-Interface-Password.32.png")));
		lblNewLabel_4.setBounds(533, 266, 46, 50);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(loginForm.class.getResource("/img/phone is real.png")));
		lblNewLabel_5.setBounds(10, 0, 500, 534);
		contentPane.add(lblNewLabel_5);
		
		textField_password = new JPasswordField();
		textField_password.setBackground(new Color(255, 255, 255));
		textField_password.setColumns(10);
		textField_password.setBounds(670, 279, 178, 31);
		contentPane.add(textField_password);
		
		chckbxNewCheckBox = new JCheckBox("Hiển thị mật khẩu");
		chckbxNewCheckBox.setFont(new Font("Arial", Font.BOLD, 10));
		chckbxNewCheckBox.setBackground(new Color(230, 230, 250));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					textField_password.setEchoChar((char)0);
				}else {
					textField_password.setEchoChar('•');
				}
				
			}
		});
		chckbxNewCheckBox.setBounds(668, 321, 123, 23);
		contentPane.add(chckbxNewCheckBox);
	}
	
	public boolean login() {
	    BUS_taiKhoan bustk = new BUS_taiKhoan();
	    for (DTO_Taikhoan tk : bustk.getListTK()) {
	        if (textField_user.getText().equals(tk.getTen_TK()) && String.valueOf(textField_password.getPassword()).equals(tk.getMat_khau())) {
	            if (textField_user.getText().equals("Admin") && String.valueOf(textField_password.getPassword()).equals("123123")) {
	                QuanLyForm qlForm = new QuanLyForm();
	                loginForm.this.setVisible(false);
	                qlForm.setVisible(true);
	                JOptionPane.showMessageDialog(null, "Đăng nhập tài khoản quản lý thành công");
	                return true;
	            } else if (textField_user.getText().equals("hahaha") && String.valueOf(textField_password.getPassword()).equals("123123")) {
	                BanHangForm bhForm = new BanHangForm();
	                loginForm.this.setVisible(false);
	                bhForm.setVisible(true);
	                JOptionPane.showMessageDialog(null, "Đăng nhập tài khoản nhân viên thành công");
	                return true;
	            }else if (textField_user.getText().equals("banhang1") && String.valueOf(textField_password.getPassword()).equals("123123")) {
	                HoaDonFormBH bhForm = new HoaDonFormBH();
	                loginForm.this.setVisible(false);
	                bhForm.setVisible(true);
	                JOptionPane.showMessageDialog(null, "Đăng nhập tài khoản bán hàng thành công");
	                return true;
	            }
	        }
	    }
	    JOptionPane.showMessageDialog(null, "Sai thông tin tài khoản hoặc mật khẩu");
	    return false;
	}	
}
