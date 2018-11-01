package kuma.project.udacity.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayList<String> mGirlsName = new ArrayList<>();
    private ArrayList<String> mBoysName = new ArrayList<>();
    private ArrayList<String> mSurnames = new ArrayList<>();
    private ArrayList<String> mSubjectNames = new ArrayList<>();
    public static final int SHOW_STUDENT_REPORT_CARDS = 10;
    public static final int SHOW_STUDENT_ID_START_FROM = 900000;
    public static final int CURRENT_YEAR = 2018;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeArrayLists();
        ArrayList<StudentInfo> studentList = loadStudentInfo();
        StudentAdapter studentAdapter = new StudentAdapter(this, studentList);
        ListView studentListView = this.findViewById(R.id.student_list);
        studentListView.setAdapter(studentAdapter);
        studentListView.setOnItemClickListener(this);
    }

    private void initializeArrayLists(){
        mGirlsName.add("Emma");
        mGirlsName.add("Larissa");
        mGirlsName.add("Edith");
        mGirlsName.add("Sophia");
        mGirlsName.add("Joyce");
        mGirlsName.add("Ashley");
        mGirlsName.add("May");
        mGirlsName.add("Ivy");
        mGirlsName.add("Hailey");
        mGirlsName.add("Stella");
        mGirlsName.add("Gloria");
        mGirlsName.add("Amy");
        mGirlsName.add("Jessie");
        mGirlsName.add("Lucy");
        mGirlsName.add("Amanda");
        mGirlsName.add("Jennifer");
        mGirlsName.add("Abby");
        mGirlsName.add("Chelsea");
        mGirlsName.add("Lorraine");
        mGirlsName.add("Marian");
        mGirlsName.add("Anne");
        mGirlsName.add("Loren");
        mGirlsName.add("Bella");
        mGirlsName.add("Sarah");
        mGirlsName.add("Colin");
        mGirlsName.add("Kate");
        mBoysName.add("Wilson");
        mBoysName.add("Carl");
        mBoysName.add("Warren");
        mBoysName.add("Kevin");
        mBoysName.add("James");
        mBoysName.add("Solomon");
        mBoysName.add("Leon");
        mBoysName.add("Barry");
        mBoysName.add("Benson");
        mBoysName.add("Albert");
        mBoysName.add("Bruce");
        mBoysName.add("Paul");
        mBoysName.add("Charles");
        mBoysName.add("Denny");
        mBoysName.add("Wesley");
        mBoysName.add("Abraham");
        mBoysName.add("Andrew");
        mBoysName.add("Abel");
        mBoysName.add("Kenny");
        mBoysName.add("Ben");
        mBoysName.add("Evan");
        mBoysName.add("Bill");
        mBoysName.add("Nick");
        mBoysName.add("Peter");
        mBoysName.add("Jason");
        mBoysName.add("Johnny");
        mSurnames.add("Smith");
        mSurnames.add("Jones");
        mSurnames.add("Williams");
        mSurnames.add("Taylor");
        mSurnames.add("Brown");
        mSurnames.add("Davies");
        mSurnames.add("Evans");
        mSurnames.add("Wilson");
        mSurnames.add("Thomas");
        mSurnames.add("Johnson");
        mSurnames.add("Roberts");
        mSurnames.add("Robinson");
        mSurnames.add("Thompson");
        mSurnames.add("Wright");
        mSurnames.add("Walker");
        mSurnames.add("White");
        mSurnames.add("Edwards");
        mSurnames.add("Hughes");
        mSurnames.add("Green");
        mSurnames.add("Hall");
        mSurnames.add("Lewis");
        mSurnames.add("Harris");
        mSurnames.add("Clarke");
        mSurnames.add("Patel");
        mSurnames.add("Jackson");
        mSubjectNames.add("chinese");
        mSubjectNames.add("english");
        mSubjectNames.add("mathematics");
        mSubjectNames.add("biology");
        mSubjectNames.add("history");
        mSubjectNames.add("chemistry");
        mSubjectNames.add("physics");
        mSubjectNames.add("politics");
        mSubjectNames.add("geography");
        mSubjectNames.add("sports");
        mSubjectNames.add("arithmetic");
        mSubjectNames.add("geometry");
        mSubjectNames.add("science");
        mSubjectNames.add("music");
    }

    private ArrayList<StudentInfo> loadStudentInfo(){
        ArrayList<StudentInfo> studentList = new ArrayList<>();
        Random random = new Random();
        for(int i=1;i<=20;i++){
            int gender = random.nextInt(2);
            String studentName = null;
            switch(gender){
                case Gender.MALE:
                    studentName = mBoysName.get(random.nextInt(mBoysName.size())) + " " + mSurnames.get(random.nextInt(mSurnames.size()));
                    break;
                case Gender.FEMALE:
                    studentName = mGirlsName.get(random.nextInt(mGirlsName.size())) + " " + mSurnames.get(random.nextInt(mSurnames.size()));
            }
            studentList.add(new StudentInfo(
                    "" + SHOW_STUDENT_ID_START_FROM + i, studentName, gender, R.drawable.ic_person));
        }
        for (StudentInfo studentInfo:studentList) {
            studentInfo.reportCards = generateStudentGrades();
        }
        return studentList;
    }
    
    private ArrayList<ReportCard> generateStudentGrades(){
        ArrayList<ReportCard> studentGrades = new ArrayList<>();
        Random random = new Random();
        for(String subjectName:mSubjectNames){
            String grade = String.valueOf ((char) (random.nextInt(5) + 'A'));
            studentGrades.add(new ReportCard(subjectName, grade, CURRENT_YEAR));
        }
        return studentGrades;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this,"i="+adapterView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ReportActivity.class);
        intent.putExtra(StudentInfo.CLASS_NAME,(StudentInfo) adapterView.getItemAtPosition(i));
        startActivity(intent);
    }
}
