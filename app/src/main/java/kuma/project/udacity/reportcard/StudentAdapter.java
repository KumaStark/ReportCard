package kuma.project.udacity.reportcard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<StudentInfo> {
    public StudentAdapter(@NonNull Context context, @NonNull ArrayList<StudentInfo> studentList) {
        super(context, 0, studentList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        StudentInfo studentInfo = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        return setStudentInfo(convertView,studentInfo);
    }

    protected static View setStudentInfo(View convertView, StudentInfo studentInfo){
        TextView tvStudentId = (TextView) convertView.findViewById(R.id.student_id);
        TextView tvStudentName = (TextView) convertView.findViewById(R.id.student_name);
        ImageView ivStudentGender = (ImageView) convertView.findViewById(R.id.student_gender);
        ImageView ivStudentPhoto = (ImageView) convertView.findViewById(R.id.student_photo);
        tvStudentId.setText(studentInfo.getId());//TODO Figure out why getId() may cause NullPointerException
        tvStudentName.setText(studentInfo.getName());
        if(studentInfo.getGender() == Gender.MALE){
            ivStudentGender.setImageResource(R.drawable.ic_male);
        }else{
            ivStudentGender.setImageResource(R.drawable.ic_female);
        }
        ivStudentPhoto.setImageResource(studentInfo.getPhotoResId());
        return convertView;
    }
}
