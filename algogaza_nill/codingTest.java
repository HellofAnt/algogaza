import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class codingTest {
    

    private static void test(){

        String str1 = "AA"; 
        String str2 = "AA"; 
        String str3 = "BB"; 
        System.out.println(str1.compareTo(str2));  // 결과  0 
        System.out.println(str2.compareTo(str3));  // 결과 -1 
        System.out.println(str3.compareTo(str2));  // 결과  1 


        ////// sort
        Integer arr[] = {4,23,33,15,17,19};
        // 오름차순
        Arrays.sort(arr); //4 15 17 19 23 33
        // 내림차순  -- 기본타입(int)은 reverseOrder()에서 사용 불가
        //              레퍼클래스(Integer)로 만들어야함
        Arrays.sort(arr,Collections.reverseOrder());
        Arrays.sort(arr, 0, 4); // 0,1,2,3 요소만 정렬 >4 15 23 33 17 19


        /////     compare과 compareTo를 이용한 sort
        int[] numbers = {1, 2, 3, 5, 33, 12};
        List<Integer> list4 = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list4.add(numbers[i]);
        }
        //List의 값(a, b)을 compare로 비교
        //익명함수(람다식)을 이용한 int를 String으로 바꿔서 문자열 합친 후 다시 Integer로 비교
        Collections.sort(list4, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });

        ////   다음은 compareTo를 이용한 방법
        String[] toString_numbers = new String[numbers.length];
        for(int i=0; i < numbers.length; i++){
            toString_numbers[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(toString_numbers, (o1,o2)->(o2+o1).compareTo(o1+o2));
        

        


        /////////    List
        LinkedList<Integer> list = new LinkedList<Integer>();//타입 미설정 Object로 선언된다.
        LinkedList<Student> members = new LinkedList<Student>();//타입설정 Student객체만 사용가능
        LinkedList<Integer> num = new LinkedList<Integer>();//타입설정 int타입만 사용가능
        LinkedList<Integer> num2 = new LinkedList<>();//new에서 타입 파라미터 생략가능
        LinkedList<Integer> list2 = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));

        
        list.addFirst(1);//가장 앞에 데이터 추가
        list.addLast(2);//가장 뒤에 데이터 추가
        list.add(3);//데이터 추가
        list.add(1, 10);//index 1뒤에 데이터 10 추가
        System.out.println(list.get(0));//0번째 index 출력
        System.out.println(list2.size()); //list2 크기 : 5
        System.out.println(list.contains(1)); //list에 1이 있는지 검색 : true
        System.out.println(list.indexOf(1)); //1이 있는 index반환 없으면 -1
        list2.removeFirst(); //가장 앞의 데이터 제거
        list2.removeLast(); //가장 뒤의 데이터 제거
        list2.remove(); //생략시 0번째 index제거
        list2.remove(1); //index 1 제거
        list2.clear(); //모든 값 제거

        for(Integer i : list2) { //for문을 통한 list 전체출력
            System.out.println(i);
        }

        
        ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(1,2,3));
        ArrayList<Student> members2 = new ArrayList<Student>();
        list3.add(3); //값 추가
        list3.add(null); //null값도 add가능
        list3.add(1,10); //index 1뒤에 10 삽입
        String name = "Chloe";
        Integer score = 95;
		Student student = new Student(name,score);
        members2.add(student);
        members2.add(3, new Student("홍길동", 85)); // index 3 뒤에 student 삽입, 뒤에 index 밀려남


        HashMap<String, String> dictEngToKor = new HashMap<>(); 
        
        //값을 추가하기 
        dictEngToKor.put("apple", "사과"); 
        dictEngToKor.put("book", "책"); 
        dictEngToKor.put("pen", "볼펜"); 
        
        //값을 꺼내기 
        System.out.println(dictEngToKor.get("apple")); 
        System.out.println(dictEngToKor.get("book")); 
        
        //값을 덮어씌우는 법 
        dictEngToKor.put("book", "도서"); 
        System.out.println(dictEngToKor.get("book")); 
        
        //값을 삭제 하는법 
        dictEngToKor.remove("book"); //book의 키값을 가진 값 삭제 
        System.out.println(dictEngToKor.get("book")); 
        
        //길이 확인 
        System.out.println("dictEngToKor의 길이: " + dictEngToKor.size());

        

        ////////    Map
        //HashMap으로 관리되는 데이터 전체를 다시 뽑을 때에는 순서가 뒤섞이게 된다. HashCode를 계산해서 사용하기 때문
        //HashMap은 빠른 탐색 가능 -시간복잡도O(1)
        Map<String, String> map = new HashMap<String, String>();

        map.put("Google", "USA");
        map.put("Naver", "Korea");
        map.put("Facebook", "USA");
        
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        // 출력 값
        // Naver:Korea
        // Facebook:USA
        // Google:USA

        //TreeMap은 key값 기준 정렬   -탐색,추가삭제 시간복잡도 O(log N)
        Map<String, String> map2 = new TreeMap<String, String>();

        map2.put("Google", "USA");
        map2.put("Naver", "Korea");
        map2.put("Facebook", "USA");

        for(Map.Entry<String, String> entry2 : map2.entrySet()) {
            System.out.println(entry2.getKey() + ":" + entry2.getValue());
        }
        // 출력 값
        // Facebook:USA
        // Google:USA
        // Naver:Korea

        
        //////   Queue (FIFO) / Stack (LIFO)
             //Queue
        // boolean add(Object o)	지정된 객체를  Queue 에 추가 성공하면 true를 반환, 
        //                         저장공간이 부족하면  IllegalStateException 발생
        // Object remove( )	Queue 에서 객체를 꺼내 반환.
        //                     비어있으면  NoSuchElementException 발생
        // Object element( )	삭제없이 요소를 읽어옴
        //                     peek 와 달리  Queue 가 비었을때  NoSuchElementException 발생
        // boolean offer(Object o)	Queue 에 객체를 저장
        //                         성공하면 true, 실패하면 false를 반환
        // Object poll( )	Queue 에서 객체를 꺼내서 반환.
        //                 비어있으면 null을 반환
        // Object peek( )	삭제없이 요소를 읽어온다.
        //                 Queue가 비어있으면 null을 반환
             //Stack
        // boolean empty( )	 Stack 이 비어있는지 알려줌
        // Object peek( ) 	 Stack 의 맨 위에 저장된 객체를 반환 pop( ) 과 달리
        //                   Stack 에서 객체를 꺼내지 않음(비었을 때는  EmptyStackException 발생)
        // Object pop( )	 Stack 의 맨 위에 저장된 객체를 꺼냄(비었을 때는  EmptyStackException 발생)
        // Object push(Object item)	 Stack 에 객체( item )를 저장
        // int search(Object o)	 Stack 에서 주어진 객체( o )를 찾아서 그 위치를 반환, 못 찾으면  -1 을 반환(배열과 달리 위치가 1부터 시작)


        Stack<String> st = new Stack<String>();
		Queue<String> q = new LinkedList<String>();	//Queue의 인터페이스 구현체인 LinkedList를 사용
		
		st.push("0 ");
		st.push("1 ");
		st.push("2 ");
		
		q.offer("0 ");
		q.offer("1 ");
		q.offer("2 ");
		
		System.out.println("=== Stack ===");
		while(!st.isEmpty()) {
			System.out.print(st.pop()); //2 1 0
		}
		
		System.out.println("=== Queue ===");
		while(!q.isEmpty()) {
			System.out.print(q.poll()); //0  1 2
        }
        
        //PriorityQueue - 우선순위 요소를 먼저 꺼냄
        //int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        //int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());

        //String형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
        PriorityQueue<String> priorityQueue3 = new PriorityQueue<>(); 

        //String형 priorityQueue 선언 (우선순위가 높은 숫자 순)
        PriorityQueue<String> priorityQueue4 = new PriorityQueue<>(Collections.reverseOrder());
        
        //add(value) 메서드의 경우 만약 삽입에 성공하면 true를 반환하고, 
        //큐에 여유 공간이 없어 삽입에 실패하면 IllegalStateException을 발생시킵니다
        priorityQueue.add(1);     // priorityQueue 값 1 추가
        priorityQueue.add(2);     // priorityQueue 값 2 추가
        priorityQueue.offer(3);   // priorityQueue 값 3 추가

        priorityQueue.poll();       // priorityQueue에 첫번째 값을 반환하고 제거 비어있다면 null
        priorityQueue.remove();     // priorityQueue에 첫번째 값 제거
        priorityQueue.clear();      // priorityQueue에 초기화
        
        //가장 높은값 참조
        priorityQueue.offer(2);     // priorityQueue에 값 2 추가
        priorityQueue.offer(1);     // priorityQueue에 값 1 추가
        priorityQueue.offer(3);     // priorityQueue에 값 3 추가
        priorityQueue.peek();       // priorityQueue에 첫번째 값 참조 = 1
    }


}


