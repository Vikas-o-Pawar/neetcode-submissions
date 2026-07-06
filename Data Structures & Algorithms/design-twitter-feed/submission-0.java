class Twitter {

    Map<Integer, Set<Integer>> userFollows = new HashMap<>();
    Map<Integer, List<Tweet>> userPosts = new HashMap<>(); 
    int t = 0;

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
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.tweet.time, a.tweet.time));
        
        userFollows.computeIfAbsent(userId, k -> new HashSet<>());
        userFollows.get(userId).add(userId);

        for(int followee: userFollows.get(userId)) {
            List<Tweet> tweets = userPosts.get(followee);
            
            if (tweets == null || tweets.isEmpty()) {
            continue;
            }

            int idx = tweets.size() - 1;
            pq.offer(new Node(tweets.get(idx), followee, idx));
        }

        while(!pq.isEmpty() && res.size() < 10) {
            Node cur = pq.poll();
            res.add(cur.tweet.tweetId);
            
            if (cur.index > 0) {
                int nextIndex = cur.index - 1;
                List<Tweet> tweets = userPosts.get(cur.userId);
                pq.offer(new Node(tweets.get(nextIndex), cur.userId, nextIndex));
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;

        userFollows.computeIfAbsent(followerId, k -> new HashSet<>());
        userFollows.get(followerId).add(followeeId);   
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userFollows.containsKey(followerId)) return;  

        userFollows.get(followerId).remove(followeeId);      
    }

    class Tweet {
        int tweetId;
        int time;

        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    class Node {
        Tweet tweet;
        int userId;
        int index;

        Node(Tweet tweet, int userId, int index) {
            this.tweet = tweet;
            this.userId = userId;
            this.index = index;
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