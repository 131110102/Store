import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;


public class ChangeKeyGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String username;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ChangeKeyGUI(final String username) {
		this.username=username;
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 432, 255);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(57, 30, 324, 148);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("*\u65E7\u5BC6\u7801\uFF1A");
		label.setBounds(49, 39, 72, 18);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("*\u65B0\u5BC6\u7801\uFF1A");
		label_1.setBounds(49, 84, 72, 18);
		panel_1.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(135, 78, 136, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(135, 36, 136, 24);
		panel_1.add(passwordField);
		
		JLabel label_2 = new JLabel("\u5E26*\u53F7\u4E3A\u5FC5\u586B");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		label_2.setBounds(348, 229, 70, 13);
		panel.add(label_2);
		
		JButton button = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String old =String.valueOf(passwordField.getPassword());
				String n=textField.getText();
				int a = JOptionPane.showConfirmDialog(null, "确认修改密码为"+n+"?",
						"密码修改确认", JOptionPane.YES_NO_OPTION);
				if (a == JOptionPane.YES_OPTION) {
					try {
						Controller con=new Controller(username,old,n);
						JOptionPane.showMessageDialog(null, "密码修改成功！",
								"修改密码", JOptionPane.PLAIN_MESSAGE);
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "旧密码错误！",
								"修改密码", JOptionPane.ERROR_MESSAGE);
					}
				} else if (a == JOptionPane.NO_OPTION) {
					// ......
				}
			}
		});
		button.setBounds(190, 200, 113, 27);
		panel.add(button);
	}
}
