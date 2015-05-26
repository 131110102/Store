import com.demo.model.User;

public class Controller {

	private Manage manage;
	private Object data;
	java.util.List list;

	public java.util.List getList() {
		return list;
	}

	public void setList(java.util.List list) {
		this.list = list;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Manage getManage() {
		return manage;
	}

	public void setManage(Manage manage) {
		this.manage = manage;
	}

	public Controller(String target, String order, Object ob, String str)
			throws Exception {
		data = null;
		list = null;
		if (target.equals("customer")) {
			CustomerManage n = new CustomerManage();
			setManage(n);
		} else {
			if (target.equals("product")) {
				ProductManage n = new ProductManage();
				setManage(n);
			} else {
				if (target.equals("purchase")) {
					PurchaseManage n = new PurchaseManage();
					setManage(n);
				} else {
					throw new Exception("ÎÞ¸Ã²Ù×÷");
				}
			}
		}
		if (order.equals("add")) {
			manage.add(ob);
		} else {
			if (order.equals("update")) {
				manage.update(ob);
			} else {
				if (order.equals("delate")) {
					manage.delate(str);
				} else {
					if (order.equals("findall")) {
						hbOperation hb = new hbOperation();
						String t = target.substring(0, 1).toUpperCase()
								+ target.substring(1);
						list = hb.findOperation("from " + t);
						hb.endSession();
					} else {
						if (order.equals("find")) {
							setData(manage.find(str));
						}
					}
				}
			}
		}
	}
	public Controller(String name,String old,String n) throws Exception
	{
		java.util.List temp=null;
		User u=null;
		hbOperation hb=new hbOperation();
		
		temp=hb.findOperation("from User where name="+name.trim());
		u=(User) temp.get(0);
		if(old.equals(u.getPassword()))
		{
			u.setPassword(n);
			hb.updateOperation(u);
			hb.endSession();
		}else{
			hb.endSession();
			throw new Exception();
		}
	}
}
