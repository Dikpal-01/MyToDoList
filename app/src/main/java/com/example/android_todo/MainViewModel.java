package com.example.android_todo;

import android.app.Application;
import android.view.View;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.android_todo.database.AppDatabase;
import com.example.android_todo.database.Repository;
import com.example.android_todo.database.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    Repository repository;

    private  LiveData<List<TaskEntry>> tasks;



    public  MainViewModel(Application application){
        super(application);
        AppDatabase database = AppDatabase.getInstance(application);
        repository = new Repository(database);
        tasks = repository.getTasks();
    }

    public LiveData<List<TaskEntry>> getTasks(){
        return tasks;
    }

    public void deleteTask(TaskEntry task)
    {
        repository.deleteTask(task);
    }

}
