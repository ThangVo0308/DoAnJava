package gradient;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicLabelUI;

public class GradientLabelUI extends BasicLabelUI{
	private GradientPaint gradientPaint;

    public GradientLabelUI(GradientPaint gp) {
        gradientPaint = gp;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g.create();
        Rectangle2D r = new Rectangle2D.Double(0, 0, c.getWidth(), c.getHeight());
        g2d.setPaint(gradientPaint);
        g2d.fill(r);
        super.paint(g2d, c);
        g2d.dispose();
    }
}
