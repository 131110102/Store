import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.demo.model.Customer;
import com.demo.model.Product;
import com.demo.model.Purchase;


public class MainPageGUI extends JFrame {

	private JPanel contentPane;
	private String cname;
	private String city;
	private String cnum;
	private String fax;
	private String address;
	private String phone;
	private Customer cus;
	private Controller con;
	java.util.List l;
	private JTable table;
	private String user;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPageGUI frame = new MainPageGUI("1311101");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MainPageGUI(final String u) {
		user=u;
		l=null;
		setTitle("\u4ED3\u5E93\u7BA1\u7406");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 779, 413);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(14, 13, 751, 94);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(14, 120, 751, 280);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		final Button button_4 = new Button("\u7CFB\u7EDF\u8BBE\u7F6E\u25BC");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JPopupMenu menu=new JPopupMenu();  
				JMenuItem Item_1 = new JMenuItem("修改密码");
				JMenuItem Item_3 = new JMenuItem("退出");
				Item_1.addMouseListener(new MouseAdapter(){
        			public void mousePressed(MouseEvent e) {
        				new ChangeKeyGUI(u).setVisible(true);
        			}
        		});
				Item_3.addMouseListener(new MouseAdapter(){
        			public void mousePressed(MouseEvent e) {
        				int a = JOptionPane.showConfirmDialog(null, "停止使用吗？",
        						"退出", JOptionPane.YES_NO_OPTION);
        				if (a == JOptionPane.YES_OPTION) {
        					
        						dispose();
        					
        				} else if(a == JOptionPane.NO_OPTION) {
        					// ......
        				}
        			}
        		});
				 //firstItem.addActionListener(anActionListener);
				menu.add(Item_1);     
		        menu.add(Item_3);   
		        menu.show(button_4, 2, 68);
			}
		});
		button_4.setBounds(229, 13, 84, 68);
		panel_1.add(button_4);
		
		final Button button = new Button("\u4ED3\u5E93\u7BA1\u7406\u25BC");
		button.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseEntered(MouseEvent e) {
				final JPopupMenu menu=new JPopupMenu();  
				final JMenu smenu_1=new JMenu("商品信息管理");
        		JMenuItem item_1 = new JMenuItem("添加商品信息");
        		JMenuItem item_2 = new JMenuItem("删除商品信息");
        		JMenuItem item_3 = new JMenuItem("修改商品信息");
        		JMenuItem item_8 = new JMenuItem("显示所有商品信息");
        		item_8.addMouseListener(new MouseAdapter(){
        			public void mousePressed(MouseEvent e) {
        				//System.out.println("爆炸");
        				try {
							con=new Controller("product", "findall", null, null);
							l=con.getList();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							System.out.println("爆炸了");
						}			
        				//System.out.println("爆炸");
        				//model.addElement("Hello\t000");
        				table.setModel(new DefaultTableModel(
        						new Object[][] {
        						},
        						new String[] {
        							"商品名称", "规格", "单位", "备注"
        						}
        					));
        				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        				for(int i=0;i<l.size();i++)
        				{
        				Product p=(Product) l.get(i);
        				tableModel.addRow(new Object[]{p.getProductname(),p.getSpec(),p.getUnit(),p.getMemo()});
        				}
        			}
        		});
        		smenu_1.add(item_1);
        		smenu_1.add(item_2);
        		smenu_1.add(item_3);
        		smenu_1.add(item_8);
        		item_1.addMouseListener(new MouseAdapter(){
        			public void mousePressed(MouseEvent e) {
        				new AddProductGUI().setVisible(true);
        			}
        		});
        		item_2.addMouseListener(new MouseAdapter(){
        			public void mousePressed(MouseEvent e) {
        				new DelateProductGUI().setVisible(true);
        			}
        		});
        		item_3.addMouseListener(new MouseAdapter(){
        			public void mousePressed(MouseEvent e) {
        				new UpdateProductGUI().setVisible(true);
        			}
        		});
        		final JMenu smenu_2=new JMenu("顾客信息管理");
        		JMenuItem item_4 = new JMenuItem("添加顾客信息");
        		JMenuItem item_5 = new JMenuItem("删除顾客信息");
        		JMenuItem item_9 = new JMenuItem("显示所有顾客信息");
        		item_9.addMouseListener(new MouseAdapter(){
        			public void mousePressed(MouseEvent e) {
        				//System.out.println("爆炸");
        				try {
							con=new Controller("customer", "findall", null, null);
							l=con.getList();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							System.out.println("爆炸了");
						}			
        				//System.out.println("爆炸");
        				//model.addElement("Hello\t000");
        				table.setModel(new DefaultTableModel(
        						new Object[][] {
        						},
        						new String[] {
        							"顾客姓名", "城市", "邮编", "传真", "地址", "联系电话"
        						}
        					));
        				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        				for(int i=0;i<l.size();i++)
        				{
        				Customer c=(Customer) l.get(i);
        				tableModel.addRow(new Object[]{c.getCompanyname(),c.getCity(),c.getCitynum(),c.getFax(),c.getAddress(),c.getPhone()});
        				}
        			}
        		});
        		item_4.addMouseListener(new MouseAdapter(){
        			public void mousePressed(MouseEvent e) {
        				new AddCustomerGUI().setVisible(true);
        			}
        		});
        		item_5.addMouseListener(new MouseAdapter(){
        			public void mousePressed(MouseEvent e) {
        				new DelateCustomerGUI().setVisible(true);
        			}
        		});
        		
        		smenu_2.add(item_4);
        		smenu_2.add(item_5);
        		smenu_2.add(item_9);
        		JMenuItem item_7 = new JMenuItem("添加订单");
        		item_7.addMouseListener(new MouseAdapter(){
        			public void mousePressed(MouseEvent e) {
        				new PurchaseGUI().setVisible(true);
        			}
        		});
        		menu.add(smenu_1);
        		menu.add(smenu_2);
        		menu.add(item_7);
				 //firstItem.addActionListener(anActionListener);
				
		        menu.show(button, 2, 68);
		        
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(26, 13, 84, 68);
		panel_1.add(button);
		
         
		final Button button_1 = new Button("\u4FE1\u606F\u67E5\u8BE2\u25BC");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JPopupMenu menu=new JPopupMenu();  
				JMenuItem Item_2 = new JMenuItem("订单信息查询");
				JMenuItem Item_3 = new JMenuItem("显示所有订单信息");
				Item_3.addMouseListener(new MouseAdapter(){
        			public void mousePressed(MouseEvent e) {
        				//System.out.println("爆炸");
        				try {
							con=new Controller("purchase", "findall", null, null);
							l=con.getList();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							System.out.println("爆炸了");
						}			
        				//System.out.println("爆炸");
        				//model.addElement("Hello\t000");
        				table.setModel(new DefaultTableModel(
        						new Object[][] {
        						},
        						new String[] {
        							"订单号", "商品名称", "顾客名称", "数量", "单价", "日期","备注"
        						}
        					));
        				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        				for(int i=0;i<l.size();i++)
        				{
        				Purchase c=(Purchase) l.get(i);
        				tableModel.addRow(new Object[]{c.getOrderno(),c.getProduct().getProductname(),
        						c.getCustomer().getCompanyname(),c.getQuantity(),c.getUnitprice(),c.getOrderdate(),c.getMemo()});
        				}
        			}
        		});
				 //firstItem.addActionListener(anActionListener);  
				menu.add(Item_2);      
				menu.add(Item_3);      
		        menu.show(button_1, 2, 68);
		        Item_2.addMouseListener(new MouseAdapter(){
		        	public void mousePressed(MouseEvent e) {
		        		JMenuItem save =(JMenuItem) e.getSource();
		        		if(save.getText().equals("库存查询"))
		        		{
		        		System.out.println(save.getText());
		        		JOptionPane.showMessageDialog( null,"插入失败!");
		        		}
					}
		        });
		        }
			
		});
		button_1.setBounds(127, 13, 84, 68);
		panel_1.add(button_1);
		
		
		
		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		label.setBounds(665, 249, 72, 18);
		panel_2.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 13, 723, 223);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		
	}
}
