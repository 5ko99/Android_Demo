package fragment;

import com.example.aoc.navigationdemo.R;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class stepThreeFragment extends Fragment {
    public static final String TEXT = "text";
    public static final String STEP_NUMBER = "number";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_step_3, container, false);
        Bundle args = getArguments();

        TextView textView = (TextView) rootView.findViewById(R.id.textView);
        textView.setText(args.getString(TEXT));

        return rootView;
    }
}