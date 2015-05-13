import com.demo.model.Product;
import com.demo.model.Sell;
import com.demo.model.Supplier;


public class SellManage implements Manage
{

	@Override
	public void update(Object s) throws Exception {
		// TODO Auto-generated method stub
		hbOperation hb=new hbOperation();
		
		//java.util.List list=hb.findOperation("from Product where productname='"+p.getProductname()+"'");
		if(hb.findOperation("from Sell where sellno="+((Sell)s).getSellno())!=null)
		{
		
			hb.updateOperation(s);
		}else{
			throw new Exception("不存在");
		}
		hb.endSession();
	}

	@Override
	public void add(Object s) throws Exception {
		// TODO Auto-generated method stub
		hbOperation hb=new hbOperation();
		hb.saveOperation((Sell)s);
		hb.endSession();
	}

	@Override
	public void delate(String n) throws Exception {//按照sellno
		// TODO Auto-generated method stub
		hbOperation hb=new hbOperation();
		Product t=null;
		if(hb.findOperation("from Sell where sellno="+Integer.valueOf(n))!=null)
		{
			hb.delateOperation(t);
		}else{
			throw new Exception("不存在");
		}
		hb.endSession();
	}

	@Override
	public Object[] find(String n) {//按照companyname
		// TODO Auto-generated method stub
		
		hbOperation hb=new hbOperation();
		
		java.util.List list=hb.findOperation("from Sell where companyname='"+n+"'");
		hb.endSession();
		Sell[] temp=null;
		if(list.size()!=0)
		{
			for(int i=0;i<list.size();i++)
			{
				temp[i]=(Sell) list.get(i);
			}
		}
		return temp;
		
	}

}
