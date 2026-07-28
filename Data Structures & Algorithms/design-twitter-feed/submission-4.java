
class Twitter {
    // Global timestamp to order tweets chronologically
    private static int timeStamp = 0;

    // Tweet node containing id and creation timestamp
    private static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    // Maps userId -> Set of followeeIds
    private Map<Integer, Set<Integer>> followMap;
    // Maps userId -> List of Tweets posted by user
    private Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        // Max-Heap ordered by most recent tweet timestamp
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        // Get set of followees (and ensure user sees their own tweets)
        Set<Integer> followees = new HashSet<>(followMap.getOrDefault(userId, new HashSet<>()));
        followees.add(userId);

        // Add all relevant users' tweets into the Max-Heap
        for (int followeeId : followees) {
            List<Tweet> tweets = tweetMap.get(followeeId);
            if (tweets != null) {
                // Add tweets to heap (or optimize by only taking recent ones)
                for (int i = tweets.size() - 1; i >= 0 && i >= tweets.size() - 10; i--) {
                    maxHeap.offer(tweets.get(i));
                }
            }
        }

        // Collect top 10 most recent tweets
        List<Integer> feed = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            feed.add(maxHeap.poll().id);
            count++;
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // Cannot follow yourself
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}