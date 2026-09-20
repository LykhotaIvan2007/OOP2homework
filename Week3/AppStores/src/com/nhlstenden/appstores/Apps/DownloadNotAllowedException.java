package com.nhlstenden.appstores.Apps;

public class DownloadNotAllowedException extends RuntimeException {
    public DownloadNotAllowedException() {
        super("Download Not Allowed");
    }
}
