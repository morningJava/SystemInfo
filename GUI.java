/*Bryon Fields
 * CO217
 * 
 * GUI class builds the JPanels, buttons and text area
 * for display. The serialize and deserialize methods are here
 * and are called in the relevant button action listener.
 */

package edu.grcc.co217;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class GUI extends JPanel {
	private static final String SYSTEM_INFO_FILENAME = "src/main/resources/system.info";
	private static final long serialVersionUID = 1L;
	
	private JButton jbtnNew = new JButton("Show System Information");
	private JButton jbtnSave = new JButton("Save System Information");
	private JButton jbtnLoad = new JButton("Load Saved Information");

	private JPanel jpnlButtons = new JPanel();
	private JPanel jpnlText = new JPanel();
   
	private JTextArea lblInfo = new JTextArea();
	SystemInfo newInfo = new SystemInfo();

	public GUI() {
		setLayout(new BorderLayout());
			
		lblInfo.setEditable(false);
		lblInfo.setPreferredSize(new Dimension(300,150));
		lblInfo.setBorder(BorderFactory.createLoweredBevelBorder());
		jpnlText.add(lblInfo);

		//displays system information & enables Save button 
		jbtnNew.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(null, //for user name field
						"Please enter your name.");
				
				newInfo.setName(input);//sets the user name field
				lblInfo.setText(newInfo.toString());//displays toString in text area
				jbtnSave.setEnabled(true);//enables save button

			}

		});
		
		jbtnSave.setEnabled(false);// Save button disabled until jbtNew Action Listener is called
		jbtnSave.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {  //serializes system information
				try {
					serializeSystemInfo(newInfo);
				} catch (IOException e1) {
					JOptionPane
							.showMessageDialog(
									null,
									"You must display the information before you can save it.",
									"ERROR", JOptionPane.ERROR_MESSAGE);//just in case something weird
					                                                    // happens when saving information

				}

			}
		});

		jbtnLoad.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e1) {
				try {
					SystemInfo loadedInfo =  deserializeSystemInfo() ;
					lblInfo.setText(loadedInfo.toString());
					repaint();
					
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Class Not Found.",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "File Not Found",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		jpnlButtons.add(jbtnNew);
		jpnlButtons.add(jbtnSave);
		jpnlButtons.add(jbtnLoad);
		add(jpnlText,BorderLayout.CENTER);
		add(jpnlButtons, BorderLayout.SOUTH);
		
	}

	/*
	 Serialize method
	 */
	public static void serializeSystemInfo(final SystemInfo info)
			throws IOException {
		ObjectOutputStream output = null;
		try {
			output = new ObjectOutputStream(new FileOutputStream(
					SYSTEM_INFO_FILENAME));
			output.writeObject(info);
		} finally {
			if (output != null) {
				output.close();//closes output stream
			}
		}
	}

	/*
	 De-serialize method
	 */
	public static SystemInfo deserializeSystemInfo() throws IOException,
			ClassNotFoundException {
		ObjectInputStream input = null;
		SystemInfo info = null;

		try {
			input = new ObjectInputStream(new FileInputStream(
					SYSTEM_INFO_FILENAME));
			info = (SystemInfo) input.readObject();
		} finally {
			if (input != null) {
				try {
					input.close();//closes input stream
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,
							"Non-fatal error closing input file", "ERROR",
							JOptionPane.ERROR_MESSAGE);

				}
			}
		}
		return info;
	}
}
