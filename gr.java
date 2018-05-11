import javax.swing.*;
import java.awt.*;
class MyPanel extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.green);
		g.drawRect(0, 0, 200, 200);
		for(int x = 0; x < 200; x++) {
			Color c = new Color(x / 199f, 0f, 0f);
			g.setColor(c);
			g.drawLine(x, 0, x, 199);
		}
	}
	public Dimension getPrefferedSize() {
		return new Dimension(200, 200);
	}
}
public class gr {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("FRAME");
		frame.setSize(201, 201);
		frame.setVisible(true);
		frame.add(new MyPanel());
	}
}