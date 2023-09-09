package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import event.ClickEvent;
import event.ClickEventBanHang;
import event.MouseOverEvent;
import event.MouseOverEventBanHang;
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
import javax.swing.SpringLayout;
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
public class BanHangForm extends JFrame {

	public JPanel contentPane;
	public JPanel panel_sanPham;
	public JPanel panel_hoaDon;
	public ArrayList<JPanel> jPanelList = new ArrayList<JPanel>();
	public JLabel lblNewLabel;
	public JPanel panel;
	public JPanel panel_all;
	public JPanel panel_2;
	public JPanel sanPhamJPanel;
	public LoaiDTForm loaiDTForm;
//	public TaiKhoanForm tkForm;
	public SPBanHangForm spBanHangForm;
	public HDBanHangForm hdBanHangForm;
	public SanPhamForm sanPhamForm;
	public ChucVuForm chucVuForm;
	public HoaDonForm hdForm;
	public PhieuNhapForm pnForm;
	public PhieuChiForm pcForm;
	public PanelBanHangNVForm nvForm;
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
	public JPanel spBanHangPanel;
	public JPanel hdBanHangPanel;
	private JPanel panel_NhanVien;

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
					BanHangForm frame = new BanHangForm();
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
	public BanHangForm() {
		loginForm loginForm = new loginForm();
		MouseListener ml = new MouseOverEventBanHang(this);
		MouseListener ce = new ClickEventBanHang(this);
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

		lblNewLabel = new JLabel("QUẢN LÝ CỬA HÀNG BÁN ĐIỆN THOẠI");
		lblNewLabel.setBackground(new Color(0, 0, 160));
		panel_1.add(Box.createHorizontalGlue());
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
		        	BanHangForm.this.setVisible(false);
		        }
		    }
		});
		panel_1.add(Box.createHorizontalGlue());
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon icon = new ImageIcon("C:\\JAVA\\DoAnJava\\src\\img\\DangXuat.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(-1, 60, Image.SCALE_SMOOTH); // -1: tu dong tinh toan kich thuoc sao cho phu hop
		icon.setImage(img);
		lblNewLabel_1_7.setIcon(new ImageIcon(BanHangForm.class.getResource("/img/DangXuat.png")));
		panel_1.add(lblNewLabel_1_7);
		
		panel_all = new JPanel();
		panel_all.setPreferredSize(new Dimension(247, 500)); // Thiết lập kích thước
		panel_all.setBackground(new Color(0, 255, 255));
		contentPane.add(panel_all, BorderLayout.WEST);;
		
		panel_sanPham = new JPanel();
		panel_sanPham.setBackground(new Color(0, 255, 255));
		panel_sanPham.setName("Sản phẩm");
//		panel_sanPham.setBackground(Color.yellow);
		panel_sanPham.setPreferredSize(new Dimension(250, 50));
		panel_sanPham.setLayout(null);
		panel_all.add(panel_sanPham);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(BanHangForm.class.getResource("/img/Product.png")));
		lblNewLabel_1.setBounds(10, 0, 54, 48);
		panel_sanPham.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sản phẩm");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(93, 0, 124, 48);
		panel_sanPham.add(lblNewLabel_2);
		
		panel_hoaDon = new JPanel();
		panel_hoaDon.setName("Hóa đơn");
		panel_hoaDon.setBackground(new Color(0, 255, 255));
		panel_hoaDon.setPreferredSize(new Dimension(250,50));
		panel_hoaDon.setLayout(null);
		panel_all.add(panel_hoaDon);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(BanHangForm.class.getResource("/img/Type of product.png")));
		lblNewLabel_1_2.setBounds(10, 0, 54, 48);
		panel_hoaDon.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Hóa đơn");
		lblNewLabel_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(92, 0, 124, 48);
		panel_hoaDon.add(lblNewLabel_2_2);
		
		panel_NhanVien = new JPanel();
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
		
		jPanelList.add(panel_sanPham);
		jPanelList.add(panel_hoaDon);
		jPanelList.add(panel_NhanVien);
		
		panel_2 = new JPanel();
		spBanHangForm = new SPBanHangForm();
		spBanHangPanel = spBanHangForm.getSPBanHangPanel();
		spBanHangPanel.setPreferredSize(new Dimension(spBanHangForm.getWidth()+100,spBanHangForm.getHeight()));
//		panel_2.add(spBanHangPanel);
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
				@Override
				public void mouseClicked(MouseEvent e) {
					if(jp.getName().equals("Sản phẩm")) {
						spBanHangForm = new SPBanHangForm();
						spBanHangPanel = spBanHangForm.getSPBanHangPanel();
						spBanHangPanel.setPreferredSize(new Dimension(spBanHangForm.getWidth()+100,spBanHangForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(spBanHangPanel);
						panel_2.revalidate();
						panel_2.repaint();
						contentPane.add(panel_2);
					}else if(jp.getName().equals("Hóa đơn")){
						hdBanHangForm = new HDBanHangForm();
						hdBanHangPanel = hdBanHangForm.getHoaDonJPanel();
						hdBanHangPanel.setPreferredSize(new Dimension(hdBanHangForm.getWidth()+100,hdBanHangForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(hdBanHangPanel);
						panel_2.revalidate();
						panel_2.repaint();
						contentPane.add(panel_2);
					}else {
						nvForm = new PanelBanHangNVForm();
						nvJPanel = nvForm.getKhachHangJPanel();
						nvJPanel.setPreferredSize(new Dimension(nvForm.getWidth()+100,nvForm.getHeight()));
						panel_2.removeAll();
						panel_2.add(nvJPanel);
						panel_2.revalidate();
						panel_2.repaint();
						contentPane.add(panel_2);
					}
				}
			});
		}
	}
}
