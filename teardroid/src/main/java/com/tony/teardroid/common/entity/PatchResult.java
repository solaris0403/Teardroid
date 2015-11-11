package com.tony.teardroid.common.entity;

/**
 * PatchResult
 */
public class PatchResult {

    private int    status;
    private String message;

    public PatchResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * get status
     * 
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * set status
     * 
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * get message
     * 
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * set message
     * 
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
