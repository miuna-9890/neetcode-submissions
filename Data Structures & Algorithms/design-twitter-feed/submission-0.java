class Twitter {
    HashMap<Integer, HashSet<Integer>> follows;
    HashMap<Integer, ArrayList<int[]>> tweetMap;
    int count = 0;

    public Twitter() {
        follows = new HashMap<>();
        tweetMap = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if (tweetMap.get(userId) == null) {
            tweetMap.put(userId, new ArrayList<>());
        }

        ArrayList<int[]> tweets = tweetMap.get(userId);
        tweets.add(new int[]{count++, tweetId}); 
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        follows.putIfAbsent(userId, new HashSet<>());
        follows.get(userId).add(userId);

        for (int followee: follows.get(userId)) {
            if (tweetMap.get(followee) != null) {
                for (int[] tweet: tweetMap.get(followee)) {
                    maxHeap.add(tweet);
                }
            }            
        }

        List<Integer> ans = new ArrayList<>();
        while (ans.size() < 10 && !maxHeap.isEmpty()) {
            ans.add(maxHeap.poll()[1]);
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (follows.get(followerId) == null) {
            follows.put(followerId, new HashSet<>());
        }

        HashSet<Integer> followersList = follows.get(followerId);
        followersList.add(followeeId); 
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followersList = follows.get(followerId);
        followersList.remove(Integer.valueOf(followeeId)); 
    }
}
