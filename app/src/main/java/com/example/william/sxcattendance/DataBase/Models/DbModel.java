package com.example.william.sxcattendance.DataBase.Models;

import java.util.List;

public class DbModel {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name_of_department : CSIT
         * code : 1
         * hod : kk
         * Semester : [{"id":1,"code":1,"value":1,"department":"CSIT","batch":"2015","Students":[{"id":1,"first_name":"kk","middle_name":"kk","last_name":"kk","contact":"9854654654","department":"CSIT","semester":1}]},{"id":2,"code":3,"value":1,"department":"CSIT","batch":"2015","Students":[]}]
         */

        private int id;
        private String name_of_department;
        private String code;
        private String hod;
        private List<SemesterBean> Semester;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName_of_department() {
            return name_of_department;
        }

        public void setName_of_department(String name_of_department) {
            this.name_of_department = name_of_department;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getHod() {
            return hod;
        }
        }

        public List<SemesterBean> getSemester() {
            return Semester;
        }

        public void setSemester(List<SemesterBean> Semester) {
            this.Semester = Semester;
        }

        public static class SemesterBean {
            /**
             * id : 1
             * code : 1
             * value : 1
             * department : CSIT
             * batch : 2015
             * Students : [{"id":1,"first_name":"kk","middle_name":"kk","last_name":"kk","contact":"9854654654","department":"CSIT","semester":1}]
             */

            private int id;
            private int code;
            private int value;
            private String department;
            private String batch;
            private List<StudentsBean> Students;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public String getDepartment() {
                return department;
            }

            public void setDepartment(String department) {
                this.department = department;
            }

            public String getBatch() {
                return batch;
            }

            public void setBatch(String batch) {
                this.batch = batch;
            }

            public List<StudentsBean> getStudents() {
                return Students;
            }

            public void setStudents(List<StudentsBean> Students) {
                this.Students = Students;
            }

            public static class StudentsBean {
                /**
                 * id : 1
                 * first_name : kk
                 * middle_name : kk
                 * last_name : kk
                 * contact : 9854654654
                 * department : CSIT
                 * semester : 1
                 */

                private int id;
                private String first_name;
                private String middle_name;
                private String last_name;
                private String contact;
                private String department;
                private int semester;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getFirst_name() {
                    return first_name;
                }

                public void setFirst_name(String first_name) {
                    this.first_name = first_name;
                }

                public String getMiddle_name() {
                    return middle_name;
                }

                public void setMiddle_name(String middle_name) {
                    this.middle_name = middle_name;
                }

                public String getLast_name() {
                    return last_name;
                }

                public void setLast_name(String last_name) {
                    this.last_name = last_name;
                }

                public String getContact() {
                    return contact;
                }

                public void setContact(String contact) {
                    this.contact = contact;
                }

                public String getDepartment() {
                    return department;
                }

                public void setDepartment(String department) {
                    this.department = department;
                }

                public int getSemester() {
                    return semester;
                }

                public void setSemester(int semester) {
                    this.semester = semester;
                }
            }
        }
    }
}
