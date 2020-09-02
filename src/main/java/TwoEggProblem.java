// https://www.interviewcake.com/question/java/two-egg-problem
//
// 100 floors, 2 eggs
// find floor x where an egg does not break
// minimize count c of drops
//
// - skip floors
// - fallback to last known good and one floor at a time
// - decrease skip size by 1 to keep worst-case size constant
// - make sure skipping is possible until at the top -> last skip is at 98 to 100
//
// n + (n - 1) + (n - 2) + ... + 1 = 100
// n * (n + 1) / 2 = 100
// (n² + n) / 2 = 100
// n² + n = 200
// n² + n - 200 = 0
// n1,2 = (-b +/- sqrt(b² - 4ac)) / 2a
// n1,2 = (-1 +/- sqrt(1² - 4 * 1 * -200)) / 2 * 1
// ~= 13,65 -> skip 14 floors
public class TwoEggProblem {



}
