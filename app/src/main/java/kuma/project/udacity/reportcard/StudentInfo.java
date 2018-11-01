package kuma.project.udacity.reportcard;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.ArrayList;

public class StudentInfo implements Serializable {
    public static final String CLASS_NAME = "student_info";
    private String mId;
    private String mName;
    private int mGender;
    private int mPhotoResId;
    protected ArrayList<ReportCard> reportCards;

    public StudentInfo(String studentId, String studentName, int studentGender, int studentPhotoResId) {
        mId = studentId;
        mName = studentName;
        mGender = studentGender;
        mPhotoResId = studentPhotoResId;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public int getGender() {
        return mGender;
    }

    public int getPhotoResId() {
        return mPhotoResId;
    }

    public void setPhotoResId(int PhotoResId) {
        this.mPhotoResId = PhotoResId;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", mGender='" + mGender + '\'' +
                ", mPhotoResId=" + mPhotoResId +
                ", reportCards=" + reportCards +
                '}';
    }
}
