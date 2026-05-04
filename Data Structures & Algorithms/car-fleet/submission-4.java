class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

    int[][] arr = new int[position.length][2];

    for (int i = 0; i < position.length; i++) {
        arr[i][0] = position[i];
        arr[i][1] = speed[i];
    }

    Arrays.sort(arr, (a,b) -> a[0] - b[0]);

    int fleet = 1;
    double slowest = (double) (target - arr[arr.length - 1][0])/arr[arr.length - 1][1];
    for (int i = arr.length - 1; i >= 0; i--) {
        if ((double) (target - arr[i][0])/arr[i][1] > slowest) {
            fleet+=1;
            slowest = (double) (target - arr[i][0])/arr[i][1];
        }
    }
    return fleet;
    }
}
