import com.demo.model.Customer;
import com.demo.model.Supplier;


public class CustomerManage 
{
	public void addCustomer(Customer c) throws Exception
	{
		hbOperation hb=new hbOperation();
		//java.util.List list=hb.findOperation("from Product where productname='"+p.getProductname()+"'");
		if(findProductByCname(c.getCompanyname())==null)
		{
		
			hb.saveOperation(c);
		}else
		{
			throw new Exception("已存在");
		}
		hb.endSession();
	}
	
	
	
	public void updateCustomer(Customer c) throws Exception
	{
		hbOperation hb=new hbOperation();
		
		//java.util.List list=hb.findOperation("from Product where productname='"+p.getProductname()+"'");
		if(findProductByCname(c.getCompanyname())!=null)
		{
		
			hb.updateOperation(c);
		}else{
			throw new Exception("不存在");
		}
		hb.endSession();
	}
	
	
	public Customer findProductByCname(String n)
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
	
	public void delateCustomer(String n) throws Exception
	{
		hbOperation hb=new hbOperation();
		Customer t=null;
		t=findProductByCname(n);
		if(t!=null)
		{
			hb.delateOperation(t);
		}else{
			throw new Exception("不存在");
		}
		hb.endSession();
	}
}
