import com.demo.model.Product;
import com.demo.model.Purchase;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//ProductManage m=new ProductManage();
		//Product p=new Product("333");
		//try {
		//	m.add(p);
		//} catch (Exception e) {
		//	// TODO Auto-generated catch block
		//	System.out.println(e.toString());
		//}
		//m.updateProduct(p);
		//hbOperation hb=new hbOperation();
		//hb.saveOperation(p);
		//hb.endSession();
		//String str="customer";
		//str  = str.substring(0,1).toUpperCase()+str.substring(1);
		//hbOperation hb = new hbOperation();
		//java.util.List list = hb.findOperation("from "+str);
		//.endSession();
		/*try {
			Controller com=new Controller("131110102","1311101","812766");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		PurchaseManage p=new PurchaseManage();
		p.find("20150526200026");
	}

}
