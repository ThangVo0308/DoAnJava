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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import BUS.BUS_NhaPP;
import DTO.DTO_Khachhang;
import DTO.DTO_LoaiDT;
import DTO.DTO_NhaPP;

public class NCCForm extends JFrame {

	public JPanel contentPane;
	public JPanel khachHangPanel;
	public JPanel NCCPanel;
	public JTextField textField_4;
	public JTextField textField_maNCC;
	public JTextField textField_tenNCC;
	public JTextField textField_diaChi;
	public JTextField textField_sdt;
	public JComponent btnNewButton;
	public JTextField textField_email;
	public JTable table_1;
	public JComboBox comboBox_1;
	public JTextField textField_7;
	public JLabel label_nhacc;
	public JPanel NhaNCCPanel;
	public JScrollPane scrollPane;
	public ArrayList<JComponent> listComponent = new ArrayList<>();
	public ArrayList<Point> toaDoBanDau = new ArrayList<Point>();
	public ArrayList<DTO_NhaPP> test = new ArrayList<>();
	BUS_NhaPP busnpp = new BUS_NhaPP();
	public int count = 0;
	public int checkClicked = -1; // nguoi dung chua an nut nao
	private JTextField textField_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NCCForm frame = new NCCForm();
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
	public NCCForm() {
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
		
		NCCPanel = new JPanel();
		NCCPanel.setBackground(new Color(192, 192, 192));
		contentPane.add(NCCPanel, BorderLayout.CENTER);
		GridBagLayout gbl_NCCPanel = new GridBagLayout();
		gbl_NCCPanel.columnWidths = new int[]{0, 0, 0, 335, 102, 134, 133, 0, 0};
		gbl_NCCPanel.rowHeights = new int[]{106, 44, 45, 40, 41, 43, 0, 0, 42, 0, 225, 0, 0};
		gbl_NCCPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_NCCPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		NCCPanel.setLayout(gbl_NCCPanel);
		
		JLabel label_nhacc = new JLabel("QUẢN LÝ NHÀ CUNG CẤP");
		label_nhacc.setHorizontalAlignment(SwingConstants.CENTER);
		label_nhacc.setFont(new Font("Arial", Font.BOLD, 24));
		GridBagConstraints gbc_label_nhacc = new GridBagConstraints();
		gbc_label_nhacc.insets = new Insets(0, 0, 5, 0);
		gbc_label_nhacc.gridwidth = 8;
		gbc_label_nhacc.fill = GridBagConstraints.BOTH;
		gbc_label_nhacc.gridx = 0;
		gbc_label_nhacc.gridy = 0;
		NCCPanel.add(label_nhacc, gbc_label_nhacc);
		
		JLabel lblNewLabel_1 = new JLabel("Mã NCC");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		NCCPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_maNCC = new JTextField();
		textField_maNCC.setText("");
		textField_maNCC.setEditable(false);
		textField_maNCC.setColumns(10);
		GridBagConstraints gbc_textField_maNCC = new GridBagConstraints();
		gbc_textField_maNCC.insets = new Insets(0, 0, 5, 5);
		gbc_textField_maNCC.fill = GridBagConstraints.BOTH;
		gbc_textField_maNCC.gridx = 3;
		gbc_textField_maNCC.gridy = 1;
		NCCPanel.add(textField_maNCC, gbc_textField_maNCC);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên NCC");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 2;
		gbc_lblNewLabel_1_1.gridy = 2;
		NCCPanel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		textField_tenNCC = new JTextField();
		textField_tenNCC.setText("");
		textField_tenNCC.setColumns(10);
		GridBagConstraints gbc_textField_tenNCC = new GridBagConstraints();
		gbc_textField_tenNCC.insets = new Insets(0, 0, 5, 5);
		gbc_textField_tenNCC.fill = GridBagConstraints.BOTH;
		gbc_textField_tenNCC.gridx = 3;
		gbc_textField_tenNCC.gridy = 2;
		NCCPanel.add(textField_tenNCC, gbc_textField_tenNCC);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput()) {
					themNCC();
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(NCCForm.class.getResource("/img/add.png")));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 2;
		NCCPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sửa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_1.getSelectedRow();
				if(checkClicked != selectedRow) { // neu chon qua nut khac
					count = 0;
				}
				// neu van o cai dong do
				checkClicked = selectedRow;
				count++;
				
				if(count % 2 == 0) {
					int index = table_1.getSelectedRow();
					if(index == -1) {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					busnpp.update(textField_maNCC.getText()+"",textField_tenNCC.getText()+"",textField_diaChi.getText()+"",textField_sdt.getText()+"", textField_email.getText()+"", true);
					updateNPPFromList();
				}else {
					suaNPP();
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(NCCForm.class.getResource("/img/sua.png")));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 6;
		gbc_btnNewButton_2.gridy = 2;
		NCCPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 2;
		gbc_lblNewLabel_1_1_1.gridy = 3;
		NCCPanel.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		textField_diaChi = new JTextField();
		textField_diaChi.setText("");
		textField_diaChi.setColumns(10);
		GridBagConstraints gbc_textField_diaChi = new GridBagConstraints();
		gbc_textField_diaChi.insets = new Insets(0, 0, 5, 5);
		gbc_textField_diaChi.fill = GridBagConstraints.BOTH;
		gbc_textField_diaChi.gridx = 3;
		gbc_textField_diaChi.gridy = 3;
		NCCPanel.add(textField_diaChi, gbc_textField_diaChi);
		
		JButton btnNewButton_3 = new JButton("Xóa");
		btnNewButton_3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			       xoaNPP();
			    }
			});
		btnNewButton_3.setIcon(new ImageIcon(NCCForm.class.getResource("/img/delete.png")));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_3.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 3;
		NCCPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Reset");
		btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               xoaForm();
            }
        });
		btnNewButton_4.setIcon(new ImageIcon(NCCForm.class.getResource("/img/reload.png")));
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_4.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 6;
		gbc_btnNewButton_4.gridy = 3;
		NCCPanel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("SĐT");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 2;
		gbc_lblNewLabel_1_1_1_1.gridy = 4;
		NCCPanel.add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);
		
		textField_sdt = new JTextField();
		textField_sdt.setText("");
		textField_sdt.setColumns(10);
		GridBagConstraints gbc_textField_sdt = new GridBagConstraints();
		gbc_textField_sdt.insets = new Insets(0, 0, 5, 5);
		gbc_textField_sdt.fill = GridBagConstraints.BOTH;
		gbc_textField_sdt.gridx = 3;
		gbc_textField_sdt.gridy = 4;
		NCCPanel.add(textField_sdt, gbc_textField_sdt);
		
		JButton btnNewButton_5 = new JButton("Xuất Excel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportNCC.xlsx";
				xuatExcel(busnpp.getListNPP(), fileName);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(NCCForm.class.getResource("/img/xuat excel.png")));
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_5.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 5;
		gbc_btnNewButton_5.gridy = 4;
		NCCPanel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Nhập Excel");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportNCC.xlsx";
				importExcel(fileName);
			}
		});
		btnNewButton_6.setIcon(new ImageIcon(NCCForm.class.getResource("/img/nhap excel.png")));
		btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_6.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 6;
		gbc_btnNewButton_6.gridy = 4;
		NCCPanel.add(btnNewButton_6, gbc_btnNewButton_6);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1.gridx = 2;
		gbc_lblNewLabel_1_1_1_1_1.gridy = 5;
		NCCPanel.add(lblNewLabel_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1);
		
		textField_email = new JTextField();
		textField_email.setText("");
		textField_email.setColumns(10);
		GridBagConstraints gbc_textField_email = new GridBagConstraints();
		gbc_textField_email.insets = new Insets(0, 0, 5, 5);
		gbc_textField_email.fill = GridBagConstraints.BOTH;
		gbc_textField_email.gridx = 3;
		gbc_textField_email.gridy = 5;
		NCCPanel.add(textField_email, gbc_textField_email);
		
		JLabel lblNewLabel_5 = new JLabel("Tìm kiếm: ");
		lblNewLabel_5.setToolTipText("Tìm kiếm");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_5.setBackground(new Color(128, 0, 64));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.gridheight = 3;
		gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 7;
		NCCPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 String searchText = textField_6.getText().trim();
			        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
			        table_1.setRowSorter(sorter);
			        
			        // ?i: khong quan tam chu thuong hay chu hoa
			        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText)); // áp dụng filter với regular expression
			}
		});
		textField_6.setText("");
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.BOTH;
		gbc_textField_6.gridx = 3;
		gbc_textField_6.gridy = 8;
		NCCPanel.add(textField_6, gbc_textField_6);
		
		JButton btnNewButton_5_1 = new JButton("Tìm");
		btnNewButton_5_1.setIcon(new ImageIcon(NCCForm.class.getResource("/img/search.png")));
		btnNewButton_5_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_5_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_5_1 = new GridBagConstraints();
		gbc_btnNewButton_5_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5_1.gridx = 5;
		gbc_btnNewButton_5_1.gridy = 8;
		NCCPanel.add(btnNewButton_5_1, gbc_btnNewButton_5_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã NCC", "Tên NCC", "Địa chỉ", "Số điện thoại","Email","Trạng thái"
			}
		));
		table_1.setRowHeight(50);
		table_1.setBounds(1, 25, 922, -2);
		table_1.setDefaultEditor(Object.class, null);
		NCCPanel.add(table_1);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setEnabled(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 8;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 10;
		NCCPanel.add(scrollPane, gbc_scrollPane);
		
		Color customColor = new Color(226, 221, 221);


		updateNPPFromList();
		showMaNCCNext();
	}
	public  void updatePanelSize() {
	    int newWidth = getWidth() - 245;
	    NCCPanel.setBounds(245, 54, newWidth, NCCPanel.getHeight());
	    label_nhacc.setBounds((newWidth - label_nhacc.getWidth()) / 2, label_nhacc.getY(), label_nhacc.getWidth(), label_nhacc.getHeight()); // Cập nhật vị trí của label
	}
	
	public JPanel getNCCJPanel() {
		return NCCPanel;
	}
	
	public boolean checkInput() {
		if(this.textField_maNCC.getText().equals("") || this.textField_tenNCC.getText().equals("") || this.textField_diaChi.getText().equals("") || this.textField_sdt.getText().equals("") || this.textField_email.getText().equals("")) {
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
		Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(this.textField_email.getText()+"");
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Địa chỉ email không hợp lệ");
            return false;
        }
		
		return true;
	}
	
	public void showMaNCCNext() {
		BUS_NhaPP busnpp = new BUS_NhaPP();
		textField_maNCC.setEditable(false);
		textField_maNCC.setText(busnpp.getMaNPPNext()+"");
	}
	
	public void themNCCVaoTable(DTO_NhaPP npp) {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.addRow(new Object[]{npp.getMa_NPP()+"",npp.getTen_NPP()+"",npp.getDiaChi()+"",npp.getSDT()+"",npp.getEmail()+"",npp.isCheck_exist()+""});
		updateNPPFromList();
		xoaForm();
	}
	
	public void updateNPPFromList() {
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.setRowCount(0);

	    BUS_NhaPP busnpp = new BUS_NhaPP();

	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);

	    for (DTO_NhaPP npp : busnpp.getListNPP()) {
	    	String text = null;
	        if (npp.isCheck_exist()) {
	        	text = "<html><font color='green' style='font-weight:bold;'>Tồn tại</font></html>";
	        } else {
	            text = "<html><font color='red' style='font-weight: bold;'>Đã xóa</font></html>";
	        }
//	       if(cv.isCheck_exist()) {
//	    	   model_table.addRow(new Object[] {cv.getMa_CV()+"",cv.getTen_CV()+"",cv.getMoTa()+"",text});
//	       }
	       model_table.addRow(new Object[] {npp.getMa_NPP()+"",npp.getTen_NPP()+"",npp.getDiaChi()+"",npp.getSDT()+"",npp.getEmail()+"",text});
	    }
	    int index = 1;
		for (DTO_NhaPP ldt : busnpp.getListNPP()) {
			test.add(ldt);
			index++;
		}
	    xoaForm();
	}


	
	public void xoaForm() {
		textField_maNCC.setText("");
		textField_tenNCC.setText("");
		textField_diaChi.setText("");
		textField_sdt.setText("");
		textField_email.setText("");
		showMaNCCNext();
	}
	
	public void themNCC() {
		 BUS_NhaPP busnpp = new BUS_NhaPP();
		 boolean result = busnpp.addNPPToTable(this.textField_maNCC.getText()+"", this.textField_tenNCC.getText()+"", this.textField_diaChi.getText()+"", this.textField_sdt.getText()+"",  this.textField_email.getText()+"", true);
		 if (result) {
		        themNCCVaoTable(busnpp.getListNPP().get(busnpp.getListNPP().size() - 1));
		    }else {
		    	JOptionPane.showMessageDialog(null, "Thêm thất bại");
		    }
		    xoaForm();
	}

	public DTO_NhaPP getNPP() {
		DefaultTableModel model_npp = (DefaultTableModel) table_1.getModel();
		int index = table_1.getSelectedRow();
		int modelIndex = table_1.convertRowIndexToModel(index);
		String maNPP = (String) model_npp.getValueAt(modelIndex, 0);
		String tenNPP = (String) model_npp.getValueAt(modelIndex, 1);
		String diaChi = (String) model_npp.getValueAt(modelIndex, 2);
		String sdt = (String) model_npp.getValueAt(modelIndex, 3);
		String email = (String) model_npp.getValueAt(modelIndex, 4);
		
		DTO_NhaPP npp = new DTO_NhaPP(maNPP, tenNPP, diaChi, sdt, email, true);
		return npp;
	}
	
	public void suaNPP() {
		int index = table_1.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa");
		}else {
			DTO_NhaPP npp = getNPP();
			this.textField_maNCC.setText(npp.getMa_NPP()+"");
			this.textField_tenNCC.setText(npp.getTen_NPP()+"");
			this.textField_diaChi.setText(npp.getDiaChi()+"");	
			this.textField_sdt.setText(npp.getSDT()+"");
			this.textField_email.setText(npp.getEmail()+"");	
		}
	}
	
	public void xoaNPP() {
	    BUS_NhaPP busnpp = new BUS_NhaPP();
	    int index = table_1.getSelectedRow(); // lay ra dong ma nguoi dung chon
	    if (index == -1) {
	        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
	    } else {
	        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa điện thoại này?");
	        if (luaChon == JOptionPane.YES_OPTION) {
	            DTO_NhaPP npp = getNPP();
	            boolean check = busnpp.delete(npp.getMa_NPP());
	            if (check) {
//	                model_table.removeRow(index);
	            	npp.setCheck_exist(false);
//	            	System.out.println(dt);
	                updateNPPFromList();
	            }
	            xoaForm();
	        }
	    }
	}
	
	
	public void xuatExcel(ArrayList<DTO_NhaPP> dsNPP, String fileName) {
		updateNPPFromList();
	    try {
	        // Tạo workbook mới
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // Tạo sheet mới trong workbook
	        Sheet sheet = workbook.createSheet("Sheet1");
	        
	        // Tạo header row với tên cột
	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Mã NPP");
	        headerRow.createCell(1).setCellValue("Tên NPP");
	        headerRow.createCell(2).setCellValue("Địa chỉ");
	        headerRow.createCell(3).setCellValue("SĐT");
	        headerRow.createCell(4).setCellValue("Email");
	        headerRow.createCell(5).setCellValue("Trạng thái");
	        
	        // Duyệt qua danh sách điện thoại và tạo các row và cell tương ứng trên sheet
	        int rowIndex = 1;
	        for (DTO_NhaPP NPP : test) {
	            Row row = sheet.createRow(rowIndex++);
	            row.createCell(0).setCellValue(NPP.getMa_NPP());
	            row.createCell(1).setCellValue(NPP.getTen_NPP());
	            row.createCell(2).setCellValue(NPP.getDiaChi());
	            row.createCell(3).setCellValue(NPP.getSDT());
	            row.createCell(4).setCellValue(NPP.getEmail());
	            row.createCell(5).setCellValue(NPP.isCheck_exist());
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
	
	public void importExcel(String filePath) {
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    int count = 0;
	    for(int i = 1 ; i <= busnpp.getListNPP().size() ; i++) {
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
	            	String lastMaNCC = (String) table_1.getValueAt(rowCount - 1, 0);
	            	
	            	int lastRowNum = sheet.getLastRowNum();

	            	// Lấy đối tượng Row của dòng cuối cùng
	            	Row lastRow = sheet.getRow(lastRowNum);

	            	// Lấy giá trị của ô chứa mã NV trong dòng cuối cùng
	            	Cell maNPPCell = lastRow.getCell(0);
	            	Cell tenNCCCell = lastRow.getCell(1);
	            	Cell diaChiCell = lastRow.getCell(2);
	            	Cell sdtCell = lastRow.getCell(3);	
	            	Cell emailCell = lastRow.getCell(4);
	            	
	            	String maNPP = maNPPCell.getStringCellValue();
	            	if(Integer.parseInt(maNPP.substring(3)) - Integer.parseInt(lastMaNCC.substring(3)) == 1 )	            		
	            		for(DTO_NhaPP npp : busnpp.getListNPP()){
	            			if(sdtCell.getCellType() != CellType.NUMERIC) {
	            				JOptionPane.showMessageDialog(null, "Dữ liệu số điện thoại truyền vào phải là kiểu số");
	            				return;
	            			}else {
	            				for(int i = count + 1 ; i <= sheet.getLastRowNum() ; i++) {
	        	            		XSSFRow excelRow = (XSSFRow) sheet.getRow(i);
	        	            		XSSFCell ex_maNPP = excelRow.getCell(0);
	        	            		XSSFCell ex_tenNPP = excelRow.getCell(1);
	        	            		XSSFCell ex_diaChi = excelRow.getCell(2);
	        	            		XSSFCell ex_sdt = excelRow.getCell(3);
	        	            		XSSFCell ex_email = excelRow.getCell(4);
	        	            		XSSFCell ex_trangThai = excelRow.getCell(5);
	        	            		boolean trangThai = ex_trangThai.getBooleanCellValue();
	        	            		
	        	            		boolean check = busnpp.addNPPToTable(ex_maNPP.toString(), ex_tenNPP.toString(), ex_diaChi.toString(), ex_sdt.toString(), ex_email.toString(), trangThai);
	        	            		if(check) {
	        	            			themNCCVaoTable(busnpp.getListNPP().get(busnpp.getListNPP().size() - 1));
	        	            	}
	        	            }
	            		}	            	            			            		            		
	            		}else {
	            			JOptionPane.showMessageDialog(null, "Dữ liệu mã nhà cung cấp truyền vào phải theo thứ tự");
	            			return;	  
	            		}
	            }
	            model_table.addRow(rowData);
	            updateNPPFromList();
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
	    JOptionPane.showMessageDialog(null, "Import từ excel thành công");
	}

}
