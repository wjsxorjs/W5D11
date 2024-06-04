package mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.DeptVO;
import mybatis.vo.EmpVO;

public class DeptDAO {

	// 나중에 useBean으로 등록하여 사용할 객체
	public static DeptVO[] getList() {

		DeptVO[] d_ar = null;
		
		System.out.println("");
		
		SqlSession ss = FactoryService.getFactory().openSession(); 
		
		List<DeptVO> d_list = ss.selectList("dept.all");
		ss. close();
		
		// list의 요소들을 배열로 변환하자!
		if(d_list != null && !d_list.isEmpty()) {
			d_ar = new DeptVO[d_list.size()];
			d_list.toArray(d_ar);
		}
		
		return d_ar;
	}
	
	public static DeptVO[] searchList(Map<String, String> d_map) {

		DeptVO[] d_ar = null;
		
		// 인자로 받은 카테고리 값 중 하나를 받아서
		// shop_t라는 테이블로부터 해당 값을 검색한다.
		
		System.out.println("");
		
		SqlSession ss = FactoryService.getFactory().openSession(); 
		
		List<DeptVO> d_list = ss.selectList("dept.search",d_map);
		ss. close();
		
		// list의 요소들을 배열로 변환하자!
		if(d_list != null && !d_list.isEmpty()) {
			// ar을 list 크기만큼 배열을 생성하자
			d_ar = new DeptVO[d_list.size()];
			
			// p_list의 요소들을 한번에 배열에 복사한다.
			d_list.toArray(d_ar);
		}
		
		return d_ar;
	}
	
}
