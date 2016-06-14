package Heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subhransumishra on 6/12/16.
 */

class TwitterClone {

    List<User> user;
    List<Integer> listID;

    /** Initialize your data structure here. */
    public TwitterClone() {
        user = new ArrayList<>();
        listID = new ArrayList<>();
    }

    public void addUser(int ID){
        user.add(new User(ID));
        listID.add(ID);
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        user.get(listID.indexOf(userId)).tweet(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if(user.get(listID.indexOf(userId)).FollowList.size()==0) {
            return user.get(listID.indexOf(userId)).getTweet();
        }else{
            List<Integer> AllFeed = new ArrayList<>();

            for(Integer i:user.get(listID.indexOf(userId)).getTweet()){
                AllFeed.add(i);
            }
            List<Integer> temp = new ArrayList<>();
            List<Integer> fl = user.get(listID.indexOf(userId)).FollowList;
            //System.out.println(fl);
            for (Integer i:fl){
                temp = user.get(listID.indexOf(i)).getTweet();
                for (Integer j:temp){
                    AllFeed.add(j);
                }
            }
            return AllFeed;
        }
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followeeId==followerId){
            System.out.println("Come on! You can not follow yourself!");
        }else{
            user.get(listID.indexOf(followerId)).following(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        user.get(listID.indexOf(followerId)).unfollow(followeeId);
    }

}

class User{
    int ID;
    List<Integer> FollowList;
    List<Integer> tweetID;

    public User(int ID){
        this.ID = ID;
        FollowList = new ArrayList();
        tweetID = new ArrayList();
    }

    public void following(int ID){
        FollowList.add(ID);
    }

    public void unfollow(int ID){
        FollowList.remove(FollowList.indexOf(ID));
    }

    public void tweet(int ID){
        tweetID.add(ID);
    }

    public int getID() {
        return ID;
    }

    public List<Integer> getTweet() {
        return tweetID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

public class Twitter{
    public static void main(String[] args){
        /**
         * Your Twitter object will be instantiated and called as such:
         * Twitter obj = new Twitter();
         * obj.postTweet(userId,tweetId);
         * List<Integer> param_2 = obj.getNewsFeed(userId);
         * obj.follow(followerId,followeeId);
         * obj.unfollow(followerId,followeeId);
         */

        TwitterClone twitter = new TwitterClone();

        //Add users
        twitter.addUser(1);
        twitter.addUser(2);
        twitter.addUser(3);
        twitter.addUser(4);
        twitter.addUser(5);
        twitter.addUser(6);



        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);


        // User 1's news feed should return a list with 1 tweet id -> [5].
        twitter.getNewsFeed(1);

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        System.out.println(twitter.getNewsFeed(1));

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        System.out.println(twitter.getNewsFeed(1));
    }
}