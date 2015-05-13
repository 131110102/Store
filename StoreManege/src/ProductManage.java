import com.demo.model.Product;


public class ProductManage implements Manage
{
	public void add(Object p) throws Exception
	{
		hbOperation hb=new hbOperation();
		//java.util.List list=hb.findOperation("from Product where productname='"+p.getProductname()+"'");
		if(find(((Product) p).getProductname())==null)
		{
		
			hb.saveOperation(p);
		}else
		{
			throw new Exception("已存在");
		}
		hb.endSession();
	}
	
	
	
	public void update(Object p) throws Exception
	{
		hbOperation hb=new hbOperation();
		
		//java.util.List list=hb.findOperation("from Product where productname='"+p.getProductname()+"'");
		if(find(((Product) p).getProductname())!=null)
		{
		
			hb.updateOperation(p);
		}else{
			throw new Exception("不存在");
		}
		hb.endSession();
	}
	
	
	public Product find(String n)
	{
		hbOperation hb=new hbOperation();
		
		java.util.List list=hb.findOperation("from Product where productname='"+n+"'");
		hb.endSession();
		Product temp=null;
		if(list.size()!=0)
		{
			temp=(Product) list.get(0);
		}
		return temp;
	}
	
	public void delate(String n) throws Exception
	{
		hbOperation hb=new hbOperation();
		Product t=null;
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
