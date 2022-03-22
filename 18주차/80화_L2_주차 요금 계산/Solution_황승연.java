import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String,String> inTime = new HashMap<>();
        Map<String,Integer> sumTime = new HashMap<>();
        Map<String,Boolean> flag = new HashMap<>();
        
        for(int i=0;i<records.length;i++){
            StringTokenizer st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String number = st.nextToken();
            String inOut = st.nextToken();
            
            if(inOut.equals("IN")){
                inTime.put(number, time);
                flag.put(number,false);
            }else{
                String in = inTime.get(number);
                //시간 계산하는 함수로 계산
                int cal = calculator(in, time);
                sumTime.put(number, sumTime.getOrDefault(number,0)+cal);
                flag.put(number,true);
            }
        }
        
        for(String s:flag.keySet()){
            if(!flag.get(s)){
                sumTime.put(s, sumTime.getOrDefault(s,0)+calculator(inTime.get(s),"23:59"));
            }
        }
        
        List<Car> list = new ArrayList<>();
        
        for(String num:sumTime.keySet()){
            int money = fees[1];
            int minute = sumTime.get(num);
            System.out.println(num+" "+minute);
            if(minute>fees[0]){
                money+=Math.ceil((double)(minute-fees[0])/fees[2])*fees[3];
            }
            list.add(new Car(num,money));
        }
        
        Collections.sort(list, new Comparator<Car>(){
            public int compare(Car o1, Car o2){
                return o1.number.compareTo(o2.number);
            }
        });
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i).fee;
        }
        
        return answer;
    }
    
    static class Car{
        String number;
        int fee;
        public Car(String number,int fee){
            this.number = number;
            this.fee = fee;
        }
    }
    
    static int calculator(String in, String out){
        String[] arr = in.split("\\:");
        String[] arr2 = out.split("\\:");
        
        int min = Integer.parseInt(arr2[1])-Integer.parseInt(arr[1]);
        int hour = Integer.parseInt(arr2[0])-Integer.parseInt(arr[0]);
        
        if(min<0){
            hour-=1;
            min+=60;
        }
        
        return (hour*60)+min;
    }
}