package lnmiit.android.app.model;

public class ContactDetails {
    private String title, name , email , phone , url ;


    /* Constructor */
    public ContactDetails(String name , String title , String url , String email , String phone){
        this.name = name;
        this.title = title;
        this.url = url ;
        this.email = email ;
        this.phone = phone ;
    }

    /*Getters
     */
    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    public String getUrl() {
        return url;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }
}