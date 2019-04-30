package competitiveProgramming.yandexInternshipContest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        List<String> list = new ArrayList<>();
        for(int i = 0; i < t; i++) {
            list.add(reader.readLine());
        }

        Map<String, Map<String, Integer>> adj = new HashMap<>();
//        Map<String, Integer> strToId = new HashMap<>();
//        Map<Integer, String> idToStr = new HashMap<>();
//        int curId = 0;

        String prev = "";
        for(String s : list) {
            for(int i = 0; i < s.length() - 2; i++) {
                String w = s.substring(i, i + 3);
//                if(!strToId.containsKey(w)) {
//                    strToId.put(w, curId);
//                    idToStr.put(curId, w);
//                    curId++;
//                }

                if(!adj.containsKey(w))
                    adj.put(w, new HashMap<>());

                if(!prev.equals("")) {
//                    int cur = strToId.get(w);
//                    String prev = idToStr.get(cur - 1);

                    Map<String, Integer> node = adj.get(prev);
                    node.put(w, node.getOrDefault(w, 0) + 1);
                }
                prev = w;
            }
            prev = "";
        }

        System.out.println(adj.size());

        int edges = 0;
        for(Map.Entry<String, Map<String, Integer>> entry : adj.entrySet()) {
            Map<String, Integer> map = entry.getValue();
            edges += map.size();
        }

        System.out.println(edges);

        for(Map.Entry<String, Map<String, Integer>> entry : adj.entrySet()) {
            String cur = entry.getKey();
            for(Map.Entry<String, Integer> edge : entry.getValue().entrySet()) {
                System.out.println(cur + " " + edge.getKey() + " " + edge.getValue());
            }
        }




    }



}
