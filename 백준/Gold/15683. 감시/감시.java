import java.util.*;

public class Main {
    static int answer = 64;

    static int[][][] dir = {
            {},
            {{1}, {2}, {3}, {4}},                 // 1번
            {{1, 3}, {2, 4}},                     // 2번
            {{1, 4}, {4, 3}, {3, 2}, {2, 1}},         // 3번
            {{1, 2, 4}, {1, 2, 3}, {2, 3, 4}, {1, 3, 4}}, // 4번
            {{1, 2, 3, 4}}                        // 5번
    };

    static class Position {
        int ri;
        int ci;
        int cctv;

        Position(int ri, int ci, int cctv) {
            this.ri = ri;
            this.ci = ci;
            this.cctv = cctv;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();
        String[] split = s.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[][] map = new int[n][m];
        List<Position> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] split1 = input.split(" ");
            for (int j = 0; j < m; j++) {
                int number = Integer.parseInt(split1[j]);
                map[i][j] = number;
                if (1 <= number && number <= 5) {
                    list.add(new Position(i, j, number));
                }
            }
        }

        search(map, list, 0);
        System.out.println(answer);
    }

    static void search(int[][] map, List<Position> list, int n) {
        if (n == list.size()) {
            int count = 0;
            for (int[] row : map) {
                for (int num : row) {
                    if (num == 0) count++;
                }
            }
            answer = Math.min(answer, count);
            return;
        }

        Position position = list.get(n);
        int cctv = position.cctv;

        for (int[] dset : dir[cctv]) {
            int[][] copy = copyMap(map);
            for (int d : dset) {
                go(position, copy, d, 7);
            }
            search(copy, list, n + 1);
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] copy = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            copy[i] = map[i].clone();
        }
        return copy;
    }

    static void go(Position position, int[][] map, int direction, int num) {
        int n = position.ri;
        int m = position.ci;
        if (direction == 1) {
            while (n >= 0 && map[n][m] != 6) {
                map[n--][m] = num;
            }
        } else if (direction == 3) {
            while (n < map.length && map[n][m] != 6) {
                map[n++][m] = num;
            }
        } else if (direction == 2) {
            while (m >= 0 && map[n][m] != 6) {
                map[n][m--] = num;
            }
        } else {
            while (m < map[0].length && map[n][m] != 6) {
                map[n][m++] = num;
            }
        }
    }
}