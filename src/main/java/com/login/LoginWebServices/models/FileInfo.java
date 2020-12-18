package com.login.LoginWebServices.models;

public class FileInfo {

    private long filesize;
    private String filename;

    public FileInfo() {
    }

    public FileInfo(int filesize, String filename) {
        this.filesize = filesize;
        this.filename = filename;
    }

    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
