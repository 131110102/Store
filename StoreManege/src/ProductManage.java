import com.demo.model.Product;


public class ProductManage 
{
	public void addProduct(Product p) throws Exception
	{
		hbOperation hb=new hbOperation();
		//java.util.List list=hb.findOperation("from Product where productname='"+p.getProductname()+"'");
		if(findProductByPname(p.getProductname())==null)
		{
		
			hb.saveOperation(p);
		}else
		{
			throw new Exception("已存在");
		}
		hb.endSession();
	}
	
	
	
	public void updateProduct(Product p) throws Exception
	{
		hbOperation hb=new hbOperation();
		
		//java.util.List list=hb.findOperation("from Product where productname='"+p.getProductname()+"'");
		if(findProductByPname(p.getProductname())!=null)
		{
		
			hb.updateOperation(p);
		}else{
			throw new Exception("不存在");
		}
		hb.endSession();
	}
	
	
	public Product findProductByPname(String n)
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
	
	public void delateProduct(String n) throws Exception
	{
		hbOperation hb=new hbOperation();
		Product t=null;
		t=findProductByPname(n);
		if(t!=null)
		{
			hb.delateOperation(t);
		}else{
			throw new Exception("不存在");
		}
		hb.endSession();
	}
}
