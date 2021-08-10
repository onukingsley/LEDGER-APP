package sample.CustomerData;

public class AdminData {
    private int id;
    private String Name;
    private String username;
    private String email;
    private String mobileNo;
    private String datereg;

    public AdminData(int id, String name, String username, String email, String mobileNo, String datereg) {
        this.id = id;
        Name = name;
        this.username = username;
        this.email = email;
        this.mobileNo = mobileNo;
        this.datereg = datereg;
    }
    public AdminData(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getDatereg() {
        return datereg;
    }

    public void setDatereg(String datereg) {
        this.datereg = datereg;
    }
}
