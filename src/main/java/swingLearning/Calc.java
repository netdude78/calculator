package swingLearning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calc extends JFrame {

	private JPanel contentPane;
	private final JButton oneBtn = new JButton("1");
	private final JButton twoBtn = new JButton("2");
	private final JButton threeBtn = new JButton("3");
	private final JButton plusBtn = new JButton("+");
	private final JButton fourBtn = new JButton("4");
	private final JButton fiveBtn = new JButton("5");
	private final JButton sixBtn = new JButton("6");
	private final JButton minusBtn = new JButton("-");
	private final JButton sevenBtn = new JButton("7");
	private final JButton eightBtn = new JButton("8");
	private final JButton nineBtn = new JButton("9");
	private final JButton timesBtn = new JButton("*");
	private final JButton zeroBtn = new JButton("0");
	private final JButton decimalBtn = new JButton(".");
	private final JButton equalsBtn = new JButton("=");
	private final JButton divideBtn = new JButton("/");
	private final JTextField inputOutputText = new JTextField();
	private final JButton clearBtn = new JButton("CA");
	
	private JButton operation;
	private double first_number, second_number;
	
	private final Color bgDefault = new Color(238,238,238);
	private final Color bgRed = new Color(255,0,0);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc frame = new Calc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calc() {
		inputOutputText.setHorizontalAlignment(SwingConstants.RIGHT);
		inputOutputText.setBounds(58, 6, 196, 40);
		inputOutputText.setColumns(20);
		initGUI();
	}
	
	private void appendTextToIO(String t) {
		inputOutputText.setText(inputOutputText.getText() + t);
	}
	
	private void handleButtonPress(JButton b) {
		switch (b.getText()) {
			case "/":
				// handle division
				b.setOpaque(true);
				b.setBackground(bgRed);
				try {
					first_number = Double.parseDouble(inputOutputText.getText());
				} catch (Exception e) {
					inputOutputText.setText("Error");
					operation = null;
					first_number = 0;
					second_number = 0;
					b.setBackground(bgDefault);
					b.setOpaque(false);
					break;
				}
				operation = b;
				inputOutputText.setText("");				
				break;

			case "*":
				// handle multiplication
				b.setOpaque(true);
				b.setBackground(bgRed);
				try {
					first_number = Double.parseDouble(inputOutputText.getText());
				} catch (Exception e) {
					inputOutputText.setText("Error");
					operation = null;
					first_number = 0;
					second_number = 0;
					b.setBackground(bgDefault);
					b.setOpaque(false);
					break;
				}
				operation = b;
				inputOutputText.setText("");				
				break;
				
			case "+":
				b.setOpaque(true);
				b.setBackground(bgRed);
				try {
					first_number = Double.parseDouble(inputOutputText.getText());
				} catch (Exception e) {
					inputOutputText.setText("Error");
					operation = null;
					first_number = 0;
					second_number = 0;
					b.setBackground(bgDefault);
					b.setOpaque(false);
					break;
				}
				operation = b;
				inputOutputText.setText("");				
				break;
				
			case "-":
				// handle subtraction
				b.setOpaque(true);
				b.setBackground(bgRed);
				try {
					first_number = Double.parseDouble(inputOutputText.getText());
				} catch (Exception e) {
					inputOutputText.setText("Error");
					operation = null;
					first_number = 0;
					second_number = 0;
					b.setBackground(bgDefault);
					b.setOpaque(false);
					break;
				}
				operation = b;
				inputOutputText.setText("");				
				break;
	
			case "=":
				if (operation == null) {
					inputOutputText.setText("Error");
				} else {
					switch (operation.getText()) {
						case "+":
							try {
								second_number = Double.parseDouble(inputOutputText.getText());
								operation.setBackground(bgDefault);
								operation.setOpaque(false);
								double result = first_number + second_number;
								inputOutputText.setText(Double.toString(result));
							} catch (Exception e) {
								operation.setBackground(bgDefault);
								operation.setOpaque(true);
								operation = null;
								first_number = 0;
								second_number = 0;
								inputOutputText.setText("Error");
							}
							break;
						case "-":
							try {
								second_number = Double.parseDouble(inputOutputText.getText());
								operation.setBackground(bgDefault);
								operation.setOpaque(false);
								double result = first_number - second_number;
								inputOutputText.setText(Double.toString(result));
							} catch (Exception e) {
								operation.setBackground(bgDefault);
								operation.setOpaque(true);
								operation = null;
								first_number = 0;
								second_number = 0;
								inputOutputText.setText("Error");
							}
							break;
						case "*":
							try {
								second_number = Double.parseDouble(inputOutputText.getText());
								operation.setBackground(bgDefault);
								operation.setOpaque(false);
								double result = first_number * second_number;
								inputOutputText.setText(Double.toString(result));
							} catch (Exception e) {
								operation.setBackground(bgDefault);
								operation.setOpaque(true);
								operation = null;
								first_number = 0;
								second_number = 0;
								inputOutputText.setText("Error");
							}
							break;
						case "/":
							try {
								second_number = Double.parseDouble(inputOutputText.getText());
								operation.setBackground(bgDefault);
								operation.setOpaque(false);
								double result = first_number / second_number;
								inputOutputText.setText(Double.toString(result));
							} catch (Exception e) {
								operation.setBackground(bgDefault);
								operation.setOpaque(true);
								operation = null;
								first_number = 0;
								second_number = 0;
								inputOutputText.setText("Error");
							}
							break;
					}
				}
				break;
				
			default:
				appendTextToIO(b.getText());
				break;
		}
		inputOutputText.requestFocus();
		inputOutputText.select(0,0);
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		oneBtn.addActionListener((arg0) -> handleButtonPress(oneBtn));
		oneBtn.setBounds(58, 157, 40, 40);
		contentPane.add(oneBtn);
		
		twoBtn.addActionListener((arg0) -> handleButtonPress(twoBtn));
		twoBtn.setBounds(110, 157, 40, 40);
		contentPane.add(twoBtn);

		threeBtn.addActionListener((arg0) -> handleButtonPress(threeBtn));
		threeBtn.setBounds(162, 157, 40, 40);
		contentPane.add(threeBtn);

		plusBtn.addActionListener((arg0) -> handleButtonPress(plusBtn));
		plusBtn.setBounds(214, 53, 40, 40);
		contentPane.add(plusBtn);
		
		fourBtn.addActionListener((arg0) -> handleButtonPress(fourBtn));
		fourBtn.setBounds(58, 105, 40, 40);
		contentPane.add(fourBtn);
		
		fiveBtn.addActionListener((arg0) -> handleButtonPress(fiveBtn));
		fiveBtn.setBounds(110, 105, 40, 40);
		contentPane.add(fiveBtn);
		
		sixBtn.addActionListener((arg0) -> handleButtonPress(sixBtn));
		sixBtn.setBounds(162, 105, 40, 40);		
		contentPane.add(sixBtn);
		
		minusBtn.setBounds(214, 105, 40, 40);
		minusBtn.addActionListener((arg0) -> handleButtonPress(minusBtn));
		contentPane.add(minusBtn);
		
		sevenBtn.addActionListener((arg0) -> handleButtonPress(sevenBtn));
		sevenBtn.setBounds(58, 53, 40, 40);
		contentPane.add(sevenBtn);
		
		eightBtn.addActionListener((arg0) -> handleButtonPress(eightBtn));
		eightBtn.setBounds(110, 53, 40, 40);		
		contentPane.add(eightBtn);
		
		nineBtn.addActionListener((arg0) -> handleButtonPress(nineBtn));
		nineBtn.setBounds(162, 53, 40, 40);
		contentPane.add(nineBtn);
		
		timesBtn.setBounds(214, 157, 40, 40);
		timesBtn.addActionListener((arg0) -> handleButtonPress(timesBtn));
		contentPane.add(timesBtn);
		
		zeroBtn.addActionListener((arg0) -> handleButtonPress(zeroBtn));
		zeroBtn.setBounds(58, 209, 40, 40);
		contentPane.add(zeroBtn);
		
		decimalBtn.addActionListener((arg0) -> handleButtonPress(decimalBtn));
		decimalBtn.setBounds(110, 209, 40, 40);
		contentPane.add(decimalBtn);
		
		equalsBtn.setBounds(162, 209, 40, 40);
		equalsBtn.addActionListener((arg0) -> handleButtonPress(equalsBtn));
		contentPane.add(equalsBtn);

		divideBtn.setBounds(214, 209, 40, 40);		
		divideBtn.addActionListener((arg0) -> handleButtonPress(divideBtn));
		contentPane.add(divideBtn);
		
		contentPane.add(inputOutputText);
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputOutputText.setText("");
				operation = null;
				first_number = 0;
				second_number = 0;
				try {
					operation.setBackground(bgDefault);
					operation.setOpaque(false);
				} catch (Exception ex) { }
			}
		});
		
		// prevent default action of selecting all text when focus is switched to the textbox
		inputOutputText.addFocusListener(new FocusListener() {			
			@Override
			public void focusLost(FocusEvent e) {
				inputOutputText.select(0, 0);
				inputOutputText.setCaretPosition(inputOutputText.getText().length());
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				inputOutputText.select(0, 0);
				inputOutputText.setCaretPosition(inputOutputText.getText().length());
			}
		});
		
		clearBtn.setBounds(266, 53, 40, 92);
		contentPane.add(clearBtn);
		
		inputOutputText.requestFocusInWindow();
		
		//inputOutputText.addKeyListener(l=);
		
		inputOutputText.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			    if (!Character.isDigit(c) && c != '.') {
			      e.consume(); // Stop the event from propagating
			    } 
				
			}

			@Override
			public void keyPressed(KeyEvent e) {				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				switch (e.getKeyCode()) {
				case KeyEvent.VK_ENTER:
					equalsBtn.doClick();
					break;
				case KeyEvent.VK_ESCAPE:
					clearBtn.doClick();
					break;
				}

				switch (e.getKeyChar()) {
					case '*':
						timesBtn.doClick();
						break;						
					case '/':
						divideBtn.doClick();
						break;
					case '-':
						minusBtn.doClick();
						break;
					case '+':
						plusBtn.doClick();
						break;
				}
			}
			});
	}
}
