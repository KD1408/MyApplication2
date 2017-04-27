package com.kurta.example.admin.kruta.Model;

import java.util.List;

/**
 * Created by Krutarth on 4/25/2017.
 */

public class DashboardItem {


    /**
     * status : true
     * records : [{"_id":"57dd048d45b169efde7dbe99","fname":"jay","lname":"shah","email":"jayshah@gmail.com","pictureUrl":"http://publichealth.gwu.edu/sites/default/files/graham_jay_250x250.png","action":"registered","text":"Registered in your community."},{"_id":"57dd048d45b169efde7dbe99","fname":"krutarth","lname":"doshi","email":"kk@gmail.com","pictureUrl":"http://jaysantos.com/wp-content/themes/jay%20nueva/images/JaySantos_YTO_05_thumb.jpg","action":"registered","text":"Registered in your community."}]
     * total : 2
     */

    private boolean status;
    private int total;
    private List<RecordsBean> records;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RecordsBean> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public static class RecordsBean {
        /**
         * _id : 57dd048d45b169efde7dbe99
         * fname : jay
         * lname : shah
         * email : jayshah@gmail.com
         * pictureUrl : http://publichealth.gwu.edu/sites/default/files/graham_jay_250x250.png
         * action : registered
         * text : Registered in your community.
         */

        private String _id;
        private String fname;
        private String lname;
        private String email;
        private String pictureUrl;
        private String action;
        private String text;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
