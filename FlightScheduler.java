
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Flight {
    String departureAirport;
    String arrivalAirport;
    LocalTime departureTime;
    LocalTime arrivalTime;

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm");

    public Flight(String departureAirport, String arrivalAirport, String departureTime, String arrivalTime) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = LocalTime.parse(departureTime, TIME_FORMATTER);
        this.arrivalTime = LocalTime.parse(arrivalTime, TIME_FORMATTER);
    }

    public boolean conflictsWith(Flight other) {
        return this.arrivalTime.isAfter(other.departureTime) && this.departureAirport.equals(other.departureAirport);
    }

    @Override
    public String toString() {
        return departureAirport + " -> " + arrivalAirport + " (" + departureTime + " - " + arrivalTime + ")";
    }
}

class Aircraft {
    List<Flight> flights = new ArrayList<>();

    public boolean canAddFlight(Flight flight) {
        for (Flight existingFlight : flights) {
            if (flight.conflictsWith(existingFlight)) {
                return false;
            }
        }
        return true;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    @Override
    public String toString() {
        return flights.toString();
    }
}

public class FlightScheduler {

    public static List<Aircraft> randomWalkScheduler(List<Flight> flights, int n, int m) {
        List<Aircraft> bestPlan = null;

        for (int i = 0; i < m; i++) { // m번 반복하여 최적 계획 탐색
            List<Aircraft> currentPlan = generateRandomPlan(new ArrayList<>(flights), n);
            if (bestPlan == null || currentPlan.size() < bestPlan.size()) {
                bestPlan = currentPlan;
            }
        }

        return bestPlan;
    }

    private static List<Aircraft> generateRandomPlan(List<Flight> flights, int n) {
        Random random = new Random();
        List<Aircraft> aircrafts = new ArrayList<>();

        while(!flights.isEmpty()){
            Aircraft aircraft = new Aircraft();
            for(int i =0;i<n;i++){
                if(flights.isEmpty()){
                    break;
                }
                Flight flight = flights.get(random.nextInt(flights.size())); // 랜덤으로 비행 선택
                if (aircraft.canAddFlight(flight)) { // 조건 만족 시
                    aircraft.addFlight(flight); // 항공기에 비행 추가
                    flights.remove(flight); // 할당된 비행 제거
                }
            }
            if (!aircraft.flights.isEmpty()) { // 비행이 추가된 항공기만 리스트에 추가
                aircrafts.add(aircraft);
            }
        }
        return aircrafts;
    }


    public static List<Flight> loadFlightsFromInput() {
        Scanner scanner = new Scanner(System.in);
        List<Flight> flights = new ArrayList<>();
        System.out.println("Enter flight data line by line (empty line to finish):");
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            String[] parts = line.split(",");
            String departureAirport = parts[0];
            String arrivalAirport = parts[1];
            String departureTime = parts[2];
            String arrivalTime = parts[3];
            flights.add(new Flight(departureAirport, arrivalAirport, departureTime, arrivalTime));
        }
        return flights;
    }

    public static void main(String[] args) {
        // 입력 데이터를 읽어들임
        List<Flight> flights = loadFlightsFromInput();

        // 랜덤 워크 알고리즘 실행
        int n = 30;  // 각 항공기에서 비행 추가 시도 횟수
        int m = 100; // 전체 계획 반복 횟수
        List<Aircraft> optimalPlan = randomWalkScheduler(flights, n, m);

        // 결과 출력
        System.out.println("최적 항공기 수: " + optimalPlan.size());
        for (int i = 0; i < optimalPlan.size(); i++) {
            System.out.println("Aircraft " + (i + 1) + ": " + optimalPlan.get(i));
        }
    }
}


