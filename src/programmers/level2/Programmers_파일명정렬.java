package programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

// Programmers_파일명정렬_level2
public class Programmers_파일명정렬 {
	public static void main(String[] args) {
		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		System.out.println(Arrays.toString(solution(files)));
	}
	
	// 파일명 객체
	public static class File implements Comparable<File>{
		// 입력 순서
        int idx;
        // 파일의 문자부분
        String head;
        // 파일의 숫자부분
        int number;
        
        public File(int idx, String head, int number){
            this.idx = idx;
            this.head = head;
            this.number = number;
        }
        
        @Override
        public int compareTo(File o){
        	// 대소문자의 구분이 없다했으므로 전부 소문자로 변경 후 비교
            String thisHead = this.head.toLowerCase();
            String oHead = o.head.toLowerCase();
            // head가 다르면 사전 순
            if(!thisHead.equals(oHead)){
                return thisHead.compareTo(oHead);
            }
            // 숫자가 다르면 숫자 순
            if(this.number!=o.number){
                return Integer.compare(this.number,o.number);
            }
            // 둘 다 같으면 입력 순
            return Integer.compare(this.idx,o.idx);
        }
    }
    public static String[] solution(String[] files) {
    	// 정렬을 위한 우선순위 큐
        PriorityQueue<File> fileList = new PriorityQueue<>();
        
        // 모든 파일 조회
        for(int i = 0; i < files.length ; i++){
        	// 문자를 저장할 StringBuilder
            StringBuilder headSb = new StringBuilder();
            // 숫자를 저장할 StringBuilder
            StringBuilder numberSb = new StringBuilder();
            // 한 파일의 처음부터 끝까지 조회
            for(int j = 0; j < files[i].length(); j++){
            	// 현재 문자
                char curr = files[i].charAt(j);
                // 현재 문자가 숫자가 아니면 head StringBuilder에 저장
                if(!Character.isDigit(curr)){
                    headSb.append(curr);
                }
                // 아니면 그 이후를 돌면서 number StringBuilder에 저장
                else{
                    for(int k = j; k < files[i].length(); k++){
                        curr = files[i].charAt(k);
                        if(Character.isDigit(curr)){
                            numberSb.append(curr);
                        }
                        else{
                            break;
                        }
                    }
                    break;
                }
            }
            // 찾은 head와 number를 가지고 file객체를 생성하여 우선순위 큐에 저장하면 comparator에 의해 저장
            fileList.offer(new File(i,headSb.toString(),Integer.parseInt(numberSb.toString())));
        }
        // 정렬된 큐에서 뽑아 배열에 저장
        String[] answer = new String[files.length];
        for(int i = 0; i < files.length; i++){
            answer[i] = files[fileList.poll().idx];
        }
        return answer;         
    }
}
