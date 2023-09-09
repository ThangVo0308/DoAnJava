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
import java.awt.event.KeyListener;
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
import java.util.Locale;

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
import BUS.BUS_PhieuBH;
import DTO.DTO_Chucvu;
import DTO.DTO_Hoadon;
import DTO.DTO_PhieuBH;

import com.toedter.calendar.JDateChooser;

public class PhieuBHForm extends JFrame {

	private JPanel contentPane;
	private JPanel PhieuBHPanel;
	private JTable table_1;
	private JTextField textField_maBH;
	private JTextField textField_tenCH;
	private JTextField textField_diaChi;
	private JLabel lblNewLabel_3_1;
	private JTextField textField_6;
	private JLabel lblQunLPhiu;
	private JScrollPane scrollPane;
	public ArrayList<JComponent> listComponent = new ArrayList<>();
	public ArrayList<Point> toaDoBanDau = new ArrayList<Point>();
	private JDateChooser dateChooser;
	private JComboBox comboBox_1;
	BUS_PhieuBH busbh = new BUS_PhieuBH();
	private int month;
	private JTextField textField_hetHan;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuBHForm frame = new PhieuBHForm();
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
	public PhieuBHForm() {
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
		
		PhieuBHPanel = new JPanel();
		PhieuBHPanel.setBackground(new Color(192, 192, 192));
		contentPane.add(PhieuBHPanel, BorderLayout.CENTER);
		GridBagLayout gbl_PhieuBHPanel = new GridBagLayout();
		gbl_PhieuBHPanel.columnWidths = new int[]{0, 182, 286, 83, 127, 149, 0, 0};
		gbl_PhieuBHPanel.rowHeights = new int[]{73, 50, 52, 52, 53, 47, 46, 0, 0, 48, 0, 0, 234, 0, 0};
		gbl_PhieuBHPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_PhieuBHPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		PhieuBHPanel.setLayout(gbl_PhieuBHPanel);
		
		JLabel lblQunLPhiu = new JLabel("QUẢN LÝ PHIẾU BẢO HÀNH");
		lblQunLPhiu.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLPhiu.setFont(new Font("Arial", Font.BOLD, 24));
		GridBagConstraints gbc_lblQunLPhiu = new GridBagConstraints();
		gbc_lblQunLPhiu.insets = new Insets(0, 0, 5, 5);
		gbc_lblQunLPhiu.gridwidth = 7;
		gbc_lblQunLPhiu.gridx = 0;
		gbc_lblQunLPhiu.gridy = 0;
		PhieuBHPanel.add(lblQunLPhiu, gbc_lblQunLPhiu);
		
		JLabel lblNewLabel_1 = new JLabel("Mã BH");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		PhieuBHPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_maBH = new JTextField();
		textField_maBH.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		PhieuBHPanel.add(textField_maBH, gbc_textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên cửa hàng");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 2;
		PhieuBHPanel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		textField_tenCH = new JTextField();
		textField_tenCH.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		PhieuBHPanel.add(textField_tenCH, gbc_textField_1);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput()) {
					themPH();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(PhieuBHForm.class.getResource("/img/add.png")));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 2;
		PhieuBHPanel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			       xoaPH();
			    }
			});
		btnNewButton_2.setIcon(new ImageIcon(PhieuBHForm.class.getResource("/img/delete.png")));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 2;
		PhieuBHPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 3;
		PhieuBHPanel.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		textField_diaChi = new JTextField();
		textField_diaChi.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		PhieuBHPanel.add(textField_diaChi, gbc_textField_2);
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               xoaForm();
            }
        });
		
		JButton btnNewButton_4 = new JButton("Xuất Excel");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportPhieuBH.xlsx";
				xuatExcel(busbh.getlistPBH(), fileName);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(PhieuBHForm.class.getResource("/img/xuat excel.png")));
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_4.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 3;
		PhieuBHPanel.add(btnNewButton_4, gbc_btnNewButton_4);
		btnNewButton_3.setIcon(new ImageIcon(PhieuBHForm.class.getResource("/img/reload.png")));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_3.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 3;
		PhieuBHPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ngày bán");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3.gridx = 1;
		gbc_lblNewLabel_1_3.gridy = 4;
		PhieuBHPanel.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 4;
		PhieuBHPanel.add(dateChooser, gbc_dateChooser);
		
		JLabel lblNewLabel_1_4 = new JLabel("Thời gian BH");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_4 = new GridBagConstraints();
		gbc_lblNewLabel_1_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_4.gridx = 1;
		gbc_lblNewLabel_1_4.gridy = 5;
		PhieuBHPanel.add(lblNewLabel_1_4, gbc_lblNewLabel_1_4);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				updateTextField();
				
			}
		});
		comboBox_1.addItem("3 thang");
		comboBox_1.addItem("6 thang");
		comboBox_1.addItem("12 thang");
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 5;
		PhieuBHPanel.add(comboBox_1, gbc_textField_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Ngày hết hạn");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_5 = new GridBagConstraints();
		gbc_lblNewLabel_1_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_5.gridx = 1;
		gbc_lblNewLabel_1_5.gridy = 6;
		PhieuBHPanel.add(lblNewLabel_1_5, gbc_lblNewLabel_1_5);
		
		textField_hetHan = new JTextField();
		textField_hetHan.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.BOTH;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 6;
		PhieuBHPanel.add(textField_hetHan, gbc_textField_5);
		
		JLabel lblNewLabel_5 = new JLabel("Tìm kiếm: ");
		lblNewLabel_5.setToolTipText("Tìm kiếm");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_5.setBackground(new Color(128, 0, 64));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 9;
		PhieuBHPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
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
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.BOTH;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 9;
		PhieuBHPanel.add(textField_6, gbc_textField_6);
		
		JButton btnTm = new JButton("Tìm");
		btnTm.setIcon(new ImageIcon(PhieuBHForm.class.getResource("/img/search.png")));
		btnTm.setFont(new Font("Arial", Font.BOLD, 14));
		btnTm.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnTm = new GridBagConstraints();
		gbc_btnTm.fill = GridBagConstraints.BOTH;
		gbc_btnTm.insets = new Insets(0, 0, 5, 5);
		gbc_btnTm.gridx = 4;
		gbc_btnTm.gridy = 9;
		PhieuBHPanel.add(btnTm, gbc_btnTm);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã BH", "Tên cửa hàng", "Địa chỉ", "Ngày bán","Thời gian BH","Ngày hết hạn","Trạng thái"
			}
		));
		table_1.setRowHeight(50);
		table_1.setBounds(1, 25, 922, -2);
		table_1.setDefaultEditor(Object.class, null);
		PhieuBHPanel.add(table_1);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setEnabled(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 8;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 11;
		PhieuBHPanel.add(scrollPane, gbc_scrollPane);
		
		Color customColor = new Color(226, 221, 221);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm: ");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\HK2-N2\\JAVA\\DoAnJava (1)\\src\\img\\search.png"));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(128, 0, 64));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setToolTipText("Tìm kiếm");
		lblNewLabel.setBounds(87, 392, 132, 35);	
		updatePHFromList();
		showMaBHNext();
	}
	public  void updatePanelSize() {
	    int newWidth = getWidth() - 245;
	    PhieuBHPanel.setBounds(245, 54, newWidth, PhieuBHPanel.getHeight());
	    lblQunLPhiu.setBounds((newWidth - lblQunLPhiu.getWidth()) / 2, lblQunLPhiu.getY(), lblQunLPhiu.getWidth(), lblQunLPhiu.getHeight()); // Cập nhật vị trí của label
	}
	
	public boolean checkInput() {
		if(this.textField_maBH.getText().equals("") || this.textField_tenCH.getText().equals("") || this.textField_diaChi.getText().equals("") || this.dateChooser.getDate().equals("") || this.comboBox_1.getSelectedIndex() == -1 || this.textField_hetHan.getText().equals("")) {
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
		        JOptionPane.showMessageDialog(null, "Ngày nhập không được lớn hơn ngày hiện tại.");
		        return false;
		    }

		return true;
	}
	
	public JPanel getBHJPanel() {
		return PhieuBHPanel;
	}
	
	private java.sql.Date updateTextField() {
	    java.util.Date dateBan = dateChooser.getDate();
	    String selectedItem = (String) comboBox_1.getSelectedItem();
//	    System.out.println(selectedItem);
	    if (dateBan != null && selectedItem != null) {
	        int month = Integer.parseInt(selectedItem.split(" ")[0]);
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(dateBan);
	        cal.add(Calendar.MONTH, month);

	        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	        textField_hetHan.setText(dateFormat.format(cal.getTime()));
	        
	        return new java.sql.Date(cal.getTime().getTime());
	    }
	    return null;
	}
	
	public void showMaBHNext() {
		BUS_PhieuBH busbh = new BUS_PhieuBH();
		textField_maBH.setEditable(false);
		textField_tenCH.setEditable(false);
		textField_hetHan.setEditable(false);
		textField_tenCH.setText("HANDPHONE");
		textField_maBH.setText(busbh.getmaPBHNext()+"");
	}
	
	public void themPHVaoTable(DTO_PhieuBH ph) {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.addRow(new Object[]{ph.getMa_BH()+"",ph.getTen_BH()+"",ph.getDiaChi()+"",ph.getNgay_banHang()+"",ph.getTG_baoHanh()+"",ph.getNgay_Het_Han()+"",ph.isCheck_exist()+""});
		updatePHFromList();
		xoaForm();
	}
	
	public void updatePHFromList() {
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.setRowCount(0);

	    BUS_PhieuBH busph = new BUS_PhieuBH();

	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);

	    for (DTO_PhieuBH ph : busph.getlistPBH()) {
	    	System.out.println(ph);
			 java.util.Date utilDate = ph.getNgay_banHang(); // lay ra date trong o input
			 Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
			 cal.setTime(utilDate); // lay ra thoi gian cua utilDate
			 cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
			 java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
			 java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
			 
			 java.util.Date utilDateHethan = ph.getNgay_Het_Han(); // lay ra date trong o input
			 Calendar cal1 = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
			 cal1.setTime(utilDateHethan); // lay ra thoi gian cua utilDate
			 cal1.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
			 java.util.Date newUtilDateHetHan = cal1.getTime(); // lay ra thoi gian sau khi cong 2 ngay
			 java.sql.Date sqlDateHetHan = new java.sql.Date(newUtilDateHetHan.getTime()); // ep ve kieu sql.Date
			 System.out.println("test: "+sqlDateHetHan);
			 
			 
	    	String text = null;
	        if (ph.isCheck_exist()) {
	        	text = "<html><font color='green' style='font-weight:bold;'>Còn hiệu lực</font></html>";
	        } else {
	            text = "<html><font color='red' style='font-weight: bold;'>Hết hạn</font></html>";
	        }
	       if(ph.isCheck_exist()) {
	    	   model_table.addRow(new Object[] {ph.getMa_BH()+"",ph.getTen_BH()+"",ph.getDiaChi()+"",sqlDate,ph.getTG_baoHanh()+"",sqlDateHetHan,text});
	       }
//	       model_table.addRow(new Object[] {ph.getMa_BH()+"",ph.getTen_BH()+"",ph.getDiaChi()+"",ph.getNgay_banHang()+"",ph.getTG_baoHanh()+"",ph.getNgay_Het_Han()+"",text});
	    }

	    xoaForm();
	}
	
	public void xoaForm() {
		textField_maBH.setText("");
		textField_tenCH.setText("");
		textField_diaChi.setText("");
		dateChooser.setDate(null);
		comboBox_1.setSelectedIndex(-1);
		textField_hetHan.setText("");
		showMaBHNext();
	}
	
	public void themPH() {
		BUS_PhieuBH busbh = new BUS_PhieuBH();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 String text = df.format(this.dateChooser.getDate());
		 System.out.println(text);
		java.util.Date ngayBan = null;
		 try {
		     ngayBan = (java.util.Date) df.parse(text);
		 } catch (ParseException e) {
		     e.printStackTrace();
		 }

		 java.sql.Date ngayBanSQL = new java.sql.Date(ngayBan.getTime());
		 Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
			cal.setTime(ngayBanSQL); // lay ra thoi gian cua utilDate
			cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
			java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
			java.sql.Date sqlDateBan = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
			
			
			String dateString = textField_hetHan.getText();

			// Chuyển chuỗi thành đối tượng Date
			java.util.Date date;
			try {
				date = (java.util.Date) new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH).parse(dateString);
			} catch (ParseException e) {
			    e.printStackTrace();
			    return;
			}

			// Tạo đối tượng JDateChooser và đặt ngày cho nó
			JDateChooser dateChooser = new JDateChooser(date);
			String text1 = df.format(dateChooser.getDate());
			System.out.println(text1);
			java.util.Date ngayHetHan = null;
			 try {
			     ngayHetHan = (java.util.Date) df.parse(text1);
			 } catch (ParseException e) {
			     e.printStackTrace();
			 }
		 
			 java.sql.Date ngayHetHanSQL = new java.sql.Date(ngayHetHan.getTime());
			 Calendar cal1 = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
				cal1.setTime(ngayHetHanSQL); // lay ra thoi gian cua utilDate
				cal1.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
				java.util.Date newUtilDate1 = cal1.getTime(); // lay ra thoi gian sau khi cong 2 ngay
				java.sql.Date sqlDateHetHan = new java.sql.Date(newUtilDate1.getTime()); // ep ve kieu sql.Date
			
		 boolean result = busbh.addBHToTable(this.textField_maBH.getText()+"", this.textField_tenCH.getText()+"", this.textField_diaChi.getText(), sqlDateBan, this.comboBox_1.getSelectedItem()+"", sqlDateHetHan, true);
		 if (result) {
		        themPHVaoTable(busbh.getlistPBH().get(busbh.getlistPBH().size() - 1));
		    }else {
		    	JOptionPane.showMessageDialog(null, "Thêm thất bại");
		    }
		    xoaForm();
	}

	public DTO_PhieuBH getPH() {
		DefaultTableModel model_CV = (DefaultTableModel) table_1.getModel();
		int index = table_1.getSelectedRow();
		int modelIndex = table_1.convertRowIndexToModel(index);
		String maPH = (String) model_CV.getValueAt(modelIndex, 0);
		String tenCH = (String) model_CV.getValueAt(modelIndex, 1);
		String diaChi = (String) model_CV.getValueAt(modelIndex, 2);
		String ngayBan = ((java.sql.Date)model_CV.getValueAt(modelIndex, 3)).toString();	
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(ngayBan);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date ngayBanReal = new java.sql.Date(parsedDate.getTime());
		
		String tgBaoHanh = (String) model_CV.getValueAt(index, 4);
		String ngayHetHan = ((java.sql.Date)model_CV.getValueAt(modelIndex, 5)).toString();
		
		java.util.Date parsedDate1 = null;
		try {
			parsedDate1 = dateFormat.parse(ngayHetHan);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date ngayHetHanReal = new java.sql.Date(parsedDate1.getTime());
		
		DTO_PhieuBH bh = new DTO_PhieuBH(maPH, tenCH, diaChi, ngayBanReal, tgBaoHanh, ngayHetHanReal, true);
		return bh;
	}
	
	public void suaPH() {
		int index = table_1.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa");
		}else {
			DTO_PhieuBH ph = getPH();
			this.textField_maBH.setText(ph.getMa_BH()+"");
			this.textField_tenCH.setText(ph.getTen_BH()+"");
			this.textField_diaChi.setText(ph.getDiaChi()+"");	
			this.dateChooser.setDate(ph.getNgay_banHang());
			this.comboBox_1.setSelectedItem(ph.getTG_baoHanh()+"");
			this.textField_hetHan.setText(ph.getNgay_Het_Han()+"");	
		}
	}
	
	public void xoaPH() {
	    BUS_PhieuBH busbh = new BUS_PhieuBH();
	    int index = table_1.getSelectedRow(); // lay ra dong ma nguoi dung chon
	    if (index == -1) {
	        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
	    } else {
	        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa điện thoại này?");
	        if (luaChon == JOptionPane.YES_OPTION) {
	            DTO_PhieuBH ph = getPH();
	            boolean check = busbh.delete(ph.getMa_BH());
	            if (check) {
//	                model_table.removeRow(index);
	            	ph.setCheck_exist(false);
//	            	System.out.println(dt);
	                updatePHFromList();
	            }
	            xoaForm();
	        }
	    }
	}
	
	
	public void xuatExcel(ArrayList<DTO_PhieuBH> dsBH, String fileName) {
	    try {
	        // Tạo workbook mới
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // Tạo sheet mới trong workbook
	        Sheet sheet = workbook.createSheet("Sheet1");
	        
	        // Tạo header row với tên cột
	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Mã BH");
	        headerRow.createCell(1).setCellValue("Tên cửa hàng");
	        headerRow.createCell(2).setCellValue("Địa chỉ");
	        headerRow.createCell(3).setCellValue("Ngày bán hàng");
	        headerRow.createCell(4).setCellValue("Thời gian bảo hành");
	        headerRow.createCell(5).setCellValue("Ngày hết hàn");
	        headerRow.createCell(6).setCellValue("Trạng thái");
	        
	        // Duyệt qua danh sách điện thoại và tạo các row và cell tương ứng trên sheet
	        int rowIndex = 1;
	        for (DTO_PhieuBH ph : dsBH) {
	            Row row = sheet.createRow(rowIndex++);
	            row.createCell(0).setCellValue(ph.getMa_BH());
	            row.createCell(1).setCellValue(ph.getTen_BH());
	            row.createCell(2).setCellValue(ph.getDiaChi());
	            row.createCell(3).setCellValue(ph.getNgay_banHang());
	            Cell ngayBanCell = row.createCell(3);
	            if (ph.getNgay_banHang() != null) {
	                java.util.Date ngayNhap = ph.getNgay_banHang();
	                ngayBanCell.setCellValue(new java.text.SimpleDateFormat("dd/MM/yyyy").format(ngayNhap));
	            } else {
	            	ngayBanCell.setCellValue("");
	            }
	            row.createCell(4).setCellValue(ph.getTG_baoHanh());
	            row.createCell(5).setCellValue(ph.getNgay_Het_Han());
	            Cell ngayHetHanCell = row.createCell(5);
	            if (ph.getNgay_banHang() != null) {
	                java.util.Date ngayHetHan = ph.getNgay_Het_Han();
	                ngayHetHanCell.setCellValue(new java.text.SimpleDateFormat("dd/MM/yyyy").format(ngayHetHan));
	            } else {
	            	ngayHetHanCell.setCellValue("");
	            }
	            row.createCell(6).setCellValue(ph.isCheck_exist());
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
	
}
