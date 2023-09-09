package event;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import java.awt.event.MouseEvent;

import GUI.BanHangForm;
import GUI.HoaDonFormBH;
import GUI.QuanLyForm;

public class MouseOverEventBanHang implements MouseListener{
	private BanHangForm view; 
	private Color hoverColor;

    public MouseOverEventBanHang(BanHangForm view) {
        this.view = view;
    }
    
    
    public void mouseEntered1(MouseEvent e) {
        this.view.panel_sanPham.setBackground(hoverColor);
    }

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		this.view.mouseHover();
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		this.view.mouseHover();
	}

}
