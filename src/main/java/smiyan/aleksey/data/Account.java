package smiyan.aleksey.data;

public class Account {

    private String phone;
    private String email;
    private String password;
    private String fullName;

    public Account setPhone(String val) {
        this.phone = val;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Account setEmail(String val) {
        this.email = val;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Account setPassword(String val) {
        this.password = val;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setFullName(String val) {
        this.fullName = val;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
