package event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BanHangForm;
import GUI.HoaDonFormBH;

public class ClickEventHDFromBanHang implements MouseListener{
	
	private HoaDonFormBH view;
	
	public ClickEventHDFromBanHang(HoaDonFormBH view) {
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.view.mouseClicked();
		this.view.switchGUI();
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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
