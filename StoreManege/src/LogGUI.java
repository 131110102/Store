import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.demo.model.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LogGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String name;
	private String key;
	private User user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogGUI frame = new LogGUI();
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
	public LogGUI() {
		name=null;
		key=null;
		user=null;
		setTitle("\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 414, 228);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(37, 35, 337, 116);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(69, 69, 45, 18);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setBounds(48, 30, 72, 18);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setText("131110102");
		textField.setToolTipText("\u8F93\u5165\u7528\u6237\u540D");
		textField.setBounds(122, 27, 135, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("\u8F93\u5165\u5BC6\u7801");
		passwordField.setBounds(122, 66, 135, 24);
		panel_1.add(passwordField);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				java.util.List temp=null;
				if(textField.getText().equals("")||passwordField.getPassword().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请输入完整用户信息！", "登录", JOptionPane.ERROR_MESSAGE);
				}else{
					name=textField.getText().trim();
					key=String.valueOf(passwordField.getPassword());
					hbOperation hb=new hbOperation();
					temp=hb.findOperation("from User where name="+name);
					hb.endSession();
					if(temp.size()==0)
					{
						JOptionPane.showMessageDialog(null, "该用户不存在！", "登录", JOptionPane.ERROR_MESSAGE);
					}else{
						user=(User) temp.get(0);
						if(key.trim().equals(user.getPassword()))
						{
							JOptionPane.showMessageDialog(null, "登陆成功！",
									"登录", JOptionPane.PLAIN_MESSAGE);
							MainPageGUI f = new MainPageGUI(user.getName());
							 dispose();
							f.setVisible(true);
						}else{
							JOptionPane.showMessageDialog(null, "密码错误！", "登录", JOptionPane.ERROR_MESSAGE);
							System.out.println(key);
							System.out.println(user.getPassword());
							
						}
					}
				}
			}
		});
		btnNewButton.setToolTipText("\u767B\u5F55");
		btnNewButton.setBounds(157, 164, 98, 40);
		panel.add(btnNewButton);
	}
}
