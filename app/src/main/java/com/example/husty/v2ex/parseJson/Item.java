package com.example.husty.v2ex.parseJson;

import android.graphics.Bitmap;

/**
 * Created by HUSTy on 2016/12/1.
 */

public class Item {
    public  int id;
    public String title;
    public String url;
    public String content;
    public String content_rendered;
    public String replies;
    public int created;
    public int last_modified;
    public int last_touched;
    public Member member;
    public Node node;
    public Bitmap bitmap;

    public static class Member{
        public int id;
        public String username;
        public String tagline;
        public String avatar_mini;
        public String avatar_normal;
        public String avatar_large;

        public int getId() {
            return id;
        }

        public String getTagline() {
            return tagline;
        }

        public String getAvatar_mini() {
            return avatar_mini;
        }

        public String getAvatar_normal() {
            return avatar_normal;
        }

        public String getAvatar_large() {
            return avatar_large;
        }

        public String getUsername() {
            return username;
        }
    }

    public static class Node{
        public int id;
        public String name;
        public String title;
        public String url;
        public String topics;
        public String avatar_mini;
        public String avater_normal;
        public String avater_large;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getTopics() {
            return topics;
        }

        public String getTitle() {
            return title;
        }

        public String getUrl() {
            return url;
        }

        public String getAvatar_mini() {
            return avatar_mini;
        }

        public String getAvater_normal() {
            return avater_normal;
        }

        public String getAvater_large() {
            return avater_large;
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    public String getContent_rendered() {
        return content_rendered;
    }

    public String getReplies() {
        return replies;
    }

    public int getCreated() {
        return created;
    }

    public int getLast_modified() {
        return last_modified;
    }

    public int getLast_touched() {
        return last_touched;
    }

    public Member getMember() {
        return member;
    }

    public Node getNode() {
        return node;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }


}
