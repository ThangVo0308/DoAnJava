package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.toedter.calendar.JDateChooser;

public class TaiKhoanForm extends JFrame {

	private JPanel contentPane;
	public ArrayList<JComponent> listComponent = new ArrayList<>();
	public ArrayList<Point> toaDoBanDau = new ArrayList<Point>();
	private JPanel TaiKhoanPanel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTable table_1;
	private JLabel lblTaiKhoan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaiKhoanForm frame = new TaiKhoanForm();
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
	public TaiKhoanForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 1185, 884);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0,60));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(265,500));
		contentPane.add(panel_1, BorderLayout.WEST);
		
		TaiKhoanPanel = new JPanel();
		TaiKhoanPanel.setBackground(new Color(192, 192, 192));
		contentPane.add(TaiKhoanPanel, BorderLayout.CENTER);
		GridBagLayout gbl_TaiKhoanPanel = new GridBagLayout();
		gbl_TaiKhoanPanel.columnWidths = new int[]{0, 219, 244, 97, 157, 116, 0, 0};
		gbl_TaiKhoanPanel.rowHeights = new int[]{87, 41, 39, 37, 37, 46, 45, 40, 16, 61, 84, 56, 42, 0, 0};
		gbl_TaiKhoanPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_TaiKhoanPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		TaiKhoanPanel.setLayout(gbl_TaiKhoanPanel);
		
		lblTaiKhoan = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 24));
		GridBagConstraints gbc_lblTaiKhoan = new GridBagConstraints();
		gbc_lblTaiKhoan.insets = new Insets(0, 0, 5, 0);
		gbc_lblTaiKhoan.gridwidth = 7;
		gbc_lblTaiKhoan.gridx = 0;
		gbc_lblTaiKhoan.gridy = 0;
		TaiKhoanPanel.add(lblTaiKhoan, gbc_lblTaiKhoan);
		
		JLabel lblNewLabel_1 = new JLabel("Mã tài khoản");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		TaiKhoanPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		TaiKhoanPanel.add(textField, gbc_textField);
		
		JLabel lblNewLabel_2 = new JLabel("Tên tài khoản");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		TaiKhoanPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		TaiKhoanPanel.add(textField_1, gbc_textField_1);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\HK2-N2\\JAVA\\DoAnJava (4)\\src\\img\\add.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem = new GridBagConstraints();
		gbc_btnThem.fill = GridBagConstraints.BOTH;
		gbc_btnThem.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem.gridx = 4;
		gbc_btnThem.gridy = 2;
		TaiKhoanPanel.add(btnThem, gbc_btnThem);
		
		JButton btnThem_1 = new JButton("Sửa");
		btnThem_1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\HK2-N2\\JAVA\\DoAnJava (4)\\src\\img\\sua.png"));
		btnThem_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem_1 = new GridBagConstraints();
		gbc_btnThem_1.fill = GridBagConstraints.BOTH;
		gbc_btnThem_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem_1.gridx = 5;
		gbc_btnThem_1.gridy = 2;
		TaiKhoanPanel.add(btnThem_1, gbc_btnThem_1);
		
		JLabel lblNewLabel_3 = new JLabel("Mật khẩu");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		TaiKhoanPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		TaiKhoanPanel.add(textField_2, gbc_textField_2);
		
		JButton btnThem_2 = new JButton("Xóa");
		btnThem_2.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\HK2-N2\\JAVA\\DoAnJava (4)\\src\\img\\delete.png"));
		btnThem_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem_2.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem_2 = new GridBagConstraints();
		gbc_btnThem_2.fill = GridBagConstraints.BOTH;
		gbc_btnThem_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem_2.gridx = 4;
		gbc_btnThem_2.gridy = 3;
		TaiKhoanPanel.add(btnThem_2, gbc_btnThem_2);
		
		JButton btnThem_3 = new JButton("Reset");
		btnThem_3.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\HK2-N2\\JAVA\\DoAnJava (4)\\src\\img\\reload.png"));
		btnThem_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem_3.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem_3 = new GridBagConstraints();
		gbc_btnThem_3.fill = GridBagConstraints.BOTH;
		gbc_btnThem_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem_3.gridx = 5;
		gbc_btnThem_3.gridy = 3;
		TaiKhoanPanel.add(btnThem_3, gbc_btnThem_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Số điện thoại");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1.gridx = 1;
		gbc_lblNewLabel_3_1.gridy = 4;
		TaiKhoanPanel.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		TaiKhoanPanel.add(textField_3, gbc_textField_3);
		
		JButton btnThem_4 = new JButton("Xuất Excel");
		btnThem_4.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\HK2-N2\\JAVA\\DoAnJava (4)\\src\\img\\xuat excel.png"));
		btnThem_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem_4.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem_4 = new GridBagConstraints();
		gbc_btnThem_4.fill = GridBagConstraints.BOTH;
		gbc_btnThem_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem_4.gridx = 4;
		gbc_btnThem_4.gridy = 4;
		TaiKhoanPanel.add(btnThem_4, gbc_btnThem_4);
		
		JButton btnThem_5 = new JButton("Nhập Excel");
		btnThem_5.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\HK2-N2\\JAVA\\DoAnJava (4)\\src\\img\\nhap excel.png"));
		btnThem_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem_5.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem_5 = new GridBagConstraints();
		gbc_btnThem_5.fill = GridBagConstraints.BOTH;
		gbc_btnThem_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem_5.gridx = 5;
		gbc_btnThem_5.gridy = 4;
		TaiKhoanPanel.add(btnThem_5, gbc_btnThem_5);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã tài khoản", "Tên tài khoản", "Mật khẩu", "Số điện thoại","Ngày tạo","Trạng thái"
			}
		));
		table_1.setRowHeight(50);
		table_1.setBounds(1, 25, 922, -2);
		table_1.setDefaultEditor(Object.class, null);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Ngày tạo");
		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_3_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1_1.gridx = 1;
		gbc_lblNewLabel_3_1_1.gridy = 5;
		TaiKhoanPanel.add(lblNewLabel_3_1_1, gbc_lblNewLabel_3_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 5;
		TaiKhoanPanel.add(dateChooser, gbc_dateChooser);
		
		JLabel lblNewLabel_5 = new JLabel("Tìm kiếm: ");
		lblNewLabel_5.setToolTipText("Tìm kiếm");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBackground(new Color(128, 0, 64));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 7;
		TaiKhoanPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.BOTH;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 7;
		TaiKhoanPanel.add(textField_5, gbc_textField_5);
		
		JButton btnThem_4_1 = new JButton("Thêm");
		btnThem_4_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem_4_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem_4_1 = new GridBagConstraints();
		gbc_btnThem_4_1.fill = GridBagConstraints.BOTH;
		gbc_btnThem_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem_4_1.gridx = 3;
		gbc_btnThem_4_1.gridy = 7;
		TaiKhoanPanel.add(btnThem_4_1, gbc_btnThem_4_1);
		TaiKhoanPanel.add(table_1);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setEnabled(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 9;
		TaiKhoanPanel.add(scrollPane, gbc_scrollPane);
		
		Color customColor = new Color(226, 221, 221);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm: ");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\HK2-N2\\JAVA\\DoAnJava (1)\\src\\img\\search.png"));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(128, 0, 64));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setToolTipText("Tìm kiếm");
		lblNewLabel.setBounds(87, 392, 132, 35);


		for (Component c : listComponent) {
		    toaDoBanDau.add(c.getLocation());
		}
		
		// an nut phong to
		this.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {
		            int newWidth = getWidth() - 245; // lay ra width moi khi phong to
		            TaiKhoanPanel.setBounds(245, 54, newWidth, TaiKhoanPanel.getHeight()); // update lai vi tri panel moi khi an nut phong to
		            
		            for (Component c : listComponent) {
		                c.setLocation(c.getX() + 200, c.getY());
		            }
		            
		            table_1.setBounds(1, 25, 927, -2);
		    		scrollPane.setBounds(20, 484, 1250, 250);
		        } else {
		        	for (int i = 0; i < listComponent.size(); i++) {
		                listComponent.get(i).setLocation(toaDoBanDau.get(i));
		            }
		        	TaiKhoanPanel.setBounds(245, 54, 926, 762);
		        	lblTaiKhoan.setBounds(200, 10, 486, 42);
		    		table_1.setBounds(1, 25, 922, -2);
		    		scrollPane.setBounds(10, 484, 924, 250);
		        }
		    }
		});
		
		

	}

	public JPanel getTaiKhoanJPanel() {
		// TODO Auto-generated method stub
		return TaiKhoanPanel;
	}
	}

