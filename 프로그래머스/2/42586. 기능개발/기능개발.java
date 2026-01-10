import java.util.*;

class Solution {
    static class Job {
        int progress;
        int speed;
        
        Job(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Job> q = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            q.add(new Job(progresses[i], speeds[i]));
        }
        
        while (!q.isEmpty()) {
            Job job = q.peek();
            if (job.progress >= 100) {
                int count = 0;
                while (!q.isEmpty() && q.peek().progress >= 100) {
                    q.poll();
                    count++;
                }
                answer.add(count);
            } else {
                for (Job j : q) {
                    j.progress += j.speed;
                }
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}