package P4;

/*
 * ===================================================================================
 *  MINIMUM KEYSTROKES TO TURN A NUMBER INTO A PALINDROME  (Dynamic Programming)
 * ===================================================================================
 *
 * 1) COST MODEL
 * -------------
 * The positions between characters are "gaps" 0..N; the cursor starts at gap k.
 * Everything is measured in coordinates of the ORIGINAL string:
 *  - Supr with the cursor at gap p deletes char p and leaves the cursor just before
 *    char p+1, so a deletion also "moves" the cursor one char to the right.
 *  - Typing a digit at gap g puts it at gap g, and the cursor ends up to its right.
 *
 * Every edit needs the cursor on its position, so the cursor covers a contiguous
 * WINDOW of gaps [L, R] with L <= k <= R. Chars outside the window are never touched
 * (cost 0). Only two tours of the window are worth considering:
 *
 *  Tour A, left first:  k -> L with '<-', then L -> R with '->' / Supr.
 *      char left of k  (kept or deleted): 2 presses  ('<-' and later '->' or Supr)
 *      char right of k (kept or deleted): 1 press    ('->' or Supr)
 *      inserted digit: 1 press (typed on the way to the right, so it is never crossed)
 *
 *  Tour B, right first: k -> R with '->' / Supr, then R -> L with '<-'.
 *      char right of k kept:    2 presses ('->' and '<-')
 *      char right of k deleted: 1 press   (Supr; a deleted char isn't crossed again)
 *      char left of k kept:     1 press   ('<-')
 *      char left of k deleted:  2 presses ('<-' and Supr)
 *      inserted digit: 2 presses (typing it and then crossing it with '<-'), except
 *                      at gap L, where the tour ends: 1 press.
 *
 * So the answer is min(cost of tour A, cost of tour B). Each one is a sum of
 * per-char and per-insertion weights that only depend on the position.
 *
 * Also, the resulting number can't have leading zeros (except the one-digit
 * number "0"), so the outermost digit of the palindrome must not be '0'.
 *
 * 2) DYNAMIC PROGRAMMING (build the palindrome from the outside in)
 * ------------------------------------------------------------------
 * f(i, j, a, b, started) = minimum cost to turn the unprocessed chars s[i..j] into the
 * middle of the palindrome. The options at each step are:
 *  - match s[i] with s[j] (equal digits, both kept),
 *  - get rid of s[i]: delete it, or keep it and type a copy at gap j+1,
 *  - get rid of s[j]: delete it, or keep it and type a copy at gap i,
 *  - keep s[i] as the centre when i == j.
 * The digit to type is always a copy of an existing one, so we never need to choose it.
 *
 * To know whether a char/gap is inside the window (it pays) or outside (it's free),
 * each pointer carries the state of the gap it stands on (gap i for the left pointer,
 * gap j+1 for the right one):
 *      OUT_NEAR : not yet in the window  (left: gap < L,  right: gap > R)
 *      FIRST    : the gap is exactly L   (the first gap of the window)
 *      IN       : inside the window, but it isn't L
 *      OUT_FAR  : already past the window (left: gap > R,  right: gap < L)
 * The states only move forward as the pointers advance, gap k must always be inside,
 * and a char is inside iff the gaps on both of its sides are inside. When the pointers
 * meet on the same gap, their states must describe that gap the same way.
 * 'started' says whether the outermost pair of the palindrome has been placed yet (to
 * forbid a leading '0').
 *
 * 3) COMPLEXITY
 * -------------
 * f(i, j) only depends on f(i+1, j), f(i+1, j-1) and f(i, j-1). So we fill the table
 * with i going down and only keep two rows of (N+1) * 4 * 4 * 2 values.
 *      Time:   O(N^2) pairs (i, j) * constant work  ->  O(N^2)
 *      Memory: two rows                             ->  O(N)
 */
public class Principal {

    private static final int INF = Integer.MAX_VALUE / 4;

    // Window states of a gap (see the explanation above)
    private static final int OUT_NEAR = 0, IN = 1, OUT_FAR = 2, FIRST = 3;
    private static final int STATES = 4;

    // Allowed state of the next gap when the left pointer moves right (gap i -> gap i+1)
    private static final int[][] LEFT_NEXT = {
            {OUT_NEAR, FIRST}, // OUT_NEAR: the window may start at the next gap
            {IN, OUT_FAR},     // IN:       the window may end here (R = this gap)
            {OUT_FAR},         // OUT_FAR:  the window is already behind
            {IN, OUT_FAR}      // FIRST:    same as IN
    };
    // Allowed state of the next gap when the right pointer moves left (gap j+1 -> gap j)
    private static final int[][] RIGHT_NEXT = {
            {OUT_NEAR, IN, FIRST}, // OUT_NEAR: the window may end at the next gap (it may also be L)
            {IN, FIRST},           // IN:       the next gap may be L
            {OUT_FAR},             // OUT_FAR:  the window is already behind
            {OUT_FAR}              // FIRST:    gap L reached, the next gap is outside
    };

    public static int minCambios(String s, int k) {
        //                      keptL delL keptR delR  insert cost
        int tourA = solve(s, k, 2,    2,   1,    1,    false); // left first, then right
        int tourB = solve(s, k, 1,    2,   2,    1,    true);  // right first, then left
        return Math.min(tourA, tourB);
    }

    private static int solve(String s, int k, int keepL, int delL, int keepR, int delR, boolean tourB) {
        int n = s.length();
        // Rows indexed by jj = j + 1 (0..n), so that j = i - 1 = -1 fits in the array.
        int[][][][] next = new int[n + 1][STATES][STATES][2]; // row i + 1
        int[][][][] cur = new int[n + 1][STATES][STATES][2];  // row i

        for (int i = n; i >= 0; i--) {
            for (int j = i - 1; j < n; j++) {
                int jj = j + 1;
                for (int a = 0; a < STATES; a++)
                    for (int b = 0; b < STATES; b++)
                        for (int st = 0; st < 2; st++) {
                            if (j == i - 1) // Base case: the pointers meet on gap i
                                cur[jj][a][b][st] = (gapOk(a, i, k) && meetOk(a, b)) ? 0 : INF;
                            else
                                cur[jj][a][b][st] = step(s, k, i, j, a, b, st == 1, cur, next,
                                        keepL, delL, keepR, delR, tourB);
                        }
            }
            int[][][][] tmp = next; next = cur; cur = tmp;
        }

        // 'next' now holds row i = 0. Try every valid initial state for gaps 0 and N.
        int best = INF;
        for (int a : new int[]{OUT_NEAR, FIRST})
            for (int b : new int[]{OUT_NEAR, IN, FIRST})
                if (gapOk(a, 0, k) && gapOk(b, n, k))
                    best = Math.min(best, next[n][a][b][0]);
        return best;
    }

    // Computes f(i, j, a, b, started) for i <= j from the values already in the table.
    private static int step(String s, int k, int i, int j, int a, int b, boolean started,
                            int[][][][] cur, int[][][][] next,
                            int keepL, int delL, int keepR, int delR, boolean tourB) {
        int jj = j + 1;
        int best = INF;
        // An outermost pair made of '0' would be a leading zero
        boolean pairI = started || s.charAt(i) != '0'; // can s[i] (or its copy) form a pair?
        boolean pairJ = started || s.charAt(j) != '0';

        // ---- Moves that consume s[i]: the left pointer goes from gap i to gap i+1 ----
        for (int a2 : LEFT_NEXT[a]) {
            if (!gapOk(a2, i + 1, k)) continue;
            boolean in = inside(a) && inside(a2);             // is char i inside the window?
            int keep = in ? (i < k ? keepL : keepR) : 0;      // cost of walking over a kept s[i]
            int del = i < k ? delL : delR;

            // Delete s[i] (only possible inside the window)
            if (in)
                best = Math.min(best, del + next[jj][a2][b][started ? 1 : 0]);
            // Keep s[i] and type a copy of it at gap j+1 (that gap must be inside)
            if (inside(b) && pairI)
                best = Math.min(best, keep + insertCost(b, tourB) + next[jj][a2][b][1]);
            // s[i] is the centre of the palindrome (a single "0" is a valid number)
            if (i == j)
                best = Math.min(best, keep + next[jj][a2][b][1]);
            // Match s[i] with s[j]: the right pointer also goes from gap j+1 to gap j
            if (i < j && s.charAt(i) == s.charAt(j) && pairI) {
                for (int b2 : RIGHT_NEXT[b]) {
                    if (!gapOk(b2, j, k)) continue;
                    boolean inJ = inside(b) && inside(b2);
                    int keepJ = inJ ? (j < k ? keepL : keepR) : 0;
                    best = Math.min(best, keep + keepJ + next[jj - 1][a2][b2][1]);
                }
            }
        }

        // ---- Moves that consume only s[j]: the right pointer goes from gap j+1 to gap j ----
        for (int b2 : RIGHT_NEXT[b]) {
            if (!gapOk(b2, j, k)) continue;
            boolean in = inside(b) && inside(b2);             // is char j inside the window?
            int keep = in ? (j < k ? keepL : keepR) : 0;
            int del = j < k ? delL : delR;

            // Delete s[j]
            if (in)
                best = Math.min(best, del + cur[jj - 1][a][b2][started ? 1 : 0]);
            // Keep s[j] and type a copy of it at gap i (that gap must be inside)
            if (inside(a) && pairJ)
                best = Math.min(best, keep + insertCost(a, tourB) + cur[jj - 1][a][b2][1]);
        }
        return best;
    }

    private static boolean inside(int state) {
        return state == IN || state == FIRST;
    }

    // The cursor's starting gap k always has to be inside the window.
    private static boolean gapOk(int state, int gap, int k) {
        return gap != k || inside(state);
    }

    // Both pointers stand on the same gap: their states must describe it the same way.
    private static boolean meetOk(int a, int b) {
        return (a == OUT_NEAR && b == OUT_FAR) || (a == FIRST && b == FIRST)
                || (a == IN && b == IN) || (a == OUT_FAR && b == OUT_NEAR);
    }

    // Typing a digit costs 1, plus 1 more in tour B if the cursor has to cross it back
    // with '<-' (every gap except L, where tour B ends).
    private static int insertCost(int gapState, boolean tourB) {
        return tourB && gapState != FIRST ? 2 : 1;
    }

}
