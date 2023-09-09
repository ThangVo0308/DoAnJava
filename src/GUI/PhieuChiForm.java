package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;

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
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.JDateChooser;

import BUS.BUS_ChitietPN;
import BUS.BUS_Dienthoai;
import BUS.BUS_Nhanvien;
import BUS.BUS_PhieuChi;
import BUS.BUS_Phieunhap;
import DTO.DTO_ChitietPN;
import DTO.DTO_Dienthoai;
import DTO.DTO_Hoadon;
import DTO.DTO_LoaiDT;
import DTO.DTO_Nhanvien;
import DTO.DTO_PhieuChi;
import DTO.DTO_Phieunhap;

public class PhieuChiForm extends JFrame {

	public JPanel contentPane;
	public JPanel phieuChiPanel;
	public JLabel lblQLPhieuChi;
	public JTable table_1;
	public JScrollPane scrollPane;
	public JTextField textField_maPC;
	public JTextField textField_4;
	public JTextField txtAsdasd;
	public ArrayList<JComponent> listComponent = new ArrayList<>();
	public ArrayList<Point> toaDoBanDau = new ArrayList<Point>();
	public ArrayList<DTO_PhieuChi> test = new ArrayList<>();
	private JDateChooser dateChooser;
	private JComboBox comboBox_maNV;
	private JComboBox comboBox_maPN;
	BUS_PhieuChi buspc = new BUS_PhieuChi();
	BUS_Phieunhap buspn = new BUS_Phieunhap();
	BUS_Nhanvien busnv = new BUS_Nhanvien();
	BUS_Dienthoai busdt = new BUS_Dienthoai();
	BUS_ChitietPN busctpn = new BUS_ChitietPN();
	public int count = 0;
	public int checkClicked = -1; // nguoi dung chua an nut nao
	private JComboBox comboBox_tinhTrang;
	private JComboBox comboBox_maDT;
	private JTextField textField_2;
	PhieuNhapForm pnForm = new PhieuNhapForm();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuChiForm frame = new PhieuChiForm();
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
	public PhieuChiForm() {
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
		
		phieuChiPanel = new JPanel();
		phieuChiPanel.setBackground(new Color(192, 192, 192));
		contentPane.add(phieuChiPanel, BorderLayout.CENTER);
		GridBagLayout gbl_phieuChiPanel = new GridBagLayout();
		gbl_phieuChiPanel.columnWidths = new int[]{50, 83, 327, 108, 155, 138, 0, 0};
		gbl_phieuChiPanel.rowHeights = new int[]{78, 45, 45, 45, 43, 40, 41, 0, 0, 42, 0, 292, 0, 0};
		gbl_phieuChiPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_phieuChiPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		phieuChiPanel.setLayout(gbl_phieuChiPanel);
		
		JLabel lblQLPhieuChi = new JLabel("QUẢN LÝ PHIẾU CHI");
		lblQLPhieuChi.setHorizontalAlignment(SwingConstants.CENTER);
		lblQLPhieuChi.setFont(new Font("Arial", Font.BOLD, 24));
		GridBagConstraints gbc_lblQLPhieuChi = new GridBagConstraints();
		gbc_lblQLPhieuChi.insets = new Insets(0, 0, 5, 0);
		gbc_lblQLPhieuChi.gridwidth = 7;
		gbc_lblQLPhieuChi.gridx = 0;
		gbc_lblQLPhieuChi.gridy = 0;
		phieuChiPanel.add(lblQLPhieuChi, gbc_lblQLPhieuChi);
		
		JLabel lblNewLabel_1 = new JLabel("Mã phiếu chi");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		phieuChiPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_maPC = new JTextField();
		textField_maPC.setText("");
		textField_maPC.setEditable(false);
		textField_maPC.setColumns(10);
		GridBagConstraints gbc_textField_maPC = new GridBagConstraints();
		gbc_textField_maPC.insets = new Insets(0, 0, 5, 5);
		gbc_textField_maPC.fill = GridBagConstraints.BOTH;
		gbc_textField_maPC.gridx = 2;
		gbc_textField_maPC.gridy = 1;
		phieuChiPanel.add(textField_maPC, gbc_textField_maPC);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã phiếu nhập");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 2;
		phieuChiPanel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
	    comboBox_maPN = new JComboBox();
	    comboBox_maPN.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				pnForm.updatePNFromList();
				test();
			}
		});
		comboBox_maPN.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox_maPN = new GridBagConstraints();
		gbc_comboBox_maPN.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_maPN.fill = GridBagConstraints.BOTH;
		gbc_comboBox_maPN.gridx = 2;
		gbc_comboBox_maPN.gridy = 2;
		phieuChiPanel.add(comboBox_maPN, gbc_comboBox_maPN);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput()) {
					themPC();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(PhieuChiForm.class.getResource("/img/add.png")));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 2;
		phieuChiPanel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sửa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_1.getSelectedRow();
				if(checkClicked != selectedRow) { // neu chon qua nut khac
					count = 0;
				}
				// neu van o cai dong do
				checkClicked = selectedRow;
				count++;
				
				if(count % 2 == 0) {
					BUS_PhieuChi buspc = new BUS_PhieuChi();
					String tam = comboBox_maPN.getSelectedItem()+"";
					int index = table_1.getSelectedRow();
					if(index == -1) {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					if(buspc.getlistPC().get(index).isCheck_exist() == true) {
						JOptionPane.showMessageDialog(null, "Phiếu chi này đã được thanh toán, không thể sửa lại được nữa");
						return;
					}
					java.util.Date utilDate = dateChooser.getDate(); // lay ra date trong o input
					Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
					cal.setTime(utilDate); // lay ra thoi gian cua utilDate
//					cal.add(Calendar.DATE, 0); // cong them 2 ngay nua de hien thi dung tren jtable
					java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
					java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
					
					boolean check = false;
					if(comboBox_tinhTrang.getSelectedItem().equals("Chưa thanh toán")) {
						check = false;
					}else {
						check = true;
					}
					if(checkInput()) {
						System.out.println("test1: "+index+" :"+check);
						buspc.update(textField_maPC.getText()+"", comboBox_maPN.getSelectedItem()+"", comboBox_maNV.getSelectedItem()+"", sqlDate, Integer.parseInt(txtAsdasd.getText()+""), check);
						System.out.println(buspc.getPC(textField_maPC.getText()+""));
						updatePCFromList();
					}
					if(check == true) {
						for(int i = 0 ; i < buspn.getlistPN().size() ; i++) {
			       			System.out.println(tam);
			       			if(tam.equals(buspn.getlistPN().get(i).getMa_PN())) {
			       				for(int j = 0 ; j < busctpn.getListCTPN().size() ; j++) {
			       					if(tam.equals(busctpn.getListCTPN().get(j).getMa_PN())) {
			       						int SL = busctpn.getListCTPN().get(j).getSL();
					       				String currentMaDT = busctpn.getListCTPN().get(j).getMa_DT();
					       				for(int k = 0 ; k < busdt.getListDT().size() ; k++) {
					       					if(currentMaDT.equals(busdt.getListDT().get(k).getMa_DT())) {
//					       						System.out.println(busdt.getListDT().get(k).getMa_DT());
					       						busdt.update(busdt.getListDT().get(k).getMa_DT(), busdt.getListDT().get(k).getTenLoai(), busdt.getListDT().get(k).getMaBH(), busdt.getListDT().get(k).getTenDT(), busdt.getListDT().get(k).getTinhNang(), busdt.getListDT().get(k).getSL() + SL, busdt.getListDT().get(k).getGiaTien(), busdt.getListDT().get(k).getImg(), true);
					       					}
					       				}
			       					}
			       				}
			       				break;
			       			}
			       		}
					}
					buspc.getlistPC().get(index).setCheck_exist(check);
				}else {
					suaPC();
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(PhieuChiForm.class.getResource("/img/reload.png")));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 2;
		phieuChiPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày chi");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 3;
		phieuChiPanel.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 3;
		phieuChiPanel.add(dateChooser, gbc_dateChooser);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        xoaPC();
			    }
			});
		
		btnNewButton_2.setIcon(new ImageIcon(PhieuChiForm.class.getResource("/img/delete.png")));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 3;
		phieuChiPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        xoaForm();
			    }
			});
		btnNewButton_3.setIcon(new ImageIcon(PhieuChiForm.class.getResource("/img/reload.png")));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_3.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 3;
		phieuChiPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tổng giá");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3.gridx = 1;
		gbc_lblNewLabel_1_3.gridy = 4;
		phieuChiPanel.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		txtAsdasd = new JTextField();
		txtAsdasd.setHorizontalAlignment(SwingConstants.LEFT);
		txtAsdasd.setEditable(false);
		txtAsdasd.setColumns(10);
		GridBagConstraints gbc_txtAsdasd = new GridBagConstraints();
		gbc_txtAsdasd.insets = new Insets(0, 0, 5, 5);
		gbc_txtAsdasd.fill = GridBagConstraints.BOTH;
		gbc_txtAsdasd.gridx = 2;
		gbc_txtAsdasd.gridy = 4;
		phieuChiPanel.add(txtAsdasd, gbc_txtAsdasd);
		
		JButton btnNewButton_4 = new JButton("Xuất Excel");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportPhieuChi.xlsx";
				xuatExcel(buspc.getlistPC(), fileName);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(PhieuChiForm.class.getResource("/img/xuat excel.png")));
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_4.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 4;
		phieuChiPanel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mã nhân viên");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_4 = new GridBagConstraints();
		gbc_lblNewLabel_1_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_4.gridx = 1;
		gbc_lblNewLabel_1_4.gridy = 5;
		phieuChiPanel.add(lblNewLabel_1_4, gbc_lblNewLabel_1_4);
		
		comboBox_maNV = new JComboBox();
		comboBox_maNV.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox_maNV = new GridBagConstraints();
		gbc_comboBox_maNV.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_maNV.fill = GridBagConstraints.BOTH;
		gbc_comboBox_maNV.gridx = 2;
		gbc_comboBox_maNV.gridy = 5;
		phieuChiPanel.add(comboBox_maNV, gbc_comboBox_maNV);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Tình trạng");
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_4_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_4_1.gridx = 1;
		gbc_lblNewLabel_1_4_1.gridy = 6;
		phieuChiPanel.add(lblNewLabel_1_4_1, gbc_lblNewLabel_1_4_1);
		
		comboBox_tinhTrang = new JComboBox();
		comboBox_tinhTrang.addItem("");
		comboBox_tinhTrang.addItem("Chưa thanh toán");
		comboBox_tinhTrang.addItem("Đã thanh toán");
		comboBox_tinhTrang.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox_maNV_1 = new GridBagConstraints();
		gbc_comboBox_maNV_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_maNV_1.fill = GridBagConstraints.BOTH;
		gbc_comboBox_maNV_1.gridx = 2;
		gbc_comboBox_maNV_1.gridy = 6;
		phieuChiPanel.add(comboBox_tinhTrang, gbc_comboBox_maNV_1);
		
		JLabel lblNewLabel_4 = new JLabel("Tìm kiếm: ");
		lblNewLabel_4.setToolTipText("Tìm kiếm");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setBackground(new Color(128, 0, 64));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 9;
		phieuChiPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 String searchText = textField_2.getText().trim();
			        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
			        table_1.setRowSorter(sorter);
			        
			        // ?i: khong quan tam chu thuong hay chu hoa
			        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText)); // áp dụng filter với regular expression
			}
		});
		textField_2.setText("");
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 9;
		phieuChiPanel.add(textField_2, gbc_textField_2);
		
		JButton btnNewButton_4_1 = new JButton("Tìm");
		btnNewButton_4_1.setIcon(new ImageIcon(PhieuChiForm.class.getResource("/img/search.png")));
		btnNewButton_4_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_4_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_4_1 = new GridBagConstraints();
		gbc_btnNewButton_4_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4_1.gridx = 4;
		gbc_btnNewButton_4_1.gridy = 9;
		phieuChiPanel.add(btnNewButton_4_1, gbc_btnNewButton_4_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã phiếu chi", "Mã phiếu nhập", "Mã nhân viên", "Ngày chi","Tổng giá","Trạng thái"
			}
		));
		table_1.setRowHeight(50);
		table_1.setBounds(1, 25, 922, -2);
		table_1.setDefaultEditor(Object.class, null);
		phieuChiPanel.add(table_1);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setEnabled(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 11;
		phieuChiPanel.add(scrollPane, gbc_scrollPane);
		
		Color customColor = new Color(226, 221, 221);
		for (DTO_Nhanvien nv : busnv.getListNV()) {
			comboBox_maNV.addItem(nv.getMaNV());
		}
		for (DTO_Phieunhap pn : buspn.getlistPN()) {
			comboBox_maPN.addItem(pn.getMa_PN());
		}
		
		
	
		for (Component c : listComponent) {
		    toaDoBanDau.add(c.getLocation());
		}
	
		updatePCFromList();
		showMaPCNext();
	}
	public  void updatePanelSize() {
	    int newWidth = getWidth() - 245;
	    phieuChiPanel.setBounds(245, 54, newWidth, phieuChiPanel.getHeight());
	    lblQLPhieuChi.setBounds((newWidth - lblQLPhieuChi.getWidth()) / 2, lblQLPhieuChi.getY(), lblQLPhieuChi.getWidth(), lblQLPhieuChi.getHeight()); // Cập nhật vị trí của label
	}
	
	public void test() {
		PhieuNhapForm pnForm = new PhieuNhapForm();
		if(this.comboBox_maPN.getSelectedIndex() != -1) {
			pnForm.updatePNFromList();
			for (DTO_Phieunhap pn : pnForm.test) {
				System.out.println(pn);
				if((this.comboBox_maPN.getSelectedItem()).equals(pn.getMa_PN())) {
					txtAsdasd.setText(pn.getTongGia()+"");
				}
			}
		}
	}
	
	public JPanel getPhieuChiJPanel() {
		return phieuChiPanel;
	}
	
	public String getGiaTienFormatted(int gia) {
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
	    return formatter.format(gia)+" VNĐ";
	}
	
	public boolean checkInput() {
		if(this.textField_maPC.getText().equals("") || this.comboBox_maPN.getSelectedIndex() == -1 || this.dateChooser.equals("")|| this.txtAsdasd.getText().equals("") || this.comboBox_maNV.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}
		   DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date currentDate = new java.util.Date();
		    java.util.Date inputDate = null;
		    try {
		        inputDate = df.parse(df.format(this.dateChooser.getDate()));
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		    if (inputDate.compareTo(currentDate) > 0) {
		        JOptionPane.showMessageDialog(null, "Ngày chi không được lớn hơn ngày hiện tại.");
		        return false;
		    }
		    
		    
		    for (DTO_Phieunhap pn : buspn.getlistPN()) {
		        if (comboBox_maPN.getSelectedItem().equals(pn.getMa_PN())) {
		            int compareResult = inputDate.compareTo(pn.getNgayNhap());
		            if(compareResult < 0) {
		            	JOptionPane.showMessageDialog(null, "Ngày chi không được bé hơn ngày nhập");
		            	return false;
		            }
		        }
		    }
		    
		    for (DTO_PhieuChi pc : buspc.getlistPC()) {
				if(this.comboBox_maPN.getSelectedItem().equals(pc.getMaPN())) {
					JOptionPane.showMessageDialog(null, "Phiếu nhập này đã được thanh toán rồi, vui lòng tạo mới một phiếu nhập khác");
					return false;
				}
			}
		    
		return true;
	}

	
	public void showMaPCNext() {
		BUS_PhieuChi buspc = new BUS_PhieuChi();
		textField_maPC.setEditable(false);
		textField_maPC.setText(buspc.getmaPCNext()+"");
	}
	
	public void themPCVaoTable(DTO_PhieuChi pc) {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.addRow(new Object[]{pc.getMaPC()+"",pc.getMaPN()+"",pc.getMaNV()+"",pc.getNgayChi()+"",pc.getGia()+"",true});
		updatePCFromList();
		xoaForm();
	}
	
	public void updatePCFromList() {
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.setRowCount(0);

	    BUS_PhieuChi buspc = new BUS_PhieuChi();

	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);

	    for (DTO_PhieuChi pc : buspc.getlistPC()) {
	    	java.util.Date utilDate = pc.getNgayChi(); // lay ra date trong o input
			 Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
			 cal.setTime(utilDate); // lay ra thoi gian cua utilDate
			 cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
			 java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
			 java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
	    	String text = null;
	        if (pc.isCheck_exist()) {
	        	text = "<html><font color='green' style='font-weight:bold;'>Đã thanh toán</font></html>";
	        } else {
	            text = "<html><font color='red' style='font-weight: bold;'>Chưa thanh toán</font></html>";
	        }
//	       if(pc.isCheck_exist()) {
//	    	   model_table.addRow(new Object[] {pc.getMaPC()+"",pc.getMaPN()+"",pc.getMaNV()+"",sqlDate,getGiaTienFormatted(Integer.parseInt(pc.getGia()+"")),text});
//	       }
	       model_table.addRow(new Object[] {pc.getMaPC()+"",pc.getMaPN()+"",pc.getMaNV()+"",sqlDate,getGiaTienFormatted(Integer.parseInt(pc.getGia()+"")),text});
	    }
	    xoaForm();
	    int index = 1;
		for (DTO_PhieuChi pc : buspc.getlistPC()) {
			test.add(pc);
			index++;
		}
	}


	
	public void xoaForm() {
		textField_maPC.setText("");
		comboBox_maPN.setSelectedIndex(-1);
		comboBox_maNV.setSelectedIndex(-1);
		txtAsdasd.setText("0");
		dateChooser.setDate(null);
		comboBox_tinhTrang.setSelectedIndex(-1);
		showMaPCNext();
	}
	
	public void themPC() {
		String tam = this.comboBox_maPN.getSelectedItem()+"";
		 BUS_PhieuChi busPC = new BUS_PhieuChi();
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 String text = df.format(this.dateChooser.getDate());
		 java.util.Date ngayChi = null;
		 try {
		     ngayChi = (java.util.Date) df.parse(text);
		 } catch (ParseException e) {
		     e.printStackTrace();
		 }

		 java.sql.Date ngayChiSQL = new java.sql.Date(ngayChi.getTime());
		 Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
			cal.setTime(ngayChiSQL); // lay ra thoi gian cua utilDate
//			cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
			java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
			java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
			boolean check = false;
			if(this.comboBox_tinhTrang.getSelectedItem().equals("Chưa thanh toán")) {
				check = false;
			}else {
				check = true;
			}
			
			boolean result = busPC.addPCToTable(this.textField_maPC.getText()+"", this.comboBox_maPN.getSelectedItem()+"", this.comboBox_maNV.getSelectedItem()+"", sqlDate,Integer.parseInt(this.txtAsdasd.getText()+""),check);
			if (result) {
		       	if(check == true) {
		       		themPCVaoTable(busPC.getlistPC().get(busPC.getlistPC().size() - 1));
		       		for(int i = 0 ; i < buspn.getlistPN().size() ; i++) {
		       			if(tam.equals(buspn.getlistPN().get(i).getMa_PN())) {
		       				for(int j =0;j<busctpn.getListCTPN().size();j++) {
		       					if(buspn.getlistPN().get(i).getMa_PN().equals(busctpn.getListCTPN().get(j).getMa_PN())) {
		       						int SL = busctpn.getListCTPN().get(j).getSL();
		       						String currentMaDT = busctpn.getListCTPN().get(j).getMa_DT();
		       						for(int k = 0 ; k < busdt.getListDT().size() ; k++) {
		       							if(currentMaDT.equals(busdt.getListDT().get(k).getMa_DT())) {
//		       								System.out.println(busdt.getListDT().get(k).getMa_DT());
		       								busdt.update(busdt.getListDT().get(k).getMa_DT(), busdt.getListDT().get(k).getTenLoai(), busdt.getListDT().get(k).getMaBH(), busdt.getListDT().get(k).getTenDT(), busdt.getListDT().get(k).getTinhNang(), busdt.getListDT().get(k).getSL() + SL, busdt.getListDT().get(k).getGiaTien(), busdt.getListDT().get(k).getImg(), true);
		       							}
		       						}	
		       					}
		       					
		       				}
		       				break;
		       			}
		       		}
		       	}
		        themPCVaoTable(busPC.getlistPC().get(busPC.getlistPC().size() - 1));
		    }else { 
		    	JOptionPane.showMessageDialog(null, "Thêm thất bại");
		    }
		    xoaForm();
	}

	public DTO_PhieuChi getPC() {
		DefaultTableModel model_PC = (DefaultTableModel) table_1.getModel();
		int index = table_1.getSelectedRow();
		int modelIndex = table_1.convertRowIndexToModel(index);
		String maPC = (String) model_PC.getValueAt(modelIndex, 0);
		String maPN = (String) model_PC.getValueAt(modelIndex, 1);
		String maNV = (String) model_PC.getValueAt(modelIndex, 2);
		String giaString = (String) model_PC.getValueAt(modelIndex, 4);
	    int indexGia = giaString.indexOf(" VNĐ");
	    String getStringGia = giaString.substring(0, indexGia);
	    getStringGia = getStringGia.replace(",", "");
	    int gia = Integer.parseInt(getStringGia);
		
	    String ngayChi = ((java.sql.Date) model_PC.getValueAt(modelIndex, 3)).toString();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(ngayChi);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date ngayChiReal = new java.sql.Date(parsedDate.getTime());
		String checkTrangThai = (String) model_PC.getValueAt(modelIndex, 5);
		boolean check = false;
		if(checkTrangThai.contains("Đã thanh toán")) {
			check = true;
		}else {
			check = false;
		}
	    DTO_PhieuChi pc = new DTO_PhieuChi(maPC, maPN, maNV, ngayChiReal, gia, check);
	    pc.setCheck_exist(check);
	    return pc;
	}
	
	public void suaPC() {
		int index = table_1.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa");
		}else {
			DTO_PhieuChi pc = getPC();
			this.textField_maPC.setText(pc.getMaPC()+"");
			this.comboBox_maPN.setSelectedItem(pc.getMaPN());
			this.comboBox_maNV.setSelectedItem(pc.getMaNV()+"");	
			this.dateChooser.setDate(pc.getNgayChi());
			this.txtAsdasd.setText(pc.getGia()+"");
			if(pc.isCheck_exist()) {
				this.comboBox_tinhTrang.setSelectedItem("Đã thanh toán");
			}else {
				this.comboBox_tinhTrang.setSelectedItem("Chưa thanh toán");
			}
		}
	}
	
	public void xoaPC() {
	    BUS_PhieuChi busPC = new BUS_PhieuChi();
	    int index = table_1.getSelectedRow(); // lay ra dong ma nguoi dung chon
	    if (index == -1) {
	        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
	    } else {
	        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa điện thoại này?");
	        if (luaChon == JOptionPane.YES_OPTION) {
	            DTO_PhieuChi pc = getPC();
	            boolean check = busPC.delete(pc.getMaPC());
	            if (check) {
//	                model_table.removeRow(index);
	            	pc.setCheck_exist(false);
//	            	System.out.println(dt);
	                updatePCFromList();
	            }
	            xoaForm();
	        }
	    }
	}
	
	
	public void xuatExcel(ArrayList<DTO_PhieuChi> dsPC, String fileName) {
	    try {
	        // Tạo workbook mới
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // Tạo sheet mới trong workbook
	        Sheet sheet = workbook.createSheet("Sheet1");
	        
	        // Tạo header row với tên cột
	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Mã phiếu chi");
	        headerRow.createCell(1).setCellValue("Mã phiếu nhập");
	        headerRow.createCell(2).setCellValue("Mã nhân viên");
	        headerRow.createCell(3).setCellValue("Ngày chi");
	        headerRow.createCell(4).setCellValue("Giá");
	        headerRow.createCell(5).setCellValue("Trạng thái");
	        
	        // Duyệt qua danh sách điện thoại và tạo các row và cell tương ứng trên sheet
	        int rowIndex = 1;
	        for (DTO_PhieuChi nv : dsPC) {
	            Row row = sheet.createRow(rowIndex++);
	            row.createCell(0).setCellValue(nv.getMaPC());
	            row.createCell(1).setCellValue(nv.getMaPN());
	            row.createCell(2).setCellValue(nv.getMaNV());
	            row.createCell(3).setCellValue(nv.getNgayChi());
	            Cell ngayChiCell = row.createCell(3);
	            if (nv.getNgayChi() != null) {
	                java.util.Date ngayChi = nv.getNgayChi();
	                ngayChiCell.setCellValue(new java.text.SimpleDateFormat("dd/MM/yyyy").format(ngayChi));
	            } else {
	            	ngayChiCell.setCellValue("");
	            }
	            row.createCell(4).setCellValue(nv.getGia());
	            row.createCell(5).setCellValue(nv.isCheck_exist());
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
		
}
