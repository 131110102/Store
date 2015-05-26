import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import com.demo.model.Product;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DelateProductGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String pname;
	private String spec;
	private String unit;
	private String memo;
	private Product prod;
	private Controller con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelateProductGUI frame = new DelateProductGUI();
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
	public DelateProductGUI() {
		pname = null;
		spec = null;
		unit = null;
		memo = null;

		setTitle("\u5220\u9664\u5546\u54C1\u4FE1\u606F");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel.setBounds(0, 0, 432, 255);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel_1.setBounds(35, 30, 359, 135);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("*\u5546\u54C1\u540D\u79F0\uFF1A");
		label.setBounds(48, 32, 83, 18);
		panel_1.add(label);

		final JLabel label_1 = new JLabel("\u5E26*\u53F7\u4E3A\u5FC5\u586B");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(348, 229, 70, 13);
		panel.add(label_1);
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("\u5546\u54C1\u72B6\u6001");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(145, 79, 137, 18);
		textField = new JTextField();

		textField.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				if (textField.getText().equals("")) {
					lblNewLabel.setText("请输入商品名称！");
				} else {
					pname = textField.getText();
					prod = new Product(pname);
					prod.setMemo(memo);
					prod.setSpec(spec);
					prod.setUnit(unit);
					try {
						con = new Controller("product", "find", prod, pname);
						if (con.getData() == null) {
							lblNewLabel.setText("不存在");
						} else {
							lblNewLabel.setText("存在");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "查找该商品时出错！",
								"删除商品信息", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		textField.setToolTipText("\u8F93\u5165\u5546\u54C1\u540D\u79F0");
		textField.setBounds(145, 29, 137, 24);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel label_2 = new JLabel("\u4FE1\u606F\u72B6\u6001\uFF1A");
		label_2.setBounds(48, 79, 83, 18);
		panel_1.add(label_2);

		panel_1.add(lblNewLabel);

		JButton button = new JButton("\u5220\u9664\u5546\u54C1\u4FE1\u606F");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					con = new Controller("product", "find", prod, pname);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "商品查询时出错！", "删除商品信息",
							JOptionPane.ERROR_MESSAGE);
				}
				if (textField.getText().equals("")) {
					lblNewLabel.setText("请输入商品名称！");
					JOptionPane.showMessageDialog(null, "请输入商品名称！", "删除商品信息",
							JOptionPane.ERROR_MESSAGE);
				} else if (con.getData() == null) {
					JOptionPane.showMessageDialog(null, "该商品不存在！", "删除商品信息",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int n = JOptionPane.showConfirmDialog(null, "确认删除吗?",
							"确认删除框", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						try {
							con = new Controller("product", "delate", prod,
									pname);
							JOptionPane.showMessageDialog(null, "商品删除成功！",
									"删除商品信息", JOptionPane.PLAIN_MESSAGE);
							dispose();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "删除该商品时出错！",
									"删除商品信息", JOptionPane.ERROR_MESSAGE);
						}
					} else if (n == JOptionPane.NO_OPTION) {
						// ......
					}
				}
			}
		});
		button.setToolTipText("\u5220\u9664\u8BE5\u5546\u54C1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(189, 192, 134, 27);
		panel.add(button);
	}
}
