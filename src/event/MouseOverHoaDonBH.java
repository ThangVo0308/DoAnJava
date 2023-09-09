package event;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BanHangForm;
import GUI.HoaDonFormBH;

public class MouseOverHoaDonBH implements MouseListener{
	
	private HoaDonFormBH view; 
	private Color hoverColor;

    public MouseOverHoaDonBH(HoaDonFormBH view) {
        this.view = view;
    }
    
    public void mouseEntered1(MouseEvent e) {
        this.view.panel_hoaDon.setBackground(hoverColor);
    }
    
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.view.mouseHover();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
