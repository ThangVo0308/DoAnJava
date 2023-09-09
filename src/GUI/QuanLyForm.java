package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

import event.ClickEvent;
import event.MouseOverEvent;
import gradient.GradientLabelUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
public class QuanLyForm extends JFrame {

	public JPanel contentPane;
	public JPanel panel_sanPham;
	public JPanel panel_loaiSP;
	public JPanel panel_hoaDon;
	public JPanel panel_NhanVien;
	public JPanel panel_khachHang;
	public JPanel panel_nhaCungCap;
	public JPanel panel_phieuNhap;
	public ArrayList<JPanel> jPanelList = new ArrayList<JPanel>();
	public JLabel lblNewLabel;
	public JPanel panel;
	public JPanel panel_all;

	public JPanel panel_2;
	public JPanel sanPhamJPanel;
	public LoaiDTForm loaiDTForm;
//	public TaiKhoanForm tkForm;
	public SanPhamForm sanPhamForm;
	public ChucVuForm chucVuForm;
	public HoaDonForm hdForm;
	public PhieuNhapForm pnForm;
	public PhieuChiForm pcForm;
	public NhanVienForm nvForm;
	public KhachHangForm khForm;
	public NCCForm nccForm;
	public ThongKeForm tkForm;
	public PhieuBHForm phForm;
	public JPanel hoaDonJPanel;
	public JPanel pnJPanel;
	public JPanel pcJPanel;
	public JPanel nvJPanel;
	public JPanel khJPanel;
	public JPanel cvJPanel;
	public JPanel nccJPanel;
	public JPanel bhJPanel;
	private JLabel lblNewLabel_1_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    UIManager.setLookAndFeel( new FlatLightLaf()) ;
				} catch( Exception ex ) {
				    System.err.println( "Failed to initialize LaF" );
				}
				try {
					QuanLyForm frame = new QuanLyForm();
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
	public QuanLyForm() {
		loginForm loginForm = new loginForm();
		MouseListener ml = new MouseOverEvent(this);
		MouseListener ce = new ClickEvent(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1185, 884);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(panel_1.getWidth(), 60));
		panel_1.setBackground(new Color(0, 255, 255));
		contentPane.add(panel_1, BorderLayout.NORTH);
										panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
										
										Component horizontalGlue = Box.createHorizontalGlue();
										panel_1.add(horizontalGlue);
								
										lblNewLabel = new JLabel("QUẢN LÝ CỬA HÀNG BÁN ĐIỆN THOẠI");
										lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel.setForeground(new Color(255, 0, 0));
										lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
										lblNewLabel.setBounds(382, 16, 425, 27);
										panel_1.add(lblNewLabel);
		
		
		lblNewLabel_1_7 = new JLabel("");
		lblNewLabel_1_7.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất?", "Thông báo", JOptionPane.YES_NO_OPTION);
		        if(luaChon == JOptionPane.YES_OPTION) {
		        	loginForm.setVisible(true);
		        	QuanLyForm.this.setVisible(false);
		        }
		    }
		});
		panel_1.add(Box.createHorizontalGlue());
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon icon = new ImageIcon("C:\\JAVA\\DoAnJava\\src\\img\\DangXuat.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(-1, 60, Image.SCALE_SMOOTH); // -1: tu dong tinh toan kich thuoc sao cho phu hop
		icon.setImage(img);
		lblNewLabel_1_7.setIcon(new ImageIcon(QuanLyForm.class.getResource("/img/DangXuat.png")));
		panel_1.add(lblNewLabel_1_7);
		
		panel_all = new JPanel();
		panel_all.setPreferredSize(new Dimension(247, 500)); // Thiết lập kích thước
		panel_all.setBackground(new Color(0, 255, 255));
		contentPane.add(panel_all, BorderLayout.WEST);
		SpringLayout sl_panel_all = new SpringLayout();
		panel_all.setLayout(sl_panel_all);
		
		panel_sanPham = new JPanel();
		sl_panel_all.putConstraint(SpringLayout.NORTH, panel_sanPham, 0, SpringLayout.NORTH, panel_all);
		sl_panel_all.putConstraint(SpringLayout.WEST, panel_sanPham, 0, SpringLayout.WEST, panel_all);
		panel_sanPham.setBackground(new Color(0, 255, 255));
		panel_sanPham.setName("Sản phẩm");
//		panel_sanPham.setBackground(Color.yellow);
		panel_sanPham.setPreferredSize(new Dimension(247, 50));
		panel_sanPham.setLayout(null);
		panel_all.add(panel_sanPham);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(QuanLyForm.class.getResource("/img/Product.png")));
		lblNewLabel_1.setBounds(10, 0, 54, 48);
		panel_sanPham.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sản phẩm");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(90, 0, 124, 48);
		panel_sanPham.add(lblNewLabel_2);
		
		panel_loaiSP = new JPanel();
		sl_panel_all.putConstraint(SpringLayout.NORTH, panel_loaiSP, 6, SpringLayout.SOUTH, panel_sanPham);
		sl_panel_all.putConstraint(SpringLayout.WEST, panel_loaiSP, -1, SpringLayout.WEST, panel_all);
		panel_loaiSP.setForeground(new Color(0, 0, 0));
		panel_loaiSP.setName("Loại SP");
		panel_loaiSP.setBackground(new Color(0, 255, 255));
		panel_loaiSP.setPreferredSize(new Dimension(250,50));
		panel_loaiSP.setLayout(null);
		panel_all.add(panel_loaiSP);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(QuanLyForm.class.getResource("/img/Type of product.png")));
		lblNewLabel_1_1.setBounds(10, 0, 54, 48);
		panel_loaiSP.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Loại sản phẩm");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(90, 0, 150, 48);
		panel_loaiSP.add(lblNewLabel_2_1);
		
		panel_hoaDon = new JPanel();
		sl_panel_all.putConstraint(SpringLayout.WEST, panel_hoaDon, -1, SpringLayout.WEST, panel_all);
		panel_hoaDon.setName("Hóa đơn");
		panel_hoaDon.setBackground(new Color(0, 255, 255));
		panel_hoaDon.setPreferredSize(new Dimension(250,50));
		panel_hoaDon.setLayout(null);
		panel_all.add(panel_hoaDon);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(QuanLyForm.class.getResource("/img/Bill.png")));
		lblNewLabel_1_2.setBounds(10, 0, 54, 48);
		panel_hoaDon.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Hóa đơn");
		lblNewLabel_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(92, 0, 124, 48);
		panel_hoaDon.add(lblNewLabel_2_2);
		
		panel_phieuNhap = new JPanel();
		sl_panel_all.putConstraint(SpringLayout.SOUTH, panel_hoaDon, -6, SpringLayout.NORTH, panel_phieuNhap);
		sl_panel_all.putConstraint(SpringLayout.NORTH, panel_phieuNhap, 170, SpringLayout.NORTH, panel_all);
		sl_panel_all.putConstraint(SpringLayout.WEST, panel_phieuNhap, -1, SpringLayout.WEST, panel_all);
		panel_phieuNhap.setName("Phiếu nhập");
		panel_phieuNhap.setBackground(new Color(0, 255, 255));
		panel_phieuNhap.setPreferredSize(new Dimension(250,50));
		panel_phieuNhap.setLayout(null);
		panel_all.add(panel_phieuNhap);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(QuanLyForm.class.getResource("/img/PhieuNhap.png")));
		lblNewLabel_1_3.setBounds(10, 0, 54, 48);
		panel_phieuNhap.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Phiếu nhập");
		lblNewLabel_2_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_3.setBounds(93, 0, 124, 48);
		panel_phieuNhap.add(lblNewLabel_2_3);
		
		JPanel panel_phieuChi = new JPanel();
		sl_panel_all.putConstraint(SpringLayout.NORTH, panel_phieuChi, 225, SpringLayout.NORTH, panel_all);
		sl_panel_all.putConstraint(SpringLayout.WEST, panel_phieuChi, -1, SpringLayout.WEST, panel_all);
		panel_phieuChi.setLayout(null);
		panel_phieuChi.setName("Phiếu chi");
		panel_phieuChi.setBackground(new Color(0, 255, 255));
		panel_phieuChi.setPreferredSize(new Dimension(250,50));
		panel_all.add(panel_phieuChi);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Phiếu chi");
		lblNewLabel_2_3_1.setName("Phiếu chi");
		lblNewLabel_2_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_3_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_3_1.setBounds(93, 0, 124, 48);
		panel_phieuChi.add(lblNewLabel_2_3_1);
		
		panel_NhanVien = new JPanel();
		sl_panel_all.putConstraint(SpringLayout.NORTH, panel_NhanVien, 280, SpringLayout.NORTH, panel_all);
		sl_panel_all.putConstraint(SpringLayout.WEST, panel_NhanVien, -1, SpringLayout.WEST, panel_all);
		panel_NhanVien.setName("Nhân viên");
		panel_NhanVien.setBackground(new Color(0, 255, 255));
		panel_NhanVien.setPreferredSize(new Dimension(250,50));
		panel_all.add(panel_NhanVien);
		panel_NhanVien.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("");
		lblNewLabel_1_4.setIcon(new ImageIcon(QuanLyForm.class.getResource("/img/Nhân viên icon.png")));
		lblNewLabel_1_4.setBounds(10, 0, 54, 48);
		panel_NhanVien.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_2_4 = new JLabel("Nhân viên");
		lblNewLabel_2_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_4.setBounds(92, 0, 124, 48);
		panel_NhanVien.add(lblNewLabel_2_4);
		
		panel_khachHang = new JPanel();
		sl_panel_all.putConstraint(SpringLayout.NORTH, panel_khachHang, 335, SpringLayout.NORTH, panel_all);
		sl_panel_all.putConstraint(SpringLayout.WEST, panel_khachHang, -1, SpringLayout.WEST, panel_all);
		panel_khachHang.setName("Khách hàng");
		panel_khachHang.setBackground(new Color(0, 255, 255));
		panel_khachHang.setPreferredSize(new Dimension(250,50));
		panel_all.add(panel_khachHang);
		panel_khachHang.setLayout(null);
		
		JLabel lblNewLabel_1_5 = new JLabel("");
		lblNewLabel_1_5.setIcon(new ImageIcon(QuanLyForm.class.getResource("/img/KhachHang.png")));
		lblNewLabel_1_5.setBounds(10, 0, 54, 48);
		panel_khachHang.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_2_5 = new JLabel("Khách hàng");
		lblNewLabel_2_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_5.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_5.setBounds(93, 0, 124, 48);
		panel_khachHang.add(lblNewLabel_2_5);
		
		panel_nhaCungCap = new JPanel();
		sl_panel_all.putConstraint(SpringLayout.NORTH, panel_nhaCungCap, 390, SpringLayout.NORTH, panel_all);
		sl_panel_all.putConstraint(SpringLayout.WEST, panel_nhaCungCap, -1, SpringLayout.WEST, panel_all);
		panel_nhaCungCap.setName("Nhà cung cấp");
		panel_nhaCungCap.setBackground(new Color(0, 255, 255));
		panel_nhaCungCap.setPreferredSize(new Dimension(250,50));
		panel_all.add(panel_nhaCungCap);
		panel_nhaCungCap.setLayout(null);
		
		JLabel lblNewLabel_1_6 = new JLabel("");
		lblNewLabel_1_6.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\NhaCungCap.png"));
		lblNewLabel_1_6.setBounds(10, 0, 54, 48);
		panel_nhaCungCap.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_2_6 = new JLabel("Nhà cung cấp");
		lblNewLabel_2_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_6.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_6.setBounds(94, 0, 124, 48);
		panel_nhaCungCap.add(lblNewLabel_2_6);
		
		JPanel panel_chucVu = new JPanel();
		sl_panel_all.putConstraint(SpringLayout.NORTH, panel_chucVu, 445, SpringLayout.NORTH, panel_all);
		sl_panel_all.putConstraint(SpringLayout.WEST, panel_chucVu, -1, SpringLayout.WEST, panel_all);
		panel_chucVu.setName("Chức vụ");
		panel_chucVu.setLayout(null);
		panel_chucVu.setBackground(new Color(0, 255, 255));
		panel_chucVu.setPreferredSize(new Dimension(250,50));
		panel_all.add(panel_chucVu);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("");
		lblNewLabel_1_6_1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\role.png"));
		lblNewLabel_1_6_1.setBounds(10, 0, 42, 48);
		panel_chucVu.add(lblNewLabel_1_6_1);
		
		JLabel lblNewLabel_2_6_1 = new JLabel("Chức vụ");
		lblNewLabel_2_6_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_6_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_6_1.setBounds(92, 0, 124, 48);
		panel_chucVu.add(lblNewLabel_2_6_1);
		
		JPanel panel_thongKe = new JPanel();
		sl_panel_all.putConstraint(SpringLayout.NORTH, panel_thongKe, 500, SpringLayout.NORTH, panel_all);
		sl_panel_all.putConstraint(SpringLayout.WEST, panel_thongKe, -1, SpringLayout.WEST, panel_all);
		panel_thongKe.setName("Thống kê");
		panel_thongKe.setLayout(null);
		panel_thongKe.setBackground(new Color(0, 255, 255));
		panel_thongKe.setPreferredSize(new Dimension(250,50));
		panel_all.add(panel_thongKe);
		
		JLabel lblNewLabel_1_6_2 = new JLabel("");
		lblNewLabel_1_6_2.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\DoAnJava (4)\\src\\img\\Thong ke.png"));
		lblNewLabel_1_6_2.setBounds(10, 0, 48, 48);
		panel_thongKe.add(lblNewLabel_1_6_2);
		
		JLabel lblNewLabel_2_6_2 = new JLabel("Thống kê");
		lblNewLabel_2_6_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_6_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_6_2.setBounds(93, 0, 124, 48);
		panel_thongKe.add(lblNewLabel_2_6_2);
		
		JPanel panel_phieuBH = new JPanel();
		sl_panel_all.putConstraint(SpringLayout.NORTH, panel_phieuBH, 555, SpringLayout.NORTH, panel_all);
		sl_panel_all.putConstraint(SpringLayout.WEST, panel_phieuBH, -1, SpringLayout.WEST, panel_all);
		panel_phieuBH.setName("Phiếu bảo hành");
		panel_phieuBH.setLayout(null);
		panel_phieuBH.setBackground(new Color(0, 255, 255));
		panel_phieuBH.setPreferredSize(new Dimension(250,50));
		panel_all.add(panel_phieuBH);
		
		JLabel lblNewLabel_1_6_3 = new JLabel("");
		lblNewLabel_1_6_3.setIcon(new ImageIcon(QuanLyForm.class.getResource("/img/PhieuBH.png")));
		lblNewLabel_1_6_3.setBounds(10, 0, 48, 48);
		panel_phieuBH.add(lblNewLabel_1_6_3);
		
		JLabel lblNewLabel_2_6_3 = new JLabel("Phiếu bảo hành");
		lblNewLabel_2_6_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_6_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_6_3.setBounds(95, 0, 145, 48);
		panel_phieuBH.add(lblNewLabel_2_6_3);
		
		jPanelList.add(panel_sanPham);
		jPanelList.add(panel_loaiSP);
		jPanelList.add(panel_hoaDon);
		jPanelList.add(panel_phieuNhap);
		jPanelList.add(panel_NhanVien);
		jPanelList.add(panel_khachHang);
		jPanelList.add(panel_nhaCungCap);
		jPanelList.add(panel_phieuChi);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("");
		lblNewLabel_1_3_1.setIcon(new ImageIcon(QuanLyForm.class.getResource("/img/Phiếu chiii.png")));
		lblNewLabel_1_3_1.setBounds(10, 0, 54, 48);
		panel_phieuChi.add(lblNewLabel_1_3_1);
		jPanelList.add(panel_chucVu);
		jPanelList.add(panel_phieuBH);
		jPanelList.add(panel_thongKe);
		
		panel_2 = new JPanel();
		sanPhamForm = new SanPhamForm();
		sanPhamJPanel = sanPhamForm.getSanPhamPanel();
		sanPhamJPanel.setPreferredSize(new Dimension(sanPhamForm.getWidth()+100,sanPhamForm.getHeight()));
//		panel_2.add(sanPhamJPanel);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		for (JPanel jPanel : jPanelList) {
			jPanel.addMouseListener(ml);
			jPanel.addMouseListener(ce);
		}
	}
	
	

	private JPanel currentPanel = null; // ko co bien nay thi khi click vao jpanel bat ki xong thi no se mat mau khi click
	public void mouseClicked() {		
	    for (JPanel jPanel : jPanelList) {
	        jPanel.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                if (currentPanel != null) {
	                    currentPanel.setBackground(Color.cyan); // khi ko dc click
	                }
	                // panel khi duoc click
	                JPanel clickedPanel = (JPanel) e.getSource();
	                clickedPanel.setBackground(Color.YELLOW);
	                currentPanel = clickedPanel;
	            }
	        }); 
	    }		
	}
	
	public void mouseHover() {		
	    for (JPanel jPanel : jPanelList) {
	        jPanel.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                if(jPanel != currentPanel) {
	                	jPanel.setBackground(Color.gray);
	                }
	                setCursor(new Cursor(Cursor.HAND_CURSOR));
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                if (jPanel != currentPanel) {
	                    jPanel.setBackground(Color.cyan);
	                }
	                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }
	        }); 
	    }		
	}

	public void switchGUI() {
		for (JPanel jp : jPanelList) {
			jp.addMouseListener(new MouseAdapter() {
				private JPanel ldtJPanel;
				private JPanel tkJPanel;

				@Override
				public void mouseClicked(MouseEvent e) {
					if(jp.getName().equals("Sản phẩm")) {
						sanPhamForm = new SanPhamForm();
						sanPhamJPanel = sanPhamForm.getSanPhamPanel();
						sanPhamJPanel.setPreferredSize(new Dimension(sanPhamForm.getWidth()+100,sanPhamForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(sanPhamJPanel);
						panel_2.revalidate();
						panel_2.repaint();
						contentPane.add(panel_2);
					}else if(jp.getName().equals("Loại SP")) {
						loaiDTForm = new LoaiDTForm();
						ldtJPanel = loaiDTForm.getloaiDTPanel();
						ldtJPanel.setPreferredSize(new Dimension(loaiDTForm.getWidth()+100,loaiDTForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(ldtJPanel);
						panel_2.revalidate();
						panel_2.repaint();
					}else if(jp.getName().equals("Hóa đơn")) {
						hdForm = new HoaDonForm();
						hoaDonJPanel = hdForm.getHoaDonJPanel();
						hoaDonJPanel.setPreferredSize(new Dimension(hdForm.getWidth()+100,hdForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(hoaDonJPanel);
						panel_2.revalidate();
						panel_2.repaint();
					}else if(jp.getName().equals("Phiếu nhập")) {
						pnForm = new PhieuNhapForm();
						pnJPanel = pnForm.getPhieuNhapJPanel();
						pnJPanel.setPreferredSize(new Dimension(pnForm.getWidth()+100,pnForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(pnJPanel);
						panel_2.revalidate();
						panel_2.repaint();
						contentPane.add(panel_2);
					}else if(jp.getName().equals("Phiếu chi")) {
						pcForm = new PhieuChiForm();
						pcJPanel = pcForm.getPhieuChiJPanel();
						pcJPanel.setPreferredSize(new Dimension(pcForm.getWidth()+100,pcForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(pcJPanel);
						panel_2.revalidate();
						panel_2.repaint();
						contentPane.add(panel_2);
					}else if(jp.getName().equals("Nhân viên")) {
						nvForm = new NhanVienForm();
						nvJPanel = nvForm.getNhanVienJPanel();
						nvJPanel.setPreferredSize(new Dimension(nvForm.getWidth()+100,nvForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(nvJPanel);
						panel_2.revalidate();
						panel_2.repaint();
						contentPane.add(panel_2);
					}else if(jp.getName().equals("Khách hàng")) {
						khForm = new KhachHangForm();
						khJPanel = khForm.getKhachHangJPanel();
						khJPanel.setPreferredSize(new Dimension(khForm.getWidth()+100,khForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(khJPanel);
						panel_2.revalidate();
						panel_2.repaint();
						contentPane.add(panel_2);
					}else if(jp.getName().equals("Chức vụ")) {
						chucVuForm = new ChucVuForm();
						cvJPanel = chucVuForm.getChucVuPanel();
						cvJPanel.setPreferredSize(new Dimension(chucVuForm.getWidth()+100,chucVuForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(cvJPanel);
						panel_2.revalidate();
						panel_2.repaint();
						contentPane.add(panel_2);
					}else if(jp.getName().equals("Nhà cung cấp")) {
						nccForm = new NCCForm();
						nccJPanel = nccForm.getNCCJPanel();
						nccJPanel.setPreferredSize(new Dimension(nccForm.getWidth()+100,nccForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(nccJPanel);
						panel_2.revalidate();
						panel_2.repaint();
						contentPane.add(panel_2);
					}else if(jp.getName().equals("Thống kê")) {
						tkForm = new ThongKeForm();
						tkJPanel = tkForm.getThongKePanel();
						tkJPanel.setPreferredSize(new Dimension(tkForm.getWidth()+100,tkForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(tkJPanel);
						panel_2.revalidate();
						panel_2.repaint();
						contentPane.add(panel_2);
					}else if(jp.getName().equals("Phiếu bảo hành")) {
						phForm = new PhieuBHForm();
						bhJPanel = phForm.getBHJPanel();
						bhJPanel.setPreferredSize(new Dimension(phForm.getWidth()+100,phForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(bhJPanel);
						panel_2.revalidate();
						panel_2.repaint();
						contentPane.add(panel_2);
					}
				}
			});
		}
	}
}
