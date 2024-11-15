package com.hrk.entity;

public class Noti {
    private Integer id;
    private String notiKind;
    private String notiContent;
    private String time;
    public Noti() {

    }

    @Override
    public String toString() {
        return "Noti{" +
                "id=" + id +
                ", notiKind='" + notiKind + '\'' +
                ", notiContent='" + notiContent + '\'' +
                ", time='" + time + '\'' +
                '}';
    }


    public String getNotiKind() {
        return notiKind;
    }

    public void setNotiKind(String notiKind) {
        this.notiKind = notiKind;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotiContent() {
        return notiContent;
    }

    public void setNotiContent(String notiContent) {
        this.notiContent = notiContent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
