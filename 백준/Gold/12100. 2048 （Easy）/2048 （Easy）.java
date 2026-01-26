import java.util.Scanner;

public class Main {

    static int answer;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] split = scan.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        backtrack(0, map);
        System.out.println(answer);
    }

    public static void backtrack(int count, int[][] map) {
        if (count >= 5) {
            int max = findMax(map);
            if (answer < max) answer = max;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[][] clone = new int[map.length][map.length];
            for (int j = 0; j < clone.length; j++) {
                clone[j] = map[j].clone();
            }
            go(clone, i);
            backtrack(count + 1, clone);
        }
    }

    public static void go(int[][] map, int direction) {
        int N = map.length;
        boolean[][] b = new boolean[N][N];

        if (direction == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) continue;
                    int cur = i;
                    while (cur > 0) {
                        int next = cur - 1;
                        if (map[next][j] != 0) {
                            if (map[next][j] != map[cur][j] || b[next][j] || b[cur][j]) {
                                break;
                            } else {
                                map[next][j] = 2 * map[next][j];
                                b[next][j] = true;
                                map[cur][j] = 0;
                            }
                        } else {
                            int tmp = map[next][j];
                            map[next][j] = map[cur][j];
                            map[cur][j] = tmp;
                            cur--;
                        }
                    }
                }
            }
        } else if (direction == 1) {
            for (int i = N - 1; i >= 0; i--) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) continue;
                    int cur = i;
                    while (cur < N - 1) {
                        int next = cur + 1;
                        if (map[next][j] != 0) {
                            if (map[next][j] != map[cur][j] || b[next][j] || b[cur][j]) {
                                break;
                            } else {
                                map[next][j] *= 2;
                                b[next][j] = true;
                                map[cur][j] = 0;
                                break;
                            }
                        } else {
                            map[next][j] = map[cur][j];
                            map[cur][j] = 0;
                            cur++;
                        }
                    }
                }
            }

        } else if (direction == 2) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) continue;
                    int cur = j;
                    while (cur > 0) {
                        int next = cur - 1;
                        if (map[i][next] != 0) {
                            if (map[i][next] != map[i][cur] || b[i][next] || b[i][cur]) {
                                break;
                            } else {
                                map[i][next] *= 2;
                                b[i][next] = true;
                                map[i][cur] = 0;
                                break;
                            }
                        } else {
                            map[i][next] = map[i][cur];
                            map[i][cur] = 0;
                            cur--;
                        }
                    }
                }
            }

        } else {
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    if (map[i][j] == 0) continue;
                    int cur = j;
                    while (cur < N - 1) {
                        int next = cur + 1;
                        if (map[i][next] != 0) {
                            if (map[i][next] != map[i][cur] || b[i][next] || b[i][cur]) {
                                break;
                            } else {
                                map[i][next] *= 2;
                                b[i][next] = true;
                                map[i][cur] = 0;
                                break;
                            }
                        } else {
                            map[i][next] = map[i][cur];
                            map[i][cur] = 0;
                            cur++;
                        }
                    }
                }
            }
        }
    }

    public static int findMax(int[][] map) {
        int max = 0;
        for (int[] m : map) {
            for (int n : m) {
                if (max < n) max = n;
            }
        }
        return max;
    }
}