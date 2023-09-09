package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.AbstractButton;
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
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.hslf.record.ExMediaAtom;
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

import BUS.BUS_ChitietHD;
import BUS.BUS_Chucvu;
import BUS.BUS_Dienthoai;
import BUS.BUS_Hoadon;
import BUS.BUS_Khachhang;
import BUS.BUS_Nhanvien;
import DTO.DTO_ChitietHD;
import DTO.DTO_Chucvu;
import DTO.DTO_Dienthoai;
import DTO.DTO_Hoadon;
import DTO.DTO_Khachhang;
import DTO.DTO_LoaiDT;
import DTO.DTO_Nhanvien;

import com.toedter.calendar.JDateChooser;

public class HDBanHangForm extends JFrame {

	public JPanel contentPane;
	public JTable table_1;
	public JTextField textField_maHD;
	public JTextField textField_tongTien;
	public JPanel hoaDonPanel;
	public JComboBox comboBox_1;
	public JTextField textField_7;
	public AbstractButton lblNewLabel_5;
	public JLabel label_hoadon;
	public JScrollPane scrollPane_table;
	public ArrayList<JComponent> listComponent = new ArrayList<>();
	public ArrayList<Point> toaDoBanDau = new ArrayList<Point>();
	public ArrayList<DTO_Hoadon> test = new ArrayList<>();
	public JComboBox comboBox_maKH;
	public JComboBox comboBox_maNV;
	public int count = 0;
	public int checkClicked = -1; // nguoi dung chua an nut nao
	private JDateChooser dateChooser;
	BUS_Hoadon bushd = new BUS_Hoadon();
	BUS_Khachhang buskh = new BUS_Khachhang();
	BUS_Nhanvien busnv = new BUS_Nhanvien();
	BUS_Dienthoai busdt = new BUS_Dienthoai();
	BUS_ChitietHD buscthd = new BUS_ChitietHD();
	ExportPDF pdf = new ExportPDF();
	private JPanel panel_1;
	private JTextField textField_2;
	private JDateChooser dateChooser_1_1;
	private JDateChooser dateChooser_1_1_1;
	private JComboBox comboBox;
	private double tong = 0;
	public JTextField txtVn;
	CTHoaDonForm cthdForm = new CTHoaDonForm();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HDBanHangForm frame = new HDBanHangForm();
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
	public HDBanHangForm() {
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
		
		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(265,500));
		contentPane.add(panel_1, BorderLayout.WEST);
		
		hoaDonPanel = new JPanel();
		hoaDonPanel.setBackground(new Color(192, 192, 192));
		hoaDonPanel.setPreferredSize(new Dimension(0,60));
		
		contentPane.add(hoaDonPanel, BorderLayout.CENTER);
		GridBagLayout gbl_hoaDonPanel = new GridBagLayout();
		gbl_hoaDonPanel.columnWidths = new int[]{0, 30, 161, 192, 116, 39, 132, 134};
		gbl_hoaDonPanel.rowHeights = new int[]{0, 73, 44, 48, 46, 47, 46, 46, 0, 0, 38, 0, 0, 0, 239, 0};
		gbl_hoaDonPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0};
		gbl_hoaDonPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		hoaDonPanel.setLayout(gbl_hoaDonPanel);
		
		
		JLabel label_hoadon = new JLabel("QUẢN LÝ HÓA ĐƠN");
		label_hoadon.setHorizontalAlignment(SwingConstants.CENTER);
		label_hoadon.setFont(new Font("Times New Roman", Font.BOLD, 24));
		GridBagConstraints gbc_label_hoadon = new GridBagConstraints();
		gbc_label_hoadon.insets = new Insets(0, 0, 5, 5);
		gbc_label_hoadon.gridwidth = 9;
		gbc_label_hoadon.gridx = 0;
		gbc_label_hoadon.gridy = 1;
		hoaDonPanel.add(label_hoadon, gbc_label_hoadon);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 2;
		hoaDonPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_maHD = new JTextField();
		textField_maHD.setText("");
		textField_maHD.setEditable(false);
		textField_maHD.setColumns(10);
		GridBagConstraints gbc_textField_maHD = new GridBagConstraints();
		gbc_textField_maHD.gridwidth = 2;
		gbc_textField_maHD.insets = new Insets(0, 0, 5, 5);
		gbc_textField_maHD.fill = GridBagConstraints.BOTH;
		gbc_textField_maHD.gridx = 3;
		gbc_textField_maHD.gridy = 2;
		hoaDonPanel.add(textField_maHD, gbc_textField_maHD);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày lập hóa đơn");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 3;
		hoaDonPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 2;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 3;
		gbc_dateChooser.gridy = 3;
		hoaDonPanel.add(dateChooser, gbc_dateChooser);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(HoaDonForm.class.getResource("/img/add.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput()) {
					themHD();
				}
			}
		});
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem = new GridBagConstraints();
		gbc_btnThem.fill = GridBagConstraints.BOTH;
		gbc_btnThem.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem.gridx = 6;
		gbc_btnThem.gridy = 3;
		hoaDonPanel.add(btnThem, gbc_btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(HoaDonForm.class.getResource("/img/sua.png")));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_1.getSelectedRow();
				if(checkClicked != selectedRow) { // neu chon qua nut khac
					count = 0;
				}
				// neu van o cai dong do
				checkClicked = selectedRow;
				count++;
				DTO_Hoadon selectedHD = getHD();
				
				if(selectedHD.isCheck_exist() == true) {
					JOptionPane.showMessageDialog(null, "Hóa đơn này đã được thanh toán rồi, không thể sửa được nữa");
					return;
				}
				if(count % 2 == 0) {
					BUS_Hoadon bushd = new BUS_Hoadon();
					int index = table_1.getSelectedRow();
					if(index == -1) {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					 java.util.Date utilDate = dateChooser.getDate(); // lay ra date trong o input
					 if (utilDate == null) {
				            JOptionPane.showMessageDialog(null, "Test", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				            return;
				     }
					 Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
					 cal.setTime(utilDate); // lay ra thoi gian cua utilDate
					 cal.add(Calendar.DATE, 0);
					 java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
					 java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
					 bushd.update(textField_maHD.getText()+"",sqlDate, Integer.parseInt(txtVn.getText()+""), comboBox_maKH.getSelectedItem()+"", comboBox_maNV.getSelectedItem()+"", false);
					updateHDFromList();
				}else {
					suaHD();
				}
			}
		});
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnSua = new GridBagConstraints();
		gbc_btnSua.fill = GridBagConstraints.BOTH;
		gbc_btnSua.insets = new Insets(0, 0, 5, 5);
		gbc_btnSua.gridx = 7;
		gbc_btnSua.gridy = 3;
		hoaDonPanel.add(btnSua, gbc_btnSua);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng tiền");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 4;
		hoaDonPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtVn = new JTextField();
		txtVn.setEditable(false);
		txtVn.setColumns(10);
		GridBagConstraints gbc_txtVn = new GridBagConstraints();
		gbc_txtVn.gridwidth = 2;
		gbc_txtVn.insets = new Insets(0, 0, 5, 5);
		gbc_txtVn.fill = GridBagConstraints.BOTH;
		gbc_txtVn.gridx = 3;
		gbc_txtVn.gridy = 4;
		hoaDonPanel.add(txtVn, gbc_txtVn);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(HoaDonForm.class.getResource("/img/delete.png")));
		btnXoa.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        xoaHD();
			    }
			});
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnXoa = new GridBagConstraints();
		gbc_btnXoa.fill = GridBagConstraints.BOTH;
		gbc_btnXoa.insets = new Insets(0, 0, 5, 5);
		gbc_btnXoa.gridx = 6;
		gbc_btnXoa.gridy = 4;
		hoaDonPanel.add(btnXoa, gbc_btnXoa);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(HoaDonForm.class.getResource("/img/reload.png")));
		btnReset.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        xoaForm();
		        updateHDFromList();
		        CTHoaDonForm cthd = new CTHoaDonForm();
		        for (DTO_Hoadon hd : test) {
		            cthd.updateHDFromList(hd.getMa_HD() + "");
		            java.util.Date utilDate = hd.getNgayLap_HD();
		            Calendar cal = Calendar.getInstance();
		            cal.setTime(utilDate);
		            cal.add(Calendar.DATE, 2);
		            java.util.Date newUtilDate = cal.getTime();
		            java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime());
		            
		            boolean checkBeforeUpdate = hd.isCheck_exist(); // Trạng thái ban đầu
		            
		            // In giá trị trạng thái ban đầu
		            System.out.println("Trạng thái ban đầu: " + checkBeforeUpdate);
		            
		            bushd.update(hd.getMa_HD() + "", sqlDate, cthd.getTongTien(hd.getMa_HD() + ""), hd.getMa_KH() + "", hd.getMa_NV() + "", hd.isCheck_exist());
		            
		            boolean checkAfterUpdate = hd.isCheck_exist(); // Trạng thái sau khi gọi bushd.update()
		            
		            // In giá trị trạng thái sau khi update
		            System.out.println("Trạng thái sau khi update: " + checkAfterUpdate);
		            break;
		        }
		    }
		});


		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnReset.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.fill = GridBagConstraints.BOTH;
		gbc_btnReset.insets = new Insets(0, 0, 5, 5);
		gbc_btnReset.gridx = 7;
		gbc_btnReset.gridy = 4;
		hoaDonPanel.add(btnReset, gbc_btnReset);
		
		JLabel lblNewLabel_4 = new JLabel("Mã khách hàng");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 5;
		hoaDonPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		comboBox_maKH = new JComboBox();
		comboBox_maKH.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox_maKH = new GridBagConstraints();
		gbc_comboBox_maKH.gridwidth = 2;
		gbc_comboBox_maKH.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_maKH.fill = GridBagConstraints.BOTH;
		gbc_comboBox_maKH.gridx = 3;
		gbc_comboBox_maKH.gridy = 5;
		hoaDonPanel.add(comboBox_maKH, gbc_comboBox_maKH);
		
		JButton btn_chiTiet = new JButton("Chi tiết hóa đơn");
		btn_chiTiet.setIcon(new ImageIcon(HoaDonForm.class.getResource("/img/nhap excel.png")));
		btn_chiTiet.addActionListener((e) -> {
//			updateHDFromList();
		    int index = table_1.getSelectedRow();
		    if (index == -1) {
		        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xem chi tiết hóa đơn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        return;
		    } else {
		        CTHoaDonForm cthd = new CTHoaDonForm();
		        int modelIndex = table_1.convertRowIndexToModel(index);
		        String maHD = (String) table_1.getModel().getValueAt(modelIndex, 0);
		        System.out.println("Mã hóa đơn: " + maHD);

		        for (DTO_Hoadon cthd1 : test) {
		            if (cthd1.getMa_HD().equals(maHD)) {
		                cthd.updateHDFromList(maHD);
		                break;
		            }
		        }

		        cthd.showCurrentMaHD(maHD);
		        cthd.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosing(WindowEvent e) {
		                cthd.setVisible(false);
		            }
		        });
		        cthd.setVisible(true);
		    }
		});
		
		
		
		
				btn_chiTiet.setFont(new Font("Times New Roman", Font.BOLD, 15));
				btn_chiTiet.setBackground(new Color(226, 221, 221));
				GridBagConstraints gbc_btn_chiTiet = new GridBagConstraints();
				gbc_btn_chiTiet.fill = GridBagConstraints.BOTH;
				gbc_btn_chiTiet.insets = new Insets(0, 0, 5, 5);
				gbc_btn_chiTiet.gridx = 6;
				gbc_btn_chiTiet.gridy = 5;
				hoaDonPanel.add(btn_chiTiet, gbc_btn_chiTiet);
		
		
		JLabel lblNewLabel_4_1 = new JLabel("Mã nhân viên");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_4_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1.gridx = 2;
		gbc_lblNewLabel_4_1.gridy = 6;
		hoaDonPanel.add(lblNewLabel_4_1, gbc_lblNewLabel_4_1);
		
		comboBox_maNV = new JComboBox();
		comboBox_maNV.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox_maNV = new GridBagConstraints();
		gbc_comboBox_maNV.gridwidth = 2;
		gbc_comboBox_maNV.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_maNV.fill = GridBagConstraints.BOTH;
		gbc_comboBox_maNV.gridx = 3;
		gbc_comboBox_maNV.gridy = 6;
		hoaDonPanel.add(comboBox_maNV, gbc_comboBox_maNV);
		
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
		
		JLabel lblNewLabel_7 = new JLabel("Ngày lập");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 4;
		gbc_lblNewLabel_7.gridy = 8;
		hoaDonPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Tìm kiếm: ");
		lblNewLabel_6.setToolTipText("Tìm kiếm");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBackground(new Color(128, 0, 64));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 9;
		hoaDonPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 9;
		hoaDonPanel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{111, 0};
		gbl_panel_2.rowHeights = new int[]{26, 20, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Tổng tiền ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tất cả","Dưới 10 triệu","Từ 10 triệu đến 20 triệu","Trên 20 triệu"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		panel_2.add(comboBox, gbc_comboBox);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 3;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 4;
		gbc_panel_4.gridy = 9;
		hoaDonPanel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_3_1 = new JPanel();
		panel_4.add(panel_3_1);
		GridBagLayout gbl_panel_3_1 = new GridBagLayout();
		gbl_panel_3_1.columnWidths = new int[]{0, 0};
		gbl_panel_3_1.rowHeights = new int[]{26, 17, 0};
		gbl_panel_3_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_3_1.setLayout(gbl_panel_3_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Từ ngày");
		GridBagConstraints gbc_lblNewLabel_7_1 = new GridBagConstraints();
		gbc_lblNewLabel_7_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7_1.gridx = 0;
		gbc_lblNewLabel_7_1.gridy = 0;
		panel_3_1.add(lblNewLabel_7_1, gbc_lblNewLabel_7_1);
		
		dateChooser_1_1 = new JDateChooser();
		GridBagConstraints gbc_dateChooser_1_1 = new GridBagConstraints();
		gbc_dateChooser_1_1.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_1_1.gridx = 0;
		gbc_dateChooser_1_1.gridy = 1;
		panel_3_1.add(dateChooser_1_1, gbc_dateChooser_1_1);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_4.add(panel_3_1_1);
		GridBagLayout gbl_panel_3_1_1 = new GridBagLayout();
		gbl_panel_3_1_1.columnWidths = new int[]{0, 0};
		gbl_panel_3_1_1.rowHeights = new int[]{29, 10, 0};
		gbl_panel_3_1_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3_1_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_3_1_1.setLayout(gbl_panel_3_1_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Đến ngày");
		GridBagConstraints gbc_lblNewLabel_7_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_7_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7_1_1.gridx = 0;
		gbc_lblNewLabel_7_1_1.gridy = 0;
		panel_3_1_1.add(lblNewLabel_7_1_1, gbc_lblNewLabel_7_1_1);
		
		dateChooser_1_1_1 = new JDateChooser();
		GridBagConstraints gbc_dateChooser_1_1_1 = new GridBagConstraints();
		gbc_dateChooser_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_1_1_1.gridx = 0;
		gbc_dateChooser_1_1_1.gridy = 1;
		panel_3_1_1.add(dateChooser_1_1_1, gbc_dateChooser_1_1_1);
		
		
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
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 7;
		gbc_textField_2.gridy = 9;
		hoaDonPanel.add(textField_2, gbc_textField_2);
		
		JButton btnTm = new JButton("Tìm");
		btnTm.setIcon(new ImageIcon(HoaDonForm.class.getResource("/img/search.png")));
		btnTm.setSelectedIcon(new ImageIcon(HoaDonForm.class.getResource("/img/search.png")));
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnTm.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnTm.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnTm = new GridBagConstraints();
		gbc_btnTm.fill = GridBagConstraints.BOTH;
		gbc_btnTm.insets = new Insets(0, 0, 5, 0);
		gbc_btnTm.gridx = 9;
		gbc_btnTm.gridy = 9;
		hoaDonPanel.add(btnTm, gbc_btnTm);
		hoaDonPanel.add(table_1);
		JScrollPane scrollPane_table = new JScrollPane(table_1);
		scrollPane_table.setEnabled(false);
		GridBagConstraints gbc_scrollPane_table = new GridBagConstraints();
		gbc_scrollPane_table.gridheight = 3;
		gbc_scrollPane_table.gridwidth = 10;
		gbc_scrollPane_table.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_table.gridx = 0;
		gbc_scrollPane_table.gridy = 12;
		hoaDonPanel.add(scrollPane_table, gbc_scrollPane_table);
		
		
		
		Color customColor = new Color(226, 221, 221);
		ImageIcon iconPDF = new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Graphicloads-Filetype-Pdf.48.png");
		for (DTO_Khachhang kh : buskh.getListKH()) {
			comboBox_maKH.addItem(kh.getMa_KH());
		}
		for (DTO_Nhanvien nv : busnv.getListNV()) {
			comboBox_maNV.addItem(nv.getMaNV());
		}
		

		for (Component c : listComponent) {
		    toaDoBanDau.add(c.getLocation());
		}
		updateHDFromList();
		showMaCVNext();
	}

	public JPanel getHoaDonJPanel() {
		return hoaDonPanel;
	}
	
	public boolean checkInput() {
		if(this.textField_maHD.getText().equals("") || this.dateChooser.equals("") || this.txtVn.getText().equals("") || this.comboBox_maKH.getSelectedIndex() == -1 || this.comboBox_maNV.getSelectedIndex() == -1 ) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}
		try {
			int gia = Integer.parseInt(this.txtVn.getText()+"");
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Tổng tiền phải là kiểu số");
			return false;
		}
		return true;
	}
	
	public void showMaCVNext() {
		BUS_Hoadon bushd = new BUS_Hoadon();
		textField_maHD.setEditable(false);
		textField_maHD.setText(bushd.getMaHDNext()+"");
	}
	
	public void themHDVaoTable(DTO_Hoadon hd) {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.addRow(new Object[]{hd.getMa_HD()+"",hd.getNgayLap_HD()+"",hd.getTongTien()+"",hd.getMa_KH()+"",hd.getMa_NV()+"",hd.isCheck_exist()});
		updateHDFromList();
		xoaForm();
	}
	
	
	public void updateHDFromList() {
		test.clear();
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.setRowCount(0);
	    CTHoaDonForm cthd = new CTHoaDonForm();

	    BUS_Hoadon bushd = new BUS_Hoadon();
	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);
	    for (DTO_Hoadon ldt : bushd.getListHD()) {
	    	test.add(ldt);
	    }
	    for (DTO_Hoadon hd : test) {
	    	cthd.updateHDFromList(hd.getMa_HD()+"");
	    	java.util.Date utilDate = hd.getNgayLap_HD(); // lay ra date trong o input
			 Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
			 cal.setTime(utilDate); // lay ra thoi gian cua utilDate
			 cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
			 java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
			 java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
	       if(!hd.isCheck_exist()) {
	    	   model_table.addRow(new Object[] {hd.getMa_HD()+"",sqlDate,getGiaTienFormatted(cthd.getTongTien(hd.getMa_HD()+"")),hd.getMa_KH()+"",hd.getMa_NV()+"",hd.isCheck_exist()});
	       }

//	       model_table.addRow(new Object[] {hd.getMa_HD()+"",sqlDate,getGiaTienFormatted(cthd.getTongTien(hd.getMa_HD()+"")),hd.getMa_KH()+"",hd.getMa_NV()+"",text});
	    }
	    xoaForm();
	}


	
	public void xoaForm() {
		textField_maHD.setText("");
		txtVn.setText("0");
		comboBox_maKH.setSelectedIndex(-1);
		comboBox_maNV.setSelectedIndex(-1);
		dateChooser.setDate(null);
		showMaCVNext();
	}
	
	public void themHD() {
		 BUS_Hoadon bushd = new BUS_Hoadon();
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 String text = df.format(this.dateChooser.getDate());
		 java.util.Date ngayLap = null;
		 try {
		     ngayLap = (java.util.Date) df.parse(text);
		 } catch (ParseException e) {
		     e.printStackTrace();
		 }

		 java.sql.Date ngayLapSQL = new java.sql.Date(ngayLap.getTime());
		 Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
			cal.setTime(ngayLapSQL); // lay ra thoi gian cua utilDate
			cal.add(Calendar.DATE, 0); // cong them 2 ngay nua de hien thi dung tren jtable
			java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
			java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
		 boolean result = bushd.addHDToTable(this.textField_maHD.getText()+"", sqlDate, Integer.parseInt(this.txtVn.getText()+""), this.comboBox_maKH.getSelectedItem()+"", this.comboBox_maNV.getSelectedItem()+"",false);
		 if (result) {
		        themHDVaoTable(bushd.getListHD().get(bushd.getListHD().size() - 1));
		    }else {
		    	JOptionPane.showMessageDialog(null, "Thêm thất bại");
		    }
		    xoaForm();
	}

	public DTO_Hoadon getHD() {
		DefaultTableModel model_HD = (DefaultTableModel) table_1.getModel();
		int index = table_1.getSelectedRow();
		int modelIndex = table_1.convertRowIndexToModel(index);
		String maHD = (String) model_HD.getValueAt(modelIndex, 0);
		String maKH = (String) model_HD.getValueAt(modelIndex, 3);
		String maNV = (String) model_HD.getValueAt(modelIndex, 4);
	
	    String giaString = (String) model_HD.getValueAt(modelIndex, 2);
	    int indexGia = giaString.indexOf(" VNĐ");
	    String getStringGia = giaString.substring(0, indexGia);
	    getStringGia = getStringGia.replace(",", "");
	    System.out.println(getStringGia);
	    int gia = Integer.parseInt(getStringGia);
	    
	    String ngaySinhStr = (String) model_HD.getValueAt(modelIndex, 1).toString();
	    System.out.println(ngaySinhStr);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date parsedDate = null;
	    try {
	        parsedDate = dateFormat.parse(ngaySinhStr);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    java.sql.Date ngayLap = new java.sql.Date(parsedDate.getTime());
	    
		
		DTO_Hoadon hd = new DTO_Hoadon(maHD, ngayLap, gia, maKH, maNV,false);
		return hd;
	}
	
	public void suaHD() {
		int index = table_1.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa");
		}else {
			DTO_Hoadon hd = getHD();
			this.textField_maHD.setText(hd.getMa_HD()+"");
			this.dateChooser.setDate(hd.getNgayLap_HD());
			this.txtVn.setText(hd.getTongTien()+"");	
			this.comboBox_maKH.setSelectedItem(hd.getMa_KH()+"");	
			this.comboBox_maNV.setSelectedItem(hd.getMa_NV()+"");	
		}
	}
	
	public void xoaHD() {
	    BUS_Hoadon bushd = new BUS_Hoadon();
	    int index = table_1.getSelectedRow(); // lay ra dong ma nguoi dung chon
	    if (index == -1) {
	        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
	    } else {
	        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa điện thoại này?");
	        if (luaChon == JOptionPane.YES_OPTION) {
	            DTO_Hoadon hd = getHD();
	            boolean check = bushd.delete(hd.getMa_HD());
	            if (check) {
//	                model_table.removeRow(index);
	            	hd.setCheck_exist(false);
//	            	System.out.println(dt);
	                updateHDFromList();
	            }
	            xoaForm();
	        }
	    }
	}
	
	public String getGiaTienFormatted(int gia) {
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
	    return formatter.format(gia)+" VNĐ";
	}
	
	public void search() {
		BUS_Hoadon bushd = new BUS_Hoadon();
		
		String text = (String) comboBox.getSelectedItem();
		System.out.println(text);
		ArrayList<DTO_Hoadon> listHoadon = bushd.searchHoaDon(text, dateChooser_1_1,dateChooser_1_1_1);
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.setRowCount(0);
				// Thêm dòng tương ứng vào model cho mỗi nhân viên phù hợp
				for (DTO_Hoadon hd : listHoadon) {
			        if(!hd.isCheck_exist()) {
			        	java.util.Date utilDate = hd.getNgayLap_HD(); // lay ra date trong o input
						 Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
						 cal.setTime(utilDate); // lay ra thoi gian cua utilDate
						 cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
						 java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
						 java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
				        model_table.addRow(new Object[] {hd.getMa_HD()+"",sqlDate,getGiaTienFormatted(Integer.parseInt(hd.getTongTien()+"")),hd.getMa_KH()+"",hd.getMa_NV()+""});
			        }
				}

				// Thiết lập model cho table_1
			table_1.setModel(model_table);
	}
}
