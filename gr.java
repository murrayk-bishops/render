import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
class MyPanel extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
		for(int y = 0; y < 400; y++) {
			for(int x = 0; x < 400; x++) {
				Color c = new Color(x / 399f, y / 399f, 1f - (float)Math.sqrt(Math.pow(x - 200, 2) + Math.pow(y - 200, 2)) / 400f);
				image.setRGB(x, y, c.getRGB());
			}
		}
		g.drawImage(image, 0, 0, null);
	}
	public Dimension getPrefferedSize() {
		return new Dimension(400, 400);
	}
}
public class gr {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("FRAME");
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.add(new MyPanel());
	}
}