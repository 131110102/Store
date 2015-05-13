import com.demo.model.Customer;
import com.demo.model.Supplier;


public class CustomerManage implements Manage
{
	public void add(Object c) throws Exception
	{
		hbOperation hb=new hbOperation();
		//java.util.List list=hb.findOperation("from Product where productname='"+p.getProductname()+"'");
		if(find(((Customer) c).getCompanyname())==null)
		{
		
			hb.saveOperation(c);
		}else
		{
			throw new Exception("已存在");
		}
		hb.endSession();
	}
	
	
	
	public void update(Object c) throws Exception
	{
		hbOperation hb=new hbOperation();
		
		//java.util.List list=hb.findOperation("from Product where productname='"+p.getProductname()+"'");
		if(find(((Customer) c).getCompanyname())!=null)
		{
		
			hb.updateOperation(c);
		}else{
			throw new Exception("不存在");
		}
		hb.endSession();
	}
	
	
	public Customer find(String n)
	{
		hbOperation hb=new hbOperation();
		
		java.util.List list=hb.findOperation("from Customer where companyname='"+n+"'");
		hb.endSession();
		Customer temp=null;
		if(list.size()!=0)
		{
			temp=(Customer) list.get(0);
		}
		return temp;
	}
	
	public void delate(String n) throws Exception
	{
		hbOperation hb=new hbOperation();
		Customer t=null;
		t=find(n);
		if(t!=null)
		{
			hb.delateOperation(t);
		}else{
			throw new Exception("不存在");
		}
		hb.endSession();
	}
}
