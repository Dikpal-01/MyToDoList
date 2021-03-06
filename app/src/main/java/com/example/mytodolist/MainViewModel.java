package com.example.mytodolist;

import android.app.Application;
import android.view.View;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytodolist.database.AppDatabase;
import com.example.mytodolist.database.Repository;
import com.example.mytodolist.database.TaskEntry;

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
