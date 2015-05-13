import com.demo.model.Supplier;


public class SupplierManage implements Manage
{
	/*public void addSupplier(Supplier sup)
	{
		hbOperation hb=new hbOperation();
		try{
			hb.saveOperation(sup);
		}catch(Exception e)
		{
			
		}
		hb.endSession();*
	}*/
	
	public void add(Object s) throws Exception
	{
		hbOperation hb=new hbOperation();
		//java.util.List list=hb.findOperation("from Product where productname='"+p.getProductname()+"'");
		if(find(((Supplier) s).getCompanyname())==null)
		{
		
			hb.saveOperation(s);
		}else
		{
			throw new Exception("已存在");
		}
		hb.endSession();
	}
	
	
	
	public void update(Object s) throws Exception
	{
		hbOperation hb=new hbOperation();
		
		//java.util.List list=hb.findOperation("from Product where productname='"+p.getProductname()+"'");
		if(find(((Supplier) s).getCompanyname())!=null)
		{
		
			hb.updateOperation(s);
		}else{
			throw new Exception("不存在");
		}
		hb.endSession();
	}
	
	
	public Supplier find(String n)
	{
		hbOperation hb=new hbOperation();
		
		java.util.List list=hb.findOperation("from Supplier where companyname='"+n+"'");
		hb.endSession();
		Supplier temp=null;
		if(list.size()!=0)
		{
			temp=(Supplier) list.get(0);
		}
		return temp;
	}
	
	public void delate(String n) throws Exception
	{
		hbOperation hb=new hbOperation();
		Supplier t=null;
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
