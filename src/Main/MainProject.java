package Main;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import GUI.loginForm;

public class MainProject {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    UIManager.setLookAndFeel( new FlatLightLaf()) ;
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
		loginForm login = new loginForm();
		login.setVisible(true);
	}

}