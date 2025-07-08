import java.util.*;

public class Leetcode721 {

    public static void main(String[] args){
        String[][] data = {
                {"John", "johnsmith@mail.com", "john_newyork@mail.com"},
                {"John", "johnsmith@mail.com", "john00@mail.com"},
                {"Mary", "mary@mail.com"},
                {"John", "johnnybravo@mail.com"}
        };

        // Convert the 2D array to a list of lists of strings
        List<List<String>> listOfLists = new ArrayList<>();
        for (String[] row : data) {
            listOfLists.add(new ArrayList<>(Arrays.asList(row)));
        }
        System.out.println(accountsMerge(listOfLists));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<Set<String>>> map = new HashMap<>();

        for(List<String> account : accounts){
            String name = account.removeFirst();
            List<Set<String>> emailFromDifferentPeopleSameName = map.getOrDefault(name, new ArrayList<>());
            boolean match = false;
            if(emailFromDifferentPeopleSameName.size() != 0){
                for(Set<String> emails : emailFromDifferentPeopleSameName){
                    for(String email : account){
                        if(emails.contains(email))
                            match = true;
                    }
                    if(match){
                        for(String email : account)
                            emails.add(email);
                        break;
                    }
                }
                if(match)
                    continue;
            }
            Set<String> set = new HashSet<>();
            for(String email : account)
                set.add(email);
            emailFromDifferentPeopleSameName.add(set);
            map.put(name, emailFromDifferentPeopleSameName);

        }

        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()){

            String name = key;
            List<Set<String>> emailSet = map.get(key);
            for(Set<String> emails : emailSet){
                PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int index = 0;
                        while (index < o1.length() && index < o2.length()){
                            if(o1.charAt(index) < o2.charAt(index))
                                return 0;
                            else if(o1.charAt(index) > o2.charAt(index))
                                return 1;
                            index++;
                        }
                        if(index == o1.length())
                            return 0;
                        else
                            return 1;
                    }
                });
                for(String email : emails)
                    queue.offer(email);
                List<String> sortedEmails = new ArrayList<>();
                sortedEmails.add(name);
                while (!queue.isEmpty())
                    sortedEmails.add(queue.poll());

                result.add(sortedEmails);
            }


        }
        return result;

    }

}
