public class Leetcode2211 {

    public static void main(String[] args){
        System.out.println(countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }

    public static int countCollisions(String directions) {

        char currentDirection = 'L';
        int collisions = 0;
        for (int i = 0; i < directions.length(); i++) {
            char carDirection = directions.charAt(i);
            switch (carDirection){
                case 'S':
                    if(currentDirection == 'R'){
                        collisions++;
                    }
                    currentDirection = 'S';
                    continue;
                case 'L':
                    if(currentDirection == 'S' || currentDirection == 'R'){
                        collisions = currentDirection == 'S' ? collisions+1 : collisions+2;
                        currentDirection = 'S';
                    }
                    continue;
                case 'R':
                    int rightCollision = 0;
                    while (i<directions.length() && directions.charAt(i) == 'R'){
                        i++;
                        rightCollision++;
                    }
                    if(i != directions.length()) {
                        collisions = directions.charAt(i) == 'S' ? collisions+rightCollision : collisions + rightCollision+1;
                    }
                    currentDirection = 'S';
            }
        }
        return collisions;

    }

}

/*
RLRSLL
SRSLL   1
SSLL    2
SSL     3
SS      4

RRRR
LLLL
RLRL
SS      2
LRLR
LSR     1
 */
