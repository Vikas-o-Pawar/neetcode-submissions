class Twitter {
    Map<Integer, Set<Integer>> userFollows;
    // userId -> the followers he has 

    Map<Integer, List<Tweet>> userPosts;
    int t;

    public Twitter() {
        this.userFollows = new HashMap<>();
        this.userPosts = new HashMap<>();
        this.t = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        userPosts.computeIfAbsent(userId, k -> new ArrayList<>());
        userPosts.get(userId).add(new Tweet(tweetId, this.t++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.tweet.time, a.tweet.time));

        userFollows.computeIfAbsent(userId, k -> new HashSet<>());
        userFollows.get(userId).add(userId);

        for(int followeeId: userFollows.get(userId)) {
            List<Tweet> tweets = userPosts.get(followeeId);

            if(tweets == null || tweets.size() == 0) continue;

            int idx = tweets.size() - 1;
            pq.offer(new Node(followeeId, idx, tweets.get(idx)));
        }

        List<Integer> res = new ArrayList<>();

        while(!pq.isEmpty() && res.size() < 10) {
            Node node = pq.poll();
            res.add(node.tweet.tweetId);
            node.idx--;
            if(node.idx < 0) continue;

            List<Tweet> tweets = userPosts.get(node.userId);
            pq.offer(new Node(
                node.userId,
                node.idx,
                tweets.get(node.idx)
            ));

        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userFollows.containsKey(followerId)) return;
        userFollows.get(followerId).remove(followeeId);
    }

    class Node {
        int userId;
        int idx;
        Tweet tweet;

        public Node(int userId, int idx, Tweet tweet) {
            this.userId = userId;
            this.idx = idx;
            this.tweet = tweet;
        }
    }

    class Tweet {
        int time; // time this tweet was added
        int tweetId; // tweet id of the post

        public Tweet(int tweetId, int time) {
            this.time = time;
            this.tweetId = tweetId;
        } 
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */