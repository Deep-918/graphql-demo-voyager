package com.voyager.demo.customerdatacache;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class Customer implements Serializable {
    @Id
    @GraphQLQuery(name = "customer_id", description = "Customer's id")
    private Long customer_id;
    @GraphQLQuery(name = "firstName", description = "Customer's name")
    private @NonNull String firstName;
    @GraphQLQuery(name = "lastName", description = "Customer's citizenship")
    private @NonNull String lastName;
    @GraphQLQuery(name="gender",description = "Customer's gender")
    private @NonNull String gender;
    @GraphQLQuery(name = "dob", description = "Customer's date of birth")
    private @NonNull String dob;
    @GraphQLQuery(name="nationality",description="Customer's nationality")
    private @NonNull String nationality;
    @GraphQLQuery(name="passport_number",description="Customer's passport_number")
    private @NonNull String  passport_number;
    @GraphQLQuery(name="number_of_dependents",description="Customer's of dependents")
    private @NonNull String number_of_dependents;
    @GraphQLQuery(name="marital_status",description="Customer's marital status")
    private @NonNull String marital_status;

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public void setNumber_of_dependents(String number_of_dependents) {
        this.number_of_dependents = number_of_dependents;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public Long getCustomer_id() {
        return this.customer_id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getGender() {
        return this.gender;
    }

    public String getDob() {
        return this.dob;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getPassport_number() {
        return this.passport_number;
    }

    public String getNumber_of_dependents() {
        return this.number_of_dependents;
    }

    public String getMarital_status() {
        return this.marital_status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", nationality='" + nationality + '\'' +
                ", passport_number='" + passport_number + '\'' +
                ", number_of_dependents='" + number_of_dependents + '\'' +
                ", marital_status='" + marital_status + '\'' +
                '}';
    }
}
