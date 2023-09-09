package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.BUS_Dienthoai;
import BUS.BUS_Hoadon;
import BUS.BUS_LoaiDT;
import BUS.BUS_PhieuBH;
import DAL.DAL_Dienthoai;
import DAL.DB_Connect;
import DTO.DTO_Dienthoai;
import DTO.DTO_Hoadon;
import DTO.DTO_LoaiDT;
import DTO.DTO_NhaPP;
import DTO.DTO_PhieuBH;
import DTO.DTO_Phieunhap;
import linhtinh.ImageRender;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;

public class SanPhamForm extends JFrame {
	public JPanel contentPane;
	public JPanel sanPhamPanel;
	public JPanel panel;
	public JLabel label_dienthoai;
	public JTable table_1;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JLabel lblNewLabel_5;
	public JLabel lblNewLabel_7;
	public JTextField textField_maDT;
	public JTextField textField_tenDT;
	public JTextField txtAsdasdasd;
	public JTextField textField_giaTien;
	public JComboBox comboBox_maLoai;
	public JLabel lblNewLabel_6;
	public JLabel lblNewLabel_8;
	public JTextField textField_4;
	public ArrayList<JComponent> listComponent = new ArrayList<>();
	public ArrayList<Point> toaDoBanDau = new ArrayList<Point>();
	public JScrollPane scrollPane_table;
	public JComboBox comboBox_maBH;
	public JTextArea textArea_tinhNang;
	public JLabel jlabel_img;
	public JComponent panel_1;
	public JButton btn_img;
	public int count = 0;
	public int checkClicked = -1; // nguoi dung chua an nut nao
	private boolean isResizing = false;
	private JComboBox comboBox_1;
	private JPanel panel_4;
	private JComboBox comboBox;
	private JLabel lblNewLabel_9;
	private JButton btn_tim;
	private JLabel lblTimKiem;
	private JPanel panel_3;
	private JPanel panel_2;
	private JButton btn_them_5;
	private JPanel panel_5;
	BUS_Dienthoai busdt = new BUS_Dienthoai();
	BUS_LoaiDT busldt = new BUS_LoaiDT();
	BUS_PhieuBH busbh = new BUS_PhieuBH();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanPhamForm frame = new SanPhamForm();
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
	public SanPhamForm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1185, 884);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(0,60));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(265,500));
		contentPane.add(panel_2, BorderLayout.WEST);
		
		sanPhamPanel = new JPanel();
		sanPhamPanel.setBackground(new Color(192, 192, 192));
		contentPane.add(sanPhamPanel, BorderLayout.CENTER);
		GridBagLayout gbl_sanPhamPanel = new GridBagLayout();
		gbl_sanPhamPanel.columnWidths = new int[]{0, 151, 221, 66, 0, 232, 89, -21, 0};
		gbl_sanPhamPanel.rowHeights = new int[]{89, 51, 50, 51, 72, 39, 0, 0, 46, 0, 220, 0, 0, 0, 0};
		gbl_sanPhamPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_sanPhamPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		sanPhamPanel.setLayout(gbl_sanPhamPanel);
		
		label_dienthoai = new JLabel("ĐIỆN THOẠI");
		label_dienthoai.setHorizontalAlignment(SwingConstants.CENTER);
		label_dienthoai.setFont(new Font("Arial", Font.BOLD, 24));
		GridBagConstraints gbc_label_dienthoai = new GridBagConstraints();
		gbc_label_dienthoai.insets = new Insets(0, 0, 5, 0);
		gbc_label_dienthoai.gridwidth = 8;
		gbc_label_dienthoai.gridx = 0;
		gbc_label_dienthoai.gridy = 0;
		sanPhamPanel.add(label_dienthoai, gbc_label_dienthoai);
		
		lblNewLabel = new JLabel("Mã DT:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		sanPhamPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_maDT = new JTextField();
		textField_maDT.setText("DT04");
		textField_maDT.setEditable(false);
		textField_maDT.setColumns(10);
		GridBagConstraints gbc_textField_maDT = new GridBagConstraints();
		gbc_textField_maDT.insets = new Insets(0, 0, 5, 5);
		gbc_textField_maDT.fill = GridBagConstraints.BOTH;
		gbc_textField_maDT.gridx = 2;
		gbc_textField_maDT.gridy = 1;
		sanPhamPanel.add(textField_maDT, gbc_textField_maDT);
		
		lblNewLabel_3 = new JLabel("Tên DT:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 1;
		sanPhamPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_tenDT = new JTextField();
		textField_tenDT.setText("");
		textField_tenDT.setColumns(10);
		GridBagConstraints gbc_textField_tenDT = new GridBagConstraints();
		gbc_textField_tenDT.insets = new Insets(0, 0, 5, 5);
		gbc_textField_tenDT.fill = GridBagConstraints.BOTH;
		gbc_textField_tenDT.gridx = 5;
		gbc_textField_tenDT.gridy = 1;
		sanPhamPanel.add(textField_tenDT, gbc_textField_tenDT);
		
		lblNewLabel_1 = new JLabel("Tên loại:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		sanPhamPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		comboBox_maLoai = new JComboBox();
		comboBox_maLoai.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox_maLoai = new GridBagConstraints();
		gbc_comboBox_maLoai.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_maLoai.fill = GridBagConstraints.BOTH;
		gbc_comboBox_maLoai.gridx = 2;
		gbc_comboBox_maLoai.gridy = 2;
		sanPhamPanel.add(comboBox_maLoai, gbc_comboBox_maLoai);
		
		lblNewLabel_5 = new JLabel("SL:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 2;
		sanPhamPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtAsdasdasd = new JTextField();
		txtAsdasdasd.setEditable(false);
		txtAsdasdasd.setColumns(10);
		GridBagConstraints gbc_txtAsdasdasd = new GridBagConstraints();
		gbc_txtAsdasdasd.insets = new Insets(0, 0, 5, 5);
		gbc_txtAsdasdasd.fill = GridBagConstraints.BOTH;
		gbc_txtAsdasdasd.gridx = 5;
		gbc_txtAsdasdasd.gridy = 2;
		sanPhamPanel.add(txtAsdasdasd, gbc_txtAsdasdasd);
		
		lblNewLabel_2 = new JLabel("Mã BH:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		sanPhamPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		comboBox_maBH = new JComboBox();
		comboBox_maBH.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox_maBH = new GridBagConstraints();
		gbc_comboBox_maBH.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_maBH.fill = GridBagConstraints.BOTH;
		gbc_comboBox_maBH.gridx = 2;
		gbc_comboBox_maBH.gridy = 3;
		sanPhamPanel.add(comboBox_maBH, gbc_comboBox_maBH);
		
		lblNewLabel_6 = new JLabel("Giá tiền:");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 4;
		gbc_lblNewLabel_6.gridy = 3;
		sanPhamPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_giaTien = new JTextField();
		textField_giaTien.setText("");
		textField_giaTien.setColumns(10);
		GridBagConstraints gbc_textField_giaTien = new GridBagConstraints();
		gbc_textField_giaTien.insets = new Insets(0, 0, 5, 5);
		gbc_textField_giaTien.fill = GridBagConstraints.BOTH;
		gbc_textField_giaTien.gridx = 5;
		gbc_textField_giaTien.gridy = 3;
		sanPhamPanel.add(textField_giaTien, gbc_textField_giaTien);
		
		lblNewLabel_4 = new JLabel("Tính năng:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		sanPhamPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textArea_tinhNang = new JTextArea();
		textArea_tinhNang.setText("");
		GridBagConstraints gbc_textArea_tinhNang = new GridBagConstraints();
		gbc_textArea_tinhNang.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_tinhNang.fill = GridBagConstraints.BOTH;
		gbc_textArea_tinhNang.gridx = 2;
		gbc_textArea_tinhNang.gridy = 4;
		sanPhamPanel.add(textArea_tinhNang, gbc_textArea_tinhNang);
		
		lblNewLabel_7 = new JLabel("Hình ảnh:");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 4;
		gbc_lblNewLabel_7.gridy = 4;
		sanPhamPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 5;
		gbc_panel_3.gridy = 4;
		sanPhamPanel.add(panel_3, gbc_panel_3);
		
		jlabel_img = new JLabel("");
		jlabel_img.setHorizontalAlignment(SwingConstants.CENTER);
		jlabel_img.setBounds(41, 10, 134, 53);
		panel_3.add(jlabel_img);
		
		JButton btn_img = new JButton("");
		btn_img.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
		                "JPG & GIF Images", "jpg", "gif", "png");
		        file.setFileFilter(filter);
		        int returnVal = file.showOpenDialog(null);
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		        	String filePath = file.getSelectedFile().getAbsolutePath();
		        	ImageIcon imageIcon = new ImageIcon(filePath);
		        	System.out.println(""+filePath);
		        	jlabel_img.setIcon(imageIcon);
		        }
			}
		});
		btn_img.setBackground(new Color(226, 221, 221));
		btn_img.setIcon(new ImageIcon(SanPhamForm.class.getResource("/img/folder.png")));
		GridBagConstraints gbc_btn_img = new GridBagConstraints();
		gbc_btn_img.fill = GridBagConstraints.BOTH;
		gbc_btn_img.insets = new Insets(0, 0, 5, 5);
		gbc_btn_img.gridx = 6;
		gbc_btn_img.gridy = 4;
		sanPhamPanel.add(btn_img, gbc_btn_img);
		
		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 7;
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 5;
		sanPhamPanel.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel_5_1 = new GridBagConstraints();
		gbc_panel_5_1.fill = GridBagConstraints.BOTH;
		gbc_panel_5_1.gridx = 0;
		gbc_panel_5_1.gridy = 0;
		panel_5.add(panel_5_1, gbc_panel_5_1);
		GridBagLayout gbl_panel_5_1 = new GridBagLayout();
		gbl_panel_5_1.columnWidths = new int[]{0, 134, 122, 127, 127, 120, 133, 0, 0};
		gbl_panel_5_1.rowHeights = new int[]{54, 0};
		gbl_panel_5_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5_1.setLayout(gbl_panel_5_1);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput() == true) {
					themDT();
				}
			}
		});
		btnThem.setIcon(new ImageIcon(SanPhamForm.class.getResource("/img/add.png")));
		btnThem.setFont(new Font("Arial", Font.BOLD, 15));
		btnThem.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem = new GridBagConstraints();
		gbc_btnThem.fill = GridBagConstraints.BOTH;
		gbc_btnThem.insets = new Insets(0, 0, 0, 5);
		gbc_btnThem.gridx = 1;
		gbc_btnThem.gridy = 0;
		panel_5_1.add(btnThem, gbc_btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_1.getSelectedRow();
				if(checkClicked != selectedRow) { // neu chon qua nut khac
					count = 0;
				}
				// neu van o cai dong do
				checkClicked = selectedRow;
				count++;
				
				if(count % 2 == 0) {				
					BUS_Dienthoai busdt = new BUS_Dienthoai();
					int index = table_1.getSelectedRow();
					if(index == -1) {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					boolean check = false;
					String cellValue = table_1.getValueAt(selectedRow, 8).toString();
					System.out.println("HIHI: "+cellValue);
					if(cellValue.contains("Đã xóa")) {
						check = false;
					}else {
						check = true;
					}
					if(check == false) {
						JOptionPane.showMessageDialog(null, "Điện thoại đã xóa thì không thể sửa được nữa");
					}else {
						busdt.update(textField_maDT.getText()+"",comboBox_maLoai.getSelectedItem()+"", comboBox_maBH.getSelectedItem()+"", textField_tenDT.getText()+"", textArea_tinhNang.getText()+"", Integer.parseInt(txtAsdasdasd.getText()+""), Integer.parseInt(textField_giaTien.getText()+""), jlabel_img.getIcon().toString(),true);
					}
					
					updateDTFromList();
				}else {
					suaDT();
				}
			}
		});
		btnSua.setIcon(new ImageIcon(SanPhamForm.class.getResource("/img/sua.png")));
		btnSua.setFont(new Font("Arial", Font.BOLD, 15));
		btnSua.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnSua = new GridBagConstraints();
		gbc_btnSua.fill = GridBagConstraints.BOTH;
		gbc_btnSua.insets = new Insets(0, 0, 0, 5);
		gbc_btnSua.gridx = 2;
		gbc_btnSua.gridy = 0;
		panel_5_1.add(btnSua, gbc_btnSua);
		
		JButton btn_them_2_1 = new JButton("Xóa");
		btn_them_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaDT();
				updateDTFromList();
			}
		});
		btn_them_2_1.setIcon(new ImageIcon(SanPhamForm.class.getResource("/img/delete.png")));
		btn_them_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		btn_them_2_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btn_them_2_1 = new GridBagConstraints();
		gbc_btn_them_2_1.fill = GridBagConstraints.BOTH;
		gbc_btn_them_2_1.insets = new Insets(0, 0, 0, 5);
		gbc_btn_them_2_1.gridx = 3;
		gbc_btn_them_2_1.gridy = 0;
		panel_5_1.add(btn_them_2_1, gbc_btn_them_2_1);
		
		JButton btn_them_3_1 = new JButton("Reset");
		btn_them_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaForm();
			}
		});
		btn_them_3_1.setIcon(new ImageIcon(SanPhamForm.class.getResource("/img/reload.png")));
		btn_them_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		btn_them_3_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btn_them_3_1 = new GridBagConstraints();
		gbc_btn_them_3_1.fill = GridBagConstraints.BOTH;
		gbc_btn_them_3_1.insets = new Insets(0, 0, 0, 5);
		gbc_btn_them_3_1.gridx = 4;
		gbc_btn_them_3_1.gridy = 0;
		panel_5_1.add(btn_them_3_1, gbc_btn_them_3_1);
		
		JButton btn_them_4_1 = new JButton("Xuất Excel");
		btn_them_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportDienThoai.xlsx";
				xuatExcel(busdt.getListDT(), fileName);
			}
		});
		btn_them_4_1.setIcon(new ImageIcon(SanPhamForm.class.getResource("/img/xuat excel.png")));
		btn_them_4_1.setFont(new Font("Arial", Font.BOLD, 15));
		btn_them_4_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btn_them_4_1 = new GridBagConstraints();
		gbc_btn_them_4_1.fill = GridBagConstraints.BOTH;
		gbc_btn_them_4_1.insets = new Insets(0, 0, 0, 5);
		gbc_btn_them_4_1.gridx = 5;
		gbc_btn_them_4_1.gridy = 0;
		panel_5_1.add(btn_them_4_1, gbc_btn_them_4_1);
		
		JButton btn_them_5_1 = new JButton("Nhập Excel");
		btn_them_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportDienThoai.xlsx";
				importExcel(fileName);
				updateDTFromList();
			}
		});
		btn_them_5_1.setIcon(new ImageIcon(SanPhamForm.class.getResource("/img/nhap excel.png")));
		btn_them_5_1.setFont(new Font("Arial", Font.BOLD, 15));
		btn_them_5_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btn_them_5_1 = new GridBagConstraints();
		gbc_btn_them_5_1.fill = GridBagConstraints.BOTH;
		gbc_btn_them_5_1.insets = new Insets(0, 0, 0, 5);
		gbc_btn_them_5_1.gridx = 6;
		gbc_btn_them_5_1.gridy = 0;
		panel_5_1.add(btn_them_5_1, gbc_btn_them_5_1);
		
		lblTimKiem = new JLabel("Tìm kiếm: ");
		lblTimKiem.setToolTipText("Tìm kiếm");
		lblTimKiem.setForeground(Color.RED);
		lblTimKiem.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTimKiem.setBackground(new Color(128, 0, 64));
		GridBagConstraints gbc_lblTimKiem = new GridBagConstraints();
		gbc_lblTimKiem.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimKiem.gridx = 1;
		gbc_lblTimKiem.gridy = 7;
		sanPhamPanel.add(lblTimKiem, gbc_lblTimKiem);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 DT", "M\u00E3 lo\u1EA1i", "M\u00E3 BH", "Tính năng", "Tên DT", "SL", "Gi\u00E1 ti\u1EC1n","Hình ảnh","Trạng thái"
			}
		));
		table_1.setRowHeight(50);
		table_1.setBounds(1, 25, 922, -2);
		table_1.setDefaultEditor(Object.class, null);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 2;
		gbc_panel_4.gridheight = 3;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 7;
		sanPhamPanel.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{138, 143, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		lblNewLabel_8 = new JLabel("Giá tiền");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 0;
		panel_4.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Mã loại");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 0;
		panel_4.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		comboBox = new JComboBox();
		comboBox.addItem("Tất cả");
		comboBox.addItem("Dưới 10 triệu");
		comboBox.addItem("Từ 10 triệu đến 20 triệu");
		comboBox.addItem("Trên 20 triệu");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		panel_4.add(comboBox, gbc_comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addItem("Tất cả");
		for (DTO_LoaiDT ldt : busldt.getlistLoaiDT()) {
			comboBox_1.addItem(ldt.getTenLoai());
		}
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		panel_4.add(comboBox_1, gbc_comboBox_1);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 String searchText = textField_4.getText().trim();
			        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
			        table_1.setRowSorter(sorter);
			        
			        // ?i: khong quan tam chu thuong hay chu hoa
			        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText)); // áp dụng filter với regular expression
			}
		});
		textField_4.setText("");
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 5;
		gbc_textField_4.gridy = 7;
		sanPhamPanel.add(textField_4, gbc_textField_4);
		
		btn_them_5 = new JButton("Tìm");
		btn_them_5.setIcon(new ImageIcon(SanPhamForm.class.getResource("/img/search.png")));
		btn_them_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btn_them_5.setFont(new Font("Arial", Font.BOLD, 16));
		btn_them_5.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btn_them_5 = new GridBagConstraints();
		gbc_btn_them_5.fill = GridBagConstraints.BOTH;
		gbc_btn_them_5.insets = new Insets(0, 0, 5, 5);
		gbc_btn_them_5.gridx = 6;
		gbc_btn_them_5.gridy = 7;
		sanPhamPanel.add(btn_them_5, gbc_btn_them_5);
		sanPhamPanel.add(table_1);
		
		scrollPane_table = new JScrollPane(table_1);
		scrollPane_table.setEnabled(false);
		GridBagConstraints gbc_scrollPane_table = new GridBagConstraints();
		gbc_scrollPane_table.gridheight = 4;
		gbc_scrollPane_table.gridwidth = 8;
		gbc_scrollPane_table.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_table.gridx = 0;
		gbc_scrollPane_table.gridy = 10;
		sanPhamPanel.add(scrollPane_table, gbc_scrollPane_table);
		
		Color customColor = new Color(226, 221, 221); // tạo một màu mới
		ImageIcon iconAdd = new ImageIcon("C:\\JAVA\\DoAnJava\\src\\img\\add.png");
		
		ImageIcon iconFix = new ImageIcon("C:\\JAVA\\DoAnJava\\src\\img\\sua.png");
		
		ImageIcon iconDelete = new ImageIcon("C:\\JAVA\\DoAnJava\\src\\img\\delete.png");
		
		ImageIcon iconExcel = new ImageIcon("C:\\JAVA\\DoAnJava\\src\\img\\xuat excel.png");
		
		ImageIcon iconInputExcel = new ImageIcon("C:\\JAVA\\DoAnJava\\src\\img\\nhap excel.png");
		for (DTO_LoaiDT ldt : busldt.getlistLoaiDT()) {
			comboBox_maLoai.addItem(ldt.getTenLoai());
		}
		for (DTO_PhieuBH ph : busbh.getlistPBH()) {
			comboBox_maBH.addItem(ph.getMa_BH());
		}
		ImageIcon iconReload = new ImageIcon("C:\\JAVA\\DoAnJava\\src\\img\\folder.png");
		ImageIcon iconSearch = new ImageIcon("C:\\JAVA\\DoAnJava\\src\\img\\search.png");
		
		for (Component c : listComponent) {
		    toaDoBanDau.add(c.getLocation());
		}
		
		updateDTFromList();
		showMaDTNext();
	}
	
	public JPanel getlistSanPham() {
		return sanPhamPanel;
	}

	
	@SuppressWarnings("unlikely-arg-type")
	public boolean checkInput() {
		if(this.textField_tenDT.equals("") || this.txtAsdasdasd.equals("") || this.textField_giaTien.equals("") || this.comboBox_maLoai.getSelectedIndex() == -1 || this.comboBox_maBH.getSelectedIndex() == -1 || this.textArea_tinhNang.equals("") || this.jlabel_img.getIcon() == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}else{
			try {
				int SL = Integer.parseInt(this.txtAsdasdasd.getText()+"");
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Trường SL phải là kiểu số nguyên");
				return false;
			}
			
			try {
				int gia = Integer.parseInt(this.textField_giaTien.getText()+"");
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Trường giá tiền phải là kiểu số nguyên");
				return false;
			}
		}
		
		for (DTO_Dienthoai dt : busdt.getListDT()) {
			if(this.textField_tenDT.getText().equals(dt.getTenDT())) {
				JOptionPane.showMessageDialog(null, "Tên điện thoại này đã tồn tại trong danh sách");
				break;
			}
		}
		return true;
	}
	
	  private static boolean isValidImageLink(String imageLink) {
	        try {
	            Image image = ImageIO.read(new File(imageLink));
	            return image != null;
	        } catch (IOException e) {
	            return false;
	        }
	    }
	
	public void showMaDTNext() {
		BUS_Dienthoai busdt = new BUS_Dienthoai();
		textField_maDT.setEditable(false);
		textField_maDT.setText(busdt.getMaDTNext()+"");
	}
	
	
	public JPanel getSanPhamPanel() {
	    return sanPhamPanel;
	}
	
	public void themDTVaoTable(DTO_Dienthoai dt) {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.addRow(new Object[]{dt.getMa_DT()+"",dt.getTenLoai()+"",dt.getMaBH()+"",dt.getTinhNang()+"",dt.getTenDT()+"",dt.getSL()+"",dt.getGiaTienFormatted()+"",dt.getImg(),dt.isCheck_exist()});
		table_1.getColumnModel().getColumn(7).setCellRenderer(new ImageRender());
		updateDTFromList();
		xoaForm();
	}
	
	public void updateDTFromList() {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.setRowCount(0);

	    BUS_Dienthoai busDT = new BUS_Dienthoai();

	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);

	    for (DTO_Dienthoai dt : busDT.getListDT()) {
	    	String test = dt.getImg();
	        String text = null;
	        if (dt.isCheck_exist()) {
	        	text = "<html><font color='green' style='font-weight:bold;'>Tồn tại</font></html>";
	        } else {
	            text = "<html><font color='red' style='font-weight: bold;'>Đã xóa</font></html>";
	        }
//	       if(dt.isCheck_exist()) {
//	    	   model_table.addRow(new Object[] { dt.getMa_DT(), dt.getTenLoai() + "", dt.getMaBH() + "", dt.getTinhNang() + "",
//	   	            dt.getTenDT() + "", dt.getSL() + "", dt.getGiaTienFormatted() + "", test, text });
//	       }
	        model_table.addRow(new Object[] { dt.getMa_DT(), dt.getTenLoai() + "", dt.getMaBH() + "", dt.getTinhNang() + "",
	   	            dt.getTenDT() + "", dt.getSL() + "", dt.getGiaTienFormatted() + "", test, text });
	    }
	    table_1.getColumnModel().getColumn(8).setCellRenderer(renderer);
	    table_1.getColumnModel().getColumn(7).setCellRenderer(new ImageRender());
	    xoaForm();
	}


	
	public void xoaForm() {
		textField_tenDT.setText("");
		textArea_tinhNang.setText("");
		txtAsdasdasd.setText("0");
		textField_giaTien.setText("");
		comboBox_maBH.setSelectedIndex(-1);
		comboBox_maLoai.setSelectedIndex(-1);
		jlabel_img.setIcon(null);
		showMaDTNext();
	}
	
	public void themDT() {
		 BUS_Dienthoai busdt = new BUS_Dienthoai();
		 String test = this.jlabel_img.getIcon().toString();
		 boolean result = busdt.addDTToTable(this.textField_maDT.getText()+"",this.comboBox_maLoai.getSelectedItem()+"",this.comboBox_maBH.getSelectedItem()+"",this.textArea_tinhNang.getText()+"",this.textField_tenDT.getText()+"",Integer.valueOf(this.txtAsdasdasd.getText()+""),Integer.valueOf(this.textField_giaTien.getText()+""),test,true);
		 if (result) {
		        themDTVaoTable(busdt.getListDT().get(busdt.getListDT().size() - 1));
		    }else {
		    	JOptionPane.showMessageDialog(null, "Thêm thất bại");
		    }
		    xoaForm();
	}

	public DTO_Dienthoai getDT() {
	    DefaultTableModel model_DT = (DefaultTableModel) table_1.getModel();
	    int index = table_1.getSelectedRow();
	    int modelIndex = table_1.convertRowIndexToModel(index);
	    
	    String maDT = (String) model_DT.getValueAt(modelIndex, 0);
	    String tenLoai = (String) model_DT.getValueAt(modelIndex, 1);
	    String maBH = (String) model_DT.getValueAt(modelIndex, 2);
	    String tinhNang = (String) model_DT.getValueAt(modelIndex, 3);
	    String tenDT = (String) model_DT.getValueAt(modelIndex, 4);
	    int SL = Integer.parseInt((String) model_DT.getValueAt(modelIndex, 5));

	    // convert chuoi "36,000,000 VNĐ -> 36000000(int)"
	    String giaString = (String) model_DT.getValueAt(modelIndex, 6);
	    int indexGia = giaString.indexOf(" VNĐ");
	    String getStringGia = giaString.substring(0, indexGia);
	    getStringGia = getStringGia.replace(",", "");
	    int gia = Integer.parseInt(getStringGia);
	    String img = (String) model_DT.getValueAt(modelIndex, 7);

	    DTO_Dienthoai dt = new DTO_Dienthoai(maDT, tenLoai, maBH, tinhNang, tenDT, SL, gia, img, true);
	    return dt;
	}

	
	public void suaDT() {
		int index = table_1.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa");
		}else {
			DTO_Dienthoai dt = getDT();
			this.textField_maDT.setText(dt.getMa_DT()+"");
			this.comboBox_maLoai.setSelectedItem(dt.getTenLoai()+"");
			this.comboBox_maBH.setSelectedItem(dt.getMaBH()+"");
			this.textArea_tinhNang.setText(dt.getTinhNang()+"");
			this.textField_tenDT.setText(dt.getTenDT()+"");
			this.txtAsdasdasd.setText(dt.getSL()+"");
			this.textField_giaTien.setText(dt.getGiaTien()+""); 
			this.jlabel_img.setIcon(new ImageIcon(dt.getImg()));			
		}
	}
	
	public void xoaDT() {
	    BUS_Dienthoai busdt = new BUS_Dienthoai();
	    int index = table_1.getSelectedRow(); // lay ra dong ma nguoi dung chon
	    if (index == -1) {
	        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
	    } else {
	        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa điện thoại này?");
	        if (luaChon == JOptionPane.YES_OPTION) {
	            DTO_Dienthoai dt = getDT();
	            boolean check = busdt.delete(dt.getMa_DT());
	            if (check) {
//	                model_table.removeRow(index);
	            	dt.setCheck_exist(false);
//	            	System.out.println(dt);
	                updateDTFromList();
	            }
	            xoaForm();
	        }
	    }
	}
	
	
	public void xuatExcel(ArrayList<DTO_Dienthoai> dsDT, String fileName) {
	    try {
	        // Tạo workbook mới
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // Tạo sheet mới trong workbook
	        Sheet sheet = workbook.createSheet("Sheet1");
	        
	        // Tạo header row với tên cột
	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Mã DT");
	        headerRow.createCell(1).setCellValue("Tên loại");
	        headerRow.createCell(2).setCellValue("Mã BH");
	        headerRow.createCell(3).setCellValue("Tính năng");
	        headerRow.createCell(4).setCellValue("Tên DT");
	        headerRow.createCell(5).setCellValue("SL");
	        headerRow.createCell(6).setCellValue("Giá tiền");
	        headerRow.createCell(7).setCellValue("Hình ảnh");
	        headerRow.createCell(8).setCellValue("Trạng thái");
	        
	        // Duyệt qua danh sách điện thoại và tạo các row và cell tương ứng trên sheet
	        int rowIndex = 1;
	        for (DTO_Dienthoai dt : dsDT) {
	            Row row = sheet.createRow(rowIndex++);
	            row.createCell(0).setCellValue(dt.getMa_DT());
	            row.createCell(1).setCellValue(dt.getTenLoai());
	            row.createCell(2).setCellValue(dt.getMaBH());
	            row.createCell(3).setCellValue(dt.getTinhNang());
	            row.createCell(4).setCellValue(dt.getTenDT());
	            row.createCell(5).setCellValue(dt.getSL());
	            row.createCell(6).setCellValue(dt.getGiaTienFormatted());
	            row.createCell(7).setCellValue(dt.getImg());
	            row.createCell(8).setCellValue(dt.isCheck_exist());
	        }
	        
	        // Ghi workbook ra file
	        FileOutputStream out = new FileOutputStream(fileName);
	        workbook.write(out);
	        out.close();
	        JOptionPane.showMessageDialog(this, "Export excel thành công");

	    } catch (Exception e) {
	        System.out.println("Lỗi khi tạo file Excel: " + e.getMessage());
	    }
    }
	public void importExcel(String filePath) {
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    int count = 0;
	    for(int i = 1 ; i <= busdt.getListDT().size() ; i++) {
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
	            if(count < sheet.getLastRowNum()) {
	            	int rowCount = table_1.getRowCount();
	            	String lastMaSP = (String) table_1.getValueAt(rowCount - 1, 0);
	            	System.out.println("From java: "+lastMaSP);
	            	
	            	int lastRowNum = sheet.getLastRowNum();

	            	// Lấy đối tượng Row của dòng cuối cùng
	            	Row lastRow = sheet.getRow(lastRowNum);

	            	// Lấy giá trị của ô chứa mã NV trong dòng cuối cùng
	            	Cell maDTCell = lastRow.getCell(0);
	            	Cell tenLoaiCell = lastRow.getCell(1);
	            	Cell maBHCell = lastRow.getCell(2);
	            	Cell tinhnangCell = lastRow.getCell(3);
	            	Cell tenDTCell = lastRow.getCell(4);
	            	Cell soLuongCell = lastRow.getCell(5);
	            	Cell giaTienCell = lastRow.getCell(6);
	            	Cell imgCell = lastRow.getCell(7);

	            	
	            	String maSP = maDTCell.getStringCellValue();
	            	System.out.println("From excel: "+maDTCell);
	            	if(Integer.parseInt(maSP.substring(2)) - Integer.parseInt(lastMaSP.substring(2)) == 1) {
	            		for(DTO_LoaiDT ldt : busldt.getlistLoaiDT()) {
	            			System.out.println("test: "+ldt.getTenLoai());
	            			if(tenLoaiCell.toString().trim().equals(ldt.getTenLoai())) {
	            				for (DTO_PhieuBH bh : busbh.getlistPBH()) {
									if(maBHCell.toString().trim().equals(bh.getMa_BH())) {
										if( soLuongCell.getCellType() != CellType.NUMERIC || giaTienCell.getCellType() != CellType.NUMERIC ) {
		    								JOptionPane.showMessageDialog(null, "Dữ liệu số lượng hoặc giá truyền vào không hợp lý");
		    								return;
		    							}else {
		    								for(int i = count + 1 ; i <= sheet.getLastRowNum() ; i++) {
            				            		XSSFRow excelRow = (XSSFRow) sheet.getRow(i);
            				            		XSSFCell maDT = excelRow.getCell(0);
            				            		XSSFCell tenLoai = excelRow.getCell(1);
            				            		XSSFCell maBH = excelRow.getCell(2);
            				            		XSSFCell tinhNang = excelRow.getCell(3);
            				            		XSSFCell tenDT = excelRow.getCell(4);
            				            		XSSFCell SL = excelRow.getCell(5);
            				            		XSSFCell giaTien = excelRow.getCell(6);
            				            		XSSFCell img = excelRow.getCell(7);
            				            		XSSFCell ex_trangThai = excelRow.getCell(8);
            				            		boolean trangThai = false;
            				            		if (ex_trangThai != null) {
            				            		    trangThai = ex_trangThai.getBooleanCellValue();
            				            		}
            				            		// SL
            				            		double value = SL.getNumericCellValue();
            				            		int intValue = (int) Math.round(value);
            				            		
            				            		// tien
            				            		DecimalFormat decimalFormat = new DecimalFormat("#");
            				            		String giaTienStr = decimalFormat.format(giaTien.getNumericCellValue());
            				            		int giaTienInt = Integer.parseInt(giaTienStr);
            				            		boolean check = busdt.addDTToTable(maDT.toString(), tenLoai.toString(), maBH.toString(), tinhNang.toString(), tenDT.toString(), intValue, giaTienInt, img.toString(), trangThai);
            				            		if(check) {
            				            			themDTVaoTable(busdt.getListDT().get(busdt.getListDT().size() - 1));
            				            		}
            				            	}return;            
		    							}
									}
									
	            				}
	            				JOptionPane.showMessageDialog(null, "Dữ liệu mã bảo hành truyền vào không hợp lý");
	            				return;
	            				
	            			}
	            				            			
        				}
	            		JOptionPane.showMessageDialog(null, "Dữ liệu tên loại điện thoại truyền vào không hợp lý");
	            		return;
	            			
	            	}
	            		JOptionPane.showMessageDialog(null, "Dữ liệu mã điện thoại truyền vào không hợp lý");
	            		return;
	            		
	            	
	            }else if(count == sheet.getLastRowNum()) {
	            	DTO_Dienthoai[] dtArray = new DTO_Dienthoai[sheet.getLastRowNum() + 1];
	            	for(int i = 1 ; i <= sheet.getLastRowNum()-1 ; i++) {
	            		XSSFRow excelRow = (XSSFRow) sheet.getRow(i);
	            		XSSFCell maDT = excelRow.getCell(0);
	            		XSSFCell tenLoai = excelRow.getCell(1);
	            		XSSFCell maBH = excelRow.getCell(2);
	            		XSSFCell tinhNang = excelRow.getCell(3);
	            		XSSFCell tenDT = excelRow.getCell(4);
	            		XSSFCell SL = excelRow.getCell(5);
	            		XSSFCell giaTien = excelRow.getCell(6);
	            		XSSFCell img = excelRow.getCell(7);
	            		XSSFCell ex_trangThai = excelRow.getCell(8);
	            		boolean trangThai = ex_trangThai.getBooleanCellValue();
	            			            							
						int sl = (int) SL.getNumericCellValue();
						int gia = (int) giaTien.getNumericCellValue();
						
						DTO_Dienthoai dt = new DTO_Dienthoai(maDT.toString(), tenLoai.toString(), maBH.toString(), tinhNang.toString(), tenDT.toString(), Integer.parseInt(SL.toString()), Integer.parseInt(giaTien.toString()), img.toString(), trangThai);
						dtArray[i] = dt;
						if(!dtArray[i].equals(busdt.getListDT().get(i))) {
	            			busdt.update(maDT.toString(), tenLoai.toString(), maBH.toString(), tinhNang.toString(), tenDT.toString(), Integer.parseInt(SL.toString()), Integer.parseInt(giaTien.toString()), img.toString(), trangThai);
	            	}
				}
	           }
	            model_table.addRow(rowData);
	            updateDTFromList();
	            System.out.println(Arrays.toString(rowData));
	        }
	        workbook.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // Đặt kích thước cột
	    table_1.getColumnModel().getColumn(0).setPreferredWidth(200);
        table_1.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_1.getColumnModel().getColumn(2).setPreferredWidth(200);
        table_1.getColumnModel().getColumn(3).setPreferredWidth(250);
        table_1.getColumnModel().getColumn(4).setPreferredWidth(200);
        table_1.getColumnModel().getColumn(5).setPreferredWidth(250);
        table_1.getColumnModel().getColumn(6).setPreferredWidth(250);
        table_1.getColumnModel().getColumn(7).setPreferredWidth(200);
        table_1.getColumnModel().getColumn(8).setPreferredWidth(200);
        JOptionPane.showMessageDialog(this, "Import từ excel thành công");
	}

	
	
	
	public void search() {
		BUS_Dienthoai busdt = new BUS_Dienthoai();
		String textGia = (String) comboBox.getSelectedItem();
		String textTenLoai = (String) comboBox_1.getSelectedItem();
		System.out.println(textGia);
		System.out.println(textTenLoai);
		ArrayList<DTO_Dienthoai> listDienthoai = busdt.searchDienThoai(textGia, textTenLoai);
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.setRowCount(0);
				// Thêm dòng tương ứng vào model cho mỗi nhân viên phù hợp
				for (DTO_Dienthoai dt : listDienthoai) {
					String test = dt.getImg();
					String text1 = null;
			        if (dt.isCheck_exist()) {
			        	text1 = "<html><font color='green' style='font-weight:bold;'>Tồn tại</font></html>";
			        } else {
			            text1 = "<html><font color='red' style='font-weight: bold;'>Đã xóa</font></html>";
			        }
				    Object[] rowData = {dt.getMa_DT(), dt.getTenLoai() + "", dt.getMaBH() + "", dt.getTenDT() + "",
			   	            dt.getTinhNang() + "", dt.getSL() + "", dt.getGiaTienFormatted() + "", test, text1};
				    model_table.addRow(rowData);
				    System.out.println("test: "+dt);
				}

				// Thiết lập model cho table_1
				table_1.setModel(model_table);
	}
	
	public String getGiaTienFormatted(int giaTien) {
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
	    return formatter.format(giaTien)+" VNĐ";
	}
}
