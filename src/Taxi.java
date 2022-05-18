import java.util.UUID;

public class Taxi extends Car{

    String taxiNum;
    String destination;
    int basicDistance;
    int destinationDistance;
    int basicFare;
    int mileFare;

    // 택시 설정
    public Taxi(int gauge, int basicDistance, int basicFare, int mileFare){
        this.taxiNum = UUID.randomUUID().toString();
        this.gauge = gauge;
        this.basicDistance = basicDistance;
        this.basicFare = basicFare;
        this.mileFare = mileFare;
    }

    // 운행 시작
    public void startOper() {
        if(checkGuage())System.out.println("운행 시작하였습니다");
    }

    // 승객 탑승
    public void onTaxi(String destination, int destinationDistance) {
        if(!checkGuage())return;
        if(state){
            System.out.println("다른 손님이 타고 있습니다");
            return;
        }
        System.out.println("손님이 택시에 탔습니다");
        this.destination = destination;
        this.destinationDistance = destinationDistance;
        System.out.println("목적지 " + destination + "까지 남은 거리 " + destinationDistance + "km 입니다.");
        state = true;
    }

    // 요금 지불
    public int payFare(int fare) {
        System.out.println(destination + "에 도착하였습니다.");
        int totalFare = 0;
        int change = 0;
        if(destinationDistance<basicDistance){
            totalFare = basicFare;
            System.out.println("기본 요금 " + totalFare + " 입니다.");
        } else {
            totalFare = basicFare+(destinationDistance-basicDistance)*mileFare;
            System.out.println("이용 요금은 " + totalFare +" 원 입니다.");
        }

        change = fare - totalFare;

        if (change==0){
            System.out.println(fare + "원 받았습니다. 안녕히가세요");
        } else if (change>0){
            System.out.println(fare + "원 받았습니다. 거스름 돈 " + change + "원 입니다");
        } else {
            System.out.println(fare + "원 받았습니다." +(-change) + "원 부족합니다.");
            return 0;
        }

        return change;

    }
}


class TexiOperation {
    public static void main(String[] args) {
        int change;

        // 택시 설정 : 주유량(int), 기본거리(int), 기본요금(int), 추가요금(int)
        Taxi taxi = new Taxi( 10, 10, 2000, 100);

        taxi.startOper();

        // 승차 정보 : 목적지(String), 목적지까지의 거리(int)
        taxi.onTaxi("해운대", 13);

        // 변속 정보 : + 증가, -감소 (int)
        taxi.changeSpeed(100);

        // 요금 결제 : 요금 지불(int)
        change = taxi.payFare(3000);

        System.out.println("거스름돈 : " + change + "원 입니다.");
    }
}
