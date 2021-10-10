package com.example.userlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;//компонент для отображения элементов списка(вверх-вниз)
    UserAdapter userAdapter;
    //ArrayList<String> usersName = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*for (int i = 0; i < 100; i++) {
            usersName.add("User_"+i);
        }*/

        recyclerView = findViewById(R.id.recyclerView);//связыеваем с activity_main
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));//как расположить элементы на экране
        Users users = new Users();//объект класса Юсерс
        userAdapter = new UserAdapter(users.getUserList());//вложение списка пользователей в адаптер
        recyclerView.setAdapter(userAdapter);//связываем с адаптером
    }

    // Класс элемента списка
    private class UserHolder extends RecyclerView.ViewHolder{//класс отображения элементов списка
        TextView itemTextView;
        String userName;
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {//конструктор принимающий из onCreate макет раздувания и группу компонентов
            super(inflater.inflate(R.layout.single_item, viewGroup, false));//создаем макет элементов списка
            itemTextView = itemView.findViewById(R.id.itemTextView);
        }
        public void bind(String userName){//для связи с другим классом
            this.userName = userName;
            itemTextView.setText(userName);
        }
    }

    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{//методы класса позволяющие нам распологать элементы на ресайклвью
        ArrayList<User> usersName;
        public UserAdapter(ArrayList<User> usersName) {
            this.usersName = usersName;
        }

        @Override
        public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {//создает и инициализирует объект ViewHolder
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);//раздувает/создает макет
            return new UserHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {//привязка данных пользователя к Holder
            User user = usersName.get(position);//достаем из позиции и записываем
            userHolder.bind(user.getUserName()+" "+user.getUserLastname());
        }

        @Override
        public int getItemCount() {//показывает сколько элементов на экране необходимо разместить
            return usersName.size();
        }
    }
}