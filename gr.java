import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
class MyPanel extends JPanel implements MouseInputListener {
	Point mousePos = null;
	double[][] cubeMesh = {
			{0.5d, 0.5d, 3d},
			{0.5d, 0.5d, 4d},
			{0.5d, 2d, 3d},
			{0.5d, 2d, 4d},
			{2d, 0.5d, 3d},
			{2d, 0.5d, 4d},
			{2d, 2d, 3d},
			{2d, 2d, 4d},
	};
	double[][] tetraMesh = {
			{0f, -1f, 0f},
			{0f, 0f, 0f},
			{1f, 0f, 0f},
			{0f, 0f, 1f},
			{-1f, 0f, 0f},
			{0f, 0f, 0f},
			{0f, 0f, 1f},
			{0f, 1f, 0f},
			{0f, 0f, -1f},
			{0f, 0f, 0f},
			{0f, 1f, 0f},
			{1f, 0f, 0f},
			{0.577350f, 0.577350f, 0.577350f},
			{0f, 0f, 1f},
			{1f, 0f, 0f},
			{0f, 1f, 0f}
	};
	public MyPanel() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
		for(int x = 0; x < 400; x++) {
			for(int y = 0; y < 400; y++) {
				image.setRGB(x, y, Color.WHITE.getRGB());
			}
		}
		double dep;
		if(mousePos == null) {
			dep = 0d;
		} else {
			dep = (double)mousePos.y;
		}
		for(int t = 0; t < tetraMesh.length / 4; t++) {
			for(int v = 1; v <= 3; v++) {
				int i = 4 * t + v;
				double x = (tetraMesh[i][0] + 1) / (tetraMesh[i][2] + dep / 100);
				double y = (tetraMesh[i][1] + 1) / (tetraMesh[i][2] + dep / 100);
				if(x < 1d && x > -1d && y < 1d && y > -1d) {
					image.setRGB((int)(x * 200 + 200), (int)(y * -200 + 200), new Color(0f, 0f, 1f).getRGB());
				}
			}
		}
		g.drawImage(image, 0, 0, null);
	}
	public static double[][] mulm(double[][] a, double[][] b) {
		if(a[0].length != b.length) {
			throw new IllegalArgumentException("Matrices cannot multiply!");
		}
		double[][] result = new double[b[0].length][a.length];
		for(int bCol = 0; bCol < b[0].length; bCol++) {
			for(int aRow = 0; aRow < a.length; aRow++) {
				double dot = 0;
				for(int aVal = 0; aVal < a[0].length; aVal++) {
					dot += a[aRow][aVal] * b[aVal][bCol];
				}
				result[aRow][bCol] = dot;
			}
		}
		return result;
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
		mousePos = null;
		repaint();
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