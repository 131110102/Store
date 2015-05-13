import com.demo.model.Product;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ProductManage m=new ProductManage();
		Product p=new Product("ddd");
		try {
			m.updateProduct(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		//m.updateProduct(p);
	}

}
