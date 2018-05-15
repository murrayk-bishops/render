import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
class MyPanel extends JPanel implements MouseInputListener {
	Point mousePos = new Point(0, 0);
	public MyPanel() {
		addMouseMotionListener(this);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
		for(int y = 0; y < 400; y++) {
			for(int x = 0; x < 400; x++) {
				float blue = 1f - Math.min(0.9f, (float)Math.sqrt(Math.pow(x - mousePos.x, 2) + Math.pow(y - mousePos.y, 2)) / 200f);
				Color c = new Color(x / 399f, y / 399f, blue);
				image.setRGB(x, y, c.getRGB());
			}
		}
		g.drawImage(image, 0, 0, null);
		if(mousePos != null) {
			g.setColor(Color.WHITE);
			g.drawRect(mousePos.x - 10, mousePos.y - 10, 20, 20);
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		mousePos = new Point(e.getX(), e.getY());
		repaint();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseDragged(MouseEvent e) {
	}
	public Dimension getPrefferesSize() {
		return new Dimension(400, 400);
	}
}
public class gr {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("FRAME");
		frame.setSize(500, 500);
		frame.add(new MyPanel());
		frame.setVisible(true);
	}
}