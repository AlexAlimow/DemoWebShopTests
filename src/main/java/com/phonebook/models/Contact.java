package com.phonebook.models;

public class Contact {
    private String name;
    private String lastName;
    private String description;
    private String phone;
    private String email;
    private String address;

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact setDescription(String description) {
        this.description = description;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }



    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("Contact{name='%s', phone='%s'}", name, phone);
    }
}


