package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartPanel;


import BUS.BUS_Hoadon;
import DTO.DTO_Hoadon;
import DTO.DTO_Khachhang;
import linhtinh.ImageRender;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Point;
import java.awt.Window;

import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.toedter.calendar.JDateChooser;

import java.util.Map;
import java.util.HashMap;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ThongKeForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblQunLThng;
	private JMenuBar menuBar;
	private JMenuItem menuItem;
	private JScrollPane scrollPane;
	public ArrayList<JComponent> listComponent = new ArrayList<>();
	public ArrayList<Point> toaDoBanDau = new ArrayList<Point>();
	public ArrayList<DTO_Hoadon> test = new ArrayList<>();
	private JTable table;
	private JTable table1;
	private Window lblThongKe;
	private BUS_Hoadon BUS_Hoadon;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel thongKePanel;
	private JLabel lblThongKe_1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JComboBox comboBox;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JButton btnHanCao;
	BUS_Hoadon bushd = new BUS_Hoadon();
	private JPanel panel_3;
//	public int tong = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeForm frame = new ThongKeForm();
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
	public ThongKeForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 1185, 884);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(0,60));
		contentPane.add(panel, BorderLayout.NORTH);
		
		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(265,500));
		contentPane.add(panel_1, BorderLayout.WEST);
		
		thongKePanel = new JPanel();
		thongKePanel.setBackground(new Color(192, 192, 192));
		contentPane.add(thongKePanel, BorderLayout.CENTER);
		GridBagLayout gbl_thongKePanel = new GridBagLayout();
		gbl_thongKePanel.columnWidths = new int[]{0, 72, 169, 0, 196, 0, 0, 138, 0, 0};
		gbl_thongKePanel.rowHeights = new int[]{101, 0, 53, 0, 0, 31, 0, 0, 222, 226, 0, 0};
		gbl_thongKePanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_thongKePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		thongKePanel.setLayout(gbl_thongKePanel);
		
		lblThongKe_1 = new JLabel("QUẢN LÝ THỐNG KÊ");
		lblThongKe_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKe_1.setFont(new Font("Arial", Font.BOLD, 24));
		GridBagConstraints gbc_lblThongKe_1 = new GridBagConstraints();
		gbc_lblThongKe_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblThongKe_1.gridwidth = 8;
		gbc_lblThongKe_1.gridx = 0;
		gbc_lblThongKe_1.gridy = 0;
		thongKePanel.add(lblThongKe_1, gbc_lblThongKe_1);
		
		lblNewLabel = new JLabel("Tìm kiếm: ");
		lblNewLabel.setToolTipText("Tìm kiếm");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(128, 0, 64));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		thongKePanel.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		thongKePanel.add(textField, gbc_textField);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 String searchText = textField.getText().trim();
			        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
			        table_1.setRowSorter(sorter);
			        
			        // ?i: khong quan tam chu thuong hay chu hoa
			        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText)); // áp dụng filter với regular expression
			}
		});
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Nhân viên bán hàng nhiều nhất", "Khách hàng mua hàng nhiều nhất", "Hóa đơn có giá trị cao nhất"}));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getItemSelectable() == comboBox && e.getStateChange() == ItemEvent.SELECTED) {
					String selectedItem = (String) comboBox.getSelectedItem();
					System.out.println(selectedItem);
					if(selectedItem.equals("Nhân viên bán hàng nhiều nhất")) {
						nhanVienMax();
					}else if(selectedItem.equals("Khách hàng mua hàng nhiều nhất")) {	
						khachHangMax();
					}else if(selectedItem.equals("Hóa đơn có giá trị cao nhất")){
						timTongTienMax();
					} 
						
				}
				
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 2;
		thongKePanel.add(comboBox, gbc_comboBox);
		
		btnNewButton_1 = new JButton("Tổng doanh thu");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\HK2-N2\\JAVA\\DoAnJava\\src\\img\\icon-doanh-thu (1).png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tongDoanhThu();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 2;
		thongKePanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã hóa đơn", "Ngày lập hóa đơn", "Tổng tiền", "Mã khách hàng","Mã nhân viên"
			}
		));
		table_1.setRowHeight(50);
		table_1.setBounds(1, 25, 922, -2);
		table_1.setDefaultEditor(Object.class, null);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 3;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 7;
		gbc_panel_3.gridy = 1;
		thongKePanel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		btnHanCao = new JButton("Thống kê hóa đơn");
		GridBagConstraints gbc_btnHanCao = new GridBagConstraints();
		gbc_btnHanCao.fill = GridBagConstraints.BOTH;
		gbc_btnHanCao.insets = new Insets(0, 0, 5, 0);
		gbc_btnHanCao.gridwidth = 2;
		gbc_btnHanCao.gridx = 0;
		gbc_btnHanCao.gridy = 1;
		panel_3.add(btnHanCao, gbc_btnHanCao);
		btnHanCao.setForeground(new Color(255, 255, 255));
		btnHanCao.setBackground(new Color(0, 128, 255));
		btnHanCao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		        ArrayList<DTO_Hoadon> listHD = bushd.getListHD();
		        for (DTO_Hoadon hd : listHD) {
		        	if(hd.isCheck_exist()) {
		            dataset.addValue(hd.getTongTien(), "Tổng tiền", hd.getMa_HD());
		        }
		        }
		        JFreeChart chart = ChartFactory.createBarChart(
		            "Thống kê hóa đơn", "Mã hóa đơn", "Giá tiền",
		            dataset, PlotOrientation.VERTICAL, false, true, false);
		        ChartFrame frame = new ChartFrame("Chart", chart);
		        frame.setVisible(true);
		        frame.setSize(800, 500);
				frame.setLocationRelativeTo(null);

			}
		});
		
		btnNewButton_2 = new JButton("Thống kê nhân viên");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.gridwidth = 2;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		panel_3.add(btnNewButton_2, gbc_btnNewButton_2);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 128, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultCategoryDataset dataset = new DefaultCategoryDataset(); // khoi tao dataset dua vao chart
				ArrayList<DTO_Hoadon> listHD = bushd.getListHD();
				Map<String, Map<String, Double>> salesByEmployeeAndMonth = new HashMap<>(); // tao 1 map de chua thong tinh doanh so cua nhan vien trong 1 thang
				for (DTO_Hoadon hd : listHD) {
					if(hd.isCheck_exist()) {
				    Calendar cal = Calendar.getInstance();
				    cal.setTime(hd.getNgayLap_HD());
				    String thang = Integer.toString(cal.get(Calendar.MONTH) + 1); // calendar chi tra ve 0-11 nen phai + 1 moi ra 12 thang
				    String maNV = hd.getMa_NV();
				    double tongTien = hd.getTongTien();
				    if (salesByEmployeeAndMonth.containsKey(thang)) { // kiem tra xem salesByEmployeeAndMonth co chua key thang hay chua
				        Map<String, Double> salesByEmployee = salesByEmployeeAndMonth.get(thang); // neu co thi lay map con ben trong tuong ung voi key thang do
				        if (salesByEmployee.containsKey(maNV)) { // neu co chua key maNV thi cap nhat doanh thu len
				        	tongTien += salesByEmployee.get(maNV);
				        }
				        salesByEmployee.put(maNV, tongTien); // cap nhat thong tin moi 
				    } else {
				        Map<String, Double> salesByEmployee = new HashMap<>(); // con neu chua co thi thi tao 1 map moi
				        salesByEmployee.put(maNV, tongTien); //cap nhat thong tin doanh thu va ma nhan vien
				        salesByEmployeeAndMonth.put(thang, salesByEmployee); // cap nhat thong tin
				    }
				}
				}
				for (Map.Entry<String, Map<String, Double>> entry : salesByEmployeeAndMonth.entrySet()) {
				    String thang = entry.getKey();
				    Map<String, Double> salesByEmployee = entry.getValue();
				    for (Map.Entry<String, Double> employeeEntry : salesByEmployee.entrySet()) {
				        String maNV = employeeEntry.getKey();
				        double tongTien = employeeEntry.getValue();
				        dataset.addValue(tongTien, "Nhân viên " + maNV, thang);
				    }
				}
				JFreeChart chart = ChartFactory.createBarChart(
				    "Thống kê nhân viên", "Tháng", "Doanh số",
				    dataset, PlotOrientation.VERTICAL, true, true, false);
				ChartFrame frame = new ChartFrame("Biểu đồ", chart);
				frame.setVisible(true);
				frame.setSize(800, 500);
				frame.setLocationRelativeTo(null);
			}
		});
		
		btnNewButton = new JButton("Thống kê khách hàng");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		panel_3.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				ArrayList<DTO_Hoadon> listHD = bushd.getListHD();
				Map<String, Map<String, Double>> salesByEmployeeAndMonth = new HashMap<>();
				for (DTO_Hoadon hd : listHD) {
					if(hd.isCheck_exist()) {
				    Calendar cal = Calendar.getInstance();
				    cal.setTime(hd.getNgayLap_HD());
				    String thang = Integer.toString(cal.get(Calendar.MONTH) + 1);
				    String maNV = hd.getMa_KH();
				    double tongTien = hd.getTongTien();
				    if (salesByEmployeeAndMonth.containsKey(thang)) {
				        Map<String, Double> salesByEmployee = salesByEmployeeAndMonth.get(thang);
				        if (salesByEmployee.containsKey(maNV)) {
				        	tongTien += salesByEmployee.get(maNV);
				        }
				        salesByEmployee.put(maNV, tongTien);
				    } else {
				        Map<String, Double> salesByEmployee = new HashMap<>();
				        salesByEmployee.put(maNV, tongTien);
				        salesByEmployeeAndMonth.put(thang, salesByEmployee);
				    }
				}
				}
				for (Map.Entry<String, Map<String, Double>> entry : salesByEmployeeAndMonth.entrySet()) {
				    String thang = entry.getKey();
				    Map<String, Double> salesByEmployee = entry.getValue();
				    for (Map.Entry<String, Double> employeeEntry : salesByEmployee.entrySet()) {
				        String maNV = employeeEntry.getKey();
				        double tongTien = employeeEntry.getValue();
				        dataset.addValue(tongTien, " Khách hàng  " + maNV, thang);
				    }
				}
				JFreeChart chart = ChartFactory.createBarChart(
				    "Thống kê khách hàng", "Tháng", "Doanh số",
				    dataset, PlotOrientation.VERTICAL, true, true, false);
				ChartFrame frame = new ChartFrame("Biểu đồ", chart);
				frame.setVisible(true);
				frame.setSize(800, 500);
				frame.setLocationRelativeTo(null);

			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 255));
		thongKePanel.add(table_1);
		
		
		scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setEnabled(false);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 4;
		gbc_scrollPane_1.gridwidth = 9;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 7;
		thongKePanel.add(scrollPane_1, gbc_scrollPane_1);
		

		
		updateTKFromList();

		
	}

	public JPanel getThongKePanel() {
		// TODO Auto-generated method stub
		return thongKePanel;
	}
	
	public String getGiaTienFormatted(int gia) {
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
	    return formatter.format(gia)+" VNĐ";
	}


	public void updateTKFromList() {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.setRowCount(0);

	    BUS_Hoadon bushd = new BUS_Hoadon();

	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);

	    for (DTO_Hoadon hd : bushd.getListHD()) {
	    	if(hd.isCheck_exist()) {
		    	   model_table.addRow(new Object[] {hd.getMa_HD()+"",hd.getNgayLap_HD()+"",getGiaTienFormatted(Integer.parseInt(hd.getTongTien()+"")),hd.getMa_KH()+"",hd.getMa_NV()+"",hd.isCheck_exist()});
		       }
//	       model_table.addRow(new Object[] {hd.getMa_HD()+"",hd.getNgayLap_HD()+"",hd.getTongTien()+"",hd.getMa_KH()+"",hd.getMa_NV()+""});
	    }
	}
	
	public void themTKVaoTable(DTO_Hoadon hd) {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.addRow(new Object[]{hd.getMa_HD()+"",hd.getNgayLap_HD()+"",hd.getTongTien()+"",hd.getMa_KH()+"",hd.getMa_NV()+""});
		updateTKFromList();
	}
	
	public void tongDoanhThu() {
		int tong = 0;
		BUS_Hoadon = new BUS_Hoadon();
		for (DTO_Hoadon hd : BUS_Hoadon.getListHD()) {
			if(hd.isCheck_exist()) {
				tong += hd.getTongTien();	
				System.out.println("Test:" +tong);
			}
		}
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		String formattedTong = formatter.format(tong);
		JOptionPane.showMessageDialog(null, "Tổng doanh thu là: "+formattedTong + " VNĐ");
	
}
	public void nhanVienMax() {
		BUS_Hoadon bushd = new BUS_Hoadon();
		Map<String, Double> revenueByEmployee = new HashMap<>();
		for (DTO_Hoadon hd : bushd.getListHD()) {
		    if (hd.isCheck_exist()) {
		        String maNV = hd.getMa_NV();
		        double tong = hd.getTongTien();
		        if (revenueByEmployee.containsKey(maNV)) {
		        	tong += revenueByEmployee.get(maNV);
		        }
		        revenueByEmployee.put(maNV, tong);
		    }
		}
		String maNVMax = null;
		double tong = Double.MIN_VALUE;
		for (Map.Entry<String, Double> entry : revenueByEmployee.entrySet()) {
		    if (entry.getValue() > tong) {
		        maNVMax = entry.getKey();
		        tong = entry.getValue();
		    }
		}
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		String formattedTong = formatter.format(tong);
		JOptionPane.showMessageDialog(null, " Nhân viên bán hàng nhiều nhất: "+maNVMax+" với số tiền "+formattedTong+" VNĐ ");

	}
	public void khachHangMax() {
		BUS_Hoadon bushd = new BUS_Hoadon();
		Map<String, Double> revenueByEmployee = new HashMap<>(); // luu tru tong doanh thu cua moi nhan vien
		for (DTO_Hoadon hd : bushd.getListHD()) {
		    if (hd.isCheck_exist()) {
		        String maKH = hd.getMa_KH();
		        double tong = hd.getTongTien();
		        if (revenueByEmployee.containsKey(maKH)) { // neu revenueByEmoyee da chua ma kh nay roi
		            tong += revenueByEmployee.get(maKH);
		        }
		        revenueByEmployee.put(maKH, tong); // thi tang tong doanh thu ma kh nay len
		    }
		}
		String maKHMax = null;
		double tong = Double.MIN_VALUE;
		for (Map.Entry<String, Double> entry : revenueByEmployee.entrySet()) { // duyet cac cap khoa va gia tri trong map va so sanh doanh thu
		    if (entry.getValue() > tong) { // so sanh gia tri doanh thu cap khoa voi doanh thu hien tai 
		    	maKHMax = entry.getKey();	// neu lon hon cap nhat gia tri doanh thu toi da va ma so nhan vien tuong ung
		        tong = entry.getValue();
		    }
		}
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		String formattedTong = formatter.format(tong);
		JOptionPane.showMessageDialog(null, " Khách hàng mua hàng nhiều nhất: "+maKHMax+" với số tiền "+formattedTong+" VNĐ ");
	}
	public void timTongTienMax() {
	    BUS_Hoadon bushd = new BUS_Hoadon();
	    int maxIndex = -1;
	    int maxTongTien = 0;
	    for (int i = 0; i < bushd.getListHD().size(); i++) {
	        DTO_Hoadon hd = bushd.getListHD().get(i);	        
	        if (hd.isCheck_exist() && hd.getTongTien() > maxTongTien) {
	            maxIndex = i; 
	            maxTongTien = hd.getTongTien();
	        }
	    }
	    
	    if (maxIndex != -1) {
	        String maHD = bushd.getListHD().get(maxIndex).getMa_HD();
	        DecimalFormat formatter = new DecimalFormat("###,###,###");
			String formattedTong = formatter.format(maxTongTien);
	        JOptionPane.showMessageDialog(null, "Khách hàng có hóa đơn có tổng tiền lớn nhất: "+ maHD +" với số tiền là " + formattedTong+" VNĐ ");
	    } 
	}
}

