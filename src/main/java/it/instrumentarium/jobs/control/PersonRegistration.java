package it.instrumentarium.jobs.control;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2021-08-18T14:44:14.558635+02:00[Europe/Warsaw]")public class PersonRegistration   {
  
  private @Valid @NotNull String login;
  private @Valid @NotNull String name;
  private @Valid @NotNull String password;

  /**
   **/
  public PersonRegistration login(String login) {
    this.login = login;
    return this;
  }

  

  
  @JsonProperty("login")
  @NotNull
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

/**
   **/
  public PersonRegistration name(String name) {
    this.name = name;
    return this;
  }

  

  
  @JsonProperty("name")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

/**
   **/
  public PersonRegistration password(String password) {
    this.password = password;
    return this;
  }

  

  
  @JsonProperty("password")
  @NotNull
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonRegistration personRegistration = (PersonRegistration) o;
    return Objects.equals(this.login, personRegistration.login) &&
        Objects.equals(this.name, personRegistration.name) &&
        Objects.equals(this.password, personRegistration.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(login, name, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonRegistration {\n");
    
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

