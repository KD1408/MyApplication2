package com.kurta.example.admin.kruta.Model;

import java.util.List;

/**
 * Created by Krutarth on 4/2/2017.
 */

public class DirectoryItem {


    /**
     * status : true
     * records : [{"phone":"9099293669","_id":"57dd048d45b169efde7dbe99","fname":"jay","lname":"shah",
     * "email":"jayshah@gmail.com","addresses":[{"id":"57f385b1adfe718438a4d502",
     * "loc":{"lat":77.60062040000003,"lng":12.9226185},"zipcode":"560029","countryName":"India",
     * "stateName":"Karnataka","state":"KA","city":"Bengaluru","streetAddress2":"","streetAddress1":"112,
     * Bannerghatta Main Road, Jayanagara 9th Block, BTM Layout","addressType":"home","country":"IN"}],
     * "phones":[{"id":"57ef7bd8ec79984414a1d41c","number":"9099293669","privacy":"public","type":"Office"},
     * {"id":"57fcd5300291b3281dd521b9","number":"5588552255","privacy":"public","type":"home"}]},
     * {"_id":"57e2b17c45b169efde7dbe9b","fname":"Krutarth","lname":"Doshi","email":"krutarthdoshi14@gmail.com","addresses":[{"country":"India","city":"Vadodara","state":"Gujarat","zipcode":"333851","street":"Krutarth Street"}],"phones":[]},{"phone":"8472082753","_id":"57eff2a6496efee40a22604e","fname":"Lahar","lname":"Shah","email":"shahlahar@outlook.com","addresses":[{"country":"United States","city":"Palatine","state":"IL","zipcode":"60074","street":"1716 E Shannon Ln"}],"phones":[{"id":"57eff2e7496efee40a22604f","number":"8472082753","privacy":"public","type":"home"}]},{"_id":"57f028a0db8d02b02a3f9bb6","fname":"Haresh","lname":"Shah","email":"hjj60dakor@gmail.com","addresses":[{"country":"India","city":"Dakor","state":"Gujarat","zipcode":"388225","street":"Bhavsarni Khadki, Kapad bazar"}],"phones":[]},{"_id":"57f14131a309721a99bc0f59","fname":"KD","lname":"pathak","email":"krdoshi@bridgeport.edu","addresses":[],"phones":[]},{"_id":"57f3dfbca309721a99bc0f5b","fname":"hi","lname":"hello","email":"hi@hello","addresses":[],"phones":[]},{"_id":"57f3e1d5a309721a99bc0f5c","fname":"hello","lname":"hi","email":"hello@hi","addresses":[],"phones":[]},{"_id":"57f3e979a309721a99bc0f5d","fname":"jay","lname":"shah","email":"josegarcia@gmail.com","addresses":[],"phones":[]},{"_id":"57f3eb15a309721a99bc0f60","fname":"hdhhd","lname":"hshsb","email":"jayhh@gmail.com","addresses":[],"phones":[]},{"_id":"57f3ed73a309721a99bc0f61","fname":"jayshah","lname":"hahja","email":"habibi@gmakl.com","addresses":[],"phones":[]}]
     * total : 21
     * query : {"communityId":"57dd00df45b169efde7dbe98"}
     */

    private boolean status;
    private int total;
    private QueryBean query;
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

    public QueryBean getQuery() {
        return query;
    }

    public void setQuery(QueryBean query) {
        this.query = query;
    }

    public List<RecordsBean> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public static class QueryBean {
        /**
         * communityId : 57dd00df45b169efde7dbe98
         */

        private String communityId;

        public String getCommunityId() {
            return communityId;
        }

        public void setCommunityId(String communityId) {
            this.communityId = communityId;
        }
    }

    public static class RecordsBean {
        /**
         * phone : 9099293669
         * _id : 57dd048d45b169efde7dbe99
         * fname : jay
         * lname : shah
         * email : jayshah@gmail.com
         * addresses : [{"id":"57f385b1adfe718438a4d502","loc":{"lat":77.60062040000003,"lng":12.9226185},"zipcode":"560029","countryName":"India","stateName":"Karnataka","state":"KA","city":"Bengaluru","streetAddress2":"","streetAddress1":"112, Bannerghatta Main Road, Jayanagara 9th Block, BTM Layout","addressType":"home","country":"IN"}]
         * phones : [{"id":"57ef7bd8ec79984414a1d41c","number":"9099293669","privacy":"public","type":"Office"},{"id":"57fcd5300291b3281dd521b9","number":"5588552255","privacy":"public","type":"home"}]
         */

        private String phone;
        private String _id;
        private String fname;
        private String lname;
        private String email;
        private List<AddressesBean> addresses;
        private List<PhonesBean> phones;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

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

        public List<AddressesBean> getAddresses() {
            return addresses;
        }

        public void setAddresses(List<AddressesBean> addresses) {
            this.addresses = addresses;
        }

        public List<PhonesBean> getPhones() {
            return phones;
        }

        public void setPhones(List<PhonesBean> phones) {
            this.phones = phones;
        }

        public static class AddressesBean {
            /**
             * id : 57f385b1adfe718438a4d502
             * loc : {"lat":77.60062040000003,"lng":12.9226185}
             * zipcode : 560029
             * countryName : India
             * stateName : Karnataka
             * state : KA
             * city : Bengaluru
             * streetAddress2 :
             * streetAddress1 : 112, Bannerghatta Main Road, Jayanagara 9th Block, BTM Layout
             * addressType : home
             * country : IN
             */

            private String id;
            private LocBean loc;
            private String zipcode;
            private String countryName;
            private String stateName;
            private String state;
            private String city;
            private String streetAddress2;
            private String streetAddress1;
            private String addressType;
            private String country;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public LocBean getLoc() {
                return loc;
            }

            public void setLoc(LocBean loc) {
                this.loc = loc;
            }

            public String getZipcode() {
                return zipcode;
            }

            public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
            }

            public String getCountryName() {
                return countryName;
            }

            public void setCountryName(String countryName) {
                this.countryName = countryName;
            }

            public String getStateName() {
                return stateName;
            }

            public void setStateName(String stateName) {
                this.stateName = stateName;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getStreetAddress2() {
                return streetAddress2;
            }

            public void setStreetAddress2(String streetAddress2) {
                this.streetAddress2 = streetAddress2;
            }

            public String getStreetAddress1() {
                return streetAddress1;
            }

            public void setStreetAddress1(String streetAddress1) {
                this.streetAddress1 = streetAddress1;
            }

            public String getAddressType() {
                return addressType;
            }

            public void setAddressType(String addressType) {
                this.addressType = addressType;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public static class LocBean {
                /**
                 * lat : 77.60062040000003
                 * lng : 12.9226185
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }
        }

        public static class PhonesBean {
            /**
             * id : 57ef7bd8ec79984414a1d41c
             * number : 9099293669
             * privacy : public
             * type : Office
             */

            private String id;
            private String number;
            private String privacy;
            private String type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getPrivacy() {
                return privacy;
            }

            public void setPrivacy(String privacy) {
                this.privacy = privacy;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
