package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

import BUS.BUS_Chucvu;
import BUS.BUS_Khachhang;
import DTO.DTO_Chucvu;
import DTO.DTO_Hoadon;
import DTO.DTO_Khachhang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.Icon;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Label;
import java.awt.Point;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;

public class KhachHangForm extends JFrame {

	public JPanel contentPane;
	public JTextField textField_maKH;
	public JTextField textField_tenKH;
	public JTextField textField_diaChi;
	public JTextField textField_sdt;
	public JPanel khachHangPanel;
	public JTable table_1;
	public JComboBox comboBox_1;
	public JTextField textField_7;
	public JLabel label_khachhang;
	public JScrollPane scrollPane;
	public ArrayList<JComponent> listComponent = new ArrayList<>();
	public ArrayList<Point> toaDoBanDau = new ArrayList<Point>();
	BUS_Khachhang buskh = new BUS_Khachhang();
	public int count = 0;
	public int checkClicked = -1; // nguoi dung chua an nut nao
	private JTextField textField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHangForm frame = new KhachHangForm();
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
	public KhachHangForm() {
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
		panel_1.setPreferredSize(new Dimension(265, 500));
		contentPane.add(panel_1, BorderLayout.WEST);
		
		khachHangPanel = new JPanel();
		khachHangPanel.setBackground(new Color(192, 192, 192));
		contentPane.add(khachHangPanel, BorderLayout.CENTER);
		GridBagLayout gbl_khachHangPanel = new GridBagLayout();
		gbl_khachHangPanel.columnWidths = new int[]{1, 79, 291, 48, 50, 128, 129, 0, 58};
		gbl_khachHangPanel.rowHeights = new int[]{83, 50, 52, 52, 47, 0, 58, 49, 71, 0, 102, 0, 0, 0, 0, 0};
		gbl_khachHangPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gbl_khachHangPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		khachHangPanel.setLayout(gbl_khachHangPanel);
		
		JLabel label_khachhang = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		label_khachhang.setHorizontalAlignment(SwingConstants.CENTER);
		label_khachhang.setFont(new Font("Arial", Font.BOLD, 24));
		GridBagConstraints gbc_label_khachhang = new GridBagConstraints();
		gbc_label_khachhang.insets = new Insets(0, 0, 5, 0);
		gbc_label_khachhang.fill = GridBagConstraints.BOTH;
		gbc_label_khachhang.gridwidth = 9;
		gbc_label_khachhang.gridx = 0;
		gbc_label_khachhang.gridy = 0;
		khachHangPanel.add(label_khachhang, gbc_label_khachhang);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		khachHangPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_maKH = new JTextField();
		textField_maKH.setText("");
		textField_maKH.setEditable(false);
		textField_maKH.setColumns(10);
		GridBagConstraints gbc_textField_maKH = new GridBagConstraints();
		gbc_textField_maKH.gridwidth = 2;
		gbc_textField_maKH.insets = new Insets(0, 0, 5, 5);
		gbc_textField_maKH.fill = GridBagConstraints.BOTH;
		gbc_textField_maKH.gridx = 2;
		gbc_textField_maKH.gridy = 1;
		khachHangPanel.add(textField_maKH, gbc_textField_maKH);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput()) {
					themKH();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(KhachHangForm.class.getResource("/img/add.png")));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 1;
		khachHangPanel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_1.getSelectedRow();
				if(checkClicked != selectedRow) { // neu chon qua nut khac
					count = 0;
				}
				// neu van o cai dong do
				checkClicked = selectedRow;
				count++;
				
				if(count % 2 == 0) {
					BUS_Khachhang buskh = new BUS_Khachhang();
					int index = table_1.getSelectedRow();
					if(index == -1) {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					buskh.update(textField_maKH.getText()+"",textField_tenKH.getText()+"",textField_diaChi.getText()+"",textField_sdt.getText()+"",true);
					updateKHFromList();
				}else {
					suaKH();
				}
			}
		});
		btnSa.setIcon(new ImageIcon(KhachHangForm.class.getResource("/img/sua.png")));
		btnSa.setFont(new Font("Arial", Font.BOLD, 14));
		btnSa.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnSa = new GridBagConstraints();
		gbc_btnSa.fill = GridBagConstraints.BOTH;
		gbc_btnSa.insets = new Insets(0, 0, 5, 5);
		gbc_btnSa.gridx = 6;
		gbc_btnSa.gridy = 1;
		khachHangPanel.add(btnSa, gbc_btnSa);
		
		JLabel lblNewLabel_2 = new JLabel("Tên khách hàng");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		khachHangPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_tenKH = new JTextField();
		textField_tenKH.setText("");
		textField_tenKH.setColumns(10);
		GridBagConstraints gbc_textField_tenKH = new GridBagConstraints();
		gbc_textField_tenKH.gridwidth = 2;
		gbc_textField_tenKH.insets = new Insets(0, 0, 5, 5);
		gbc_textField_tenKH.fill = GridBagConstraints.BOTH;
		gbc_textField_tenKH.gridx = 2;
		gbc_textField_tenKH.gridy = 2;
		khachHangPanel.add(textField_tenKH, gbc_textField_tenKH);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			      xoaKH();
			    }
			});
		btnXa.setIcon(new ImageIcon(KhachHangForm.class.getResource("/img/delete.png")));
		btnXa.setFont(new Font("Arial", Font.BOLD, 14));
		btnXa.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnXa = new GridBagConstraints();
		gbc_btnXa.fill = GridBagConstraints.BOTH;
		gbc_btnXa.insets = new Insets(0, 0, 5, 5);
		gbc_btnXa.gridx = 5;
		gbc_btnXa.gridy = 2;
		khachHangPanel.add(btnXa, gbc_btnXa);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        xoaForm();
			    }
			});
		btnReset.setIcon(new ImageIcon(KhachHangForm.class.getResource("/img/reload.png")));
		btnReset.setFont(new Font("Arial", Font.BOLD, 14));
		btnReset.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.fill = GridBagConstraints.BOTH;
		gbc_btnReset.insets = new Insets(0, 0, 5, 5);
		gbc_btnReset.gridx = 6;
		gbc_btnReset.gridy = 2;
		khachHangPanel.add(btnReset, gbc_btnReset);
		
		JLabel lblNewLabel_3 = new JLabel("Địa chỉ");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		khachHangPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_diaChi = new JTextField();
		textField_diaChi.setText("");
		textField_diaChi.setColumns(10);
		GridBagConstraints gbc_textField_diaChi = new GridBagConstraints();
		gbc_textField_diaChi.gridwidth = 2;
		gbc_textField_diaChi.insets = new Insets(0, 0, 5, 5);
		gbc_textField_diaChi.fill = GridBagConstraints.BOTH;
		gbc_textField_diaChi.gridx = 2;
		gbc_textField_diaChi.gridy = 3;
		khachHangPanel.add(textField_diaChi, gbc_textField_diaChi);
		
		JButton btnNewButton_4 = new JButton("Xuất Excel");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportKhachHang.xlsx";
				xuatExcel(buskh.getListKH(), fileName);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(KhachHangForm.class.getResource("/img/xuat excel.png")));
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_4.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 5;
		gbc_btnNewButton_4.gridy = 3;
		khachHangPanel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Nhập Excel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportKhachHang.xlsx";
				importExcel(fileName);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(KhachHangForm.class.getResource("/img/nhap excel.png")));
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_5.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 6;
		gbc_btnNewButton_5.gridy = 3;
		khachHangPanel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JLabel lblNewLabel_4 = new JLabel("Số điện thoại");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		khachHangPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_sdt = new JTextField();
		textField_sdt.setText("");
		textField_sdt.setColumns(10);
		GridBagConstraints gbc_textField_sdt = new GridBagConstraints();
		gbc_textField_sdt.gridwidth = 2;
		gbc_textField_sdt.insets = new Insets(0, 0, 5, 5);
		gbc_textField_sdt.fill = GridBagConstraints.BOTH;
		gbc_textField_sdt.gridx = 2;
		gbc_textField_sdt.gridy = 4;
		khachHangPanel.add(textField_sdt, gbc_textField_sdt);
		
		JLabel lblNewLabel_6 = new JLabel("Tìm kiếm: ");
		lblNewLabel_6.setToolTipText("Tìm kiếm");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_6.setBackground(new Color(128, 0, 64));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 7;
		khachHangPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
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
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 7;
		khachHangPanel.add(textField_4, gbc_textField_4);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại","Trạng thái"
			}
		));
		table_1.setRowHeight(50);
		table_1.setBounds(1, 25, 922, -2);
		table_1.setDefaultEditor(Object.class, null);
		
		JButton btnNewButton_4_1 = new JButton("Tìm");
		btnNewButton_4_1.setIcon(new ImageIcon(KhachHangForm.class.getResource("/img/search.png")));
		btnNewButton_4_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_4_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_4_1 = new GridBagConstraints();
		gbc_btnNewButton_4_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4_1.gridx = 5;
		gbc_btnNewButton_4_1.gridy = 7;
		khachHangPanel.add(btnNewButton_4_1, gbc_btnNewButton_4_1);
		khachHangPanel.add(table_1);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setEnabled(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.gridwidth = 9;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 8;
		khachHangPanel.add(scrollPane, gbc_scrollPane);
		
		
		Color customColor = new Color(226, 221, 221);

		updateKHFromList();
		showMaKHNext();
	}

	public JPanel getKhachHangJPanel() {
		return khachHangPanel;
	}
	public boolean checkInput() {
		if(this.textField_maKH.getText().equals("") || this.textField_tenKH.getText().equals("") || this.textField_diaChi.getText().equals("") || this.textField_sdt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}
		String sdt = this.textField_sdt.getText()+"";
		if(sdt.charAt(0) != '0') {
			JOptionPane.showMessageDialog(null, "Số điện thoại phải bắt đầu bằng số 0");
			return false;
		}else if(sdt.length() > 10) {
			JOptionPane.showMessageDialog(null, "Số điện thoại chỉ có 10 số thôi");
			return false;
		}
		try {
			int sdtInteger = Integer.parseInt(sdt);
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Đây không phải là số điện thoại");
			return false;
		}
		
		for (DTO_Khachhang kh : buskh.getListKH()) {
			if((this.textField_tenKH.getText()+"").equals(kh.getTen_KH())) {
				JOptionPane.showMessageDialog(null, "Khách hàng này đã tạo tài khoản");
				return false;
			}else if((this.textField_sdt.getText()+"").equals(kh.getSDT())) {
				JOptionPane.showMessageDialog(null, "Số điện thoại đã được đăng ký, không thể thêm được nữa");
				return false;
			}
		 }
		return true;
	}
	
	public void showMaKHNext() {
		BUS_Khachhang buskh = new BUS_Khachhang();
		textField_maKH.setEditable(false);
		textField_maKH.setText(buskh.getMaKHNext()+"");
	}
	
	public void themKHVaoTable(DTO_Khachhang kh) {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.addRow(new Object[]{kh.getMa_KH()+"",kh.getTen_KH()+"",kh.getDiaChi()+"",kh.getSDT()+"",kh.isCheck_exist()+""});
		updateKHFromList();
		xoaForm();
	}
	
	public void updateKHFromList() {
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.setRowCount(0);

	   BUS_Khachhang buskh = new BUS_Khachhang();

	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);

	    for (DTO_Khachhang kh : buskh.getListKH()) {
	    	String text = null;
	        if (kh.isCheck_exist()) {
	        	text = "<html><font color='green' style='font-weight:bold;'>Tồn tại</font></html>";
	        } else {
	            text = "<html><font color='red' style='font-weight: bold;'>Đã xóa</font></html>";
	        }
//	       if(cv.isCheck_exist()) {
//	    	   model_table.addRow(new Object[] {cv.getMa_CV()+"",cv.getTen_CV()+"",cv.getMoTa()+"",text});
//	       }
	       model_table.addRow(new Object[] {kh.getMa_KH()+"",kh.getTen_KH()+"",kh.getDiaChi()+"",kh.getSDT()+"",text});
	    }

//	    table_1.getColumnModel().getColumn(8).setCellRenderer(renderer);
//	    table_1.getColumnModel().getColumn(7).setCellRenderer(new ImageRender());
	    xoaForm();
	}


	
	public void xoaForm() {
		textField_maKH.setText("");
		textField_tenKH.setText("");
		textField_diaChi.setText("");
		textField_sdt.setText("");
		showMaKHNext();
	}
	
	public void themKH() {
		 BUS_Khachhang buskh = new BUS_Khachhang();
		 boolean result = buskh.addKHToTable(this.textField_maKH.getText()+"", this.textField_tenKH.getText()+"", this.textField_diaChi.getText(),this.textField_sdt.getText(), true);
		 if (result) {
		        themKHVaoTable(buskh.getListKH().get(buskh.getListKH().size() - 1));
		    }else {
		    	JOptionPane.showMessageDialog(null, "Thêm thất bại");
		    }
		    xoaForm();
	}

	public DTO_Khachhang getKH() {
		DefaultTableModel model_KH = (DefaultTableModel) table_1.getModel();
		int index = table_1.getSelectedRow();
		int modelIndex = table_1.convertRowIndexToModel(index);
		
		String maKH = (String) model_KH.getValueAt(modelIndex, 0);
		String tenKH = (String) model_KH.getValueAt(modelIndex, 1);
		String diaChi = (String) model_KH.getValueAt(modelIndex, 2);
		String sdt = (String) model_KH.getValueAt(modelIndex, 3);
		
		
		DTO_Khachhang kh = new DTO_Khachhang(maKH, tenKH, diaChi, sdt, true);
		return kh;
	}
	
	public void suaKH() {
		int index = table_1.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa");
		}else {
			DTO_Khachhang kh = getKH();
			this.textField_maKH.setText(kh.getMa_KH()+"");
			this.textField_tenKH.setText(kh.getTen_KH()+"");
			this.textField_diaChi.setText(kh.getDiaChi()+"");	
			this.textField_sdt.setText(kh.getSDT()+"");	
		}
	}
	
	public void xoaKH() {
	    BUS_Khachhang buskh = new BUS_Khachhang();
	    int index = table_1.getSelectedRow(); // lay ra dong ma nguoi dung chon
	    if (index == -1) {
	        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
	    } else {
	        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa điện thoại này?");
	        if (luaChon == JOptionPane.YES_OPTION) {
	            DTO_Khachhang kh = getKH();
	            boolean check = buskh.delete(kh.getMa_KH());
	            if (check) {
//	                model_table.removeRow(index);
	            	kh.setCheck_exist(false);
//	            	System.out.println(dt);
	                updateKHFromList();
	            }
	            xoaForm();
	        }
	    }
	}
	
	
	public void xuatExcel(ArrayList<DTO_Khachhang> dsKH, String fileName) {
	    try {
	        // Tạo workbook mới
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // Tạo sheet mới trong workbook
	        Sheet sheet = workbook.createSheet("Sheet1");
	        
	        // Tạo header row với tên cột
	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Mã KH");
	        headerRow.createCell(1).setCellValue("Tên KH");
	        headerRow.createCell(2).setCellValue("Địa chỉ");
	        headerRow.createCell(3).setCellValue("SĐT");
	        headerRow.createCell(4).setCellValue("Trạng thái");
	        
	        // Duyệt qua danh sách điện thoại và tạo các row và cell tương ứng trên sheet
	        int rowIndex = 1;
	        for (DTO_Khachhang kh : dsKH) {
	            Row row = sheet.createRow(rowIndex++);
	            row.createCell(0).setCellValue(kh.getMa_KH());
	            row.createCell(1).setCellValue(kh.getTen_KH());
	            row.createCell(2).setCellValue(kh.getDiaChi());
	            row.createCell(3).setCellValue(kh.getSDT());
	            row.createCell(4).setCellValue(kh.isCheck_exist());
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
	    for(int i = 1 ; i <= buskh.getListKH().size() ; i++) {
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
	            Object[] rowData = new Object[6];
	            int columnCount = 0;
	            for (Cell cell : row) {
	                if (cell.getCellType() == CellType.BOOLEAN) {
	                    rowData[columnCount] = cell.getBooleanCellValue();
	                } else {
	                    rowData[columnCount] = cell.getStringCellValue();
	                }
	                columnCount++;
	            }
	            if(count < sheet.getLastRowNum()) {
	            	int rowCount = table_1.getRowCount();
	            	String lastMaKH = (String) table_1.getValueAt(rowCount - 1, 0);
	            	System.out.println("From java: "+lastMaKH);
	            	
	            	int lastRowNum = sheet.getLastRowNum();

	            	// Lấy đối tượng Row của dòng cuối cùng
	            	Row lastRow = sheet.getRow(lastRowNum);

	            	// Lấy giá trị của ô chứa mã NV trong dòng cuối cùng
	            	Cell maKHCell = lastRow.getCell(0);
	            	Cell tenKHCell = lastRow.getCell(1);
	            	Cell diaChiCell = lastRow.getCell(2);
	            	Cell sdtCell = lastRow.getCell(3);	
	            	String maKH = maKHCell.getStringCellValue();
	            	System.out.println("From excel: "+maKH);
	            	
	            	String sdtValue = sdtCell.toString();
	            	
	            	if(Integer.parseInt(maKH.substring(2)) - Integer.parseInt(lastMaKH.substring(2)) == 1 )	     
	            		for(DTO_Khachhang kh : buskh.getListKH()){
	            			if (!KT(sdtValue)) {
	            		        JOptionPane.showMessageDialog(null, "Dữ liệu số điện thoại truyền vào phải là kiểu số");
	            		        return;
	            		    }else {
	            				for(int i = count + 1 ; i <= sheet.getLastRowNum(); i++) {
	    		            		XSSFRow excelRow = (XSSFRow) sheet.getRow(i);
	    		            		XSSFCell ex_maKH = excelRow.getCell(0);
	    		            		XSSFCell ex_tenKH = excelRow.getCell(1);
	    		            		XSSFCell ex_diaChi = excelRow.getCell(2);
	    		            		XSSFCell ex_sdt = excelRow.getCell(3);
	    		            		XSSFCell ex_trangThai = excelRow.getCell(4);
	    		            		boolean trangThai = ex_trangThai.getBooleanCellValue();
	    		            		
	    		            		boolean check = buskh.addKHToTable(ex_maKH.toString(), ex_tenKH.toString(), ex_diaChi.toString(),ex_sdt.toString(), trangThai);
	    		            		if(check) {
	    		            			themKHVaoTable(buskh.getListKH().get(buskh.getListKH().size() - 1));
	    		            		}
	            			}
	            		}
	            	}else {
	            		JOptionPane.showMessageDialog(null, "Dữ liệu mã khách hàng truyền vào phải theo thứ tự");
						return;	  
	            	}
	            }else if(count == sheet.getLastRowNum()) {
	            	DTO_Khachhang[] khArray = new DTO_Khachhang[sheet.getLastRowNum() + 1];
	            	for(int i = 1 ; i <= sheet.getLastRowNum(); i++) {
	            		XSSFRow excelRow = (XSSFRow) sheet.getRow(i);
	            		XSSFCell ex_maKH = excelRow.getCell(0);
	            		XSSFCell ex_tenKH = excelRow.getCell(1);
	            		XSSFCell ex_diaChi = excelRow.getCell(2);
	            		XSSFCell ex_sdt = excelRow.getCell(3);
	            		XSSFCell ex_trangThai = excelRow.getCell(4);
	            		boolean trangThai = ex_trangThai.getBooleanCellValue();

	            	    DTO_Khachhang kh = new DTO_Khachhang(ex_maKH.toString(), ex_tenKH.toString(), ex_diaChi.toString(),ex_sdt.toString(), trangThai);
	            	    khArray[i] = kh;
	            	    if(!khArray[i].equals(buskh.getListKH().get(i))) {
	            	        buskh.update(ex_maKH.toString(), ex_tenKH.toString(), ex_diaChi.toString(),ex_sdt.toString(), trangThai);
	            	    }
	            	}
	            }
	            model_table.addRow(rowData);
	            updateKHFromList();
	            System.out.println(Arrays.toString(rowData));
	        }
	        workbook.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // Đặt kích thước cột
	    table_1.getColumnModel().getColumn(0).setPreferredWidth(100);
	    table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
	    table_1.getColumnModel().getColumn(2).setPreferredWidth(200);
	    table_1.getColumnModel().getColumn(3).setPreferredWidth(150);
	    table_1.getColumnModel().getColumn(4).setPreferredWidth(150);
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

}
