import java.util.*;

public class Leetcode399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            List<String> equation = equations.get(i);

            String first = equation.getFirst();
            String second = equation.getLast();

            Map<String, Double> firstValue = map.getOrDefault(first, new HashMap<>());
            double value = values[i];
            firstValue.put(second, value);

            Queue<String> queue = new LinkedList<>();
            queue.offer(second);
            Set<String> keysCovered = new HashSet<>();
            keysCovered.add(second);
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    String curr = queue.poll();
                    Map<String, Double> currMap = map.get(curr);
                    if(currMap == null)
                        continue;

                }
            }
            map.put(first, firstValue);

            for(String key : map.keySet()){
                Map<String, Double> subMap = map.get(key);
                keysCovered.add(first);
                keysCovered.add(second);
                for(String insideKey : subMap.keySet()){
                    if(insideKey.equals(second))
                        continue;

                }
            }

            Map<String, Double> secondValue = map.getOrDefault(second, new HashMap<>());
            secondValue.put(first, 1/values[i]);
            map.put(second, secondValue);

        }
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            List<String> query = queries.get(i);
            String first = query.getFirst();
            String second = query.getLast();

            if(!map.containsKey(first)){
                result[i] = -1.0;
                continue;
            }

            Map<String, Double> firstMap = map.get(first);
            if(firstMap.containsKey(second)){
                result[i] = firstMap.get(second);
                continue;
            }

            Map<String, Double> secondMap = map.get(second);
            if(secondMap == null) {
                result[i] = -1;
                continue;
            }
            String commonKey = "";
            for(String key : firstMap.keySet()){
                if(secondMap.containsKey(key)){
                    commonKey = key;
                    break;
                }
            }
            if(commonKey.equals("")) {
                result[i] = -1;
                continue;
            }

            Double value = firstMap.get(commonKey);
            value *= map.get(commonKey).get(second);
            result[i] = value;

        }
        return result;
    }

}
