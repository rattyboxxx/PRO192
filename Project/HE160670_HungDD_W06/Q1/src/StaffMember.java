public abstract class StaffMember {
    
    private String name;
    private String address;
    private String phone;

    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    public String display() {
      String result = "Name: " + name + "\n";
      result += "Address: " + address + "\n";
      result += "Phone: " + phone;
      return result;
   }
   
   public abstract double pay();

}
