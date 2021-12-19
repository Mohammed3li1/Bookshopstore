package bookshoptest;

public class books {
	int bookID;
	 String bookname,writer;
	 int price;
	public books(int bookID,String bookname, String writer,  int price) {
		super();
		this.bookname = bookname;
		this.writer = writer;
		this.bookID = bookID;
		this.price = price;
	}
	 

		public int totalofbooks(int total) {
			if(total>10 ){
				System.out.println("we don't have in store");
				return total;
							}
			System.out.println("we have "+total+" books in the store ");
			
			return 0;
		    }

}