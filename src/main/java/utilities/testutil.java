package utilities;

import java.util.ArrayList;


public class testutil {
	static Xls_Reader reader;
	public static ArrayList<Object[]>  getdatafromexcel_Regdata(){
		ArrayList<Object[]> mydata_Regdata  = new ArrayList<Object[]>();
		String testdataxlx_path = System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\testdata.xlsx";
		try {
		 reader = new Xls_Reader(testdataxlx_path);
		}
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		 }
		int rowcount = reader.getRowCount("Regdata");
		
		for (int rownum = 2; rownum <= rowcount; rownum++) {
			String Firstname = reader.getCellData("Regdata", "Firstname", rownum);
			System.out.println(Firstname);
			String Lastname = reader.getCellData("Regdata", "Lastname", rownum);
			System.out.println(Lastname);
			String email = reader.getCellData("Regdata", "email", rownum);
			System.out.println(email);
			String phone = reader.getCellData("Regdata", "phone", rownum);
			System.out.println(phone);
			String password = reader.getCellData("Regdata", "password", rownum);
			System.out.println(password);
			String confirmpassword = reader.getCellData("Regdata", "confirmpassword", rownum);
			System.out.println(confirmpassword);
			
			
			Object ob[] = {Firstname, Lastname,email,phone,password,confirmpassword};
			mydata_Regdata.add(ob);
		}
		return mydata_Regdata;
	}
	
	


}
