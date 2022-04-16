import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        Arrays.sort(timetable);
        
        String[] arriveTime = new String[n];
        arriveTime[0] = "09:00";
        for(int i=1;i<n;i++){
            boolean flag=false;
            String time = arriveTime[i-1].substring(0,2);
            int num = Integer.parseInt(arriveTime[i-1].substring(3,5));
            num += t;
            if(num>=60){
                flag=true;
                num-=60;
            }
            String str ="";
            if(flag){
                int intTime = Integer.parseInt(time);
                intTime+=1;
                str+=(intTime+"");
            }else{
                str+=time;
            }
            str+=":";
            if(num<10){
                str+="0";
            }
            str+=(num+"");
            arriveTime[i]=str;
        }
        
        List<String>[] list = new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }
        
        int size=0;
        int index=0;
        for(int i=0;i<n;i++){
            size=0;
            int busTime = Integer.parseInt(arriveTime[i].substring(0,2));
            int busMinute = Integer.parseInt(arriveTime[i].substring(3,5));
            for(int j=index;j<timetable.length;j++){
                if(size>=m){
                    break;
                }
               int crewTime = Integer.parseInt(timetable[j].substring(0,2));
                if(crewTime>busTime){
                    break;
                }
                int crewMinute = Integer.parseInt(timetable[j].substring(3,5));
                if(crewTime==busTime && crewMinute>busMinute){
                    break;
                }
                list[i].add(timetable[j]);
                size++;
                index++;
            }
        }
       
        if(list[n-1].size()<m){     //마지막 셔틀에 자리가 있을때
            answer = arriveTime[n-1];    //마지막 셔틀시간에 타면된다.
        }else{                          //마지막 셔틀에 풀방일때
            String last = list[n-1].get(list[n-1].size()-1);   //마지막에 탄사람
            
            // answer은 마지막에 탄사람보다 1분일찍오거나 같은시간에 타면된다. 이걸구별하는 방법은
            //맨처음 탄사람 시간을 봐서 마지막에 탄사람이랑 시간이 똑같으면 1분일찍와야한다.
            //아니라면 답은 마지막에 탄사람 시간
            
            //인줄 알았는데 마지막셔틀이 풀방이면 무조건 마지막사람보다 1분일찍와야하네;;
            // =>콘은 게으르기 때문에 같은 시각에 도착한 크루 중 대기열에서 제일 뒤에 선다.
            int Time = Integer.parseInt(last.substring(0,2));
            int Minute = Integer.parseInt(last.substring(3,5));

            String temp ="";
            Minute -=1;
            if(Minute<0){
                Time-=1;
                Minute =59;
            }
            if(Time<10){
                temp+="0";
            }
            temp+=(Time+"");
            temp+=":";
            if(Minute<10){
                temp+="0";
            }
            temp+=(Minute+"");
            answer=temp;

        }
 
        return answer;
    }
}