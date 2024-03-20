package step1;

import java.util.Arrays;
import java.util.*;

public class 개인정보_수집_유효기간 {

	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		solution(today, terms, privacies);
	}
	
	
	
	public static int[] solution(String today, String[] terms, String[] privacies) {
        
        //today를 숫자 배열로 바꾸기
        int[] tDate = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int totalTDate = tDate[0]*12*28 + tDate[1]*28 + tDate[2];

        
        //terms를 map으로 바꾸기
        Map<String, String> termMap = new HashMap<>();
        for(String term : terms) {
        	String[] list = term.split(" ");
        	termMap.put(list[0], list[1]); // K : A V: 6...
        }
        
        //privacies를 map으로 바꾸고 날짜는 숫자 배열로 바꾸기 -> map은 key 중복 불가여서 그냥 바로 비교하기
        int index = 1;
        List<Integer> result = new ArrayList<>();
        for(String privacy : privacies) {
        	String[] list =  privacy.split(" ");
        	int[] pDate = Arrays.stream(list[0].split("\\.")).mapToInt(Integer::parseInt).toArray();

        	int totalPDate = pDate[0]*12*28 + pDate[1]*28 + pDate[2] +
        			Integer.valueOf(termMap.get(list[1]))*28 - 1;
        	
        	
        	if(totalPDate<totalTDate) {
        		result.add(index);

        	}
        	index++;
        }
        

        
        int[] answer = result.stream().mapToInt(Integer :: intValue).toArray();

		return answer;

		
	}
}
