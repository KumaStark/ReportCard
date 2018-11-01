package kuma.project.udacity.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        StudentInfo studentInfo = (StudentInfo) getIntent().getSerializableExtra(StudentInfo.CLASS_NAME);
        View infoPad = findViewById(R.id.include);
        StudentAdapter.setStudentInfo(infoPad,studentInfo);
        ReportAdapter reportAdapter = new ReportAdapter(this,studentInfo.reportCards);
        GridView reportGridView = this.findViewById(R.id.report_list);
        reportGridView.setAdapter(reportAdapter);
    }

    @Override
    public void finish() {
        super.finish();
    }
}
