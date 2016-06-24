/*Bryon Fields
 * 
 * 
 * class SysytemInfoApplication contains the main 
 * method and JFrame attributes; instantiates GUI.
 */

package edu.grcc.co217;


import javax.swing.JFrame;


public class SystemInfoApplication   {

	

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		GUI gui = new GUI();
		frame.add(gui);
		frame.setTitle("System Information Application");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 250);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}

