package kuma.project.udacity.reportcard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ReportAdapter extends ArrayAdapter<ReportCard> {
    public ReportAdapter(@NonNull Context context, @NonNull ArrayList<ReportCard> reportCards) {
        super(context, 0, reportCards);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_item, parent, false);
        }
        TextView tvSubjectName = (TextView) convertView.findViewById(R.id.report_subject);
        TextView tvGrade = (TextView) convertView.findViewById(R.id.report_grade);
        TextView tvYear = (TextView) convertView.findViewById(R.id.report_year);
        ReportCard reportCard = getItem(position);
        tvSubjectName.setText(reportCard.getSubjectName());
        tvGrade.setText(reportCard.getGrade());
        tvYear.setText("" + reportCard.getYear());
        return convertView;
    }
}
