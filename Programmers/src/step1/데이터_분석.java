package step1;
import java.util.*;

public class 데이터_분석 {
	
	class Solution {
	    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
	        List<int[]> answer = new ArrayList<>();
	        
	        //ext값이 val_ext보다 작은 데이터, sortby 기준으로 오름차순 정렬
	        
	        //1. 거르기
	        Map<String, Integer> sq = new HashMap<>();
	        sq.put("code",0);
	        sq.put("date",1);
	        sq.put("maximum",2);
	        sq.put("remain",3);
	        
	        int count = sq.get(ext);
	        int sort = sq.get(sort_by);
	        

	        for(int[] d :data){
	            if(d[count]<val_ext){
	                answer.add(d);
	            }
	        }
	                
	        //2. 정렬하기

	        Collections.sort(answer,(o1,o2)->o1[sort]-o2[sort]);  //sort 공부하기
	        return answer.toArray(new int[0][]);
	    }
	}
}
