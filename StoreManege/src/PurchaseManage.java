
import com.demo.model.Purchase;



public class PurchaseManage implements Manage 
{

	@Override
	public void update(Object s) throws Exception {
		// TODO Auto-generated method stub
		hbOperation hb=new hbOperation();
		
		//java.util.List list=hb.findOperation("from Product where productname='"+p.getProductname()+"'");
		if(find(((Purchase) s).getOrderno())!=null)
		{
		
			hb.updateOperation(s);
		}else{
			throw new Exception("不存在");
		}
		hb.endSession();
		
	}

	@Override
	public void add(Object s) throws Exception 
	{
		// TODO Auto-generated method stub
		hbOperation hb=new hbOperation();
		//java.util.List list=hb.findOperation("from Product where productname='"+p.getProductname()+"'");
		if(find(((Purchase) s).getOrderno())==null)
		{
		
			hb.saveOperation(s);
		}else
		{
			throw new Exception("已存在");
		}
		hb.endSession();
		
	}

	@Override
	public void delate(String n) throws Exception {
		// TODO Auto-generated method stub
		hbOperation hb=new hbOperation();
		Purchase t=null;
		t=find(n);
		if(t!=null)
		{
			hb.delateOperation(t);
		}else{
			throw new Exception("不存在");
		}
		hb.endSession();
		
	}

	@Override
	public Purchase find(String n) 
	{
		// TODO Auto-generated method stub
		hbOperation hb=new hbOperation();
		
		java.util.List list=hb.findOperation("from Purchase where orderno='"+n+"'");
		hb.endSession();
		Purchase temp=null;
		if(list.size()!=0)
		{
			temp=(Purchase) list.get(0);
		}
		return temp;
	}

}
