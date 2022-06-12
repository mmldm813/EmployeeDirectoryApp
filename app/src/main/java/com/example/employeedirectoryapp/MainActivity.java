package com.example.employeedirectoryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.employeedirectoryapp.employee.domain.EmployeeUseCase;
import com.example.employeedirectoryapp.employee.domain.model.Employee;
import com.example.employeedirectoryapp.employee.domain.model.EmployeeList;
import com.example.employeedirectoryapp.employee.ui.Adapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String EMPLOYEE_KEY = "employee_key";

    private Adapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView errorView;
    private TextView emptyList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<Employee> employeeList = new ArrayList<>();
    private EmployeeUseCase employeeUseCase = new EmployeeUseCase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();

        if (savedInstanceState != null) {
            employeeList = savedInstanceState.getParcelableArrayList(EMPLOYEE_KEY);
            progressBar.setVisibility(View.GONE);
        }
        adapter = new Adapter(this, employeeList);
        setupEmployeeList();

        setSwipeRefreshLayout();

        if (savedInstanceState == null) {
            fetchEmployeeList();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList(EMPLOYEE_KEY, (ArrayList<? extends Parcelable>) employeeList);
        super.onSaveInstanceState(outState);
    }

    private void setupViews() {
        progressBar = findViewById(R.id.spinner);
        errorView = findViewById(R.id.error);
        emptyList = findViewById(R.id.empty_list);
        recyclerView = findViewById(R.id.recycler_view);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
    }

    private void setupEmployeeList() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void fetchEmployeeList() {
        employeeUseCase.getEmployeeList(new Callback<EmployeeList>() {
            @Override
            public void onResponse(@NonNull Call<EmployeeList> call, @NonNull Response<EmployeeList> response) {
                progressBar.setVisibility(View.GONE);
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }

                try {
                    List<Employee> employees = response.body().getEmployees();
                    if (employeeUseCase.checkIfEmployeeListEmpty(employees)) {
                        recyclerView.setVisibility(View.GONE);
                        emptyList.setVisibility(View.VISIBLE);
                    } else if (!employeeUseCase.validateEmployeeList(employees)) {
                        recyclerView.setVisibility(View.GONE);
                        errorView.setVisibility(View.VISIBLE);
                    } else {
                        employeeList.clear();
                        employeeList.addAll(response.body().getEmployees());
                        adapter.notifyDataSetChanged();
                    }
                } catch (NullPointerException e) {
                    recyclerView.setVisibility(View.GONE);
                    errorView.setVisibility(View.VISIBLE);
                    System.out.println("List returned null: " + e);
                }
            }

            @Override
            public void onFailure(@NonNull Call<EmployeeList> call, @NonNull Throwable t) {
                progressBar.setVisibility(View.GONE);
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                recyclerView.setVisibility(View.GONE);
                errorView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void setSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener(this::fetchEmployeeList);
    }
}