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

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import BUS.BUS_Dienthoai;
import BUS.BUS_LoaiDT;
import DTO.DTO_Chucvu;
import DTO.DTO_LoaiDT;

public class LoaiDTForm extends JFrame {

	private JPanel contentPane;
	private JPanel loaiDTPanel;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JTextField textField_maLoai;
	private JTextField textField_moTa;
	private JTextField textField_tenLoai;
	private JTextField textField_4;
	public ArrayList<JComponent> listComponent = new ArrayList<>();
	public ArrayList<Point> toaDoBanDau = new ArrayList<Point>();
	public ArrayList<DTO_LoaiDT> test = new ArrayList<>();
	private JLabel lblLoaiDT;
	BUS_LoaiDT busldt = new BUS_LoaiDT();
	public int count = 0;
	public int checkClicked = -1; // nguoi dung chua an nut nao
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoaiDTForm frame = new LoaiDTForm();
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
	public LoaiDTForm() {
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
		
		loaiDTPanel = new JPanel();
		loaiDTPanel.setBackground(new Color(192, 192, 192));
		contentPane.add(loaiDTPanel, BorderLayout.CENTER);
		GridBagLayout gbl_loaiDTPanel = new GridBagLayout();
		gbl_loaiDTPanel.columnWidths = new int[]{36, 146, 376, 45, 152, 145, 58};
		gbl_loaiDTPanel.rowHeights = new int[]{75, 51, 51, 49, 38, 0, 45, 0, 283, 0, 0, 68, 0};
		gbl_loaiDTPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gbl_loaiDTPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		loaiDTPanel.setLayout(gbl_loaiDTPanel);
		
		JLabel lblLoaiDT = new JLabel("QUẢN LÝ LOẠI ĐIỆN THOẠI");
		lblLoaiDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiDT.setFont(new Font("Arial", Font.BOLD, 24));
		GridBagConstraints gbc_lblLoaiDT = new GridBagConstraints();
		gbc_lblLoaiDT.insets = new Insets(0, 0, 5, 0);
		gbc_lblLoaiDT.gridwidth = 7;
		gbc_lblLoaiDT.gridx = 0;
		gbc_lblLoaiDT.gridy = 0;
		loaiDTPanel.add(lblLoaiDT, gbc_lblLoaiDT);
		
		JLabel lblNewLabel_1 = new JLabel("Mã loại");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		loaiDTPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_maLoai = new JTextField();
		GridBagConstraints gbc_textField_maLoai = new GridBagConstraints();
		gbc_textField_maLoai.insets = new Insets(0, 0, 5, 5);
		gbc_textField_maLoai.fill = GridBagConstraints.BOTH;
		gbc_textField_maLoai.gridx = 2;
		gbc_textField_maLoai.gridy = 1;
		loaiDTPanel.add(textField_maLoai, gbc_textField_maLoai);
		textField_maLoai.setColumns(10);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput()) {
					themLDT();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(LoaiDTForm.class.getResource("/img/add.png")));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 1;
		loaiDTPanel.add(btnNewButton, gbc_btnNewButton);
		
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
					BUS_LoaiDT busldt = new BUS_LoaiDT();
					int index = table_1.getSelectedRow();
					if(index == -1) {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					boolean check = false;
					String cellValue = table_1.getValueAt(selectedRow, 3).toString();
					if(cellValue.contains("Đã xóa")) {
						check = false;
					}else {
						check = true;
					}
					if(check == false) {
						JOptionPane.showMessageDialog(null, "Loại DT đã xóa thì không thể sửa được nữa");
					}else {
						busldt.update(textField_maLoai.getText()+"",textField_tenLoai.getText()+"",textField_moTa.getText()+"",true);
					}
					updateLDTFromList();
				}else {
					suaLDT();
				}

			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LoaiDTForm.class.getResource("/img/sua.png")));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 1;
		loaiDTPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên loại");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 2;
		loaiDTPanel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		textField_tenLoai = new JTextField();
		textField_tenLoai.setColumns(10);
		GridBagConstraints gbc_textField_tenLoai = new GridBagConstraints();
		gbc_textField_tenLoai.insets = new Insets(0, 0, 5, 5);
		gbc_textField_tenLoai.fill = GridBagConstraints.BOTH;
		gbc_textField_tenLoai.gridx = 2;
		gbc_textField_tenLoai.gridy = 2;
		loaiDTPanel.add(textField_tenLoai, gbc_textField_tenLoai);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			      xoaLDT();
			    }
			});
		btnNewButton_2.setIcon(new ImageIcon(LoaiDTForm.class.getResource("/img/delete.png")));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 2;
		loaiDTPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Reset");
		btnNewButton_4.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        xoaForm();
			    }
			});
		btnNewButton_4.setIcon(new ImageIcon(LoaiDTForm.class.getResource("/img/reload.png")));
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_4.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 5;
		gbc_btnNewButton_4.gridy = 2;
		loaiDTPanel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mô tả");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 3;
		loaiDTPanel.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		textField_moTa = new JTextField();
		textField_moTa.setColumns(10);
		GridBagConstraints gbc_textField_moTa = new GridBagConstraints();
		gbc_textField_moTa.insets = new Insets(0, 0, 5, 5);
		gbc_textField_moTa.fill = GridBagConstraints.BOTH;
		gbc_textField_moTa.gridx = 2;
		gbc_textField_moTa.gridy = 3;
		loaiDTPanel.add(textField_moTa, gbc_textField_moTa);
		
		JButton btnNewButton_3 = new JButton("Xuất Excel");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportLoaiDT.xlsx";
				xuatExcel(fileName);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(LoaiDTForm.class.getResource("/img/xuat excel.png")));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_3.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 4;
		gbc_btnNewButton_3.gridy = 3;
		loaiDTPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("Nhập Excel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportLoaiDT.xlsx";
				importExcel(fileName);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(LoaiDTForm.class.getResource("/img/nhap excel.png")));
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_5.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 5;
		gbc_btnNewButton_5.gridy = 3;
		loaiDTPanel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JLabel lblNewLabel_4 = new JLabel("Tìm kiếm: ");
		lblNewLabel_4.setToolTipText("Tìm kiếm");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setBackground(new Color(128, 0, 64));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 6;
		loaiDTPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 String searchText = textField_3.getText().trim();
			        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
			        table_1.setRowSorter(sorter);
			        
			        // ?i: khong quan tam chu thuong hay chu hoa
			        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText)); // áp dụng filter với regular expression
			}
		});
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 6;
		loaiDTPanel.add(textField_3, gbc_textField_3);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã loại", "Tên loại", "Mô tả","Trạng thái"
			}
		));
		table_1.setRowHeight(50);
		table_1.setBounds(1, 25, 922, -2);
		loaiDTPanel.add(table_1);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setEnabled(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 8;
		loaiDTPanel.add(scrollPane, gbc_scrollPane);
		
				updateLDTFromList();
				showMaLDTNext();
	}
	public  void updatePanelSize() {
	    int newWidth = getWidth() - 245;
	    loaiDTPanel.setBounds(245, 54, newWidth, loaiDTPanel.getHeight());
	    lblLoaiDT.setBounds((newWidth - lblLoaiDT.getWidth()) / 2, lblLoaiDT.getY(), lblLoaiDT.getWidth(), lblLoaiDT.getHeight()); // Cập nhật vị trí của label
	}
	
	public JPanel getloaiDTPanel() {
		return loaiDTPanel;
	}
	
	public boolean checkInput() {
		if(this.textField_maLoai.getText().equals("") || this.textField_tenLoai.getText().equals("") || this.textField_moTa.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}
		return true;
	}
	
	public void showMaLDTNext() {
		BUS_LoaiDT busldt = new BUS_LoaiDT();
		textField_maLoai.setEditable(false);
		textField_maLoai.setText(busldt.getMaLDTNext()+"");
	}
	
	public void updateLDTFromList() {
		test.clear();
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.setRowCount(0);

	    BUS_LoaiDT busldt = new BUS_LoaiDT();

	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);

	    for (DTO_LoaiDT ldt : busldt.getlistLoaiDT()) {
	    	String text = null;
	        if (ldt.isCheckExist()) {
	        	text = "<html><font color='green' style='font-weight:bold;'>Tồn tại</font></html>";
	        } else {
	            text = "<html><font color='red' style='font-weight: bold;'>Đã xóa</font></html>";
	        }
//	       if(cv.isCheck_exist()) {
//	    	   model_table.addRow(new Object[] {ldt.getMaLoai()+"",ldt.getTenLoai()+"",ldt.getMoTa()+"",text});
//	       }
	       model_table.addRow(new Object[] {ldt.getMaLoai()+"",ldt.getTenLoai()+"",ldt.getMoTa()+"",text});
	    }
	    xoaForm();
	    int index = 1;
		for (DTO_LoaiDT ldt : busldt.getlistLoaiDT()) {
			test.add(ldt);
//			System.out.println(index+" : "+ldt);
			index++;
		}
	}


	
	public void xoaForm() {
		textField_maLoai.setText("");
		textField_tenLoai.setText("");
		textField_moTa.setText("");
		showMaLDTNext();
	}
	
	public void themLDTVaoTable(DTO_LoaiDT ldt) {
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.addRow(new Object[]{ldt.getMaLoai()+"",ldt.getTenLoai()+"",ldt.getMoTa()+"",ldt.isCheckExist()+""});
	    model_table.fireTableDataChanged();
	    xoaForm();
	    updateLDTFromList();
	}
	
	public void themLDT() {
		 BUS_LoaiDT busldt = new BUS_LoaiDT();
		 boolean result = busldt.addLDTToTable(this.textField_maLoai.getText()+"", this.textField_tenLoai.getText()+"", this.textField_moTa.getText(), true);
		 if (result) {
		        themLDTVaoTable(busldt.getlistLoaiDT().get(busldt.getlistLoaiDT().size() - 1));
		    }else {
		    	JOptionPane.showMessageDialog(null, "Thêm thất bại");
		    }
		    xoaForm();
	}

	public DTO_LoaiDT getLDT() {
		DefaultTableModel model_LDT = (DefaultTableModel) table_1.getModel();
		int index = table_1.getSelectedRow();
		int modelIndex = table_1.convertRowIndexToModel(index);
		String maLDT = (String) model_LDT.getValueAt(modelIndex, 0);
		String tenLDT = (String) model_LDT.getValueAt(modelIndex, 1);
		String moTa = (String) model_LDT.getValueAt(modelIndex, 2);
		
		
		DTO_LoaiDT ldt = new DTO_LoaiDT(maLDT, tenLDT, moTa, true);
		return ldt;
	}
	
	public void suaLDT() {
		int index = table_1.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa");
		}else {
			DTO_LoaiDT ldt = getLDT();
			this.textField_maLoai.setText(ldt.getMaLoai()+"");
			this.textField_tenLoai.setText(ldt.getTenLoai()+"");
			this.textField_moTa.setText(ldt.getMoTa()+"");	
		
		}
	}
	
	public void xoaLDT() {
	    BUS_LoaiDT busldt = new BUS_LoaiDT();
	    int index = table_1.getSelectedRow(); // lay ra dong ma nguoi dung chon
	    if (index == -1) {
	        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
	    } else {
	        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa điện thoại này?");
	        if (luaChon == JOptionPane.YES_OPTION) {
	            DTO_LoaiDT ldt = getLDT();
	            boolean check = busldt.delete(ldt.getMaLoai());
	            if (check) {
//	                model_table.removeRow(index);
	            	ldt.setCheckExist(false);
//	            	System.out.println(dt);
	                updateLDTFromList();
	            }
	            xoaForm();
	        }
	    }
	}
	
	public void xuatExcel(String fileName) {
		updateLDTFromList();
	    try {
	        // Tạo workbook mới
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // Tạo sheet mới trong workbook
	        Sheet sheet = workbook.createSheet("Sheet1");
	        
	        // Tạo header row với tên cột
	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Mã LDT");
	        headerRow.createCell(1).setCellValue("Tên LDT");
	        headerRow.createCell(2).setCellValue("Mô tả");
	        headerRow.createCell(3).setCellValue("Trạng thái");
	        // Duyệt qua danh sách điện thoại và tạo các row và cell tương ứng trên sheet
	        int rowIndex = 1;
	        for (DTO_LoaiDT ldt : test) {
	            Row row = sheet.createRow(rowIndex++);
	            row.createCell(0).setCellValue(ldt.getMaLoai());
	            row.createCell(1).setCellValue(ldt.getTenLoai());
	            row.createCell(2).setCellValue(ldt.getMoTa());
	            row.createCell(3).setCellValue(ldt.isCheckExist());
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
	    for(int i = 1 ; i <= busldt.getlistLoaiDT().size() ; i++) {
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
	            	String lastMaLDT = (String) table_1.getValueAt(rowCount - 1, 0);
	            	System.out.println("From java: "+lastMaLDT);
	            	
	            	int lastRowNum = sheet.getLastRowNum();

	            	// Lấy đối tượng Row của dòng cuối cùng
	            	Row lastRow = sheet.getRow(lastRowNum);

	            	// Lấy giá trị của ô chứa mã NV trong dòng cuối cùng
	            	Cell maLDTCell = lastRow.getCell(0);
	            	Cell tenLDTCell = lastRow.getCell(1);
	            	Cell moTaCell = lastRow.getCell(2);	
	            	
	            	String maLDT = maLDTCell.getStringCellValue();
	            	System.out.println("From excel: "+maLDT);
	            	if(Integer.parseInt(maLDT.substring(3)) - Integer.parseInt(lastMaLDT.substring(3)) == 1 ) {
	            		for(int i = count + 1 ; i <= sheet.getLastRowNum() ; i++) {
		            		XSSFRow excelRow = (XSSFRow) sheet.getRow(i);
		            		XSSFCell ex_maLDT = excelRow.getCell(0);
		            		XSSFCell ex_tenLDT = excelRow.getCell(1);
		            		XSSFCell ex_moTa = excelRow.getCell(2);
		            		XSSFCell ex_trangThai = excelRow.getCell(3);
		            		boolean trangThai = ex_trangThai.getBooleanCellValue();
		            		
		            		boolean check = busldt.addLDTToTable(ex_maLDT.toString(), ex_tenLDT.toString(), ex_moTa.toString(), trangThai);
		            		if(check) {
		            			themLDTVaoTable(busldt.getlistLoaiDT().get(busldt.getlistLoaiDT().size() - 1));
		            		}
		            	}break;
	            	}
	            	else {
	            		JOptionPane.showMessageDialog(null, "Dữ liệu mã loại điện thoại truyền vào không hợp lý");
	            		return;
	            	}
	            }
	            else if(count == sheet.getLastRowNum()) {
	            	DTO_LoaiDT[] ldtArray = new DTO_LoaiDT[sheet.getLastRowNum() + 1];
	            	for(int i = count + 1 ; i <= sheet.getLastRowNum() ; i++) {
	            		XSSFRow excelRow = (XSSFRow) sheet.getRow(i);
	            		XSSFCell ex_maLDT = excelRow.getCell(0);
	            		XSSFCell ex_tenLDT = excelRow.getCell(1);
	            		XSSFCell ex_moTa = excelRow.getCell(2);
	            		XSSFCell ex_trangThai = excelRow.getCell(3);
	            		boolean trangThai = ex_trangThai.getBooleanCellValue();
	            		
	            		DTO_LoaiDT ldt = new DTO_LoaiDT(ex_maLDT.toString(), ex_tenLDT.toString(), ex_moTa.toString(), trangThai);
	            	    ldtArray[i] = ldt;
	            	    if(!ldtArray[i].equals(busldt.getlistLoaiDT().get(i))) {
	            	        busldt.update(ex_maLDT.toString(), ex_tenLDT.toString(), ex_moTa.toString(), trangThai);
	            	    }
	            	}
	            }
	            model_table.addRow(rowData);
	            updateLDTFromList();
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
