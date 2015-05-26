import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import com.demo.model.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AddCustomerGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private String cname;
	private String data;
	private String city;
	private String cnum;
	private String fax;
	private String address;
	private String phone;
	private Customer cus;
	private Controller con;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomerGUI frame = new AddCustomerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Create the frame.
	 */
	public AddCustomerGUI() {
		cname=null;
		data=null;
		city=null;
		cnum=null;
		fax=null;
		address=null;
		phone=null;
		cus=null;
		setTitle("\u6DFB\u52A0\u5BA2\u6237\u4FE1\u606F");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 432, 389);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(33, 30, 363, 40);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("*\u5BA2\u6237\u540D\u79F0\uFF1A");
		label.setBounds(17, 13, 86, 18);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setBounds(117, 10, 232, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(33, 83, 363, 254);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("\u57CE\u5E02\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(14, 27, 72, 18);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("\u8BE6\u7EC6\u5730\u5740\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(14, 69, 82, 18);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("\u90AE\u7F16\uFF1A");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(14, 112, 72, 18);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("\u4F20\u771F\uFF1A");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(14, 155, 72, 18);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(14, 198, 82, 18);
		panel_2.add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 24, 232, 24);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(117, 66, 232, 24);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(117, 109, 232, 24);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(117, 152, 232, 24);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(117, 195, 232, 24);
		panel_2.add(textField_5);
		
		JLabel label_6 = new JLabel("\u5E26*\u53F7\u4E3A\u5FC5\u586B");
		label_6.setFont(new Font("宋体", Font.PLAIN, 12));
		label_6.setBounds(279, 232, 70, 13);
		panel_2.add(label_6);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u5BA2\u6237\u4FE1\u606F");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请输入客户名称！", "添加客户信息", JOptionPane.ERROR_MESSAGE);
				}else{
					cname=textField.getText();
					city=textField_1.getText();
					address=textField_2.getText();
					cnum=textField_3.getText();
					fax=textField_4.getText();
					phone=textField_5.getText();
					cus=new Customer(cname);
					cus.setCity(city);
					cus.setAddress(address);
					cus.setCitynum(cnum);
					cus.setFax(fax);	
					cus.setPhone(phone);
					try {
						con=new Controller("customer","add",cus,null);
						data=cus.getCompanyname();
						JOptionPane.showMessageDialog(null, "添加客户成功！",
								"添加客户信息", JOptionPane.PLAIN_MESSAGE);
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "客户已存在！", "添加客户信息", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(154, 349, 123, 27);
		panel.add(btnNewButton);
	}
}
