import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.demo.model.Product;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AddProductGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String pname;
	private String data;
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
					AddProductGUI frame = new AddProductGUI();
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
	public AddProductGUI() {
		data=null;
		pname=null;
		spec=null;
		unit=null;
		memo=null;
		//setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setTitle("\u5546\u54C1\u4FE1\u606F\u8868");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 317, 412);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(28, 30, 263, 49);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("*\u5546\u54C1\u540D\u79F0");
		label.setBounds(14, 13, 72, 18);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				pname=textField.getText();
			}
		});
		textField.setToolTipText("\u8F93\u5165\u5546\u54C1 \u540D\u79F0");
		textField.setBounds(88, 10, 161, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(28, 92, 263, 49);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u89C4\u683C");
		label_1.setBounds(14, 18, 72, 18);
		panel_2.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				spec=textField_1.getText();
			}
		});
		textField_1.setToolTipText("\u8F93\u5165\u5546\u54C1\u89C4\u683C");
		textField_1.setColumns(10);
		textField_1.setBounds(88, 15, 161, 24);
		panel_2.add(textField_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(28, 154, 263, 49);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u5355\u4F4D");
		label_2.setBounds(14, 13, 72, 18);
		panel_3.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				unit=textField_2.getText();
			}
		});
		textField_2.setToolTipText("\u8F93\u5165\u5546\u54C1\u5355\u4F4D");
		textField_2.setColumns(10);
		textField_2.setBounds(88, 10, 161, 24);
		panel_3.add(textField_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(28, 216, 263, 139);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_3 = new JLabel("\u5546\u54C1\u5907\u6CE8");
		label_3.setBounds(14, 13, 72, 18);
		panel_4.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				memo=textField_3.getText();
			}
		});
		textField_3.setToolTipText("\u8F93\u5165\u5546\u54C1\u5907\u6CE8");
		textField_3.setColumns(10);
		textField_3.setBounds(14, 37, 235, 89);
		panel_4.add(textField_3);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u4FE1\u606F");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(pname.equals(null))
				{
					JOptionPane.showMessageDialog(null, "商品名称不能为空！", "添加商品信息", JOptionPane.ERROR_MESSAGE);
				}else
				{
					prod=new Product(pname);
					prod.setMemo(memo);
					prod.setSpec(spec);
					prod.setUnit(unit);
					try {
						con=new Controller("product","add",prod,null);
						data=prod.getProductname();
						JOptionPane.showMessageDialog(null, "商品添加成功！", "添加商品信息", JOptionPane.PLAIN_MESSAGE);
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "商品添加失败！商品信息已存在", "添加商品信息", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(100, 368, 120, 31);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u5E26*\u53F7\u4E3A\u5FC5\u586B");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel.setBounds(233, 386, 70, 13);
		panel.add(lblNewLabel);
	}
}
