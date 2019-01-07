package g2.model;

import java.util.Date;

public class Schedule {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule.begin
     *
     * @mbg.generated
     */
    private Date begin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule.end
     *
     * @mbg.generated
     */
    private Date end;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated
     */
    public Schedule(Long id, Date begin, Date end, String address) {
        this.id = id;
        this.begin = begin;
        this.end = end;
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated
     */
    public Schedule() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule.id
     *
     * @return the value of schedule.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule.id
     *
     * @param id the value for schedule.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule.begin
     *
     * @return the value of schedule.begin
     *
     * @mbg.generated
     */
    public Date getBegin() {
        return begin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule.begin
     *
     * @param begin the value for schedule.begin
     *
     * @mbg.generated
     */
    public void setBegin(Date begin) {
        this.begin = begin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule.end
     *
     * @return the value of schedule.end
     *
     * @mbg.generated
     */
    public Date getEnd() {
        return end;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule.end
     *
     * @param end the value for schedule.end
     *
     * @mbg.generated
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule.address
     *
     * @return the value of schedule.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule.address
     *
     * @param address the value for schedule.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}