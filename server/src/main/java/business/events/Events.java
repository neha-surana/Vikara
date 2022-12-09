package business.events;

public class Events {

    private String title;
    private String address;
    private String date;
    private String thumbnail;


    public Events(String title, String address, String date, String thumbnail) {
        this.title = title;
        this.address = address;
        this.date = date;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Events{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                ", thumbnail=" + thumbnail + '\'' +
                '}';
    }
}
