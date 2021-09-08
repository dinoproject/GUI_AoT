package app;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel{
	private MenuCPU menuCPU;
	private MenuMonitor menuMonitor;
	private ToolbarMenu toolbarMenu;
	private MenuKeyboard menuKeyboard;
	Menu() {
		menuCPU = new MenuCPU();
		menuMonitor = new MenuMonitor();
		toolbarMenu = new ToolbarMenu();
		menuKeyboard = new MenuKeyboard();
		init();
		toolbarMenu.setDisplay(e -> {
			if(e.getText().equals("CPU")) {
				remove(menuMonitor);
				remove(menuKeyboard);
				add(menuCPU);
				revalidate();
		        repaint();
			}else if(e.getText().equals("Monitor")) {
				remove(menuCPU);
				remove(menuKeyboard);
				add(menuMonitor);
				revalidate();
		        repaint();
			}else if(e.getText().equals("Keyboard")) {
				remove(menuCPU);
				remove(menuMonitor);
				add(menuKeyboard);
				revalidate();
		        repaint();
			}
		});
	}
	public void init() {
		setBounds(175, 0, 560, 400);
		setLayout(null);
		add(toolbarMenu);
		add(menuCPU);
	}
}
