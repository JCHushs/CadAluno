package com.example.cadalunos.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity(tableName = "User")
    public class User {
        @PrimaryKey(autoGenerate = true)
        private int id;
        private String name;
        private String username;
        private String email;
        private String password;
        public User(String name, String username, String email, String password) {
            this.name = name;
            this.username = username;
            this.email = email;
            this.password = password;
        }

        public User() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

