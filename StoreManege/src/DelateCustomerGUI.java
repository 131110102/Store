import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.demo.model.Customer;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class DelateCustomerGUI extends JFrame {

	private JPanel contentPane;
	private String cname;
	private Customer cus;
	private Controller con;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelateCustomerGUI frame = new DelateCustomerGUI();
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
	public DelateCustomerGUI() {
		setTitle("\u5220\u9664\u987E\u5BA2\u4FE1\u606F");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel.setBounds(0, 0, 432, 212);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel_1.setBounds(40, 33, 359, 114);
		panel.add(panel_1);
		panel_1.setLayout(null);

		final JLabel label_2 = new JLabel("");
		label_2.setToolTipText("\u5546\u54C1\u72B6\u6001");
		label_2.setForeground(Color.RED);
		label_2.setBounds(135, 70, 149, 18);
		panel_1.add(label_2);

		JLabel label = new JLabel("*\u5BA2\u6237\u540D\u79F0\uFF1A");
		label.setBounds(44, 29, 83, 18);
		panel_1.add(label);

		textField = new JTextField();
		textField.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {

				if (textField.getText().equals("")) {
					label_2.setText("请输入客户名称！");
				} else {
					cname = textField.getText();
					cus = new Customer(cname);
					try {
						con = new Controller("customer", "find", cus, cname);
						if (con.getData() == null) {
							label_2.setText("不存在");
						} else {
							label_2.setText("存在");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "查找客户时出错！",
								"删除客户信息", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		textField.setBounds(135, 26, 149, 24);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u4FE1\u606F\u72B6\u6001\uFF1A");
		label_1.setBounds(44, 70, 83, 18);
		panel_1.add(label_1);

		JLabel label_3 = new JLabel("\u5E26*\u53F7\u4E3A\u5FC5\u586B");
		label_3.setFont(new Font("宋体", Font.PLAIN, 12));
		label_3.setBounds(348, 186, 70, 13);
		panel.add(label_3);

		JButton button = new JButton("\u5220\u9664\u5BA2\u6237\u4FE1\u606F");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					con = new Controller("customer", "find", cus, cname);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "查询客户时出错！", "删除客户信息",
							JOptionPane.ERROR_MESSAGE);
				}
				if (textField.getText().equals("")) {
					label_2.setText("请输入客户名称！");
					JOptionPane.showMessageDialog(null, "请输入客户名称！", "删除客户信息",
							JOptionPane.ERROR_MESSAGE);
				} else if (con.getData() == null) {
					JOptionPane.showMessageDialog(null, "该客户不存在！", "删除客户信息",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int n = JOptionPane.showConfirmDialog(null, "确认删除吗?",
							"确认删除框", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						try {
							con = new Controller("customer", "delate", cus,
									cname);
							JOptionPane.showMessageDialog(null, "客户删除成功！",
									"删除客户信息", JOptionPane.PLAIN_MESSAGE);
							dispose();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "删除该客户时出错！",
									"删除客户信息", JOptionPane.ERROR_MESSAGE);
						}
					} else if (n == JOptionPane.NO_OPTION) {
						// ......
					}
				}
			}
		});
		button.setToolTipText("\u5220\u9664\u8BE5\u5546\u54C1");
		button.setBounds(175, 160, 134, 27);
		panel.add(button);
	}

}
