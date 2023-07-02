package teamwork.com.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

/**
 * @description system_log
 * @author teamwork
 * @date 2023-06-30
 */

public class SystemLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    /**
    * access_time
    */
    private Timestamp accessTime;


    /**
    * access_url
    */
    private String accessUrl;

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }
    /**
    * created_at
    */
    private Timestamp createdAt;

    public Timestamp getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Timestamp accessTime) {
        this.accessTime = accessTime;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public SystemLog(Integer id, Timestamp accessTime, String accessUrl, Timestamp createdAt) {
        this.id = id;
        this.accessTime = accessTime;
        this.accessUrl = accessUrl;
        this.createdAt = createdAt;
    }

    public SystemLog() {}

    @Override
    public String toString() {
        return "SystemLog{" +
                "id=" + id +
                ", accessTime='" + accessTime + '\'' +
                ", accessUrl='" + accessUrl + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

}