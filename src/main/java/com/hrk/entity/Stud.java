package com.hrk.entity;

public class Stud {
        private Integer sequence;
        private String studNumber;

    @Override
    public String toString() {
        return "Stud{" +
                "sequence=" + sequence +
                ", studNumber='" + studNumber + '\'' +
                ", studName='" + studName + '\'' +
                ", major='" + major + '\'' +
                ", studClass='" + studClass + '\'' +
                '}';
    }

    private String studName;
        private String major;
        private String studClass;

        public Stud(){

        }

        // Getters and Setters
        public Integer getSequence() {
            return sequence;
        }

        public void setSequence(Integer sequence) {
            this.sequence = sequence;
        }

        public String getStudNumber() {
            return studNumber;
        }

        public void setStudNumber(String studNumber) {
            this.studNumber = studNumber;
        }

        public String getStudName() {
            return studName;
        }

        public void setStudName(String studName) {
            this.studName = studName;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getStudClass() {
            return studClass;
        }

        public void setStudClass(String studClass) {
            this.studClass = studClass;
        }

}
