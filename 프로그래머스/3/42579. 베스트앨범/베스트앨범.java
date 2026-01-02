import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer_list = new ArrayList<>();
        Map<String, Musics> map = new HashMap<>();
        
        int size = genres.length;
        for (int i = 0; i < size; i++) {
            Music music = new Music(i, plays[i]);
            if (map.containsKey(genres[i])) {
                map.get(genres[i]).add(music);
            } else {
                Musics musics = new Musics();
                musics.add(music);
                map.put(genres[i], musics);
            }
        }
        
        List<Musics> musics = new ArrayList<>(map.values());
        musics.sort((a, b) -> b.totalPlays() - a.totalPlays());
        for (Musics m : musics) {
            if (m.list.size() >= 2) {
                for (int i = 0; i < 2; i++) {
                    answer_list.add(m.list.get(i).order);
                }
            } else {
                answer_list.add(m.list.get(0).order);
            }
        }
        
        return answer_list.stream().mapToInt(i -> i).toArray();
    }
    
    static class Musics {
        List<Music> list = new ArrayList<>();
        
        int totalPlays() {
            return list.stream().mapToInt(m -> m.plays).sum();
        }
        
        void add(Music music) {
            list.add(music);
            list.sort((a, b) -> b.plays - a.plays);
        }
    }
    
    static class Music {
        int order;
        int plays;
        
        Music(int order, int plays) {
            this.order = order;
            this.plays = plays;
        }
    }
}