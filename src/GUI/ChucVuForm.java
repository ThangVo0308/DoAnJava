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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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

import BUS.BUS_Chucvu;
import DTO.DTO_Chucvu;
import DTO.DTO_Hoadon;
import DTO.DTO_Nhanvien;

public class ChucVuForm extends JFrame {

	public JPanel contentPane;
	public JPanel chucVuPanel;
	public JTextField textField_maCV;
	public JTextField textField_moTa;
	public JTable table_1;
	public JTextField textField_tenCV;
	public JTextField textField_4;
	public int count = 0;
	public int checkClicked = -1; // nguoi dung chua an nut nao
	/**
	 * @wbp.nonvisual location=-17,4
	 */
	public JPanel panel = new JPanel();
	public JLabel label_chucvu;
	public JScrollPane scrollPane;
	public ArrayList<JComponent> listComponent = new ArrayList<>();
	public ArrayList<Point> toaDoBanDau = new ArrayList<Point>();
	BUS_Chucvu buscv = new BUS_Chucvu();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChucVuForm frame = new ChucVuForm();
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
	public ChucVuForm() {
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
		
		chucVuPanel = new JPanel();
		chucVuPanel.setForeground(new Color(0, 0, 0));
		chucVuPanel.setBackground(new Color(192, 192, 192));
		contentPane.add(chucVuPanel, BorderLayout.CENTER);
		GridBagLayout gbl_chucVuPanel = new GridBagLayout();
		gbl_chucVuPanel.columnWidths = new int[]{0, 112, 96, 218, 73, 113, 64};
		gbl_chucVuPanel.rowHeights = new int[]{85, 62, 59, 57, 0, 19, 50, 46, 23, 27, 0, 0, 0, 0};
		gbl_chucVuPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0};
		gbl_chucVuPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		chucVuPanel.setLayout(gbl_chucVuPanel);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Chức Vụ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridwidth = 7;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		chucVuPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã chức vụ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		chucVuPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_maCV = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		chucVuPanel.add(textField_maCV, gbc_textField);
		textField_maCV.setColumns(10);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setIcon(new ImageIcon(ChucVuForm.class.getResource("/img/add.png")));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(226, 221, 221));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput()) {
					themCV();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 1;
		chucVuPanel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sửa");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
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
					BUS_Chucvu buscv = new BUS_Chucvu();
					int index = table_1.getSelectedRow();
					if(index == -1) {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					buscv.update(textField_maCV.getText()+"",textField_tenCV.getText()+"",textField_moTa.getText()+"",true);
					updateCVFromList();
				}else {
					suaCV();
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ChucVuForm.class.getResource("/img/sua.png")));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 1;
		chucVuPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên chức vụ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.gridwidth = 2;
		gbc_lblNewLabel_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 2;
		chucVuPanel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		textField_tenCV = new JTextField();
		textField_tenCV.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		chucVuPanel.add(textField_tenCV, gbc_textField_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			       xoaCV();
			    }
		});
		btnNewButton_2.setIcon(new ImageIcon(ChucVuForm.class.getResource("/img/delete.png")));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 2;
		chucVuPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			       xoaForm();
			    }
		});
		btnNewButton_3.setIcon(new ImageIcon(ChucVuForm.class.getResource("/img/reload.png")));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_3.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 6;
		gbc_btnNewButton_3.gridy = 2;
		chucVuPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mô tả");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.gridwidth = 2;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1.gridy = 3;
		chucVuPanel.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		textField_moTa = new JTextField();
		textField_moTa.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 3;
		chucVuPanel.add(textField_moTa, gbc_textField_3);
		
		JButton btnNewButton_4 = new JButton("Xuất Excel");
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexport.xlsx";
				xuatExcel(buscv.getListCV(), fileName);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(ChucVuForm.class.getResource("/img/xuat excel.png")));
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_4.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 5;
		gbc_btnNewButton_4.gridy = 3;
		chucVuPanel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Nhập Excel");
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexport.xlsx";
				importExcel(fileName);
				updateCVFromList();
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(ChucVuForm.class.getResource("/img/nhap excel.png")));
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_5.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.gridx = 6;
		gbc_btnNewButton_5.gridy = 3;
		chucVuPanel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tìm kiếm: ");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\HK2-N2\\JAVA\\DoAnJava (4)\\src\\img\\search.png"));
		lblNewLabel_6.setToolTipText("Tìm kiếm");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBackground(new Color(128, 0, 64));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.gridheight = 6;
		gbc_lblNewLabel_6.gridwidth = 2;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 5;
		chucVuPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
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
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 7;
		chucVuPanel.add(textField_4, gbc_textField_4);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã chức vụ", "Tên chức vụ", "Mô tả","Trạng thái"
			}
		));
		table_1.setRowHeight(50);
		table_1.setBounds(1, 25, 922, -2);
		table_1.setDefaultEditor(Object.class, null);
		chucVuPanel.add(table_1);
		
		JScrollPane scrollPane_table = new JScrollPane(table_1);
		scrollPane_table.setEnabled(false);
		GridBagConstraints gbc_scrollPane_table = new GridBagConstraints();
		gbc_scrollPane_table.gridwidth = 7;
		gbc_scrollPane_table.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_table.gridx = 0;
		gbc_scrollPane_table.gridy = 12;
		chucVuPanel.add(scrollPane_table, gbc_scrollPane_table);
		
		updateCVFromList();
		showMaCVNext();
	}
	public  void updatePanelSize() {
	    int newWidth = getWidth() - 245;
	    chucVuPanel.setBounds(245, 54, newWidth, chucVuPanel.getHeight());
	    label_chucvu.setBounds((newWidth - label_chucvu.getWidth()) / 2, label_chucvu.getY(), label_chucvu.getWidth(), label_chucvu.getHeight()); // Cập nhật vị trí của label
	}
	
	public JPanel getChucVuPanel() {
		return chucVuPanel;
	}
	
	public boolean checkInput() {
		if(this.textField_maCV.getText().equals("") || this.textField_tenCV.getText().equals("") || this.textField_moTa.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}
		return true;
	}
	
	public void showMaCVNext() {
		BUS_Chucvu buscv = new BUS_Chucvu();
		textField_maCV.setEditable(false);
		textField_maCV.setText(buscv.getMaCVNext()+"");
	}
	
	public void themCVVaoTable(DTO_Chucvu cv) {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.addRow(new Object[]{cv.getMa_CV()+"",cv.getTen_CV()+"",cv.getMoTa()+"",cv.isCheck_exist()+""});
		updateCVFromList();
		xoaForm();
	}
	
	public void updateCVFromList() {
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.setRowCount(0);

	    BUS_Chucvu busCV = new BUS_Chucvu();

	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);

	    for (DTO_Chucvu cv : busCV.getListCV()) {
	    	String text = null;
	        if (cv.isCheck_exist()) {
	        	text = "<html><font color='green' style='font-weight:bold;'>Tồn tại</font></html>";
	        } else {
	            text = "<html><font color='red' style='font-weight: bold;'>Đã xóa</font></html>";
	        }
//	       if(cv.isCheck_exist()) {
//	    	   model_table.addRow(new Object[] {cv.getMa_CV()+"",cv.getTen_CV()+"",cv.getMoTa()+"",text});
//	       }
	       model_table.addRow(new Object[] {cv.getMa_CV()+"",cv.getTen_CV()+"",cv.getMoTa()+"",text});
	    }

//	    table_1.getColumnModel().getColumn(8).setCellRenderer(renderer);
//	    table_1.getColumnModel().getColumn(7).setCellRenderer(new ImageRender());
	    xoaForm();
	}


	
	public void xoaForm() {
		textField_maCV.setText("");
		textField_tenCV.setText("");
		textField_moTa.setText("");
		showMaCVNext();
	}
	
	public void themCV() {
		 BUS_Chucvu busCV = new BUS_Chucvu();
		 boolean result = busCV.addCVToTable(this.textField_maCV.getText()+"", this.textField_tenCV.getText()+"", this.textField_moTa.getText(), true);
		 if (result) {
		        themCVVaoTable(busCV.getListCV().get(busCV.getListCV().size() - 1));
		    }else {
		    	JOptionPane.showMessageDialog(null, "Thêm thất bại");
		    }
		    xoaForm();
	}

	public DTO_Chucvu getCV() {
		DefaultTableModel model_CV = (DefaultTableModel) table_1.getModel();
		int index = table_1.getSelectedRow();
		int modelIndex = table_1.convertRowIndexToModel(index);
		String maCV = (String) model_CV.getValueAt(modelIndex, 0);
		String tenCV = (String) model_CV.getValueAt(modelIndex, 1);
		String moTa = (String) model_CV.getValueAt(modelIndex, 2);
		
		
		DTO_Chucvu cv = new DTO_Chucvu(maCV, tenCV, moTa, true);
		return cv;
	}
	
	public void suaCV() {
		int index = table_1.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa");
		}else {
			DTO_Chucvu cv = getCV();
			this.textField_maCV.setText(cv.getMa_CV()+"");
			this.textField_tenCV.setText(cv.getTen_CV()+"");
			this.textField_moTa.setText(cv.getMoTa()+"");	
		}
	}
	
	public void xoaCV() {
	    BUS_Chucvu buscv = new BUS_Chucvu();
	    int index = table_1.getSelectedRow(); // lay ra dong ma nguoi dung chon
	    if (index == -1) {
	        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
	    } else {
	        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa điện thoại này?");
	        if (luaChon == JOptionPane.YES_OPTION) {
	            DTO_Chucvu cv = getCV();
	            boolean check = buscv.delete(cv.getMa_CV());
	            if (check) {
//	                model_table.removeRow(index);
	            	cv.setCheck_exist(false);
//	            	System.out.println(dt);
	                updateCVFromList();
	            }
	            xoaForm();
	        }
	    }
	}
	
	
	public void xuatExcel(ArrayList<DTO_Chucvu> dsCV, String fileName) {
	    try {
	        // Tạo workbook mới
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // Tạo sheet mới trong workbook
	        Sheet sheet = workbook.createSheet("Sheet1");
	        
	        // Tạo header row với tên cột
	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Mã CV");
	        headerRow.createCell(1).setCellValue("Tên CV");
	        headerRow.createCell(2).setCellValue("Mô tả");
	        headerRow.createCell(3).setCellValue("Trạng thái");
	        
	        // Duyệt qua danh sách điện thoại và tạo các row và cell tương ứng trên sheet
	        int rowIndex = 1;
	        for (DTO_Chucvu cv : dsCV) {
	            Row row = sheet.createRow(rowIndex++);
	            row.createCell(0).setCellValue(cv.getMa_CV());
	            row.createCell(1).setCellValue(cv.getTen_CV());
	            row.createCell(2).setCellValue(cv.getMoTa());
	            row.createCell(3).setCellValue(cv.isCheck_exist());
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
	    for(int i = 1 ; i <= buscv.getListCV().size() ; i++) {
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
	            Object[] rowData = new Object[4];
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
	            	String lastMaCV = (String) table_1.getValueAt(rowCount - 1, 0);
	            	System.out.println("From java: "+lastMaCV);
	            	
	            	int lastRowNum = sheet.getLastRowNum();

	            	// Lấy đối tượng Row của dòng cuối cùng
	            	Row lastRow = sheet.getRow(lastRowNum);

	            	// Lấy giá trị của ô chứa mã NV trong dòng cuối cùng
	            	Cell maCVCell = lastRow.getCell(0);
	            	Cell tenCVCell = lastRow.getCell(1);
	            	Cell moTaCell = lastRow.getCell(2);	
	            	
	            	String maCV = maCVCell.getStringCellValue();
	            	System.out.println("From excel: "+maCV);
	            	if(Integer.parseInt(maCV.substring(2)) - Integer.parseInt(lastMaCV.substring(2)) == 1 ) {	            		
	            		for(int i = count + 1 ; i <= sheet.getLastRowNum() ; i++) {
		            		XSSFRow excelRow = (XSSFRow) sheet.getRow(i);
		            		XSSFCell ex_maCV = excelRow.getCell(0);
		            		XSSFCell ex_tenCV = excelRow.getCell(1);
		            		XSSFCell ex_moTa = excelRow.getCell(2);
		            		XSSFCell ex_trangThai = excelRow.getCell(3);
		            		boolean trangThai = ex_trangThai.getBooleanCellValue();
		            		
		            		boolean check = buscv.addCVToTable(ex_maCV.toString(), ex_tenCV.toString(), ex_moTa.toString(), trangThai);
		            		if(check) {
		            			themCVVaoTable(buscv.getListCV().get(buscv.getListCV().size() - 1));
		            		}
	            		}
	            	}
	            	else {
						JOptionPane.showMessageDialog(null, "Dữ liệu mã chức vụ truyền vào không hợp lý");
						return;	            		
	            		}	            	
	            	
	            	}
	            else if(count == sheet.getLastRowNum()) {
	            	DTO_Chucvu[] cvArray = new DTO_Chucvu[sheet.getLastRowNum() + 1];
	            	for(int i = count + 1 ; i <= sheet.getLastRowNum() ; i++) {
	            		XSSFRow excelRow = (XSSFRow) sheet.getRow(i);
	            		XSSFCell ex_maCV = excelRow.getCell(0);
	            		XSSFCell ex_tenCV = excelRow.getCell(1);
	            		XSSFCell ex_moTa = excelRow.getCell(2);
	            		XSSFCell ex_trangThai = excelRow.getCell(3);
	            		boolean trangThai = ex_trangThai.getBooleanCellValue();
	            		
	            		DTO_Chucvu cv = new DTO_Chucvu(ex_maCV.toString(), ex_tenCV.toString(), ex_moTa.toString(), trangThai);
	            	    cvArray[i] = cv;
	            	    if(!cvArray[i].equals(buscv.getListCV().get(i))) {
	            	        buscv.update(ex_maCV.toString(), ex_tenCV.toString(), ex_moTa.toString(), trangThai);
	            	    }
	            	}
	            }
	            model_table.addRow(rowData);
	            updateCVFromList();
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
	    JOptionPane.showMessageDialog(null, "Import từ excel thành công");
	}


}
	
