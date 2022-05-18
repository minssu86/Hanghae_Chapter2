public class Car {

    int gauge;
    int speed;
    boolean state;

    // 주유량 확인
    public boolean checkGuage() {
        if (gauge < 10) {
            System.out.println("현재 주유량은 " + gauge + " 입니다. 운행 불가 합니다");
            return false;
        }
        return true;
    }

    // 속도 변경
    public void changeSpeed(int speed) {
        if (!checkGuage()) return;
        if (speed > 0) {
            System.out.println(speed + "증속 합니다");
        } else {
            System.out.println(speed + "감속 합니다");
        }

        if (this.speed + speed < 0) {   // 속도 변경
            System.out.println("정지");
            this.speed = 0;
            state = false;
        } else {
            this.speed += speed;
            System.out.println("현재 속도는 : " + this.speed + " 입니다.");
        }

    }

}

