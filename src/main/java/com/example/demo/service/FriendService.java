package com.example.demo.service;

import com.example.demo.model.FriendMini;
import com.example.demo.model.FriendModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendService {
    private static FriendService FS;
    private List<FriendMini> friend = new ArrayList<>();
    private FriendMini f = new FriendMini();
    private List<FriendMini> friends;
    private FriendService() {

    }
    public static FriendService getFriendService() {
        if (FS == null){
            FS = new FriendService();
        }
        return FS;
    }
    public FriendModel findMaxCharFriend(FriendModel fm){
        int count = 0;
        int start = 0;
        String name;
        friends = fm.getFriends();
        for(FriendMini fmini : friends){
            count = fmini.getName().split(" ")[1].length();
            if(count > start){
                start = count;
                f = fmini;
            }
        }
        friend.add(f);
        fm.setFriends(friend);

        return fm;
    }
}
