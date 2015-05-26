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
import javax.swing.JButton;

import com.demo.model.Product;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UpdateProductGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String pname;
	private String spec;
	private String unit;
	private String memo;
	private Product prod;
	private Controller con;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProductGUI frame = new UpdateProductGUI();
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
	public UpdateProductGUI() {
		pname=null;
		spec=null;
		unit=null;
		memo=null;
		setTitle("\u4FEE\u6539\u5546\u54C1\u4FE1\u606F");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 478, 380);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(28, 28, 423, 288);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("\u5546\u54C1\u89C4\u683C");
		textField_1.setColumns(10);
		textField_1.setBounds(136, 74, 110, 24);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("\u5546\u54C1\u5355\u4F4D");
		textField_2.setColumns(10);
		textField_2.setBounds(136, 120, 110, 24);
		panel_1.add(textField_2);
		
		JLabel label = new JLabel("*\u5546\u54C1\u540D\u79F0\uFF1A");
		label.setBounds(39, 31, 83, 18);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setToolTipText("\u8F93\u5165\u5546\u54C1\u540D\u79F0");
		textField.setBounds(136, 28, 110, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u83B7\u53D6\u5546\u54C1\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请输入商品信息！", "修改商品信息", JOptionPane.ERROR_MESSAGE);
				}else{
					pname=textField.getText();
					prod=new Product(pname);
					try {
						con=new Controller("product","find",prod,pname);
						if(con.getData()==null)
						{
							JOptionPane.showMessageDialog(null, "该商品不存在！", "修改商品信息", JOptionPane.ERROR_MESSAGE);
						}else{
							prod=(Product) con.getData();
							textField_1.setText(prod.getSpec());
							textField_2.setText(prod.getUnit());
							textField_3.setText(prod.getMemo());
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "获取商品信息出错！", "修改商品信息", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		button.setBounds(263, 27, 127, 27);
		panel_1.add(button);
		
		JLabel label_1 = new JLabel("\u5E26*\u53F7\u4E3A\u5FC5\u586B");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(339, 262, 70, 13);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u89C4\u683C\uFF1A");
		label_2.setBounds(39, 77, 83, 18);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("\u5546\u54C1\u5355\u4F4D\uFF1A");
		label_3.setBounds(39, 123, 83, 18);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("\u5546\u54C1\u5907\u6CE8\uFF1A");
		label_4.setBounds(39, 172, 83, 18);
		panel_1.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(136, 172, 183, 88);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		
		
		JButton button_1 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!textField.getText().equals(pname))
				{
					JOptionPane.showMessageDialog(null, "商品名称改变，请重新获取！", "修改商品信息", JOptionPane.ERROR_MESSAGE);
				}else{
					pname=textField.getText();
					spec=textField_1.getText();
					unit=textField_2.getText();
					memo=textField_3.getText();
					prod=new Product(pname);
					prod.setMemo(memo);
					prod.setSpec(spec);
					prod.setUnit(unit);
					try {
						con=new Controller("product","update",prod,pname);
						JOptionPane.showMessageDialog(null, "商品信息修改成功！", "修改商品信息", JOptionPane.PLAIN_MESSAGE);
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "更新信息时出错！", "修改商品信息", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		button_1.setToolTipText("\u4FEE\u6539\u5546\u54C1\u4FE1\u606F");
		button_1.setBounds(168, 340, 113, 27);
		panel.add(button_1);
	}
}
