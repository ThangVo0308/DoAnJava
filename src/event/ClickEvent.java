package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BanHangForm;
import GUI.QuanLyForm;

public class ClickEvent implements MouseListener{
	private QuanLyForm view;
	
	public ClickEvent(QuanLyForm view) {
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
