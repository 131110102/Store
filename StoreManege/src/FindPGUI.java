import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import com.demo.model.Customer;
import com.demo.model.Product;
import com.demo.model.Purchase;

import java.awt.event.MouseMotionAdapter;


public class FindPGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String memo;
	private String no;
	private String cname;
	private Date date;
	private String pname;
	private double price;
	private float quan;
	private Product prod;
	private Customer cus;
	private Purchase pur;
	private Controller con;
	java.util.List l;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindPGUI frame = new FindPGUI();
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
	public FindPGUI() {
		memo = null;
		no = null;
		cname = null;
		date = null;
		pname = null;
		price = 0;
		quan = 0;
		prod = null;
		cus = null;
		con = null;
		l = null;
		setTitle("\u8BA2\u5355\u67E5\u8BE2");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 377, 482);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(38, 33, 310, 44);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		final JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(71, 90, 115, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("*\u8BA2\u5355\u53F7\uFF1A");
		lblNewLabel.setBounds(24, 13, 72, 18);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				if (textField.getText().equals("")) {
					lblNewLabel_1.setText("请输订单号！");
				} else {
					no = textField.getText();
					pur=new Purchase();
					pur.setOrderno(no);
					try {
						con = new Controller("purchase", "find", pur, no);
						if (con.getData() == null) {
							lblNewLabel_1.setText("订单不存在");
						} else{
							lblNewLabel_1.setText("订单存在");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "查找订单时出错！",
								"订单查询", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		textField.setBounds(94, 10, 188, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(38, 122, 310, 311);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(33, 33, 88, 18);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("\u987E\u5BA2\u540D\u79F0\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(33, 75, 89, 18);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("\u6570\u91CF\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(49, 120, 72, 18);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("\u5355\u4EF7\uFF1A");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(49, 165, 72, 18);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("\u51FA\u8D27\u65E5\u671F\uFF1A");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(33, 211, 88, 18);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("\u5907\u6CE8\uFF1A");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(49, 251, 72, 18);
		panel_2.add(label_5);
		
		final JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(135, 33, 118, 18);
		panel_2.add(lblNewLabel_2);
		
		final JLabel label_6 = new JLabel("");
		label_6.setBounds(136, 75, 118, 18);
		panel_2.add(label_6);
		
		final JLabel label_7 = new JLabel("");
		label_7.setBounds(135, 120, 118, 18);
		panel_2.add(label_7);
		
		final JLabel label_8 = new JLabel("");
		label_8.setBounds(135, 165, 118, 18);
		panel_2.add(label_8);
		
		final JLabel label_9 = new JLabel("");
		label_9.setBounds(135, 211, 148, 18);
		panel_2.add(label_9);
		
		final JLabel label_10 = new JLabel("");
		label_10.setBounds(135, 251, 118, 18);
		panel_2.add(label_10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请输入订单！", "订单查询", JOptionPane.ERROR_MESSAGE);
				}else{
					no=textField.getText();
					try {
						con=new Controller("purchase","find",null,no);
						if(con.getData()==null)
						{
							JOptionPane.showMessageDialog(null, "该订单不存在！", "订单查询", JOptionPane.ERROR_MESSAGE);
						}else{
							pur=(Purchase) con.getData();
							lblNewLabel_2.setText(pur.getProduct().getProductname());
							label_6.setText(pur.getCustomer().getCompanyname());
							label_7.setText(pur.getQuantity().toString());
							label_8.setText(pur.getUnitprice().toString());
							SimpleDateFormat dateFormat_1 = new SimpleDateFormat("yyyy-MM-dd");
							label_9.setText(dateFormat_1.format(pur.getOrderdate()));
							label_10.setText(pur.getMemo());
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "获取商品信息出错！", "修改商品信息", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
				
				
				
			
		});
		button.setBounds(206, 81, 113, 27);
		panel.add(button);
	}
}
