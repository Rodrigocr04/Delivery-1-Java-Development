public class Patron {
    private String name;
    private String id;
    private String contact;

    public Patron(String name, String id, String contact) {
        this.name = name;
        this.id = id;
        this.contact = contact;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public String getContact() { return contact; }
    public void setName(String name) { this.name = name; }
    public void setContact(String contact) { this.contact = contact; }
    
    public void displayPatron() {
        System.out.println("Name: " + name + ", ID: " + id + ", Contact: " + contact);
    }
}
