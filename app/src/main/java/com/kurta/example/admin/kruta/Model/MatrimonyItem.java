package com.kurta.example.admin.kruta.Model;

import java.util.List;

/**
 * Created by Krutarth on 4/8/2017.
 */

public class MatrimonyItem {
    /**
     * status : true
     * records : [{"userId":1,"creatorId":1,"communityId":1,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Errick","lname":"Riba","gender":"male","maritalStatus":"single"},{"userId":2,"creatorId":2,"communityId":2,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Ibrahim","lname":"Baudrey","gender":"male","maritalStatus":"single"},{"userId":3,"creatorId":3,"communityId":3,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Vernon","lname":"Blyth","gender":"male","maritalStatus":"single"},{"userId":4,"creatorId":4,"communityId":4,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Eadmund","lname":"Gregg","gender":"male","maritalStatus":"single"},{"userId":5,"creatorId":5,"communityId":5,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Case","lname":"Havesides","gender":"male","maritalStatus":"single"},{"userId":6,"creatorId":6,"communityId":6,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Jordon","lname":"Rayman","gender":"male","maritalStatus":"single"},{"userId":7,"creatorId":7,"communityId":7,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Pacorro","lname":"Rathborne","gender":"male","maritalStatus":"single"},{"userId":8,"creatorId":8,"communityId":8,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Weylin","lname":"Rudham","gender":"male","maritalStatus":"single"},{"userId":9,"creatorId":9,"communityId":9,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Andy","lname":"Pavy","gender":"male","maritalStatus":"single"},{"userId":10,"creatorId":10,"communityId":10,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Dom","lname":"Butler","gender":"male","maritalStatus":"single"},{"userId":11,"creatorId":11,"communityId":11,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Case","lname":"Tutton","gender":"male","maritalStatus":"single"},{"userId":12,"creatorId":12,"communityId":12,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Emanuele","lname":"Bamforth","gender":"male","maritalStatus":"single"},{"userId":13,"creatorId":13,"communityId":13,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Elwood","lname":"Allom","gender":"male","maritalStatus":"single"},{"userId":14,"creatorId":14,"communityId":14,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Frank","lname":"Fairham","gender":"male","maritalStatus":"single"},{"userId":15,"creatorId":15,"communityId":15,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Ralph","lname":"Costigan","gender":"male","maritalStatus":"single"},{"userId":16,"creatorId":16,"communityId":16,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Meredeth","lname":"Matiewe","gender":"male","maritalStatus":"single"},{"userId":17,"creatorId":17,"communityId":17,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Dar","lname":"Grinley","gender":"male","maritalStatus":"single"},{"userId":18,"creatorId":18,"communityId":18,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Marcello","lname":"Neilly","gender":"male","maritalStatus":"single"},{"userId":19,"creatorId":19,"communityId":19,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Hamilton","lname":"Shottin","gender":"male","maritalStatus":"single"},{"userId":20,"creatorId":20,"communityId":20,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Rock","lname":"Ivanilov","gender":"male","maritalStatus":"single"},{"userId":21,"creatorId":21,"communityId":21,"displayPicture":"http://dummyimage.com/250x250.jpg/cc0000/ffffff","fname":"Erasmus","lname":"Andriss","gender":"male","maritalStatus":"single"},{"userId":22,"creatorId":22,"communityId":22,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Olvan","lname":"Cota","gender":"male","maritalStatus":"single"},{"userId":23,"creatorId":23,"communityId":23,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Gail","lname":"Drewell","gender":"male","maritalStatus":"single"},{"userId":24,"creatorId":24,"communityId":24,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Hayyim","lname":"Mycock","gender":"male","maritalStatus":"single"},{"userId":25,"creatorId":25,"communityId":25,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Franciskus","lname":"Ritchman","gender":"male","maritalStatus":"single"},{"userId":26,"creatorId":26,"communityId":26,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Jacky","lname":"Luke","gender":"male","maritalStatus":"single"},{"userId":27,"creatorId":27,"communityId":27,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Garth","lname":"Camp","gender":"male","maritalStatus":"single"},{"userId":28,"creatorId":28,"communityId":28,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Land","lname":"Slide","gender":"male","maritalStatus":"single"},{"userId":29,"creatorId":29,"communityId":29,"displayPicture":"http://dummyimage.com/250x250.jpg/cc0000/ffffff","fname":"Tobie","lname":"Gatchel","gender":"male","maritalStatus":"single"},{"userId":30,"creatorId":30,"communityId":30,"displayPicture":"http://dummyimage.com/250x250.jpg/cc0000/ffffff","fname":"Cirstoforo","lname":"Aizic","gender":"male","maritalStatus":"single"}]
     * total : 30
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
         * userId : 1
         * creatorId : 1
         * communityId : 1
         * displayPicture : http://dummyimage.com/250x250.jpg/ff4444/ffffff
         * fname : Errick
         * lname : Riba
         * gender : male
         * maritalStatus : single
         */

        private int userId;
        private int creatorId;
        private int communityId;
        private String displayPicture;
        private String fname;
        private String lname;
        private String gender;
        private String maritalStatus;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(int creatorId) {
            this.creatorId = creatorId;
        }

        public int getCommunityId() {
            return communityId;
        }

        public void setCommunityId(int communityId) {
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
    }

    //{"status":true,
    // "records":[{"userId":1,"creatorId":1,"communityId":1,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Errick","lname":"Riba","gender":"male","maritalStatus":"single"},{"userId":2,"creatorId":2,"communityId":2,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Ibrahim","lname":"Baudrey","gender":"male","maritalStatus":"single"},{"userId":3,"creatorId":3,"communityId":3,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Vernon","lname":"Blyth","gender":"male","maritalStatus":"single"},{"userId":4,"creatorId":4,"communityId":4,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Eadmund","lname":"Gregg","gender":"male","maritalStatus":"single"},{"userId":5,"creatorId":5,"communityId":5,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Case","lname":"Havesides","gender":"male","maritalStatus":"single"},{"userId":6,"creatorId":6,"communityId":6,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Jordon","lname":"Rayman","gender":"male","maritalStatus":"single"},{"userId":7,"creatorId":7,"communityId":7,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Pacorro","lname":"Rathborne","gender":"male","maritalStatus":"single"},{"userId":8,"creatorId":8,"communityId":8,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Weylin","lname":"Rudham","gender":"male","maritalStatus":"single"},{"userId":9,"creatorId":9,"communityId":9,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Andy","lname":"Pavy","gender":"male","maritalStatus":"single"},{"userId":10,"creatorId":10,"communityId":10,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Dom","lname":"Butler","gender":"male","maritalStatus":"single"},{"userId":11,"creatorId":11,"communityId":11,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Case","lname":"Tutton","gender":"male","maritalStatus":"single"},{"userId":12,"creatorId":12,"communityId":12,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Emanuele","lname":"Bamforth","gender":"male","maritalStatus":"single"},{"userId":13,"creatorId":13,"communityId":13,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Elwood","lname":"Allom","gender":"male","maritalStatus":"single"},{"userId":14,"creatorId":14,"communityId":14,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Frank","lname":"Fairham","gender":"male","maritalStatus":"single"},{"userId":15,"creatorId":15,"communityId":15,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Ralph","lname":"Costigan","gender":"male","maritalStatus":"single"},{"userId":16,"creatorId":16,"communityId":16,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Meredeth","lname":"Matiewe","gender":"male","maritalStatus":"single"},{"userId":17,"creatorId":17,"communityId":17,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Dar","lname":"Grinley","gender":"male","maritalStatus":"single"},{"userId":18,"creatorId":18,"communityId":18,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Marcello","lname":"Neilly","gender":"male","maritalStatus":"single"},{"userId":19,"creatorId":19,"communityId":19,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Hamilton","lname":"Shottin","gender":"male","maritalStatus":"single"},{"userId":20,"creatorId":20,"communityId":20,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Rock","lname":"Ivanilov","gender":"male","maritalStatus":"single"},{"userId":21,"creatorId":21,"communityId":21,"displayPicture":"http://dummyimage.com/250x250.jpg/cc0000/ffffff","fname":"Erasmus","lname":"Andriss","gender":"male","maritalStatus":"single"},{"userId":22,"creatorId":22,"communityId":22,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Olvan","lname":"Cota","gender":"male","maritalStatus":"single"},{"userId":23,"creatorId":23,"communityId":23,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Gail","lname":"Drewell","gender":"male","maritalStatus":"single"},{"userId":24,"creatorId":24,"communityId":24,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Hayyim","lname":"Mycock","gender":"male","maritalStatus":"single"},{"userId":25,"creatorId":25,"communityId":25,"displayPicture":"http://dummyimage.com/250x250.jpg/dddddd/000000","fname":"Franciskus","lname":"Ritchman","gender":"male","maritalStatus":"single"},{"userId":26,"creatorId":26,"communityId":26,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Jacky","lname":"Luke","gender":"male","maritalStatus":"single"},{"userId":27,"creatorId":27,"communityId":27,"displayPicture":"http://dummyimage.com/250x250.jpg/5fa2dd/ffffff","fname":"Garth","lname":"Camp","gender":"male","maritalStatus":"single"},{"userId":28,"creatorId":28,"communityId":28,"displayPicture":"http://dummyimage.com/250x250.jpg/ff4444/ffffff","fname":"Land","lname":"Slide","gender":"male","maritalStatus":"single"},{"userId":29,"creatorId":29,"communityId":29,"displayPicture":"http://dummyimage.com/250x250.jpg/cc0000/ffffff","fname":"Tobie","lname":"Gatchel","gender":"male","maritalStatus":"single"},{"userId":30,"creatorId":30,"communityId":30,"displayPicture":"http://dummyimage.com/250x250.jpg/cc0000/ffffff","fname":"Cirstoforo","lname":"Aizic","gender":"male","maritalStatus":"single"}],
    // "total":30}

}
