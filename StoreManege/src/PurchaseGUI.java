import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class PurchaseGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Controller con;
	java.util.List l;
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
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseGUI frame = new PurchaseGUI();
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
	public PurchaseGUI() {
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
		setTitle("\u51FA\u8D27\u5355");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel.setBounds(0, 0, 363, 494);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel_1.setBounds(27, 28, 313, 415);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("\u5355\u53F7\uFF1A");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(41, 26, 72, 18);
		panel_1.add(label);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(127, 26, 138, 18);
		panel_1.add(lblNewLabel);

		Date now = new Date();
		date = now;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = dateFormat.format(now);
		no = str;
		lblNewLabel.setText(str);

		JLabel label_1 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(24, 66, 88, 18);
		panel_1.add(label_1);

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(127, 63, 104, 24);
		panel_1.add(comboBox);
		try {
			con = new Controller("product", "findall", null, null);
			l = con.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "获取商品信息出错！", "添加出货单",
					JOptionPane.ERROR_MESSAGE);
		}
		for (int i = 0; i < l.size(); i++) {
			Product p = (Product) l.get(i);
			comboBox.addItem(p.getProductname());
		}

		JLabel label_2 = new JLabel("\u987E\u5BA2\u540D\u79F0\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(24, 107, 89, 18);
		panel_1.add(label_2);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(127, 100, 104, 24);
		panel_1.add(comboBox_1);
		try {
			con = new Controller("customer", "findall", null, null);
			l = con.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "获取顾客信息出错！", "添加出货单",
					JOptionPane.ERROR_MESSAGE);
		}
		for (int i = 0; i < l.size(); i++) {
			Customer c = (Customer) l.get(i);
			comboBox_1.addItem(c.getCompanyname());
		}

		JLabel label_3 = new JLabel("\u6570\u91CF\uFF1A");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(41, 151, 72, 18);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("\u5355\u4EF7\uFF1A");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(41, 189, 72, 18);
		panel_1.add(label_4);

		textField = new JTextField();
		textField.setBounds(127, 185, 104, 24);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel label_5 = new JLabel("\u51FA\u8D27\u65E5\u671F\uFF1A");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(24, 220, 88, 18);
		panel_1.add(label_5);

		JLabel label_6 = new JLabel("");
		label_6.setBounds(127, 220, 138, 18);
		panel_1.add(label_6);

		SimpleDateFormat dateFormat_1 = new SimpleDateFormat("yyyy-MM-dd");
		String str_1 = dateFormat_1.format(now);
		label_6.setText(str_1);

		JLabel label_7 = new JLabel("\u5907\u6CE8\uFF1A");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(41, 252, 72, 18);
		panel_1.add(label_7);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 249, 157, 135);
		panel_1.add(textField_1);

		JButton btnNewButton = new JButton("+");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddProductGUI frame = new AddProductGUI();
				frame.setVisible(true);
				/*
				 * String save=null; while(frame.getData().equals(null)) {
				 * save=frame.getData(); }
				 */
				JOptionPane.showMessageDialog(null, "添加后请重新打开订单界面！", "添加订单",
						JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton
				.setToolTipText("\u6DFB\u52A0\u65B0\u7684\u5546\u54C1\u4FE1\u606F");
		btnNewButton.setBounds(245, 69, 41, 18);
		panel_1.add(btnNewButton);

		JButton button_1 = new JButton("+");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddCustomerGUI frame = new AddCustomerGUI();
				frame.setVisible(true);
				JOptionPane.showMessageDialog(null, "添加后请重新打开订单界面！", "添加订单",
						JOptionPane.WARNING_MESSAGE);

			}
		});
		button_1.setToolTipText("\u6DFB\u52A0\u65B0\u7684\u987E\u5BA2\u4FE1\u606F");
		button_1.setBounds(245, 107, 41, 18);
		panel_1.add(button_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(127, 148, 104, 24);
		panel_1.add(textField_2);

		JButton button = new JButton("\u6DFB\u52A0\u51FA\u8D27\u5355");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!isRealNumber(textField.getText())) {
					JOptionPane.showMessageDialog(null, "单价请输入数字！", "添加订单",
							JOptionPane.ERROR_MESSAGE);

				} else {
					if (!isRealNumber(textField_2.getText())) {
						JOptionPane.showMessageDialog(null, "数量请输入数字！", "添加订单",
								JOptionPane.ERROR_MESSAGE);

					} else {
						memo = textField_1.getText();
						cname = comboBox_1.getSelectedItem().toString();
						pname = comboBox.getSelectedItem().toString();
						//System.out.println(pname);
						price=Double.valueOf(textField.getText());
						quan=Float.valueOf(textField_2.getText());
						
						try {
							//prod=new Product(pname);
							con=new Controller("product","find",null,pname);
							prod=(Product) con.getData();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							//e2.printStackTrace();
							JOptionPane.showMessageDialog(null, "获取商品信息出错！", "添加订单",
									JOptionPane.ERROR_MESSAGE);

						}
						try {
							cus=new Customer(cname);
							con=new Controller("customer","find",cus,cname);
							cus =(Customer) con.getData();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "获取顾客信息出错！", "添加订单",
									JOptionPane.ERROR_MESSAGE);

						}
						pur=new Purchase();
						pur.setCustomer(cus);
						pur.setProduct(prod);
						pur.setMemo(memo);
						pur.setUnitprice(price);
						pur.setOrderno(no);
						pur.setOrderdate(date);
						pur.setQuantity(quan);
						try {
							con=new Controller("purchase","add",pur,null);
							JOptionPane.showMessageDialog(null, "添加订单成功！",
									"添加订单", JOptionPane.PLAIN_MESSAGE);
							dispose();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "订单添加出错！", "添加订单", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				}
			}
		});
		button.setBounds(129, 456, 113, 27);
		panel.add(button);
	}
	
	private static boolean isMatch(String regex, String orginal){  
        if (orginal == null || orginal.trim().equals("")) {  
            return false;  
        }  
        Pattern pattern = Pattern.compile(regex);  
        Matcher isNum = pattern.matcher(orginal);  
        return isNum.matches();  
    }
	public static boolean isPositiveInteger(String orginal) {  
        return isMatch("^\\+{0,1}[1-9]\\d*", orginal);  
    }  
  
    public static boolean isNegativeInteger(String orginal) {  
        return isMatch("^-[1-9]\\d*", orginal);  
    }  
	public static boolean isWholeNumber(String orginal) {  
        return isMatch("[+-]{0,1}0", orginal) || isPositiveInteger(orginal) || isNegativeInteger(orginal);  
    }  
	public static boolean isDecimal(String orginal){  
        return isMatch("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+", orginal);  
    }  
      
    public static boolean isRealNumber(String orginal){  
        return isWholeNumber(orginal) || isDecimal(orginal);  
    }  
}
