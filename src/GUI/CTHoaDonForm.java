package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.BUS_ChitietHD;
import BUS.BUS_Dienthoai;
import BUS.BUS_Hoadon;
import DTO.DTO_ChitietHD;
import DTO.DTO_Dienthoai;
import DTO.DTO_Hoadon;
import DTO.DTO_LoaiDT;
import javax.swing.ImageIcon;

public class CTHoaDonForm extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTextField textField_1;
	private JTextField textField_SL;
	private JTextField textField_maHD;
	private JTextField textField_tongTien;
	private JComboBox comboBox_maDT;
	public ArrayList<DTO_ChitietHD> test = new ArrayList<>();
	BUS_Dienthoai busdt = new BUS_Dienthoai();
	public int count = 0;
	public int checkClicked = -1; // nguoi dung chua an nut nao
	public JPanel panel_tong;
	public JLabel lblNewLabel;
	public int tongTienHD = 0;
	BUS_ChitietHD bushd = new BUS_ChitietHD();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CTHoaDonForm frame = new CTHoaDonForm();
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
	public CTHoaDonForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 781, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
	
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 95, 263, 58, 119, 123, 0, 0};
		gbl_contentPane.rowHeights = new int[]{70, 38, 39, 36, 39, 0, 0, 0, 0, 0, 0, 139, 114, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblChiTitPhiu = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblChiTitPhiu.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTitPhiu.setFont(new Font("Times New Roman", Font.BOLD, 24));
		GridBagConstraints gbc_lblChiTitPhiu = new GridBagConstraints();
		gbc_lblChiTitPhiu.insets = new Insets(0, 0, 5, 0);
		gbc_lblChiTitPhiu.gridwidth = 7;
		gbc_lblChiTitPhiu.gridx = 0;
		gbc_lblChiTitPhiu.gridy = 0;
		contentPane.add(lblChiTitPhiu, gbc_lblChiTitPhiu);
		
		JLabel lblMaPhieuNhap = new JLabel("Mã hóa đơn");
		lblMaPhieuNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblMaPhieuNhap = new GridBagConstraints();
		gbc_lblMaPhieuNhap.fill = GridBagConstraints.VERTICAL;
		gbc_lblMaPhieuNhap.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaPhieuNhap.gridx = 1;
		gbc_lblMaPhieuNhap.gridy = 1;
		contentPane.add(lblMaPhieuNhap, gbc_lblMaPhieuNhap);
		
		textField_maHD = new JTextField();
		textField_maHD.setText("");
		textField_maHD.setEditable(false);
		textField_maHD.setColumns(10);
		GridBagConstraints gbc_textField_maHD = new GridBagConstraints();
		gbc_textField_maHD.insets = new Insets(0, 0, 5, 5);
		gbc_textField_maHD.fill = GridBagConstraints.BOTH;
		gbc_textField_maHD.gridx = 2;
		gbc_textField_maHD.gridy = 1;
		contentPane.add(textField_maHD, gbc_textField_maHD);
		
		JLabel lblMinThoi = new JLabel("Mã điện thoại");
		lblMinThoi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblMinThoi = new GridBagConstraints();
		gbc_lblMinThoi.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinThoi.gridx = 1;
		gbc_lblMinThoi.gridy = 2;
		contentPane.add(lblMinThoi, gbc_lblMinThoi);
		
		comboBox_maDT = new JComboBox();
		comboBox_maDT.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox_maDT = new GridBagConstraints();
		gbc_comboBox_maDT.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_maDT.fill = GridBagConstraints.BOTH;
		gbc_comboBox_maDT.gridx = 2;
		gbc_comboBox_maDT.gridy = 2;
		contentPane.add(comboBox_maDT, gbc_comboBox_maDT);
		comboBox_maDT.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (comboBox_maDT.getSelectedIndex() != -1) {
		            String selectedMaDT = (String) comboBox_maDT.getSelectedItem();
		            getPriceProduct(selectedMaDT);
		        }
		    }
		});
		
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(CTHoaDonForm.class.getResource("/img/add.png")));
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
		gbc_btnThem.gridx = 4;
		gbc_btnThem.gridy = 2;
		contentPane.add(btnThem, gbc_btnThem);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setIcon(new ImageIcon(CTHoaDonForm.class.getResource("/img/sua.png")));
		btnSa.addActionListener(new ActionListener() {
		    BUS_ChitietHD buscthd = new BUS_ChitietHD();

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
		            System.out.println("test modelIndex: " + modelIndex);
		            if (modelIndex == -1) {
		                JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                String currentMaHD = textField_maHD.getText();
		                String currentMaDT = comboBox_maDT.getSelectedItem() + "";
		                int index1 = 0;
		                int index2 = 0;
		                System.out.println("haha: "+comboBox_maDT.getSelectedItem());
		                for (DTO_Dienthoai dt : busdt.getListDT()) {
		                    if (dt.getMa_DT().equals(comboBox_maDT.getSelectedItem())) {
		                        index1 = index2;
		                        break;
		                    } else {
		                        index2++;
		                    }
		                }
		                int SL = busdt.getListDT().get(index1).getSL();
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
		                
		                if (SL < soLuong) {
		                    JOptionPane.showMessageDialog(null, "Số lượng điện thoại bạn cần mua không đủ số lượng để đáp ứng");
		                    return;
		                } else if (SL == 0) {
		                    JOptionPane.showMessageDialog(null, "Điện thoại này đã hết hàng");
		                    return;
		                }
		                // maDT cu~ truoc khi sua
		                String maDT = null;

		                if (selectedRow != -1) {
		                    maDT = table_1.getValueAt(selectedRow, 1).toString();
		                }
		                boolean isMaDTFound = false;
		                System.out.println("MaDT trước khi sửa: " + maDT);
		                // Kiểm tra dòng đang chọn và bỏ qua
		                for (int i = 0; i < table_1.getRowCount(); i++) {
		                    if (i == viewIndex) {
		                        continue; 
		                    }
		                    String maDT1 = table_1.getValueAt(i, 1).toString();
		                    System.out.println("maDT1: " + maDT1);
		                    if (currentMaDT.equals(maDT1)) {
		                        JOptionPane.showMessageDialog(null, "Mã điện thoại này đã tồn tại, vui lòng sửa ở phần số lượng và giá");
		                        isMaDTFound = true;
		                        break;
		                    } else {
		                    	isMaDTFound = false;
		                    }
		                }
		                System.out.println("check coi: "+isMaDTFound);
//		                HoaDonForm hdForm = new HoaDonForm();
		                boolean isUpdateStarted = false;
		                if (isMaDTFound == false) {
		                    for (int i = 0; i < table_1.getRowCount(); i++) {
		                        String maHD = table_1.getValueAt(i, 0).toString();
		                        String maDT5 = table_1.getValueAt(i, 1).toString();
		                        String checkExist = table_1.getValueAt(i, 4).toString();
		                        boolean check = checkExist.contains("Tồn tại") ? true : false;
		                        System.out.println("LAM ON: "+check);
		                        if (currentMaHD.equals(maHD) && maDT.equals(maDT5) && check == true) {
		                            buscthd.update(currentMaHD, maDT5, currentMaDT, soLuong, Integer.parseInt(textField_tongTien.getText().trim()), true);
		                            updateHDFromList(currentMaHD);
		                            isUpdateStarted = true;
		                            break;
		                        }
		                    }
		                    System.out.println("CHECK COI: "+isUpdateStarted);
		                }
		                else {
			                buscthd.update(currentMaHD, comboBox_maDT.getSelectedItem().toString(), currentMaDT, soLuong, Integer.parseInt(textField_tongTien.getText().trim()), true);
//			                updateHDFromList(textField_maHD.getText());
		                }

		            }
		        } else {
		            suaHD();
		        }
		    }
		});

		btnSa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSa.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnSa = new GridBagConstraints();
		gbc_btnSa.fill = GridBagConstraints.BOTH;
		gbc_btnSa.insets = new Insets(0, 0, 5, 5);
		gbc_btnSa.gridx = 5;
		gbc_btnSa.gridy = 2;
		contentPane.add(btnSa, gbc_btnSa);
		
		JLabel lblMinThoi_1 = new JLabel("Số lượng");
		lblMinThoi_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
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
		btnThem_1_1.setIcon(new ImageIcon(CTHoaDonForm.class.getResource("/img/delete.png")));
		btnThem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaHD();
			}
		});
		btnThem_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem_1_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem_1_1 = new GridBagConstraints();
		gbc_btnThem_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnThem_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem_1_1.gridx = 4;
		gbc_btnThem_1_1.gridy = 3;
		contentPane.add(btnThem_1_1, gbc_btnThem_1_1);
		
		JButton btnThem_1_1_1 = new JButton("Reset");
		btnThem_1_1_1.setIcon(new ImageIcon(CTHoaDonForm.class.getResource("/img/reload.png")));
		btnThem_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaForm();
			}
		});
		btnThem_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem_1_1_1.setBackground(new Color(226, 221, 221));
		GridBagConstraints gbc_btnThem_1_1_1 = new GridBagConstraints();
		gbc_btnThem_1_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnThem_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem_1_1_1.gridx = 5;
		gbc_btnThem_1_1_1.gridy = 3;
		contentPane.add(btnThem_1_1_1, gbc_btnThem_1_1_1);
		
		JLabel lblMinThoi_1_1 = new JLabel("Giá");
		lblMinThoi_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblMinThoi_1_1 = new GridBagConstraints();
		gbc_lblMinThoi_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinThoi_1_1.gridx = 1;
		gbc_lblMinThoi_1_1.gridy = 4;
		contentPane.add(lblMinThoi_1_1, gbc_lblMinThoi_1_1);
		
		textField_tongTien = new JTextField();
		textField_tongTien.setEnabled(false);
		textField_tongTien.setEditable(false);
		textField_tongTien.setText("0");
		textField_tongTien.setColumns(10);
		GridBagConstraints gbc_textField_tongTien = new GridBagConstraints();
		gbc_textField_tongTien.insets = new Insets(0, 0, 5, 5);
		gbc_textField_tongTien.fill = GridBagConstraints.BOTH;
		gbc_textField_tongTien.gridx = 2;
		gbc_textField_tongTien.gridy = 4;
		contentPane.add(textField_tongTien, gbc_textField_tongTien);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm: ");
		lblTimKiem.setToolTipText("Tìm kiếm");
		lblTimKiem.setForeground(Color.RED);
		lblTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
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
		btnThem_1_1_2.setIcon(new ImageIcon(CTHoaDonForm.class.getResource("/img/search.png")));
		btnThem_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
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
					"Mã hóa đơn", "Mã điện thoại" ,"Số lượng","Giá","Trạng thái"
			}
		));
		table_1.setRowHeight(50);
		table_1.setBounds(1, 25, 922, -2);
		table_1.setDefaultEditor(Object.class, null);
		contentPane.add(table_1);
		
		JLabel lblMinThoi_1_1_1 = new JLabel("Tổng giá");
		lblMinThoi_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblMinThoi_1_1_1 = new GridBagConstraints();
		gbc_lblMinThoi_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinThoi_1_1_1.gridx = 4;
		gbc_lblMinThoi_1_1_1.gridy = 14;
		contentPane.add(lblMinThoi_1_1_1, gbc_lblMinThoi_1_1_1);
		
		panel_tong = new JPanel();
		panel_tong.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_panel_tong = new GridBagConstraints();
		gbc_panel_tong.insets = new Insets(0, 0, 5, 5);
		gbc_panel_tong.fill = GridBagConstraints.BOTH;
		gbc_panel_tong.gridx = 5;
		gbc_panel_tong.gridy = 14;
		contentPane.add(panel_tong, gbc_panel_tong);
		
		lblNewLabel = new JLabel("");
		panel_tong.add(lblNewLabel);
		
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setEnabled(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 10;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		for (DTO_Dienthoai dt : busdt.getListDT()) {
			comboBox_maDT.addItem(dt.getMa_DT());
		}
		
		showCurrentMaHD(textField_maHD.getText()+"");
		
		
	}
	
	public JPanel getHoaDonJPanel() {
		return contentPane;
	}
	
	public boolean checkInput() {
		if(this.textField_maHD.getText().equals("") ||  this.textField_tongTien.getText().equals("") ||  this.comboBox_maDT.getSelectedIndex() == -1 || this.textField_SL.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}
		try {
			int gia = Integer.parseInt(this.textField_tongTien.getText()+"");
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Tổng tiền phải là kiểu số");
			return false;
		}
		return true;
	}
	
	public void showCurrentMaHD(String maHD) {
		textField_maHD.setText(maHD+"");
		textField_maHD.setEditable(false);
	}
	
	public void themHDVaoTable(DTO_ChitietHD hd) {
		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.addRow(new Object[]{hd.getMaHD()+"",hd.getMaDT()+"",hd.getSL()+"",hd.getGia()+"",hd.isCheck_exist()+""});
		updateHDFromList(hd.getMaHD());
		xoaForm();
	}
	
	public void getPriceProduct(String maDT) {
		BUS_Dienthoai busdt = new BUS_Dienthoai();
		for(int i =0 ; i < busdt.getListDT().size() ; i++) {
			if(maDT.equals(busdt.getListDT().get(i).getMa_DT())) {
				textField_tongTien.setText(busdt.getListDT().get(i).getGiaTien()+"");
				break;
			}
		}
	}
	
	public void updateHDFromList(String maHD) {
		test.clear();
		BUS_ChitietHD bushd = new BUS_ChitietHD();
	    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
	    model_table.setRowCount(0);

	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(SwingConstants.CENTER);

	    for (DTO_ChitietHD hd : bushd.getListCTHD()) {
	    	String text = null;
	        if (hd.isCheck_exist()) {
	        	text = "<html><font color='green' style='font-weight:bold;'>Tồn tại</font></html>";
	        } else {
	            text = "<html><font color='red' style='font-weight: bold;'>Đã xóa</font></html>";
	        }
	    	if(hd.getMaHD().equals(maHD) && hd.isCheck_exist()) {
	    		 model_table.addRow(new Object[]{hd.getMaHD()+"",hd.getMaDT()+"",hd.getSL()+"",getGiaTienFormatted(Integer.parseInt(hd.getGia()+"")),text});
	    	}
	    }
	    xoaForm();
		for (DTO_ChitietHD ldt : bushd.getListCTHD()) {
			test.add(ldt);
		}
		int tong = 0;
		for (DTO_ChitietHD ct : test) {
			if(ct.getMaHD().equals(maHD) && ct.isCheck_exist() == true) {
				tong += ct.getGia() * ct.getSL();
			}
		}
		tongTienHD = tong;
		lblNewLabel.setText(getGiaTienFormatted(tong));
	}


	public int getTongTien(String maHD) {
		updateHDFromList(maHD);
		return tongTienHD;
	}
	
	public void xoaForm() {
		textField_tongTien.setText("");
		comboBox_maDT.setSelectedIndex(-1);
		textField_SL.setText("");
	}
	
	public String getGiaTienFormatted(int gia) {
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
	    return formatter.format(gia)+" VNĐ";
	}
	
	public void themHD() {
		 BUS_ChitietHD bushd = new BUS_ChitietHD();
		 BUS_Dienthoai busdt = new BUS_Dienthoai();
		 for (DTO_ChitietHD cthd : bushd.getListCTHD()) {
			if(cthd.getMaHD().equals(this.textField_maHD.getText()+"") && cthd.getMaDT().equals(this.comboBox_maDT.getSelectedItem()+"") && cthd.isCheck_exist() == true) {
				JOptionPane.showMessageDialog(null, "Mã điện thoại đã tồn tại");
				return;
			}
		}
		 int index = 0;
		 int index1 = 0;
		 System.out.println(comboBox_maDT.getSelectedItem());
		 for (DTO_Dienthoai dt : busdt.getListDT()) {
			if(dt.getMa_DT().equals(comboBox_maDT.getSelectedItem())) {
				index1 = index;
				break;
			}else {
				index++;				
			}
		}
		 System.out.println("index1: "+index1);
		 int SL = busdt.getListDT().get(index1).getSL();
		 if(SL < Integer.parseInt(this.textField_SL.getText()+"")) {
			 JOptionPane.showMessageDialog(null, "Số lượng điện thoại bạn cần mua không đủ số lượng để đáp ứng");
			 return;
		 }else if(SL == 0) {
			 JOptionPane.showMessageDialog(null, "Điện thoại này đã hết hàng");
			 return;
		 }
		 boolean result = bushd.addHDToTable(this.textField_maHD.getText()+"", comboBox_maDT.getSelectedItem()+"", Integer.parseInt(this.textField_SL.getText()+""),Integer.parseInt(this.textField_tongTien.getText()+""),true);
		 if (result) {
		        themHDVaoTable(bushd.getListCTHD().get(bushd.getListCTHD().size() - 1));
		        HoaDonForm hoaDonForm = new HoaDonForm();
		        if (hoaDonForm != null) {
	                hoaDonForm.updateHDFromList();
	            }
		 }else {
		    	JOptionPane.showMessageDialog(null, "Thêm thất bại");
		    }
		 updateHDFromList(this.textField_maHD.getText());
		 xoaForm();
	}


	public DTO_ChitietHD getHD() {
	    DefaultTableModel model_HD = (DefaultTableModel) table_1.getModel();
	    int index = table_1.getSelectedRow();
	    int modelIndex = table_1.convertRowIndexToModel(index);
	    String maHD = (String) model_HD.getValueAt(modelIndex, 0);
	    String maDT = (String) model_HD.getValueAt(modelIndex, 1);
	    String SLString = model_HD.getValueAt(modelIndex, 2).toString();
	    int SL = Integer.parseInt(SLString);
	    String giaString = (String) model_HD.getValueAt(modelIndex, 3);
	    int indexGia = giaString.indexOf(" VNĐ");
	    String getStringGia = giaString.substring(0, indexGia);
	    getStringGia = getStringGia.replace(",", "");
	    System.out.println(getStringGia);
	    int gia = Integer.parseInt(getStringGia);

	    DTO_ChitietHD cthd = new DTO_ChitietHD(maHD, maDT, SL, gia, true);
	    return cthd;
	}

	
	public void suaHD() {
		int index = table_1.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn sửa");
		}else {
			DTO_ChitietHD hd = getHD();
			this.textField_maHD.setText(hd.getMaHD()+"");
			this.textField_tongTien.setText(hd.getGia()+"");	
			this.textField_SL.setText(hd.getSL()+"");	
			this.comboBox_maDT.setSelectedItem(hd.getMaDT()+"");
		}
	}
	
	public void xoaHD() {
	    BUS_ChitietHD bushd = new BUS_ChitietHD();
	    int index = table_1.getSelectedRow(); // lay ra dong ma nguoi dung chon
	    if (index == -1) {
	        JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
	    } else {
	        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa điện thoại này?");
	        if (luaChon == JOptionPane.YES_OPTION) {
	            DTO_ChitietHD hd = getHD();
	            boolean check = bushd.deleteCTHD(hd.getMaHD(),hd.getMaDT());
	            if (check) {
//	                table_1.getModel().setValueAt(false, index, 5); // Cập nhật giá trị của cột "check_exist" thành false
//	                hd.setCheck_exist(false);
	            	JOptionPane.showMessageDialog(null, "OK R");
	            	System.out.println("RA GIUM EM");
	                updateHDFromList(hd.getMaHD());
	            }
	            xoaForm();
	        }
	    }
	}
	
}
