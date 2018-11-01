package kuma.project.udacity.reportcard;

import java.io.Serializable;

public class ReportCard implements Serializable {
    private String mSubjectName;
    private String mGrade;
    private int mYear;

    public ReportCard(String subjectName, String grade, int year) {
        mSubjectName = subjectName;
        mGrade = grade;
        mYear = year;
    }

    public void setSubjectName(String SubjectName) {
        this.mSubjectName = SubjectName;
    }

    public void setGrade(String grade){
        this.mGrade = grade;
    }

    public void setYear(int year) {
        this.mYear = year;
    }

    public String getSubjectName(){
        return mSubjectName;
    }

    public String getGrade(){
        return mGrade;
    }

    public int getYear(){
        return mYear;
    }

    @Override
    public String toString() {
        return "ReportCard{" +
                "mSubjectName='" + mSubjectName + '\'' +
                ", mGrade='" + mGrade + '\'' +
                ", mYear='" + mYear + '\'' +
                '}';
    }
}
