package g2.model;

public class Stuff {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stuff.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stuff.Uni_id
     *
     * @mbg.generated
     */
    private Long uni_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stuff.sch_id
     *
     * @mbg.generated
     */
    private Long sch_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column stuff.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stuff
     *
     * @mbg.generated
     */
    public Stuff(Long id, Long uni_id, Long sch_id, String name) {
        this.id = id;
        this.uni_id = uni_id;
        this.sch_id = sch_id;
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stuff
     *
     * @mbg.generated
     */
    public Stuff() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stuff.id
     *
     * @return the value of stuff.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stuff.id
     *
     * @param id the value for stuff.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stuff.Uni_id
     *
     * @return the value of stuff.Uni_id
     *
     * @mbg.generated
     */
    public Long getUni_id() {
        return uni_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stuff.Uni_id
     *
     * @param uni_id the value for stuff.Uni_id
     *
     * @mbg.generated
     */
    public void setUni_id(Long uni_id) {
        this.uni_id = uni_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stuff.sch_id
     *
     * @return the value of stuff.sch_id
     *
     * @mbg.generated
     */
    public Long getSch_id() {
        return sch_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stuff.sch_id
     *
     * @param sch_id the value for stuff.sch_id
     *
     * @mbg.generated
     */
    public void setSch_id(Long sch_id) {
        this.sch_id = sch_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column stuff.name
     *
     * @return the value of stuff.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column stuff.name
     *
     * @param name the value for stuff.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}