package it.instrumentarium.jobs.control;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2021-08-18T12:43:05.523401+02:00[Europe/Warsaw]")public class Person   {
  
  private @Valid LocalDate creationDate;
  private @Valid Long id;
  private @Valid String login;
  private @Valid String name;

  /**
   **/
  public Person creationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  

  
  @JsonProperty("creationDate")
  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

/**
   **/
  public Person id(Long id) {
    this.id = id;
    return this;
  }

  

  
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

/**
   **/
  public Person login(String login) {
    this.login = login;
    return this;
  }

  

  
  @JsonProperty("login")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

/**
   **/
  public Person name(String name) {
    this.name = name;
    return this;
  }

  

  
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(this.creationDate, person.creationDate) &&
        Objects.equals(this.id, person.id) &&
        Objects.equals(this.login, person.login) &&
        Objects.equals(this.name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationDate, id, login, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

