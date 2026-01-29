import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Position {
        int r;
        int c;

        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int answer = 99999;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] split = scan.nextLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        List<Position> houseList = new ArrayList<>();
        List<Position> chickenList = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            String[] split1 = scan.nextLine().split(" ");
            for (int j = 1; j < N + 1; j++) {
                int num = Integer.parseInt(split1[j - 1]);
                if (num == 1) {
                    houseList.add(new Position(i, j));
                } else if (num == 2) {
                    chickenList.add(new Position(i, j));
                }
            }
        }

        List<List<Integer>> allCase = new ArrayList<>();
        findAllCase(allCase, new ArrayList<>(), 0, M, chickenList.size());

        for (List<Integer> list : allCase) {
            List<Position> cl = new ArrayList<>();
            for (int n : list) {
                cl.add(chickenList.get(n));
            }
            int dis = calculateMinChickenDistance(houseList, cl);
            if (dis < answer) answer = dis;
        }

        System.out.println(answer);
    }

    public static void findAllCase(List<List<Integer>> allCase, List<Integer> list, int start, int M, int size) {
        if (list.size() == M) {
            allCase.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < size; i++) {
            list.add(i);
            findAllCase(allCase, list, i + 1, M, size);
            list.remove(list.size() - 1);
        }
    }

    public static int calculateMinChickenDistance(List<Position> houseList, List<Position> chickenList) {
        int totalDistance = 0;
        for (Position house : houseList) {
            int distance = 10000;
            for (Position chicken : chickenList) {
                int dis = Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c);
                if (dis < distance) {
                    distance = dis;
                }
            }
            totalDistance += distance;
        }
        return totalDistance;
    }
}