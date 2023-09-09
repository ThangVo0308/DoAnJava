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
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

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
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.BUS_ChitietPN;
import BUS.BUS_Chucvu;
import BUS.BUS_Dienthoai;
import BUS.BUS_NhaPP;
import BUS.BUS_Phieunhap;
import DTO.DTO_ChitietHD;
import DTO.DTO_ChitietPN;
import DTO.DTO_Chucvu;
import DTO.DTO_Dienthoai;
import DTO.DTO_Hoadon;
import DTO.DTO_LoaiDT;
import DTO.DTO_NhaPP;
import DTO.DTO_Phieunhap;
import com.toedter.calendar.JDateChooser;

public class PhieuNhapForm extends JFrame {

	public JPanel contentPane;
	public JPanel phieuNhapPanel;
	public JLabel lblQunLPhiu;
	public JTable table_1;
	public JScrollPane scrollPane;
	public JTextField textField_maPN;
	public JTextField textField_4;
	public ArrayList<JComponent> listComponent = new ArrayList<>();
	public ArrayList<Point> toaDoBanDau = new ArrayList<Point>();
	public ArrayList<DTO_Phieunhap> test = new ArrayList<>();
	private JComboBox comboBox_maNPP;
	private JTextField textField_gia;
	private JDateChooser dateChooser;
	BUS_Dienthoai busdt = new BUS_Dienthoai();
	BUS_Phieunhap buspn = new BUS_Phieunhap();
	BUS_NhaPP busnpp = new BUS_NhaPP();
	BUS_ChitietPN busctpn = new BUS_ChitietPN();
	public int count = 0;
	public int checkClicked = -1; // nguoi dung chua an nut nao
	private JTextField textField_1;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuNhapForm frame = new PhieuNhapForm();
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
	public PhieuNhapForm() {
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
		
		phieuNhapPanel =  new JPanel();
		phieuNhapPanel.setBackground(new Color(192, 192, 192));
		contentPane.add(phieuNhapPanel, BorderLayout.CENTER);
		GridBagLayout gbl_phieuNhapPanel = new GridBagLayout();
		gbl_phieuNhapPanel.columnWidths = new int[]{0, 163, 297, 78, 133, 124, 0, 0, 0};
		gbl_phieuNhapPanel.rowHeights = new int[]{78, 49, 45, 48, 45, 33, 18, 47, 150, 72, 0, 0};
		gbl_phieuNhapPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_phieuNhapPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		phieuNhapPanel.setLayout(gbl_phieuNhapPanel);
		
		JLabel lblQunLPhiu = new JLabel("QUẢN LÝ PHIẾU NHẬP");
		lblQunLPhiu.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLPhiu.setFont(new Font("Times New Roman", Font.BOLD, 24));
		GridBagConstraints gbc_lblQunLPhiu = new GridBagConstraints();
		gbc_lblQunLPhiu.insets = new Insets(0, 0, 5, 5);
		gbc_lblQunLPhiu.gridwidth = 7;
		gbc_lblQunLPhiu.gridx = 0;
		gbc_lblQunLPhiu.gridy = 0;
		phieuNhapPanel.add(lblQunLPhiu, gbc_lblQunLPhiu);
		
		JLabel lblMaPhieuNhap = new JLabel("Mã phiếu nhập");
		lblMaPhieuNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblMaPhieuNhap = new GridBagConstraints();
		gbc_lblMaPhieuNhap.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaPhieuNhap.gridx = 1;
		gbc_lblMaPhieuNhap.gridy = 1;
		phieuNhapPanel.add(lblMaPhieuNhap, gbc_lblMaPhieuNhap);
		
		textField_maPN = new JTextField();
		textField_maPN.setColumns(10);
		GridBagConstraints gbc_textField_maPN = new GridBagConstraints();
		gbc_textField_maPN.insets = new Insets(0, 0, 5, 5);
		gbc_textField_maPN.fill = GridBagConstraints.BOTH;
		gbc_textField_maPN.gridx = 2;
		gbc_textField_maPN.gridy = 1;
		phieuNhapPanel.add(textField_maPN, gbc_textField_maPN);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput()) {
					themPN();
				}
			}
		});
		btnThem.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/img/add.png")));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem = new GridBagConstraints();
		gbc_btnThem.fill = GridBagConstraints.BOTH;
		gbc_btnThem.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem.gridx = 4;
		gbc_btnThem.gridy = 1;
		phieuNhapPanel.add(btnThem, gbc_btnThem);
		
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
					int index = table_1.getSelectedRow();
					java.util.Date utilDate = dateChooser.getDate(); // lay ra date trong o input
					Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
					cal.setTime(utilDate); // lay ra thoi gian cua utilDate
					cal.add(Calendar.DATE, 0); // cong them 2 ngay nua de hien thi dung tren jtable
					java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
					java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
					if(index == -1) {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					boolean check = false;
					String cellValue = table_1.getValueAt(selectedRow, 4).toString();
					if(cellValue.contains("Đã xóa")) {
						check = false;
					}else {
						check = true;
					}
					if(check == false) {
						JOptionPane.showMessageDialog(null, "Hóa đơn đã xóa thì không thể sửa được nữa");
					}else {
						buspn.update(textField_maPN.getText()+"",sqlDate,Integer.parseInt(textField_gia.getText()+""),comboBox_maNPP.getSelectedItem()+"",true);
					}
					updatePNFromList();
				}else {
					suaPN();
				}
			}
		});
		btnSa.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/img/sua.png")));
		btnSa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSa.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnSa = new GridBagConstraints();
		gbc_btnSa.fill = GridBagConstraints.BOTH;
		gbc_btnSa.insets = new Insets(0, 0, 5, 5);
		gbc_btnSa.gridx = 5;
		gbc_btnSa.gridy = 1;
		phieuNhapPanel.add(btnSa, gbc_btnSa);
		
		JLabel lblMNcc = new JLabel("Mã NPP");
		lblMNcc.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblMNcc = new GridBagConstraints();
		gbc_lblMNcc.insets = new Insets(0, 0, 5, 5);
		gbc_lblMNcc.gridx = 1;
		gbc_lblMNcc.gridy = 2;
		phieuNhapPanel.add(lblMNcc, gbc_lblMNcc);
		
		comboBox_maNPP = new JComboBox();
		for (DTO_NhaPP npp : busnpp.getListNPP()) {
			comboBox_maNPP.addItem(npp.getMa_NPP());
		}
		GridBagConstraints gbc_comboBox_nhaCC = new GridBagConstraints();
		gbc_comboBox_nhaCC.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_nhaCC.fill = GridBagConstraints.BOTH;
		gbc_comboBox_nhaCC.gridx = 2;
		gbc_comboBox_nhaCC.gridy = 2;
		phieuNhapPanel.add(comboBox_maNPP, gbc_comboBox_nhaCC);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			       xoaPN();
			    }
			});
		btnXa.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/img/delete.png")));
		btnXa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXa.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnXa = new GridBagConstraints();
		gbc_btnXa.fill = GridBagConstraints.BOTH;
		gbc_btnXa.insets = new Insets(0, 0, 5, 5);
		gbc_btnXa.gridx = 4;
		gbc_btnXa.gridy = 2;
		phieuNhapPanel.add(btnXa, gbc_btnXa);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(HoaDonForm.class.getResource("/img/reload.png")));
		btnReset.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        xoaForm();
		        updatePNFromList();
		        CTPhieuNhapForm ctpn = new CTPhieuNhapForm();
		        for (DTO_Phieunhap pn : test) {
		            ctpn.updateHDFromList(pn.getMa_PN() + "");
		            java.util.Date utilDate = pn.getNgayNhap();
		            Calendar cal = Calendar.getInstance();
		            cal.setTime(utilDate);
		            cal.add(Calendar.DATE, 2);
		            java.util.Date newUtilDate = cal.getTime();
		            java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime());
		            
		            buspn.update(pn.getMa_PN()+"",sqlDate,ctpn.getTongTien(pn.getMa_PN()+""),pn.getMa_NPP()+"",pn.isCheck_exist());
		        
		        }
		    }
		});

		btnReset.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/img/reload.png")));
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnReset.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.fill = GridBagConstraints.BOTH;
		gbc_btnReset.insets = new Insets(0, 0, 5, 5);
		gbc_btnReset.gridx = 5;
		gbc_btnReset.gridy = 2;
		phieuNhapPanel.add(btnReset, gbc_btnReset);
		
		JLabel lblNgyNhp = new JLabel("Ngày nhập");
		lblNgyNhp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNgyNhp = new GridBagConstraints();
		gbc_lblNgyNhp.insets = new Insets(0, 0, 5, 5);
		gbc_lblNgyNhp.gridx = 1;
		gbc_lblNgyNhp.gridy = 3;
		phieuNhapPanel.add(lblNgyNhp, gbc_lblNgyNhp);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 3;
		phieuNhapPanel.add(dateChooser, gbc_dateChooser);
		
		JButton btnXutExcel = new JButton("Xuất Excel");
		btnXutExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportPhieuNhap.xlsx";
				xuatExcel(buspn.getlistPN(), fileName);
			}
		});
		btnXutExcel.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/img/xuat excel.png")));
		btnXutExcel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXutExcel.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnXutExcel = new GridBagConstraints();
		gbc_btnXutExcel.fill = GridBagConstraints.BOTH;
		gbc_btnXutExcel.insets = new Insets(0, 0, 5, 5);
		gbc_btnXutExcel.gridx = 4;
		gbc_btnXutExcel.gridy = 3;
		phieuNhapPanel.add(btnXutExcel, gbc_btnXutExcel);
		
		JButton btn_chiTiet = new JButton("Chi tiết hóa đơn");
		btn_chiTiet.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/img/PhieuChi.png")));
		btn_chiTiet.addActionListener((e) -> {
//			updatePNFromList();
			int index = table_1.getSelectedRow();
		    if (index == -1) {
		        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xem chi tiết hóa đơn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        return;
		    } else {
		        CTPhieuNhapForm ctpn = new CTPhieuNhapForm();
		        int modelIndex = table_1.convertRowIndexToModel(index);
		        String maPN = (String) table_1.getModel().getValueAt(modelIndex, 0);
		        for (DTO_Phieunhap cthd1 : test) {
		            if (cthd1.getMa_PN().equals(maPN)) {
		                ctpn.updateHDFromList(maPN);
		                break;
		            }
		        }
		        ctpn.showCurrentMaPN(maPN);
		        ctpn.addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosing(WindowEvent e) {
		            	ctpn.setVisible(false);
		            }
		        });
		        ctpn.setVisible(true);
		    }
		});
		btn_chiTiet.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btn_chiTiet.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btn_chiTiet = new GridBagConstraints();
		gbc_btn_chiTiet.fill = GridBagConstraints.BOTH;
		gbc_btn_chiTiet.insets = new Insets(0, 0, 5, 5);
		gbc_btn_chiTiet.gridx = 5;
		gbc_btn_chiTiet.gridy = 3;
		phieuNhapPanel.add(btn_chiTiet, gbc_btn_chiTiet);
		
//		JButton btnNhpExcel = new JButton("Nhập Excel");
//		btnNhpExcel.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String fileName = "C:\\Users\\ADMIN\\Desktop\\doanjavaexportPhieuNhap.xlsx";
//				importExcel(fileName);
//			}
//		});
//		btnNhpExcel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\HK2-N2\\JAVA\\DoAnJava (4)\\src\\img\\nhap excel.png"));
//		btnNhpExcel.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		btnNhpExcel.setBackground(new Color(226, 221, 221));
//		GridBagConstraints gbc_btnNhpExcel = new GridBagConstraints();
//		gbc_btnNhpExcel.fill = GridBagConstraints.BOTH;
//		gbc_btnNhpExcel.insets = new Insets(0, 0, 5, 5);
//		gbc_btnNhpExcel.gridx = 5;
//		gbc_btnNhpExcel.gridy = 3;
//		phieuNhapPanel.add(btnNhpExcel, gbc_btnNhpExcel);
		
		JLabel lblTngGi = new JLabel("Tổng giá");
		lblTngGi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblTngGi = new GridBagConstraints();
		gbc_lblTngGi.insets = new Insets(0, 0, 5, 5);
		gbc_lblTngGi.gridx = 1;
		gbc_lblTngGi.gridy = 4;
		phieuNhapPanel.add(lblTngGi, gbc_lblTngGi);
		
		textField_gia = new JTextField();
		textField_gia.setEditable(false);
		textField_gia.setColumns(10);
		GridBagConstraints gbc_textField_gia = new GridBagConstraints();
		gbc_textField_gia.insets = new Insets(0, 0, 5, 5);
		gbc_textField_gia.fill = GridBagConstraints.BOTH;
		gbc_textField_gia.gridx = 2;
		gbc_textField_gia.gridy = 4;
		phieuNhapPanel.add(textField_gia, gbc_textField_gia);
		
		
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm: ");
		lblTimKiem.setToolTipText("Tìm kiếm");
		lblTimKiem.setForeground(Color.RED);
		lblTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTimKiem.setBackground(new Color(128, 0, 64));
		GridBagConstraints gbc_lblTimKiem = new GridBagConstraints();
		gbc_lblTimKiem.fill = GridBagConstraints.VERTICAL;
		gbc_lblTimKiem.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimKiem.gridx = 1;
		gbc_lblTimKiem.gridy = 7;
		phieuNhapPanel.add(lblTimKiem, gbc_lblTimKiem);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 String searchText = textField_1.getText().trim();
			        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
			        table_1.setRowSorter(sorter);
			        
			        // ?i: khong quan tam chu thuong hay chu hoa
			        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText)); // áp dụng filter với regular expression
			}
		});
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 7;
		phieuNhapPanel.add(textField_1, gbc_textField_1);
		
		JButton btnTm = new JButton("Tìm");
		btnTm.setIcon(new ImageIcon(PhieuNhapForm.class.getResource("/img/search.png")));
		btnTm.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnTm.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnTm = new GridBagConstraints();
		gbc_btnTm.fill = GridBagConstraints.BOTH;
		gbc_btnTm.insets = new Insets(0, 0, 5, 5);
		gbc_btnTm.gridx = 4;
		gbc_btnTm.gridy = 7;
		phieuNhapPanel.add(btnTm, gbc_btnTm);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Mã phiếu nhập", "Mã nhà phân phối","Ngày nhập","Giá","Trạng thái"
			}
		));
		table_1.setRowHeight(50);
		table_1.setBounds(1, 25, 922, -2);
		table_1.setDefaultEditor(Object.class, null);
		phieuNhapPanel.add(table_1);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setEnabled(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 8;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 8;
		phieuNhapPanel.add(scrollPane, gbc_scrollPane);
		
		Color customColor = new Color(226, 221, 221);
		

		


		updatePNFromList();
		showMaPNNext();
	}

	public JPanel getPhieuNhapJPanel() {
		return phieuNhapPanel;
	}
	
	public String getGiaTienFormatted(int gia) {
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
	    return formatter.format(gia)+" VNĐ";
	}
	
	public boolean checkInput() {
	    if (this.textField_maPN.getText().equals("") || this.comboBox_maNPP.getSelectedIndex() == -1 || this.textField_gia.getText().equals("")) {
	        JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
	        return false;
	    }	

	    try {
	        int gia = Integer.parseInt(this.textField_gia.getText() + "");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Trường giá tiền phải là kiểu số nguyên");
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

	
	public void showMaPNNext() {
		BUS_Phieunhap busph = new BUS_Phieunhap();
		textField_maPN.setEditable(false);
		textField_maPN.setText(busph.getmaPNNext()+"");
	}
	
	public void themPNVaoTable(DTO_Phieunhap pn) {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.addRow(new Object[]{pn.getMa_PN()+"",pn.getMa_NPP()+"",pn.getNgayNhap()+"",pn.getTongGia()+"",pn.isCheck_exist()+""});
		updatePNFromList();
		xoaForm();
	}
	
	public void updatePNFromList() {
		test.clear();
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.setRowCount(0);

	    CTPhieuNhapForm ctpn = new CTPhieuNhapForm();
	    BUS_Phieunhap buspn = new BUS_Phieunhap();

	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);

	    for (DTO_Phieunhap pn : buspn.getlistPN()) {
			 java.util.Date utilDate = pn.getNgayNhap(); // lay ra date trong o input
			 Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
			 cal.setTime(utilDate); // lay ra thoi gian cua utilDate
			 cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
			 java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
			 java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
	    	String text = null;
	        if (pn.isCheck_exist()) {
	        	text = "<html><font color='green' style='font-weight:bold;'>Tồn tại</font></html>";
	        } else {
	            text = "<html><font color='red' style='font-weight: bold;'>Đã xóa</font></html>";
	        }
//	       if(pn.isCheck_exist()) {
//	    	   model_table.addRow(new Object[] {pn.getMa_PN()+"",pn.getMa_NPP()+"",pn.getMa_DT()+"",sqlDate,pn.getSL()+"",getGiaTienFormatted(Integer.parseInt(pn.getTongGia()+"")),text});
//	       }
	 
	       model_table.addRow(new Object[] {pn.getMa_PN()+"",pn.getMa_NPP()+"",sqlDate,getGiaTienFormatted(ctpn.getTongTien(pn.getMa_PN()+"")),text});
	    }
	    xoaForm();
	    for (DTO_Phieunhap pn : buspn.getlistPN()) {
	    	test.add(pn);
	    }
	}


	
	public void xoaForm() {
		textField_gia.setText("0");
		comboBox_maNPP.setSelectedIndex(-1);
		dateChooser.setDate(null);
		showMaPNNext();
	}
	
	public void themPN() {
		BUS_Phieunhap buspn = new BUS_Phieunhap();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 String text = df.format(this.dateChooser.getDate());
		 java.util.Date ngayNhap = null;
		 try {
		     ngayNhap = (java.util.Date) df.parse(text);
		 } catch (ParseException e) {
		     e.printStackTrace();
		 }

		 java.sql.Date ngayNhapSQL = new java.sql.Date(ngayNhap.getTime());
		 Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
			cal.setTime(ngayNhapSQL); // lay ra thoi gian cua utilDate
			cal.add(Calendar.DATE, 0); // cong them 2 ngay nua de hien thi dung tren jtable
			java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
			java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
		 boolean result = buspn.addPNToTable(this.textField_maPN.getText()+"", sqlDate,Integer.parseInt(this.textField_gia.getText()+""),this.comboBox_maNPP.getSelectedItem()+"",true);
		 if (result) {
		        themPNVaoTable(buspn.getlistPN().get(buspn.getlistPN().size() - 1));
		    }else {
		    	JOptionPane.showMessageDialog(null, "Thêm thất bại");
		    }
		    xoaForm();
	}

	public DTO_Phieunhap getPN() {
		DefaultTableModel model_CV = (DefaultTableModel) table_1.getModel();
		int index = table_1.getSelectedRow();
		int modelIndex = table_1.convertRowIndexToModel(index);
		String maPN = (String) model_CV.getValueAt(modelIndex, 0);
		String maNPP = (String) model_CV.getValueAt(modelIndex, 1);
	    String ngayLapStr = (String) model_CV.getValueAt(modelIndex, 2).toString();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date parsedDate = null;
	    try {
	        parsedDate = dateFormat.parse(ngayLapStr);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    java.sql.Date ngayLap = new java.sql.Date(parsedDate.getTime());
		
		String giaString = (String) model_CV.getValueAt(modelIndex, 3);
	    int indexGia = giaString.indexOf(" VNĐ");
	    String getStringGia = giaString.substring(0, indexGia);
	    getStringGia = getStringGia.replace(",", "");
	    int gia = Integer.parseInt(getStringGia);
		
		DTO_Phieunhap pn = new DTO_Phieunhap(maPN, ngayLap, gia, maNPP, true);
		return pn;
	}
	
	public void suaPN() {
		int index = table_1.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa");
		}else {
			DTO_Phieunhap pn = getPN();
			this.textField_maPN.setText(pn.getMa_PN()+"");
			this.comboBox_maNPP.setSelectedItem(pn.getMa_NPP()+"");
			this.dateChooser.setDate(pn.getNgayNhap());	
			this.textField_gia.setText(pn.getTongGia()+"");
		}
	}
	
	public void xoaPN() {
	    BUS_Phieunhap buspn = new BUS_Phieunhap();
	    int index = table_1.getSelectedRow(); // lay ra dong ma nguoi dung chon
	    if (index == -1) {
	        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
	    } else {
	        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa điện thoại này?");
	        if (luaChon == JOptionPane.YES_OPTION) {
	            DTO_Phieunhap pn = getPN();
	            boolean check = buspn.delete(pn.getMa_PN());
	            if (check) {
	            	pn.setCheck_exist(false);
	                updatePNFromList();
	            }
	            xoaForm();
	        }
	    }
	}
	
	
	public void xuatExcel(ArrayList<DTO_Phieunhap> dsPN, String fileName) {
		updatePNFromList();
	    try {
	        // Tạo workbook mới
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // Tạo sheet mới trong workbook
	        Sheet sheet = workbook.createSheet("Sheet1");
	        
	        // Tạo header row với tên cột
	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Mã phiếu nhập");
	        headerRow.createCell(1).setCellValue("Mã nhà phân phối");
	        headerRow.createCell(2).setCellValue("Ngày nhập");
	        headerRow.createCell(3).setCellValue("Giá");
	        headerRow.createCell(4).setCellValue("Trạng thái");
	        
	        
	        // Duyệt qua danh sách điện thoại và tạo các row và cell tương ứng trên sheet
	        int rowIndex = 1;
	        for (DTO_Phieunhap pn : test) {
	            Row row = sheet.createRow(rowIndex++);
	            row.createCell(0).setCellValue(pn.getMa_PN());
	            row.createCell(1).setCellValue(pn.getMa_NPP());
	            row.createCell(2).setCellValue(pn.getNgayNhap());
	            Cell ngayNhapCell = row.createCell(2);
	            if (pn.getNgayNhap() != null) {
	                java.util.Date ngayNhap = pn.getNgayNhap();
	                ngayNhapCell.setCellValue(new java.text.SimpleDateFormat("dd/MM/yyyy").format(ngayNhap));
	            } else {
	                ngayNhapCell.setCellValue("");
	            }
	            row.createCell(3).setCellValue(pn.getTongGia());
	            row.createCell(4).setCellValue(pn.isCheck_exist());
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
	    for(int i = 1 ; i <= buspn.getlistPN().size() ; i++) {
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
	            Object[] rowData = new Object[7];
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
	            	String lastMaPN = (String) table_1.getValueAt(rowCount - 1, 0);
	            	
	            	int lastRowNum = sheet.getLastRowNum();

	            	// Lấy đối tượng Row của dòng cuối cùng
	            	Row lastRow = sheet.getRow(lastRowNum);

	            	// Lấy giá trị của ô chứa mã NV trong dòng cuối cùng
	            	Cell maPNCell = lastRow.getCell(0);
	            	Cell maNPPCell = lastRow.getCell(1);
	            	Cell ngayNhapCell = lastRow.getCell(2);	
	            	Cell giaCell = lastRow.getCell(3);	
	            	
	            	String maPN = maPNCell.getStringCellValue();
	            	if(Integer.parseInt(maPN.substring(2)) - Integer.parseInt(lastMaPN.substring(2)) == 1) {
	            		for(DTO_NhaPP npp : busnpp.getListNPP()) {
	            			if(maNPPCell.toString().trim().equals(npp.getMa_NPP())) {	            			
	            				if (ngayNhapCell.getCellType() != CellType.NUMERIC || (ngayNhapCell.getCellType() == CellType.STRING && !DateUtil.isCellDateFormatted(ngayNhapCell)) || giaCell.getCellType() != CellType.NUMERIC) {
	            				    JOptionPane.showMessageDialog(null, "Dữ liệu ngày sinh không hợp lệ");
	            				    return;
	            				}
	            				else {
		    								for(int i = count + 1 ; i <= sheet.getLastRowNum() ; i++) {
		    				            		XSSFRow excelRow = (XSSFRow) sheet.getRow(i);
		    				            		XSSFCell ex_maPN = excelRow.getCell(0);
		    				            		XSSFCell ex_maNPP = excelRow.getCell(1);
		    				            		XSSFCell ex_ngayNhap = excelRow.getCell(2);
		    				            		XSSFCell ex_gia = excelRow.getCell(3);
		    				            		XSSFCell ex_trangThai = excelRow.getCell(4);
		    				            		boolean trangThai = ex_trangThai.getBooleanCellValue();
		    				            		
		    				            		String ngayNhapStr = ex_ngayNhap.getStringCellValue();
		    				            		SimpleDateFormat excelDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    				            		java.util.Date ngayNhapUtilDate = null;
		    				            		try {
		    				            		    ngayNhapUtilDate = excelDateFormat.parse(ngayNhapStr);
		    				            		} catch (ParseException e) {
		    				            		    e.printStackTrace();
		    				            		}

		    				            		SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    				            		String ngayNhapSqlString = sqlDateFormat.format(ngayNhapUtilDate);
		    				            		java.sql.Date ngayNhapSqlDate = java.sql.Date.valueOf(ngayNhapSqlString);
		    				            		Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
		    									cal.setTime(ngayNhapSqlDate); // lay ra thoi gian cua utilDate
		    									cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
		    									java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
		    									java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
		    									
		    									int gia = (int) ex_gia.getNumericCellValue();
		    									
		    				            		boolean check = buspn.addPNToTable(ex_maPN.toString(), sqlDate, gia,ex_maNPP.toString(),trangThai);
		    				            		if(check) {
		    				            			themPNVaoTable(buspn.getlistPN().get(buspn.getlistPN().size() - 1));
		    				            		}
		    				            	}return;
		    							}	            				
	            			}
	            				            			
        				}
	            		JOptionPane.showMessageDialog(null, "Dữ liệu mã nhà phân phối truyền vào không hợp lý");
	            		return;
	            			
	            	}
	            		JOptionPane.showMessageDialog(null, "Dữ liệu mã phiếu nhập truyền vào không hợp lý");
	            		return;
	            		
	            	
	            }else if(count == sheet.getLastRowNum()) {
	            	DTO_Phieunhap[] pnArray = new DTO_Phieunhap[sheet.getLastRowNum() + 1];
	            	for(int i = 1 ; i <= sheet.getLastRowNum()-1 ; i++) {
	            		XSSFRow excelRow = (XSSFRow) sheet.getRow(i);
	            		XSSFCell ex_maPN = excelRow.getCell(0);
	            		XSSFCell ex_maNPP = excelRow.getCell(1);	            	
	            		XSSFCell ex_ngayNhap = excelRow.getCell(2);
	            		XSSFCell ex_gia = excelRow.getCell(3);
	            		XSSFCell ex_trangThai = excelRow.getCell(4);
	            		boolean trangThai = ex_trangThai.getBooleanCellValue();
	            		
	            		String ngayNhapStr = ex_ngayNhap.getStringCellValue();
	            		SimpleDateFormat excelDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	            		java.util.Date ngayNhapUtilDate = null;
	            		try {
	            		    ngayNhapUtilDate = excelDateFormat.parse(ngayNhapStr);
	            		} catch (ParseException e) {
	            		    e.printStackTrace();
	            		}

	            		SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            		String ngayNhapSqlString = sqlDateFormat.format(ngayNhapUtilDate);
	            		java.sql.Date ngayNhapSqlDate = java.sql.Date.valueOf(ngayNhapSqlString);
	            		Calendar cal = Calendar.getInstance(); // khoi tao doi tuong Calendar va thiet lap thoi gian hien tai cho he thong
						cal.setTime(ngayNhapSqlDate); // lay ra thoi gian cua utilDate
						cal.add(Calendar.DATE, 2); // cong them 2 ngay nua de hien thi dung tren jtable
						java.util.Date newUtilDate = cal.getTime(); // lay ra thoi gian sau khi cong 2 ngay
						java.sql.Date sqlDate = new java.sql.Date(newUtilDate.getTime()); // ep ve kieu sql.Date
						
						int gia = (int) ex_gia.getNumericCellValue();
						
	            	    DTO_Phieunhap pn = new DTO_Phieunhap(ex_maPN.toString(), sqlDate, gia,ex_maNPP.toString(),trangThai);
	            	    pnArray[i] = pn;
	            	    if(!pnArray[i].equals(buspn.getlistPN().get(i))) {
	            	    	buspn.update(ex_maPN.toString(), sqlDate, gia,ex_maNPP.toString(),trangThai);
	            	    }
	            	}
	            }
	            model_table.addRow(rowData);
	            updatePNFromList();
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
	    table_1.getColumnModel().getColumn(4).setPreferredWidth(200);
	    JOptionPane.showMessageDialog(null, "Import từ excel thành công");
	}
}
