package com.example.wirtualnytrener;


import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WorkoutDetailFragment extends Fragment {
    private long workoutId;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            workoutId = savedInstanceState.getLong("workoutId");
        }
        if(savedInstanceState == null){
            StopwatchFragment stopWatch = new StopwatchFragment();
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.add(R.id.main, stopWatch);
            ft.addToBackStack(null);
            ft.commit();
        }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putLong("workoutId", workoutId);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view != null){
            TextView title = view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int)workoutId];
            title.setText(workout.getName());
            TextView description = view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }






    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }
}
