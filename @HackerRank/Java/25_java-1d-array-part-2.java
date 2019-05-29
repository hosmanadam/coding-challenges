/* https://www.hackerrank.com/challenges/java-1d-array/problem */

import java.util.*;

/**
 * v3 - Back to basics
 *
 * Asks one simple question: can every obstacle be jumped through?
 * Beautifully simple, but it doesn't take into account the fact that not
 * all empty cells are reachable.
 *
 * In the following example, the algorithm would evaluate obstacles F & G to
 * jumpable, but fact is we couldn't jump from empty spot marked ✗ because it's
 * unreachable.
 *
 * leap = 5
 * . . . A B . C D . E . F G . . H . . . . .
 *                     ✗
 *
 * Obvious solution: don't try to jump from unreachable spots.
 *
 * To achieve this, whenever we can't jump to a spot, or walk to it, we could
 * mark it as unreachable, and then when evaluating an obstacle after it, we
 * don't try to jump from there.
 *
 * However, whether a cell is reachable by walking depends on on the
 * reachability of both previous and following cells, the latter which we
 * haven't checked yet. So the simple beuty of this approach is lost,
 * let's not do it.
 */
//import java.util.*;
//
//public class Solution {
//
//    public static boolean canWin(int leap, boolean[] game) {
//        outer:
//        for (int i = leap-1; i <= game.length-leap; i++)
//            if (!game[i]) {
//                for (int from = i+1-leap; from < i; from++)
//                    if (game[from] && game[from+leap])
//                        continue outer;
//                return false;
//            }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int q = scan.nextInt();
//        while (q-- > 0) {
//            int n = scan.nextInt();
//            int leap = scan.nextInt();
//
//            boolean[] game = new boolean[n];
//            for (int i = 0; i < n; i++) {
//                game[i] = scan.nextInt() == 0;
//            }
//
//            System.out.println((canWin(leap, game)) ? "YES" : "NO");
//        }
//        scan.close();
//    }
//}

/**
 * v2 - Non-recursive
 */
//public class Solution {
//
//    /**
//     * One iteration looks at where it is, walks as far as it can, and adds a jump
//     * from all positions that make sense.
//     *
//     * @param game Cells are true where empty, false where blocked
//     */
//    private static boolean canWin(int leap, boolean[] game) {
//        if (allClear(game))
//            return true;
//
//        Set<Integer> visited = new HashSet<>();
//        Set<Integer> posNow = new HashSet<>();
//        Set<Integer> posNext = new HashSet<>();
//        posNow.add(0);
//
//        while (posNow.size() > 0) {
//            for (int position : posNow) {
//                if (position >= game.length)
//                    return true;
//                if (!game[position] || visited.contains(position))
//                    continue;
//
//                while (position < game.length-1 && game[position+1])
//                    position++;
//
//                int backtrackLimit = 1;
//                while (backtrackLimit <= position && backtrackLimit < leap-1 && game[position-backtrackLimit])
//                    backtrackLimit++;
//
//                for (int backtrack = 0; backtrack < backtrackLimit; backtrack++) {
//                    posNext.add(position-backtrack+leap);
//                }
//            }
//            visited.addAll(posNow);
//            posNow = posNext;
//            posNext = new HashSet<>();
//        }
//
//        return false;
//    }
//
//    private static boolean allClear(boolean[] game) {
//        for (boolean cell : game)
//            if (!cell)
//                return false;
//        return true;
//    }
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int q = scan.nextInt();
//        while (q-- > 0) {
//            int n = scan.nextInt();
//            int leap = scan.nextInt();
//
//            boolean[] game = new boolean[n];
//            for (int i = 0; i < n; i++) {
//                game[i] = scan.nextInt() == 0;
//            }
//
//            System.out.println((canWin(leap, game)) ? "YES" : "NO" );
//        }
//        scan.close();
//    }
//}

/**
 * v1 - Recursive
 */
public class Solution {

    private static Set<Integer> visited = new HashSet<>();

    /**
     * One call looks at where it is, walks as far as it can, and calls a jump
     * from all positions that make sense.
     *
     * @param game Cells are true where empty, false where blocked
     */
    public static boolean canWin(int leap, boolean[] game, int position) {
        if (position >= game.length)
            return true;
        if (!game[position] || visited.contains(position))
            return false;

        visited.add(position);

        while (position < game.length-1 && game[position+1])
            position++;

        int backtrackLimit = 1;
        while (backtrackLimit <= position && backtrackLimit < leap-1 && game[position-backtrackLimit])
            backtrackLimit++;

        for (int backtrack = 0; backtrack < backtrackLimit; backtrack++) {
            if (canWin(leap, game, position-backtrack+leap))
                return true;
        }
        return false;
    }

    private static boolean allClear(boolean[] game) {
        for (boolean cell : game)
            if (!cell)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            boolean[] game = new boolean[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt() == 0;
            }

            visited.clear();
            System.out.println(
                    allClear(game) || canWin(leap, game, 0)
                            ? "YES"
                            : "NO" );
        }
        scan.close();
    }
}
