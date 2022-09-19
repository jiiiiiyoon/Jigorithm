import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solve() {
        class Car{
            int inTime;
            String number;
            int parkingTime;
            boolean isIn;

            Car (int inTime, String number, int parkingTime, boolean isIn) {
                this.inTime = inTime;
                this.number = number;
                this.parkingTime = parkingTime;
                this.isIn = isIn;
            }

            public String getNumber() {
                return number;
            }
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] fees = {120, 0, 60, 591};  //기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
            String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
            ArrayList<Car> car = new ArrayList<>();
            HashMap<String, Integer> index = new HashMap<>();

            for (int i = 0; i < records.length; ++i) {
                String[] str = records[i].split(" ");
                //str[0] -> 시간, str[1] -> 차량번호, str[2] -> 주차여부
                String[] timeStr = str[0].split(":");
                int time = (Integer.parseInt(timeStr[0]) * 60) + Integer.parseInt(timeStr[1]);

                if (str[2].equals("IN")) {                      //입차
                    if (index.containsKey(str[1])) {            //주차기록이 있으면
                        int carIndex = index.get(str[1]);
                        car.set(carIndex, new Car(time, str[1], car.get(carIndex).parkingTime, true));

                    } else {                                    //주차기록이 없으면
                        index.put(str[1], car.size());
                        car.add(new Car(time, str[1], 0,true));
                    }

                } else {                                        //출차
                    int carIndex = index.get(str[1]);
                    int parkingTime = time - car.get(carIndex).inTime;

                    car.set(carIndex, new Car(time, str[1], car.get(carIndex).parkingTime + parkingTime, false));
                }
            }

            int[] answer = new int[index.size()];

            Comparator<Car> comparator = new Comparator<Car>() {
                @Override
                public int compare(Car o1, Car o2) {
                    String carNum1 = o1.number;
                    String carNum2 = o2.number;
                    return carNum1.compareToIgnoreCase(carNum2);
                }
            };

            Collections.sort(car, comparator);

            for (int i = 0; i < car.size(); ++i) {
                if (car.get(i).isIn) {
                    int parkingTime = 1439 - car.get(i).inTime;
                    car.set(i, new Car(1439, car.get(i).number, car.get(i).parkingTime + parkingTime, false));
                }
                if (car.get(i).parkingTime <= fees[0]) {
                    answer[i] = fees[1];
                } else {
                    answer[i] += fees[1];
                    int extraTime = car.get(i).parkingTime - fees[0];
                    answer[i] += (int) (Math.ceil((double) extraTime / (double)fees[2])) * fees[3];
                }
            }


            for (int i = 0; i < answer.length; ++i) {
                System.out.println(answer[i]);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}