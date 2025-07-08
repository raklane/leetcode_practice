import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode1376 {

    public static void main(String[] args){
        System.out.println(numOfMinutes(15, 0, new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6},
                new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}));
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        HashMap<Integer, List<Integer>> managers = new HashMap<>();
        int employeesCovered = 0;
        for (int i = 0; i < manager.length && employeesCovered <= n-1; i++) {
            if(i==headID)
                continue;
            int employee = i;
            int managerNum = manager[i];
            List<Integer> employeeList = managers.get(managerNum);
            if(employeeList == null)
                employeeList = new ArrayList<>();
            employeeList.add(employee);
            managers.put(managerNum,employeeList);
            employeesCovered++;
        }
        return getInformTime(managers,headID,informTime);

    }

    public static int getInformTime(HashMap<Integer, List<Integer>> managers, int managerIndex, int[] informTime){

        List<Integer> employeesUnderManager = managers.get(managerIndex);
        if(employeesUnderManager == null)
            return 0;
        int informTimeForManager = informTime[managerIndex];
        int informTimeForSubManagers = 0;

        for (int employee : employeesUnderManager){
            informTimeForSubManagers = Math.max(informTimeForSubManagers, getInformTime(managers,employee,informTime));
        }
        return informTimeForManager+informTimeForSubManagers;

    }


}
