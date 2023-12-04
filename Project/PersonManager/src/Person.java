
public class Person {
    private String code;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String code, String name, int age) {
        this.code = code;
        this.name = name;
        this.age = age;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public String toString() {
        return code + "\t" + name + "\t" + age;
    }
}
