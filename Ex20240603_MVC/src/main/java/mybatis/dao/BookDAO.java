package mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.BookVO;

public class BookDAO {

	// 나중에 useBean으로 등록하여 사용할 객체
	public static BookVO[] getList() {

		BookVO[] b_ar = null;
		
		System.out.println("");
		
		SqlSession ss = FactoryService.getFactory().openSession(); 
		
		List<BookVO> b_list = ss.selectList("book.all");
		ss. close();
		
		// list의 요소들을 배열로 변환하자!
		if(b_list != null && !b_list.isEmpty()) {
			b_ar = new BookVO[b_list.size()];
			b_list.toArray(b_ar);
		}
		
		return b_ar;
	}
	
	
}
