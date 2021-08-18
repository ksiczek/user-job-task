package it.instrumentarium.jobs.control;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2021-08-18T11:45:35.555634972+02:00[Europe/Warsaw]")public class JobOffer   {
  

public enum CategoryEnum {

    IT(String.valueOf("IT")), FOODDRINKS(String.valueOf("FoodDrinks")), OFFICE(String.valueOf("Office")), COURIER(String.valueOf("Courier")), SHOPASSISTANT(String.valueOf("ShopAssistant"));


    private String value;

    CategoryEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String value) {
        for (CategoryEnum b : CategoryEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

  private @Valid CategoryEnum category;
  private @Valid String employerId;
  private @Valid LocalDate endDate;
  private @Valid Long id;
  private @Valid LocalDate startDate;

  /**
   **/
  public JobOffer category(CategoryEnum category) {
    this.category = category;
    return this;
  }

  

  
  @JsonProperty("category")
  public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }

/**
   **/
  public JobOffer employerId(String employerId) {
    this.employerId = employerId;
    return this;
  }

  

  
  @JsonProperty("employerId")
  public String getEmployerId() {
    return employerId;
  }

  public void setEmployerId(String employerId) {
    this.employerId = employerId;
  }

/**
   **/
  public JobOffer endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  

  
  @JsonProperty("endDate")
  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

/**
   **/
  public JobOffer id(Long id) {
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
  public JobOffer startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  

  
  @JsonProperty("startDate")
  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobOffer jobOffer = (JobOffer) o;
    return Objects.equals(this.category, jobOffer.category) &&
        Objects.equals(this.employerId, jobOffer.employerId) &&
        Objects.equals(this.endDate, jobOffer.endDate) &&
        Objects.equals(this.id, jobOffer.id) &&
        Objects.equals(this.startDate, jobOffer.startDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, employerId, endDate, id, startDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobOffer {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    employerId: ").append(toIndentedString(employerId)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
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

