package com.kurta.example.admin.kruta.Model;

import java.util.List;

/**
 * Created by Krutarth on 4/8/2017.
 */

public class MatrimonyItem {

    /**
     * status : true
     * records : [{"userId":"g8i7tgi87yi","creatorId":"86f87tg89i7","communityId":"jyhviyg9ou","visibleTo":["community","public"],"displayPicture":"https://pbs.twimg.com/profile_images/565802631231062016/7FuVrnc9.jpeg","fname":"Jay","lname":"Shah","gender":"male","maritalStatus":"Single"},{"userId":"g8i7tgi87yi","creatorId":"86f87tg89i7","communityId":"jyhviyg9ou","visibleTo":["community","public"],"displayPicture":"https://pbs.twimg.com/profile_images/565802631231062016/7FuVrnc9.jpeg","fname":"Krutarth","lname":"Doshi","gender":"male","maritalStatus":"Single"}]
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
         * userId : g8i7tgi87yi
         * creatorId : 86f87tg89i7
         * communityId : jyhviyg9ou
         * visibleTo : ["community","public"]
         * displayPicture : https://pbs.twimg.com/profile_images/565802631231062016/7FuVrnc9.jpeg
         * fname : Jay
         * lname : Shah
         * gender : male
         * maritalStatus : Single
         */

        private String userId;
        private String creatorId;
        private String communityId;
        private String displayPicture;
        private String fname;
        private String lname;
        private String gender;
        private String maritalStatus;
        private List<String> visibleTo;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(String creatorId) {
            this.creatorId = creatorId;
        }

        public String getCommunityId() {
            return communityId;
        }

        public void setCommunityId(String communityId) {
            this.communityId = communityId;
        }

        public String getDisplayPicture() {
            return displayPicture;
        }

        public void setDisplayPicture(String displayPicture) {
            this.displayPicture = displayPicture;
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

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public List<String> getVisibleTo() {
            return visibleTo;
        }

        public void setVisibleTo(List<String> visibleTo) {
            this.visibleTo = visibleTo;
        }
    }
}
