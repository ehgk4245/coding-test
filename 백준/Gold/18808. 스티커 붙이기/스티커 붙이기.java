import java.util.*;

public class Main {

    static class Sticker {
        int[][] shape;
        int degree;

        Sticker(int[][] shape) {
            this.shape = shape;
            degree = 0;
        }

        void rotate() {
            int r = shape.length;
            int c = shape[0].length;

            int[][] rotated = new int[c][r];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    rotated[j][r - 1 - i] = shape[i][j];
                }
            }
            this.shape = rotated;
            degree++;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] split = input.split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int K = Integer.parseInt(split[2]);

        int[][] note = new int[N][M];
        Queue<Sticker> q = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            String[] split1 = scan.nextLine().split(" ");
            int r = Integer.parseInt(split1[0]);
            int c = Integer.parseInt(split1[1]);
            int[][] shape = new int[r][c];
            for (int j = 0; j < r; j++) {
                String[] split2 = scan.nextLine().split(" ");
                for (int k = 0; k < c; k++) {
                    shape[j][k] = Integer.parseInt(split2[k]);
                }
            }
            q.add(new Sticker(shape));
        }

        outer:
        while (!q.isEmpty()) {
            Sticker sticker = q.poll();
            while (sticker.degree <= 3) {
                int[][] shape = sticker.shape;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (attach(i, j, note, shape)) continue outer;
                    }
                }
                sticker.rotate();
            }
        }
        int answer = 0;
        for (int[] arr : note) {
            for (int n : arr) {
                answer += n;
            }
        }
        System.out.print(answer);
    }

    static boolean attach(int ri, int ci, int[][] note, int[][] shape) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (ri + i >= note.length || ci + j >= note[0].length) return false;
                if (shape[i][j] == 1 && note[ri + i][ci + j] == 1) return false;
            }
        }
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (shape[i][j] == 1) {
                    note[ri + i][ci + j] = shape[i][j];
                }
            }
        }
        return true;
    }
}