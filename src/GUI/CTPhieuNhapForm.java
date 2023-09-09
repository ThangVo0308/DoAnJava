package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.BUS_ChitietHD;
import BUS.BUS_ChitietPN;
import BUS.BUS_Dienthoai;
import BUS.BUS_Phieunhap;
import DTO.DTO_ChitietHD;
import DTO.DTO_ChitietPN;
import DTO.DTO_Dienthoai;
import DTO.DTO_Phieunhap;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class CTPhieuNhapForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_maPN;
	private JTextField textField_SL;
	private JTextField textField_1;
	private JTable table_1;
	private JComboBox comboBox_maDT;
	private JTextField textField_gia;
	public int tongTienHD = 0;
	public ArrayList<DTO_ChitietPN> test = new ArrayList<>();
	BUS_ChitietPN busctpn = new BUS_ChitietPN();
	BUS_Dienthoai busdt = new BUS_Dienthoai();
	private JPanel panel_tong;
	private JLabel lblNewLabel;
	public int count = 0;
	public int checkClicked = -1; // nguoi dung chua an nut nao

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CTPhieuNhapForm frame = new CTPhieuNhapForm();
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
	public CTPhieuNhapForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 781, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
	
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 95, 263, 58, 119, 123, 0, 0};
		gbl_contentPane.rowHeights = new int[]{70, 38, 39, 36, 39, 0, 0, 0, 0, 0, 0, 139, 114, 59, 0, 18, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblChiTitPhiu = new JLabel("CHI TIẾT PHIẾU NHẬP");
		lblChiTitPhiu.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTitPhiu.setFont(new Font("Arial", Font.BOLD, 24));
		GridBagConstraints gbc_lblChiTitPhiu = new GridBagConstraints();
		gbc_lblChiTitPhiu.insets = new Insets(0, 0, 5, 0);
		gbc_lblChiTitPhiu.gridwidth = 7;
		gbc_lblChiTitPhiu.gridx = 0;
		gbc_lblChiTitPhiu.gridy = 0;
		contentPane.add(lblChiTitPhiu, gbc_lblChiTitPhiu);
		
		JLabel lblMaPhieuNhap = new JLabel("Mã phiếu nhập");
		lblMaPhieuNhap.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblMaPhieuNhap = new GridBagConstraints();
		gbc_lblMaPhieuNhap.fill = GridBagConstraints.VERTICAL;
		gbc_lblMaPhieuNhap.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaPhieuNhap.gridx = 1;
		gbc_lblMaPhieuNhap.gridy = 1;
		contentPane.add(lblMaPhieuNhap, gbc_lblMaPhieuNhap);
		
		textField_maPN = new JTextField();
		textField_maPN.setEditable(false);
		textField_maPN.setColumns(10);
		GridBagConstraints gbc_textField_maPN = new GridBagConstraints();
		gbc_textField_maPN.insets = new Insets(0, 0, 5, 5);
		gbc_textField_maPN.fill = GridBagConstraints.BOTH;
		gbc_textField_maPN.gridx = 2;
		gbc_textField_maPN.gridy = 1;
		contentPane.add(textField_maPN, gbc_textField_maPN);
		
		JLabel lblMinThoi = new JLabel("Mã điện thoại");
		lblMinThoi.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblMinThoi = new GridBagConstraints();
		gbc_lblMinThoi.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinThoi.gridx = 1;
		gbc_lblMinThoi.gridy = 2;
		contentPane.add(lblMinThoi, gbc_lblMinThoi);
		
		comboBox_maDT = new JComboBox();
		for (DTO_Dienthoai dt : busdt.getListDT()) {
			comboBox_maDT.addItem(dt.getMa_DT());
		}
		comboBox_maDT.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (comboBox_maDT.getSelectedIndex() != -1) {
		            String selectedMaDT = (String) comboBox_maDT.getSelectedItem();
		            getPriceProduct(selectedMaDT);
		        }
		    }
		});
		comboBox_maDT.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox_maDT = new GridBagConstraints();
		gbc_comboBox_maDT.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_maDT.fill = GridBagConstraints.BOTH;
		gbc_comboBox_maDT.gridx = 2;
		gbc_comboBox_maDT.gridy = 2;
		contentPane.add(comboBox_maDT, gbc_comboBox_maDT);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setIcon(new ImageIcon(CTPhieuNhapForm.class.getResource("/img/add.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkInput()) {
					themPN();
				}
				
			}
		});
		btnThem.setFont(new Font("Arial", Font.BOLD, 14));
		btnThem.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem = new GridBagConstraints();
		gbc_btnThem.fill = GridBagConstraints.BOTH;
		gbc_btnThem.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem.gridx = 4;
		gbc_btnThem.gridy = 2;
		contentPane.add(btnThem, gbc_btnThem);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setForeground(new Color(0, 0, 0));
		btnSa.setIcon(new ImageIcon(CTPhieuNhapForm.class.getResource("/img/sua.png")));
		btnSa.addActionListener(new ActionListener() {
		    BUS_ChitietPN busctpn = new BUS_ChitietPN();

		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table_1.getSelectedRow();
		        if (checkClicked != selectedRow) {
		            count = 0;
		        }
		        checkClicked = selectedRow;
		        count++;
		        
		        if (count % 2 == 0) {
		            int viewIndex = table_1.getSelectedRow();
		            int modelIndex = table_1.convertRowIndexToModel(viewIndex);
		            if (modelIndex == -1) {
		                JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                String currentMaPN = textField_maPN.getText();
		                String currentMaDT = comboBox_maDT.getSelectedItem() + "";
		                
		                String slText = textField_SL.getText().trim();
		                int soLuong = 0;
		                if (!slText.isEmpty()) {
		                    try {
		                        soLuong = Integer.parseInt(slText);
		                    } catch (NumberFormatException ex) {
		                        JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
		                        return;
		                    }
		                } else {
		                    JOptionPane.showMessageDialog(null, "Số lượng không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
		                    return; 
		                }
		                
		                // maDT cu~ truoc khi sua
		                String maDT = null;

		                if (selectedRow != -1) {
		                    maDT = table_1.getValueAt(selectedRow, 1).toString();
		                }

		                // Kiểm tra dòng đang chọn và bỏ qua
		                boolean isMaDTFound = false;

		                for (int i = 0; i < table_1.getRowCount(); i++) {
		                    if (i == viewIndex) {
		                        continue; 
		                    }
		                    String maDT1 = table_1.getValueAt(i, 1).toString();
		                    if (currentMaDT.equals(maDT1)) {
		                        JOptionPane.showMessageDialog(null, "Mã điện thoại này đã tồn tại, vui lòng sửa ở phần số lượng và giá");
		                        return;
		                    } else {
		                        isMaDTFound = true;
		                    }
		                }

		                HoaDonForm hdForm = new HoaDonForm();
		                if (!isMaDTFound) {
	                    	busctpn.update(currentMaPN, maDT, currentMaDT, soLuong, Integer.parseInt(textField_gia.getText().trim()), true);
	                    	updateHDFromList(currentMaPN);
	                    	hdForm.updateHDFromList();
	                    	return;
		                }
		                busctpn.update(currentMaPN, comboBox_maDT.getSelectedItem().toString(), currentMaDT, soLuong, Integer.parseInt(textField_gia.getText().trim()), true);
		                updateHDFromList(textField_maPN.getText());
		                hdForm.updateHDFromList();
		            }
		        } else {
		            suaPN();
		        }
		    }
		});
		btnSa.setFont(new Font("Arial", Font.BOLD, 14));
		btnSa.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnSa = new GridBagConstraints();
		gbc_btnSa.fill = GridBagConstraints.BOTH;
		gbc_btnSa.insets = new Insets(0, 0, 5, 5);
		gbc_btnSa.gridx = 5;
		gbc_btnSa.gridy = 2;
		contentPane.add(btnSa, gbc_btnSa);
		
		JLabel lblMinThoi_1 = new JLabel("Số lượng");
		lblMinThoi_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblMinThoi_1 = new GridBagConstraints();
		gbc_lblMinThoi_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinThoi_1.gridx = 1;
		gbc_lblMinThoi_1.gridy = 3;
		contentPane.add(lblMinThoi_1, gbc_lblMinThoi_1);
		
		textField_SL = new JTextField();
		textField_SL.setText("");
		textField_SL.setColumns(10);
		GridBagConstraints gbc_textField_SL = new GridBagConstraints();
		gbc_textField_SL.insets = new Insets(0, 0, 5, 5);
		gbc_textField_SL.fill = GridBagConstraints.BOTH;
		gbc_textField_SL.gridx = 2;
		gbc_textField_SL.gridy = 3;
		contentPane.add(textField_SL, gbc_textField_SL);
		
		JButton btnThem_1_1 = new JButton("Xóa");
		btnThem_1_1.setForeground(new Color(0, 0, 0));
		btnThem_1_1.setIcon(new ImageIcon(CTPhieuNhapForm.class.getResource("/img/delete.png")));
		btnThem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaPN();
			}
		});
		btnThem_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnThem_1_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem_1_1 = new GridBagConstraints();
		gbc_btnThem_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnThem_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem_1_1.gridx = 4;
		gbc_btnThem_1_1.gridy = 3;
		contentPane.add(btnThem_1_1, gbc_btnThem_1_1);
		
		JButton btnThem_1_1_1 = new JButton("Reset");
		btnThem_1_1_1.setForeground(new Color(0, 0, 0));
		btnThem_1_1_1.setIcon(new ImageIcon(CTPhieuNhapForm.class.getResource("/img/reload.png")));
		btnThem_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaForm();
			}
		});
		btnThem_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnThem_1_1_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem_1_1_1 = new GridBagConstraints();
		gbc_btnThem_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnThem_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem_1_1_1.gridx = 5;
		gbc_btnThem_1_1_1.gridy = 3;
		contentPane.add(btnThem_1_1_1, gbc_btnThem_1_1_1);
		
		JLabel lblMinThoi_1_1 = new JLabel("Giá");
		lblMinThoi_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblMinThoi_1_1 = new GridBagConstraints();
		gbc_lblMinThoi_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinThoi_1_1.gridx = 1;
		gbc_lblMinThoi_1_1.gridy = 4;
		contentPane.add(lblMinThoi_1_1, gbc_lblMinThoi_1_1);
		
		textField_gia = new JTextField();
		textField_gia.setEnabled(false);
		textField_gia.setEditable(false);
		textField_gia.setText("0");
		textField_gia.setColumns(10);
		GridBagConstraints gbc_textField_gia = new GridBagConstraints();
		gbc_textField_gia.insets = new Insets(0, 0, 5, 5);
		gbc_textField_gia.fill = GridBagConstraints.BOTH;
		gbc_textField_gia.gridx = 2;
		gbc_textField_gia.gridy = 4;
		contentPane.add(textField_gia, gbc_textField_gia);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm: ");
		lblTimKiem.setToolTipText("Tìm kiếm");
		lblTimKiem.setForeground(Color.RED);
		lblTimKiem.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTimKiem.setBackground(new Color(128, 0, 64));
		GridBagConstraints gbc_lblTimKiem = new GridBagConstraints();
		gbc_lblTimKiem.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimKiem.gridx = 1;
		gbc_lblTimKiem.gridy = 7;
		contentPane.add(lblTimKiem, gbc_lblTimKiem);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 7;
		contentPane.add(textField_1, gbc_textField_1);
		
		JButton btnThem_1_1_2 = new JButton("Tìm");
		btnThem_1_1_2.setIcon(new ImageIcon(CTPhieuNhapForm.class.getResource("/img/search.png")));
		btnThem_1_1_2.setForeground(new Color(0, 0, 0));
		btnThem_1_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		btnThem_1_1_2.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem_1_1_2 = new GridBagConstraints();
		gbc_btnThem_1_1_2.fill = GridBagConstraints.BOTH;
		gbc_btnThem_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem_1_1_2.gridx = 4;
		gbc_btnThem_1_1_2.gridy = 7;
		contentPane.add(btnThem_1_1_2, gbc_btnThem_1_1_2);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Mã phiếu nhập", "Mã điện thoại" ,"Số lượng","Giá","Trạng thái"
			}
		));
		table_1.setRowHeight(50);
		table_1.setBounds(1, 25, 922, -2);
		table_1.setDefaultEditor(Object.class, null);
		contentPane.add(table_1);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setEnabled(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 10;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JLabel lblMinThoi_1_1_1 = new JLabel("Tổng giá");
		lblMinThoi_1_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblMinThoi_1_1_1 = new GridBagConstraints();
		gbc_lblMinThoi_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinThoi_1_1_1.gridx = 4;
		gbc_lblMinThoi_1_1_1.gridy = 14;
		contentPane.add(lblMinThoi_1_1_1, gbc_lblMinThoi_1_1_1);
		
		panel_tong = new JPanel();
		panel_tong.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel_tong = new GridBagConstraints();
		gbc_panel_tong.insets = new Insets(0, 0, 5, 5);
		gbc_panel_tong.fill = GridBagConstraints.BOTH;
		gbc_panel_tong.gridx = 5;
		gbc_panel_tong.gridy = 14;
		contentPane.add(panel_tong, gbc_panel_tong);
		
		lblNewLabel = new JLabel("");
		panel_tong.add(lblNewLabel);

		showCurrentMaPN(textField_maPN.getText()+"");
	}
	
	public JPanel getPhieuNhapJPanel() {
		return contentPane;
	}
	
	public String getGiaTienFormatted(int gia) {
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
	    return formatter.format(gia)+" VNĐ";
	}
	
	public boolean checkInput() {
	    if (this.textField_maPN.getText().equals("") || this.comboBox_maDT.getSelectedIndex() == -1 || this.textField_SL.getText().equals("") || this.textField_gia.getText().equals("")) {
	        JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
	        return false;
	    }

	    try {
	        int SL = Integer.parseInt(this.textField_SL.getText() + "");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Trường SL phải là kiểu số nguyên");
	        return false;
	    }

	    try {
	        int gia = Integer.parseInt(this.textField_gia.getText() + "");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Trường giá tiền phải là kiểu số nguyên");
	        return false;
	    }

	    return true;
	}

	
	public void showCurrentMaPN(String maPN) {
		textField_maPN.setText(maPN+"");
		textField_maPN.setEditable(false);
	}
	
	public void themPNVaoTable(DTO_ChitietPN pn) {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.addRow(new Object[]{pn.getMa_PN()+"",pn.getMa_DT()+"",pn.getSL()+"",pn.getGia()+"",pn.isCheck_exist()+""});
		updateHDFromList(pn.getMa_PN()+"");
		xoaForm();
	}
	
	public void getPriceProduct(String maDT) {
		BUS_Dienthoai busdt = new BUS_Dienthoai();
		for(int i =0 ; i < busdt.getListDT().size() ; i++) {
			if(maDT.equals(busdt.getListDT().get(i).getMa_DT())) {
				textField_gia.setText(busdt.getListDT().get(i).getGiaTien()+"");
				break;
			}
		}
	}
	
	public void updateHDFromList(String maPN) {
		test.clear();
		BUS_ChitietPN bushd = new BUS_ChitietPN();
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.setRowCount(0);

	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);

	    for (DTO_ChitietPN hd : bushd.getListCTPN()) {
	    	String text = null;
	        if (hd.isCheck_exist()) {
	        	text = "<html><font color='green' style='font-weight:bold;'>Tồn tại</font></html>";
	        } else {
	            text = "<html><font color='red' style='font-weight: bold;'>Đã xóa</font></html>";
	        }
	    	if(hd.getMa_PN().equals(maPN) && hd.isCheck_exist()) {
	    		 model_table.addRow(new Object[]{hd.getMa_PN()+"",hd.getMa_DT()+"",hd.getSL()+"",getGiaTienFormatted(Integer.parseInt(hd.getGia()+"")),text});
	    	}
	    }
	    xoaForm();
		for (DTO_ChitietPN ldt : bushd.getListCTPN()) {
			test.add(ldt);
		}
		int tong = 0;
		for (DTO_ChitietPN ct : test) {
			if(ct.getMa_PN().equals(maPN) && ct.isCheck_exist() == true) {
				tong += ct.getGia() * ct.getSL();
			}
		}
		tongTienHD = tong;
		lblNewLabel.setText(getGiaTienFormatted(tong));
	}

	public int getTongTien(String maPN) {
		updateHDFromList(maPN);
		return tongTienHD;
	}
	
	
	public void xoaForm() {
		textField_SL.setText("");
		textField_gia.setText("");
		comboBox_maDT.setSelectedIndex(-1);
	}
	
	public void themPN() {
		 BUS_ChitietPN buspn = new BUS_ChitietPN();
		 BUS_Dienthoai busdt = new BUS_Dienthoai();
		 for (DTO_ChitietPN ctpn : buspn.getListCTPN()) {
			if(ctpn.getMa_PN().equals(this.textField_maPN.getText()+"") && ctpn.getMa_DT().equals(this.comboBox_maDT.getSelectedItem()+"") && ctpn.isCheck_exist() == true) {
				JOptionPane.showMessageDialog(null, "Mã điện thoại đã tồn tại");
				return;
			}
		}
		 int index = 0;
		 int index1 = 0;
//		 for (DTO_Dienthoai dt : busdt.getListDT()) {
//			if(dt.getMa_DT().equals(comboBox_maDT.getSelectedItem())) {
//				index1 = index;
//				break;
//			}else {
//				index++;				
//			}
//		}
//		 System.out.println("index1: "+index1);
//		 int SL = busdt.getListDT().get(index1).getSL();
//		 if(SL < Integer.parseInt(this.textField_SL.getText()+"")) {
//			 JOptionPane.showMessageDialog(null, "Số lượng điện thoại bạn cần mua không đủ số lượng để đáp ứng");
//			 return;
//		 }else if(SL == 0) {
//			 JOptionPane.showMessageDialog(null, "Điện thoại này đã hết hàng");
//			 return;
//		 }
		 boolean result = buspn.addPNToTable(this.textField_maPN.getText()+"", comboBox_maDT.getSelectedItem()+"", Integer.parseInt(this.textField_SL.getText()+""),Integer.parseInt(this.textField_gia.getText()+""),true);
		 if (result) {
		        themPNVaoTable(buspn.getListCTPN().get(buspn.getListCTPN().size() - 1));
		 }else {
		    	JOptionPane.showMessageDialog(null, "Thêm thất bại");
		    }
		 updateHDFromList(this.textField_maPN.getText());
		    xoaForm();
	}

	public DTO_ChitietPN getPN() {
		DefaultTableModel model_CV = (DefaultTableModel) table_1.getModel();
		int index = table_1.getSelectedRow();
		int modelIndex = table_1.convertRowIndexToModel(index);
		String maPN = (String) model_CV.getValueAt(modelIndex, 0);
		String maDT = (String) model_CV.getValueAt(modelIndex, 1);
		int SL = Integer.parseInt((String) model_CV.getValueAt(modelIndex, 2));
		String giaString = (String) model_CV.getValueAt(modelIndex, 3);
	    int indexGia = giaString.indexOf(" VNĐ");
	    String getStringGia = giaString.substring(0, indexGia);
	    getStringGia = getStringGia.replace(",", "");
	    int gia = Integer.parseInt(getStringGia);
		
		DTO_ChitietPN pn = new DTO_ChitietPN(maPN, maDT, SL, gia, true);
		return pn;
	}
	
	public void suaPN() {
		int index = table_1.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa");
		}else {
			DTO_ChitietPN pn = getPN();
			this.textField_maPN.setText(pn.getMa_PN()+"");
			this.textField_SL.setText(pn.getSL()+"");
			this.textField_gia.setText(pn.getGia()+"");
			this.comboBox_maDT.setSelectedItem(pn.getMa_DT()+"");
		}
	}
	
	public void xoaPN() {
	    BUS_ChitietPN buspn = new BUS_ChitietPN();
	    int index = table_1.getSelectedRow(); // lay ra dong ma nguoi dung chon
	    if (index == -1) {
	        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
	    } else {
	        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa điện thoại này?");
	        if (luaChon == JOptionPane.YES_OPTION) {
	            DTO_ChitietPN pn = getPN();
	            boolean check = buspn.deleteCTPN(pn.getMa_PN(),pn.getMa_DT());
	            if (check) {
	            	JOptionPane.showMessageDialog(null, "OK R");
	                updateHDFromList(pn.getMa_PN());
	            }
	            xoaForm();
	        }
	    }
	}

}
