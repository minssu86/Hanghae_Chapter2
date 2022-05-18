import java.util.UUID;

public class Bus extends Car{

    int maxPassenger = 40; // 최대 승객수
    int currentPassenger; // 현재 승객수
    int fare;
    String busNum;

    // 버스 설정
    public Bus(int maxPassenger, int fare, int gauge) {  // 운행
        this.gauge= gauge;
        this.maxPassenger = maxPassenger;
        this.fare = fare;
        this.busNum = UUID.randomUUID().toString();
        if(!checkGuage())return;
        this.state = true;
        System.out.println("영업을 시작합니다.");
    }

    // 버스 상태 변경
    public void changeBusState(){
        if(!checkGuage())return;
        this.state = state; // 입력된 상태로 변경
        if(state==true){
            System.out.println("운행을 시작합니다.");
        } else {
            System.out.println("차고지로 돌아갑니다");
        }
    }

    // 승객 버스 탑승
    public void onBoard(int boardPassenger) {
        System.out.println("승객이 탑승 합니다");
        if(!state){  // 운행 상태 확인
            System.out.println("운행 중이지 않습니다");
            return;
        }
        if(currentPassenger+boardPassenger>maxPassenger){  // 버스 정원 확인 및 승객 증가
            System.out.println("정원 초과로 " + (currentPassenger+boardPassenger-maxPassenger) + " 명은 탑승 할 수 없습니다.");
            this.fare += (maxPassenger-currentPassenger)*1250;  // 요금 정산
            currentPassenger = maxPassenger;
            System.out.println("만차 입니다");
        } else {
            currentPassenger += boardPassenger;
            System.out.println("현재 " + currentPassenger + "명 탑승해 있습니다");
        }

    }

}


class BusOperation {

    public static void main(String[] args) {

        // 버스 설정 : 최대 승객수(int), 버스 요금(fare), 주유량(int)
        Bus bus = new Bus(30, 1200, 11 );  // 운행시작 (gas , speed)

        // 버스 상태 변경 :
        bus.changeBusState(); // 버스 상태 변경 true 운행, false 차고지행

        bus.onBoard(2); // 승객 탑승

        bus.changeSpeed(10);  // 속도 변경 양수이면 올리고, 음수이면 내린다

    }

}

