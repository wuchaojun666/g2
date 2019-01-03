package g2.model;

public class User extends UserKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbg.generated
     */
    public User(String id, String type, String cid, String name, String password) {
        super(id, type, cid);
        this.name = name;
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbg.generated
     */
    public User() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User.name
     *
     * @return the value of User.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User.name
     *
     * @param name the value for User.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User.password
     *
     * @return the value of User.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User.password
     *
     * @param password the value for User.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}