package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.BUS_Chucvu;
import BUS.BUS_Dienthoai;
import BUS.BUS_Nhanvien;
import DTO.DTO_Chucvu;
import DTO.DTO_Hoadon;
import DTO.DTO_LoaiDT;
import DTO.DTO_NhaPP;
import DTO.DTO_Nhanvien;
import DTO.DTO_Phieunhap;

import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

public class NhanVienForm extends JFrame {

	public JPanel contentPane;
	public JTextField textField_maNV;
	public JTextField textField_tenNV;
	public JTextField textField_diaChi;
	public JTextField textField_sdt;
	public JTextField textField_soCMND;
	public JScrollPane scrollPane;
	public JTable table_1;
	public JPanel nhanVienPanel;
	public JTextField textField_7;
	public JLabel label_nhanvien;
	public ArrayList<JComponent> listComponent = new ArrayList<>();
	public ArrayList<Point> toaDoBanDau = new ArrayList<Point>();
	public ArrayList<DTO_Nhanvien> test = new ArrayList<>();
	private JComboBox<String> comboBox_maCV;
	private JRadioButton radiobutton_nam;
	private JRadioButton radiobutton_nu;
	private ButtonGroup buttonGroup_GT;
	private JDateChooser dateChooser;
	public int count = 0;
	public int checkClicked = -1; // nguoi dung chua an nut nao
	private JComboBox cbGioiTinh;
	private JComboBox cbChucVu;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblMChcV;
	BUS_Nhanvien busnv = new BUS_Nhanvien();
	BUS_Chucvu buscv = new BUS_Chucvu();
	private JRadioButton rdbtnNu;
	private AbstractButton rdbtnNam;
	public boolean cmndExists = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienForm frame = new NhanVienForm();
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
	public NhanVienForm() {
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
		
		nhanVienPanel = new JPanel();
		nhanVienPanel.setBackground(new Color(192, 192, 192));
		contentPane.add(nhanVienPanel, BorderLayout.CENTER);
		GridBagLayout gbl_nhanVienPanel = new GridBagLayout();
		gbl_nhanVienPanel.columnWidths = new int[]{0, 114, 250, 34, 147, 90, 141, -51, 0};
		gbl_nhanVienPanel.rowHeights = new int[]{80, 51, 50, 46, 44, 0, 30, 42, 0, 127, 0, 0, 130, 0, 0};
		gbl_nhanVienPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_nhanVienPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		nhanVienPanel.setLayout(gbl_nhanVienPanel);
		
		JLabel label_nhanvien = new JLabel("QUẢN LÝ NHÂN VIÊN");
		label_nhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		label_nhanvien.setFont(new Font("Arial", Font.BOLD, 24));
		GridBagConstraints gbc_label_nhanvien = new GridBagConstraints();
		gbc_label_nhanvien.insets = new Insets(0, 0, 5, 0);
		gbc_label_nhanvien.gridwidth = 8;
		gbc_label_nhanvien.gridx = 0;
		gbc_label_nhanvien.gridy = 0;
		nhanVienPanel.add(label_nhanvien, gbc_label_nhanvien);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		nhanVienPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_maNV = new JTextField();
		textField_maNV.setColumns(10);
		GridBagConstraints gbc_textField_maNV = new GridBagConstraints();
		gbc_textField_maNV.insets = new Insets(0, 0, 5, 5);
		gbc_textField_maNV.fill = GridBagConstraints.BOTH;
		gbc_textField_maNV.gridx = 2;
		gbc_textField_maNV.gridy = 1;
		nhanVienPanel.add(textField_maNV, gbc_textField_maNV);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giới tính");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 4;
		gbc_lblNewLabel_1_2.gridy = 1;
		nhanVienPanel.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		radiobutton_nam = new JRadioButton("Nam");
		radiobutton_nam.setFont(new Font("Arial", Font.BOLD, 14));
		radiobutton_nam.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_rdbtnNam = new GridBagConstraints();
		gbc_rdbtnNam.fill = GridBagConstraints.VERTICAL;
		gbc_rdbtnNam.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNam.gridx = 5;
		gbc_rdbtnNam.gridy = 1;
		nhanVienPanel.add(radiobutton_nam, gbc_rdbtnNam);
		
		radiobutton_nu = new JRadioButton("Nữ");
		radiobutton_nu.setFont(new Font("Arial", Font.BOLD, 14));
		radiobutton_nu.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_rdbtnNu = new GridBagConstraints();
		gbc_rdbtnNu.fill = GridBagConstraints.VERTICAL;
		gbc_rdbtnNu.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNu.gridx = 6;
		gbc_rdbtnNu.gridy = 1;
		nhanVienPanel.add(radiobutton_nu, gbc_rdbtnNu);
		
		buttonGroup_GT = new ButtonGroup();
		buttonGroup_GT.add(radiobutton_nam);
		buttonGroup_GT.add(radiobutton_nu);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 2;
		nhanVienPanel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		textField_tenNV = new JTextField();
		textField_tenNV.setColumns(10);
		GridBagConstraints gbc_textField_tenNV = new GridBagConstraints();
		gbc_textField_tenNV.insets = new Insets(0, 0, 5, 5);
		gbc_textField_tenNV.fill = GridBagConstraints.BOTH;
		gbc_textField_tenNV.gridx = 2;
		gbc_textField_tenNV.gridy = 2;
		nhanVienPanel.add(textField_tenNV, gbc_textField_tenNV);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ngày sinh");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3.gridx = 4;
		gbc_lblNewLabel_1_3.gridy = 2;
		nhanVienPanel.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 2;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 5;
		gbc_dateChooser.gridy = 2;
		nhanVienPanel.add(dateChooser, gbc_dateChooser);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1.gridy = 3;
		nhanVienPanel.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		textField_diaChi = new JTextField();
		textField_diaChi.setColumns(10);
		GridBagConstraints gbc_textField_diaChi = new GridBagConstraints();
		gbc_textField_diaChi.insets = new Insets(0, 0, 5, 5);
		gbc_textField_diaChi.fill = GridBagConstraints.BOTH;
		gbc_textField_diaChi.gridx = 2;
		gbc_textField_diaChi.gridy = 3;
		nhanVienPanel.add(textField_diaChi, gbc_textField_diaChi);
		
		JLabel lblNewLabel_1_4 = new JLabel("Số CMND");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_4 = new GridBagConstraints();
		gbc_lblNewLabel_1_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_4.gridx = 4;
		gbc_lblNewLabel_1_4.gridy = 3;
		nhanVienPanel.add(lblNewLabel_1_4, gbc_lblNewLabel_1_4);
		
		textField_soCMND = new JTextField();
		textField_soCMND.setColumns(10);
		GridBagConstraints gbc_textField_soCMND = new GridBagConstraints();
		gbc_textField_soCMND.gridwidth = 2;
		gbc_textField_soCMND.insets = new Insets(0, 0, 5, 5);
		gbc_textField_soCMND.fill = GridBagConstraints.BOTH;
		gbc_textField_soCMND.gridx = 5;
		gbc_textField_soCMND.gridy = 3;
		nhanVienPanel.add(textField_soCMND, gbc_textField_soCMND);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("SĐT");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1_1.gridy = 4;
		nhanVienPanel.add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);
		
		textField_sdt = new JTextField();
		textField_sdt.setColumns(10);
		GridBagConstraints gbc_textField_sdt = new GridBagConstraints();
		gbc_textField_sdt.insets = new Insets(0, 0, 5, 5);
		gbc_textField_sdt.fill = GridBagConstraints.BOTH;
		gbc_textField_sdt.gridx = 2;
		gbc_textField_sdt.gridy = 4;
		nhanVienPanel.add(textField_sdt, gbc_textField_sdt);
		
		JLabel lblNewLabel_1_5 = new JLabel("Mã chức vụ");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1_5 = new GridBagConstraints();
		gbc_lblNewLabel_1_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_5.gridx = 4;
		gbc_lblNewLabel_1_5.gridy = 4;
		nhanVienPanel.add(lblNewLabel_1_5, gbc_lblNewLabel_1_5);
		
		comboBox_maCV = new JComboBox();
		BUS_Chucvu buscv = new BUS_Chucvu();
		for (DTO_Chucvu cv : buscv.getListCV()) {
			comboBox_maCV.addItem(cv.getMa_CV());
		}
		GridBagConstraints gbc_comboBox_maCV = new GridBagConstraints();
		gbc_comboBox_maCV.gridwidth = 2;
		gbc_comboBox_maCV.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_maCV.fill = GridBagConstraints.BOTH;
		gbc_comboBox_maCV.gridx = 5;
		gbc_comboBox_maCV.gridy = 4;
		nhanVienPanel.add(comboBox_maCV, gbc_comboBox_maCV);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã nhân viên", "Tên nhân viên", "Mã chức vụ", "Địa chỉ", "Số điện thoại", "Giới tính", "Ngày sinh", "Số CMND","Trạng thái"
			}
		));
		table_1.setRowHeight(50);
		table_1.setBounds(1, 25, 922, -2);
		table_1.setDefaultEditor(Object.class, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.gridwidth = 8;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 5;
		nhanVienPanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 156, 159, 146, 162, 151, 142, 0, 0};
		gbl_panel_1.rowHeights = new int[]{45, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton_1_1_1_2 = new JButton("Xuất Excel");
		btnNewButton_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportNhanVien.xlsx";
				xuatExcel(busnv.getListNV(), fileName);
			}
		});
		
		JButton btnNewButton_1_1_1_1 = new JButton("Reset");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                xoaForm();
                updateNVFromList();
            }
        });
		
		JButton btnNewButton_1_1_1 = new JButton("Xóa");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        xoaNV();
			    }
			});
		
		JButton btnNewButton_1_1 = new JButton("Sửa");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_1.getSelectedRow();
				if(checkClicked != selectedRow) { // neu chon qua nut khac
					count = 0;
				}
				// neu van o cai dong do
				checkClicked = selectedRow;
				count++;
				
				if(count % 2 == 0) {
					BUS_Nhanvien busnv = new BUS_Nhanvien();
					int index = table_1.getSelectedRow();
					if(index == -1) {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					java.util.Date utilDate = dateChooser.getDate(); // lay ra date trong o input
					Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
					cal.setTime(utilDate); // lay ra thoi gian cua utilDate
					cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
					java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
					java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
					boolean gioiTinh = true;
					if(radiobutton_nam.isSelected()) {
					    gioiTinh = true; 
					} else if(radiobutton_nu.isSelected()) {
					    gioiTinh = false;
					}
					if(checkInput()) {
						busnv.update(textField_maNV.getText()+"", textField_tenNV.getText()+"", comboBox_maCV.getSelectedItem()+"", textField_diaChi.getText()+"", textField_sdt.getText()+"", gioiTinh, sqlDate, textField_soCMND.getText()+"", true);
						updateNVFromList();
					}
				}else {
					suaNV();
				}
			}
		});
		
		JButton btnNewButton_6 = new JButton("Thêm");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput()) {
					themNV();
				}
			}
		});
		btnNewButton_6.setIcon(new ImageIcon(NhanVienForm.class.getResource("/img/add.png")));
		btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_6.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 2;
		gbc_btnNewButton_6.gridy = 0;
		panel_1.add(btnNewButton_6, gbc_btnNewButton_6);
		btnNewButton_1_1.setIcon(new ImageIcon(NhanVienForm.class.getResource("/img/sua.png")));
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_1.gridx = 3;
		gbc_btnNewButton_1_1.gridy = 0;
		panel_1.add(btnNewButton_1_1, gbc_btnNewButton_1_1);
		btnNewButton_1_1_1.setIcon(new ImageIcon(NhanVienForm.class.getResource("/img/delete.png")));
		btnNewButton_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1_1_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_1_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_1_1.gridx = 4;
		gbc_btnNewButton_1_1_1.gridy = 0;
		panel_1.add(btnNewButton_1_1_1, gbc_btnNewButton_1_1_1);
		btnNewButton_1_1_1_1.setIcon(new ImageIcon(NhanVienForm.class.getResource("/img/reload.png")));
		btnNewButton_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1_1_1_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_1_1_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_1_1_1.gridx = 5;
		gbc_btnNewButton_1_1_1_1.gridy = 0;
		panel_1.add(btnNewButton_1_1_1_1, gbc_btnNewButton_1_1_1_1);
		btnNewButton_1_1_1_2.setIcon(new ImageIcon(NhanVienForm.class.getResource("/img/xuat excel.png")));
		btnNewButton_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1_1_1_2.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_1_1_1_2 = new GridBagConstraints();
		gbc_btnNewButton_1_1_1_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_1_1_2.gridx = 6;
		gbc_btnNewButton_1_1_1_2.gridy = 0;
		panel_1.add(btnNewButton_1_1_1_2, gbc_btnNewButton_1_1_1_2);
		
//		JButton btnNewButton_1_1_1_3 = new JButton("Nhập Excel");
//		btnNewButton_1_1_1_3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportNhanVien.xlsx";
//				importExcel(fileName);
//			}
//		});
//		btnNewButton_1_1_1_3.setIcon(new ImageIcon(NhanVienForm.class.getResource("/img/nhap excel.png")));
//		btnNewButton_1_1_1_3.setFont(new Font("Arial", Font.BOLD, 14));
//		btnNewButton_1_1_1_3.setBackground(new Color(226, 221, 221));
//		GridBagConstraints gbc_btnNewButton_1_1_1_3 = new GridBagConstraints();
//		gbc_btnNewButton_1_1_1_3.fill = GridBagConstraints.BOTH;
//		gbc_btnNewButton_1_1_1_3.insets = new Insets(0, 0, 5, 5);
//		gbc_btnNewButton_1_1_1_3.gridx = 6;
//		gbc_btnNewButton_1_1_1_3.gridy = 0;
//		panel_1.add(btnNewButton_1_1_1_3, gbc_btnNewButton_1_1_1_3);
		
		JLabel lblNewLabel_9 = new JLabel("Tìm kiếm: ");
		lblNewLabel_9.setToolTipText("Tìm kiếm");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_9.setBackground(new Color(128, 0, 64));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 7;
		nhanVienPanel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 7;
		nhanVienPanel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{149, 141, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Giới tính");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Mã chức vụ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		cbGioiTinh = new JComboBox();
		cbGioiTinh.addItem("Tất cả");
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		panel_2.add(cbGioiTinh, gbc_comboBox);
		
		cbChucVu = new JComboBox();
		cbChucVu.addItem("Tất cả");
		for (DTO_Chucvu cv : buscv.getListCV()) {
			cbChucVu.addItem(cv.getMa_CV());
		}
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		panel_2.add(cbChucVu, gbc_comboBox_1);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 String searchText = textField_7.getText().trim();
			        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
			        table_1.setRowSorter(sorter);
			        
			        // ?i: khong quan tam chu thuong hay chu hoa
			        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText)); // áp dụng filter với regular expression
			}
		});
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridwidth = 2;
		gbc_textField_7.fill = GridBagConstraints.BOTH;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.gridx = 4;
		gbc_textField_7.gridy = 7;
		nhanVienPanel.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_4_1 = new JButton("Tìm");
		btnNewButton_4_1.setIcon(new ImageIcon(NhanVienForm.class.getResource("/img/search.png")));
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		GridBagConstraints gbc_btnNewButton_4_1 = new GridBagConstraints();
		gbc_btnNewButton_4_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4_1.gridx = 6;
		gbc_btnNewButton_4_1.gridy = 7;
		nhanVienPanel.add(btnNewButton_4_1, gbc_btnNewButton_4_1);
		btnNewButton_4_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_4_1.setBackground(new Color(226, 221, 221));
		nhanVienPanel.add(table_1);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setEnabled(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.gridwidth = 8;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 9;
		nhanVienPanel.add(scrollPane, gbc_scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(265,500));
		contentPane.add(panel_3, BorderLayout.WEST);
		
		Color customColor = new Color(226, 221, 221);
	
		updateNVFromList();
		showMaNVNext();
	}
	public  void updatePanelSize() {
	    int newWidth = getWidth() - 245;
	    nhanVienPanel.setBounds(245, 54, newWidth, nhanVienPanel.getHeight());
	    label_nhanvien.setBounds((newWidth - label_nhanvien.getWidth()) / 2, label_nhanvien.getY(), label_nhanvien.getWidth(), label_nhanvien.getHeight()); // Cập nhật vị trí của label
	}
	
	public JPanel getNhanVienJPanel() {
		return nhanVienPanel;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean checkInput() {
		if(this.textField_tenNV.equals("") || this.textField_diaChi.equals("") || this.textField_sdt.equals("")|| (buttonGroup_GT.getSelection() == null)|| this.textField_soCMND.equals("") || this.comboBox_maCV.getSelectedIndex() == -1 || this.dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}
		String sdt = this.textField_sdt.getText()+"";
		String cmnd = this.textField_soCMND.getText()+"";
		if(sdt.charAt(0) != '0') {
			JOptionPane.showMessageDialog(null, "Số điện thoại phải bắt đầu từ số 0");
			return false;
		}else if(sdt.length() > 10) {
			JOptionPane.showMessageDialog(null, "Điện thoại chỉ có 10 số thôi");
			return false;
		}
		if(cmnd.length() > 10) {
			JOptionPane.showMessageDialog(null, "Số CMND chỉ có 10 số thôi");
			return false;
		}
		for (DTO_Nhanvien nv : busnv.getListNV()) {
			if(this.textField_sdt.getText().equals(nv.getSDT())) {
				JOptionPane.showMessageDialog(null, "Số điện thoại này đã được đăng ký rồi");
				return false;
			}
		}
		
		for (DTO_Nhanvien nv : busnv.getListNV()) {
			if(this.textField_soCMND.getText().equals(nv.getSoCMND())) {
				JOptionPane.showMessageDialog(null, "Số CMND này đã được đăng ký rồi");
				return false;
			}else if(this.textField_tenNV.getText().equals(nv.getTenNV())) {
				JOptionPane.showMessageDialog(null, "Nhân viên đã có trong danh sách!!");
				return false;
			}
		}
		
		// kiem tra nhan vien co du tuoi de di lam hay chua
		Calendar ngaySinhInput = Calendar.getInstance();
		ngaySinhInput.setTime(this.dateChooser.getDate());
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - ngaySinhInput.get(Calendar.YEAR);
		if(today.get(Calendar.MONTH) < ngaySinhInput.get(Calendar.MONTH)) {
			age--;
		}else if(today.get(Calendar.MONTH) == ngaySinhInput.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < ngaySinhInput.get(Calendar.DAY_OF_MONTH)) {
			age--;
		}
		if(age < 18) {
			JOptionPane.showMessageDialog(null, "Nhân viên này chưa đủ 18 tuổi");
			return false;
		}
		return true;
	}
	
	public void showMaNVNext() {
		BUS_Nhanvien busnv = new BUS_Nhanvien();
		textField_maNV.setEditable(false);
		textField_maNV.setText(busnv.getMaNVNext()+"");
	}
	
	public void themNVVaoTable(DTO_Nhanvien nv) {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.addRow(new Object[]{nv.getMaNV()+"",nv.getTenNV()+"",nv.getMaCV()+"",nv.getDiaChi()+"",nv.getSDT()+"",(nv.isGioiTinh()?"Nam":"Nữ"),nv.getNgaySinh()+"",nv.getSoCMND()+"",true});
		updateNVFromList();
		xoaForm();
	}
	
	public void updateNVFromList() {
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.setRowCount(0);

	    BUS_Nhanvien busnv = new BUS_Nhanvien();

	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    

	    for (DTO_Nhanvien nv : busnv.getListNV()) {
			 java.util.Date utilDate = nv.getNgaySinh(); // lay ra date trong o input
			 Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
			 cal.setTime(utilDate); // lay ra thoi gian cua utilDate
			 cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
			 java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
			 java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
	    	String text = null;
	        if (nv.isCheck_exist()) {
	        	text = "<html><font color='green' style='font-weight:bold;'>Tồn tại</font></html>";
	        } else {
	            text = "<html><font color='red' style='font-weight: bold;'>Đã xóa</font></html>";
	        }
//	       if(cv.isCheck_exist()) {
//	    	   model_table.addRow(new Object[] {nv.getMaNV()+"",nv.getTenNV()+"",nv.getMaCV()+"",nv.getDiaChi()+"",nv.getSDT()+"",(nv.isGioiTinh()?"Nam":"Nữ"),nv.getNgaySinh()+"",nv.getSoCMND()+"",text});
//	       }
	       model_table.addRow(new Object[] {nv.getMaNV()+"",nv.getTenNV()+"",nv.getMaCV()+"",nv.getDiaChi()+"",nv.getSDT()+"",(nv.isGioiTinh()?"Nam":"Nữ"),nv.getNgaySinh()+"",nv.getSoCMND()+"",text});
	    }
	    xoaForm();
	    int index = 1;
		for (DTO_Nhanvien ldt : busnv.getListNV()) {
			test.add(ldt);
			index++;
		}
	}


	
	public void xoaForm() {
		textField_tenNV.setText("");
		comboBox_maCV.setSelectedIndex(-1);
		textField_diaChi.setText("");
		textField_sdt.setText("");
		buttonGroup_GT.clearSelection();
		textField_sdt.setText("");
		textField_soCMND.setText("");
		dateChooser.setDate(null);
		showMaNVNext();
	}
	
	public void themNV() {
		 BUS_Nhanvien busnv = new BUS_Nhanvien();
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 String text = df.format(this.dateChooser.getDate());
		 java.util.Date ngaySinh = null;
		 try {
		     ngaySinh = (java.util.Date) df.parse(text);
		 } catch (ParseException e) {
		     e.printStackTrace();
		 }

		 java.sql.Date ngaySinhSQL = new java.sql.Date(ngaySinh.getTime());
		 Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
			cal.setTime(ngaySinhSQL); // lay ra thoi gian cua utilDate
			cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
			java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
			java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
		Boolean gioiTinh = true;
		if(this.radiobutton_nam.isSelected()) {
			gioiTinh = true;
		}else if(this.radiobutton_nu.isSelected()){
			gioiTinh = false;
		}
		 boolean result = busnv.addnvToTable(this.textField_maNV.getText()+"", this.textField_tenNV.getText()+"", this.comboBox_maCV.getSelectedItem()+"", this.textField_diaChi.getText()+"",this.textField_sdt.getText()+"",gioiTinh,sqlDate,this.textField_soCMND.getText()+"",true);
		 if (result) {
		        themNVVaoTable(busnv.getListNV().get(busnv.getListNV().size() - 1));
		    }else {
		    	JOptionPane.showMessageDialog(null, "Thêm thất bại");
		    }
		    xoaForm();
	}

	public DTO_Nhanvien getNV() {
		DefaultTableModel model_NV = (DefaultTableModel) table_1.getModel();
		int index = table_1.getSelectedRow();
		int modelIndex = table_1.convertRowIndexToModel(index);
		String maNV = (String) model_NV.getValueAt(modelIndex, 0);
		String tenNV = (String) model_NV.getValueAt(modelIndex, 1);
		String maCV = (String) model_NV.getValueAt(modelIndex, 2);
		String diaChi = (String) model_NV.getValueAt(modelIndex, 3);
		String sdt = (String) model_NV.getValueAt(modelIndex, 4).toString();
		String GT = (String) model_NV.getValueAt(modelIndex, 5);
		boolean gioiTinh = false;
		if(GT.equals("Nam")) {
			gioiTinh = true;
			radiobutton_nam.setSelected(true);
		}else if(GT.equals("Nữ")){
			gioiTinh = false;
			radiobutton_nu.setSelected(true);
		}
		
//		String ngaySinh = ((java.sql.Date)model_NV.getValueAt(modelIndex, 6)).toString();
		String ngaySinhStr = (String) model_NV.getValueAt(modelIndex, 6);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsedDate = null;
		try {
		    parsedDate = dateFormat.parse(ngaySinhStr);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		java.sql.Date ngaySinh = new java.sql.Date(parsedDate.getTime());
		
	    String CMND = (String) model_NV.getValueAt(index, 7);
	    
	    DTO_Nhanvien nv = new DTO_Nhanvien(maNV, tenNV, maCV, diaChi, sdt, gioiTinh, ngaySinh, CMND, true);
	    return nv;
	}
	
	public void suaNV() {
		int index = table_1.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa");
		}else {
			DTO_Nhanvien nv = getNV();
			this.textField_maNV.setText(nv.getMaNV()+"");
			this.textField_tenNV.setText(nv.getTenNV()+"");
			this.comboBox_maCV.setSelectedItem(nv.getMaCV()+"");	
			this.textField_sdt.setText(nv.getSDT()+"");
			if(nv.isGioiTinh()) {
				this.radiobutton_nam.setSelected(true);
			}else {
				this.radiobutton_nu.setSelected(true);
			}
			this.dateChooser.setDate(nv.getNgaySinh());
			this.textField_soCMND.setText(nv.getSoCMND()+"");
			this.textField_diaChi.setText(nv.getDiaChi()+"");
		}
	}
	
	public void xoaNV() {
	    BUS_Nhanvien busnv = new BUS_Nhanvien();
	    int index = table_1.getSelectedRow(); // lay ra dong ma nguoi dung chon
	    if (index == -1) {
	        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
	    } else {
	        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này?");
	        if (luaChon == JOptionPane.YES_OPTION) {
	            DTO_Nhanvien nv = getNV();
	            boolean check = busnv.delete(nv.getMaNV());
	            if (check) {
//	                model_table.removeRow(index);
	            	nv.setCheck_exist(false);
//	            	System.out.println(dt);
	                updateNVFromList();
	            }
	            xoaForm();
	        }
	    }
	}
	
	
	public void xuatExcel(ArrayList<DTO_Nhanvien> dsNV, String fileName) {
	    try {
	        // Tạo workbook mới
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // Tạo sheet mới trong workbook
	        Sheet sheet = workbook.createSheet("Sheet1");
	        
	        // Tạo header row với tên cột
	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Mã nhân viên");
	        headerRow.createCell(1).setCellValue("Tên nhân viên");
	        headerRow.createCell(2).setCellValue("Mã chức vụ");
	        headerRow.createCell(3).setCellValue("Địa chỉ");
	        headerRow.createCell(4).setCellValue("SDT");
	        headerRow.createCell(5).setCellValue("Giới tính");
	        headerRow.createCell(6).setCellValue("Ngày sinh");
	        headerRow.createCell(7).setCellValue("CMND");
	        headerRow.createCell(8).setCellValue("Trạng thái");
	        
	        // Duyệt qua danh sách điện thoại và tạo các row và cell tương ứng trên sheet
	        int rowIndex = 1;
	        for (DTO_Nhanvien nv : dsNV) {
	            Row row = sheet.createRow(rowIndex++);
	            row.createCell(0).setCellValue(nv.getMaNV());
	            row.createCell(1).setCellValue(nv.getTenNV());
	            row.createCell(2).setCellValue(nv.getMaCV());
	            row.createCell(3).setCellValue(nv.getDiaChi());
	            row.createCell(4).setCellValue(nv.getSDT());
	            row.createCell(5).setCellValue(nv.isGioiTinh() ? "Nam" : "Nữ");
	            Cell dateOfBirthCell = row.createCell(6);
	            if (nv.getNgaySinh() != null) {
	                java.util.Date dateOfBirth = nv.getNgaySinh();
	                dateOfBirthCell.setCellValue(new java.text.SimpleDateFormat("dd/MM/yyyy").format(dateOfBirth));
	            } else {
	                dateOfBirthCell.setCellValue("");
	            }
	            row.createCell(7).setCellValue(nv.getSoCMND());
	            row.createCell(8).setCellValue(nv.isCheck_exist());
	        }
	        
	        // Ghi workbook ra file
	        FileOutputStream out = new FileOutputStream(fileName);
	        workbook.write(out);
	        out.close();
	        JOptionPane.showMessageDialog(this, "Export excel thành công");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }
	
	@SuppressWarnings("unlikely-arg-type")
	public void importExcel(String filePath) {
		 DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		    int count = 0;
		    for(int i = 1 ; i <= busnv.getListNV().size() ; i++) {
		    	count++;
		    }
		    try {
		        Workbook workbook = null;
		        try {
		            workbook = new XSSFWorkbook(new File(filePath));
		        } catch (InvalidFormatException e) {
		            e.printStackTrace();
		        }
		        Sheet sheet = workbook.getSheetAt(0);
		        int row1 = 0;
		        for (Row row : sheet) {
		            if (row1 == 0) { // bỏ qua dòng đầu tiên
		                row1++;
		                continue;
		            }
		            Object[] rowData = new Object[9];
		            int columnCount = 0;
		            for (Cell cell : row) {
		            	if (cell.getCellType() == CellType.BOOLEAN) {
		                    rowData[columnCount] = cell.getBooleanCellValue();
		                } else if(cell.getCellType() == CellType.NUMERIC){
		                    rowData[columnCount] = cell.getDateCellValue();
		                }else {
		                	rowData[columnCount] = cell.getStringCellValue();
		                }
		                columnCount++;
		            }
		            if (count < sheet.getLastRowNum()) {
		                int rowCount = table_1.getRowCount();
		                String lastMaNV = (String) table_1.getValueAt(rowCount - 1, 0);

		                int lastRowNum = sheet.getLastRowNum();

		                // Lấy đối tượng Row của dòng cuối cùng
		                Row lastRow = sheet.getRow(lastRowNum);

		                // Lấy giá trị của ô chứa mã NV trong dòng cuối cùng
		                Cell maNVCell = lastRow.getCell(0);
		                Cell tenNVCell = lastRow.getCell(1);
		                Cell maCVCell = lastRow.getCell(2);
		                Cell sdtCell = lastRow.getCell(4);
		                Cell diaChiCell = lastRow.getCell(3);
		                Cell gtCell = lastRow.getCell(5);
		                Cell ngaySinhCell = lastRow.getCell(6);	
		                Cell cmndCell = lastRow.getCell(7);
		                String cmnd = cmndCell.toString();
		                String sdt = sdtCell.toString();
		                String maNV = maNVCell.getStringCellValue();
	            	  if (Integer.parseInt(maNV.substring(2)) - Integer.parseInt(lastMaNV.substring(2)) == 1) {
	                    boolean foundCV = false;
	                    for (DTO_Chucvu cv : buscv.getListCV()) {
	                        if (maCVCell.toString().trim().equals(cv.getMa_CV().trim())) {
	                            foundCV = true;
	                            break;
	                        }
	                    }
	                    if (foundCV) {
	                        if (gtCell.toString().trim().equals("Nam") || gtCell.toString().trim().equals("Nữ")) {
	                            if( KTsdt(sdt) == true) {
	                            	if(KTcmnd(cmnd)== true) {
    								for(int i = count + 1 ; i <= sheet.getLastRowNum() ; i++) {
    				            		XSSFRow excelRow = (XSSFRow) sheet.getRow(i);
    				            		XSSFCell ex_maNV = excelRow.getCell(0);
    				            		XSSFCell ex_tenNV = excelRow.getCell(1);
    				            		XSSFCell ex_maCV = excelRow.getCell(2);
    				            		XSSFCell ex_diaChi = excelRow.getCell(3);
    				            		XSSFCell ex_SDT = excelRow.getCell(4);
    				            		XSSFCell ex_gioiTinh = excelRow.getCell(5);
    				            		XSSFCell ex_ngaySinh = excelRow.getCell(6);
    				            		XSSFCell ex_CMND = excelRow.getCell(7);
    				            		XSSFCell ex_trangThai = excelRow.getCell(8);
    				            		boolean trangThai = ex_trangThai.getBooleanCellValue();
    				            		boolean gioiTinh = true;
    				            		if(ex_gioiTinh.getStringCellValue().equalsIgnoreCase("Nam")) {
    				            		    gioiTinh = true;
    				            		}else {
    				            		    gioiTinh = false;
    				            		}
    				            		String ngaySinhStr = ex_ngaySinh.getStringCellValue();
    				            		SimpleDateFormat excelDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    				            		java.util.Date ngaySinhUtilDate = null;
    				            		try {
    				            		    ngaySinhUtilDate = excelDateFormat.parse(ngaySinhStr);
    				            		} catch (ParseException e) {
    				            		    e.printStackTrace();
    				            		}

    				            		SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    				            		String ngaySinhSqlString = sqlDateFormat.format(ngaySinhUtilDate);
    				            		java.sql.Date ngaySinhSqlDate = java.sql.Date.valueOf(ngaySinhSqlString);
    				            		Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
    									cal.setTime(ngaySinhSqlDate); // lay ra thoi gian cua utilDate
    									cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
    									java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
    									java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
    									boolean check = busnv.addnvToTable(ex_maNV.toString(), ex_tenNV.toString(), ex_maCV.toString(), ex_diaChi.toString(), ex_SDT.toString(),gioiTinh,sqlDate, ex_CMND.toString(),trangThai);
    				            		if(check) {
    				            			themNVVaoTable(busnv.getListNV().get(busnv.getListNV().size() - 1));
    				            			
    				            		}return;
    				            
	                            }
	                            	}else {
	                            		JOptionPane.showMessageDialog(null, "CMND truyền vào phải là kiểu số");
	    	                            return;
	                            	}
	                            }else {
	                            JOptionPane.showMessageDialog(null, "Số điện thoại truyền vào phải là kiểu số");
	                            return;
	                            }
		                }
	                        JOptionPane.showMessageDialog(null, "Dữ liệu giới tính truyền vào phải là nam hoặc nữ");
	                        return;
		            }
	                    JOptionPane.showMessageDialog(null, "Dữ liệu mã chức vụ truyền vào không hợp lý");
	                    return;
	            	  }
	            	  JOptionPane.showMessageDialog(null, "Dữ liệu mã nhân viên truyền vào không hợp lý");
	            	  return;
	            		
	            	
	            }else if(count == sheet.getLastRowNum()) {
	            	DTO_Nhanvien[] nvArray = new DTO_Nhanvien[sheet.getLastRowNum() + 1];
	            	for(int i = 1 ; i <= sheet.getLastRowNum()-1 ; i++) {
	            		XSSFRow excelRow = (XSSFRow) sheet.getRow(i);
	            		XSSFCell ex_maNV = excelRow.getCell(0);
	            		XSSFCell ex_tenNV = excelRow.getCell(1);
	            		XSSFCell ex_maCV = excelRow.getCell(2);
	            		XSSFCell ex_diaChi = excelRow.getCell(3);
	            		XSSFCell ex_SDT = excelRow.getCell(4);
	            		XSSFCell ex_gioiTinh = excelRow.getCell(5);
	            		XSSFCell ex_ngaySinh = excelRow.getCell(6);
	            		XSSFCell ex_CMND = excelRow.getCell(7);
	            		XSSFCell ex_trangThai = excelRow.getCell(8);
	            		boolean trangThai = ex_trangThai.getBooleanCellValue();
	            		boolean gioiTinh = true;
	            		if(ex_gioiTinh.getStringCellValue().equalsIgnoreCase("Nam")) {
	            		    gioiTinh = true;
	            		}else {
	            		    gioiTinh = false;
	            		}
	            		String ngaySinhStr = ex_ngaySinh.getStringCellValue();
	            		SimpleDateFormat excelDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	            		java.util.Date ngaySinhUtilDate = null;
	            		try {
	            		    ngaySinhUtilDate = excelDateFormat.parse(ngaySinhStr);
	            		} catch (ParseException e) {
	            		    e.printStackTrace();
	            		}

	            		SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            		String ngaySinhSqlString = sqlDateFormat.format(ngaySinhUtilDate);
	            		java.sql.Date ngaySinhSqlDate = java.sql.Date.valueOf(ngaySinhSqlString);
	            		Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
						cal.setTime(ngaySinhSqlDate); // lay ra thoi gian cua utilDate
						cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
						java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
						java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date

	            	    DTO_Nhanvien nv = new DTO_Nhanvien(ex_maNV.toString(), ex_tenNV.toString(), ex_maCV.toString(), ex_diaChi.toString(), ex_SDT.toString(),gioiTinh,sqlDate, ex_CMND.toString(),trangThai);
	            	    nvArray[i] = nv; // nvArray[i]: nhan vien trong excel
	            	    if(!nvArray[i].equals(busnv.getListNV().get(i))) {
	            	        busnv.update(ex_maNV.toString(), ex_tenNV.toString(), ex_maCV.toString(), ex_diaChi.toString(), ex_SDT.toString(),gioiTinh,sqlDate, ex_CMND.toString(),trangThai);
	            	    }
	            	}
	            }
	            model_table.addRow(rowData);
	            updateNVFromList();
	        }
	        workbook.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // Đặt kích thước cột
	    table_1.getColumnModel().getColumn(0).setPreferredWidth(200);
	    table_1.getColumnModel().getColumn(1).setPreferredWidth(300);
	    table_1.getColumnModel().getColumn(2).setPreferredWidth(200);
	    table_1.getColumnModel().getColumn(3).setPreferredWidth(150);
	    table_1.getColumnModel().getColumn(4).setPreferredWidth(300);
	    table_1.getColumnModel().getColumn(5).setPreferredWidth(300);
	    table_1.getColumnModel().getColumn(6).setPreferredWidth(300);
	    table_1.getColumnModel().getColumn(7).setPreferredWidth(350);
	    table_1.getColumnModel().getColumn(8).setPreferredWidth(250);
	    JOptionPane.showMessageDialog(null, "Import từ excel thành công");
	}
	public boolean KT(String str) {
		try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	public boolean KTsdt(String sdt) {
		try {
			int sdtReal = Integer.parseInt(sdt);
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Day khong phai sdt");
			return false;
		}
		if(sdt.charAt(0) != '0') {
			JOptionPane.showMessageDialog(null, "Số điện thoại phải bắt đầu từ số 0");
			return false;
		}else if(sdt.length() > 10) {
			JOptionPane.showMessageDialog(null, "Điện thoại chỉ có 10 số thôi");
			return false;
		}
		for (DTO_Nhanvien nv : busnv.getListNV()) {
			if(this.textField_sdt.getText().equals(nv.getSDT())) {
				JOptionPane.showMessageDialog(null, "Số điện thoại này đã được đăng ký rồi");
				return false;
			}
		}
		return true;
	}
	public boolean KTcmnd (String cmnd) {
		updateNVFromList();
		try {
			int cmndReal = Integer.parseInt(cmnd);
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Day khong phai cmnd");
			return false;
		}
		if(cmnd.length() > 10) {
			JOptionPane.showMessageDialog(null, "Số CMND chỉ có 10 số thôi");
			return false;
		}
		int index = 0;
		for (DTO_Nhanvien nv : test) {
			if(cmnd.equals(nv.getSoCMND())) {
				JOptionPane.showMessageDialog(null, "Số CMND này đã được đăng ký rồi");
				return false;
			}
			index++;
		}
		return true;
		
	}
	
	public void search() {
		BUS_Nhanvien busnv = new BUS_Nhanvien();
		String gioiTinh = this.cbGioiTinh.getSelectedItem()+"";
		String maCV = this.cbChucVu.getSelectedItem()+"";
		ArrayList<DTO_Nhanvien> listNhanvien = busnv.searchNhanVien(gioiTinh, maCV);
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0);
				// Thêm dòng tương ứng vào model cho mỗi nhân viên phù hợp
				for (DTO_Nhanvien nv : listNhanvien) {
					String text = null;
			        if (nv.isCheck_exist()) {
			        	text = "<html><font color='green' style='font-weight:bold;'>Tồn tại</font></html>";
			        } else {
			            text = "<html><font color='red' style='font-weight: bold;'>Đã xóa</font></html>";
			        }
			        model.addRow(new Object[] {nv.getMaNV()+"",nv.getTenNV()+"",nv.getMaCV()+"",nv.getDiaChi()+"",nv.getSDT()+"",(nv.isGioiTinh()?"Nam":"Nữ"),nv.getNgaySinh()+"",nv.getSoCMND()+"",text});
				}

				// Thiết lập model cho table_1
				table_1.setModel(model);
	}
	
}
