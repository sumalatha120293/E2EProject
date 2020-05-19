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
			//reader.setCellData("Regdata", "status", rownum, "");
			
			Object ob[] = {Firstname, Lastname,email,phone,password,confirmpassword};
			mydata_Regdata.add(ob);
		}
		return mydata_Regdata;
	}
	
	
	public static ArrayList<Object[]>  getdatafromexcel_Searchdata(){
		ArrayList<Object[]> mydata_Searchdata  = new ArrayList<Object[]>();
		String testdataxlx_path = System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\testdata.xlsx";
		try {
		 reader = new Xls_Reader(testdataxlx_path);
		}
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		 }
		int rowcount = reader.getRowCount("Searchdata");
		
		for (int rownum = 2; rownum <= rowcount; rownum++) {
			String searchuname = reader.getCellData("Searchdata", "searchuname", rownum);
			System.out.println(searchuname);
			String searchpwd = reader.getCellData("Searchdata", "searchpwd", rownum);
			System.out.println(searchpwd);
			String Searchtext = reader.getCellData("Searchdata", "Searchtext", rownum);
			System.out.println(Searchtext);
			String product = reader.getCellData("Searchdata", "product", rownum);
			System.out.println(product);
			
			//reader.setCellData("Regdata", "status", rownum, "");
			
			Object ob[] = {searchuname,searchpwd,Searchtext,product};
			mydata_Searchdata.add(ob);
		}
		return mydata_Searchdata;
	}


	public static ArrayList<Object[]>  getdatafromexcel_wishlistdata(){
		ArrayList<Object[]> mydata_wishlistdata  = new ArrayList<Object[]>();
		String testdataxlx_path = System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\testdata.xlsx";
		try {
		 reader = new Xls_Reader(testdataxlx_path);
		}
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		 }
		int rowcount = reader.getRowCount("wishlistdata");
		System.out.println(rowcount);
		for (int rownum = 2; rownum <= rowcount; rownum++) {
			String Productname = reader.getCellData("wishlistdata", "Productname", rownum);
			System.out.println(Productname);
			String wishproduct = reader.getCellData("wishlistdata", "wishproduct", rownum);
			System.out.println(wishproduct);
			String Addtocartfromwishlist = reader.getCellData("wishlistdata", "Addtocartfromwishlist", rownum);
			System.out.println(Addtocartfromwishlist);
			String Removefromwishlist = reader.getCellData("wishlistdata", "Removefromwishlist", rownum);
			System.out.println(Removefromwishlist);
			String Quanity = reader.getCellData("wishlistdata", "Quanity", rownum);
			System.out.println(Quanity);
			String couponcode = reader.getCellData("wishlistdata", "couponcode", rownum);
			System.out.println(couponcode);
			String country = reader.getCellData("wishlistdata", "country", rownum);
			System.out.println(country);
			String state = reader.getCellData("wishlistdata", "state", rownum);
			System.out.println(state);
			String postcode = reader.getCellData("wishlistdata", "postcode", rownum);
			System.out.println(postcode);
			String giftcer = reader.getCellData("wishlistdata", "giftcer", rownum);
			System.out.println(giftcer);
			
			
			//reader.setCellData("Regdata", "status", rownum, "");
			
			Object ob[] = {Productname,wishproduct,Addtocartfromwishlist,Removefromwishlist,Quanity,couponcode,country,state,postcode,giftcer};
			mydata_wishlistdata.add(ob);
		}
		return mydata_wishlistdata;
	}


}
